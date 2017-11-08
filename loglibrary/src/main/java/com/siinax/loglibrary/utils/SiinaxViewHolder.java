package com.siinax.loglibrary.utils;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class SiinaxViewHolder {

    public final View convertView;
    private SparseArray<View> cache = new SparseArray<>();

    private SiinaxViewHolder(View convertView) {
        this.convertView = convertView;
    }

    public static SiinaxViewHolder createSiinaxVH(View convertView, ViewGroup viewGroup, int resId) {
        SiinaxViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(viewGroup.getContext()).inflate(resId, viewGroup, false);
            holder = new SiinaxViewHolder(convertView);
            convertView.setTag(holder);
        }
        holder = (SiinaxViewHolder) convertView.getTag();
        return holder;
    }

    public void putView(int id, View view ){
        cache.put(id, view);
    }

    public View getView(int id){
        if (cache.get(id) == null) {
            putView(id, convertView.findViewById(id));
        }
        return cache.get(id);
    }

    public TextView getTV(int id){
        return (TextView) getView(id);
    }

    public ImageView getIV(int id){
        return (ImageView) getView(id);
    }
}