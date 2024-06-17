package tech.annexflow.lavmee

import tech.annexflow.konstructor.company.Company
import tech.annexflow.konstructor.developer.components.about.about
import tech.annexflow.konstructor.developer.components.kotlin.Kotlin
import tech.annexflow.konstructor.developer.components.kotlin.Multiplatform
import tech.annexflow.konstructor.developer.components.kotlin.with
import tech.annexflow.konstructor.developer.components.links.links
import tech.annexflow.konstructor.developer.developer
import tech.annexflow.konstructor.developer.getValue

val lavmee by developer {
    about {
        fullName = "Sergei Gagarin"
        displayName = "Lavmee"
        age = 22u
        company = Foresko
    }

    links {
        x = "@samuelgagarin"
        telegram = "@lavmee"
    }

    install(Kotlin) {
        this with Multiplatform
    }
}

data object Foresko : Company
