package com.hbl.sandbox1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hbl.sandbox1.models.Banners;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hbl on 4/3/2017.
 */

class BannerListAdapter extends RecyclerView.Adapter<BannerListAdapter.BannerViewHolder> {
    List<Banners> banner = new ArrayList<>();

    BannerListAdapter() {
    }

    void addBanners(List<Banners> list) {
        if (list != null)
            banner.addAll(list);
    }

    @Override
    public BannerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View itemView = inflater.inflate(R.layout.banner_list_item, parent, false);

        return new BannerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(BannerViewHolder holder, int position) {
        Banners b = banner.get(position);
        holder.textView1.setText("Roll no :- " + b.get0());
        holder.textView2.setText("Id :- " + b.getEntityId());
        holder.textView3.setText("Class Id :- " + b.get1());
        holder.textView4.setText("Subject :- " + b.getSku());
    }

    @Override
    public int getItemCount() {
        return banner.size();
    }

    class BannerViewHolder extends RecyclerView.ViewHolder {
        TextView textView1;
        TextView textView2;
        TextView textView3;
        TextView textView4;

        BannerViewHolder(View itemView) {
            super(itemView);
            textView1 = (TextView) itemView.findViewById(R.id.banner_item_text1);
            textView2 = (TextView) itemView.findViewById(R.id.banner_item_text2);
            textView3 = (TextView) itemView.findViewById(R.id.banner_item_text3);
            textView4 = (TextView) itemView.findViewById(R.id.banner_item_text4);
        }

    }
}
