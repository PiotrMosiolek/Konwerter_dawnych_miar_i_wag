package com.example.konwerter_dawnych_miar_i_wag;

import java.text.NumberFormat;

public class Przelicznik_Masy {


    // zmienne stałe do porównania jednostek i konwersji

    // referencyjna jednostka bazowa będzie miała 1 kilogram


    final double kilogram = 1;
    final double dekagram = 100;
    final double gram = 1000;
    final double funtMorski = 0.006;
    final double centar = 0.015;
    final double kamien = 0.077;
    final double funt = 2.459;
    final double grzywna = 4.918;
    final double lut = 78.989;
    final double drachma = 315.956;
    final double tona = 0.001;



    // zmienne dla danych wejściowych i wyjściowych

    private double wartosc_poczatkowa;
    private double wartosc_koncowa;
    private String typ_jednostki_poczatkowej;
    private String typ_jednostki_koncowej;



    //konstruktor

    public Przelicznik_Masy(){

        /**   wartosc_poczatkowa = 0;
         wartosc_koncowa = 0;
         typ_jednostki_poczatkowej = "";
         typ_jednostki_koncowej = ""; **/
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
        if (typ_jednostki == "Kilogram"){return kilogram;}
        if (typ_jednostki == "Dekagram"){return dekagram;}
        if (typ_jednostki == "Gram"){return gram;}
        if (typ_jednostki == "FuntMorski"){return funtMorski;}
        if (typ_jednostki == "Centar"){return centar;}
        if (typ_jednostki == "Kamień"){return kamien;}
        if (typ_jednostki == "Funt"){return funt;}
        if (typ_jednostki == "Grzywna"){return grzywna;}
        if (typ_jednostki == "Łut"){return lut;}
        if (typ_jednostki == "Drachma"){return drachma;}
        if (typ_jednostki == "Tona"){return tona;}


        return 0;
    }

    public double obliczWartosc_koncowa(){



        //deklaracja i inicjacja zmiennych

        double wartosc_poczatkowa = getWartosc_poczatkowa();
        double wartosc_koncowa = getWartosc_koncowa();
        double typ_jednostki_poczatkowej = getTypJednostkiConstant(getTyp_jednostki_poczatkowej());
        double typ_jednostki_koncowej = getTypJednostkiConstant(getTyp_jednostki_koncowej());

        //convert na metry
        wartosc_koncowa = kilogram/typ_jednostki_poczatkowej;

        //convert z metry
        wartosc_koncowa = wartosc_koncowa * typ_jednostki_koncowej;

        //pomnożyć przez początkową ilość, aby uzyskać końcową ilość
        wartosc_koncowa = wartosc_koncowa * wartosc_poczatkowa;

        return wartosc_koncowa;

    }

    public String toString(){

        NumberFormat nf = NumberFormat.getNumberInstance();

        if (typ_jednostki_koncowej.equals("Kilogram")||typ_jednostki_koncowej.equals("Dekagram")
                ||typ_jednostki_koncowej.equals("Gram")||typ_jednostki_koncowej.equals("FuntMorski")||typ_jednostki_koncowej.equals("Centar")
                ||typ_jednostki_koncowej.equals("Kamień")||typ_jednostki_koncowej.equals("Funt")||typ_jednostki_koncowej.equals("Grzywna")
                ||typ_jednostki_koncowej.equals("Łut")||typ_jednostki_koncowej.equals("Frachma")|typ_jednostki_koncowej.equals("Tona")) {
            nf.setMaximumFractionDigits(2);
        }else {
            nf.setMaximumFractionDigits(4);
        }

        return nf.format(getWartosc_koncowa()) + " " + getTyp_jednostki_koncowej();
    }

}
