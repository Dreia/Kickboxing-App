package com.example.android.courtcounter;

import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    //Define and initialize the integers and views used in the application
    int scoreFighterA;
    int scoreFighterB;
    TextView scoreViewB;
    TextView scoreViewA;
    EditText nameA;
    EditText nameB;
    String s1;
    String s2;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //Save the score
        s1 = getString(R.string.keyscoreA);
        s2 = getString(R.string.keyscoreB);
        outState.putInt(s1, scoreFighterA);
        outState.putInt(s2, scoreFighterB);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        //Restore information to the integers
        scoreFighterA = savedInstanceState.getInt(s1);
        scoreFighterB = savedInstanceState.getInt(s2);
        //Pass restored values to the TextViews.
        displayForFighterA(scoreFighterA);
        displayForFighterB(scoreFighterB);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Initialize variables
        scoreFighterA = 0;
        scoreFighterB = 0;
        scoreViewB = (TextView) findViewById(R.id.fighter_b_score);
        scoreViewA = (TextView) findViewById(R.id.fighter_a_score);
        nameA = findViewById(R.id.fighter_a);
        nameB = findViewById(R.id.fighter_b);
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
     * Checks EditText fighter_a and fighter_b
     *
     * @return string of the name
     */
    private String getNameA() {
        return nameA.getText().toString();
    }

    private String getNameB() {
        return nameB.getText().toString();
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
        scoreViewB.setText(String.valueOf(score));
    }

    /**
     * This method creates summary message
     *
     * @param winner
     * @return summaryMessage
     */
    private String createSummary(String winner, int totalScore) {
        String summaryMessage = winner + getString(R.string.summary_message);
        summaryMessage = summaryMessage + getString(R.string.summary_message_space) + totalScore + getString(R.string.summary_message_point);
        return summaryMessage;
    }

    /**
     * Resets the score to 0 and displays winner in a toast message
     */
    public void winner(View v) {
        String summaryMessage = "null";
        String name = "null";
        if (scoreFighterA > scoreFighterB) {
            name = getNameA();
            summaryMessage = createSummary(name, scoreFighterA);
        } else {
            if (scoreFighterA == scoreFighterB) {
                summaryMessage = "It´ a draw";
            } else {
                name = getNameB();
                summaryMessage = createSummary(name, scoreFighterB);
            }
        }
        Toast.makeText(this, summaryMessage, Toast.LENGTH_LONG).show();
        scoreFighterA = 0;
        scoreFighterB = 0;
        displayForFighterA(scoreFighterA);
        displayForFighterB(scoreFighterB);
    }
}