package com.android.app.core.toolbox;

import com.squareup.otto.Bus;

/**
 * ���¼������õ�������װ�����������<br>
 * Bus������UI���߳������<br>
 * ��Ҫ������������view֮�䴫�ݵĹ���<br>
 * ��ֹ������ģ��֮��Ĵ���(�������ƻ������ͨ�żܹ�)<br>
 * Created by frodo on 2015/4/20.
 */
public final class EventBus {

    private static class Holder {
        private static EventBus DEFAULT = new EventBus();
    }

    public static EventBus getDefault() {
        return Holder.DEFAULT;
    }

    private Bus bus;

    private EventBus() {
        bus = new Bus();
    }

    public void register(Object object) {
        bus.register(object);
    }

    public void unregister(Object object) {
        bus.unregister(object);
    }

    public void post(Object object) {
        bus.post(object);
    }
}
