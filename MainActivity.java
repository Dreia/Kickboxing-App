package com.example.android.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    //Define and initialize the integers used in the application
    int scoreFighterA = 0;
    int scoreFighterB = 0;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //Save the score
        outState.putInt("fighter_A_current", scoreFighterA);
        outState.putInt("fighter_B_current", scoreFighterB);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        //Restore information to the integers
        scoreFighterA = savedInstanceState.getInt("fighter_A_current");
        scoreFighterB = savedInstanceState.getInt("fighter_B_current");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Get the opponents names.
     */
    public void opponentA() {
        //Get user name
        EditText mEdit = (EditText) findViewById(R.id.fighter_a);
        String name = mEdit.getText().toString();

    }

    public void opponentB() {
        //Get user name
        EditText mEdit = (EditText) findViewById(R.id.fighter_b);
        String name = mEdit.getText().toString();
    }

    /**
     * Increase the score for Fighter A by 8 point.
     */
    public void addEightForFighterA(View v) {
        scoreFighterA = scoreFighterA + 8;
        displayForFighterA(scoreFighterA);
    }

    /**
     * Increase the score for Fighter A by 9 points.
     */
    public void addNineForFighterA(View v) {
        scoreFighterA += 9;
        displayForFighterA(scoreFighterA);
    }

    /**
     * Increase the score for Fighter A by 10 points.
     */
    public void addTenForFighterA(View v) {
        scoreFighterA += 10;
        displayForFighterA(scoreFighterA);
    }

    /**
     * Displays the given score for Fighter A.
     */
    public void displayForFighterA(int score) {
        TextView scoreViewA = (TextView) findViewById(R.id.fighter_a_score);
        scoreViewA.setText(String.valueOf(score));
    }

    /**
     * Increase the score for Fighter B by 8 point.
     */
    public void addEightForFighterB(View v) {
        scoreFighterB += 8;
        displayForFighterB(scoreFighterB);
    }

    /**
     * Increase the score for Fighter B by 9 points.
     */
    public void addNineForFighterB(View v) {
        scoreFighterB += 9;
        displayForFighterB(scoreFighterB);
    }

    /**
     * Increase the score for Fighter B by 10 points.
     */
    public void addTenForFighterB(View v) {
        scoreFighterB += 10;
        displayForFighterB(scoreFighterB);
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForFighterB(int score) {
        TextView scoreViewB = (TextView) findViewById(R.id.fighter_b_score);
        scoreViewB.setText(String.valueOf(score));
    }

    /**
     * Resets the score to 0.
     */
    public void reset(View v) {
        scoreFighterA = 0;
        scoreFighterB = 0;
        displayForFighterA(scoreFighterA);
        displayForFighterB(scoreFighterB);
    }
}