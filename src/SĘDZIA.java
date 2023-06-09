import java.io.Serializable;
import java.util.ArrayList;

public class SĘDZIA extends OSOBA implements Serializable {
    public int NumerSędziego;
    public String DziedzinaSportowa;
    public ArrayList<SĘDZIA> Sędziowie;
    public SĘDZIA(String imie,String Nazwisko,int NumerSędziego,String Dziedzina)
    {
        super(imie,Nazwisko);
        this.NumerSędziego=NumerSędziego;
        this.DziedzinaSportowa=Dziedzina;
    }

    public void dodajSędziego(SĘDZIA sędzia)
    {
        Sędziowie.add(sędzia);
    }
    public void usunSędziego(SĘDZIA sędzia)
    {
        Sędziowie.remove(sędzia);
    }

    public ArrayList<SĘDZIA> getSędziowie() {
        return Sędziowie;
    }
}
