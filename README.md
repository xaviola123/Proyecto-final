# Agencia de Viajes

Este repositorio contiene una agencia de viajes que integra tres entidades principales: `Vuelo`, `Hotel` y `Reserva`. Estas entidades interactúan entre sí y utilizan una base de datos SQL y funcionalidades API REST.

## Características Principales
- Conexión a base de datos
- Métodos CRUD para `Vuelo`, `Hotel` y `Reserva`
- Endpoints para interactuar con las entidades

## Entidades
1. **Vuelo**: Representa un vuelo.
2. **Hotel**: Representa un hotel.
3. **Reserva**: Representa reservas que interactúan con vuelos y hoteles.

## Servicios

### Servicio Vuelo
A partir de la tabla `vuelos` en la base de datos `agencia`, se crean recursos.

### Servicio Hotel
A partir de la tabla `hoteles` en la base de datos `agencia`, se crean recursos.

### Servicio Reserva
A partir de la tabla `reservas` en la base de datos `agencia`, se crean recursos.

## Funcionalidades de Hotel

### Métodos CRUD
- **Create**: Crea un nuevo hotel.
- **Read**: Obtiene la lista de hoteles.
- **Update**: Actualiza un hotel a partir de un JSON en el body.
- **Delete**: Elimina un hotel.

### Otros Métodos
- Obtiene un hotel por nombre.

### Endpoints
1. **Listar todos los hoteles**
   - **URL**: `/hoteles`
   - **Método**: `GET`

2. **Listar hoteles por nombre**
   - **URL**: `/hoteles/{nombre}`
   - **Método**: `GET`

3. **Agregar un hotel**
   - **URL**: `/hoteles`
   - **Método**: `POST`

4. **Borrar un hotel por ID**
   - **URL**: `/hoteles/{idHotel}`
   - **Método**: `DELETE`

5. **Actualizar un hotel**
   - **URL**: `/hoteles`
   - **Método**: `PUT`

## Funcionalidades de Vuelo

### Métodos CRUD
- **Create**: Crea un nuevo vuelo.
- **Read**: Obtiene la lista de vuelos.
- **Update**: Actualiza un vuelo a partir de un JSON en el body.
- **Delete**: Elimina un vuelo.

### Otros Métodos
- Busca vuelos disponibles según el número de plazas a reservar.

### Endpoints
1. **Listar todos los vuelos**
   - **URL**: `/vuelos`
   - **Método**: `GET`

2. **Buscar vuelos disponibles por número de plazas**
   - **URL**: `/vuelos/{totalPlazasReservar}`
   - **Método**: `GET`

3. **Agregar un vuelo**
   - **URL**: `/vuelos`
   - **Método**: `POST`

4. **Actualizar las plazas de un vuelo**
   - **URL**: `/vuelos/{idVuelo}/{plazasReservadas}`
   - **Método**: `PUT`

5. **Eliminar un vuelo por ID**
   - **URL**: `/vuelos/{idVuelo}`
   - **Método**: `DELETE`

## Funcionalidades de Reserva

### Métodos CRUD
- **Create**: Crea una nueva reserva.
- **Read**: Obtiene la lista de reservas.
- **Update**: Actualiza una reserva a partir de un JSON en el body.
- **Delete**: Elimina una reserva.

### Otros Métodos
- Obtiene la lista de todas las reservas por nombre de hotel.
- Actualiza las plazas del vuelo según la reserva pasada por body.

### Endpoints
1. **Agregar una reserva**
   - **URL**: `/reservas`
   - **Método**: `POST`

2. **Obtener la lista de todas las reservas**
   - **URL**: `/reservas`
   - **Método**: `GET`

3. **Obtener reservas por nombre de hotel**
   - **URL**: `/reservas/{nombreHotel}`
   - **Método**: `GET`

4. **Obtener una reserva por ID de reserva**
   - **URL**: `/reservas/{id}`
   - **Método**: `GET`

5. **Eliminar una reserva por ID**
   - **URL**: `/reservas/{id}`
   - **Método**: `DELETE`

6. **Actualizar el número de plazas de vuelo a partir de una reserva**
   - **URL**: `/reservas`
   - **Método**: `PUT`

## Documentación Swagger

- [Hotel](http://localhost:8080/swagger-ui/index.html)
- [Vuelos](http://localhost:8081/swagger-ui/index.html)
- [Reserva](http://localhost:8082/swagger-ui/index.html)
