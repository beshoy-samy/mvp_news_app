package com.development.beshoy.taskcardview.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.development.beshoy.taskcardview.R;

/**
 * Created by bisho on 07-Sep-17.
 */

public class ImageLoadingUtils {


    private ImageLoadingUtils() {
    }

    public static void loadImageURL(Context mContext, String imageURL, ImageView imageView){

        GlideApp.with(mContext)
                .load(imageURL)
                .centerCrop()
                .placeholder(R.drawable.image_error)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .into(imageView);
    }


}
