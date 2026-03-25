plugins {
    java
    id("org.springframework.boot") version "3.4.2"
    id("io.spring.dependency-management") version "1.1.7"
    id("org.sonarqube") version "7.1.0.6387"
}

group = "com.vantagepoint"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

// --- 1. DECLARACIÓN DE VERSIONES ---
// Ponemos esto justo antes de las dependencias.
// Es la forma correcta en Kotlin DSL para evitar el "hardcoding".
val mapstructVersion = "1.5.5.Final"
val lombokMapstructBindingVersion = "0.2.0"
val jjwtVersion = "0.12.5"
val archunitVersion = "1.2.1"

dependencies {
    // --- 2. IMPLEMENTATION (Lógica principal) ---
    // Agrupamos todos los 'implementation' juntos para cumplir con el "Group by destination"
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.flywaydb:flyway-core")
    implementation("org.flywaydb:flyway-database-postgresql")
    implementation("org.mapstruct:mapstruct:$mapstructVersion")
    implementation("io.jsonwebtoken:jjwt-api:$jjwtVersion")

    // --- 3. ANNOTATION PROCESSORS & COMPILE ONLY ---
    // Agrupamos las herramientas de generación de código
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    annotationProcessor("org.mapstruct:mapstruct-processor:$mapstructVersion")
    annotationProcessor("org.projectlombok:lombok-mapstruct-binding:$lombokMapstructBindingVersion")

    // --- 4. RUNTIME ONLY ---
    // Dependencias necesarias solo cuando la app está corriendo
    runtimeOnly("org.postgresql:postgresql")
    runtimeOnly("io.jsonwebtoken:jjwt-impl:$jjwtVersion")
    runtimeOnly("io.jsonwebtoken:jjwt-jackson:$jjwtVersion")

    // --- 5. TEST (Entorno de pruebas) ---
    // Agrupamos todas las dependencias de testing
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")
    testImplementation("com.tngtech.archunit:archunit-junit5:$archunitVersion")
    testImplementation("com.h2database:h2")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
    useJUnitPlatform()
}