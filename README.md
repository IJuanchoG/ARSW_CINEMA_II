# Cinema Book System

Este laboratorio tiene como fin presentar la estructura de una correcta implementación en injección de dependencias por medio de un servicio SpringBoot.
En el ejercicio se presenta la estructura de un servicio de Cinema, donde se dan las opciones vista en este, lo que se busca es guiar a los estudiantes para que entiendan como usar SpringBoot Adecuadamente.

## Compile and run instructions

Para compilar y ejecutar pruebas del proyecto:
```
mvn package
```
Para ejecutar el proyecto:
```
mvn exec:java -Dexec.mainClass="edu.eci.arsw.cinema.ui.CinemaUI"
```



## Part I 

Como se puede ver, se hace la implementación de los diferentes servicios, como ejemplo tenemos el servicio de pago, el cual es implementado en **InMemoryCinemaPersistence**
![1](https://media.discordapp.net/attachments/712443158797221889/750571696746004520/unknown.png?width=1443&height=481)



Para hacer la implementación de los servicios propuestos por SpringBoot, se usan las etiquetas tales como ```@Autowired``` o ```@Services```.

![1](https://media.discordapp.net/attachments/712443158797221889/750573387956355123/unknown.png)


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
* **Davor Javier Cortes** - *Initial work* - [D4vor](https://github.com/D4v0r)


## License

Este proyecto es de libre uso y distribución, para más detalles vea el archivo [LICENSE.md](LICENSE.md).
