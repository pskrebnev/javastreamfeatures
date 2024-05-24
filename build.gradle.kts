plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

//    implementation("org.graalvm.sdk:graal-sdk:22.3.2")
//    implementation("org.graalvm.js:js:22.3.2")
//    implementation("org.graalvm.js:js-scriptengine:22.3.2")
}

tasks.test {
    useJUnitPlatform()
}