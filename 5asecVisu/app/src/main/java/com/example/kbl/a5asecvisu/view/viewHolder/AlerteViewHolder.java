package com.example.kbl.a5asecvisu.view.viewHolder;

import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kbl.a5asecvisu.R;
import com.example.kbl.a5asecvisu.presenter.VO.AlertVO;
import com.example.kbl.a5asecvisu.utils.RessourceUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AlerteViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.alerte_image)
    ImageView imageView;
    @BindView(R.id.alerte_entitled)
    TextView textView;
    @BindView(R.id.alerte_checkbox)
    CheckBox checkBox;

    private AlertVO alerteVO;

    private int reducSizeForBold = 2;

    public AlerteViewHolder(View v) {
        super(v);
        ButterKnife.bind(this, v);
    }

    public void bindItem(final AlertVO alertVO) {

        this.alerteVO = alertVO;

        textView.setTypeface(alerteVO.isCheckbox()?Typeface.DEFAULT_BOLD:Typeface.DEFAULT);
        int size = alerteVO.isCheckbox()?(int)RessourceUtils.getDimen(R.dimen.profil_title)-reducSizeForBold:(int)RessourceUtils.getDimen(R.dimen.profil_title);

        SpannableString ss1 = new SpannableString(alerteVO.getAlerte());
        ss1.setSpan(new AbsoluteSizeSpan(size), 0, alerteVO.getAlerte().length(), 0);

        textView.setText(ss1);

        checkBox.setChecked(alertVO.isCheckbox());
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                textView.setTypeface(isChecked?Typeface.DEFAULT_BOLD:Typeface.DEFAULT);
                int size = isChecked?(int)RessourceUtils.getDimen(R.dimen.profil_title)-reducSizeForBold:(int)RessourceUtils.getDimen(R.dimen.profil_title);


                SpannableString ss1 = new SpannableString(alerteVO.getAlerte());
                ss1.setSpan(new AbsoluteSizeSpan(size), 0, alerteVO.getAlerte().length(), 0);

                textView.setText(ss1);
            }
        });

//        Typeface typeface = alertVO.isCheckbox()?Typeface.DEFAULT_BOLD:Typeface.DEFAULT;
//
//        textView.setText(alertVO.getAlerte());
//        textView.setTypeface(typeface);
//        checkBox.setChecked(alertVO.isCheckbox());
//
//        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                Typeface typeface = isChecked?Typeface.DEFAULT_BOLD:Typeface.DEFAULT;
//                textView.setTypeface(typeface);
//            }
//        });
    }


}
