package tech.annexflow.konstructor.developer.components.links

import tech.annexflow.konstructor.developer.Developer
import tech.annexflow.konstructor.developer.DeveloperKonstructor
import tech.annexflow.konstructor.developer.annotation.DeveloperDSL
import tech.annexflow.konstructor.developer.component.DeveloperComponent
import tech.annexflow.konstructor.developer.component.DeveloperComponentProvider

interface Links : DeveloperComponent<Links.Config> {

    fun printAll()

    data class Config(
        var x: String? = null,
        var telegram: String? = null,
    )

    companion object : DeveloperComponentProvider<Config, Links> {
        override val key: String = "links"

        override fun create(developer: Developer, config: Config): Links = LinksImpl(developer, config)

        override fun createConfig(init: Config.() -> Unit): Config = Config().apply(init)
    }

}

val Developer.links: Links get() = this.componentManager.getComponent(Links)

internal class LinksImpl(
    override val developer: Developer,
    override val config: Links.Config,
): Links {

    override fun printAll() {
        println("X: ${config.x}")
        println("Telegram: ${config.telegram}")
    }

}

@DeveloperDSL
fun DeveloperKonstructor.links(
    init: @DeveloperDSL Links.Config.() -> Unit = {},
) = this.install(Links, init)
