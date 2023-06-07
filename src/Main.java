import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.SocketHandler;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ZAWODNIK z1 = new ZAWODNIK("Maciuś", "R", 13);

        ZAWODNIK z2 = new ZAWODNIK("Ulcia", "R", 4);
        ZAWODNIK z3 = new ZAWODNIK("Domiś", "Ż", 23);
        ZAWODNIK z4 = new ZAWODNIK("Romek", "A", 80);
        ZAWODNIK z5 = new ZAWODNIK("Maciuś", "R", 13);
        ZAWODNIK z6 = new ZAWODNIK("Ulcia", "R", 4);
        ZAWODNIK z7 = new ZAWODNIK("Domiś", "Ż", 23);
        ZAWODNIK z8 = new ZAWODNIK("Romek", "A", 80);

        SĘDZIA s1 = new SĘDZIA("Daro", "Lew", 3, "DwaOgnie");
        SĘDZIA s2 = new SĘDZIA("Daro1", "Lew1", 3, "DwaOgnie1");


        DRUZYNA d1 = new DRUZYNA("Byki", "Siatkowka Plazowa", z3, z4);
        DRUZYNA d2 = new DRUZYNA("ZZ", "Siatkowka Plazowa", z1, z2);
        DRUZYNA d3 = new DRUZYNA("AA", "Siatkowka Plazowa", z5, z6);
        DRUZYNA d4 = new DRUZYNA("BB", "Siatkowka Plazowa", z7, z8);

//
//        MeczDwaOgnie m1 = new MeczDwaOgnie(d1, d2, s1);
//        MeczDwaOgnie m2 = new MeczDwaOgnie(d2, d3, s1);
//        MeczDwaOgnie m4 = new MeczDwaOgnie(d1, d3, s1);
//        MeczDwaOgnie m5 = new MeczDwaOgnie(d1, d4, s1);
//        MeczDwaOgnie m6 = new MeczDwaOgnie(d2, d4, s1);
//        MeczDwaOgnie m7 = new MeczDwaOgnie(d3, d4, s1);

//        System.out.println("Wynik m1=" + m1.wynik);
//        System.out.println("Pkt d1=" + d1.Punkty);
//        System.out.println("Pkt d2=" + d2.Punkty);

//
//        //odtad domin!!
        TURNIEJ turniej = new TURNIEJ();
        //MeczSiatkowkaPlazowa meczSiatkowkaPlazowa = new MeczSiatkowkaPlazowa();
        turniej.dodajDruzyne(d1);
        turniej.dodajDruzyne(d2);
        turniej.dodajDruzyne(d3);
        turniej.dodajDruzyne(d4);
        //turniej.WyswietlRanknig();
        turniej.dodajSedziego(s1);
        turniej.dodajSedziego(s2);
//


        String nazwadruzyny, imieZawodnika, nazwiskoZawodnika, dziedzinaSportowaDruzyny, imieSedziego, nazwiskoSedziego, dyscyplinaSedziego;
        Scanner sc = new Scanner(System.in);
        int wybor = 0, ktoraDoUsuniecia1 = 0, index2=0, licznikIndex1=0, licznikIndex2=0;
        int numerZawodnika = 0, numerSedziego = 0;
        System.out.println("Wybierz opcje");

        while (true) {
            System.out.println("1. Zarządzaj drużynami");
            System.out.println("2. Zarządzaj sędziami");
            System.out.println("3. Rozegraj turniej");
            System.out.println("4. Wyświetl tabele wyników");
            wybor = sc.nextInt();
            switch (wybor) {
                case 1:
                    System.out.println("Wybierz opcje");
                    while (wybor != 5) {
                        System.out.println("1. Dodaj drużyne");
                        System.out.println("2. Wczytaj drużyny z pliku");
                        System.out.println("3. Wycofaj drużyne");
                        System.out.println("4. Przeglądaj drużyny");
                        System.out.println("5. Wyjdz");
                        wybor = sc.nextInt();
                        switch (wybor) {
                            case 1:
                                System.out.println("Podaj nazwe druzyny");
                                nazwadruzyny = sc.next();
                                System.out.println("Podaj dane zawodnika nr1");
                                System.out.println("Podaj imie zawodnika");
                                imieZawodnika = sc.next();
                                System.out.println("podaj nazwisko zawodnika");
                                nazwiskoZawodnika = sc.next();
                                System.out.println("Podaj numer zawodnika");
                                numerZawodnika = sc.nextInt();
                                ZAWODNIK zawodnik1 = new ZAWODNIK(imieZawodnika, nazwiskoZawodnika, numerZawodnika);
                                System.out.println("Podaj dane zawodnika nr2");
                                System.out.println("Podaj imie zawodnika");
                                imieZawodnika = sc.next();
                                System.out.println("podaj nazwisko zawodnika");
                                nazwiskoZawodnika = sc.next();
                                System.out.println("Podaj numer zawodnika");
                                numerZawodnika = sc.nextInt();
                                ZAWODNIK zawodnik2 = new ZAWODNIK(imieZawodnika, nazwiskoZawodnika, numerZawodnika);
                                System.out.println("Podaj do jakiego sportu chcesz zapisac druzyne");
                                dziedzinaSportowaDruzyny = sc.next();
                                DRUZYNA druzyna = new DRUZYNA(nazwadruzyny, dziedzinaSportowaDruzyny, zawodnik1, zawodnik2);
                                turniej.dodajDruzyne(druzyna);
                                break;

                            case 2:
                                turniej.wczytajDrużynyZPliku();
                                break;

                            case 3:
                                System.out.println("Ktora druzyne chcesz wycofać");
                                turniej.przegladajDruzyny();
                                ktoraDoUsuniecia1 = sc.nextInt();
                                turniej.wycofajDruzyne(ktoraDoUsuniecia1);//nie dziala usuwanie ostatniej druzyny
                                break;

                            case 4:
                                turniej.przegladajDruzyny();
                                break;


                            case 5:
                                break;


                        }

                    }
                    break;
                case 2:
                    System.out.println("Wybierz opcje");

                    while (wybor != 5) {
                        System.out.println("1. Dodaj sędziego");
                        System.out.println("2. Wczytaj sędziów z pliku");
                        System.out.println("3. Usun sędziego");
                        System.out.println("4. Przeglądaj sędziów");
                        System.out.println("5. Wyjdz");
                        wybor = sc.nextInt();
                        switch (wybor) {
                            case 1:
                                System.out.println("Podaj imie sędziego");
                                imieSedziego = sc.next();
                                System.out.println("Podaj nazwisko sędziego");
                                nazwiskoSedziego = sc.next();
                                System.out.println("Podaj numer sędziego");
                                numerSedziego = sc.nextInt();
                                System.out.println("Podaj dyscypline sedziego");
                                dyscyplinaSedziego = sc.next();
                                SĘDZIA sędzia = new SĘDZIA(imieSedziego, nazwiskoSedziego, numerSedziego, dyscyplinaSedziego);
                                turniej.dodajSedziego(sędzia);
                                break;

                            case 2:
                                turniej.wczytajSędziówZPliku();
                                break;

                            case 3:
                                System.out.println("Ktorego sedziego chcesz usunac?");
                                turniej.przegladajSedziow();
                                wybor = sc.nextInt();
                                turniej.usunSedziego(wybor);

                                break;

                            case 4:
                                turniej.przegladajSedziow();
                                break;
                            case 5:
                                break;
                        }


                    }
                    break;
                case 3:
                    System.out.println("Wybierz dyscypline w ktorej chcesz rozegrac turniej");
                    System.out.println("1. Siatkowka Plażowa");
                    System.out.println("2. Dwa Ognie");
                    System.out.println("3. Przeciąganie Liny");
                    System.out.println("4. Wyjdz");
                    wybor = sc.nextInt();
                    while (wybor != 4) {
                        switch (wybor) {
                            case 1:
                                System.out.println("1. Rozegraj faze grupową");
                                System.out.println("2. Rozegraj półfinały");
                                System.out.println("3. Rozegraj finał");
                                System.out.println("4. Wyjdz");
                                wybor = sc.nextInt();
                                while (wybor != 4) {
                                    switch (wybor) {
                                        case 1:
                                            for (DRUZYNA druzyna: turniej.Druzyny) {
                                                licznikIndex1 = turniej.Druzyny.indexOf(druzyna);
                                                if(druzyna.DziedzinaSportowa.equals("Siatkowka_Plazowa"))
                                                {
//
                                                    for (int i = licznikIndex1+1; i < turniej.Druzyny.size(); i++) {
                                                      if(turniej.Druzyny.get(i).DziedzinaSportowa.equals("Siatkowka_Plazowa")){
                                                          MeczSiatkowkaPlazowa meczSiatkowkaPlazowa = new MeczSiatkowkaPlazowa(turniej.Druzyny.get(licznikIndex1),turniej.Druzyny.get(i), turniej.Sedziowie_SiatkowkaPlazowa);

                                                          System.out.println("Druzyna "+ licznikIndex1+  "vs "+  " Druzyna " +i + "Sędzia głwóny:"+meczSiatkowkaPlazowa.sedzia1.Imie+"Sędzia liniowy 1:"+meczSiatkowkaPlazowa.sedzia2.Imie+"Sędzia liniowy 2:"+meczSiatkowkaPlazowa.sedzia3.Imie);
                                                          System.out.println(meczSiatkowkaPlazowa.wynikd1 + " " + meczSiatkowkaPlazowa.wynikd2);
                                                        }
                                                    }
                                                }
                                            }


                                            System.out.println("Tabela punktów drużyn po fazie grupowej");
                                            for (DRUZYNA druzyny:turniej.Druzyny) {
                                                System.out.println(druzyny.NazwaDruzyny + " " + druzyny.Punkty);
                                            }


                                            break;
                                        case 2:

                                            break;
                                        case 3:
                                            break;
                                        case 4:
                                            break;
                                    }
                                    break;
                                }
                                break;
                         case 2:

                            System.out.println("1. Rozegraj faze grupową");
                            System.out.println("2. Rozegraj półfinały");
                            System.out.println("3. Rozegraj finał");
                            System.out.println("4. Wyjdz");
                            wybor = sc.nextInt();
                            while (wybor != 4) {
                                switch (wybor) {
                                    case 1:
                                        for (DRUZYNA druzyna : turniej.Druzyny) {
                                            licznikIndex1 = turniej.Druzyny.indexOf(druzyna);
                                            if (druzyna.DziedzinaSportowa.equals("Dwa_Ognie")) {
//
                                                for (int i = licznikIndex1 + 1; i < turniej.Druzyny.size(); i++) {
                                                    if (turniej.Druzyny.get(i).DziedzinaSportowa.equals("Dwa_Ognie")) {
                                                        MeczDwaOgnie meczDwaOgnie = new MeczDwaOgnie(turniej.Druzyny.get(licznikIndex1),turniej.Druzyny.get(i), turniej.Sedziowie_DwaOgnie);

                                                        System.out.println("Druzyna "+ licznikIndex1+  "vs "+  " Druzyna " +i+"Sędzia który sędziował: "+meczDwaOgnie.sedzia1.Imie );
                                                        System.out.println(meczDwaOgnie.wynikd1 + " " + meczDwaOgnie.wynikd2);
                                                    }
                                                }
                                            }
                                        }

                                        System.out.println("Tabela punktów drużyn po fazie grupowej");
                                        for (DRUZYNA druzyny : turniej.Druzyny) {
                                            System.out.println(druzyny.NazwaDruzyny + " " + druzyny.Punkty);
                                        }
                                        break;
                                }
                        break;

                    }

             case 3:
                 System.out.println("1. Rozegraj faze grupową");
                 System.out.println("2. Rozegraj półfinały");
                 System.out.println("3. Rozegraj finał");
                 System.out.println("4. Wyjdz");
                 wybor = sc.nextInt();
                 while (wybor != 4) {
                     switch (wybor) {
                         case 1:

                         for (DRUZYNA druzyna : turniej.Druzyny) {
                             licznikIndex1 = turniej.Druzyny.indexOf(druzyna);
                             if (druzyna.DziedzinaSportowa.equals("Przeciaganie_Liny")) {
//
                                 for (int i = licznikIndex1 + 1; i < turniej.Druzyny.size(); i++) {
                                     if (turniej.Druzyny.get(i).DziedzinaSportowa.equals("Przeciaganie_Liny")) {
                                         MeczPrzeciaganieLiny meczPrzeciaganieLiny = new MeczPrzeciaganieLiny(turniej.Druzyny.get(licznikIndex1), turniej.Druzyny.get(i), turniej.Sedziowie_PrzeciaganieLiny);

                                         System.out.println("Druzyna " + licznikIndex1 + "vs " + " Druzyna " + i + "Sędzia: " + meczPrzeciaganieLiny.sedzia1.Imie);
                                         System.out.println(meczPrzeciaganieLiny.wynikd1 + " " + meczPrzeciaganieLiny.wynikd2);
                                     }
                                 }
                             }
                         }

                         System.out.println("Tabela punktów drużyn po fazie grupowej");
                         for (DRUZYNA druzyny : turniej.Druzyny) {
                             System.out.println(druzyny.NazwaDruzyny + " " + druzyny.Punkty);
                         }
                         break;
                     }
        }


   }

}}}}}