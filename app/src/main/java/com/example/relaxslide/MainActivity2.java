package com.example.relaxslide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity implements MainActivity_2 {
    MediaPlayer mPlayer;


    private final int[] mDrawablesArray = {R.drawable.neitralnoe, R.drawable.schastie, R.drawable.zlost_,
    };
    ViewFlipper mViewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        mPlayer = MediaPlayer.create(this, R.raw.happines);
        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                //     stopPlay();
            }
        });
        mPlayer.start();


        mViewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper1);

        for (int j : mDrawablesArray) {
            setFlipperImage(j);
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


    public class Array {
        public class Arrays {
            final int[] images = {
                    R.drawable.dolphin,
                    R.drawable.sea,
                    R.drawable.sun,

                    R.drawable.galaxy_a,
                    R.drawable.planet_a,
                    R.drawable.stars_a,

                    R.drawable.fall_d,
                    R.drawable.light_d,
                    R.drawable.water_d,
            };
        }

        final int[] texts = {
                R.string.счастье,
                R.string.злость,
                R.string.депрессия,
        };
    }

    private final int[] mDrawablesArray2 = {R.drawable.dolphin, R.drawable.sea, R.drawable.sun,
    };
    ViewFlipper mViewFlipper2;


    public class MainActivity3 extends AppCompatActivity implements MainActivity_2 {
        MediaPlayer mPlayer;

        protected void onCreate1(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main2);


            mPlayer = MediaPlayer.create(this, R.raw.happines);
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

        private void setFlipperImage2(int resId) {
            ImageView image = new ImageView(getApplicationContext());
            image.setBackgroundResource(resId);
            mViewFlipper.addView(image);
        }

        public void stop2(View view) {
            mPlayer.stop();
            Intent intent = new Intent(MainActivity2.this, MainActivity.class);
            startActivity(intent);
        }
    }

    public class MainActivity_second extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            TextView textView = new TextView(this);
            textView.setTextSize(26);
            textView.setPadding(16, 16, 16, 16);

            Bundle arguments = getIntent().getExtras();

            if(arguments!=null){
                String name = arguments.get("name").toString();
                String company = arguments.getString("company");
                int age = arguments.getInt("age");
                textView.setText("Name: " + name + "\nCompany: " + company +
                        "\nAge: " + age);
            }

            setContentView(textView);
        }
    }
}
