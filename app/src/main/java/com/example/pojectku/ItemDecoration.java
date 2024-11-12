package com.example.pojectku;

import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemDecoration extends RecyclerView.ItemDecoration {

    private final int horizontalMargin;

    public ItemDecoration(int horizontalMargin) {
        this.horizontalMargin = horizontalMargin;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        outRect.left = horizontalMargin;
        outRect.right = horizontalMargin;
    }
}

