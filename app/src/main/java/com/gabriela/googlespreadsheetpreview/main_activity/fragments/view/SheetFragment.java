package com.gabriela.googlespreadsheetpreview.main_activity.fragments.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.gabriela.googlespreadsheetpreview.R;
import com.gabriela.googlespreadsheetpreview.main_activity.MainContract;
import com.gabriela.googlespreadsheetpreview.main_activity.fragments.adapters.RecyclerViewAdapter;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class SheetFragment extends Fragment {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.progressBar1)
    ProgressBar progressBar;

    @BindView(R.id.swiperefresh)
    SwipeRefreshLayout swiperefresh;

    private RecyclerView.LayoutManager layoutManager;
    private RecyclerViewAdapter recyclerViewAdapter;
    private Unbinder unbinder;
    private MainContract.BetweenFragmentAndActivityInterface listener;

    int pos;

    public static SheetFragment newInstance(int position) {
        Bundle args = new Bundle();
        SheetFragment fragment = new SheetFragment();
        args.putSerializable("position", position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pos = getArguments() != null ? getArguments().getInt("position") : 1;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        unbinder = ButterKnife.bind(this, view);
        swiperefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                listener.sendDataToActivity(pos, pos + 1);
                swiperefresh.setRefreshing(false);
            }
        });
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        recyclerViewAdapter = new RecyclerViewAdapter();
        recyclerView.setAdapter(recyclerViewAdapter);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        progressBar.setVisibility(View.VISIBLE);
        listener.sendDataToActivity(pos, pos + 1);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (MainContract.BetweenFragmentAndActivityInterface) context;
    }

    public void addListToAdapter(Map<String, String> cellsAndData) {
        recyclerViewAdapter.addData(cellsAndData);
        progressBar.setVisibility(View.GONE);
    }
}
