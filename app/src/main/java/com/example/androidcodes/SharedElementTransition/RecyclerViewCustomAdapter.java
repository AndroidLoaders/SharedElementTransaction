package com.example.androidcodes.SharedElementTransition;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Mehta on 4/23/2017.
 */

public class RecyclerViewCustomAdapter extends RecyclerView.Adapter<RecyclerViewCustomAdapter.
        CustomViewHolder> {

    private Context context;

    private ArrayList<Model> list;

    public RecyclerViewCustomAdapter(Context context, ArrayList<Model> list) {

        this.context = context;

        this.list = list;

    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View customView = LayoutInflater.from(context).inflate(R.layout.recclerview_list_item,
                parent, false);

        return new CustomViewHolder(customView);

    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {

        holder.iv_image.setImageResource(R.drawable.image);

        holder.tv_appName.setText(list.get(position).getAppName());

        holder.tv_companyName.setText(list.get(position).getCompanyName());

    }

    @Override
    public int getItemCount() {

        return list != null ? list.size() : 0;

    }

    public class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView iv_image;

        public TextView tv_appName, tv_companyName;

        public CustomViewHolder(View itemView) {
            super(itemView);

            iv_image = (ImageView) itemView.findViewById(R.id.iv_image);

            tv_appName = (TextView) itemView.findViewById(R.id.tv_appName);

            tv_companyName = (TextView) itemView.findViewById(R.id.tv_companyName);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            int position = getAdapterPosition();

            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("myappName", list.get(position).getAppName());
            /*Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.image);
            intent.putExtra("bitmap", bitmap);*/
            intent.putParcelableArrayListExtra("parcebleList", list);
            ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeBasic().
                    makeSceneTransitionAnimation((AppCompatActivity) context,
                            new Pair<>(v.findViewById(R.id.iv_image), "logo"),
                            new Pair<View, String>(tv_appName, "appName"));
            ActivityCompat.startActivity(context, intent, optionsCompat.toBundle());

        }
    }
}
