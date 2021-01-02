package maze.run.dagger.pojo;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;

public interface AuthApi {
    @GET("posts")
    public Observable<List<Posts>> getposts();

}
