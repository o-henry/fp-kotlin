plugins {
    kotlin("jvm") version "1.8.10"
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
    implementation("io.arrow-kt:arrow-core:1.2.0-RC")
    implementation("io.arrow-kt:arrow-fx-coroutines:1.2.0-RC")

}


tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(11)
}
