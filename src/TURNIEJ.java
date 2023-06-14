import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.io.*;


public class TURNIEJ {
    public ArrayList<DRUZYNA> Druzyny = new ArrayList<>();
    public ArrayList<SĘDZIA> sedziowie = new ArrayList<>();
    public ArrayList<SĘDZIA> Sedziowie_DwaOgnie = new ArrayList<>();
    public ArrayList<DRUZYNA> finalisciSiatkowka = new ArrayList<>();
    public ArrayList<DRUZYNA> finalisciOgnie = new ArrayList<>();
    public ArrayList<DRUZYNA> finalisciLina = new ArrayList<>();
    public ArrayList<DRUZYNA> listaDruzynSiata = new ArrayList<>();
    public ArrayList<DRUZYNA> listaDruzynOgnie = new ArrayList<>();
    public ArrayList<DRUZYNA> listaDruzynLina = new ArrayList<>();
    public ArrayList<SĘDZIA> Sedziowie_SiatkowkaPlazowa = new ArrayList<>();
    public ArrayList<SĘDZIA> Sedziowie_PrzeciaganieLiny = new ArrayList<>();
    private int index1 = 0, index2 = 0;

    public TURNIEJ() {
    }

    public void dodajDruzyne(DRUZYNA s) {
        Druzyny.add(s);
    }



    public void przegladajDruzyny() {
        for (DRUZYNA druzyna : Druzyny) {
            System.out.println(Druzyny.indexOf(druzyna) + ". " + "Nazwa drużyny: " + druzyna.NazwaDruzyny + "\n" + "Dziedzina Sportowa: " + druzyna.DziedzinaSportowa + "\n" + "Dane o zawodnikach: " + "\n" + "Zawodnik nr1" + "\n" + "Imie: " + druzyna.zawodnik1.Imie + "\n" + "Nazwisko: " + druzyna.zawodnik1.Nazwisko + "\n" + "Numer: " + druzyna.zawodnik1.NumerZawodnika + "\n" + "Zawodnik nr2" + "\n" + "Imie: " + druzyna.zawodnik2.Imie + "\n" + "Nazwisko: " + druzyna.zawodnik2.Nazwisko + "\n" + "Numer: " + druzyna.zawodnik2.NumerZawodnika);
        }
    }

    public void wycofajDruzyne(int ktoraDoUsuniecia) {
        Iterator<DRUZYNA> iterator = Druzyny.iterator();
        while (iterator.hasNext()) {
            DRUZYNA druzyna = iterator.next();
            if (Druzyny.indexOf(druzyna) == ktoraDoUsuniecia) {
                iterator.remove();
                break;
            }
        }
    }

    //SĘDZIOWIE

    public void dodajSedziego(SĘDZIA sędzia) {
        if (sędzia.DziedzinaSportowa.equals("Dwa_Ognie"))
            Sedziowie_DwaOgnie.add(sędzia);
        else if (sędzia.DziedzinaSportowa.equals("Siatkowka_Plazowa"))
            Sedziowie_SiatkowkaPlazowa.add(sędzia);
        else if (sędzia.DziedzinaSportowa.equals("Przeciaganie_Liny"))
            Sedziowie_PrzeciaganieLiny.add(sędzia);
        else {
            System.out.println("Błąd");
            return;
        }
        sedziowie.add(sędzia);
    }

    public void przegladajSedziow() {
        for (SĘDZIA sedzia : sedziowie) {
            System.out.println("Sędzia nr: " + sedziowie.indexOf(sedzia) + "\n" + "Imie : " + sedzia.Imie + "\n" + "Nazwisko : " + sedzia.Nazwisko + "\n" + "Numer : " + sedzia.NumerSędziego + "\n" + "Dyscyplina : " + sedzia.DziedzinaSportowa);

        }
    }

    public void usunSedziego(int ktorySedzia) {
        Iterator<SĘDZIA> iterator = sedziowie.iterator();
        while (iterator.hasNext()) {
            SĘDZIA sedzia = iterator.next();
            if (sedziowie.indexOf(sedzia) == ktorySedzia) {
                iterator.remove();
                break;
            }
        }
    }

    public void wczytajSędziówZPliku() {
        System.out.println("Podaj nazwę pliku z sędziami: ");
        Scanner sc = new Scanner(System.in);
        String nazwa;
        nazwa = sc.next();

        try {
            Scanner scanner = new Scanner(new File(nazwa));
            //String nazwaObiektu;
            String imie;
            String nazwisko;
            int nr;
            String dziedzina;

            while (scanner.hasNext()) {
                //nazwaObiektu = scanner.next();
                imie = scanner.next();
                nazwisko = scanner.next();
                nr = scanner.nextInt();
                dziedzina = scanner.next();

                SĘDZIA sędzia = new SĘDZIA(imie, nazwisko, nr, dziedzina);
                dodajSedziego(sędzia);
            }


        } catch (FileNotFoundException e) {
            System.out.println("Nie udało sie otworzyc pliku.");
        }
    }

    public void wczytajDrużynyZPliku() {

        System.out.println("Podaj nazwę pliku z drużynami. ");
        Scanner sc = new Scanner(System.in);
        String nazwa;
        nazwa = sc.next();

        try {
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

            while (scanner.hasNext()) {
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
        } catch (FileNotFoundException e) {
            System.out.println("Nie udało sie otworzyc pliku.");
        }

    }

    int licznikIndex1 = 0;
    private int m1 = 0, m2 = 3;

    public void rozegrajFazeGrupowa(int n) {

        if (n == 1) {
            for (DRUZYNA druzyna : Druzyny) {

                if (druzyna.DziedzinaSportowa.equals("Siatkowka_Plazowa")) {
                    licznikIndex1 = Druzyny.indexOf(druzyna);
                    listaDruzynSiata.add(druzyna);
                    for (int i = licznikIndex1 + 1; i < Druzyny.size(); i++) {
                        if (Druzyny.get(i).DziedzinaSportowa.equals("Siatkowka_Plazowa")) {
                            MeczSiatkowkaPlazowa meczSiatkowkaPlazowa = new MeczSiatkowkaPlazowa(Druzyny.get(licznikIndex1), Druzyny.get(i), Sedziowie_SiatkowkaPlazowa);

                            System.out.println("Druzyna:  " + Druzyny.get(licznikIndex1).NazwaDruzyny + " vs " + " Druzyna " + Druzyny.get(i).NazwaDruzyny + " Sędzia główny: " + meczSiatkowkaPlazowa.sedzia1.Imie + " Sędzia liniowy 1 :" + meczSiatkowkaPlazowa.sedzia2.Imie + " Sędzia liniowy 2 :" + meczSiatkowkaPlazowa.sedzia3.Imie);
                            System.out.println(meczSiatkowkaPlazowa.wynikd1 + " : " + meczSiatkowkaPlazowa.wynikd2);
                        }
                    }

                }

            }
            System.out.println("Tabela punktów drużyn po fazie grupowej dla siatkówki plażowej: ");
            tabelaWynikowSiatkowka();
        }
        else if (n == 2) {
            for (DRUZYNA druzyna : Druzyny) {


                if (druzyna.DziedzinaSportowa.equals("Dwa_Ognie")) {
                    listaDruzynOgnie.add(druzyna);
                    licznikIndex1 = Druzyny.indexOf(druzyna);
                    for (int i = licznikIndex1 + 1; i < Druzyny.size(); i++) {
                        if (Druzyny.get(i).DziedzinaSportowa.equals("Dwa_Ognie")) {
                            MeczDwaOgnie meczDwaOgnie = new MeczDwaOgnie(Druzyny.get(licznikIndex1), Druzyny.get(i), Sedziowie_DwaOgnie);

                            System.out.println("Druzyna " + Druzyny.get(licznikIndex1).NazwaDruzyny + " vs " + " Druzyna " + Druzyny.get(licznikIndex1).NazwaDruzyny + " Sędzia który sędziował : " + meczDwaOgnie.sedzia1.Imie);
                            System.out.println(meczDwaOgnie.wynikd1 + " " + meczDwaOgnie.wynikd2);
                        }
                    }
                }
            }

            System.out.println("Tabela punktów drużyn po fazie grupowej dla dwóch ogni:");
            tabelaWynikowDwaOgnie();
        }
        else if (n == 3) {
            for (DRUZYNA druzyna : Druzyny) {

                if (druzyna.DziedzinaSportowa.equals("Przeciaganie_Liny")) {
                    licznikIndex1 = Druzyny.indexOf(druzyna);
                    listaDruzynLina.add(druzyna);
                    for (int i = licznikIndex1 + 1; i < Druzyny.size(); i++) {
                        if (Druzyny.get(i).DziedzinaSportowa.equals("Przeciaganie_Liny")) {
                            MeczPrzeciaganieLiny meczPrzeciaganieLiny = new MeczPrzeciaganieLiny(Druzyny.get(licznikIndex1), Druzyny.get(i), Sedziowie_PrzeciaganieLiny);

                            System.out.println("Druzyna " + Druzyny.get(licznikIndex1).NazwaDruzyny + " vs " + " Druzyna " + Druzyny.get(i).NazwaDruzyny + " Sędzia: " + meczPrzeciaganieLiny.sedzia1.Imie);
                            System.out.println(meczPrzeciaganieLiny.wynikd1 + " " + meczPrzeciaganieLiny.wynikd2);
                        }
                    }
                }
            }

            System.out.println("Tabela punktów drużyn po fazie grupowej dla przeciągania liny: ");
            tabelaWynikowPrzeciaganieLiny();
        }
        licznikIndex1 = 0;
    }

    public void rozegrajPolfinal(int n) {


        if (n == 1) {

            Collections.sort(listaDruzynSiata, new PorownywaniePunktow());
            System.out.println("Półfinały");

            for (DRUZYNA druzyna : listaDruzynSiata) {

                if (druzyna.DziedzinaSportowa.equals("Siatkowka_Plazowa") && listaDruzynSiata.indexOf(druzyna) <= 1) {
                    MeczSiatkowkaPlazowa meczSiatkowkaPlazowa = new MeczSiatkowkaPlazowa(listaDruzynSiata.get(m1), listaDruzynSiata.get(m2), Sedziowie_SiatkowkaPlazowa);

                    System.out.println("Druzyna:  " + listaDruzynSiata.get(m1).NazwaDruzyny + " vs " + " Druzyna " + listaDruzynSiata.get(m2).NazwaDruzyny + " Sędzia głwóny: " + meczSiatkowkaPlazowa.sedzia1.Imie + " Sędzia liniowy 1 :" + meczSiatkowkaPlazowa.sedzia2.Imie + " Sędzia liniowy 2 :" + meczSiatkowkaPlazowa.sedzia3.Imie);
                    System.out.println(meczSiatkowkaPlazowa.wynikd1 + " : " + meczSiatkowkaPlazowa.wynikd2);
                    if (meczSiatkowkaPlazowa.wynikd1 > meczSiatkowkaPlazowa.wynikd2) {
                        finalisciSiatkowka.add(listaDruzynSiata.get(m1));


                    } else {
                        finalisciSiatkowka.add(listaDruzynSiata.get(m2));
                    }
                    m1++;
                    m2--;
                }
            }
            System.out.println("Zwyciezcy półfinałów: ");
            for (DRUZYNA druzyna: finalisciSiatkowka) {
                System.out.println(druzyna.NazwaDruzyny);
            }
            m1 = 0;
            m2 = 3;
        } else if (n == 2) {
            Collections.sort(listaDruzynOgnie, new PorownywaniePunktow());
            System.out.println("Półfinały");
            for (DRUZYNA druzyna : listaDruzynOgnie) {
                if (druzyna.DziedzinaSportowa.equals("Dwa_Ognie") && listaDruzynOgnie.indexOf(druzyna) <= 1) {
                    MeczDwaOgnie meczDwaOgnie = new MeczDwaOgnie(listaDruzynOgnie.get(m1), listaDruzynOgnie.get(m2), Sedziowie_DwaOgnie);
                    System.out.println("Druzyna:  " + listaDruzynOgnie.get(m1).NazwaDruzyny + " vs " + " Druzyna " + listaDruzynOgnie.get(m2).NazwaDruzyny + " Sędzia: " + meczDwaOgnie.sedzia1.Imie + " " + meczDwaOgnie.sedzia1.Nazwisko);
                    System.out.println(meczDwaOgnie.wynikd1 + " : " + meczDwaOgnie.wynikd2);
                    if (meczDwaOgnie.wynikd1 > meczDwaOgnie.wynikd2) {
                        finalisciOgnie.add(listaDruzynOgnie.get(m1));
                    } else {
                        finalisciOgnie.add(listaDruzynOgnie.get(m2));
                    }
                    m1++;
                    m2--;
                }
            }
            System.out.println("Zwyciezcy półfinałów: ");
            for (DRUZYNA druzyna: finalisciOgnie) {
                System.out.println(druzyna.NazwaDruzyny);
            }
            m1 = 0;
            m2 = 3;
        } else if (n == 3) {
            Collections.sort(listaDruzynLina, new PorownywaniePunktow());
            for (DRUZYNA druzyna : Druzyny) {

                if (druzyna.DziedzinaSportowa.equals("Przeciaganie_Liny") && listaDruzynLina.indexOf(druzyna) <= 1) {
                    MeczPrzeciaganieLiny meczPrzeciaganieLiny = new MeczPrzeciaganieLiny(listaDruzynLina.get(m1), listaDruzynLina.get(m2), Sedziowie_PrzeciaganieLiny);
                    System.out.println("Druzyna:  " + listaDruzynLina.get(m1).NazwaDruzyny + " vs " + " Druzyna " + listaDruzynLina.get(m2).NazwaDruzyny + " Sędzia: " + meczPrzeciaganieLiny.sedzia1.Imie + " " + meczPrzeciaganieLiny.sedzia1.Nazwisko);
                    System.out.println(meczPrzeciaganieLiny.wynikd1 + " : " + meczPrzeciaganieLiny.wynikd2);
                    if (meczPrzeciaganieLiny.wynikd1 > meczPrzeciaganieLiny.wynikd2) {
                        finalisciLina.add(listaDruzynLina.get(m1));
                    } else {
                        finalisciLina.add(listaDruzynLina.get(m2));
                    }
                    m1++;
                    m2--;
                }
            }
            System.out.println("Zwyciezcy półfinałów: ");
            for (DRUZYNA druzyna: finalisciLina) {
                System.out.println(druzyna.NazwaDruzyny);
            }
            m1 = 0;
            m2 = 3;
        }
        licznikIndex1 = 0;
    }


    public void rozegrajFinal(int n) {

        if (n == 1) {
            System.out.println("Grande Finale");
            MeczSiatkowkaPlazowa meczSiatkowkaPlazowa = new MeczSiatkowkaPlazowa(finalisciSiatkowka.get(0), finalisciSiatkowka.get(1), Sedziowie_SiatkowkaPlazowa);
            System.out.println("Druzyna:  " + finalisciSiatkowka.get(0).NazwaDruzyny + " vs " + " Druzyna " + finalisciSiatkowka.get(1).NazwaDruzyny + " Sędzia głwóny: " + meczSiatkowkaPlazowa.sedzia1.Imie + " Sędzia liniowy 1 :" + meczSiatkowkaPlazowa.sedzia2.Imie + " Sędzia liniowy 2 :" + meczSiatkowkaPlazowa.sedzia3.Imie);
            System.out.println(meczSiatkowkaPlazowa.wynikd1 + " : " + meczSiatkowkaPlazowa.wynikd2 );
            System.out.println("Zwyciezca Finału: ");
            if (meczSiatkowkaPlazowa.wynikd1 > meczSiatkowkaPlazowa.wynikd2) {
                System.out.println(finalisciSiatkowka.get(0).NazwaDruzyny);

            } else {
                System.out.println(finalisciSiatkowka.get(1).NazwaDruzyny);
            }

        }




       if(n==2)
               {
                   System.out.println("Grande Finale");
                   MeczDwaOgnie meczDwaOgnie = new MeczDwaOgnie(finalisciOgnie.get(0), finalisciOgnie.get(1), Sedziowie_DwaOgnie);
                   System.out.println("Druzyna:  " + finalisciOgnie.get(0).NazwaDruzyny + " vs " + " Druzyna " + finalisciOgnie.get(1).NazwaDruzyny + " Sędzia głwóny: " + meczDwaOgnie.sedzia1.Imie );
                   System.out.println(meczDwaOgnie.wynikd1 + " : " + meczDwaOgnie.wynikd2 );
                   System.out.println("Zwyciezca Finału: ");
                   if (meczDwaOgnie.wynikd1 > meczDwaOgnie.wynikd2) {
                       System.out.println(finalisciOgnie.get(0).NazwaDruzyny);

                   } else {
                       System.out.println(finalisciOgnie.get(1).NazwaDruzyny);
                   }
        }
        if(n==3){
            System.out.println("Grande Finale");
            MeczPrzeciaganieLiny meczPrzeciaganieLiny = new MeczPrzeciaganieLiny(finalisciLina.get(0),finalisciLina.get(1),Sedziowie_PrzeciaganieLiny);

            System.out.println("Druzyna:  " + finalisciLina.get(0).NazwaDruzyny + " vs " + " Druzyna " + finalisciLina.get(1).NazwaDruzyny + " Sędzia głwóny: " + meczPrzeciaganieLiny.sedzia1.Imie );
            System.out.println(meczPrzeciaganieLiny.wynikd1 + " : " + meczPrzeciaganieLiny.wynikd2 );
            System.out.println("Zwyciezca Finału: ");
            if (meczPrzeciaganieLiny.wynikd1 > meczPrzeciaganieLiny.wynikd2) {
                System.out.println(finalisciLina.get(0).NazwaDruzyny);

            } else {
                System.out.println(finalisciLina.get(1).NazwaDruzyny);
            }
        }
        }

public void tabelaWynikowSiatkowka()
        {
        ArrayList<DRUZYNA> wynikiSiatkowka=new ArrayList<>();
        for(DRUZYNA druzyna:Druzyny)
        {
        if(druzyna.DziedzinaSportowa.equals("Siatkowka_Plazowa"))
        {
        wynikiSiatkowka.add(druzyna);
        }
        }
        Collections.sort(wynikiSiatkowka,new PorownywaniePunktow());
        for(DRUZYNA druzyna:wynikiSiatkowka)
        {
        System.out.println(druzyna.NazwaDruzyny+"   "+druzyna.Punkty);
        }
        }
public void tabelaWynikowDwaOgnie()
        {
        ArrayList<DRUZYNA> lista=new ArrayList<>();
        for(DRUZYNA druzyna:Druzyny)
        {
        if(druzyna.DziedzinaSportowa.equals("Dwa_Ognie"))
        {
        lista.add(druzyna);
        }
        }
        Collections.sort(lista,new PorownywaniePunktow());
        for(DRUZYNA druzyna:lista)
        {
        System.out.println(druzyna.NazwaDruzyny+"   "+druzyna.Punkty);
        }
        }
public void tabelaWynikowPrzeciaganieLiny()
        {
        {
        ArrayList<DRUZYNA> lista=new ArrayList<>();
        for(DRUZYNA druzyna:Druzyny)
        {
        if(druzyna.DziedzinaSportowa.equals("Przeciaganie_Liny"))
        {
        lista.add(druzyna);
        }
        }
        Collections.sort(lista,new PorownywaniePunktow());
        for(DRUZYNA druzyna:lista)
        {
        System.out.println(druzyna.NazwaDruzyny+"   "+druzyna.Punkty);
        }
        }
        }
public void tabelaWynikow()
        {
        System.out.println("Siatkówka Plażowa: ");
        tabelaWynikowSiatkowka();
        System.out.println("Dwa Ognie: ");
        tabelaWynikowDwaOgnie();
        System.out.println("Przeciąganie Liny:");
        tabelaWynikowPrzeciaganieLiny();
        }

public void zapis_stanu_sedziow_druzyn()throws Exception{

//        ObjectOutputStream zapis = new ObjectOutputStream(new FileOutputStream(SedziowieZapis));
//        for (DRUZYNA druzyna: Druzyny) {
//            zapis.writeObject(druzyna);
//        }

        PrintWriter zapis1=new PrintWriter("druzynyZapis.txt");
        for(DRUZYNA druzyna:Druzyny){
        zapis1.print(druzyna.NazwaDruzyny+" ");
        zapis1.print(druzyna.DziedzinaSportowa+" ");
        zapis1.print(druzyna.zawodnik1.Imie+" ");
        zapis1.print(druzyna.zawodnik1.Nazwisko+" ");
        zapis1.print(druzyna.zawodnik1.NumerZawodnika+" ");
        zapis1.print(druzyna.zawodnik2.Imie+" ");
        zapis1.print(druzyna.zawodnik2.Nazwisko+" ");
        zapis1.println(druzyna.zawodnik2.NumerZawodnika);
        }
        zapis1.close();

        PrintWriter zapis2=new PrintWriter("sedziowieZapis.txt");
        for(SĘDZIA sedzia:sedziowie){
        zapis2.print(sedzia.Imie+" ");
        zapis2.print(sedzia.Nazwisko+" ");
        zapis2.print(sedzia.NumerSędziego+" ");
        zapis2.println(sedzia.DziedzinaSportowa);
        }
        zapis2.close();


        System.out.println("Pomyślnie zapisano stan sędziów i drużyn");
        }
public void wczytanie_stanu_sedziow_druzyn()throws Exception{
//        ObjectInputStream odczyt = new ObjectInputStream(new FileInputStream(SedziowieZapis));
//
//        while (true) {
//            try {
//                Object obj = odczyt.readObject();
//                Druzyny.add((DRUZYNA) obj);
//            }
//            catch (EOFException e){
//                break;
//            }
//
//        }


        try{
        Scanner scanner1=new Scanner(new File("sedziowieZapis.txt"));

        String imie;
        String nazwisko;
        int nr;
        String dziedzina;

        while(scanner1.hasNext()){
        imie=scanner1.next();
        nazwisko=scanner1.next();
        nr=scanner1.nextInt();
        dziedzina=scanner1.next();

        SĘDZIA sędzia=new SĘDZIA(imie,nazwisko,nr,dziedzina);
        dodajSedziego(sędzia);
        }


        }catch(FileNotFoundException e){
        System.out.println("Nie udało sie otworzyc pliku z zapisem sędziów.");
        }

        try{
        Scanner scanner=new Scanner(new File("druzynyZapis.txt"));

        String nazwaDruzyny;
        String dziedzina;

        String imie1;
        String nazwisko1;
        int nr1;
        String imie2;
        String nazwisko2;
        int nr2;

        while(scanner.hasNext()){

        nazwaDruzyny=scanner.next();
        dziedzina=scanner.next();

        imie1=scanner.next();
        nazwisko1=scanner.next();
        nr1=scanner.nextInt();
        imie2=scanner.next();
        nazwisko2=scanner.next();
        nr2=scanner.nextInt();

        ZAWODNIK zawodnik1=new ZAWODNIK(imie1,nazwisko1,nr1);
        ZAWODNIK zawodnik2=new ZAWODNIK(imie2,nazwisko2,nr2);
        DRUZYNA druzyna=new DRUZYNA(nazwaDruzyny,dziedzina,zawodnik1,zawodnik2);
        Druzyny.add(druzyna);
        }
        }catch(FileNotFoundException e){
        System.out.println("Nie udało sie otworzyc pliku z zapisem drużyn.");
        }

        System.out.println("Pomyślnie odczytano stan sędziów i drużyn");

        }


        }



















