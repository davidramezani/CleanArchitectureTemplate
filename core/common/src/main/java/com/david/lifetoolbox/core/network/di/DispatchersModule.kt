package com.david.lifetoolbox.core.network.di

import com.david.lifetoolbox.core.network.LtbDispatchers.IO
import com.david.lifetoolbox.core.network.Dispatcher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
object DispatchersModule {
    @Provides
    @Dispatcher(IO)
    fun provideIODispatcher() : CoroutineDispatcher = Dispatchers.IO
}
