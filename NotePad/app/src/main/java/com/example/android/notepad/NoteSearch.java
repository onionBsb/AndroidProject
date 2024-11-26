package com.example.android.notepad;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class NoteSearch extends Activity {
    private EditText editText;
    private TextView cancelButton;
    private ImageView searchBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 设置布局文件
        setContentView(R.layout.note_search); // 确保这里是你创建的布局文件的正确名称

        // 获取控件实例
        editText = (EditText) findViewById(R.id.note_search);
        cancelButton = (TextView) findViewById(R.id.note_cancel);
        searchBtn =(ImageView) findViewById(R.id.search_logo);
        editText.requestFocus();
//         设置取消按钮的点击事件
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 清空搜索框内容
                editText.setText("");
                Intent intent = new Intent(NoteSearch.this,NotesList.class);
                startActivity(intent);
                finish();
            }
        });

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 清空搜索框内容
                Intent intent = new Intent(NoteSearch.this,NotesList.class);
                intent.putExtra("keywords", editText.getText().toString());
                startActivity(intent);
                editText.setText("");
                finish();
            }
        });
    }


}
