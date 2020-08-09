package maze.run.dagger.di;

import androidx.lifecycle.ViewModelProvider;

import dagger.Binds;
import dagger.Module;
import maze.run.dagger.ViewModels.ViewModelProviderFactory;

@Module
public abstract class viewModelFactoryModule {
    @Binds
    public abstract ViewModelProvider.Factory factory(ViewModelProviderFactory viewModelProviderFactory);
}
