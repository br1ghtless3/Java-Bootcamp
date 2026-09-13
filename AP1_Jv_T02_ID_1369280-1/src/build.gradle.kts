plugins {
    id("java")
}

subprojects {
    apply(plugin = "java")

    group = "ru.br1ghtless.ap1_jv_t02"
    version = "1.0.0"

    repositories {
        mavenCentral()
    }

    configure<JavaPluginExtension> {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
}