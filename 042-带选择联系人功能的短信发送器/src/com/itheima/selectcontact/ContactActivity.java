package com.itheima.selectcontact;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Author: 王俊超
 * Date: 2015-10-09
 * Time: 11:47
 * Declaration: All Rights Reserved !!!
 */
public class ContactActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact);

        ListView lv = (ListView) findViewById(R.id.lv);

        //虚构几个联系人
        final String[] objects = {"芙蓉姐姐", "位争的芙蓉姐姐", "芙蓉姐姐的们争", "福尔马林"};
        lv.setAdapter(new ArrayAdapter<String>(this, R.layout.item_contact, R.id.tv, objects));

        // 对ListView条目进行点击侦听
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // i：用户点击了哪个条目
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent data = new Intent();
                // 把要传递的数据封闭至Intent对象
                data.putExtra("name", objects[i]);
                // 此Activity一旦销毁，这个data就会传递到此Activity的调用者
                setResult(0, data);
                finish();
            }
        });
    }
}
