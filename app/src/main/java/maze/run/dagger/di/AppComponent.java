package maze.run.dagger.di;


import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import maze.run.dagger.ui.BaseApplication;

@Singleton
@Component(
        modules = {
                AndroidInjectionModule.class,
                ActivityBuilderModule.class,
                AppModule.class,
                viewModelFactoryModule.class,
        }
)
public interface AppComponent extends AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder{
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
