package com.david.core.network

import javax.inject.Qualifier
import kotlin.annotation.AnnotationRetention.RUNTIME


@Qualifier
@Retention(RUNTIME)
annotation class Dispatcher(val davidDispatcher : LtbDispatchers)

enum class LtbDispatchers {
    IO
}