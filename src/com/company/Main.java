package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        /*
        Pseudokod

        Entity: Hrac1, Hrac2, Vitez, Plocha

        1) Inicializovat entity
        2) Vyzvat hrace na tah
        3) Check volna pozice
            a) ano - umistit znak na pozici, ukazat plochu
            b) ne - dokud nenajde volnou pozici znovu vyzvat
        4) Check vitezstvi
            a) ano - ukoncit hru ukazat jmeno viteze
            b) ne - pokracovat
        5) Check plna plocha (plichta)
            a) ano - konec hry, vypsat,ze je plichta
            b) ne - bod 2
        */

        Scanner scanner = new Scanner(System.in);
        Plocha plocha = new Plocha(3,3);
        Hrac vitez = null;
        Hrac hrac1 = new Hrac("x");
        Hrac hrac2 = new Hrac("o");
        Hrac hracNaTahu = hrac1;
        System.out.println("Zadej jmeno hrace1");
        hrac1.setName(scanner.next());
        System.out.println("Zadej jmeno hrace2");
        hrac2.setName(scanner.next());

        do {
            boolean jsouSouradniceZadany = false;
            do {
                System.out.println("Hrac na tahu: " + hracNaTahu.getName());
                System.out.println("Zadej radek");
                hracNaTahu.setRadek(scanner.nextInt());
                System.out.println("Zadej sloupec");
                hracNaTahu.setSloupec(scanner.nextInt());
                if (!plocha.jePoziceVolna(hracNaTahu.getRadek(), hracNaTahu.getSloupec()))
                    System.out.println("Pozice je jiz obsazena");
                else {
                    plocha.umistiZnak(hracNaTahu.getRadek(), hracNaTahu.getSloupec(), hracNaTahu.getSymbol());
                    plocha.ukazPlochu();
                    hracNaTahu = (hracNaTahu==hrac1) ? hrac2 : hrac1;
                    jsouSouradniceZadany = true;
                }
            } while (!jsouSouradniceZadany);

        vitez = plocha.zjistiViteze(hrac1,hrac2);
        }while(vitez==null && plocha.jePlnaPlocha()==false);

        if(vitez!=null) System.out.println("Vitezem je hrac " + vitez.getName());
        else System.out.println("Hra skoncila remizou.");




















    }
}
