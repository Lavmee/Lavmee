package tech.annexflow.konstructor.developer

import tech.annexflow.konstructor.developer.annotation.DeveloperDSL
import tech.annexflow.konstructor.developer.component.DeveloperComponent
import tech.annexflow.konstructor.developer.component.DeveloperComponentProvider

@DeveloperDSL
class DeveloperKonstructor {
    private val components = mutableMapOf<String, ((Developer) -> DeveloperComponent<*>)>()

    fun konstruct(): Developer = DeveloperImpl(components = components)

    @DeveloperDSL
    fun <Config, ComponentInstance : DeveloperComponent<Config>, Provider : DeveloperComponentProvider<Config, ComponentInstance>> install(
        component: Provider,
        init: @DeveloperDSL Config.() -> Unit = {},
    ) {
        val config = component.createConfig(init)
        component.setup(konstructor = this, config = config)
        components[component.key] = { developer ->
            component.create(developer = developer, config = config)
        }
    }

}

fun developer(
    konstructor: DeveloperKonstructor.() -> Unit,
): Developer = DeveloperKonstructor().apply(konstructor).konstruct()
