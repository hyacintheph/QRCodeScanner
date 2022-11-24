package com.example.scanqr;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;




public class MainActivity extends Activity {
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button scanBtn = findViewById(R.id.scan);
        scanBtn.setOnClickListener(view -> scan());
    }

    private void scan(){
        IntentIntegratorScan.initiateScan(this);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch(requestCode) {
            case IntentIntegratorScan.REQUEST_CODE:
            {
                if (resultCode == RESULT_CANCELED){
                }
                else
                {
                   IntentResult intentResult = IntentIntegratorScan.parseActivityResult(requestCode, resultCode, data);

                    String UPCScanned = intentResult.getContents();
                    Toast.makeText(this, UPCScanned, Toast.LENGTH_LONG).show();
                }
                break;
            }
        }
    }
}