package maze.run.dagger.di.auth;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import maze.run.dagger.di.auth.AuthModule;
import maze.run.dagger.di.auth.AuthViewModelModule;
import maze.run.dagger.di.main.MainFragmentModule;
import maze.run.dagger.di.main.MainViewModelsModule;
import maze.run.dagger.ui.auth.AuthActivity;
import maze.run.dagger.ui.main.MainActivity;

@Module
public abstract class ActivityBuilderModule {

    //auth activity
    @ContributesAndroidInjector(
            modules = {
                    AuthViewModelModule.class,
                    AuthModule.class
            }
    )
    abstract AuthActivity authActivity();



    //Main activity
    @ContributesAndroidInjector(
            modules = {
                    MainFragmentModule.class,
                   MainViewModelsModule.class,
            }
    )
    abstract MainActivity mainActivity();

}
