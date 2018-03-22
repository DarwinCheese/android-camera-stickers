package com.example.android.camera2basic;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import static com.example.android.camera2basic.EditPictureActivity.PERM_RQST_CODE;

/**
 * Created by Darwin on 22-Mar-18.
 */

public class SplashActivity extends AppCompatActivity{

    private static final String TAG = "Splashactivity";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        makeRequest();
    }

    protected void makeRequest() {
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA},
                PERM_RQST_CODE);
    }

    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[]
                                                   grantResults) {
        switch (requestCode) {
            case PERM_RQST_CODE: {

                if (grantResults.length == 0
                        || grantResults[0] !=
                        PackageManager.PERMISSION_GRANTED) {

                    Log.i(TAG, "Permission has been denied by user");
                } else {
                    Log.i(TAG, "Permission has been granted by user");
                    // Start home activity
                    startActivity(new Intent(SplashActivity.this, CameraActivity.class));
                    // close splash activity
                    finish();
                }
                return;
            }
        }
    }
}
