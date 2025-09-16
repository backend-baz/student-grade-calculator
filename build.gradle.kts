plugins {
    id("java")
    id("application")
}

group = "ir.emadi.amir"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

application {
    mainClass.set("ir.emadi.amir.Main")
}

tasks.test {
    useJUnitPlatform()
}