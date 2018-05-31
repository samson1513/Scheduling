package com.am.scheduling.presentation.abc.core.list.adapter;

import android.support.annotation.LayoutRes;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.ArrayList;

/**
 * Created by Roman Saldan on 4/6/2018.
 */
public abstract class SimpleAdapter<DH extends MultiItemEntity> extends BaseMultiItemQuickAdapter<DH, BaseViewHolder> {

    private SparseIntArray layouts;
    private SparseArray<DelegateVH<?>> delegates;
    private ViewTypeBuilder builder;

    protected abstract void initViewTypes(ViewTypeBuilder builder);

    public SimpleAdapter() {
        super(new ArrayList<>());
        layouts = new SparseIntArray();
        delegates = new SparseArray<>();
        builder = new ViewTypeBuilder();

        initViewTypes(builder);
    }

    @Override
    protected BaseViewHolder onCreateDefViewHolder(ViewGroup parent, int viewType) {
        BaseViewHolder holder = delegates.get(viewType).createVH(getItemView(layouts.get(viewType),parent));
        bindChildViewClickListener(holder);
        return holder;
    }

    private void bindChildViewClickListener(final BaseViewHolder baseViewHolder) {
        if (baseViewHolder == null) {
            return;
        }
        final View view = baseViewHolder.itemView;
        if (view == null) {
            return;
        }
        if (getOnItemChildClickListener() != null && baseViewHolder instanceof ChildClickable) {
            ((ChildClickable) baseViewHolder).setOnChildClickListener();
        }
        if (getOnItemChildLongClickListener() != null && baseViewHolder instanceof ChildLongClickable) {
            ((ChildLongClickable) baseViewHolder).setOnChildLongClickListener();
        }
    }

    @Override
    protected void convert(BaseViewHolder helper, DH item) {
        delegates.get(item.getItemType()).bindDH(helper, item);
    }

    public class ViewTypeBuilder {
        public ViewTypeBuilder addViewType(int type, @LayoutRes int layoutRes, DelegateVH<?> delegateVH) {
            layouts.put(type, layoutRes);
            delegates.put(type, delegateVH);
            return this;
        }
    }
}
