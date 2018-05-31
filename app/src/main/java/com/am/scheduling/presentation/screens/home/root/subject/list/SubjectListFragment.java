package com.am.scheduling.presentation.screens.home.root.subject.list;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.am.scheduling.R;
import com.am.scheduling.presentation.abc.core.list.ListFragment;
import com.am.scheduling.presentation.abc.core.list.adapter.SimpleAdapter;
import com.am.scheduling.presentation.screens.home.root.subject.create.CreateSubjectFragment;
import com.am.scheduling.presentation.screens.home.root.subject.list.adapter.SubjectDH;
import com.am.scheduling.presentation.screens.home.root.subject.list.adapter.SubjectsAdapter;

import javax.inject.Inject;

import butterknife.BindView;


public class SubjectListFragment extends ListFragment<SubjectDH, SubjectListContract.Presenter> implements SubjectListContract.View {

    @BindView(R.id.rv_bfl_list)
    RecyclerView mRvBflList;

    public static SubjectListFragment newInstance() {
        SubjectListFragment fragment = new SubjectListFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Inject
    SubjectsAdapter mAdapter;

    @Override
    protected int getLayoutResource() {
        return R.layout.base_fragment_list;
    }

    @Override
    public void initUI() {
        getPresenter().subscribe();
    }

    @Override
    public SimpleAdapter<SubjectDH> getAdapter() {
        return mAdapter;
    }

    @Override
    public RecyclerView getRecyclerView() {
        return mRvBflList;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_add, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mi_add_ma:
                getPresenter().create();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public void startCreateScreen() {
        getNavigator().switchFragment(CreateSubjectFragment.newInstance());
    }
}

