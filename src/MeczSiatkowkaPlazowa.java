import java.util.Random;

public class MeczSiatkowkaPlazowa {
    public DRUZYNA druzyna1;
    public DRUZYNA druzyna2;
    public SĘDZIA sedzia1;
    public int wynikd1;
    public int wynikd2;
    public MeczSiatkowkaPlazowa(DRUZYNA druzyna1,DRUZYNA druzyna2, SĘDZIA sedzia1)
    {
        this.druzyna1=druzyna1;
        this.druzyna2=druzyna2;
        this.sedzia1=sedzia1;
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
