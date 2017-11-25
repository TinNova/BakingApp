package com.example.tin.bakingapp.Adapters;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tin.bakingapp.Models.TheSteps;
import com.example.tin.bakingapp.R;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class TheStepsAdapter extends RecyclerView.Adapter<TheStepsAdapter.ViewHolder> {

    private final ArrayList<TheSteps> mStepsList;
    private final Context mContext;
    private TheStepsClickListener mClickListener;

    public interface TheStepsClickListener {
        void onClick(int position);
    }

    public TheStepsAdapter(ArrayList<TheSteps> stepsList, Context context, TheStepsClickListener listener) {
        this.mStepsList = stepsList;
        this.mContext = context;
        this.mClickListener = listener;

    }

    /**
     * This gets called when each new ViewHolder is created. This happens when the RecyclerView
     * is laid out. Enough ViewHolders will be created to fill the screen and allow for scrolling.
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new View and inflate the list_item Layout into it
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.steps_list_item, viewGroup, false);
        // Return the view just created
        return new TheStepsAdapter.ViewHolder(v);
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

        TheSteps theSteps = mStepsList.get(position);

        viewHolder.tvShortDescription.setText(theSteps.getShortDescription());
    }



    @Override
    public int getItemCount() {
        return mStepsList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvShortDescription;

        public ViewHolder(View itemView) {
            super(itemView);

            tvShortDescription = itemView.findViewById(R.id.short_description);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            mClickListener.onClick(position);
        }
    }
}
