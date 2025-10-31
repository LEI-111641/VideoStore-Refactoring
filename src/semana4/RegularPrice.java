package semana4;

public class RegularPrice extends Price {
    @Override
    public double getRentalAmount(int duration) {
        double result = 2;
        if (duration > 2)
            result += (duration - 2) * 1.5;
        return result;
    }

    @Override
    public int getFrequentRentalPoints(int duration) {
        return 1;
    }
}
