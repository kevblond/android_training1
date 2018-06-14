// Generated code from Butter Knife. Do not modify!
package com.example.kbl.a5asecvisu.view.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.kbl.a5asecvisu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ListPriceFragment_ViewBinding implements Unbinder {
  private ListPriceFragment target;

  @UiThread
  public ListPriceFragment_ViewBinding(ListPriceFragment target, View source) {
    this.target = target;

    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.history_price_recyclerview, "field 'recyclerView'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ListPriceFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.recyclerView = null;
  }
}
