import java.util.Comparator;

public class PorownywaniePunktow implements Comparator<DRUZYNA> {

    @Override
    public int compare(DRUZYNA d1, DRUZYNA d2) {
        return Integer.compare(d2.getPunkty(), d1.getPunkty());
    }
}
