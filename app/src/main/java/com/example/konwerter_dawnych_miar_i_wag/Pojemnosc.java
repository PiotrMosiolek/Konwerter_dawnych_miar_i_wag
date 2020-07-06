package com.example.konwerter_dawnych_miar_i_wag;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Pojemnosc extends AppCompatActivity {

    Spinner covertFromUnitTypeSpinner;
    Spinner convertToUnitTypeSpinner;

    String[] typJednostki = {"Litr", "Beczka", "Półbeczka", "Konew", "Garniec","Półgarniec","Kwarta",
            "Kwaterka","Łąszt","Korzec","Półkorzec","Ćwierćkorzec","Miarka"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pojemnosc);



        covertFromUnitTypeSpinner = findViewById(R.id.spinnerZ);
        convertToUnitTypeSpinner = findViewById(R.id.spinnerNa);

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this,R.layout.custom_spinner, typJednostki);

        spinnerAdapter.setDropDownViewResource(R.layout.custom_spinner_dropdown);

        covertFromUnitTypeSpinner.setAdapter(spinnerAdapter);
        convertToUnitTypeSpinner.setAdapter(spinnerAdapter);


    }

    public void obliczWartosc_koncowa(View view) {

        double wartosc_poczatkowa;
        double wartosc_koncowa;
        String typ_jednostki_poczatkowej;
        String typ_jednostki_koncowej;

        EditText qtyEditText = findViewById(R.id.wartosc_poczatkowa);
        TextView resultOutputTextView = findViewById(R.id.rezultat);

        // Stworzenie obiektu Przelicznik długości i wywołanie go oraz klast Przelicznik_Długości
        // W ten sam sposób wywołać pozostałe przeliczniki.
        //Czyli np. Przelicznik_masy przelicznik_masy = new Przelicznik_masy();
        Przelicznik_Pojemnosci przelicznik_pojemnosci = new Przelicznik_Pojemnosci();

        if (!qtyEditText.getText().toString().equals("")) {

            wartosc_poczatkowa = Double.parseDouble(qtyEditText.getText().toString());
            typ_jednostki_poczatkowej = covertFromUnitTypeSpinner.getSelectedItem().toString();
            typ_jednostki_koncowej = convertToUnitTypeSpinner.getSelectedItem().toString();

            przelicznik_pojemnosci.setWartosc_poczatkowa(wartosc_poczatkowa);
            przelicznik_pojemnosci.setTyp_jednostki_poczatkowej(typ_jednostki_poczatkowej);
            przelicznik_pojemnosci.setTyp_jednostki_koncowej(typ_jednostki_koncowej);

            wartosc_koncowa = przelicznik_pojemnosci.obliczWartosc_koncowa();
            przelicznik_pojemnosci.setWartosc_koncowa(wartosc_koncowa);

            resultOutputTextView.setText(przelicznik_pojemnosci.toString());

        }
    }

}
