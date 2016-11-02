package com.figengungor.suits.utility;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by figengungor on 17.10.2016.
 */
public class ImageViewBindingUtils {

    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView view, String url) {
        Glide.with(view.getContext()).load(url).centerCrop().into(view);
    }

    @BindingAdapter("imageResource")
    public static void loadImage(ImageView view, int resource){
        Glide.with(view.getContext()).load(resource).into(view);
    }
}
