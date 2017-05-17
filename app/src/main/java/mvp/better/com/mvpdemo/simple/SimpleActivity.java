package mvp.better.com.mvpdemo.simple;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import mvp.better.com.mvpdemo.R;

public class SimpleActivity extends AppCompatActivity implements SimpleContract.View {
    private ProgressDialog mDialog;
    private TextView content;
    private SimpleContract.Presenter mPresenter;
    private EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
        content = (TextView) findViewById(R.id.content);
        et = (EditText) findViewById(R.id.et);

        // 初始化P
        mPresenter = new SimplePresenter(this);
        findViewById(R.id.request).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String url = et.getText().toString();
                content.setText("");
                mPresenter.doGetData(url);
            }
        });
    }

    @Override
    public void showLoading(String msg) {
        if (mDialog == null) {
            mDialog = new ProgressDialog(this);
        }
        mDialog.setMessage(msg);
        mDialog.show();
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void removeLoading() {
        if (mDialog != null) {
            mDialog.dismiss();
        }
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    @Override
    public void showContent(String data) {
        content.setText(data);
    }
}
