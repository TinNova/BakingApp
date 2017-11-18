package com.example.tin.bakingapp.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tin.bakingapp.Models.TheRecipe;
import com.example.tin.bakingapp.R;

import java.util.List;

/**
 * Created by Tin on 18/11/2017.
 */

public class TheRecipeAdapter extends RecyclerView.Adapter<TheRecipeAdapter.ViewHolder> {

    private final List<TheRecipe> recipes;
    private final Context context;

    RecipeListItemClickListener mOnClickListener;

    public interface RecipeListItemClickListener {
        void onListItemClick (int clickedItemIndex);
    }


    public TheRecipeAdapter(List<TheRecipe> recipes, Context context) {
        this.recipes = recipes;
        this.context = context;
    }

    /**
     * This gets called when each new ViewHolder is created. This happens when the RecyclerView
     * is laid out. Enough ViewHolders will be created to fill the screen and allow for scrolling.
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new View and inflate the list_item Layout into it
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recipes_list_item, viewGroup, false);

        // Return the View we just created
        return new TheRecipeAdapter.ViewHolder(v);
    }

    /**
     * OnBindViewHolder is called by the RecyclerView to display the data at the specified
     * position.
     *
     * @param viewHolder   The ViewHolder which should be updated to represent the
     *                 contents of the item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        TheRecipe recipe = recipes.get(position);

        viewHolder.userNameTV.setText(review.getUserName());
        viewHolder.userReviewTV.setText(review.getUserComment());

    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        final TextView userNameTV;
        final TextView userReviewTV;


        @Override
        public void onClick(View view) {

            int clickedPosition = getAdapterPosition();
            mOnClickListener.onListItemClick(clickedPosition);

        }


        public ViewHolder(View itemView) {
            super(itemView);

            userNameTV = (TextView) itemView.findViewById(R.id.user_name);
            userReviewTV = (TextView) itemView.findViewById(R.id.user_review);

        }

    }
}



