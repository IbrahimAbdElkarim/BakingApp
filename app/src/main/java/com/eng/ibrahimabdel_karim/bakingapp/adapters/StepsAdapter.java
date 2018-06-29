package com.eng.ibrahimabdel_karim.bakingapp.adapters;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.eng.ibrahimabdel_karim.bakingapp.IgredientStepActivity;
import com.eng.ibrahimabdel_karim.bakingapp.R;
import com.eng.ibrahimabdel_karim.bakingapp.StepDetailActivity;
import com.eng.ibrahimabdel_karim.bakingapp.models.Step;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ibrahimAbdelKarim on 03/07/2017.
 */

public class StepsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    IgredientStepActivity context;
    ArrayList<Step> steps;
    boolean mTwoPane;

    public StepsAdapter(IgredientStepActivity context, ArrayList<Step> steps, boolean mTwoPane) {
        this.context = context;
        this.steps = steps;
        this.mTwoPane = mTwoPane;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.step_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.bindTo(steps.get(position), position);
    }

    @Override
    public int getItemCount() {
        return steps.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.list_step_description)
        TextView step_desc;
        @BindView(R.id.list_step_layout)
        RelativeLayout relativeLayout;

        public MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);

        }

        void bindTo(@NonNull final Step step, final int position) {
            step_desc.setText(step.getShortDescription());
            relativeLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mTwoPane) {
                        context.viewStepDetailfragment(steps, position);
                    } else {
                        Intent intent = new Intent(context, StepDetailActivity.class);
                        intent.putParcelableArrayListExtra("steps", steps);
                        intent.putExtra("position", position);
                        context.startActivity(intent);
                    }
                }
            });
        }
    }
}
