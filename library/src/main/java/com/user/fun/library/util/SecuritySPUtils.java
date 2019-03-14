package com.user.fun.library.util;

/**
 * Created on 2017/7/17.
 * author chen_ping
 * Email yy_cping@163.com
 * Edit androidStudio
 * 通过加密的sharereference
 */

public class SecuritySPUtils {

    // 存储加密数据
    public void putString(String key, String value) {
        SPUtils.getInstance().putString(key, value);
    }

    public String getString(String key, String def) {
        return SPUtils.getInstance().getString(key, def);
    }

    public void putInt(String key, int value) {
        SPUtils.getInstance().putInt(key, value);
    }

    public int getInt(String key, int def) {
        return SPUtils.getInstance().getInt(key, def);
    }

    public void putLong(String key, long value) {
        SPUtils.getInstance().putLong(key, value);
    }

    public long getLong(String key, long def) {
        return SPUtils.getInstance().getLong(key, def);
    }

    public void putBoolean(String key, boolean value) {
        SPUtils.getInstance().putBoolean(key, value);
    }

    public boolean getBoolean(String key) {
        return SPUtils.getInstance().getBoolean(key);
    }
}
