package com.example.android.quizapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.android.quizapp.R;

public class MainActivity extends AppCompatActivity {

    // Declaration/Initialization of variables

    int finalScore = 0;

    boolean qOneOpOne;
    boolean qOneOpTwo;
    boolean qOneOpThree;
    boolean qTwoOpOne;
    boolean qTwoOpTwo;
    boolean qTwoOpThree;
    boolean qThree;
    boolean qFourOpOne;
    boolean qFourOpTwo;
    boolean qFourOpThree;
    boolean qFiveOpOne;
    boolean qFiveOpTwo;
    boolean qFiveOpThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // For Radio Buttons
    public void onButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.qOneOptionOne:
                if (checked) {
                    qOneOpOne = true;
                    qOneOpTwo = false;
                    qOneOpThree = false;
                }
                break;
            case R.id.qOneOptionTwo:
                if (checked) {
                    qOneOpOne = false;
                    qOneOpTwo = true;
                    qOneOpThree = false;
                }
                break;
            case R.id.qOneOptionThree:
                if (checked) {
                    qOneOpOne = false;
                    qOneOpTwo = false;
                    qOneOpThree = true;
                }
                break;
            case R.id.qFourOptionOne:
                if (checked) {
                    qFourOpOne = true;
                    qFourOpTwo = false;
                    qFourOpThree = false;
                }
                break;
            case R.id.qFourOptionTwo:
                if (checked) {
                    qFourOpOne = false;
                    qFourOpTwo = true;
                    qFourOpThree = false;
                }
                break;
            case R.id.qFourOptionThree:
                if (checked) {
                    qFourOpOne = false;
                    qFourOpTwo = false;
                    qFourOpThree = true;
                }
                break;
            case R.id.qFiveOptionOne:
                if (checked) {
                    qFiveOpOne = true;
                    qFiveOpTwo = false;
                    qFiveOpThree = false;
                }
                break;
            case R.id.qFiveOptionTwo:
                if (checked) {
                    qFiveOpOne = false;
                    qFiveOpTwo = true;
                    qFiveOpThree = false;
                }
                break;
            case R.id.qFiveOptionThree:
                if (checked) {
                    qFiveOpOne = false;
                    qFiveOpTwo = false;
                    qFiveOpThree = true;
                }
                break;
        }
    }

    // For CheckBoxes
    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.qTwoOptionOne:
                if (checked) {
                    qTwoOpOne = true;
                    qTwoOpTwo = false;
                    qTwoOpThree = false;
                }
                break;
            case R.id.qTwoOptionTwo:
                if (checked) {
                    qTwoOpOne = false;
                    qTwoOpTwo = true;
                    qTwoOpThree = false;
                }
                break;
            case R.id.qTwoOptionThree:
                if (checked) {
                    qTwoOpOne = false;
                    qTwoOpTwo = false;
                    qTwoOpThree = true;
                }
                break;
        }
    }

    // On clicking the submit button
    public void submitQuiz(View view) {

        // Calculation of the final score
        // Question One

        if (qOneOpThree)
            finalScore = finalScore+2;

        // Question Two

        if (qTwoOpOne && qTwoOpThree && !qTwoOpTwo)
            finalScore = finalScore+2;

        // Question Three

        EditText questionThree = (EditText) findViewById(R.id.qThree);
        String answerThree = questionThree.getText().toString();
        qThree = answerThree.equals(getString(R.string.answerThree));

        if (qThree)
            finalScore = finalScore+2;

        // Question Four

        if (qFourOpOne)
            finalScore = finalScore+2;

        //Question Five

        if(qFiveOpTwo)
            finalScore = finalScore+2;

        // Calculate Result

        // Display Results
        Context context = getApplicationContext();
        CharSequence text = "you have got " + finalScore + "/10";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        // Reset Score

        finalScore = 0;
    }
}
