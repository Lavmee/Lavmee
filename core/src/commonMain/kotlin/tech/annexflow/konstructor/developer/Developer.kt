package tech.annexflow.konstructor.developer

import kotlin.reflect.KProperty

interface Developer {

    val componentManager: ComponentManager

}

/**
 * Just fun :)
 */
inline operator fun Developer.getValue(thisRef: Any?, property: KProperty<*>): Developer = this
