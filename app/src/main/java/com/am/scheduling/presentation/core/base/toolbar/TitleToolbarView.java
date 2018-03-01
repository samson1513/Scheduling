package com.am.scheduling.presentation.core.base.toolbar;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.am.scheduling.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Alex Michenko
 * on 20.02.2018.
 */

public class TitleToolbarView implements ToolbarView {

    @BindView(R.id.tv_tt_subtitle)
    TextView mTvTtSubtitle;
    @BindView(R.id.tv_tt_title)
    TextView mTvTtTitle;
    private Unbinder unbinder;

    @Override
    public void onCreateView(LayoutInflater inflater, ViewGroup parent, ViewGroup container) {
        View view = inflater.inflate(R.layout.toolbar_title, null);
        unbinder = ButterKnife.bind(this, view);

        container.addView(view, container.getChildCount());
    }

    @Override
    public void setTitle(int resId) {
        mTvTtTitle.setText(resId);
    }

    @Override
    public void setTitle(String title) {
        mTvTtTitle.setText(title);
    }

    @Override
    public void setSubtitle(int resId) {
        setSubtitle(mTvTtTitle.getContext().getString(resId));
    }

    @Override
    public void setSubtitle(String subtitle) {
        if (TextUtils.isEmpty(subtitle)) {
            mTvTtSubtitle.setVisibility(View.GONE);
        } else {
            mTvTtSubtitle.setVisibility(View.VISIBLE);
            mTvTtSubtitle.setText(subtitle);
        }
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
    }
}
