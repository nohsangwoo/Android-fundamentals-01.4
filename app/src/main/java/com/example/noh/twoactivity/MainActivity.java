package com.example.noh.twoactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    public static final String EXTRA_MESSAGE = "com.example.android.twoactivities.extra.MESSAGE";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.button_move);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                EditText mMessageEditText= findViewById(R.id.editText_main);
                String message = mMessageEditText.getText().toString();
                Log.d(LOG_TAG, "button clicked: " + message);

                intent.putExtra("key", message);
                startActivity(intent);
//                finish();
            }
        });
    }



//    public void launchSecondActivity(View view) {
//        Intent intent = new Intent(this, SecondActivity.class);
//        startActivity(intent);
//        Log.d(LOG_TAG, "button clicked");
//        finish();
//    }
}