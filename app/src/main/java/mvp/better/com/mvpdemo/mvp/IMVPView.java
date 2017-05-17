package mvp.better.com.mvpdemo.mvp;

import android.content.Context;

/**
 * MVP中View层抽象接口
 */

public interface IMVPView {
    /**
     * 加载填充界面数据时显示加载进度
     *
     * @param msg 提示文字。传null时显示默认
     */
    void showLoading(String msg);

    /**
     * M层获取数据失败
     *
     * @param msg 提示文字。传null时显示默认
     */
    void showError(String msg);

    void removeLoading();
    /**
     * 获取Context对象
     */
    Context getContext();
}
