plugins {
    id("org.jetbrains.kotlin.jvm") version "1.6.10"
    id("org.jetbrains.kotlin.kapt") version "1.6.10"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.6.10"
    id("com.github.johnrengelman.shadow") version "7.1.2"
    id("io.micronaut.application") version "3.3.2"
}

version = "0.1"
group = "com.dashBoardUniversary"

val kotlinVersion=project.properties.get("kotlinVersion")
repositories {
    mavenCentral()
}

dependencies {
    kapt("io.micronaut:micronaut-http-validation")
    kapt("io.micronaut.security:micronaut-security-annotations")
    implementation("io.micronaut:micronaut-http-client")
    implementation("io.micronaut:micronaut-jackson-databind")
    implementation("io.micronaut:micronaut-runtime")
    implementation("io.micronaut.kotlin:micronaut-kotlin-runtime")
    implementation("io.micronaut.security:micronaut-security")
    implementation("io.micronaut.security:micronaut-security-jwt")
    implementation("io.micronaut.security:micronaut-security-oauth2")
    implementation("jakarta.annotation:jakarta.annotation-api")
    implementation("org.jetbrains.kotlin:kotlin-reflect:${kotlinVersion}")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${kotlinVersion}")
    runtimeOnly("ch.qos.logback:logback-classic")
    implementation("io.micronaut:micronaut-validation")


    implementation("io.micronaut.security:micronaut-security-annotations")


    implementation("com.squareup.okhttp:okhttp:2.7.5")
//    implementation("com.squareup.okhttp:okhttp-urlconnetion:2.7.5")


    // https://mvnrepository.com/artifact/io.reactivex.rxjava2/rxjava
    implementation("io.reactivex.rxjava2:rxjava:2.2.21")

    // https://mvnrepository.com/artifact/org.apache.httpcomponents/httpclient
    implementation("org.apache.httpcomponents:httpclient:4.5")

    implementation("org.keycloak:keycloak-spring-boot-starter:11.0.3")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.keycloak:keycloak-spring-boot-starter:11.0.3")


    implementation("com.google.code.gson:gson:2.8.8")

    implementation("org.apache.commons:commons-lang3:3.12.0")

    implementation("javax.xml.bind:jaxb-api:2.3.1")
    implementation("io.jsonwebtoken:jjwt:0.9.1")
    implementation("org.bouncycastle:bcprov-jdk15on:1.69")
    implementation("com.nimbusds:nimbus-jose-jwt:9.14")
    implementation("org.jsoup:jsoup:1.13.1")


    runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin")

}


application {
    mainClass.set("com.dashBoardUniversary.ApplicationKt")
}
java {
    sourceCompatibility = JavaVersion.toVersion("11")
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "11"
        }
    }
    compileTestKotlin {
        kotlinOptions {
            jvmTarget = "11"
        }
    }
}
graalvmNative.toolchainDetection.set(false)
micronaut {
    runtime("netty")
    testRuntime("kotest")
    processing {
        incremental(true)
        annotations("com.dashBoardUniversary.*")
    }
}