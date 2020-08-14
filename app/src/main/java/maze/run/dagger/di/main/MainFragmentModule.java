package maze.run.dagger.di.main;


import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import maze.run.dagger.di.auth.AuthModule;
import maze.run.dagger.ui.main.ui.Posts.PostsFragment;
import maze.run.dagger.ui.main.ui.Profile.ProfileFragment;

@Module
public abstract class MainFragmentModule {

    @ContributesAndroidInjector(
            modules = {
                    AuthModule.class
            }
    )
    abstract ProfileFragment homeFragment();

    @ContributesAndroidInjector(
            modules = {
                 AuthModule.class
            }
    )
    abstract PostsFragment galleryFragment();
}
