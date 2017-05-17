package mvp.better.com.mvpdemo.mvp;

/**
 * MVP层中P层顶层抽象
 */
public interface IMVPPresenter {
    /**
     * 加载填充界面需要的数据
     */
    void onCreate();

    /**
     * <ol>
     *     <li>释放View</li>
     *     <li>释放Model</li>
     *     <li>释放其他资源</li>
     * </ol>
     */
    void onDestroy();
}
