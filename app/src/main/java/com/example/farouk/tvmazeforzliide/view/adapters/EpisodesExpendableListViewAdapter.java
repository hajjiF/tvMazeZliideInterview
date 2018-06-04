package com.example.farouk.tvmazeforzliide.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.farouk.tvmazeforzliide.R;
import com.example.farouk.tvmazeforzliide.model.entity.Episode;
import com.example.farouk.tvmazeforzliide.model.entity.Season;
import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * Created by farouk on 03/06/2018.
 */

public class EpisodesExpendableListViewAdapter extends BaseExpandableListAdapter {
    private LayoutInflater inflater;
    List<List<Episode>> episodes;
    List<Season> seasons;
    Context context;
    public EpisodesExpendableListViewAdapter(Context context, List<Season> seasons, List<List<Episode>> episodesBySeason) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context=context;
        this.episodes= episodesBySeason;
        this.seasons = seasons;
    }

    @Override
    public int getGroupCount() {
        return seasons.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return episodes.size();
    }

    @Override
    public Object getGroup(int i) {
        return seasons.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return episodes.get(i).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return seasons.get(i).getId();
    }

    @Override
    public long getChildId(int i, int i1) {
        return episodes.get(i).get(i1).getId();
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.one_season_item, viewGroup, false);
        GroupViewHolder holder = new GroupViewHolder();
        try {
            holder.seasonNum =  view.findViewById(R.id.SeasonNum);
        } catch (ClassCastException e) {
            throw e;
        }
        holder.seasonNum.setText(context.getString(R.string.season) +((Season)getGroup(i)).getNumber());
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.one_episode_item, viewGroup, false);
        ChildViewHolder holder = new ChildViewHolder();
        try {
            holder.image = view.findViewById(R.id.EpisodeImage);
            holder.episodeNum= view.findViewById(R.id.EpisodeNum);
            holder.episodeTitle= view.findViewById(R.id.EpisodeTitle);
            holder.airDate= view.findViewById(R.id.AirDate);
            holder.airTime= view.findViewById(R.id.AirTime);
            holder.network = view.findViewById(R.id.Network);

        } catch (ClassCastException e) {
            throw e;
        }
            if(episodes.get(i).get(i1).getImage()!= null) {
                Picasso.with(context).load(episodes.get(i).get(i1).getImage().getMedium()).into(holder.image);
            }
            holder.episodeNum.setText(context.getString(R.string.episode)+((Episode)getChild(i,i1)).getNumber());
            holder.episodeTitle.setText(((Episode)getChild(i,i1)).getName());
            holder.airDate.setText(((Episode)getChild(i,i1)).getAirdate());
            holder.airTime.setText(((Episode)getChild(i,i1)).getAirtime());
            holder.network.setText(seasons.get(i).getNetwork().getName());
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
    static class GroupViewHolder {
        public TextView seasonNum;
    }
    static class ChildViewHolder {
        public ImageView image;
        public TextView episodeNum;
        public TextView episodeTitle;
        public TextView airDate;
        public TextView airTime;
        public TextView network;
    }
}
