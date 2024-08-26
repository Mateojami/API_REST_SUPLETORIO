# ApiSupletorio - Gestión de Tareas

## Descripción

ApiSupletorio es una API REST desarrollada con Spring Boot para la gestión de tareas. Permite crear, listar, actualizar y eliminar tareas, además de filtrarlas por su estado. El proyecto hace uso de programación funcional mediante Java Streams para realizar operaciones sobre colecciones de datos, además de
usar conceptos como inversión de control, inyección de dependencias y persistencia.

## Características

- **CRUD de Tareas**: Crear, leer, actualizar y eliminar tareas.
- **Filtrado por Estado**: Filtra las tareas por estado (pendiente o completado) usando un endpoint.
- **Programación Funcional**: Implementación de Streams para operaciones eficientes sobre datos.

## Tecnologías

- **Java 21**
- **Spring Boot**
- **Maven**
- **Mysql** 
- **Postman** (para pruebas)

## Nota

Para que se ejecute correctamente el programa se debe ejecutar específicamente la carpeta "ApiSupletorio" en nuestro IDE.

# Uso

## 1. Crear una Tarea

**Método:** `POST`

**URL:** `http://localhost:8080/tareas`

## Configurar el cuerpo de la solicitud

Ve a la pestaña Body en Postman.

Selecciona la opción raw y el tipo JSON.

Ingresa un JSON con los datos de la tarea que deseas crear. Por ejemplo:


```json
{
    "titulo": "Nueva Tarea",
    "descripcion": "Descripción de la tarea",
    "estado": "pendiente"
}
```
## Enviar la solicitud

Haga click en el botón Send.

## 2. Actualizar una Tarea

**Método:** `PUT`

**URL:** `http://localhost:8080/tareas/{id}`

Reemplaza {id} con el id de la tarea que deseas modificar. Por ejemplo, si quieres modificar la tarea con id 1, la URL sería: http://localhost:8080/tareas/1.

## Configurar el cuerpo de la solicitud

Ve a la pestaña Body en Postman.

Selecciona la opción raw y el tipo JSON.

Ingresa un JSON con los datos de la tarea que deseas modificar. Por ejemplo:


```json
{
    "titulo": "Mi primera tarea actualizada",
    "descripcion": "Esta es la descripción actualizada de mi primera tarea",
    "estado": "completado"
}
```
## Enviar la solicitud

Haga click en el botón Send.

## 3. Eliminar una Tarea

**Método:** `DELETE`

**URL:** `http://localhost:8080/tareas/{id}`

Reemplaza {id} con el id de la tarea que deseas eliminar. Por ejemplo, si quieres eliminar la tarea con id 1, la URL sería: http://localhost:8080/tareas/1.

## Enviar la solicitud

Haga click en el botón Send.

## 4. Listar una Tarea

**Método:** `GET`

**URL:** `http://localhost:8080/tareas`

## Enviar la solicitud

Haga click en el botón Send.

## 4. Listar una Tarea por su estado

**Método:** `GET`

**URL:** `http://localhost:8080/tareas/estado/{estado}`

Parámetro de URL: {estado} puede ser pendiente o completado.

Ejemplo: Obtener tareas con estado "pendiente":

GET http://localhost:8080/tareas/estado/pendiente

## Enviar la solicitud

Haga click en el botón Send.
