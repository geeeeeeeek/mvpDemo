package mvp.better.com.mvpdemo.simple;

import lib.basenet.okhttp.OkHttpRequest;
import lib.basenet.request.AbsRequest;
import lib.basenet.request.AbsRequestCallBack;
import lib.basenet.response.Response;
import mvp.better.com.mvpdemo.mvp.LoadDataCallback;

/**
 * M 类
 * Created by zhaoyu1 on 2017/5/17.
 */
public class SimpleRepo implements SimpleContract.Repo {

    private AbsRequest mHttpRequest;

    @Override
    public void getData(final String url, final LoadDataCallback<String> callback) {
        mHttpRequest = new OkHttpRequest.Builder().url(url).callback(new AbsRequestCallBack<String>() {
            @Override
            public void onSuccess(Response<String> response) {
                super.onSuccess(response);
                callback.onDataLoaded(response.responseBody);
            }

            @Override
            public void onFailure(Throwable e) {
                super.onFailure(e);
                callback.onDataNotAvailable(e.toString(), 0);
            }
        }).tag(SimpleRepo.this).build();
        mHttpRequest.request();
    }

    @Override
    public void onDestroy() {
        // 销毁网络请求
        if (mHttpRequest != null) {
            mHttpRequest.cancel();
        }
    }
}
