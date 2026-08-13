plugins {
    id("java")
}

group = "ui-test"
version = "1.0-SNAPSHOT"

val playwrightVersion = "1.51.0"
val testngVersion = "7.12.0"
val commonsLangVersion = "3.18.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.microsoft.playwright:playwright:${playwrightVersion}")
    testImplementation("org.testng:testng:${testngVersion}")
    implementation("org.apache.commons:commons-lang3:${commonsLangVersion}")
}

tasks.test {
    useTestNG()
    }
