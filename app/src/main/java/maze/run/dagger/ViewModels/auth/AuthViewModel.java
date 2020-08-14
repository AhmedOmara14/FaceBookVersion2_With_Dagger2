package maze.run.dagger.ViewModels.auth;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import maze.run.dagger.pojo.AuthApi;
import maze.run.dagger.pojo.Posts;

public class AuthViewModel extends ViewModel {
    private static final String TAG = "AuthViewModel";
    public MutableLiveData<List<Posts>> listMutableLiveData=new MutableLiveData<>();
    private AuthApi authApi;

    @Inject
    public AuthViewModel(AuthApi authApi) {
        this.authApi=authApi;
        Log.d(TAG, "AuthViewModel: is working");

        if (authApi==null){
            Log.d(TAG, "AuthViewModel: is Null");
        }

    }

    public void getListMutableLiveData()
        {

            Observable observable=authApi.getposts()
                    .subscribeOn(Schedulers.computation())
                    .observeOn(AndroidSchedulers.mainThread());

            Observer<List<Posts>> listObserver=new Observer<List<Posts>>() {
                @Override
                public void onSubscribe(@NonNull Disposable d) {

                }

                @Override
                public void onNext(@NonNull List<Posts> posts) {
                    listMutableLiveData.setValue(posts);

                }

                @Override
                public void onError(@NonNull Throwable e) {
                    Log.d(TAG, "onError: "+e.getMessage());
                }

                @Override
                public void onComplete() {

                }
            };
            observable.subscribe(listObserver);



    }
}
