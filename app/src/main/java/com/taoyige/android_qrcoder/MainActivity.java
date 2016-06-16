package com.taoyige.android_qrcoder;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.zxing.client.android.CaptureActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void scanClick(View v){
        Intent intent = new Intent(this, CaptureActivity.class);
        startActivityForResult(intent,0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            String content = data.getStringExtra("msg");
            System.out.println("content = "+content);

            if(content.contains("http://") || content.contains("https://")){
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(content));
                startActivity(intent);
            }
        }
    }
}
