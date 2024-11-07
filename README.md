# PruebaMifel
Api protegida con spring security y JWT

Tecnologías utilizadas para crear la API: 
Java 11,
Spring-Boot versión 2.7.18,
Spring-Security,
JWT,
Lombok,
H2,
JPA,
Maven,
Postman: como cliente,
IDE usado: Inteliji IDEA.

Para utilizar la AP,I descargar o clonar el proyecto de este repositorio, correr el proeycto en el IDE de su preferencia (Aunque para este proyecto fue utilizado inteliji IDEA)

Posterirormente acceder a la consola de administración de H2DB medinate la siguiente URL (En local): http://localhost:8080/h2-console

La configuración de la base está en el archivo aplication.properties, el usuario es: sa y no tiene contraseña, y el JDBC URL es: jdbc:h2:mem:mifeldb y está configurada solo en memoria

Ya accediendo se peuden insertar algunos datos en la tabla llamada ITEM

Posteriroemente se genera el token desde un cliente como postman haciendo un POST desde la siguiente URL: http://localhost:8080/auth/login e ingresando el siguiente JASON en el BODY:

{
  "username": "usuario",
  "password": "password"
}

Una ves ya teniendo el token que tiene duración de una hora, se puede acceder a los siguientes END POINT's para consumir sus respectivos servicios:
/**API Pokemon/
1. http://localhost:8080/api/pokemon desde postman haciendo una petición GET ingresando el token generado en el apartado Headers.

/*Catalogo ITEMS*/
2. http://localhost:8080/api/catalogo desde postman haciendo una petición GET ingresando el token generado en el apartado Headers (Esto obtendrá todos los datos)
y de la siguiente manera solo el dato requerido mediante el filtro nombre:  http://localhost:8080/api/catalogo?nombre=producto

/*Cifrar texto*/
3. http://localhost:8080/api/encryption/encrypt desde postman haciendo una petición POST ingresando el token generado en el apartado Headers y el texto a cifrar en el apartado Body, por ejemplo:
"Texto a cifrar"

Lo cual obtendría la siguiente respuesta:

{
    "cipherText": "7GmccQz5oMmSZExfTZUavQ=="
}


 Cualquier problema o duda quedo a sus ordenes.

 ATTE. ISC Elson Castillo
