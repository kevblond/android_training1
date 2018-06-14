// Generated code from Butter Knife. Do not modify!
package com.example.kbl.a5asecvisu.view.viewHolder;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.kbl.a5asecvisu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AlerteViewHolder_ViewBinding implements Unbinder {
  private AlerteViewHolder target;

  @UiThread
  public AlerteViewHolder_ViewBinding(AlerteViewHolder target, View source) {
    this.target = target;

    target.imageView = Utils.findRequiredViewAsType(source, R.id.alerte_image, "field 'imageView'", ImageView.class);
    target.textView = Utils.findRequiredViewAsType(source, R.id.alerte_entitled, "field 'textView'", TextView.class);
    target.checkBox = Utils.findRequiredViewAsType(source, R.id.alerte_checkbox, "field 'checkBox'", CheckBox.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AlerteViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imageView = null;
    target.textView = null;
    target.checkBox = null;
  }
}
