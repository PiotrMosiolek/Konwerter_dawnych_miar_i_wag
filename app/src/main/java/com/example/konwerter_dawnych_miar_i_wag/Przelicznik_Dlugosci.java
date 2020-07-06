package com.example.konwerter_dawnych_miar_i_wag;

import java.text.NumberFormat;

public class Przelicznik_Dlugosci {

    // zmienne stałe do porównania jednostek i konwersji

    // referencyjna jednostka bazowa będzie miała 1 metr

    final double metry = 1; // współczynnik konwersji
    final double centymetry = 100;
    final double milimetry = 1000;
    final double sazen = 0.56;
    final double lokiec = 1.678;
    final double stopa = 3.356;
    final double cwierc = 6.711;
    final double dlon = 13.423;
    final double palec = 40.323;
    final double ziarno = 322.581;
    final double staje = 0.001;
    final double sznur = 0.023;
    final double laska = 0.112;
    final double pret = 0.224;
    final double krok = 0.448;

    // zmienne dla danych wejściowych i wyjściowych

    private double wartosc_poczatkowa;
    private double wartosc_koncowa;
    private String typ_jednostki_poczatkowej;
    private String typ_jednostki_koncowej;

    //konstruktor

    public Przelicznik_Dlugosci(){

        wartosc_poczatkowa = 0;
        wartosc_koncowa = 0;
        typ_jednostki_poczatkowej = "";
        typ_jednostki_koncowej = "";
    }

    public double getWartosc_poczatkowa() {
        return wartosc_poczatkowa;
    }

    public void setWartosc_poczatkowa(double wartosc_poczatkowa) {
        this.wartosc_poczatkowa = wartosc_poczatkowa;
    }

    public double getWartosc_koncowa(){
        return wartosc_koncowa;
    }

    public void setWartosc_koncowa(double wartosc_koncowa) {
        this.wartosc_koncowa = wartosc_koncowa;
    }

    public String getTyp_jednostki_poczatkowej() {
        return typ_jednostki_poczatkowej;
    }

    public void setTyp_jednostki_poczatkowej(String typ_jednostki_poczatkowej) {
        this.typ_jednostki_poczatkowej = typ_jednostki_poczatkowej;
    }

    public String getTyp_jednostki_koncowej() {
        return typ_jednostki_koncowej;
    }

    public void setTyp_jednostki_koncowej(String typ_jednostki_koncowej) {
        this.typ_jednostki_koncowej = typ_jednostki_koncowej;
    }

    public double getTypJednostkiConstant(String typ_jednostki){
        if (typ_jednostki == "Metry"){return metry;}
        if (typ_jednostki == "Centymetry"){return centymetry;}
        if (typ_jednostki == "Milimetry"){return milimetry;}
        if (typ_jednostki == "Sążeń"){return sazen;}
        if (typ_jednostki == "Łokieć"){return lokiec;}
        if (typ_jednostki == "Stopy"){return stopa;}
        if (typ_jednostki == "Ćwierć"){return cwierc;}
        if (typ_jednostki == "Dłoń"){return dlon;}
        if (typ_jednostki == "Palec"){return palec;}
        if (typ_jednostki == "Ziarno"){return ziarno;}
        if (typ_jednostki == "Staje"){return staje;}
        if (typ_jednostki == "Sznur"){return sznur;}
        if (typ_jednostki == "Laska"){return laska;}
        if (typ_jednostki == "Pręt"){return pret;}
        if (typ_jednostki == "Krok"){return krok;}

        return 0;
    }

    public double obliczWartosc_koncowa(){

        //deklaracja i inicjacja zmiennych

        double wartosc_poczatkowa = getWartosc_poczatkowa();
        double typ_jednostki_poczatkowej = getTypJednostkiConstant(getTyp_jednostki_poczatkowej());
        double typ_jednostki_koncowej = getTypJednostkiConstant(getTyp_jednostki_koncowej());

        //konwersja jednostki początkowej na metry

        wartosc_koncowa = metry / typ_jednostki_poczatkowej;

        //konwersja z metrów na jednostkę końcową
        wartosc_koncowa = wartosc_koncowa * typ_jednostki_koncowej;

        //pomnożyć przez początkową ilość, aby uzyskać końcową ilość
        wartosc_koncowa = wartosc_koncowa * wartosc_poczatkowa;

        return wartosc_koncowa;
    }

    public String toString(){

        NumberFormat nf = NumberFormat.getNumberInstance();

        if (typ_jednostki_koncowej.equals("Metry")|| typ_jednostki_koncowej.equals("Centymetry") || typ_jednostki_koncowej.equals("Millimetry")
                ||typ_jednostki_koncowej.equals("Sążeń")
                ||typ_jednostki_koncowej.equals("Łokieć")||typ_jednostki_koncowej.equals("Stopy")||typ_jednostki_koncowej.equals("Ćwierć")
                ||typ_jednostki_koncowej.equals("Dłoń")||typ_jednostki_koncowej.equals("Palec")||typ_jednostki_koncowej.equals("Ziarno")
                ||typ_jednostki_koncowej.equals("Staje")||typ_jednostki_koncowej.equals("Sznur")|typ_jednostki_koncowej.equals("Laska")
                ||typ_jednostki_koncowej.equals("Pręt")||typ_jednostki_koncowej.equals("Krok")) {
            nf.setMaximumFractionDigits(2);
        }else {
            nf.setMaximumFractionDigits(4);
        }

        return nf.format(getWartosc_koncowa()) + " " + getTyp_jednostki_koncowej();
    }

}
