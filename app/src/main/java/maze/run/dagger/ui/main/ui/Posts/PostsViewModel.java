package maze.run.dagger.ui.main.ui.Posts;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import maze.run.dagger.pojo.AuthApi;
import maze.run.dagger.pojo.Posts;

public class PostsViewModel extends ViewModel {

    private MutableLiveData<List<Posts>> listOfPosts=new MutableLiveData<>();
    private static final String TAG = "PostsViewModel";

    @Inject
    AuthApi authApi;

    @Inject
    public PostsViewModel(AuthApi authApi) {
        this.authApi = authApi;
        if (authApi == null) {
            Log.d(TAG, "Authapi in HomeViewModel: null");
        } else {
            Log.d(TAG, "Authapi in HomeViewModel: notnull");

        }
    }

    public LiveData<List<Posts>> getListPosts()
    {
        Observable<List<Posts>> listObservable =
                authApi.getposts()
                        .subscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread());

        ;

        Observer<List<Posts>> listObserver = new Observer<List<Posts>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<Posts> posts) {

                listOfPosts.setValue(posts);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: " + e);
            }

            @Override
            public void onComplete() {

            }
        };
        listObservable.subscribe(listObserver);

        return listOfPosts;
    }
}