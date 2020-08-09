package maze.run.dagger.ui.auth;

import android.os.Bundle;
import android.util.Log;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.android.support.DaggerAppCompatActivity;
import maze.run.dagger.R;
import maze.run.dagger.ViewModels.auth.AuthViewModel;
import maze.run.dagger.ViewModels.ViewModelProviderFactory;
import maze.run.dagger.pojo.Posts;
import maze.run.dagger.ui.Adapter;

public class AuthActivity extends DaggerAppCompatActivity {


    @Inject
    ViewModelProviderFactory viewModelProviderFactory;

    AuthViewModel authViewModel;
    private static final String TAG = "AuthActivity";
    Adapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        authViewModel = ViewModelProviders.of(this, viewModelProviderFactory).get(AuthViewModel.class);

        authViewModel.getListMutableLiveData();
        authViewModel.listMutableLiveData.observe(this, new Observer<List<Posts>>() {
            @Override
            public void onChanged(List<Posts> posts) {
                Log.d(TAG, "onChanged: " + posts.get(2).getTitle());
                adapter = new Adapter(AuthActivity.this, posts);
                recyclerView.setAdapter(adapter);
            }
        });

        Log.d(TAG, "ahm auth view model onCreate: "+authViewModel);


    }
}