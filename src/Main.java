import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.SocketHandler;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main implements Serializable {
    public static void main(String[] args) throws Exception {
        ZAWODNIK z1 = new ZAWODNIK("Maciuś11111", "R", 13);

        ZAWODNIK z2 = new ZAWODNIK("Ulcia", "R", 4);
        ZAWODNIK z3 = new ZAWODNIK("Domiś", "Ż", 23);
        ZAWODNIK z4 = new ZAWODNIK("Romek", "A", 80);
        ZAWODNIK z5 = new ZAWODNIK("Maciuś", "R", 13);
        ZAWODNIK z6 = new ZAWODNIK("Ulcia", "R", 4);
        ZAWODNIK z7 = new ZAWODNIK("Domiś", "Ż", 23);
        ZAWODNIK z8 = new ZAWODNIK("Romek", "A", 80);
//
       // SĘDZIA s1 = new SĘDZIA("Daro", "Lew", 3, "Siatkowka_Plazowa");
        //SĘDZIA s2 = new SĘDZIA("Daro1", "Lew1", 3, "Przeciaganie_Liny");
//
//
//        DRUZYNA d1 = new DRUZYNA("Byki", "Siatkowka_Plazowa", z3, z4);
//        DRUZYNA d2 = new DRUZYNA("ZZ", "Siatkowka_Plazowa", z1, z2);
//        DRUZYNA d3 = new DRUZYNA("AA", "Siatkowka_Plazowa", z5, z6);
//        DRUZYNA d4 = new DRUZYNA("BB", "Siatkowka_Plazowa", z7, z8);
//
//        DRUZYNA d5 = new DRUZYNA("Byki", "Dwa_Ognie", z3, z4);
//        DRUZYNA d6 = new DRUZYNA("ZZ", "Dwa_Ognie", z1, z2);
//        DRUZYNA d7 = new DRUZYNA("AA", "Dwa_Ognie", z5, z6);
//        DRUZYNA d8 = new DRUZYNA("BB", "Dwa_Ognie", z7, z8);
//
//        DRUZYNA d9 = new DRUZYNA("Byki", "Przeciaganie_Liny", z3, z4);
//        DRUZYNA d10 = new DRUZYNA("ZZ", "Przeciaganie_Liny", z1, z2);
//        DRUZYNA d11 = new DRUZYNA("AA", "Przeciaganie_Liny", z5, z6);
//        DRUZYNA d12 = new DRUZYNA("BB", "Przeciaganie_Liny", z7, z8);


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
//        MeczSiatkowkaPlazowa meczSiatkowkaPlazowa = new MeczSiatkowkaPlazowa();
//        turniej.dodajDruzyne(d1);
//        turniej.dodajDruzyne(d2);
//        turniej.dodajDruzyne(d3);
//        turniej.dodajDruzyne(d4);
//        turniej.dodajDruzyne(d5);
//        turniej.dodajDruzyne(d6);
//        turniej.dodajDruzyne(d7);
//        turniej.dodajDruzyne(d8);
//        turniej.dodajDruzyne(d9);
//        turniej.dodajDruzyne(d10);
//        turniej.dodajDruzyne(d11);
//        turniej.dodajDruzyne(d12);
        //turniej.WyswietlRanknig();
        //turniej.dodajSedziego(s1);
        //turniej.dodajSedziego(s2);
//
        int wyborDruzyna=0, wyborSedzia=0, wyborSiatkowka=0, wyborOgnie=0, wyborLina=0, wyborTurniejSiata=0, wyborTurniejOgnie=0, wyborTurniejLina=0, wyborSedziaDoUsuniecia=-9;
        boolean wyborDruzynaB= true;


        String nazwadruzyny, imieZawodnika, nazwiskoZawodnika, dziedzinaSportowaDruzyny, imieSedziego, nazwiskoSedziego, dyscyplinaSedziego;
        Scanner sc = new Scanner(System.in);
        int wybor = 0, ktoraDoUsuniecia1 = 0, index2 = 0, licznikIndex1 = 0, licznikIndex2 = 0;
        int numerZawodnika = 0, numerSedziego = 0;


        while (wybor!=5) {
            System.out.println("Wybierz opcje");
            System.out.println("1. Zarządzaj drużynami");
            System.out.println("2. Zarządzaj sędziami");
            System.out.println("3. Rozegraj turniej");
            System.out.println("4. Wyświetl tabele wyników");
            System.out.println("5. Wyjdź");
            wyborDruzyna =0;
            wyborSedzia =0;
            wyborSiatkowka=0;
            wybor = sc.nextInt();
            switch (wybor) {
                case 1:

                    while (wyborDruzyna != 5) {
                        System.out.println("Wybierz opcje");
                        System.out.println("1. Dodaj drużyne");
                        System.out.println("2. Wczytaj drużyny z pliku");
                        System.out.println("3. Wycofaj drużyne");
                        System.out.println("4. Przeglądaj drużyny");
                        System.out.println("5. Wyjdz");
                        wyborDruzyna = sc.nextInt();
                        switch (wyborDruzyna) {
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
                            default:
                                System.out.println("Wybrales zly numer");
                                break;


                        }

                    }
                    break;
                case 2:
                    System.out.println("Wybierz opcje");

                    while (wyborSedzia != 5) {
                        System.out.println("1. Dodaj sędziego");
                        System.out.println("2. Wczytaj sędziów z pliku");
                        System.out.println("3. Usun sędziego");
                        System.out.println("4. Przeglądaj sędziów");
                        System.out.println("5. Wyjdz");
                        wyborSedzia = sc.nextInt();
                        switch (wyborSedzia) {
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
                               // turniej.wczytajSędziówZPliku();
                                 //turniej.zapis_stanu_sedziow_druzyn();
                               turniej.wczytanie_stanu_sedziow_druzyn();
                                break;

                            case 3:
                                System.out.println("Ktorego sedziego chcesz usunac?");
                                turniej.przegladajSedziow();
                                wyborSedziaDoUsuniecia = sc.nextInt();
                                turniej.usunSedziego(wyborSedziaDoUsuniecia);

                                break;

                            case 4:
                                turniej.przegladajSedziow();
                                break;
                            case 5:
                                break;
                            default:
                                System.out.println("Wybrales zly numer");
                                break;
                        }


                    }
                    break;
                case 3:



                    while (wyborSiatkowka != 4) {
                        System.out.println("Wybierz dyscypline w ktorej chcesz rozegrac turniej");
                        System.out.println("1. Siatkowka Plażowa");
                        System.out.println("2. Dwa Ognie");
                        System.out.println("3. Przeciąganie Liny");
                        System.out.println("4. Wyjdz");
                        wyborTurniejSiata =0;
                        wyborLina =0;
                        wyborOgnie =0;
                        wyborSiatkowka = sc.nextInt();
                        switch (wyborSiatkowka) {
                            case 1:

                                while (wyborTurniejSiata != 4) {
                                    System.out.println("1. Rozegraj faze grupową");
                                    System.out.println("2. Rozegraj półfinały");
                                    System.out.println("3. Rozegraj finał");
                                    System.out.println("4. Wyjdz");
                                    wyborTurniejSiata = sc.nextInt();
                                    switch (wyborTurniejSiata) {
                                        case 1:
                                            turniej.rozegrajFazeGrupowa(1);
                                            break;
                                        case 2:
                                            turniej.rozegrajPolfinal(1);
                                            break;
                                        case 3:

                                            turniej.rozegrajFinal(1);
                                            break;
                                        case 4:
                                            break;
                                        default:
                                            System.out.println("Wybrales zly numer, podaj numer jeszcze raz");
                                            break;
                                    }

                                }
                                break;


                            case 2:


                                while (wyborOgnie != 4) {
                                    System.out.println("1. Rozegraj faze grupową");
                                    System.out.println("2. Rozegraj półfinały");
                                    System.out.println("3. Rozegraj finał");
                                    System.out.println("4. Wyjdz");
                                    wyborOgnie = sc.nextInt();
                                    switch (wyborOgnie) {
                                        case 1:
                                            turniej.rozegrajFazeGrupowa(2);
                                            break;

                                        case 2:
                                            turniej.rozegrajPolfinal(2);
                                            break;

                                        case 3:
                                            turniej.rozegrajFinal(2);
                                            break;

                                        case 4:
                                            break;

                                        default:
                                            System.out.println("Wybrales zly numer");


                                    }

                                }
                                break;

                            case 3:

                                while (wyborLina != 4) {
                                    System.out.println("1. Rozegraj faze grupową");
                                    System.out.println("2. Rozegraj półfinały");
                                    System.out.println("3. Rozegraj finał");
                                    System.out.println("4. Wyjdz");
                                    wyborLina = sc.nextInt();
                                    switch (wyborLina) {
                                        case 1:
                                            turniej.rozegrajFazeGrupowa(3);
                                            break;
                                        case 2:
                                            turniej.rozegrajPolfinal(3);
                                            break;
                                        case 3:
                                            turniej.rozegrajFinal(3);
                                            break;
                                        case 4:
                                            break;
                                        default:
                                            System.out.println("Wybrales zly numer");
                                            break;

                                    }

                                }
                                break;
                            case 4:
                                break;
                            default:
                                System.out.println("Wybrales zly numer");
                                break;



                        }

                    }
                case 4:
                    turniej.tabelaWynikow();
                    break;
                case 5:
                    System.out.println("Wyszedles z programu naura");
                    System.exit(-1);
                    break;
                default:
                    System.out.println("Podales zly numer");
                    break;



            }

        }
    }
}