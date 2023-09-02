package com.example.numberguessgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private ImageView imageViewResult;
    private TextView textViewResult;
    private Button buttonTryAgain;
    private boolean result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        imageViewResult= findViewById(R.id.imageViewResult);
        textViewResult= findViewById(R.id.textViewResult);
        buttonTryAgain= findViewById(R.id.buttonTryAgain);

        result= getIntent().getBooleanExtra("result",false);

        if(result){
            textViewResult.setText("YOU WİN!");
            imageViewResult.setImageResource(R.drawable.smile_picture);
        }else{
            textViewResult.setText("YOU LOST!");
            imageViewResult.setImageResource(R.drawable.sad_picture);
        }

        buttonTryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ResultActivity.this,GuessActivity.class));
                finish();
            }
        });
    }
}