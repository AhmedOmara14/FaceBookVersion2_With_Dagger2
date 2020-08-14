package maze.run.dagger.ui.main.ui.Profile;

import android.util.Log;

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

public class ProfileViewModel extends ViewModel {

    public MutableLiveData<List<Posts>> listMutableLiveData=new MutableLiveData<>();
    private AuthApi authApi;
    private static final String TAG = "HomeViewModel";

    @Inject
    public ProfileViewModel(AuthApi authApi) {
        this.authApi = authApi;
        if (authApi == null) {
            Log.d(TAG, "Authapi in HomeViewModel: null");
        } else {
            Log.d(TAG, "Authapi in HomeViewModel: notnull");

        }
    }

    public MutableLiveData<List<Posts>> getlistofPosts() {

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

                listMutableLiveData.setValue(posts);
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

        return listMutableLiveData;
    }
}