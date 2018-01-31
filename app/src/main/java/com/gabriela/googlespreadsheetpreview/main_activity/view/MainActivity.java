package com.gabriela.googlespreadsheetpreview.main_activity.view;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.gabriela.googlespreadsheetpreview.R;
import com.gabriela.googlespreadsheetpreview.main_activity.fragments.adapters.PagerAdapter;
import com.gabriela.googlespreadsheetpreview.main_activity.MainContract;
import com.gabriela.googlespreadsheetpreview.main_activity.fragments.view.SheetFragment;
import com.gabriela.googlespreadsheetpreview.main_activity.presenter.MainPresenterImpl;

import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainContract.MainView, MainContract.BetweenFragmentAndActivityInterface {
    @BindView(R.id.tabs)
    TabLayout tabLayout;

    @BindView(R.id.viewPager)
    ViewPager viewPager;

    private MainContract.MainPresenter presenter;
    private PagerAdapter pagerAdapter;
    private List<Fragment> fragmentList;

    int sheetNumber,position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        ButterKnife.bind(this);

        presenter = new MainPresenterImpl(this);

        tabLayout.setupWithViewPager(viewPager);
        setUpViewPager(viewPager);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

    // funkcija za postavljanje adaptera za tabove
    private void setUpViewPager(ViewPager viewPager) {
        pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(new SheetFragment(), "Sheet1");
        pagerAdapter.addFragment(new SheetFragment(), "Sheet2");
        viewPager.setAdapter(pagerAdapter);
    }


    @Override
    protected void onStart() {
        super.onStart();
        presenter.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.onStop();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void sendDataToActivity(int position, int sheetNumber) {
        this.sheetNumber = sheetNumber;
        this.position = position;
        presenter.setData(position, sheetNumber);
    }

    @Override
    public void sendData(int pos, String title, Map<String, String> cellsAndData) {
        fragmentList = getSupportFragmentManager().getFragments();

        for (Fragment fragment : fragmentList) {
            if (fragment != null) {
                int z = fragment.getArguments().getInt("position");
                SheetFragment fragment1 = (SheetFragment) fragment;
                if (z == pos) {
                    fragment1.addListToAdapter(cellsAndData);
                    break;
                }
            }
        }
    }
}
