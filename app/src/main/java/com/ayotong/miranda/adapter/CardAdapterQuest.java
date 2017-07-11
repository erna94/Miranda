package com.ayotong.miranda.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.TextView;

import com.ayotong.miranda.R;
import com.ayotong.miranda.app.Home_fragment;
import com.ayotong.miranda.model.Quest;

import java.util.ArrayList;
import java.util.List;

public class CardAdapterQuest extends RecyclerView.Adapter<CardAdapterQuest.ViewHolder> {

    private Context context;
    private List<Quest> items;


    public CardAdapterQuest(Context context) {
        this.context = context;
        this.items = new ArrayList<>();
    }

    public void setItems(List<Quest> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView txtJam;
        private TextView txtXP;
        private TextView txtQuest;
        ImageButton accomplish;
        ImageButton dismiss;

        public ViewHolder(View itemView) {
            super(itemView);

            this.txtJam = (TextView)itemView.findViewById(R.id.txtJam);
            this.txtXP = (TextView)itemView.findViewById(R.id.txtXP);
            this.txtQuest = (TextView)itemView.findViewById(R.id.txtQuest);
            accomplish = (ImageButton)itemView.findViewById(R.id.id_accomplish);
            dismiss= (ImageButton)itemView.findViewById(R.id.id_dissmiss);

            dismiss.setOnClickListener(this);
            accomplish.setOnClickListener(this);
        }

        public void bind(Quest quest) {
            this.txtJam.setText(quest.getJam());
            this.txtXP.setText(quest.getXp());
            this.txtQuest.setText(quest.getQuest());
        }

        @Override
        public void onClick(View view) {

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View cardView = LayoutInflater.from(this.context).inflate(R.layout.carousel_home, parent, false);
        return new ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.bind(this.items.get(position));

        holder.dismiss.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
//                Quest itemLabel = items.get(position);
                items.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position,items.size());
            }
        });

        holder.accomplish.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                items.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position,items.size());
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}