package com.android.app.framework.command;

/**
 * CMD��Ҫ����������view������ÿһ�ε������� <br>
 * ÿһ�εĶ�����ɺ��ٽ������߼�ת�뵽IView��IPresenter<br>
 * ʵ�ʺ����߼���IModel���ӹܣ�ͬʱIModel����Ҫ��ȫ������ͨ��MainController����ȡ<br>
 *
 * @author frodoking
 * @date 2014-11-10 11:59:53
 */
public interface ICommand {

    String getName();

    void execute();

    void setCancel(boolean isCancel);

    boolean isCancel();
}
