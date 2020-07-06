package com.example.konwerter_dawnych_miar_i_wag;

import java.text.NumberFormat;

public class Przelicznik_Powierzchni {



    // zmienne stałe do porównania jednostek i konwersji

    // referencyjna jednostka bazowa będzie miała 1 ar


    final double ar = 1;
    final double metrKw = 100;
    final double hektar = 0.01;
    final double lan = 0.0004;
    final double wolka = 0.001;
    final double morg = 0.017;
    final double wiertel = 0.029;
    final double kopanka = 5.263;
    final double zagon = 0.518;




    // zmienne dla danych wejściowych i wyjściowych

    private double wartosc_poczatkowa;
    private double wartosc_koncowa;
    private String typ_jednostki_poczatkowej;
    private String typ_jednostki_koncowej;



    //konstruktor

    public Przelicznik_Powierzchni(){

      /**  wartosc_poczatkowa = 0;
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
        if (typ_jednostki == "Ar"){return ar;}
        if (typ_jednostki == "MetrKw"){return metrKw;}
        if (typ_jednostki == "Hektar"){return hektar;}
        if (typ_jednostki == "Łan"){return lan;}
        if (typ_jednostki == "Wółka"){return wolka;}
        if (typ_jednostki == "Mórg"){return morg;}
        if (typ_jednostki == "Wiertel"){return wiertel;}
        if (typ_jednostki == "Kopanka"){return kopanka;}
        if (typ_jednostki == "Zagon"){return zagon;}


        return 0;
    }

    public double obliczWartosc_koncowa(){



        //deklaracja i inicjacja zmiennych

        double wartosc_poczatkowa = getWartosc_poczatkowa();
        double wartosc_koncowa = getWartosc_koncowa();
        double typ_jednostki_poczatkowej = getTypJednostkiConstant(getTyp_jednostki_poczatkowej());
        double typ_jednostki_koncowej = getTypJednostkiConstant(getTyp_jednostki_koncowej());

        //convert na metry
        wartosc_koncowa = ar/typ_jednostki_poczatkowej;

        //convert z metry
        wartosc_koncowa = wartosc_koncowa * typ_jednostki_koncowej;

        //pomnożyć przez początkową ilość, aby uzyskać końcową ilość
        wartosc_koncowa = wartosc_koncowa * wartosc_poczatkowa;

        return wartosc_koncowa;

    }

    public String toString(){

        NumberFormat nf = NumberFormat.getNumberInstance();

        if (typ_jednostki_koncowej.equals("Ar")||typ_jednostki_koncowej.equals("MetrKw")
                ||typ_jednostki_koncowej.equals("Hektar")||typ_jednostki_koncowej.equals("Łan")||typ_jednostki_koncowej.equals("Wółka")
                ||typ_jednostki_koncowej.equals("Mórg")||typ_jednostki_koncowej.equals("Wiertel")||typ_jednostki_koncowej.equals("Kopanka")
                ||typ_jednostki_koncowej.equals("Zagon")) {
            nf.setMaximumFractionDigits(2);
        }else {
            nf.setMaximumFractionDigits(4);
        }

        return nf.format(getWartosc_koncowa()) + " " + getTyp_jednostki_koncowej();
    }

}
