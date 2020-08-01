package com.example.flashlight;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button on ,off;
    CameraManager cameraManager;
    String Cameraid;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        on=findViewById(R.id.on1);
        off=findViewById(R.id.off1);

        cameraManager= (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        try {
            Cameraid=cameraManager.getCameraIdList()[0];
        } catch (Exception e) {
            e.printStackTrace();
        }
        on.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                try {
                    cameraManager.setTorchMode(Cameraid,true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        off.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                try {
                    cameraManager.setTorchMode(Cameraid,false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
