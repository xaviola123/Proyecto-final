# Agencia Viajes
Este repositorio contiene una agencia de viajes.Integras 3 entidades `Vuelo`,`Hotel` y `Reserva`. Estas interactuan entre si y utilizan una base de datos SQL y funcionalidades API REST
## Características Principales
->Conexion a base de datos
->Metodos CRUD de `Vuelos`,`Hotel` y `Reserva`
->Contiene endpoints para interactuar con las entidades
# Entidades
1. **Vuelo**: Representa a un Vuelo
2. **Hotel**: Representa a un Hotel
3. **Reserva** Represnta Reservas que intereactuan con vuelos y hoteles
# Servicio Vuelo
  A partir de una tabla vuelos en la base de datos agencia, se crean recursos
# Servicio Hotel
A partir de una tabla hoteles en la base de datos agencia, se crean recursos
# Servicio Reserva
A partir de una tabla reservas en la base de datos agencia, se crean recursos
# Funcionalidades de Hotel
1. **MetodosCRUD** contiene los metodos create,read,update,delete,(crea un hotel nuevo,obtiene la lista de hoteles,actualiza un hotel por un JSON en el body,eliminar un hotel)
2. **OtrosMetodos**
  2.1      Obtiene un hotel por nombre
### Clientes endpoint

1. **Listar todos los Hoteles**
   - **URL**: `/hoteles`
   - **Método**: `GET`

2. **listar hoteles por nombre**
   - **URL**: `/hoteles/{nombre}`
   - **Método**: `GET`

3. **Agrega un hotel**
   - **URL**: `/hoteles`
   - **Método**: `POST`

4. **borra  un hotel por ID**
   - **URL**: `/hoteles/{idHotel}`
   - **Método**: `DELETE`

5. **Actualiza un hotel**
   - **URL**: `/hoteles`
   - **Método**: `PUT`


# Funcionalidades de Vuelo
1. **MetodosCRUD** contiene los metodos create,read,update,delete,(crea un hotel nuevo,obtiene la lista de hoteles,actualiza un hotel por un JSON en el body,eliminar un hotel)
2. **OTROS METODOS**
  2.1 Busca vuelos disponibles según el número de plazas a reservar
  2.2

### Vuelos endpoint

1. **Listar todos los vuelos**
   - **URL**: `/vuelos`
   - **Método**: `GET`

2. **Busca vuelos disponibles por num plazas**
   - **URL**: `/vuelos/{totalPlazasReservar}`
   - **Método**: `GET`

3. **Agrega un vuelo**
   - **URL**: `/vuelos`
   - **Método**: `POST`

4. **Actualiza las plazas de un Vuelo**
   - **URL**: `/vuelos/{idVuelo}/{plazasReservadas}`
   - **Método**: `PUT`

5. **Elimina un Vuelo por ID**
   - **URL**: `/vuelos/{Idvuelo}`
   - **Método**: `DELETE`
   - 
# Funcionalidades de Reserva
1. **MetodosCRUD** contiene los metodos create,read,update,delete,(crea un hotel nuevo,obtiene la lista de hoteles,actualiza un hotel por un JSON en el body,eliminar un hotel)
2. **OTROS METODOS**
  2.1 obtienes la lista de todas las reservas por nombre hotel
  2.2 actualiza las plazas del vuelo segun la reserva pasada por body

   ### Reservas endpoint
1. **Agrega una reserva**
   - **URL**: `/reservas`
   - **Método**: `POST`

2. **Obtienes la lista de todas las reservas**
   - **URL**: `/reservas`
   - **Método**: `GET`

3. **Obtiene reservas por nombre HOTEL**
   - **URL**: `/reservas/{nombreHotel}`
   - **Método**: `GET`

4. **Obtiene una reserva por Id de reserva**
   - **URL**: `/reservas/{id}`
   - **Método**: `GET`
   - 
5. **Elimina una Reserva por ID**
   - **URL**: `/reservas/{id}`
   - **Método**: `DELETE`

6. **Actualiza el num Plazas vuelo a partir de una Reserva**
   - **URL**: `/reservas`
   - **Método**: `PUT`
