package com.lyl.spinnerdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String[] mItems;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.spinner1);

        mItems = new String[]{"C語言","Java","Php","Android","ios"};
        // 建立Adapter并且绑定数据源
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.item,R.id.tv, mItems);
        adapter.setDropDownViewResource(R.layout.item1);
        //绑定 Adapter到控件
        spinner .setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {

                Toast.makeText(MainActivity.this, "你点击的是:"+mItems[pos], Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });
    }

}
