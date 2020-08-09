package maze.run.dagger.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import maze.run.dagger.di.auth.AuthModule;
import maze.run.dagger.di.auth.AuthViewModelModule;
import maze.run.dagger.ui.auth.AuthActivity;

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

}
