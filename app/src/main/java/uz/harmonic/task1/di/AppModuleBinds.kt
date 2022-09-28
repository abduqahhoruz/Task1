package uz.harmonic.task1.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.harmonic.task1.data.Pref
import uz.harmonic.task1.data.PrefImpl
import uz.harmonic.task1.data.Repo
import uz.harmonic.task1.data.RepoImp

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModuleBinds {

    @Binds
    abstract fun bindPref(prefImpl: PrefImpl): Pref

    @Binds
    abstract fun bindRepo(repoImp: RepoImp): Repo
}