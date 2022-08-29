# Aplicación de examen Spring Boot API CRUD Mercadona

## Sobre
El siguiente repositorio contiene una aplicación API Spring Boot que actúa como un servicio para monitorear productos con operaciones CRUD.

## Descarga la aplicación:
### con Docker:
```
docker pull truricprd/mercadona:version2
```
### con Git:
```
git init
git pull https://github.com/truric/mercadona-exam.git
```
### no Git no Docker:
```
https://github.com/truric/mercadona-exam/archive/refs/heads/main.zip
```

## Ejecute la aplicación sin Docker:
* Crear una base de datos PostgreSQL con nombre: mercadona
* Configure la configuración de su navegador de base de datos para que se vea así, donde la contraseña es "wm", como se ve en application.properties:
image: "img.png"
* Ejecute todas las pruebas a la vez para llenar la base de datos con registros de tablas y productos

* Ahora puede ejecutar la aplicación

## API endpoints:
* Usando una plataforma API como Postman o Insomnia, puede probar los siguientes endpoints:


* Obtener todos los productos:
```
GET http://localhost:8080/api/v1/productos
```
* Publicar un nuevo producto:
```
POST http://localhost:8080/api/v1/productos

agregue cuerpo Json para crear un nuevo producto, ejemplo:

{
"nombre": "nombre del producto",
"precio": 99,00,
"cantidad": 50,
"peso": 1.0,
"formatopeso": "kg",
"miniatura": "www.mercadona.es/product-name/thumbnail/123"
}
```
* Actualizar producto existente:
```
PUT http://localhost:8080/api/v1/products/2

agregue cuerpo Json para agregar cambios a un producto existente, ejemplo:

{
"name": "cambiar el nombre del producto existente",
"precio": 89,00,
"cantidad": 49,
"peso": 2.0,
"formato de peso": "l",
"miniatura": "www.mercadona.es/product-name/thumbnail/101"
}
```
* Eliminar producto existente:
```
DELETE http://localhost:8080/api/v1/products/2
```

### Sobre
* Para hacer que las solicitudes de respuesta sean fáciles de usar, en lugar de usar un enfoque condicional o rodear cada solicitud con una captura de intento, he usado Java Beans Validator, que agrega reglas a las propiedades y devuelve mensajes de error al usuario.
* Para ayudar en este sentido, he creado ValidationConstraintHandler, que intercepta excepciones, para que podamos personalizar los mensajes de error. También formatea la solicitud de respuesta sobre errores con sello de tiempo, código de estado y un mensaje personalizado del Controlador
* En el controlador, los mensajes de error personalizados se envían con la ayuda de ResourceNotFoundException y los mensajes exitosos se envían con el cuerpo de ResponseEntity.
* Utilicé un enfoque BDD, mientras que todo se probó y cada prueba debe pasar primero para pasar al siguiente paso.

## Docker

### Extraer nueva imagen de Docker:
* ejecuta Docker en tu máquina
* entrar en la ruta de la aplicación
```
ejemplo:
cd Desktop/producto-CRUD-API
```
* crear una imagen Docker:
```
docker build -t docker-image-name-here.
```

### Algunos comandos de Docker:
* ejecutar la aplicación como un contenedor
```
docker run -p 8080:8080 docker-image-name-aquí
```
* o ejecutarlo como detached mode
```
docker run -dp 80:8080 docker-image-name-aquí
```
* ingrese al contenedor en ejecución
```
docker exec -it app-name-here /bin/bash

### Empuje esta imagen a su Docker Hub
* inicie sesión en Docker Hub para enviar esta imagen
```
login -u nombre-de-usuario-docker-aquí
```
* verifique las imágenes de la ventana acoplable para verificar el nombre correcto
```
docker images
```
* use la etiqueta de comando para nombrar la imagen, el nombre de salida debe tener esta sintaxis: docker-user-name/new-image-name:version-number, el número de versión es opcional
```
docker tag docker-image-name-here docker-user-name/new-iname-name:version1
```
* empuja la imagen a tu Docker Hub
```
docker push docker-user-name/new-iname-name:version1
```
