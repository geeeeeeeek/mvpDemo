package mvp.better.com.mvpdemo.mvp;

/**
 * mvp中M层抽象接口，这里采用 Repo 仓库，参考了google mvp demo
 */
public interface IMVPRepo {
    /**
     * 1，释放P引用<br/>
     * 2,释放具体逻辑上的数据
     */
    void onDestroy();
}
