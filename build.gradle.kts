plugins {
    java
    application
    id("com.gradleup.shadow") version "9.2.2"
}

group = "net.mendex.discord"
version = "0.0.0"

repositories.mavenCentral()
dependencies {
    implementation("net.dv8tion:JDA:6.1.1")
    implementation("ch.qos.logback:logback-classic:1.5.20")
    implementation("io.github.cdimascio:dotenv-java:3.2.0")
}

application.mainClass = "$group.Bot"

tasks.withType<JavaCompile> {
    options.encoding = Charsets.UTF_8.name()
    options.isIncremental = true
}