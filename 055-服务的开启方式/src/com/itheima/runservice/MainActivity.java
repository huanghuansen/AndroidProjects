package com.itheima.runservice;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

public class MainActivity extends Activity {
    private Intent intent;
    private MyServiceConn conn;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        intent = new Intent(this, MyService.class);
        conn = new MyServiceConn();
    }

    public void start(View view) {
        startService(intent);
    }

    public void stop(View view) {
        stopService(intent);
    }

    public void bind(View view) {
        // 绑定服务
        bindService(intent, conn, BIND_AUTO_CREATE);
    }

    public void unbind(View view) {
        // 解绑服务
        unbindService(conn);
    }

    public void click(View view) {
    }

    class MyServiceConn implements ServiceConnection {

        // 服务连接成功时，此方法调用
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {

        }

        // 服务失去链接时，此方法调用
        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    }
}
