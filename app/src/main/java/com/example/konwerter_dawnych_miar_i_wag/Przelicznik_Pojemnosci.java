package com.example.konwerter_dawnych_miar_i_wag;

import java.text.NumberFormat;

public class Przelicznik_Pojemnosci {

    // zmienne stałe do porównania jednostek i konwersji

    // referencyjna jednostka bazowa będzie miała 1 litr


    final double litr = 1;
    final double beczka = 0.004;
    final double polbeczka = 0.008;
    final double konew = 0.053;
    final double garniec = 0.265;
    final double polgarniec = 0.532;
    final double kwarta = 1.062;
    final double kwaterka = 4.237;
    final double laszt = 0.000275;
    final double korzec = 0.008;
    final double polkorzec = 0.017;
    final double cwierckorzec = 0.033;
    final double miarka = 0.066;



    // zmienne dla danych wejściowych i wyjściowych

    private double wartosc_poczatkowa;
    private double wartosc_koncowa;
    private String typ_jednostki_poczatkowej;
    private String typ_jednostki_koncowej;


    //constructor
    //konstruktor

    public Przelicznik_Pojemnosci(){

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
        if (typ_jednostki == "Litr"){return litr;}
        if (typ_jednostki == "Beczka"){return beczka;}
        if (typ_jednostki == "Półbeczka"){return polbeczka;}
        if (typ_jednostki == "Konew"){return konew;}
        if (typ_jednostki == "Garniec"){return garniec;}
        if (typ_jednostki == "Półgarniec"){return polgarniec;}
        if (typ_jednostki == "Kwarta"){return kwarta;}
        if (typ_jednostki == "Kwaterka"){return kwaterka;}
        if (typ_jednostki == "Łaszt"){return laszt;}
        if (typ_jednostki == "Korzec"){return korzec;}
        if (typ_jednostki == "Ćwierćkorzec"){return cwierckorzec;}
        if (typ_jednostki == "Półkorzec"){return polkorzec;}
        if (typ_jednostki == "Miarka"){return miarka;}

        return 0;
    }

    public double obliczWartosc_koncowa(){


        //declare and initialize variables
        //deklaracja i inicjacja zmiennych

        double wartosc_poczatkowa = getWartosc_poczatkowa();
        double wartosc_koncowa = getWartosc_koncowa();
        double typ_jednostki_poczatkowej = getTypJednostkiConstant(getTyp_jednostki_poczatkowej());
        double typ_jednostki_koncowej = getTypJednostkiConstant(getTyp_jednostki_koncowej());

        //convert na metry
        wartosc_koncowa = litr/typ_jednostki_poczatkowej;

        //convert z metry
        wartosc_koncowa = wartosc_koncowa * typ_jednostki_koncowej;

        //pomnożyć przez początkową ilość, aby uzyskać końcową ilość
        wartosc_koncowa = wartosc_koncowa * wartosc_poczatkowa;

        return wartosc_koncowa;

    }

    public String toString(){

        NumberFormat nf = NumberFormat.getNumberInstance();

        if (typ_jednostki_koncowej.equals("Litr")||typ_jednostki_koncowej.equals("Beczka")
                ||typ_jednostki_koncowej.equals("Półbeczka")||typ_jednostki_koncowej.equals("Konew")||typ_jednostki_koncowej.equals("Garniec")
                ||typ_jednostki_koncowej.equals("Półgarniec")||typ_jednostki_koncowej.equals("Kwarta")||typ_jednostki_koncowej.equals("Kwaterka")
                ||typ_jednostki_koncowej.equals("Łąszt")||typ_jednostki_koncowej.equals("Korzec")|typ_jednostki_koncowej.equals("Półkorzec")
                ||typ_jednostki_koncowej.equals("Ćwierćkorzec")||typ_jednostki_koncowej.equals("Miarka")) {
            nf.setMaximumFractionDigits(2);
        }else {
            nf.setMaximumFractionDigits(4);
        }

        return nf.format(getWartosc_koncowa()) + " " + getTyp_jednostki_koncowej();
    }

}
