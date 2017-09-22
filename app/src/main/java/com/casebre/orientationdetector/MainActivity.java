package com.casebre.orientationdetector;

import android.content.pm.ActivityInfo;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Surface;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView txtMessage = (TextView) findViewById(R.id.text_view_rotation);
        final Button btnHoldRelease = (Button) findViewById(R.id.button_hold_release);

        final int rotation = getWindowManager().getDefaultDisplay().getRotation();

        btnHoldRelease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnHoldRelease.getText().toString().compareTo("Hold Orientation") == 0) {
                    setOrientation(rotation);
                    btnHoldRelease.setText("Release Orientation");
                }
                else {
                    btnHoldRelease.setText("Hold Orientation");
                     setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
                }
            }
        });
    }

    public void setOrientation(int rotation) {
        switch(rotation) {
            case Surface.ROTATION_0:
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                break;
            case Surface.ROTATION_90:
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                break;
            case Surface.ROTATION_180:
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT);
                break;
            case Surface.ROTATION_270:
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE);
                break;
        }
    }
}
