package com.am.scheduling.presentation.abc.core.list.pager;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex Michenko
 * on 22.05.2018.
 */
public abstract class ListPagerAdapter<DH extends PagerDH> extends PagerAdapter {


    protected List<DH> items = new ArrayList<>();

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public void setItems(List<DH> items) {
        this.items.clear();
        addItems(items);
    }

    public void addItems(List<DH> items) {
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    public List<DH> getItems() {
        return items;
    }

    @Nullable
    public DH getItem(int position) {
        if (position < 0 || position >= items.size())
            return null;
        else
            return items.get(position);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(((PagerVH) object).itemView);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        DH dh = items.get(position);
        int viewType = dh.getViewType();
        PagerVH vh = createViewHolder(container, viewType);
        vh.position = position;
        vh.viewType = viewType;
        vh.bindData(dh);
        container.addView(vh.itemView);
        return vh;
    }

    private PagerVH<DH> createViewHolder(@NonNull ViewGroup container, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        return onCreateViewHolder(inflater, container, viewType);
    }

    protected abstract PagerVH<DH> onCreateViewHolder(LayoutInflater inflater, @NonNull ViewGroup container, int viewType);


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        PagerVH vh = ((PagerVH) object);
        container.removeView(vh.itemView);
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }
}
