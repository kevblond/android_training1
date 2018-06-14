package com.example.kbl.a5asecvisu.view.view;


import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Spinner;

import com.example.kbl.a5asecvisu.R;
import com.example.kbl.a5asecvisu.contract.ProfilContract;
import com.example.kbl.a5asecvisu.presenter.ProfilPresenter;
import com.example.kbl.a5asecvisu.presenter.VO.AlertVO;
import com.example.kbl.a5asecvisu.view.adapter.ProfilAlerteAdapter;
import com.example.kbl.a5asecvisu.view.view.divider.DividerAlerte;

import java.util.List;

import butterknife.BindView;

public class ProfilActivity extends AbstractActivity<ProfilContract.Presenter> implements ProfilContract.View {

    @BindView(R.id.profil_alerte)
    RecyclerView recyclerView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.profil_all_alerte)
    SwitchCompat switchCompat;
    @BindView(R.id.profil_spinner)
    Spinner spinner;
    @BindView(R.id.profil_button)
    Button buttonTerminate;

    private RecyclerView.LayoutManager layoutManager;
    private ProfilAlerteAdapter profilAlerteAdapter;

    @Override
    protected void initView() {
        super.initView();
        //toolbar
        setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setTitle(R.string.profil_title);
        }

        recyclerView.addItemDecoration(new DividerAlerte(Color.BLACK,1,true,true));
        recyclerView.setNestedScrollingEnabled(false);

        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        profilAlerteAdapter = new ProfilAlerteAdapter();
        recyclerView.setAdapter(profilAlerteAdapter);

        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    profilAlerteAdapter.checkAllData();
                } else{
                    profilAlerteAdapter.uncheckAllData();
                }
            }
        });

        ArrayAdapter<CharSequence> notificationAdapter = ArrayAdapter.createFromResource(this,R.array.notification_array,android.R.layout.simple_spinner_item);
        notificationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(notificationAdapter);

        buttonTerminate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchNextActivity();
            }
        });
    }

    @Override
    protected ProfilContract.Presenter newPresenter() {
        return new ProfilPresenter(this);
    }

    @Override
    protected void willAppear() {
        getPresenter().loadProfil();
    }

    @Override
    protected int getContentView() {
        return R.layout.profil_activity;
    }

    @Override
    public void displayProfil(List<AlertVO> alerteVO) {
        profilAlerteAdapter.setData(alerteVO);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_profil,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        launchNextActivity();
        return true;
    }
    private void launchNextActivity() {
        Intent intent = new Intent(ProfilActivity.this,HistoryActivity.class);
        startActivity(intent);
    }
}
