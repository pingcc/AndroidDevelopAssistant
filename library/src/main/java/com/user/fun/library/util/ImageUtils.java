package com.user.fun.library.util;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.user.fun.library.widget.GlideRoundedCornersTransform;


/**
 * Created on 2017/7/19.
 * author chen_ping
 * Email yy_cping@163.com
 * Edit androidStudio
 */

public class ImageUtils {

    private static RequestOptions getRequestOptions() {
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.diskCacheStrategy(DiskCacheStrategy.ALL);
        return requestOptions;
    }

    /**
     * @param <T> 可以传url,id,file,uri , model
     */
    private  static <T> void loadImage(T url, ImageView image, RequestOptions requestOptions) {
        Glide.with(image.getContext())
                .load(url)
                .apply(requestOptions)
                .into(image);
    }

    public static <T> void loadImage(T url, ImageView image) {
        loadImage(url, image, getRequestOptions());
    }
    public static <T> void loadPlaceHolderImage(T url, ImageView image, int placeholderId) {
        loadPlaceHolderImage(url,image,placeholderId);
    }
    public static <T> void loadPlaceHolderImage(T url, ImageView image, int placeholderId,int errorId) {
        RequestOptions requestOptions = getRequestOptions();
        requestOptions
                .placeholder(placeholderId)
                .error(errorId);
        loadImage(url, image, requestOptions);
    }
    public static <T> void loadCircleImage(T url, ImageView image) {
        loadCircleImage(url,image,0,0);
    }
    public static <T> void loadCircleImage(T url, ImageView image,int placeholderId) {
        loadCircleImage(url,image,placeholderId,0);
    }
    public static <T> void loadCircleImage(T url, ImageView image,int placeholderId,int errorId) {
        RequestOptions requestOptions = getRequestOptions();
        requestOptions
                .placeholder(placeholderId)
                .error(errorId).circleCrop();
        loadImage(url, image, requestOptions);
    }

    public static <T> void loadRoundedCornersImage(T url, ImageView image, float radius) {

        RequestOptions requestOptions = getRequestOptions();
        requestOptions.transform(new RoundedCorners((int) (UiUtils.dp2px(radius) + 0.5f)));
        loadImage(url, image, requestOptions);
    }

    public static <T> void loadRoundedCornersImage(T url, ImageView image, float radius,
                                               GlideRoundedCornersTransform.CornerType cornerType) {
        RequestOptions requestOptions = getRequestOptions();
        requestOptions.optionalTransform(new GlideRoundedCornersTransform((int) (UiUtils.dp2px
                (radius) + 0.5f),
                cornerType));
        loadImage(url, image, requestOptions);
    }
}
