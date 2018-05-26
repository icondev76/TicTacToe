package com.icondev76.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //declare button variables

    private Button[][] button= new Button[3][3];

    int playerID=0;


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
        String result;
            if (getWinner()=="X") {
                result = "Player X is Won";
            }else{
                result = "Player O is Won";
            }
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();

    }


    public String getWinner(){

        String[][] string= new String[3][3];
        String result=null;

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
                result=string[i][0];
            }
        }
        //check vertical buttons for winner
        for(int i=0;i<3;i++){
            if(string[0][i].equals(string[1][i])
                    && string[0][i].equals(string[2][i])
                    && !string[0][i].equals("")){
                    result=string[0][i];
            }
        }
        //check cross buttons for winner

            if(string[0][0].equals(string[1][1])
                    && string[0][0].equals(string[2][2])
                    && !string[0][0].equals("")){
                    result=string[0][0];
            }

            if(string[0][2].equals(string[1][1])
                    && string[0][2].equals(string[2][0])
                    && !string[0][2].equals("")){
                    result=string[0][2];
            }

        return result;
    }

}
