package maze.run.dagger.di.auth;


import dagger.Module;
import dagger.Provides;
import maze.run.dagger.pojo.AuthApi;
import retrofit2.Retrofit;

@Module
public class AuthModule {
    @Provides
    static AuthApi authApi(Retrofit retrofit){
        return retrofit.create(AuthApi.class);
    }
}
