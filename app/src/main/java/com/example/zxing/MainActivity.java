package com.example.zxing;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.client.android.CaptureActivity;

public class MainActivity extends AppCompatActivity {

    Button bt_scan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_scan = findViewById(R.id.btn_scan);
        bt_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
//                intent.setAction(Intents.Scan.ACTION);
                startActivityForResult(intent,1);
            }
        });

//        Intent intent = new Intent(this, CaptureActivity.class);
//        intent.setAction(Intents.Scan.ACTION);
//        intent.putExtra(Intents.Scan.FORMATS, "QR_CODE");
//        startActivityForResult(intent, REQUEST_CODE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == REQUEST_CODE) {
//            if (data != null) {
//                String string=data.getStringExtra(Intents.Scan.RESULT);//条形码
//                Log.e("返回扫描结果",string);
//            }
//        }

        Log.e("Main","1");
        if (requestCode == 1){
            Log.e("Main","2");
            if (data != null) {
                Log.e("Main","3");
                String string = data.getStringExtra("displayContents");
                Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
            }
        }
    }

}