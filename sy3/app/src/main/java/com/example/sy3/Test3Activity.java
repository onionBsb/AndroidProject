package com.example.sy3;
import com.example.sy3.R;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Test3Activity extends AppCompatActivity {
    private TextView testTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sy3_test3_01);

        testTextView = findViewById(R.id.testword);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sy3_test3_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.test3_size_small){
            testTextView.setTextSize(10);
            return true;
        }else if(item.getItemId()==R.id.test3_size_mid){
            testTextView.setTextSize(16);
            return true;
        }else if(item.getItemId()==R.id.test3_size_big){
            testTextView.setTextSize(20);
            return true;
        }else if(item.getItemId()==R.id.test3_color_red){
            testTextView.setTextColor(Color.RED);
            return true;
        }else if(item.getItemId()==R.id.test3_color_black){
            testTextView.setTextColor(Color.BLACK);
            return true;
        }else{
            return super.onOptionsItemSelected(item);
        }

//        switch (item.getItemId()) {
//            case small:
//                testTextView.setTextSize(10);
//                return true;
//            case R.id.test3_size_mid:
//                testTextView.setTextSize(16);
//                return true;
//            case R.id.test3_size_big:
//                testTextView.setTextSize(20);
//                return true;
//            case R.id.test3_color_red:
//                testTextView.setTextColor(Color.RED);
//            case R.id.test3_color_black:
//                testTextView.setTextColor(Color.BLACK);
//                return true;
//            case R.id.test3_normal:
//                Toast.makeText(Test3Activity.this, "普通菜单", Toast.LENGTH_SHORT).show();
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
    }


}
