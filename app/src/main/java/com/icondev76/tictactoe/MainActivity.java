package com.icondev76.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //declare button variables
    private Button[][] button= new Button[3][3];
    private int playerID=0;
    private String[][] string= new String[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //assign button view to variable and set onclicklistener
        for(int i=0;i<3;i++){
            for(int j=0; j<3; j++){
                String string="bt"+i+j;
                int resID= getResources().getIdentifier(string,"id",getPackageName());
                button[i][j]= findViewById(resID);
                button[i][j].setOnClickListener(this);
            }
        }
    }
    public void onClick(View v){
        if(((Button)v).getText().equals("")){
            if(playerID==0){
                ((Button)v).setText("X");
                playerID=1;
            }else{
                ((Button)v).setText("O");
                playerID=0;
            }
        }
        if(getWinner()){

                Toast.makeText(this,"Player "+((Button)v).getText()+" is Won", Toast.LENGTH_LONG).show();
                reset();
        }else if(draw()){
            Toast.makeText(this,"Game is Draw", Toast.LENGTH_LONG).show();
            reset();
        }
    }
    public boolean getWinner(){
        for(int i=0; i<3;i++){
            for(int j=0; j<3;j++){
                string[i][j]=button[i][j].getText().toString();
            }
        }
        //check horizontal buttons for winner
        for(int i=0;i<3;i++){
            if(string[i][0].equals(string[i][1])
                && string[i][0].equals(string[i][2])
                && !string[i][0].equals("")){
                return true;
            }
        }
        //check vertical buttons for winner
        for(int i=0;i<3;i++){
            if(string[0][i].equals(string[1][i])
                    && string[0][i].equals(string[2][i])
                    && !string[0][i].equals("")){
                    return true;
            }
        }
        //check cross buttons for winner
            if(string[0][0].equals(string[1][1])
                    && string[0][0].equals(string[2][2])
                    && !string[0][0].equals("")){
                    return true;
            }
            if(string[0][2].equals(string[1][1])
                    && string[0][2].equals(string[2][0])
                    && !string[0][2].equals("")){
                    return true;
            }
        return false;
    }
    public void reset(){
        playerID=0;
        for(int i=0;i<3;i++){
            for(int j=0; j<3; j++){
                button[i][j].setText("");
            }
        }
    }
    public boolean draw(){
        for(int i=0; i<3;i++){
            for(int j=0; j<3;j++){
                if(((string[i][j]).equals(""))){
                    return false;
                }
            }
        }
        return true;
    }
}
