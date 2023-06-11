import java.util.ArrayList;
import java.util.Random;

public class MeczDwaOgnie {
    public DRUZYNA druzyna1;
    public DRUZYNA druzyna2;
    public SĘDZIA sedzia1;
    public int wynik;
    public int wynikd1;
    public int wynikd2;
    public MeczDwaOgnie(DRUZYNA druzyna1, DRUZYNA druzyna2, ArrayList<SĘDZIA> lista)
    {
        this.druzyna1=druzyna1;
        this.druzyna2=druzyna2;

        Random liczba = new Random();
        int l = liczba.nextInt(lista.size());
        this.sedzia1 = lista.get(l);
//        Random liczba= new Random();
        Random liczba1= new Random();
        Random liczba2= new Random();
//        wynik=liczba.nextInt(2);
        wynikd1=liczba1.nextInt(2);
        wynikd2 = wynikd1;
        while (wynikd2 == wynikd1)
        {
            wynikd2=liczba2.nextInt(2);
        }
        if(wynik==0)
        {
            druzyna1.Punkty+=1;
        }
        else
            druzyna2.Punkty += 1;
    }

}
