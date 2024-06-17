package tech.annexflow.konstructor.developer.component

import tech.annexflow.konstructor.developer.Developer

interface DeveloperComponent<Config> {

    val config: Config

    val developer: Developer

    fun init() {}

    fun close() {}

}
