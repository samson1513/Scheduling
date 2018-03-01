package com.am.scheduling.presentation.core.list;

import com.am.scheduling.presentation.core.content.ContentView;
import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * Created by Alex Michenko
 * on 07.02.2018.
 */

public interface ListView<DH extends MultiItemEntity, P extends ListPresenter> extends ContentView<P> {

    void setItems(List<DH> items);

    void addItems(List<DH> items);

    void updateItem(DH item, int position);

    void addItem(DH item);

    void addItem(DH item, int position);

    void removeItem(int position);

    void showLoadMoreError();

    void disablePagination();
}
