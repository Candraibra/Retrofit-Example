package com.candraibra.terserah;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<LeaguesItem> leagues;

    public Adapter(Context mContext, List<LeaguesItem> mLeague) {
        this.leagues = mLeague;
    }

    @NonNull
    @Override
    public Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout_item_rv, viewGroup, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.MyViewHolder holder, int i) {
        holder.tvLeagueName.setText(leagues.get(i).getStrLeague());
        holder.tvLeagueType.setText(leagues.get(i).getStrSport());
    }

    @Override
    public int getItemCount() {
        return leagues.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvLeagueName, tvLeagueType;

        MyViewHolder(View view) {
            super(view);
            tvLeagueName = itemView.findViewById(R.id.tvLeagueName);
            tvLeagueType = itemView.findViewById(R.id.tvLeagueType);

        }
    }
}
