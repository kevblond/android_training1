// Generated code from Butter Knife. Do not modify!
package com.example.kbl.a5asecvisu.view.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.kbl.a5asecvisu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(MainActivity target, View source) {
    this.target = target;

    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.layoutAdress = Utils.findRequiredViewAsType(source, R.id.home_adress_bottom, "field 'layoutAdress'", LinearLayout.class);
    target.balanceValue = Utils.findRequiredViewAsType(source, R.id.home_balance_value, "field 'balanceValue'", TextView.class);
    target.balanceContry = Utils.findRequiredViewAsType(source, R.id.home_balance_country, "field 'balanceContry'", TextView.class);
    target.balanceDate = Utils.findRequiredViewAsType(source, R.id.home_balance_date, "field 'balanceDate'", TextView.class);
    target.orderTitleNumber = Utils.findRequiredViewAsType(source, R.id.home_order_title, "field 'orderTitleNumber'", TextView.class);
    target.orderState = Utils.findRequiredViewAsType(source, R.id.home_order_state, "field 'orderState'", TextView.class);
    target.orderDate = Utils.findRequiredViewAsType(source, R.id.home_order_date, "field 'orderDate'", TextView.class);
    target.adressDetail1 = Utils.findRequiredViewAsType(source, R.id.home_adress_detail1, "field 'adressDetail1'", TextView.class);
    target.adressDetail2 = Utils.findRequiredViewAsType(source, R.id.home_adress_detail2, "field 'adressDetail2'", TextView.class);
    target.adressDetail3 = Utils.findRequiredViewAsType(source, R.id.home_adress_detail3, "field 'adressDetail3'", TextView.class);
    target.adressDetail4 = Utils.findRequiredViewAsType(source, R.id.home_adress_detail4, "field 'adressDetail4'", TextView.class);
    target.adressOpen = Utils.findRequiredViewAsType(source, R.id.home_adress_open, "field 'adressOpen'", TextView.class);
    target.searchButton = Utils.findRequiredViewAsType(source, R.id.home_bottom_search, "field 'searchButton'", Button.class);
    target.contactButton = Utils.findRequiredViewAsType(source, R.id.home_bottom_contact, "field 'contactButton'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.toolbar = null;
    target.layoutAdress = null;
    target.balanceValue = null;
    target.balanceContry = null;
    target.balanceDate = null;
    target.orderTitleNumber = null;
    target.orderState = null;
    target.orderDate = null;
    target.adressDetail1 = null;
    target.adressDetail2 = null;
    target.adressDetail3 = null;
    target.adressDetail4 = null;
    target.adressOpen = null;
    target.searchButton = null;
    target.contactButton = null;
  }
}
