# Despliegue local de la aplicación
Requisitos:
JDK 17

PostgreSQL instalado y corriendo

Maven (mvn) instalado

Archivo catalogos_mx.sql cargado en la base de datos

Importa el catálogo de datos (catalogos_mx.sql):
psql -U tu_usuario -d catalogos_mx -f catalogos_mx.sql

# Configura el archivo application.properties
Ubicado en src/main/resources/application.properties

# Configuración de la base de datos
spring.datasource.url=jdbc:postgresql://localhost:5432/catalogos_mx

spring.datasource.username=tu_usuario

spring.datasource.password=tu_password

# Configuración adicional
spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

# Dependencias principales (pom.xml)
<dependencies>

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-thymeleaf</artifactId>
    </dependency>

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>

    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
        <version>42.7.3</version>
    </dependency>

    <dependency>
        <groupId>jakarta.validation</groupId>
        <artifactId>jakarta.validation-api</artifactId>
    </dependency>

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        <scope>runtime</scope>
        <optional>true</optional>
    </dependency>

</dependencies>

# Puerto local (opcional)
server.port=8080

# Compila y ejecuta la app con Maven:

./mvnw spring-boot:run

Abre la app en tu navegador:

http://localhost:8080/
# Tecnologia Empleadas

| Componente       | Tecnología                            |
|------------------|----------------------------------------|
| Backend          | Java 17, Spring Boot, Spring Web, JPA |
| Base de Datos    | PostgreSQL                            |
| Frontend         | HTML, CSS, JavaScript (AJAX)          |
| Plantillas       | Thymeleaf                             |
| Build Tool       | Maven                                 |
