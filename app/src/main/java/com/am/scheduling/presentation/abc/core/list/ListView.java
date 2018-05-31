package com.am.scheduling.presentation.abc.core.list;

import com.am.scheduling.presentation.abc.core.content.ContentView;
import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * Created by Roman Saldan on 4/6/2018.
 */
public interface ListView<DH extends MultiItemEntity> extends ContentView {
    void setItems(List<DH> items);
    void addItems(List<DH> items);
    void updateItem(DH item, int position);
    void removeItem(int position);
    void showLoadMoreError();
    void disablePagination();
}
