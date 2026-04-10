plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("jvm")
    kotlin("plugin.spring")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")

    // Add these for Config Server support
    implementation("org.springframework.cloud:spring-cloud-starter-config")
    implementation("org.springframework.cloud:spring-cloud-starter-bootstrap")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    // This provides HttpSecurity and the security framework
    implementation("org.springframework.boot:spring-boot-starter-security")

    // Optional: If you want to use JWT/OAuth2 resource server features
    implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server")

}

springBoot {
    mainClass.set("com.skk.order.OrderApplicationKt")
}

