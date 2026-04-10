plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("jvm")
    kotlin("plugin.spring")
}
dependencies {
    implementation("org.springframework.cloud:spring-cloud-config-server")

    // Config Server usually registers with Eureka too
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")

}
