package kuznetsov.hse.kmm.koin

import co.touchlab.kermit.Logger
import co.touchlab.kermit.StaticConfig
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

class KoinInitializer {

    fun initKoin(appDeclaration: KoinAppDeclaration = {}) =
        startKoin {
            val koinPlatformModuleInitializer = KoinPlatformModuleInitializer()
            appDeclaration()
            modules(koinPlatformModuleInitializer.platformModule, commonModule)
        }

    // called by iOS etc
    fun initKoin() = initKoin {
        val log = Logger(config = StaticConfig(), tag = "KOIN_")
        log.d("initKoin ios")
    }

    val commonModule = module {}

}