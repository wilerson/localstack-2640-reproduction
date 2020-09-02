
plugins {
    kotlin("jvm") version "1.4.0"
    id("com.avast.gradle.docker-compose") version "0.13.2"
    application
}

group = "com.wilerson"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
dependencies {
    implementation(platform("software.amazon.awssdk:bom:2.14.8"))
    implementation("software.amazon.awssdk:sqs")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.2")
    testImplementation(kotlin("test-junit5"))
}
tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    test {
        useJUnitPlatform()
    }
}
dockerCompose.isRequiredBy(tasks["test"])
