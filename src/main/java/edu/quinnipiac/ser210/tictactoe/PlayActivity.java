package edu.quinnipiac.ser210.tictactoe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class PlayActivity extends Activity implements ITicTacToe {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        configureResetButton();
        configureGameButton();

        Intent intent = getIntent();

        String message = intent.getStringExtra("USER_NAME");
        TextView textView = findViewById(R.id.start_message);
        textView.setText("Welcome " + message);
    }


    // Sets up the game reset button
    private void configureResetButton(){
        Button resetButton = findViewById(R.id.resetButton);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    // Sets up image for each button on click
    private void configureGameButton() {

            final ImageButton button1 = findViewById(R.id.board1);
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        if (checkBoard[0] == 1 ||  checkBoard[0] == 2){
                            Toast.makeText(PlayActivity.this,"Invalid Move",Toast.LENGTH_LONG).show();
                        }else {
                            button1.setBackgroundResource(R.drawable.red_x);
                            checkForWinner();
                            board[0][0] = 1;
                            checkBoard[0] = 1;
                            setMove(2, getComputerMove());
                            checkForWinner();                        }
                }
            });

            final ImageButton button2 = findViewById(R.id.board2);
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        if (checkBoard[1] == 1 ||  checkBoard[1] == 2){
                            Toast.makeText(PlayActivity.this,"Invalid Move",Toast.LENGTH_LONG).show();
                        }else {
                            button2.setBackgroundResource(R.drawable.red_x);
                            checkForWinner();
                            board[0][1] = 1;
                            checkBoard[1] = 1;
                            setMove(2, getComputerMove());
                            checkForWinner();
                        }
                }
            });

            final ImageButton button3 = findViewById(R.id.board3);
            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        if (checkBoard[2] == 1 ||  checkBoard[2] == 2){
                            Toast.makeText(PlayActivity.this,"Invalid Move",Toast.LENGTH_LONG).show();
                        }else {
                            button3.setBackgroundResource(R.drawable.red_x);
                            checkForWinner();
                            board[0][2] = 1;
                            checkBoard[2] = 1;
                            setMove(2, getComputerMove());
                            checkForWinner();
                        }
                }
            });

        final ImageButton button4 = findViewById(R.id.board4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if (checkBoard[3] == 1 ||  checkBoard[3] == 2){
                        Toast.makeText(PlayActivity.this,"Invalid Move",Toast.LENGTH_LONG).show();
                    }else {
                        button4.setBackgroundResource(R.drawable.red_x);
                        checkForWinner();
                        board[1][0] = 1;
                        checkBoard[3] = 1;
                        setMove(2, getComputerMove());
                        checkForWinner();
                    }
            }
        });

        final ImageButton button5 = findViewById(R.id.board5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if (checkBoard[4] == 1 ||  checkBoard[4] == 2){
                        Toast.makeText(PlayActivity.this,"Invalid Move",Toast.LENGTH_LONG).show();
                    }else {
                        button5.setBackgroundResource(R.drawable.red_x);
                        checkForWinner();
                        board[1][1] = 1;
                        checkBoard[4] = 1;
                        setMove(2, getComputerMove());
                        checkForWinner();
                    }
            }
        });

        final ImageButton button6 = findViewById(R.id.board6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if (checkBoard[5] == 1 ||  checkBoard[5] == 2){
                        Toast.makeText(PlayActivity.this,"Invalid Move",Toast.LENGTH_LONG).show();
                    }else {
                        button6.setBackgroundResource(R.drawable.red_x);
                        checkForWinner();
                        board[1][2] = 1;
                        checkBoard[5] = 1;
                        setMove(2, getComputerMove());
                        checkForWinner();
                    }
            }
        });

        final ImageButton button7 = findViewById(R.id.board7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if (checkBoard[6] == 1 ||  checkBoard[6] == 2){
                        Toast.makeText(PlayActivity.this,"Invalid Move",Toast.LENGTH_LONG).show();
                    } else {
                        button7.setBackgroundResource(R.drawable.red_x);
                        checkForWinner();
                        board[2][0] = 1;
                        checkBoard[6] = 1;
                        setMove(2, getComputerMove());
                        checkForWinner();
                    }
            }
        });

        final ImageButton button8 = findViewById(R.id.board8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if (checkBoard[7] == 1 ||  checkBoard[7] == 2){
                        Toast.makeText(PlayActivity.this,"Invalid Move",Toast.LENGTH_LONG).show();
                    } else {
                        button8.setBackgroundResource(R.drawable.red_x);
                        checkForWinner();
                        board[2][1] = 1;
                        checkBoard[7] = 1;
                        setMove(2, getComputerMove());
                        checkForWinner();
                    }
            }
        });

        final ImageButton button9 = findViewById(R.id.board9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if ( checkBoard[8] == 1 ||  checkBoard[8] == 2){
                        Toast.makeText(PlayActivity.this,"Invalid Move",Toast.LENGTH_LONG).show();
                    } else {
                        button9.setBackgroundResource(R.drawable.red_x);
                        checkForWinner();
                        board[2][2] = 1;
                        checkBoard[8] = 1;
                        setMove(2, getComputerMove());
                        checkForWinner();
                    }
            }
        });
    }

//////////////////////////////////Game Mechanics////////////////
    // The game board and the game status
    private static final int ROWS = 3, COLS = 3; // number of rows and columns
    private int[][] board = new int[ROWS][COLS]; // game board in 2D array
    private int[] checkBoard = new int[9];
    int currPlayer;

    /**
     * clear board and set current player
     */

    @Override
    public void clearBoard() {
        int pos = 0;
        while (pos < 9){
            setMove(0,pos);
            pos++;
        }
    }

    public void setMove(int player, int location) {

        switch (location) {
            case 0:
                ImageButton button1 = findViewById(R.id.board1);
                button1.setBackgroundResource(R.drawable.red_o);
                board[0][0] = player;
                checkBoard[location] = player;
                //setPlayer--;
                break;
            case 1:
                ImageButton button2 = findViewById(R.id.board2);
                button2.setBackgroundResource(R.drawable.red_o);
                board[0][1] = player;
                checkBoard[location] = player;
                //setPlayer--;
                break;
            case 2:
                ImageButton button3 = findViewById(R.id.board3);
                button3.setBackgroundResource(R.drawable.red_o);
                board[0][2] = player;
                checkBoard[location] = player;
               // setPlayer--;
                break;
            case 3:
                ImageButton button4 = findViewById(R.id.board4);
                button4.setBackgroundResource(R.drawable.red_o);
                board[1][0] = player;
                checkBoard[location] = player;
               // setPlayer--;
                break;
            case 4:
                ImageButton button5 = findViewById(R.id.board5);
                button5.setBackgroundResource(R.drawable.red_o);
                board[1][1] = player;
                checkBoard[location] = player;
               // setPlayer--;
                break;
            case 5:
                ImageButton button6 = findViewById(R.id.board6);
                button6.setBackgroundResource(R.drawable.red_o);
                board[1][2] = player;
                checkBoard[location] = player;
               // setPlayer--;
                break;
            case 6:
                ImageButton button7 = findViewById(R.id.board7);
                button7.setBackgroundResource(R.drawable.red_o);
                board[2][0] = player;
                checkBoard[location] = player;
               // setPlayer--;
                break;
            case 7:
                ImageButton button8 = findViewById(R.id.board8);
                button8.setBackgroundResource(R.drawable.red_o);
                board[2][1] = player;
                checkBoard[location] = player;
               // setPlayer--;
                break;
            case 8:
                ImageButton button9 = findViewById(R.id.board9);
                button9.setBackgroundResource(R.drawable.red_o);
                board[2][2] = player;
                checkBoard[location] = player;
               // setPlayer--;
                break;
        }
    }

    public int getComputerMove() {
        Random rand = new Random();
        int move = rand.nextInt(9);
        // Checks computer move vs used moves

        //Horizontal Block
        if (checkBoard[0] == 1 && checkBoard[1] == 1 && checkBoard[2] != 2){
            move = 2;
        }
        if (checkBoard[3] == 1 && checkBoard[4] == 1 && checkBoard[5] != 2){
            move = 5;
        }
        if (checkBoard[6] == 1 && checkBoard[7] == 1 && checkBoard[8] != 2){
            move = 8;
        }
        //Vertical Block
        if (checkBoard[0] == 1 && checkBoard[3] == 1 && checkBoard[6] != 2){
            move = 6;
        }
        if (checkBoard[1] == 1 && checkBoard[4] == 1 && checkBoard[7] != 2){
            move = 7;
        }
        if (checkBoard[2] == 1 && checkBoard[5] == 1 && checkBoard[8] != 2){
            move = 8;
        }
        //Diagonal Block
        if (checkBoard[0] == 1 && checkBoard[4] == 1 && checkBoard[8] != 2){
            move = 8;
        }
        if (checkBoard[2] == 1 && checkBoard[4] == 1 && checkBoard[6] != 2){
            move = 6;
        }

        for (int i = 0; i < 9; i++){
            int check = checkMove(i);
            if (check != 25){
                return move;
            }
        }
        return move;
    }

    public int checkMove(int move){
        Random rand = new Random();
        switch(move){
            case 0:
                if (board[0][0] == 1  || board[0][0] == 2){
                   return 25;
                }
                break;
            case 1:
                if (board[0][1]  == 1 || board[0][1]  == 2){
                    return 25;
                }
                break;
            case 2:
                if (board[0][2]  == 1 || board[0][2]  == 2){
                    return 25;
                }
                break;
            case 3:
                if(board[1][0]  == 1 || board[1][0]  == 2){
                    return 25;
                }
                break;
            case 4:
                if(board[1][1]  == 1 || board[1][1]  == 2){
                    return 25;
                }
                break;
            case 5:
                if (board[1][2] == 1 || board[1][2] == 2){
                    return 25;
                }
                break;
            case 6:
                if (board[2][0]  == 1 || board[2][0]  == 2){
                    return 25;
                }
                break;
            case 7:
                if (board[2][1]  == 1 || board[2][1]  == 2){
                    return 25;
                }
                break;
            case 8:
                if (board[2][2]  == 1 || board[2][2]  == 2){
                    return 25;
                }
                break;
        }
       // move = rand.nextInt(9);
        return move;
    }

    @Override
    public int checkForWinner() {
        // Horizontal Check
        if (checkBoard[0] == 1 && checkBoard[1] == 1 && checkBoard[2] == 1){
            Toast.makeText(PlayActivity.this,"Cross Won",Toast.LENGTH_LONG).show();
            finish();
        }
        if (checkBoard[3] == 1 && checkBoard[4] == 1 && checkBoard[5] == 1){
            Toast.makeText(PlayActivity.this,"Cross Won",Toast.LENGTH_LONG).show();
            finish();
        }
        if (checkBoard[6] == 1 && checkBoard[7] == 1 && checkBoard[8] == 1){
            Toast.makeText(PlayActivity.this,"Cross Won",Toast.LENGTH_LONG).show();
            finish();
        }
        if (checkBoard[0] == 2 && checkBoard[1] == 2 && checkBoard[2] == 2){
            Toast.makeText(PlayActivity.this,"Naught Won",Toast.LENGTH_LONG).show();
            finish();
        }
        if (checkBoard[3] == 2 && checkBoard[4] == 2 && checkBoard[5] == 2){
            Toast.makeText(PlayActivity.this,"Naught Won",Toast.LENGTH_LONG).show();
            finish();
        }
        if (checkBoard[6] == 2 && checkBoard[7] == 2 && checkBoard[8] == 2){
            Toast.makeText(PlayActivity.this,"Naught Won",Toast.LENGTH_LONG).show();
            finish();
        }
        //Vertical Check
        if (checkBoard[0] == 1 && checkBoard[3] == 1 && checkBoard[6] == 1){
            Toast.makeText(PlayActivity.this,"Cross Won",Toast.LENGTH_LONG).show();
            finish();
        }
        if (checkBoard[1] == 1 && checkBoard[4] == 1 && checkBoard[7] == 1){
            Toast.makeText(PlayActivity.this,"Cross Won",Toast.LENGTH_LONG).show();
            finish();
        }
        if (checkBoard[2] == 1 && checkBoard[5] == 1 && checkBoard[8] == 1){
            Toast.makeText(PlayActivity.this,"Cross Won",Toast.LENGTH_LONG).show();
            finish();
        }
        if (checkBoard[0] == 2 && checkBoard[3] == 2 && checkBoard[6] == 2){
            Toast.makeText(PlayActivity.this,"Naught Won",Toast.LENGTH_LONG).show();
            finish();
        }
        if (checkBoard[1] == 2 && checkBoard[4] == 2 && checkBoard[7] == 2){
            Toast.makeText(PlayActivity.this,"Naught Won",Toast.LENGTH_LONG).show();
            finish();
        }
        if (checkBoard[2] == 2 && checkBoard[5] == 2 && checkBoard[8] == 2){
            Toast.makeText(PlayActivity.this,"Naught Won",Toast.LENGTH_LONG).show();
            finish();
        }
        //Diagonal Check
        if (checkBoard[0] == 1 && checkBoard[4] == 1 && checkBoard[8] == 1){
            Toast.makeText(PlayActivity.this,"Cross Won",Toast.LENGTH_LONG).show();
            finish();
        }
        if (checkBoard[2] == 1 && checkBoard[4] == 1 && checkBoard[6] == 1){
            Toast.makeText(PlayActivity.this,"Cross Won",Toast.LENGTH_LONG).show();
            finish();
        }
        if (checkBoard[0] == 2 && checkBoard[4] == 2 && checkBoard[8] == 2){
            Toast.makeText(PlayActivity.this,"Naught Won",Toast.LENGTH_LONG).show();
            finish();
        }
        if (checkBoard[2] == 2 && checkBoard[4] == 2 && checkBoard[6] == 2){
            Toast.makeText(PlayActivity.this,"Naught Won",Toast.LENGTH_LONG).show();
            finish();
        }
        return 0;
    }
    /**
     *  Print the game board
     */
    public  void printBoard() {
        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
                printCell(board[row][col]); // print each of the cells
                if (col != COLS - 1) {
                    System.out.print("|");   // print vertical partition
                }
            }
            System.out.println();
            if (row != ROWS - 1) {
                System.out.println("-----------"); // print horizontal partition
            }
        }
        System.out.println();
    }

    /**
     * Print a cell with the specified "content"
     * @param content either CROSS, NOUGHT or EMPTY
     */
    public  void printCell(int content) {
        switch (content) {
            case EMPTY:  System.out.print("   "); break;
            case NOUGHT: System.out.print(" O "); break;
            case CROSS:  System.out.print(" X "); break;
        }
    }

}







