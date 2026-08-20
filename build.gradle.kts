plugins {
    id("java")
    id("io.qameta.allure") version "4.1.0"
}

group = "ui-test"
version = "1.0-SNAPSHOT"

val playwrightVersion = "1.51.0"
val testngVersion = "7.12.0"
val commonsLangVersion = "3.18.0"
val slf4jVersion = "2.0.13"
val logbackVersion = "1.5.6"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.microsoft.playwright:playwright:${playwrightVersion}")
    testImplementation("org.testng:testng:${testngVersion}")
    implementation("org.apache.commons:commons-lang3:${commonsLangVersion}")

    implementation("org.slf4j:slf4j-api:${slf4jVersion}")
    implementation("ch.qos.logback:logback-classic:${logbackVersion}")
}

allure {
    version.set("2.34.0")
}

tasks.test {
    useTestNG()
}

tasks.named<io.qameta.allure.gradle.report.tasks.AllureServe>("allureServe") {
    dependsOnTests()
}
