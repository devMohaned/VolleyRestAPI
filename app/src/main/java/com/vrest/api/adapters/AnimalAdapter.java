package com.vrest.api.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.vrest.api.view_holders.AnimalViewHolder;
import com.vrest.api.R;
import com.vrest.api.models.Animal;

import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalViewHolder> {

    private List<Animal> list;
    public AnimalAdapter(List<Animal> list)
    {
        this.list = list;
    }

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AnimalViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_animal, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder holder, int position) {
        Animal currentAnimal = list.get(position);
        holder.mAnimalCategory.setText("Animal Category: " + currentAnimal.getCategory());
        holder.mAnimalDescription.setText("Animal Description: " + currentAnimal.getDescription());
        Picasso.get().load(getAnimalImage(currentAnimal.getDescription())).into(holder.mAnimalImage);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private String getAnimalImage(String animalDescription){
        if (animalDescription.toLowerCase().contains("dog"))
        {
            return "https://images.dog.ceo/breeds/mountain-bernese/n02107683_4350.jpg";
        }else if (animalDescription.toLowerCase().contains("cat"))
        {
            return "http://www.cutestpaw.com/wp-content/uploads/2016/02/Silly-kitty-all-the-birds-went-south....jpg";
        }
        return "https://image.shutterstock.com/image-vector/no-image-available-vector-illustration-260nw-744886198.jpg";


    }
}
