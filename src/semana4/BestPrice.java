package semana4;

public class BestPrice extends Price {
    @Override
    public double getRentalAmount(int duration) {
        return 1.5 + duration * 1.0;
    }

    @Override
    public int getFrequentRentalPoints(int duration) {
        return 1;
    }
}
