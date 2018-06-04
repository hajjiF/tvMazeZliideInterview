package com.example.farouk.tvmazeforzliide.view.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;

import com.example.farouk.tvmazeforzliide.R;
import com.example.farouk.tvmazeforzliide.model.entity.Show;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by farouk on 03/06/2018.
 */

public class ShowsGridAdapter extends ArrayAdapter<Show> {
    private LayoutInflater inflater;
    private Context context;
    public List<Show> originalData = null;
    public List<Show> filteredData = null;
    private ItemFilter mFilter = new ItemFilter();

    public ShowsGridAdapter(Context context, List<Show> objects) {
        super(context, R.layout.one_show_grid_item, objects);
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context = context;
        this.originalData = objects;
        this.filteredData = objects;
    }

    static class ViewHolder {
        public ImageView image;
    }

    public int getCount() {
        return filteredData.size();
    }

    public Show getItem(int position) {
        return filteredData.get(position);
    }

    public Filter getFilter() {
        return mFilter;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder = new ViewHolder();
        convertView = inflater.inflate(R.layout.one_show_grid_item, parent, false);
        try {
            holder.image = convertView.findViewById(R.id.imageViewOneShowGrid);
        } catch (ClassCastException e) {
            throw e;
        }
        Picasso.with(context).load(filteredData.get(position).getImage().getMedium()).into(holder.image);
        return convertView;
    }

    private class ItemFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            String filterString = constraint.toString().toLowerCase();
            FilterResults results = new FilterResults();
            final List<Show> list = originalData;
            int count = list.size();
            final ArrayList<Show> nlist = new ArrayList<Show>(count);
            String filterableString;
            for (int i = 0; i < count; i++) {
                filterableString = list.get(i).getName();
                if (filterableString.toLowerCase().contains(filterString)) {
                    nlist.add(list.get(i));
                }
            }
            results.values = nlist;
            results.count = nlist.size();
            return results;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            filteredData = (ArrayList<Show>) results.values;
            notifyDataSetChanged();
        }

    }
}
