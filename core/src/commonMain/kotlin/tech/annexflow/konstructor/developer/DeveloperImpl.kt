package tech.annexflow.konstructor.developer

import tech.annexflow.konstructor.developer.component.DeveloperComponent

internal class DeveloperImpl(
    components: MutableMap<String, (Developer) -> DeveloperComponent<*>>,
) : Developer {

    override val componentManager: ComponentManager = ComponentManager(
        installedComponents = components.toList().associate { (key, value) -> key to value(this) },
    )

    init {
        componentManager.installedComponents.values.forEach(DeveloperComponent<*>::init)
    }

}
