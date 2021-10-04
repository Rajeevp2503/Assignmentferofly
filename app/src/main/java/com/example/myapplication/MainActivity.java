package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.kofigyan.stateprogressbar.StateProgressBar;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button track;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // steps on state progress bar
        String[] descriptionData = {"Cooking", "Picked", "On way", "Delivered", "Done"};


        track = (Button) findViewById(R.id.track);

        StateProgressBar stateProgressBar = (StateProgressBar) findViewById(R.id.your_state_progress_bar_id);
        stateProgressBar.setStateDescriptionData(descriptionData);

        for(int i =2 ; i<=5; i++){

            if(i==2){
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                            stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.TWO);




                    }
                }, 5000);

            }

            if(i ==3){
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.THREE);
                    }
                }, 5000);

            }
            if(i ==4){
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.FOUR);
                    }
                }, 5000);

            }
            if(i ==5){
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.FIVE);                    }
                }, 5000);

            }

        }





        track.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri mapUri = Uri.parse("geo:0,0?q=" + Uri.encode(" MGS hospial Delhi,110026"));
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, mapUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });





        // button given along with id








    }

}