package mvp.better.com.mvpdemo.mvp;

import android.os.Bundle;

import java.lang.ref.WeakReference;

/**
 * MVP层中P层抽象类
 */
public abstract class AbsMVPPresenter<T extends IMVPView> implements IMVPPresenter {

    protected WeakReference<T> mViewRef;

    /**
     * 必要的构造方法
     * 可以在构造方法中创建对应的Model
     *
     * @param view : 绑定对应的View
     */
    public AbsMVPPresenter(T view) {
        this.mViewRef = new WeakReference<>(view);
    }

    /**
     * 界面恢复时，调用该方法通过M层恢复数据。不需要的界面不要重写
     * 此方法为扩展，界面恢复时的处理，目前暂没想好放在哪里，这里留一个入口
     *
     * @param bundle 恢复数据时需要的参数
     */
    public void restore(Bundle bundle) {
        //empty
    }

    /**
     * view 是否存活
     *
     * @return
     */
    protected boolean isAlive() {
        return mViewRef != null && mViewRef.get() != null && mViewRef.get().getContext() != null;
    }

    @Override
    public void onDestroy() {
        if (null != mViewRef) {
            mViewRef.clear();
            mViewRef = null;
        }
    }
}
