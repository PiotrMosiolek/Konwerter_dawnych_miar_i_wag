package com.example.konwerter_dawnych_miar_i_wag;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Dlugosc extends AppCompatActivity {

    Spinner covertFromUnitTypeSpinner;
    Spinner convertToUnitTypeSpinner;

    String[] typJednostki = {"Metry","Centymetry","Milimetry", "Sążeń", "Łokieć", "Stopy", "Ćwierć","Dłoń","Palec",
            "Ziarno","Staje","Sznur","Laska","Pręt","Krok"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dlugosc);



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

        // Stworzenie obiektu Przelicznik długości i wywołanie go oraz klasy Przelicznik_Długości

        Przelicznik_Dlugosci Przelicznik_Dlugosci = new Przelicznik_Dlugosci();

        if (!qtyEditText.getText().toString().equals("")) {

            wartosc_poczatkowa = Double.parseDouble(qtyEditText.getText().toString());
            typ_jednostki_poczatkowej = covertFromUnitTypeSpinner.getSelectedItem().toString();
            typ_jednostki_koncowej = convertToUnitTypeSpinner.getSelectedItem().toString();

            Przelicznik_Dlugosci.setWartosc_poczatkowa(wartosc_poczatkowa);
            Przelicznik_Dlugosci.setTyp_jednostki_poczatkowej(typ_jednostki_poczatkowej);
            Przelicznik_Dlugosci.setTyp_jednostki_koncowej(typ_jednostki_koncowej);

            wartosc_koncowa = Przelicznik_Dlugosci.obliczWartosc_koncowa();
            Przelicznik_Dlugosci.setWartosc_koncowa(wartosc_koncowa);

            resultOutputTextView.setText(Przelicznik_Dlugosci.toString());
        }

    }

}
