package com.am.scheduling.presentation.abc.core.placeholder;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.am.scheduling.R;

import butterknife.BindView;

/**
 * Created by Alex Michenko
 * on 29.12.2017.
 */

public class SimpleHolder extends Holder {

    @BindView(R.id.tv_hs_message)
    TextView tvHsMessage;
    @BindView(R.id.iv_hs_image)
    ImageView ivHsImage;

    public SimpleHolder(@NonNull View content) {
        super(R.layout.holder_simple, content);
    }

    public void setIcon(@DrawableRes int drawableRes) {
        ivHsImage.setImageResource(drawableRes);
    }

    public void setText(@StringRes int stringRes) {
        tvHsMessage.setText(stringRes);
    }

    public static class Builder {

        SimpleHolder holder;

        public Builder(View content) {
            holder = new SimpleHolder(content);
        }

        public Builder setIcon(@DrawableRes int drawableRes) {
            holder.setIcon(drawableRes);
            return this;
        }

        public Builder setText(@StringRes int stringRes) {
            holder.setText(stringRes);
            return this;
        }

        public SimpleHolder build() {
            return holder;
        }
    }
}
