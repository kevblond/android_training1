// Generated code from Butter Knife. Do not modify!
package com.example.kbl.githubappcopy.view.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.kbl.githubappcopy.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LoginActivity_ViewBinding implements Unbinder {
  private LoginActivity target;

  @UiThread
  public LoginActivity_ViewBinding(LoginActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public LoginActivity_ViewBinding(LoginActivity target, View source) {
    this.target = target;

    target.buttonValidate = Utils.findRequiredViewAsType(source, R.id.button_validate, "field 'buttonValidate'", Button.class);
    target.searchView = Utils.findRequiredViewAsType(source, R.id.user_name, "field 'searchView'", SearchView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    LoginActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.buttonValidate = null;
    target.searchView = null;
  }
}
