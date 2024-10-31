package com.example.sy3;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test4Activity extends AppCompatActivity {

    private List<Map<String, Object>> list;
    private ListView listView;
    private ActionMode actionMode;
    private int selectedPosition = -1;
    private int selectCount=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sy3_test4_01);
        listView = (ListView) findViewById(R.id.test4List);
        initDataList();
        String[] from = { "name", "img"};
        // 列表项组件Id 数组
        int[] to = { R.id.animal,R.id.avatar };

        final SimpleAdapter adapter = new SimpleAdapter(this, list,
                R.layout.sy3_test4_02, from, to);

        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                showAllCheckBoxes();
                for (int i = 0; i < listView.getChildCount(); i++) {
                    View view1 = listView.getChildAt(i);
                    CheckBox checkBox = view1.findViewById(R.id.selectBox);
                    checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
                        updateActionModeTitle(isChecked);
                    });
                }

                if (actionMode == null) {
                    actionMode = startActionMode(actionModeCallback);
                }
                return true; // 返回true表示事件已处理
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
    private void updateActionModeTitle(Boolean isChecked) {
        if (actionMode != null) {
           if(isChecked){
               selectCount++;
           }else{
               if(selectCount==0) return;
               selectCount--;
           }
            actionMode.setTitle(selectCount + " selected");
        }
    }

    private void showAllCheckBoxes() {
        for (int i = 0; i < listView.getChildCount(); i++) {
            View view = listView.getChildAt(i);
            CheckBox checkBox = view.findViewById(R.id.selectBox);
            checkBox.setVisibility(View.VISIBLE); // 显示复选框
        }
    }
    private void hidAllCheckBoxes() {
        for (int i = 0; i < listView.getChildCount(); i++) {
            View view = listView.getChildAt(i);
            CheckBox checkBox = view.findViewById(R.id.selectBox);
            checkBox.setChecked(false);
            checkBox.setVisibility(View.GONE);
        }
    }

    private final ActionMode.Callback actionModeCallback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            mode.getMenuInflater().inflate(R.menu.sy3_test4_menu, menu);
            mode.setTitle(selectCount+"selected");

            View view = mode.getCustomView();
//            view.setBackgroundColor(Color.rgb(0,46,62));

            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
//            if(item.getItemId()==R.id.action_edit){
//                mode.finish();
//                return true;
//            }
            if(item.getItemId()==R.id.action_delete){
                mode.finish();
                hidAllCheckBoxes();
                selectCount=0;
                return true;
            }
            return true;


        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            actionMode = null;
            hidAllCheckBoxes();
            selectedPosition = -1;
        }
    };




}
