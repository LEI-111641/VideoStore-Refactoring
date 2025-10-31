package semana4;

public class ChildrenPrice extends Price {

    @Override
    public double getRentalAmount(int duration) {
        double result = 1.5;
        if (duration > 3)
            result += (duration - 3) * 1.5;
        return result;
    }

    @Override
    public int getFrequentRentalPoints(int duration) {
        return 1;
    }
}
