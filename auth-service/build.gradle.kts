plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("jvm")
    kotlin("plugin.spring")
}

dependencies {
    // Standard Auth dependencies (Example)

    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")
    implementation("org.springframework.boot:spring-boot-starter-web")
    // Add these for Config Server support
    implementation("org.springframework.cloud:spring-cloud-starter-config")
    implementation("org.springframework.cloud:spring-cloud-starter-bootstrap")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    // JJWT API
    implementation("io.jsonwebtoken:jjwt-api:0.11.5")

    // JJWT Implementation (needed at runtime)
    runtimeOnly("io.jsonwebtoken:jjwt-impl:0.11.5")

    // JJWT Jackson (for JSON parsing)
    runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.11.5")

}
springBoot {
    mainClass.set("com.skk.auth.AuthApplicationKt")
}
