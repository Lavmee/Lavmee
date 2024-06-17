package tech.annexflow.konstructor.developer.components.kotlin

import tech.annexflow.konstructor.developer.Developer
import tech.annexflow.konstructor.developer.DeveloperKonstructor
import tech.annexflow.konstructor.developer.annotation.DeveloperDSL
import tech.annexflow.konstructor.developer.component.DeveloperComponent
import tech.annexflow.konstructor.developer.component.DeveloperComponentProvider

interface Kotlin : DeveloperComponent<Kotlin.Config> {

    data class Config(
        val extensions: MutableSet<KotlinExtension> = mutableSetOf(),
    )

    companion object : DeveloperComponentProvider<Config, Kotlin> {
        override val key: String = "kotlin"

        override fun create(developer: Developer, config: Config): Kotlin = KotlinImpl(developer, config)

        override fun createConfig(init: Config.() -> Unit): Config = Config().apply(init)
    }

}

val Developer.kotlin: Kotlin get() = this.componentManager.getComponent(Kotlin)

infix fun Kotlin.Config.with(extension: KotlinExtension) {
    extensions.add(extension)
}

internal class KotlinImpl(
    override val developer: Developer,
    override val config: Kotlin.Config,
): Kotlin

@DeveloperDSL
fun DeveloperKonstructor.kotlin(
    init: @DeveloperDSL Kotlin.Config.() -> Unit = {},
) = this.install(Kotlin, init)
