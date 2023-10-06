package az.zero.animeaz.di

import az.zero.animeaz.data.local.database.DBDriverFactory
import az.zero.animeaz.data.local.database.adapter.animeEntityAdapter
import az.zero.animeaz.data.local.file_storage.ImageStorageHandler
import az.zero.animeaz.database.AppDatabase

import az.zero.animeaz.presentation.string_util.StringProvider
import com.squareup.sqldelight.db.SqlDriver
import database.AnimeEntity
import org.koin.core.module.Module
import org.koin.dsl.module

actual class PlatformModule {
    actual val module: Module = module {

        single<SqlDriver> { DBDriverFactory(get()).create() }
        single<AppDatabase> { AppDatabase(get(), get()) }

        single<StringProvider> { StringProvider(get()) }
        single<ImageStorageHandler> { ImageStorageHandler(get()) }
    }
}