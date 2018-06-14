// Generated code from Butter Knife. Do not modify!
package com.example.kbl.a5asecvisu.view.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.kbl.a5asecvisu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ProfilActivity_ViewBinding implements Unbinder {
  private ProfilActivity target;

  @UiThread
  public ProfilActivity_ViewBinding(ProfilActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ProfilActivity_ViewBinding(ProfilActivity target, View source) {
    this.target = target;

    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.profil_alerte, "field 'recyclerView'", RecyclerView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.switchCompat = Utils.findRequiredViewAsType(source, R.id.profil_all_alerte, "field 'switchCompat'", SwitchCompat.class);
    target.spinner = Utils.findRequiredViewAsType(source, R.id.profil_spinner, "field 'spinner'", Spinner.class);
    target.buttonTerminate = Utils.findRequiredViewAsType(source, R.id.profil_button, "field 'buttonTerminate'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ProfilActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.recyclerView = null;
    target.toolbar = null;
    target.switchCompat = null;
    target.spinner = null;
    target.buttonTerminate = null;
  }
}
