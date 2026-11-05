# Odoo Docker Creator Module Basic

Este repositorio está destinado a ofrecer un proyecto básico para la creación de un entorno de Odoo con Docker, que permita generar nuevos módulos de manera sencilla.

Este repositorio es dependiente de Docker, por lo que es necesario tener instalado este programa para poder utilizar y ejecutar el proyecto. En el [siguiente enlace](https://docs.docker.com/engine/install/ubuntu/) puedes revisar cómo realizar la instalación.

El proyecto esta subdividido en tres aplicaciones diferentes [Odoo](http://localhost:8069/), [postgresSQL](http://localhost:5432/) y [PGadmin](http://localhost:5050/) 

---

## Cómo crear los contenedores de Docker

Para levantar los servicios de Docker, utiliza el siguiente comando en la terminal de bash:

```bash
docker-compose up -d 
```
La opción -d permite que Docker se ejecute como daemon, lo cual evita que la terminal quede bloqueada.

## Cómo iniciar, parar o reiniciar el proyecto
El proyecto está formado por tres contenedores: odoo, postgres-odoo y pgadmin-odoo. Para iniciar, parar o reiniciar los contenedores, utiliza respectivamente los siguientes comandos:
```bash
docker start CONTENEDORES
docker stop CONTENEDORES
docker restart CONTENEDORES
```
## Cómo borrar los contenedores y todos los datos asociados
Para borrar los contenedores del proyecto, usa el siguiente comando:
```bash
docker rm CONTENEDOR_ID_O_NOMBRE
```
Este proceso eliminará todos los datos de imágenes, volúmenes y redes asociados a los contenedores. Para borrar estos elementos adicionales, utiliza los siguientes comandos respectivamente:
```bash
docker volume rm NOMBRE_VOLUMEN
docker rmi NOMBRE_IMAGEN
docker network rm NOMBRE_RED
```
También es posible eliminar todos los elementos no relacionados a un contenedor existente con el siguiente comando. Sin embargo, ten en cuenta que este proceso borrará todos los elementos no relacionados con ningún contenedor, lo cual puede ser contraproducente en algunas situaciones:
```bash
docker system prune
```
Finalmente, para borrar los datos propios de este proyecto, elimina el directorio odoo, ubicado en la carpeta donde descargaste inicialmente el proyecto. Ten en cuenta que, si no has realizado una copia de seguridad del contenido del directorio extra-addons, podrías perder toda la información de tus módulos específicos.
