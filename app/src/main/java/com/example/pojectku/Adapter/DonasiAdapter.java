package com.example.pojectku.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.example.pojectku.Item.ItemDonasi;
import com.example.pojectku.R;

import java.io.Serializable;
import java.util.ArrayList;

public class DonasiAdapter extends RecyclerView.Adapter<DonasiAdapter.ViewHolder> {
    ArrayList<ItemDonasi> item;

    public DonasiAdapter(ArrayList<ItemDonasi> item) {
        this.item = item;
    }

    @NonNull
    @Override
    public DonasiAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_donasi,parent,false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull DonasiAdapter.ViewHolder holder, int position) {
    holder.kategori.setText(item.get(position).getCategori());
    holder.title.setText(item.get(position).getTitle());

    int drawableResId = holder.itemView.getResources().getIdentifier(item.get(position).getPicture(),
            "drawable", holder.itemView.getContext().getPackageName());

    Glide.with(holder.itemView.getContext())
            .load(drawableResId)
            .transform(new CenterCrop(), new GranularRoundedCorners(40,40,40,40))
            .into(holder.img);

    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView kategori, title;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img=itemView.findViewById(R.id.img_2);
            kategori=itemView.findViewById(R.id.txt_kategori);
            title=itemView.findViewById(R.id.txt_title);

        }
    }
}
