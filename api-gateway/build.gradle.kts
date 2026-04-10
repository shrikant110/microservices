
plugins {
    id("org.springframework.boot") // Required for bootJar
    id("io.spring.dependency-management")
    kotlin("jvm")
    kotlin("plugin.spring")
}

dependencies {
    implementation("org.springframework.cloud:spring-cloud-starter-gateway")
    implementation("spring-cloud-starter-circuitbreaker-reactor-resilience4j")
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")

    // Add these for Config Server support
    implementation("org.springframework.cloud:spring-cloud-starter-config")
    implementation("org.springframework.cloud:spring-cloud-starter-bootstrap")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    //


    // JJWT API
    implementation("io.jsonwebtoken:jjwt-api:0.11.5")

    // JJWT Implementation (needed at runtime)
    runtimeOnly("io.jsonwebtoken:jjwt-impl:0.11.5")

    // JJWT Jackson (for JSON parsing)
    runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.11.5")
}

// Ensure the main class is explicitly found
tasks.getByName<org.springframework.boot.gradle.tasks.bundling.BootJar>("bootJar") {
   mainClass.set("com.skk.apigateway.ApiGatewayApplication")
}
