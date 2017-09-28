package com.example.sa9ya.fbu;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by sa9ya on 26.09.2017.
 */


public class PostsNews extends RecyclerView.Adapter<PostsNews.ViewHolder> {

    private List<ApiModel> posts;
    Context context;

    public PostsNews(List<ApiModel> posts) {
        this.posts = posts;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        context = holder.image.getContext();

        ApiModel post = posts.get(position);
        Picasso.with(context).load(post.getImg()).into(holder.image);
        holder.cat.setText("Суперліга Парі-Матч");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date newDate = null;
        try {
            newDate = format.parse(String.valueOf(post.getDate()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        format = new SimpleDateFormat("dd.MM.yyyy");
        String date = format.format(newDate);

        if(newDate != null) {
            holder.date.setText(date);
        } else {
            holder.date.setText(String.valueOf(post.getDate()));
        }
        holder.title.setText(String.valueOf(post.getTitle()));
        holder.setHolderId(post.getId());
    }

    @Override
    public int getItemCount() {
        if (posts == null)
            return 0;
        return posts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView image;
        TextView title;
        TextView date;
        TextView cat;
        int id;
        Intent intent;

        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.postitem_image);
            cat = (TextView) itemView.findViewById(R.id.postitem_cat);
            date = (TextView) itemView.findViewById(R.id.postitem_date);
            title = (TextView) itemView.findViewById(R.id.postitem_site);

            image.setOnClickListener(this);
            title.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            System.out.println("Click " + this.getHolderId());

            intent = new Intent(context, NewExpanded.class);
            context.startActivity(intent);
        }

        public void setHolderId(int id) {
            this.id = id;
        }
        public int getHolderId() {
            return id;
        }
    }
}
