package com.example.numberguessgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class GuessActivity extends AppCompatActivity {

    private TextView textViewClue, textViewRemainingRight;
    private EditText editTextEntered;
    private Button buttonGuess;
    private int randomNumber;
    private int counter= 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess);

        textViewClue= findViewById(R.id.textViewClue);
        textViewRemainingRight= findViewById(R.id.textViewRemainingRight);
        editTextEntered= findViewById(R.id.editTextEntered);
        buttonGuess= findViewById(R.id.buttonGuess);

        Random r = new Random();
        randomNumber= r.nextInt(101);//0-100
        Log.e("randomNumber", String.valueOf(randomNumber));

        buttonGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter--;
                int guess= Integer.parseInt(editTextEntered.getText().toString());

                if(guess==randomNumber){
                    Intent i = new Intent(GuessActivity.this,ResultActivity.class);
                    i.putExtra("result",true);
                    startActivity(i);
                    finish();
                    return;
                }

                if(guess>randomNumber){
                    textViewClue.setText("Reduce your guess ↓");
                    textViewRemainingRight.setText("Your remaining right: "+counter);
                }

                if(guess<randomNumber){
                    textViewClue.setText("İncrease your guess ↑");
                    textViewRemainingRight.setText("Your remaining right: "+counter);
                }

                if (counter==0){
                    Intent i = new Intent(GuessActivity.this,ResultActivity.class);
                    i.putExtra("result",false);
                    startActivity(i);
                    finish();
                }

                editTextEntered.setText("");

            }
        });
    }
}