# Cinema Book System II

Este laboratorio tiene como fin presentar la estructura de una correcta implementación en injección de dependencias por medio de un servicio SpringBoot.
En el ejercicio se presenta la estructura de un servicio de Cinema, donde se dan las opciones vista en este, lo que se busca es guiar a los estudiantes para que entiendan como usar SpringBoot Adecuadamente.

## Compile and run instructions

Para compilar y ejecutar pruebas del proyecto:

```
mvn package
```

Para ejecutar el proyecto:
```
mvn exec:java -Dexec.mainClass="edu.eci.arsw.cinema.CinemaAPIApplication"
```



## Part I 

Como se puede ver, se hace la implementación de los diferentes servicios, como ejemplo tenemos el servicio de pago, el cual es implementado en **InMemoryCinemaPersistence**,Para hacer la implementación de los servicios propuestos por SpringBoot, se usan las etiquetas tales como ```@Autowired``` o ```@Services```.

Como se puede ver, al solicitar los recursos en ```http://localhost:8080/cinemas```, se puede ver que nos devuelve los cines.


![image](https://user-images.githubusercontent.com/49318314/92551665-2adb9700-f224-11ea-9f13-5fd647c77be7.png)

Del mismo modo se puede filtrar por diferentes campos.

![image](https://user-images.githubusercontent.com/49318314/92552454-4fd10980-f226-11ea-9008-b16b73ba105a.png)

## Part II

Para realizar una petición POST nos dirigimos al terminal de comandos con la siguiente función (cinema.json es un archivo json con la información):

#### PARA AÑADIR UN NUEVO CINE:


```curl -i -X POST -HContent-Type:application/json -HAccept:application/json http://localhost:8080/cinemas/cinemaA -d @cinema.json```

![image](https://user-images.githubusercontent.com/49318314/92552761-fae1c300-f226-11ea-84de-1200086b3237.png)

#### PARA ACTUALIZAR EL MISMO CINE:

```curl -i -X POST -HContent-Type:application/json -HAccept:application/json http://localhost:8080/cinemas/cinemaA -d @cinemaUpdate.json```

![image](https://user-images.githubusercontent.com/49318314/92552824-21076300-f227-11ea-80f8-67ed61cb979d.png)


## Part III

La información respecto a las condiciones de carrera y secciones críticas pueden ser contempladas en el archivo de [ANALISIS_CONCURRENCIA](ANALISIS_CONCURRENCIA.txt).


### Prerequisitos.

Es necesario/recomendable que posea las siguientes herramientas:

- git instalado en su computador.
- Maven configurado en sus **Variables de Entorno**.
- Interprete de lenguaje de programacion **JAVA** (Eclipse, netbeans, Intellij, etc.)

si necesita instalar algunos de los servicios mencionados puede encontrarlos aquí:

- **Git** puede descargarlo [aqui.](https://git-scm.com/downloads)

- **Maven** puede descargarlo [aqui.](https://maven.apache.org/download.cgi)

- **IntelliJ** puede descargarlo [aqui.](https://www.jetbrains.com/es-es/idea/download/)

- **SpringBoot** puede encontrar la documentación [aqui.](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#preface)


## Built With

* [IntelliJ](https://www.jetbrains.com/es-es/idea/) - The develop enviroment
* [Maven](https://maven.apache.org/) - Dependency Management
* [JUnit](https://junit.org/junit5/) - Used to generate Unitary Test.
* [SpringBoot](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#preface)  - Used to dependency injection.


## Authors

* **Juan Carlos García** - *Initial work* - [IJuanchoG](https://github.com/IJuanchoG)


## License

Este proyecto es de libre uso y distribución, para más detalles vea el archivo [LICENSE.md](LICENSE.md).
