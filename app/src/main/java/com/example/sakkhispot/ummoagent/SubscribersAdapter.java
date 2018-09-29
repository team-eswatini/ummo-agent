package com.example.sakkhispot.ummoagent;

import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.amulyakhare.textdrawable.TextDrawable;

import java.util.List;

public class SubscribersAdapter extends RecyclerView.Adapter<SubscribersAdapter.ViewHolder> {


    private List<Subscribers> filterList;
    private Context context;

    public SubscribersAdapter(List<Subscribers> filterModelList) {
        filterList = filterModelList;
    }

    @Override
    public SubscribersAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                                          int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.subscribers_list, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Subscribers filterM = filterList.get(position);
        holder.subscriberName.setText(filterM.subscriberName);
       /* if (filterM.isSelection()) {
            holder.selectionState.setChecked(true);
        } else {
            holder.selectionState.setChecked(false);
        }*/
        TextDrawable drawable = TextDrawable.builder()
                .buildRound(filterM.subscriberName.substring(0, 1), Color.RED);

        holder.initialsIcon.setImageDrawable(drawable);

    }
    @Override
    public int getItemCount() {
        return filterList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView subscriberName;
        public CheckBox selectionState;
        public ImageView initialsIcon;

        public ViewHolder(View view) {
            super(view);
            subscriberName = (TextView) view.findViewById(R.id.subscriber_name);
            selectionState = (CheckBox) view.findViewById(R.id.subscriber_select);
            initialsIcon = (ImageView) view.findViewById(R.id.initials_view);

            //item click event listener
            view.setOnClickListener(this);

            //checkbox click event handling
            selectionState.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView,
                                             boolean isChecked) {
                    if (isChecked) {

                    } else {

                    }
                }
            });
        }

        @Override
        public void onClick(View v) {
            TextView brndName = (TextView) v.findViewById(R.id.subscriber_name);
            //show more information about brand
        }
    }

}
