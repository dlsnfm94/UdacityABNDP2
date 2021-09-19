package com.example.abndp2bynooralmashhadani;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    int scorePlayer1 = 0;
    int scorePlayer2 = 0;
    int scorePlayer3 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayScoreForPlayer1(int score) {
        TextView scorePlayer1TV = findViewById(R.id.player_1_score);
        scorePlayer1TV.setText(score + "");
    }

    public void displayScoreForPlayer2(int score) {
        TextView scorePlayer2TV = findViewById(R.id.player_2_score);
        scorePlayer2TV.setText(score + "");
    }

    public void displayScoreForPlayer3(int score) {
        TextView scorePlayer3TV = findViewById(R.id.player_3_score);
        scorePlayer3TV.setText(score + "");
    }

    public void add1Point_Player1(View view) {
        scorePlayer1++;
        displayScoreForPlayer1(scorePlayer1);
    }

    public void add2Points_Player1(View view) {
        scorePlayer1 += 2;
        displayScoreForPlayer1(scorePlayer1);
    }

    public void add3Points_Player1(View view) {
        scorePlayer1 += 3;
        displayScoreForPlayer1(scorePlayer1);
    }

    public void add1Point_Player2(View view) {
        scorePlayer2++;
        displayScoreForPlayer2(scorePlayer2);
    }

    public void add2Points_Player2(View view) {
        scorePlayer2 += 2;
        displayScoreForPlayer2(scorePlayer2);
    }

    public void add3Points_Player2(View view) {
        scorePlayer2 += 3;
        displayScoreForPlayer2(scorePlayer2);
    }

    public void add1Point_Player3(View view) {
        scorePlayer3++;
        displayScoreForPlayer3(scorePlayer3);
    }

    public void add2Points_Player3(View view) {
        scorePlayer3 += 2;
        displayScoreForPlayer3(scorePlayer3);
    }

    public void add3Points_Player3(View view) {
        scorePlayer3 += 3;
        displayScoreForPlayer3(scorePlayer3);
    }

    public void calculateAndShowResult(View view) {

        int maxScore = Math.max(Math.max(scorePlayer1, scorePlayer2), scorePlayer3);
        int minScore = Math.min(Math.min(scorePlayer1, scorePlayer2), scorePlayer3);

        String gameWinner;
        String gameSecondPlace;
        String gameThirdPlace;

        if (maxScore == scorePlayer1 && minScore == scorePlayer3) {
            gameWinner = "1. Player 1 ( " + scorePlayer1 + " ) WINNER";
            gameSecondPlace = "2. Player 2 ( " + scorePlayer2 + " )";
            gameThirdPlace = "3. Player 3 ( " + scorePlayer3 + " )";
        } else if (maxScore == scorePlayer1 && minScore == scorePlayer2) {
            gameWinner = "1. Player 1 ( " + scorePlayer1 + " ) WINNER";
            gameSecondPlace = "2. Player 3 ( " + scorePlayer3 + " )";
            gameThirdPlace = "3. Player 2 ( " + scorePlayer2 + " )";
        } else if (maxScore == scorePlayer2 && minScore == scorePlayer3) {
            gameWinner = "1. Player 2 ( " + scorePlayer2 + " ) WINNER";
            gameSecondPlace = "2. Player 1 ( " + scorePlayer1 + " )";
            gameThirdPlace = "3. Player 3 ( " + scorePlayer3 + " )";
        } else if (maxScore == scorePlayer2 && minScore == scorePlayer1) {
            gameWinner = "1. Player 2 ( " + scorePlayer2 + " ) WINNER";
            gameSecondPlace = "2. Player 3 ( " + scorePlayer3 + " )";
            gameThirdPlace = "3. Player 1 ( " + scorePlayer1 + " )";
        } else if (maxScore == scorePlayer3 && minScore == scorePlayer2) {
            gameWinner = "1. Player 3 ( " + scorePlayer3 + " ) WINNER";
            gameSecondPlace = "2. Player 1 ( " + scorePlayer1 + " )";
            gameThirdPlace = "3. Player 2 ( " + scorePlayer2 + " )";
        } else {
            gameWinner = "1. Player 3 ( " + scorePlayer3 + " ) WINNER";
            gameSecondPlace = "2. Player 2 ( " + scorePlayer2 + " )";
            gameThirdPlace = "3. Player 1 ( " + scorePlayer1 + " )";
        }

        displayResult(gameWinner, gameSecondPlace, gameThirdPlace);

    }

    public void displayResult(String gameWinner, String gameSecondPlace, String gameThirdPlace) {
        TextView winner = findViewById(R.id.winner);
        TextView secondPlace = findViewById(R.id.second_place);
        TextView thirdPlace = findViewById(R.id.third_place);

        winner.setText(gameWinner);
        winner.setTextColor(getResources().getColor(R.color.winner_color));
        secondPlace.setText(gameSecondPlace);
        thirdPlace.setText(gameThirdPlace);
        thirdPlace.setTextColor(getResources().getColor(R.color.last_place_color));
    }

    public void reset(View view) {
        scorePlayer1 = 0;
        scorePlayer2 = 0;
        scorePlayer3 = 0;
        displayScoreForPlayer1(scorePlayer1);
        displayScoreForPlayer2(scorePlayer2);
        displayScoreForPlayer3(scorePlayer3);
        displayResult("", "", "");
    }
}