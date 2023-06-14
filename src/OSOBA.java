import java.io.Serializable;

abstract public class OSOBA implements Serializable {
    public String Imie;
    public String Nazwisko;

    public OSOBA(String imie, String nazwisko) {
        Imie = imie;
        Nazwisko = nazwisko;
    }
//tutaj domin
    public OSOBA() {

    }

    public String getImie() {
        return Imie;
    }

    public void setImie(String imie) {
        Imie = imie;
    }

    public String getNazwisko() {
        return Nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        Nazwisko = nazwisko;
    }
}
