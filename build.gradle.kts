import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    // Versions optimized for Java 21 compatibility
    id("org.springframework.boot") version "3.2.4" apply false
    id("io.spring.dependency-management") version "1.1.4"
    kotlin("jvm") version "1.9.23"
    kotlin("plugin.spring") version "1.9.23" apply false
}

allprojects {
    group = "com.company.microservices"
    version = "1.0.0-SNAPSHOT"

    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")

    // Explicitly target Java 21
    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(21))
        }
    }

    dependencies {
        // Kotlin standard libraries
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

        // Microservice Foundations
        implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")
        implementation("org.springframework.cloud:spring-cloud-starter-config")
        implementation("org.springframework.boot:spring-boot-starter-actuator")

        // Resilience (Required for Circuit Breakers)
        implementation("io.github.resilience4j:resilience4j-spring-boot3")

        testImplementation("org.springframework.boot:spring-boot-starter-test")

        implementation("org.springframework.boot:spring-boot-starter-aop")
        implementation("io.github.resilience4j:resilience4j-spring-boot3")
    }

    dependencyManagement {
        imports {
            // Spring Cloud 2023.0.x is the first major version supporting Java 21 officially
            mavenBom("org.springframework.cloud:spring-cloud-dependencies:2023.0.0")
        }
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs += "-Xjsr305=strict"
            jvmTarget = "21" // Match JVM target
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }

    // Standard for Company Projects: Create a 'clean' fat-jar
    tasks.getByName<Jar>("jar") {
        enabled = false
    }
}