package com.example.apekshakhandelwal.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MActivity extends AppCompatActivity
{

    private int teamA = 0, teamB = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m);
    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        savedInstanceState.putInt("teamA", teamA);
        savedInstanceState.putInt("teamB", teamB);
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);


        // Restore UI state.

        teamA = savedInstanceState.getInt("teamA");
        teamB = savedInstanceState.getInt("teamB");
        displayB(teamA);
        displayB(teamB);
    }

    public void Aplus6(View v)
    {
        teamA = teamA + 6;
        displayA(teamA);
    }

    public void Aplus3(View v)
    {
        teamA = teamA + 3;
        displayA(teamA);
    }

    public void Aplus2(View v)
    {
        teamA = teamA + 2;
        displayA(teamA);
    }

    public void Aplus1(View v)
    {
        teamA++;
        displayA(teamA);
    }

    public void Bplus6(View v)
    {
        teamB = teamB + 6;
        displayB(teamB);
    }

    public void Bplus3(View v)
    {
        teamB = teamB + 3;
        displayB(teamB);
    }

    public void Bplus2(View v)
    {
        teamB = teamB + 2;
        displayB(teamB);
    }

    public void Bplus1(View v)
    {
        teamB++;
        displayB(teamB);
    }

    public void resetScore(View v)
    {
        teamA = 0;
        teamB = 0;
        displayA(teamA);
        displayB(teamB);
    }


    public void displayA(int score)
    {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayB(int score)
    {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

}
