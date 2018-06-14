// Generated code from Butter Knife. Do not modify!
package com.example.kbl.a5asecvisu.view.viewHolder;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.kbl.a5asecvisu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HistoryViewHolder_ViewBinding implements Unbinder {
  private HistoryViewHolder target;

  @UiThread
  public HistoryViewHolder_ViewBinding(HistoryViewHolder target, View source) {
    this.target = target;

    target.historyDate = Utils.findRequiredViewAsType(source, R.id.history_item_date, "field 'historyDate'", TextView.class);
    target.historyLocation = Utils.findRequiredViewAsType(source, R.id.history_item_location, "field 'historyLocation'", TextView.class);
    target.historySolde = Utils.findRequiredViewAsType(source, R.id.history_item_solde, "field 'historySolde'", TextView.class);
    target.historyCountry = Utils.findRequiredViewAsType(source, R.id.history_item_country, "field 'historyCountry'", TextView.class);
    target.imageView = Utils.findRequiredViewAsType(source, R.id.history_item_open_detail, "field 'imageView'", ImageView.class);
    target.detailLayout = Utils.findRequiredViewAsType(source, R.id.history_item_detail, "field 'detailLayout'", CardView.class);
    target.detailTicket = Utils.findRequiredViewAsType(source, R.id.history_item_detail_ticket, "field 'detailTicket'", TextView.class);
    target.detailShop = Utils.findRequiredViewAsType(source, R.id.history_item_detail_shop, "field 'detailShop'", TextView.class);
    target.recyclerViewDetail = Utils.findRequiredViewAsType(source, R.id.history_item_recyclerview, "field 'recyclerViewDetail'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    HistoryViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.historyDate = null;
    target.historyLocation = null;
    target.historySolde = null;
    target.historyCountry = null;
    target.imageView = null;
    target.detailLayout = null;
    target.detailTicket = null;
    target.detailShop = null;
    target.recyclerViewDetail = null;
  }
}
