package com.example.relaxslide;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;
public class MainActivity extends Activity implements View.OnClickListener {

    EditText editTextStr, editTextNum;
    Button btnSave, btnLoad;
    SharedPreferences sharedPreferences;
/*
    final String SAVED_TEXT = "TEXT";
    final String SAVED_NUM = "NUMBER";
*/

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextStr = (EditText) findViewById(R.id.editTextStr);
        editTextNum = (EditText) findViewById(R.id.editTextNum);

        btnSave = (Button) findViewById(R.id.save);
        btnSave.setOnClickListener((View.OnClickListener) this);

        btnLoad = (Button) findViewById(R.id.load);
        btnLoad.setOnClickListener((View.OnClickListener) this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.save:
                saveData();
                break;
            case R.id.load:
                loadData();
                break;
            default:
                break;
        }

    }

    void saveData() {
        sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putString(SAVED_TEXT, editTextStr.getText().toString());
        editor.putInt(editTextStr.getText().toString(), Integer.parseInt(editTextNum.getText().toString()));
        editor.commit();
        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
    }

    void loadData() {
        sharedPreferences = getPreferences(MODE_PRIVATE);
        // String savedText = sharedPreferences.getString(SAVED_TEXT, "");
        Integer savedNum = sharedPreferences.getInt(editTextStr.getText().toString(), 0);
        //editTextStr.setText(savedText);
        editTextNum.setText(savedNum.toString());
        Toast.makeText(this, "Loaded", Toast.LENGTH_SHORT).show();
    }

    public void play(View view) {
    }

    public void pause(View view) {
    }

    public void stop(View view) {
    }

    public static class Main extends AppCompatActivity {
        private final int[] mDrawablesArray = {R.drawable.neitralnoe, R.drawable.schastie, R.drawable.zlost_,
        };
        ViewFlipper mViewFlipper;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

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
    }
}
