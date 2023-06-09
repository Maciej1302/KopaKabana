import java.io.Serializable;
import java.util.ArrayList;

public class DRUZYNA implements Serializable {
    public String NazwaDruzyny;
    public String DziedzinaSportowa;
    public ZAWODNIK zawodnik1,zawodnik2;

    public int Punkty;



    public DRUZYNA(String NazwaDruzyny,String DziedzinaSportowa,ZAWODNIK zawodnik1,ZAWODNIK zawodnik2)
    {
        this.NazwaDruzyny=NazwaDruzyny;
        this.DziedzinaSportowa=DziedzinaSportowa;
        this.zawodnik1=zawodnik1;
        this.zawodnik2=zawodnik2;
    }

//odtad DOMIN
    public DRUZYNA() {

    }

    public DRUZYNA(int punkty) {
        Punkty = punkty;
    }

    public int getPunkty() {
        return Punkty;
    }

    public void setPunkty(int punkty) {
        Punkty = punkty;
    }
}
