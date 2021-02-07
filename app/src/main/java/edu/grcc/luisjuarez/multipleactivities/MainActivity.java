package edu.grcc.luisjuarez.multipleactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Launch second activity
        Button buttonSecondActivity = findViewById(R.id.buttonSecActivity);
        buttonSecondActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SecondActivity.class);
                EditText editTextCity = findViewById(R.id.editTextCity);
                String city = editTextCity.getText().toString();
                i.putExtra("passcity", city);
                startActivity(i);
            }
        });

        //launch browser to show weather website
        Button buttonWeather = findViewById(R.id.buttonWeather);
        buttonWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextCity = findViewById(R.id.editTextCity);
                String city = editTextCity.getText().toString();
                city = city.replace(" ", "-");
                Uri webAddress = Uri.parse("https://www.wunderground.com/weather/us/mi/" + city);
                Intent intent = new Intent(Intent.ACTION_VIEW, webAddress);
                if (intent.resolveActivity(getPackageManager()) !=null) {
                    startActivity(intent);
                }
            }
        });
    }
}
