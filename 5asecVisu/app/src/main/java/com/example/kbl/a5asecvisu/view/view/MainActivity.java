package com.example.kbl.a5asecvisu.view.view;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.kbl.a5asecvisu.R;
import com.example.kbl.a5asecvisu.contract.MainContract;
import com.example.kbl.a5asecvisu.presenter.MainPresenter;
import com.example.kbl.a5asecvisu.presenter.VO.HomeVO;

import butterknife.BindView;

public class MainActivity extends AbstractActivity<MainContract.Presenter> implements MainContract.View {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.home_adress_bottom)
    LinearLayout layoutAdress;
    @BindView(R.id.home_balance_value)
    TextView balanceValue;
    @BindView(R.id.home_balance_country)
    TextView balanceContry;
    @BindView(R.id.home_balance_date)
    TextView balanceDate;
//    @BindView(R.id.home_balance_button)
//    TextView balanceDetail;
    @BindView(R.id.home_order_title)
    TextView orderTitleNumber;
    @BindView(R.id.home_order_state)
    TextView orderState;
    @BindView(R.id.home_order_date)
    TextView orderDate;
    @BindView(R.id.home_adress_detail1)
    TextView adressDetail1;
    @BindView(R.id.home_adress_detail2)
    TextView adressDetail2;
    @BindView(R.id.home_adress_detail3)
    TextView adressDetail3;
    @BindView(R.id.home_adress_detail4)
    TextView adressDetail4;
    @BindView(R.id.home_adress_open)
    TextView adressOpen;
    @BindView(R.id.home_bottom_search)
    Button searchButton;
    @BindView(R.id.home_bottom_contact)
    TextView contactButton;

    @Override
    protected void initView() {
        super.initView();
        //toolbar
        setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        getSupportActionBar().setLogo(R.drawable.toolbar_title);
        //button search
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchNextActivity();
            }
        });
        contactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchNextActivity();
            }
        });
//        balanceDetail.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                launchNextActivity();
//            }
//        });
    }

    @Override
    protected MainContract.Presenter newPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected void willAppear() {
        getPresenter().loadHome();
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        launchNextActivity();
        return true;
    }

    @Override
    public void displayHome(HomeVO homeVO) {
        balanceValue.setText(homeVO.getBalanceSolde());
        balanceContry.setText(homeVO.getBalanceCountry());
        balanceDate.setText(homeVO.getBalanceDate());
        orderTitleNumber.setText(homeVO.getOrderNumber());
        orderState.setText(homeVO.getOrderState());
        orderDate.setText(homeVO.getOrderDate());
        adressDetail1.setText(homeVO.getAdressDetail1());
        adressDetail2.setText(homeVO.getAdressDetail2());
        adressDetail3.setText(homeVO.getAdressDetail3());
        adressDetail4.setText(homeVO.getAdressDetail4());
        adressOpen.setText(homeVO.getAdressOpen());
    }

    private void launchNextActivity() {
        Intent intent = new Intent(MainActivity.this,ProfilActivity.class);
        startActivity(intent);
    }
}
