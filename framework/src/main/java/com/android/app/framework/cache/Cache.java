package com.android.app.framework.cache;

import com.android.app.framework.controller.ChildSystem;

/**
 * ���ػ���(���仺�����)
 * Created by frodo on 2015/6/20.
 */
public interface Cache extends ChildSystem {
    String getCacheDir();

    void setCacheDir(String dir);

    /**
     * ������ ���ݿ�
     */
    boolean existCacheInDatabase(String sql);

    <T> T findCacheFromDatabase(String sql);

    /**
     * ������ Ӧ���ڲ�����
     */
    boolean existCacheInApplication(String key);

    <T> T findCacheFromApplication(String key);

    /**
     * ������ ����
     */
    boolean existCacheInLocal(String fileName);

    <F> F findCacheFromLocal(String fileName);
}
