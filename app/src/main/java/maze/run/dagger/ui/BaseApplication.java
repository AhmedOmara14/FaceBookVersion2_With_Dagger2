package maze.run.dagger.ui;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerAppCompatActivity;
import dagger.android.support.DaggerApplication;
import maze.run.dagger.di.DaggerAppComponent;

public class BaseApplication extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }
}
