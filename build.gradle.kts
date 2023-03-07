plugins {
    kotlin("jvm") version PluginVersions.JVM_VERSION
}

subprojects {
    apply {
        plugin(Plugins.JVM)
        version = PluginVersions.JVM_VERSION
    }

    apply {
        plugin(Plugins.KAPT)
        version = PluginVersions.KAPT_VERSION
    }

    dependencies {

        // kotlin
        implementation(Dependencies.KOTLIN_REFLECT)
        implementation(Dependencies.KOTLIN_JDK)

        // test
        testImplementation(Dependencies.SPRING_TEST)
    }
}

allprojects {
    group = "com.pea06"
    version = "0.0.1"


    tasks {
        compileKotlin {
            kotlinOptions {
                freeCompilerArgs = listOf("-Xjsr305=strict")
                jvmTarget = "11"
            }
        }

        compileJava {
            sourceCompatibility = JavaVersion.VERSION_11.majorVersion
        }

        test {
            useJUnitPlatform()
        }
    }

    repositories {
        mavenCentral()
    }
}


tasks.getByName<Jar>("jar") {
    enabled = false
}