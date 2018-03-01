package com.am.scheduling.presentation.core.content.placeholder;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.am.scheduling.R;

import butterknife.BindView;

/**
 * Created by Alex Michenko
 * on 07.02.2018.
 */

public class OneButtonHolder extends Holder {

    @BindView(R.id.tv_hob_message)
    TextView tvHobMessage;
    @BindView(R.id.iv_hob_image)
    ImageView ivHobImage;
    @BindView(R.id.btn_hob_action)
    Button btnHobAction;


    public OneButtonHolder(@NonNull View content) {
        super(R.layout.holder_one_button, content);
    }

    public void setIcon(@DrawableRes int drawableRes) {
        ivHobImage.setImageResource(drawableRes);
    }

    public void setText(@StringRes int stringRes) {
        tvHobMessage.setText(stringRes);
    }

    public void setButtonText(@StringRes int textRes) {
        btnHobAction.setText(textRes);
    }

    public void setClickListener(View.OnClickListener listener) {
        btnHobAction.setOnClickListener(listener);
    }

    public static class Builder {

        OneButtonHolder holder;

        public Builder(View content) {
            holder = new OneButtonHolder(content);
        }

        public Builder setIcon(@DrawableRes int drawableRes) {
            holder.setIcon(drawableRes);
            return this;
        }

        public Builder setText(@StringRes int stringRes) {
            holder.setText(stringRes);
            return this;
        }

        public Builder setActionButton(@StringRes int textRes, View.OnClickListener listener) {
            holder.setButtonText(textRes);
            holder.setClickListener(listener);
            return this;
        }

        public OneButtonHolder build() {
            return holder;
        }
    }
}
