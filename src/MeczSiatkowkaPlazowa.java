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
        l = liczba.nextInt(lista.size());// nie wiem czy nie -1
        this.sedzia1 = lista.get(l);
        l = liczba.nextInt(lista.size());// nie wiem czy nie -1
        this.sedzia2 = lista.get(l);
        l = liczba.nextInt(lista.size());// nie wiem czy nie -1
        this.sedzia3 = lista.get(l);
        Random liczba1= new Random();
        Random liczba2= new Random();
        wynikd1=liczba1.nextInt(51);
        wynikd2=liczba2.nextInt(51);
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
