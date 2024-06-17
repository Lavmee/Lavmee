package tech.annexflow.konstructor.developer

import tech.annexflow.konstructor.developer.component.DeveloperComponent
import tech.annexflow.konstructor.developer.component.DeveloperComponentProvider

class ComponentManager(val installedComponents: Map<String, DeveloperComponent<*>>) {

    inline fun <reified Component : DeveloperComponent<Config>, Config, Provider : DeveloperComponentProvider<Config, Component>> getComponentOrNull(
        provider: Provider,
    ): Component? = installedComponents[provider.key] as? Component

    inline fun <reified Component : DeveloperComponent<Config>, Config, Provider : DeveloperComponentProvider<Config, Component>> getComponent(
        provider: Provider,
    ): Component = getComponentOrNull(provider) ?: error("DeveloperComponent ${provider.key} not installed.")

}
