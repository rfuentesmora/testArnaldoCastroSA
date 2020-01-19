package com.marvel.demo.services;

import com.marvel.demo.dto.ErrorMessage;
import com.marvel.demo.exceptions.*;
import com.marvel.demo.manager.CharacterManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CharacterService {
    @Autowired
    private CharacterManager characterManager;

    @GetMapping("/character/{id}")
    public ResponseEntity character(@PathVariable String id) {

        try {
            return new ResponseEntity<>(characterManager.getCharacters(Long.valueOf(id)), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(new ErrorMessage(404,e.getMessage()), HttpStatus.BAD_REQUEST);
        }catch (InvalidException e) {
            return new ResponseEntity<>(new ErrorMessage(401,e.getMessage()), HttpStatus.BAD_GATEWAY);
        }catch (MissingException e) {
            return new ResponseEntity<>(new ErrorMessage(409,e.getMessage()), HttpStatus.BAD_GATEWAY);
        }catch (ForbiddenException e) {
            return new ResponseEntity<>(new ErrorMessage(403,e.getMessage()), HttpStatus.BAD_GATEWAY);
        }catch (ResourceAccessException e) {
            return new ResponseEntity<>(new ErrorMessage(600,e.getMessage()), HttpStatus.BAD_GATEWAY);
        }
        catch (NumberFormatException ex){
            return new ResponseEntity<>(new ErrorMessage(500,"El identificador del caracter debe ser un numero"), HttpStatus.BAD_GATEWAY);
        }
        catch (Exception e) {
            return new ResponseEntity<>(new ErrorMessage(500,e.getMessage()), HttpStatus.BAD_GATEWAY);
        }
    }

}
