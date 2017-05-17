package mvp.better.com.mvpdemo.mvp;


/**
 * Created by zhaoyu1 on 2016/7/11.
 */
public interface LoadDataCallback<T> {

    void onDataLoaded(T data);

    /**
     * @param msg  提示信息
     * @param code 状态编码
     */
    void onDataNotAvailable(String msg, int code);
}
