package com.user.fun.library.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.text.TextUtils;
import android.util.Base64;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

/**
 * <p>
 * 上传图片的工具类
 */

public class UploadUtils {




    public String getPicBody(String path, long maxSize) {
        if (TextUtils.isEmpty(path)) {
            return null;
        }

        File f = new File(path);
        if (f.length() <= maxSize) {   //直接上传图片
            return Bitmap2StrByBase64(BitmapFactory.decodeFile(path, new BitmapFactory.Options()));
        } else {         //图片过大,需要压缩
            byte[] content = compressImage(path, maxSize);
            if (content == null)
                return Bitmap2StrByBase64(BitmapFactory.decodeFile(path, new BitmapFactory.Options()));
            return Bitmap2StrByBase64(BitmapFactory.decodeByteArray(content, 0, content.length));
        }
    }

    /**
     * 通过Base32将Bitmap转换成Base64字符串
     *
     * @param bit
     * @return
     */
    private String Bitmap2StrByBase64(Bitmap bit) {
        ByteArrayOutputStream bos=null;
        try {
             bos = new ByteArrayOutputStream();
            bit.compress(Bitmap.CompressFormat.JPEG, 100, bos);//参数100表示不压缩
            bos.flush();
            bos.close();
            byte[] bytes = bos.toByteArray();
            return Base64.encodeToString(bytes, Base64.NO_WRAP);
        } catch (IOException e) {
          return null;
        }finally {
            try {
                bos.flush();
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }

    /**
     * Can't compress a recycled bitmap
     *
     * @param path 图片路径
     * @return
     */
    private byte[] compressImage(String path, long maxSize) {

        if (TextUtils.isEmpty(path)) {
            return null;
        }

        //进行大小缩放来达到压缩的目的
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;
        options.inJustDecodeBounds = false;
        Bitmap scaledBitmap = null;
        try {
            scaledBitmap = BitmapFactory.decodeFile(path, options);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        }
        if (scaledBitmap == null) {
            return null;//压缩失败
        }

        //处理图片旋转问题
        ExifInterface exif = null;
        try {
            exif = new ExifInterface(path);
            int orientation = exif.getAttributeInt(
                    ExifInterface.TAG_ORIENTATION, 0);
            Matrix matrix = new Matrix();
            if (orientation == ExifInterface.ORIENTATION_ROTATE_90) {
                matrix.postRotate(90);
            } else if (orientation == ExifInterface.ORIENTATION_ROTATE_180) {
                matrix.postRotate(180);
            } else if (orientation == ExifInterface.ORIENTATION_ROTATE_270) {
                matrix.postRotate(270);
            }
            scaledBitmap = Bitmap.createBitmap(scaledBitmap, 0, 0,
                    scaledBitmap.getWidth(), scaledBitmap.getHeight(), matrix, true);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        //进行有损压缩
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int options_ = 80;
        scaledBitmap.compress(Bitmap.CompressFormat.JPEG, options_, baos);//质量压缩方法，把压缩后的数据存放到baos中 (100表示不压缩，0表示压缩到最小)

        while (baos.toByteArray().length / 1024 > maxSize && options_ > 50) {
            baos.reset();
            options_ -= 10;
            scaledBitmap.compress(Bitmap.CompressFormat.JPEG, options_, baos);
        }

        scaledBitmap.recycle();
        byte[] imgByte = baos.toByteArray();
        FileUtils.close(baos);
        return imgByte;
    }

}
