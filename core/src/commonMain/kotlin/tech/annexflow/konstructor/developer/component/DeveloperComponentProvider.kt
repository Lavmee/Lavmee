package tech.annexflow.konstructor.developer.component

import tech.annexflow.konstructor.developer.Developer
import tech.annexflow.konstructor.developer.DeveloperKonstructor

interface DeveloperComponentProvider<Config, PluginInstance : DeveloperComponent<Config>> {

    val key: String

    fun createConfig(init: Config.() -> Unit): Config

    fun setup(konstructor: DeveloperKonstructor, config: Config) {}

    fun create(developer: Developer, config: Config) : PluginInstance

}
