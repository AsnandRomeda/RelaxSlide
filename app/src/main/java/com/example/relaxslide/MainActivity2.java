package com.example.relaxslide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    MediaPlayer mPlayer;




    private final int[] mDrawablesArray = {R.drawable.neitralnoe, R.drawable.schastie, R.drawable.zlost_,
    };
    ViewFlipper mViewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        mPlayer= MediaPlayer.create(this, R.raw.happines);
        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
           //     stopPlay();
            }
        });
        mPlayer.start();


        mViewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper1);

        for (int i = 0; i < mDrawablesArray.length; i++) {
            setFlipperImage(mDrawablesArray[i]);
        }

        mViewFlipper.setAutoStart(true);
        mViewFlipper.setFlipInterval(1500);
    }

    private void setFlipperImage(int resId) {
        ImageView image = new ImageView(getApplicationContext());
        image.setBackgroundResource(resId);
        mViewFlipper.addView(image);
    }
    public void stop(View view) {
        mPlayer.stop();
        Intent intent = new Intent(MainActivity2.this, MainActivity.class);
        startActivity(intent);
    }
}