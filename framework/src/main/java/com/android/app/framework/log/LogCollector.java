package com.android.app.framework.log;

import com.android.app.framework.controller.ChildSystem;

/**
 * ����־������
 * Created by frodo on 2015/6/20.
 */
public interface LogCollector extends ChildSystem {
    boolean log(String tag, String msg, int logType);

    /**
     * Register crash handler to handle exception.
     */
    boolean registerCrashHandler();

    /**
     * Unregister crash handler to handle exception.
     */
    boolean unregisterCrashHandler();

    /**
     * Register Object into the stack.
     */
    boolean register(final Object activity);

    /**
     * Unregister Object into the stack.
     */
    boolean unregister(final Object activity);
}
