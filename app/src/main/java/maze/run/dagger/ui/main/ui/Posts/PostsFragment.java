package maze.run.dagger.ui.main.ui.Posts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;
import maze.run.dagger.R;
import maze.run.dagger.ViewModels.ViewModelProviderFactory;
import maze.run.dagger.pojo.Posts;
import maze.run.dagger.ui.Adapter;

public class PostsFragment extends DaggerFragment {

    private PostsViewModel galleryViewModel;
    private maze.run.dagger.ui.Adapter adapter;

    @Inject
     ViewModelProviderFactory viewModelProviderFactory;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        galleryViewModel = ViewModelProviders.of(this, viewModelProviderFactory).get(PostsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        final RecyclerView recyclerView = root.findViewById(R.id.recycler_Posts);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        galleryViewModel.getListPosts().observe(getViewLifecycleOwner(), new Observer<List<Posts>>() {
            @Override
            public void onChanged(List<Posts> posts) {
                adapter=new Adapter(getContext(),posts);
                recyclerView.setAdapter(adapter);
            }
        });
        return root;
    }
}