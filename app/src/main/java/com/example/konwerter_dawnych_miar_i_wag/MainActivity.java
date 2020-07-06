package com.example.konwerter_dawnych_miar_i_wag;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button buttLong = (Button)findViewById(R.id.buttonDlugosc);
        Button buttWeight = (Button)findViewById(R.id.buttonMasa);
        Button buttArea = (Button)findViewById(R.id.buttonPowierzchnia);
        Button buttCapacity = (Button)findViewById(R.id.buttonPojemnosc);

        buttLong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intLong = new Intent(MainActivity.this, Dlugosc.class);
                startActivity(intLong);
            }
        });

        buttWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intWeight = new Intent(MainActivity.this, Masa.class);
                startActivity(intWeight);
            }
        });

        buttArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intArea = new Intent(MainActivity.this, Powierzchnia.class);
                startActivity(intArea);
            }
        });

        buttCapacity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intCapacity = new Intent(MainActivity.this, Pojemnosc.class);
                startActivity(intCapacity);
            }
        });

    }
}
