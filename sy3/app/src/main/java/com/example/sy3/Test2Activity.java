package com.example.sy3;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.app.AlertDialog;
import android.widget.Button;
import android.widget.Toast;

public class Test2Activity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sy3_test2_);

        Button showDialogButton = findViewById(R.id.showDialog);
        showDialogButton.setOnClickListener(v -> showCustomDialog(Test2Activity.this));
        // Trigger dialog display (you can use a button or any event)
//        showCustomDialog();
    }

    private void showCustomDialog(Context context) {
        // 创建 AlertDialog.Builder 并设置自定义视图
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.sy3_test2_01, null);
        builder.setView(dialogView);

        Button cancelBtn = dialogView.findViewById(R.id.text2Cancel);
        Button signBtn=dialogView.findViewById(R.id.test2Sign);

        // 创建对话框
        AlertDialog dialog = builder.create();

        dialog.show();
        cancelBtn.setOnClickListener(v -> {
            Toast.makeText(context, "取消", Toast.LENGTH_SHORT)
                    .show();
            dialog.dismiss();
        });
        signBtn.setOnClickListener(v -> {
            Toast.makeText(context, "登录", Toast.LENGTH_SHORT)
                    .show();
            dialog.dismiss();
        });
    }
}
