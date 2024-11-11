package com.example.pojectku;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ImageSlideAdapter extends RecyclerView.Adapter<ImageSlideAdapter.ImageViewHolder> {

    private List<ImageSlide> imageSlides;

    public ImageSlideAdapter(List<ImageSlide> imageSlides) {
        this.imageSlides = imageSlides;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_img, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        ImageSlide imageItem = imageSlides.get(position);
        holder.imageView.setImageResource(imageItem.getResourceId());
    }

    @Override
    public int getItemCount() {
        return imageSlides.size();
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.sl_image); // Pastikan id sesuai dengan XML
        }
    }
}


