plugins {
    kotlin("jvm") version "2.0.21"
    application
}

group = "br.com.bytebank"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(17)
}

application {
    mainClass.set("br.com.bytebank.MainKt")
}
