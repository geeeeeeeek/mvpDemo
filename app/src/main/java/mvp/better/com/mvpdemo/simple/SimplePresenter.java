package mvp.better.com.mvpdemo.simple;

import mvp.better.com.mvpdemo.mvp.AbsMVPPresenter;
import mvp.better.com.mvpdemo.mvp.LoadDataCallback;

/**
 * Created by zhaoyu1 on 2017/5/17.
 */

public class SimplePresenter extends AbsMVPPresenter<SimpleContract.View> implements SimpleContract.Presenter {
    /**
     * 接口
     */
    SimpleContract.Repo mRepo;

    /**
     * 也可以在 V 层中传入M，这里没这样做，各有各的好处
     *
     * @param view
     */
    public SimplePresenter(SimpleContract.View view) {
        super(view);
        mRepo = new SimpleRepo();
    }

    @Override
    public void onCreate() {
    }

    @Override
    public void doGetData(String url) {
        if (!isAlive()) return;
        final SimpleContract.View view = mViewRef.get();

        // P 中操作 V
        view.showLoading("加载中...");

        mRepo.getData(url, new LoadDataCallback<String>() {
            @Override
            public void onDataLoaded(String data) {
                if (isAlive()) {
                    view.removeLoading();
                    view.showContent(data);
                }
            }

            @Override
            public void onDataNotAvailable(String msg, int code) {
                if (isAlive()) {
                    view.removeLoading();
                    view.showError(msg);
                }
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mRepo != null) {
            mRepo.onDestroy();
        }
    }
}
