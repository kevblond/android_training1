// Generated code from Butter Knife. Do not modify!
package com.example.kbl.a5asecvisu.view.viewHolder;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.kbl.a5asecvisu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HistoryDetailViewHolder_ViewBinding implements Unbinder {
  private HistoryDetailViewHolder target;

  @UiThread
  public HistoryDetailViewHolder_ViewBinding(HistoryDetailViewHolder target, View source) {
    this.target = target;

    target.itemDetailName = Utils.findRequiredViewAsType(source, R.id.history_item_detail_name, "field 'itemDetailName'", TextView.class);
    target.itemDetailSolde = Utils.findRequiredViewAsType(source, R.id.history_item_detail_solde, "field 'itemDetailSolde'", TextView.class);
    target.itemDetailCountry = Utils.findRequiredViewAsType(source, R.id.history_item_detail_country, "field 'itemDetailCountry'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    HistoryDetailViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.itemDetailName = null;
    target.itemDetailSolde = null;
    target.itemDetailCountry = null;
  }
}
