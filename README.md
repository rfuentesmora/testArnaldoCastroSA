# testArnaldoCastroSA
Aplicación Web que consulta el API de Marvel.

Despliegue de la aplicación
1-Clonar el proyecto de GITHUB

2-Descomprimir el proyecto en un directorio de su PC.

3-Abrir una terminal de comandosy dirigirse a la carpeta raíz del proyecto y ejecutar mvn install -Dmaven.test.skip=true

4-Ejecutar mvn spring-boot:run

5-Abrir el navegador web en http://localhost:9093/ 



Requisitos del Sistema

Java Runtime Environment (plataforma Java) es el principal componente de software para que el marco funcione. Como esta aplicación no solo se ejecuta, sino que también se emplea para el desarrollo con Java, necesitas al menos la versión 8 (o 1.8) del llamado Java Development Kit (JDK). 
Este software, además del entorno de ejecución, contiene herramientas útiles para programar y testar aplicaciones Java y está disponible tanto para Linux como para Windows y macOS, por lo que permite elegir libremente el sistema operativo que queramos utilizar.

Obviamente, este complemento también requiere que tengamos la versión actual del framework Spring instalada en el sistema.

Como herramienta de compilación, utilizar Maven (a partir de 3.3).

Cabe la posibilidad de incorporar un objeto servlet que ejecute la aplicación Java sobre la base de un servidor web. Para hacerlo, puedes elegir Apache Tomcat (a partir de 9.0).
