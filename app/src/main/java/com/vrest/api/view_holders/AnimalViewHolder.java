package com.vrest.api.view_holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vrest.api.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AnimalViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.ID_animal_image)
    public ImageView mAnimalImage;
    @BindView(R.id.ID_animal_category)
    public TextView mAnimalCategory;
    @BindView(R.id.ID_animal_description)
    public TextView mAnimalDescription;

    public AnimalViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
