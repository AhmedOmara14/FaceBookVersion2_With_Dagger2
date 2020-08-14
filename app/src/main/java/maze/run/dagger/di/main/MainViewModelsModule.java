package maze.run.dagger.di.main;

import androidx.lifecycle.ViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import maze.run.dagger.di.viewModelKey.ViewModelKey;
import maze.run.dagger.ui.main.ui.Posts.PostsViewModel;
import maze.run.dagger.ui.main.ui.Profile.ProfileViewModel;


@Module
public abstract class MainViewModelsModule {


    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel.class)
    public abstract ViewModel bindhomeViewModel(ProfileViewModel homeViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(PostsViewModel.class)
    public abstract ViewModel bindgalerryViewModel(PostsViewModel galleryViewModel);
}
