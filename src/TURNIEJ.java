import java.nio.channels.ScatteringByteChannel;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.*;


public class TURNIEJ {
    public ArrayList<Integer> WynikiDruzynDwaOgnie = new ArrayList<>();
    public ArrayList<Integer> WynikiDruzynSiata = new ArrayList<>();
    public ArrayList<Integer> WynikiDruzynPrzeciaganieLiny = new ArrayList<>();
    public ArrayList<DRUZYNA> Druzyny = new ArrayList<>();
    public ArrayList<SĘDZIA> sedziowie = new ArrayList<>();
    public ArrayList<SĘDZIA> Sedziowie_DwaOgnie = new ArrayList<>();

    public ArrayList<SĘDZIA> Sedziowie_SiatkowkaPlazowa = new ArrayList<>();
    public ArrayList<SĘDZIA> Sedziowie_PrzeciaganieLiny = new ArrayList<>();
    public TURNIEJ() {
    }
    public void dodajDruzyne(DRUZYNA s) {
        Druzyny.add(s);
    }


    public void WyswietlRanknig() {


        for (DRUZYNA druzyna : Druzyny) {
            if (druzyna.DziedzinaSportowa.equals("SiatkowkaPlazowa")) {
                WynikiDruzynSiata.add(druzyna.Punkty);

            }
            if (druzyna.DziedzinaSportowa.equals("DwaOgnie")) {
                WynikiDruzynDwaOgnie.add(druzyna.Punkty);
            }
            if (druzyna.DziedzinaSportowa.equals("PrzeciaganieLiny")) {
                WynikiDruzynPrzeciaganieLiny.add(druzyna.Punkty);
            }

        }
//       Collections.sort(WynikiDruzynPrzeciaganieLiny,Collections.reverseOrder());
//       Collections.sort(WynikiDruzynDwaOgnie,Collections.reverseOrder());
        Collections.sort(WynikiDruzynSiata, Collections.reverseOrder());
        System.out.println(WynikiDruzynSiata);


    }

    //tutaj domin
    public void przegladajDruzyny() {
        for (DRUZYNA druzyna : Druzyny) {
            System.out.println(Druzyny.indexOf(druzyna) + ". " + "Nazwa drużyny: " + druzyna.NazwaDruzyny + "\n" + "Dziedzina Sportowa: " + druzyna.DziedzinaSportowa + "\n" + "Dane o zawodnikach: " + "\n" + "Zawodnik nr1" + "\n" + "Imie: " + druzyna.zawodnik1.Imie + "\n" + "Nazwisko: " + druzyna.zawodnik1.Nazwisko + "\n" + "Numer: " + druzyna.zawodnik1.NumerZawodnika + "\n" + "Zawodnik nr2" + "\n" + "Imie: " + druzyna.zawodnik2.Imie + "\n" + "Nazwisko: " + druzyna.zawodnik2.Nazwisko + "\n" + "Numer: " + druzyna.zawodnik2.NumerZawodnika);
        }
    }

    public void wycofajDruzyne(int ktoraDoUsuniecia)
    {
        for (DRUZYNA druzyna: Druzyny) {
            if(Druzyny.indexOf(druzyna)  == ktoraDoUsuniecia)
            {
                Druzyny.remove(druzyna);
            }
        }
    }

    //SĘDZIOWIE

    public void dodajSedziego(SĘDZIA sędzia)
    {
        if(sędzia.DziedzinaSportowa.equals("Dwa_Ognie"))
            Sedziowie_DwaOgnie.add(sędzia);
        else if(sędzia.DziedzinaSportowa.equals("Siatkowka_Plazowa"))
            Sedziowie_SiatkowkaPlazowa.add(sędzia);
        else if(sędzia.DziedzinaSportowa.equals("Przeciaganie_Liny"))
            Sedziowie_PrzeciaganieLiny.add(sędzia);
        else {
            System.out.println("Błąd");
            return;
        }
        sedziowie.add(sędzia);
    }
    public void przegladajSedziow(){
        for (SĘDZIA sedzia: sedziowie) {
            System.out.println("Sędzia nr: "+ sedziowie.indexOf(sedzia) + "\n" + "Imie : " + sedzia.Imie + "\n" + "Nazwisko : " +sedzia.Nazwisko + "\n" + "Numer : " + sedzia.NumerSędziego + "\n" + "Dyscyplina : "+ sedzia.DziedzinaSportowa);

        }
    }
    public void usunSedziego(int ktorySedzia){
        for (SĘDZIA sedzia: sedziowie)
        {
            if(sedziowie.indexOf(sedzia) == ktorySedzia){
                sedziowie.remove(sedzia);
            }

        }
    }

    //rozgrywanie meczy

    //rozgrywanie fazygrupowej
    public void rozegrajMecz(DRUZYNA druzyna1, DRUZYNA druzyna2){


    }
    public void rozegrajFazeGrupowa(DRUZYNA druzyna1, DRUZYNA druzyna2){

    }
    //wczytywanie z pliku


    public void wczytajSędziówZPliku()
    {
        System.out.println("Podaj nazwę pliku z sędziami: ");
        Scanner sc = new Scanner(System.in);
        String nazwa;
        nazwa = sc.next();

        try{
            Scanner scanner = new Scanner(new File(nazwa));
            //String nazwaObiektu;
            String imie;
            String nazwisko;
            int nr;
            String dziedzina;

            while(scanner.hasNext())
            {
                //nazwaObiektu = scanner.next();
                imie = scanner.next();
                nazwisko = scanner.next();
                nr = scanner.nextInt();
                dziedzina = scanner.next();

                SĘDZIA sędzia = new SĘDZIA(imie, nazwisko, nr, dziedzina);
                dodajSedziego(sędzia);
            }


        }catch(FileNotFoundException e)
        {
            System.out.println("Nie udało sie otworzyc pliku.");
        }
    }

    public void wczytajDrużynyZPliku()
    {

        System.out.println("Podaj nazwę pliku z drużynami. ");
        Scanner sc = new Scanner(System.in);
        String nazwa;
        nazwa = sc.next();

        try{
            Scanner scanner = new Scanner(new File(nazwa));
            //String nazwaObiektu;
            String nazwaDruzyny;
            String dziedzina;
            //String nazwaZawodnika1;
            String imie1;
            String nazwisko1;
            int nr1;
            //String nazwaZawodnika2;
            String imie2;
            String nazwisko2;
            int nr2;

            while(scanner.hasNext())
            {
                //nazwaObiektu = scanner.next();
                nazwaDruzyny = scanner.next();
                dziedzina = scanner.next();
                //nazwaZawodnika1 = scanner.next();
                imie1 = scanner.next();
                nazwisko1 = scanner.next();
                nr1 = scanner.nextInt();
               // nazwaZawodnika2 = scanner.next();
                imie2 = scanner.next();
                nazwisko2 = scanner.next();
                nr2 = scanner.nextInt();

                ZAWODNIK zawodnik1 = new ZAWODNIK(imie1, nazwisko1, nr1);
                ZAWODNIK zawodnik2 = new ZAWODNIK(imie2, nazwisko2, nr2);
                DRUZYNA druzyna = new DRUZYNA(nazwaDruzyny, dziedzina, zawodnik1, zawodnik2);
                Druzyny.add(druzyna);
            }
        }catch(FileNotFoundException e)
    {
        System.out.println("Nie udało sie otworzyc pliku.");
    }

    }

}
