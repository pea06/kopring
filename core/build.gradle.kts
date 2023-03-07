plugins {
    id(Plugins.SPRING_BOOT) version PluginVersions.SPRING_BOOT_VERSION
    id(Plugins.DEPENDENCY_MANAGEMENT) version PluginVersions.DEPENDENCY_MANAGER_VERSION
    kotlin(Plugins.SPRING) version PluginVersions.SPRING_PLUGIN_VERSION
    kotlin(Plugins.JPA) version PluginVersions.JPA_VERSION
}

dependencies {

    // kotlin
    implementation(Dependencies.JACKSON)

    // database
    implementation(Dependencies.SPRING_DATA_JPA)
    runtimeOnly(Dependencies.MONGODB_SYNC)
    runtimeOnly(Dependencies.MONGODB_CORE)

}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
    annotation("javax.persistence.Embeddable")
}

noArg {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
    annotation("javax.persistence.Embeddable")
}

tasks.getByName<Jar>("jar") {
    enabled = false
}