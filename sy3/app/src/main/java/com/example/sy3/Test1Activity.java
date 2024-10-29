package com.example.sy3;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test1Activity extends Activity {
    private List<Map<String, Object>> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sy3_test1_01);
        ListView listView = (ListView) findViewById(R.id.list);
        initDataList();
//         key值数组，适配器通过key值取value，与列表项组件一一对应
        String[] from = { "name", "img"};
        // 列表项组件Id 数组
        int[] to = { R.id.animal,R.id.avatar };
//        /**
//         * SimpleAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to)
//         * context：activity界面类
//         * data 数组内容是map的集合数据
//         * resource 列表项文件
//         * from map key值数组
//         * to 列表项组件id数组      from与to一一对应，适配器绑定数据
//         */
        final SimpleAdapter adapter = new SimpleAdapter(this, list,
                R.layout.sy3_test1_02, from, to);

        listView.setAdapter(adapter);
//        /**
//         * 单击
//         */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                view.setBackgroundColor(Color.YELLOW);
                String str = list.get(position).get("name")+"被点击了";
                Toast.makeText(Test1Activity.this, str, Toast.LENGTH_SHORT)
                        .show();

            }
        });

    }

    /**
     * 初始化适配器需要的数据格式
     */
    private void initDataList() {
        //图片资源
        int[] img = {  R.drawable.lion,R.drawable.tiger,R.drawable.monkey,R.drawable.dog,R.drawable.cat,R.drawable.elephant };
        String[] str={"Lion","Tiger","Monkey","Dog","Cat","Elephant"};
        list = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < img.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("img", img[i]);
            map.put("name", str[i]);
            list.add(map);
        }

    }
}
