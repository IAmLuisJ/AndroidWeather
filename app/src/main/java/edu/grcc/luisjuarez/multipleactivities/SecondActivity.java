package edu.grcc.luisjuarez.multipleactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //set title with city parameter that was passed in from first view
        TextView textViewCity = findViewById(R.id.textViewCity);
        String city = getIntent().getExtras().getString("passcity");
        textViewCity.setText(city);

        //returns to main activity
        Button exitButton = findViewById(R.id.buttonExit);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
