package maze.run.dagger.ui.main.ui.Profile;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;
import maze.run.dagger.R;
import maze.run.dagger.ViewModels.ViewModelProviderFactory;
import maze.run.dagger.pojo.Posts;

public class ProfileFragment extends DaggerFragment {

    private ProfileViewModel homeViewModel;
    private static final String TAG = "HomeFragment";
    @Inject

    ViewModelProviderFactory viewModelProviderFactory;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = ViewModelProviders.of(this, viewModelProviderFactory).get(ProfileViewModel.class);

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView userid = root.findViewById(R.id.userid1);
        final TextView title = root.findViewById(R.id.title1);
        final TextView body = root.findViewById(R.id.body1);

        homeViewModel.getlistofPosts().observe(getViewLifecycleOwner(), new Observer<List<Posts>>() {
            @Override
            public void onChanged(List<Posts> posts) {
               userid.setText(posts.get(1).getUserid()+"");
               title.setText(posts.get(1).getTitle()+"");
               body.setText(posts.get(1).getBody()+"");

            }
        });
        return root;
    }
}