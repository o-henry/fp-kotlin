plugins {
    kotlin("jvm") version "1.8.20"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("org.http4k:http4k-bom:4.43.0.0"))
    implementation("org.http4k:http4k-testing-servirtium")
    implementation("org.http4k:http4k-server-jetty")
    implementation("org.http4k:http4k-core")
    implementation("org.http4k:http4k-client-okhttp")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(11)
}