import java.util.ArrayList;
import java.util.Random;

public class MeczSiatkowkaPlazowa {
    public DRUZYNA druzyna1;
    public DRUZYNA druzyna2;
    public SĘDZIA sedzia1;
    public SĘDZIA sedzia2;
    public SĘDZIA sedzia3;
    public int wynikd1;
    public int wynikd2;
    public MeczSiatkowkaPlazowa(DRUZYNA druzyna1,DRUZYNA druzyna2,  ArrayList<SĘDZIA> lista)
    {
        this.druzyna1=druzyna1;
        this.druzyna2=druzyna2;

                Random liczba = new Random();
        int l;
        int l1;
        int l2;
        l = liczba.nextInt(lista.size());
        sedzia1 = lista.get(l);
        l1 = l;
        while (l1 == l) {
            l1 = liczba.nextInt(lista.size());
        }
        sedzia2 = lista.get(l1);
        l2 = l1;
        while(l2 == l1 || l2 == l) {
            l2 = liczba.nextInt(lista.size());
        }
        sedzia3 = lista.get(l2);
        Random liczba1= new Random();
        Random liczba2= new Random();
        int wygrany;
        wygrany = liczba1.nextInt(2);
        if(wygrany == 0)
        {
            wynikd1 = 3;
            wynikd2 = liczba2.nextInt(3);
        } else if (wygrany == 1)
        {
            wynikd2 = 3;
            wynikd1 = liczba2.nextInt(3);
        }
        if(wynikd1>wynikd2)
        {
            druzyna1.Punkty+=1;
        }
        else
            druzyna2.Punkty += 1;
    }
    public MeczSiatkowkaPlazowa() {

    }

//tu domin

}
