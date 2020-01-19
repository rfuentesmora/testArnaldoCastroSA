package com.marvel.demo.manager;

import com.marvel.demo.dto.CharacterDataWrapper;
import com.marvel.demo.exceptions.ForbiddenException;
import com.marvel.demo.exceptions.InvalidException;
import com.marvel.demo.exceptions.MissingException;
import com.marvel.demo.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

@Repository
public class CharacterManager {
    @Value("${marvel.url}")
    private String marvelUrl;
    @Value("${marvel.public.key}")
    private String publicKey;
    @Value("${marvel.private.key}")
    private String privateKey;
    private RestTemplate restTemplate = new RestTemplate();
    public CharacterDataWrapper getCharacters(Long id) throws Exception {
        Long time = new Date().getTime();
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Type","application/json;charset=utf-8");
            ResponseEntity<CharacterDataWrapper> responseObj = restTemplate.exchange(marvelUrl+"characters/"+id+"?ts="+time+"&apikey="+publicKey+"&hash="+getHash(time.toString(),privateKey,publicKey),HttpMethod.GET, new HttpEntity<Object>(headers),
                    CharacterDataWrapper.class);
            return responseObj.getBody();
        }
        catch (HttpClientErrorException ex){
            switch (ex.getRawStatusCode()){
                case 404:
                    throw new NotFoundException("El caracter no ha sido encontrado");
                case 401:
                    throw new InvalidException("El hash es inválido");
                case 409:
                    throw new MissingException("Not found");
                case 403:
                    throw new ForbiddenException("Not access to endpoint");
                default:
                    throw new Exception("Error al establecer comunicación con el servidor");

            }
        }
        catch (ResourceAccessException ex){
            throw new ResourceAccessException("No se ha podido acceder a los servicios de marvel");
        }
        catch (Exception ex){
            throw new Exception(ex.getMessage());
        }



    }
    private String getHash(String ts,String privateKey,String publicKey)throws NoSuchAlgorithmException {
        String data = ts.concat(privateKey).concat(publicKey);
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(data.getBytes());
        byte[] digest = md.digest();
        BigInteger bigInt = new BigInteger(1,digest);
        return bigInt.toString(16);
    }


}
