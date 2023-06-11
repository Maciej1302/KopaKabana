import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.*;


public class TURNIEJ  {
    public ArrayList<DRUZYNA> Druzyny = new ArrayList<>();
    public ArrayList<SĘDZIA> sedziowie = new ArrayList<>();
    public ArrayList<SĘDZIA> Sedziowie_DwaOgnie = new ArrayList<>();

    public ArrayList<SĘDZIA> Sedziowie_SiatkowkaPlazowa = new ArrayList<>();
    public ArrayList<SĘDZIA> Sedziowie_PrzeciaganieLiny = new ArrayList<>();
    private int index1 = 0, index2 = 0;

    public TURNIEJ() {}

    public void dodajDruzyne(DRUZYNA s) {
        Druzyny.add(s);
    }


    //tutaj domin
    public void przegladajDruzyny() {
        for (DRUZYNA druzyna : Druzyny) {
            System.out.println(Druzyny.indexOf(druzyna) + ". " + "Nazwa drużyny: " + druzyna.NazwaDruzyny + "\n" + "Dziedzina Sportowa: " + druzyna.DziedzinaSportowa + "\n" + "Dane o zawodnikach: " + "\n" + "Zawodnik nr1" + "\n" + "Imie: " + druzyna.zawodnik1.Imie + "\n" + "Nazwisko: " + druzyna.zawodnik1.Nazwisko + "\n" + "Numer: " + druzyna.zawodnik1.NumerZawodnika + "\n" + "Zawodnik nr2" + "\n" + "Imie: " + druzyna.zawodnik2.Imie + "\n" + "Nazwisko: " + druzyna.zawodnik2.Nazwisko + "\n" + "Numer: " + druzyna.zawodnik2.NumerZawodnika);
        }
    }

    public void wycofajDruzyne(int ktoraDoUsuniecia) {
        for (DRUZYNA druzyna : Druzyny) {
            if (Druzyny.indexOf(druzyna) == ktoraDoUsuniecia) {
                Druzyny.remove(druzyna);
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
        for (SĘDZIA sedzia : sedziowie) {
            if (sedziowie.indexOf(sedzia) == ktorySedzia) {
                sedziowie.remove(sedzia);
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

    private int m1 = 0, m2 = 3;

    public void rozegrajFazeGrupowa(int n) {
        int licznikIndex1 = 0;
        if(n == 1) {
            for (DRUZYNA druzyna : Druzyny) {

                if (druzyna.DziedzinaSportowa.equals("Siatkowka_Plazowa")) {
                    licznikIndex1 = Druzyny.indexOf(druzyna);
                    for (int i = licznikIndex1 + 1; i < Druzyny.size(); i++) {
                        if (Druzyny.get(i).DziedzinaSportowa.equals("Siatkowka_Plazowa")) {
                            MeczSiatkowkaPlazowa meczSiatkowkaPlazowa = new MeczSiatkowkaPlazowa(Druzyny.get(licznikIndex1), Druzyny.get(i), Sedziowie_SiatkowkaPlazowa);

                            System.out.println("Druzyna:  " + Druzyny.get(licznikIndex1).NazwaDruzyny + " vs " + " Druzyna " + Druzyny.get(i).NazwaDruzyny + " Sędzia głwóny: " + meczSiatkowkaPlazowa.sedzia1.Imie + " Sędzia liniowy 1 :" + meczSiatkowkaPlazowa.sedzia2.Imie + " Sędzia liniowy 2 :" + meczSiatkowkaPlazowa.sedzia3.Imie);
                            System.out.println(meczSiatkowkaPlazowa.wynikd1 + " : " + meczSiatkowkaPlazowa.wynikd2);
                        }
                    }

                }

            }
            System.out.println("Tabela punktów drużyn po fazie grupowej dla siatkówki plażowej: ");
            tabelaWynikowSiatkowka();
        }else if(n == 2){
            for (DRUZYNA druzyna : Druzyny) {
                licznikIndex1 = Druzyny.indexOf(druzyna);
                if (druzyna.DziedzinaSportowa.equals("Dwa_Ognie")) {
//
                    for (int i = licznikIndex1 + 1; i < Druzyny.size(); i++) {
                        if (Druzyny.get(i).DziedzinaSportowa.equals("Dwa_Ognie")) {
                            MeczDwaOgnie meczDwaOgnie = new MeczDwaOgnie(Druzyny.get(licznikIndex1), Druzyny.get(i), Sedziowie_DwaOgnie);

                            System.out.println("Druzyna " + Druzyny.get(licznikIndex1).NazwaDruzyny + "vs " + " Druzyna " + Druzyny.get(licznikIndex1).NazwaDruzyny + " Sędzia który sędziował : " + meczDwaOgnie.sedzia1.Imie);
                            System.out.println(meczDwaOgnie.wynikd1 + " " + meczDwaOgnie.wynikd2);
                        }
                    }
                }
            }

            System.out.println("Tabela punktów drużyn po fazie grupowej dla dwóch ogni:");
            tabelaWynikowDwaOgnie();
        }else if(n == 3) {
            for (DRUZYNA druzyna : Druzyny) {
                licznikIndex1 = Druzyny.indexOf(druzyna);
                if (druzyna.DziedzinaSportowa.equals("Przeciaganie_Liny")) {
//
                    for (int i = licznikIndex1 + 1; i < Druzyny.size(); i++) {
                        if (Druzyny.get(i).DziedzinaSportowa.equals("Przeciaganie_Liny")) {
                            MeczPrzeciaganieLiny meczPrzeciaganieLiny = new MeczPrzeciaganieLiny(Druzyny.get(licznikIndex1), Druzyny.get(i), Sedziowie_PrzeciaganieLiny);

                            System.out.println("Druzyna " + licznikIndex1 + "vs " + " Druzyna " + i + "Sędzia: " + meczPrzeciaganieLiny.sedzia1.Imie);
                            System.out.println(meczPrzeciaganieLiny.wynikd1 + " " + meczPrzeciaganieLiny.wynikd2);
                        }
                    }
                }
            }

            System.out.println("Tabela punktów drużyn po fazie grupowej dla przeciągania liny: ");
            tabelaWynikowPrzeciaganieLiny();
        }
    }

    public void rozegrajPolfinal(int n) {

        Collections.sort(Druzyny, new PorownywaniePunktow());
if(n == 1) {
    System.out.println("Półfinały");
    for (DRUZYNA druzyna : Druzyny) {

        if (druzyna.DziedzinaSportowa.equals("Siatkowka_Plazowa") && Druzyny.indexOf(druzyna) <= 1) {
            MeczSiatkowkaPlazowa meczSiatkowkaPlazowa = new MeczSiatkowkaPlazowa(Druzyny.get(m1), Druzyny.get(m2), Sedziowie_SiatkowkaPlazowa);

            System.out.println("Druzyna:  " + Druzyny.get(m1).NazwaDruzyny + " vs " + " Druzyna " + Druzyny.get(m2).NazwaDruzyny + " Sędzia głwóny: " + meczSiatkowkaPlazowa.sedzia1.Imie + " Sędzia liniowy 1 :" + meczSiatkowkaPlazowa.sedzia2.Imie + " Sędzia liniowy 2 :" + meczSiatkowkaPlazowa.sedzia3.Imie);
            System.out.println(meczSiatkowkaPlazowa.wynikd1 + " : " + meczSiatkowkaPlazowa.wynikd2);
            if (meczSiatkowkaPlazowa.wynikd1 > meczSiatkowkaPlazowa.wynikd2) {
                Druzyny.get(m1).setPunkty(-2);
            } else {
                Druzyny.get(m2).setPunkty(-2);
            }
            m1++;
            m2--;
        }
    }
    System.out.println("Zwyciezcy półfinałów: ");
    for (DRUZYNA druzyny: Druzyny) {
        if(druzyny.getPunkty()==-2){
            System.out.println(druzyny.NazwaDruzyny);
        }
    }
}else if(n == 2)
{
    Collections.sort(Druzyny, new PorownywaniePunktow());

    for (DRUZYNA druzyna : Druzyny) {
        if (druzyna.DziedzinaSportowa.equals("Dwa_Ognie") && Druzyny.indexOf(druzyna) <= 1) {
            MeczDwaOgnie meczDwaOgnie = new MeczDwaOgnie(Druzyny.get(m1), Druzyny.get(m2), Sedziowie_DwaOgnie);
            System.out.println("Druzyna:  " + Druzyny.get(m1).NazwaDruzyny + " vs " + " Druzyna " + Druzyny.get(m2).NazwaDruzyny + " Sędzia: " + meczDwaOgnie.sedzia1.Imie + " " + meczDwaOgnie.sedzia1.Nazwisko);
            System.out.println(meczDwaOgnie.wynikd1 + " : " + meczDwaOgnie.wynikd2);
            if (meczDwaOgnie.wynikd1 > meczDwaOgnie.wynikd2) {
                Druzyny.get(m1).setPunkty(-2);
            } else {
                Druzyny.get(m2).setPunkty(-2);
            }
            m1++;
            m2--;
        }
    }
        System.out.println("Zwyciezcy półfinałów: ");
        for (DRUZYNA druzyny : Druzyny)
        {
            if(druzyny.DziedzinaSportowa.equals("Dwa_Ognie"))
             if(druzyny.Punkty < 0)
                System.out.println(druzyny.NazwaDruzyny);
        }

}else if(n == 3) {
    for (DRUZYNA druzyna : Druzyny) {

        if (druzyna.DziedzinaSportowa.equals("Przeciaganie_Liny") && Druzyny.indexOf(druzyna) <= 1) {
            MeczPrzeciaganieLiny meczPrzeciaganieLiny = new MeczPrzeciaganieLiny(Druzyny.get(m1), Druzyny.get(m2), Sedziowie_PrzeciaganieLiny);
            System.out.println("Druzyna:  " + Druzyny.get(m1).NazwaDruzyny + " vs " + " Druzyna " + Druzyny.get(m2).NazwaDruzyny + " Sędzia: " + meczPrzeciaganieLiny.sedzia1.Imie + " " + meczPrzeciaganieLiny.sedzia1.Nazwisko);
            System.out.println(meczPrzeciaganieLiny.wynikd1 + " : " + meczPrzeciaganieLiny.wynikd2);
            if (meczPrzeciaganieLiny.wynikd1 > meczPrzeciaganieLiny.wynikd2) {
                Druzyny.get(m1).setPunkty(-2);
            } else {
                Druzyny.get(m2).setPunkty(-2);
            }
            m1++;
            m2--;
        }
    }
    System.out.println("Zwyciezcy półfinałów: ");
    for (DRUZYNA druzyny : Druzyny)
    {
        if(druzyny.DziedzinaSportowa.equals("Przeciaganie_Liny"))
            if(druzyny.Punkty < 0)
                System.out.println(druzyny.NazwaDruzyny);
    }

}
}


    public void rozegrajFinal(int n) {

       if(n == 1){
           System.out.println("Grande Finale");
        for (DRUZYNA druzyna : Druzyny) {
            if (druzyna.DziedzinaSportowa.equals("Siatkowka_Plazowa") && druzyna.getPunkty() == -2) {

                index1 = Druzyny.indexOf(druzyna);
                for (int i = index1 + 1; i < Druzyny.size(); i++) {
                    if (druzyna.DziedzinaSportowa.equals("Siatkowka_Plazowa") && Druzyny.get(i).getPunkty() == -2) {

                        MeczSiatkowkaPlazowa meczSiatkowkaPlazowa5 = new MeczSiatkowkaPlazowa(Druzyny.get(index1), Druzyny.get(i), Sedziowie_SiatkowkaPlazowa);
                        System.out.println("Druzyna:  " + Druzyny.get(index1).NazwaDruzyny + " vs " + " Druzyna " + Druzyny.get(i).NazwaDruzyny + " Sędzia głwóny: " + meczSiatkowkaPlazowa5.sedzia1.Imie + " Sędzia liniowy 1 :" + meczSiatkowkaPlazowa5.sedzia2.Imie + " Sędzia liniowy 2 :" + meczSiatkowkaPlazowa5.sedzia3.Imie);
                        System.out.println(meczSiatkowkaPlazowa5.wynikd1 + " : " + meczSiatkowkaPlazowa5.wynikd2);
                        System.out.println("Zwyciezca Finału: ");
                        if(meczSiatkowkaPlazowa5.wynikd1>meczSiatkowkaPlazowa5.wynikd2)
                        {
                            System.out.println(Druzyny.get(index1).NazwaDruzyny);

                        }
                        else
                        {
                            System.out.println(Druzyny.get(i).NazwaDruzyny);
                        }
                        break;
                    }
                }

            }
            break;
        }

}
       if(n == 2)
       {
           for (DRUZYNA druzyna : Druzyny) {
               if (druzyna.DziedzinaSportowa.equals("Dwa_Ognie") && druzyna.getPunkty() == -2) {
                   index1 = Druzyny.indexOf(druzyna);
                   for (int i = index1 + 1; i < Druzyny.size(); i++) {
                       if (Druzyny.get(i).DziedzinaSportowa.equals("Dwa_Ognie") && Druzyny.get(i).getPunkty() == -2) {

                           MeczDwaOgnie meczDwaOgnie = new MeczDwaOgnie(Druzyny.get(index1), Druzyny.get(i), Sedziowie_DwaOgnie);
                           System.out.println("Druzyna:  " + Druzyny.get(index1).NazwaDruzyny + " vs " + " Druzyna " + Druzyny.get(i).NazwaDruzyny + " Sędzia : " + meczDwaOgnie.sedzia1.Imie + " " + meczDwaOgnie.sedzia1.Nazwisko);
                           System.out.println(meczDwaOgnie.wynikd1 + " : " + meczDwaOgnie.wynikd2);
                           System.out.println("Zwyciezca Finału: ");
                           if(meczDwaOgnie.wynikd1>meczDwaOgnie.wynikd2)
                           {
                               System.out.println(Druzyny.get(index1).NazwaDruzyny);
                           }
                           else
                           {
                               System.out.println(Druzyny.get(i).NazwaDruzyny);
                           }
                           break;
                       }

                       }
                   break;
                   }
               }
           }
       if(n == 3){
           for (DRUZYNA druzyna : Druzyny) {
               if (druzyna.DziedzinaSportowa.equals("Przeciaganie_Liny") && druzyna.getPunkty() == -2) {
                   index1 = Druzyny.indexOf(druzyna);
                   for (int i = index1 + 1; i < Druzyny.size(); i++) {
                       if (Druzyny.get(i).DziedzinaSportowa.equals("Przeciaganie_Liny") && Druzyny.get(i).getPunkty() == -2) {

                           MeczPrzeciaganieLiny meczPrzeciaganieLiny = new MeczPrzeciaganieLiny(Druzyny.get(index1), Druzyny.get(i), Sedziowie_PrzeciaganieLiny);
                           System.out.println("Druzyna:  " + Druzyny.get(index1).NazwaDruzyny + " vs " + " Druzyna " + Druzyny.get(i).NazwaDruzyny + " Sędzia : " + meczPrzeciaganieLiny.sedzia1.Imie + " " + meczPrzeciaganieLiny.sedzia1.Nazwisko);
                           System.out.println(meczPrzeciaganieLiny.wynikd1 + " : " + meczPrzeciaganieLiny.wynikd2);
                           System.out.println("Zwyciezca Finału: ");
                           if(meczPrzeciaganieLiny.wynikd1>meczPrzeciaganieLiny.wynikd2)
                           {
                               System.out.println(Druzyny.get(index1).NazwaDruzyny);
                           }
                           else
                           {
                               System.out.println(Druzyny.get(i).NazwaDruzyny);
                           }
                           break;
                       }

                   }
                   break;
               }
           }
       }
    }

        public void tabelaWynikowSiatkowka()
        {
            ArrayList<DRUZYNA> lista = new ArrayList<>();
            for(DRUZYNA druzyna : Druzyny)
            {
                if(druzyna.DziedzinaSportowa.equals("Siatkowka_Plazowa"))
                {
                    lista.add(druzyna);
                }
            }
            Collections.sort(lista, new PorownywaniePunktow());
            for(DRUZYNA druzyna : lista)
            {
                System.out.println(druzyna.NazwaDruzyny + "   " + druzyna.Punkty);
            }
        }
        public void tabelaWynikowDwaOgnie()
    {
        ArrayList<DRUZYNA> lista = new ArrayList<>();
        for(DRUZYNA druzyna : Druzyny)
        {
            if(druzyna.DziedzinaSportowa.equals("Dwa_Ognie"))
            {
                lista.add(druzyna);
            }
        }
        Collections.sort(lista, new PorownywaniePunktow());
        for(DRUZYNA druzyna : lista)
        {
            System.out.println(druzyna.NazwaDruzyny + "   " + druzyna.Punkty);
        }
    }
    public void tabelaWynikowPrzeciaganieLiny()
    {
        {
            ArrayList<DRUZYNA> lista = new ArrayList<>();
            for(DRUZYNA druzyna : Druzyny)
            {
                if(druzyna.DziedzinaSportowa.equals("Przeciaganie_Liny"))
                {
                    lista.add(druzyna);
                }
            }
            Collections.sort(lista, new PorownywaniePunktow());
            for(DRUZYNA druzyna : lista)
            {
                System.out.println(druzyna.NazwaDruzyny + "   " + druzyna.Punkty);
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
    File SedziowieZapis = new File("Sedziatest.txt");
    public void zapis_stanu_sedziow_druzyn() throws Exception {

        ObjectOutputStream zapis = new ObjectOutputStream(new FileOutputStream(SedziowieZapis));
        for (DRUZYNA druzyna: Druzyny) {
            zapis.writeObject(druzyna);
        }

        System.out.println("Pomyślnie zapisano stan sędziów i drużyn");
    }
    public void wczytanie_stanu_sedziow_druzyn() throws Exception {
        ObjectInputStream odczyt = new ObjectInputStream(new FileInputStream(SedziowieZapis));

        while (true) {
            try {
                Object obj = odczyt.readObject();
                Druzyny.add((DRUZYNA) obj);
            }
            catch (EOFException e){
                break;
            }

        }
        for (DRUZYNA druzyna: Druzyny) {
            System.out.println(druzyna.toString());
        }
        System.out.println("Pomyślnie odczytano stan sędziów i drużyn");


    }





}



