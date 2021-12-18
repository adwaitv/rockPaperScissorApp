package com.example.rockpaperscissor;


        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.TextView;

        import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_NUMBER1="com.example.application.example.EXTRA_NUMBER1";
    public static final String EXTRA_NUMBER2="com.example.application.example.EXTRA_NUMBER2";
    TextView userSelectionTextView,compSelectionTextView,wonLostTieTextView,scoreTextView;
    Random random;
    int userScore=0; int compScore=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userSelectionTextView=findViewById(R.id.userSelectionTextView);
        compSelectionTextView=findViewById(R.id.compSelectionTextView);
        wonLostTieTextView=findViewById(R.id.wonLostTieTextView);
        scoreTextView=findViewById(R.id.scoreTextView);

        userSelectionTextView.setText("");
        compSelectionTextView.setText("");
        wonLostTieTextView.setText("");

        random = new Random();
    }

    public void resetButton(View view) {
        userSelectionTextView.setText("");
        compSelectionTextView.setText("");
        wonLostTieTextView.setText("");
        userScore=0;
        compScore=0;
        scoreTextView.setText(String.valueOf(userScore) + " : " + String.valueOf(compScore));
    }

    public void rpsButtonClicked(View view) {
        int userSelection=0;
        userSelection= Integer.parseInt(view.getTag().toString());
        matchGame(userSelection);
    }

    public void matchGame(int userSelection){
        int low=1;
        int high=3;

        int compSelection = random.nextInt(high)+low;
        switch(userSelection){
            case 1:
                userSelectionTextView.setText("Rock");
                switch(compSelection){
                    case 1:
                        compSelectionTextView.setText("Rock");
                        //Tie
                        wonLostTieTextView.setText("It's a Tie!");
                        break;
                    case 2:
                        compSelectionTextView.setText("Paper");
                        //Comp Wins
                        wonLostTieTextView.setText("Oh,you lost");
                        compScore++;
                        break;
                    case 3:
                        compSelectionTextView.setText("Scissor");
                        //User wins
                        wonLostTieTextView.setText("Wow,you won!");
                        userScore++;
                        break;
                }
                break;
            case 2:
                userSelectionTextView.setText("Paper");
                switch (compSelection) {
                    case 1:
                        compSelectionTextView.setText("Rock");
                        //User Wins
                        wonLostTieTextView.setText("Wow,you won!");
                        userScore++;
                        break;
                    case 2:
                        compSelectionTextView.setText("Paper");
                        //Tie
                        wonLostTieTextView.setText("It's a Tie!");
                        break;
                    case 3:
                        compSelectionTextView.setText("Scissor");
                        //Comp Wins
                        wonLostTieTextView.setText("Oh,you lost");
                        compScore++;
                        break;
                }
                break;
            case 3:
                userSelectionTextView.setText("Scissor");
                switch(compSelection) {
                    case 1:
                        compSelectionTextView.setText("Rock");
                        //comp wins
                        wonLostTieTextView.setText("Oh,you lost");
                        compScore++;
                        break;
                    case 2:
                        compSelectionTextView.setText("Paper");
                        //user wins
                        wonLostTieTextView.setText("Wow,you won!");
                        userScore++;
                        break;
                    case 3:
                        compSelectionTextView.setText("Scissor");
                        //tie
                        wonLostTieTextView.setText("It's a Tie!");
                        break;
                }
                break;
        }
        setScoreTextView(userScore,compScore);
        if(userScore==5||compScore==5) {
            Intent intent = new Intent(MainActivity.this,MainActivity2.class);
            intent.putExtra(EXTRA_NUMBER1,userScore);
            intent.putExtra(EXTRA_NUMBER2,compScore);
            startActivity(intent);
        }
    }

    private void setScoreTextView(int userScore,int compScore)
    {
        scoreTextView.setText(String.valueOf(userScore) + " : " + String.valueOf(compScore));
    }
}
