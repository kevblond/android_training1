// Generated code from Butter Knife. Do not modify!
package com.example.kbl.a5asecvisu.view.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.kbl.a5asecvisu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HistoryActivity_ViewBinding implements Unbinder {
  private HistoryActivity target;

  @UiThread
  public HistoryActivity_ViewBinding(HistoryActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public HistoryActivity_ViewBinding(HistoryActivity target, View source) {
    this.target = target;

    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.balanceValue = Utils.findRequiredViewAsType(source, R.id.home_balance_value, "field 'balanceValue'", TextView.class);
    target.balanceContry = Utils.findRequiredViewAsType(source, R.id.home_balance_country, "field 'balanceContry'", TextView.class);
    target.balanceDate = Utils.findRequiredViewAsType(source, R.id.home_balance_date, "field 'balanceDate'", TextView.class);
    target.viewPager = Utils.findRequiredViewAsType(source, R.id.history_viewpager, "field 'viewPager'", ViewPager.class);
    target.titlePager = Utils.findRequiredViewAsType(source, R.id.history_title, "field 'titlePager'", TabLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    HistoryActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.toolbar = null;
    target.balanceValue = null;
    target.balanceContry = null;
    target.balanceDate = null;
    target.viewPager = null;
    target.titlePager = null;
  }
}
