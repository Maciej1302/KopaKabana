public class ZAWODNIK extends OSOBA{
    public int NumerZawodnika;
    public ZAWODNIK(String imie,String nazwisko, int nr)
    {
        super(imie,nazwisko);
        this.NumerZawodnika=nr;

    }
//odtad domin
    public ZAWODNIK() {
        super();
    }
}
