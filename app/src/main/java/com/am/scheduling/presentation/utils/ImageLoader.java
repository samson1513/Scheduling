package com.am.scheduling.presentation.utils;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.DrawableRes;
import android.widget.ImageView;

import com.am.scheduling.di.modules.GlideApp;
import com.am.scheduling.di.modules.GlideRequest;


/**
 * Created by Alex Michenko
 * on 07.02.2018.
 */

public final class ImageLoader {

    private ImageLoader() {
    }

    public static GlideRequest<Drawable> request(Uri uri, ImageView imageView, @DrawableRes int placeholderRes) {
        return GlideApp.with(imageView)
                .load(uri)
                .placeholder(placeholderRes)
                .error(placeholderRes);
    }
}
