// Generated code from Butter Knife. Do not modify!
package com.example.kbl.githubappcopy.view.viewHolder;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.kbl.githubappcopy.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class GitViewHolder_ViewBinding implements Unbinder {
  private GitViewHolder target;

  @UiThread
  public GitViewHolder_ViewBinding(GitViewHolder target, View source) {
    this.target = target;

    target.name = Utils.findRequiredViewAsType(source, R.id.name, "field 'name'", TextView.class);
    target.fullName = Utils.findRequiredViewAsType(source, R.id.path, "field 'fullName'", TextView.class);
    target.watchers = Utils.findRequiredViewAsType(source, R.id.watchers, "field 'watchers'", TextView.class);
    target.language = Utils.findRequiredViewAsType(source, R.id.language, "field 'language'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    GitViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.name = null;
    target.fullName = null;
    target.watchers = null;
    target.language = null;
  }
}
