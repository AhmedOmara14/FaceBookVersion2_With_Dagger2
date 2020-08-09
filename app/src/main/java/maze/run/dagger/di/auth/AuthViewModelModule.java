package maze.run.dagger.di.auth;


import androidx.lifecycle.ViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import maze.run.dagger.ViewModels.auth.AuthViewModel;
import maze.run.dagger.di.viewModelKey.ViewModelKey;

@Module
public abstract class AuthViewModelModule {


    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel.class)
    public abstract ViewModel bindAuthViewModel(AuthViewModel viewModel);
}
