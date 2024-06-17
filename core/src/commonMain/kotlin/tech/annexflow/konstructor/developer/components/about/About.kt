package tech.annexflow.konstructor.developer.components.about

import tech.annexflow.konstructor.company.Company
import tech.annexflow.konstructor.developer.Developer
import tech.annexflow.konstructor.developer.DeveloperKonstructor
import tech.annexflow.konstructor.developer.annotation.DeveloperDSL
import tech.annexflow.konstructor.developer.component.DeveloperComponent
import tech.annexflow.konstructor.developer.component.DeveloperComponentProvider

interface About : DeveloperComponent<About.Config> {

    data class Config(
        var fullName: String? = null,
        var displayName: String? = null,
        var company: Company? = null,
        var age: UByte? = null,
    )

    companion object : DeveloperComponentProvider<Config, About> {
        override val key: String = "about"

        override fun create(developer: Developer, config: Config): About = AboutImpl(developer, config)

        override fun createConfig(init: Config.() -> Unit): Config = Config().apply(init)
    }

}

val Developer.about: About get() = this.componentManager.getComponent(About)

internal class AboutImpl(
    override val developer: Developer,
    override val config: About.Config,
): About

@DeveloperDSL
fun DeveloperKonstructor.about(
    init: @DeveloperDSL About.Config.() -> Unit = {},
) = this.install(About, init)
