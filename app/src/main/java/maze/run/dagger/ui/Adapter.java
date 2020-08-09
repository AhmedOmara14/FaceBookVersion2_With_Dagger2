package maze.run.dagger.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

import maze.run.dagger.R;
import maze.run.dagger.pojo.Posts;

public class Adapter extends RecyclerView.Adapter<Adapter.viewholder> {

    Context context;
    List<Posts> Posts =new ArrayList<>();

    public Adapter(Context context, List<Posts> posts) {
        this.context = context;
        this.Posts = posts;
    }

    @NonNull
    @Override
    public Adapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_posts,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.viewholder holder, int position) {
            holder.title.setText(Posts.get(position).getTitle());
            holder.id.setText(Posts.get(position).getId()+"");
            holder.body.setText(Posts.get(position).getBody()+"");

    }

    @Override
    public int getItemCount() {
        return Posts.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        public TextView title,id,body;
        public viewholder(@NonNull View itemView) {
           super(itemView);
           title=itemView.findViewById(R.id.title);
           id=itemView.findViewById(R.id.id);
           body=itemView.findViewById(R.id.body);
       }
   }
}
