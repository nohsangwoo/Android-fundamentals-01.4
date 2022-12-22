package com.example.noh.twoactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private final long finishtimeed = 1000;
    private long presstime = 0;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        final TextView textValue = findViewById(R.id.text_value);
        final Button btnCheck = findViewById(R.id.button_check_value);
        final Button moveBackBTN = findViewById(R.id.move_back);

        Intent i = getIntent();
        final String data = i.getStringExtra("key");

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textValue.setText(data);
            }
        });

        moveBackBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SecondActivity.this, "뒤로가기 버튼이 눌렸습니다.", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        long tempTime = System.currentTimeMillis();
        long intervalTime = tempTime - presstime;

        if(0 <= intervalTime && finishtimeed >= intervalTime)
        {
            finish();
        }
        else
        {
            presstime = tempTime;
            Toast.makeText(getApplicationContext(),"한번더 누르시면 현재 창이 닫힙니다.",Toast.LENGTH_SHORT).show();
        }

        Toast.makeText(SecondActivity.this, "뒤로가기 버튼이 눌렸습니다.", Toast.LENGTH_LONG).show();
    }


}