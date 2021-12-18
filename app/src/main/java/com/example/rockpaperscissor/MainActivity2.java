package com.example.rockpaperscissor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView finalWinLostTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        finalWinLostTextView = findViewById(R.id.finalWinLostTextView);
        Intent intent = getIntent();
        int userScore=intent.getIntExtra(MainActivity.EXTRA_NUMBER1,0);
        int compScore=intent.getIntExtra(MainActivity.EXTRA_NUMBER2,0);
        finalWinLostTextView.setText("");
        if(userScore==5)
            finalWinLostTextView.setText("YOU WIN!!");
        if(compScore==5)
            finalWinLostTextView.setText("COMPUTER WINS!!");
    }

    public void playAgainClicked(View view) {
        openMainActivity2();
    }

    public void openMainActivity2()
    {
        Intent intent = new Intent(MainActivity2.this,MainActivity.class);
        startActivity(intent);
    }

    public void quitGameClicked(View view) {
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
}
