package mvp.better.com.mvpdemo.simple;

import mvp.better.com.mvpdemo.mvp.IMVPPresenter;
import mvp.better.com.mvpdemo.mvp.IMVPRepo;
import mvp.better.com.mvpdemo.mvp.IMVPView;
import mvp.better.com.mvpdemo.mvp.LoadDataCallback;

/**
 * Created by zhaoyu1 on 2017/5/17.
 */
public interface SimpleContract {
    interface View extends IMVPView {
        void showContent(String data);
    }

    interface Presenter extends IMVPPresenter {
        void doGetData(String url);
    }

    interface Repo extends IMVPRepo {
        void getData(String url, final LoadDataCallback<String> callback);
    }
}
