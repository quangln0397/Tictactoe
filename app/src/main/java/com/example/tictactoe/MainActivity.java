package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    List<Integer> listButton;
    List<Integer> listButtonPlayer1 = new ArrayList<>();
    List<Integer> listButtonPlayer2 = new ArrayList<>();
    Button bn1, bn2, bn3, bn4, bn5, bn6, bn7, bn8, bn9;
    TextView tvResult;
    Button buResetGame;

    int playerID = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult = (TextView) findViewById(R.id.tvResult);
        buResetGame = (Button) findViewById(R.id.buResetGame);
        bn1 = (Button) findViewById(R.id.button);
        bn2 = (Button) findViewById(R.id.button2);
        bn3 = (Button) findViewById(R.id.button3);
        bn4 = (Button) findViewById(R.id.button4);
        bn5 = (Button) findViewById(R.id.button5);
        bn6 = (Button) findViewById(R.id.button6);
        bn7 = (Button) findViewById(R.id.button7);
        bn8 = (Button) findViewById(R.id.button8);
        bn9 = (Button) findViewById(R.id.button9);

    }


    public void buttonClick(View view) {
        Button buttonClicked = (Button) view;
            buttonClicked.setBackgroundColor(Color.GREEN);
            listButton = listButtonPlayer1;
//        else {
//            buttonClicked.setBackgroundColor(Color.RED);
//            listButton = listButtonPlayer2;
//            playerID = 1;
//        }
        buttonClicked.setEnabled(false);
        switch (buttonClicked.getId()) {
            case R.id.button: {
                listButton.add(1);
                break;
            }
            case R.id.button2: {
                listButton.add(2);
                break;
            }
            case R.id.button3: {
                listButton.add(3);
                break;
            }
            case R.id.button4: {
                listButton.add(4);
                break;
            }
            case R.id.button5: {
                listButton.add(5);
                break;
            }
            case R.id.button6: {
                listButton.add(6);
                break;
            }
            case R.id.button7: {
                listButton.add(7);
                break;
            }
            case R.id.button8: {
                listButton.add(8);
                break;
            }
            case R.id.button9: {
                listButton.add(9);
                break;
            }
            default: {
                break;
            }
        }

        if(HasWinner()) {
            buResetGame.setVisibility(View.VISIBLE);
        }
        else {
            playerID = 2;
            AutoPlay();
        }
    }

    private void AutoPlay() {
        Random rd = new Random();
        int selectedCell = rd.nextInt(9)  + 1;
        while(listButtonPlayer1.contains(selectedCell) || listButtonPlayer2.contains(selectedCell)) {
             selectedCell = rd.nextInt(9)  + 1;
        }
        listButtonPlayer2.add(selectedCell);
        Button btnSelected = null;
        switch (selectedCell) {
            case 1: {
                btnSelected = (Button) findViewById(R.id.button);
                break;
            }
            case 2: {
                btnSelected = (Button) findViewById(R.id.button2);
                break;
            }
            case 3 : {
                btnSelected = (Button) findViewById(R.id.button3);
                break;
            }
            case 4: {
                btnSelected = (Button) findViewById(R.id.button4);
                break;
            }
            case 5: {
                btnSelected = (Button) findViewById(R.id.button5);
                break;
            }
            case 6: {
                btnSelected = (Button) findViewById(R.id.button6);
                break;
            }
            case 7: {
                btnSelected = (Button) findViewById(R.id.button7);
                break;
            }
            case 8: {
                btnSelected = (Button) findViewById(R.id.button8);
                break;
            }
            case 9: {
                btnSelected = (Button) findViewById(R.id.button9);
                break;
            }
            default: {
                break;
            }
        }
        btnSelected.setEnabled(false);
        btnSelected.setBackgroundColor(Color.RED);
        if(HasWinner()) {
            buResetGame.setVisibility(View.VISIBLE);

        }
        playerID = 1;
    }

    private boolean HasWinner() {
//       // Row 1
        if(listButtonPlayer1.contains(1) && listButtonPlayer1.contains(2) && listButtonPlayer1.contains(3) ||
                listButtonPlayer2.contains(1) && listButtonPlayer2.contains(2) && listButtonPlayer2.contains(3)) {
                int playerWinner = playerID;
                tvResult.setText("Congratulations ! The Winner is Player" + playerWinner);
                return true;
        }
        // Row 2
        else if(listButtonPlayer1.contains(4) && listButtonPlayer1.contains(5) && listButtonPlayer1.contains(6) ||
                listButtonPlayer2.contains(4) && listButtonPlayer2.contains(5) && listButtonPlayer2.contains(6)) {
            int playerWinner = playerID;
            tvResult.setText("Congratulations ! The Winner is Player" + playerWinner);
            return true;
        }
        // Row 3
        else if(listButtonPlayer1.contains(7) && listButtonPlayer1.contains(8) && listButtonPlayer1.contains(9) ||
                listButtonPlayer2.contains(7) && listButtonPlayer2.contains(8) && listButtonPlayer2.contains(9)) {
            int playerWinner = playerID;
            tvResult.setText("Congratulations ! The Winner is Player" + playerWinner);
            return true;

        }

        // Col 1
        if(listButtonPlayer1.contains(1) && listButtonPlayer1.contains(4) && listButtonPlayer1.contains(7) ||
                listButtonPlayer2.contains(1) && listButtonPlayer2.contains(4) && listButtonPlayer2.contains(7)) {
            int playerWinner = playerID;
            tvResult.setText("Congratulations ! The Winner is Player" + playerWinner);
            return true;

        }
        // Col 2
        else if(listButtonPlayer1.contains(2) && listButtonPlayer1.contains(5) && listButtonPlayer1.contains(8) ||
                listButtonPlayer2.contains(2) && listButtonPlayer2.contains(5) && listButtonPlayer2.contains(8)) {
            int playerWinner = playerID;
            tvResult.setText("Congratulations ! The Winner is Player" + playerWinner);
            return true;

        }
        // Col 3
        else if(listButtonPlayer1.contains(3) && listButtonPlayer1.contains(6) && listButtonPlayer1.contains(9) ||
                listButtonPlayer2.contains(3) && listButtonPlayer2.contains(6) && listButtonPlayer2.contains(9)) {
            int playerWinner = playerID;
            tvResult.setText("Congratulations ! The Winner is Player" + playerWinner);
            return true;

        }

        else if(listButtonPlayer1.size() + listButtonPlayer2.size() == 9) {
            tvResult.setText("No one is win");
            return true;
        }

        return false;



    }




    public void clickResetGame(View view) {
        bn1.setEnabled(true);
        bn2.setEnabled(true);
        bn3.setEnabled(true);
        bn4.setEnabled(true);
        bn5.setEnabled(true);
        bn6.setEnabled(true);
        bn7.setEnabled(true);
        bn8.setEnabled(true);
        bn9.setEnabled(true);
        bn1.setBackgroundColor(getResources().getColor(R.color.basic));
        bn2.setBackgroundColor(getResources().getColor(R.color.basic));
        bn3.setBackgroundColor(getResources().getColor(R.color.basic));
        bn4.setBackgroundColor(getResources().getColor(R.color.basic));
        bn5.setBackgroundColor(getResources().getColor(R.color.basic));
        bn6.setBackgroundColor(getResources().getColor(R.color.basic));
        bn7.setBackgroundColor(getResources().getColor(R.color.basic));
        bn8.setBackgroundColor(getResources().getColor(R.color.basic));
        bn9.setBackgroundColor(getResources().getColor(R.color.basic));
        listButtonPlayer1.clear();
        listButtonPlayer2.clear();
        tvResult.setText("");
        buResetGame.setVisibility(View.INVISIBLE);

    }
}