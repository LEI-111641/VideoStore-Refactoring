package semana4;

public class BluRayPrice extends Price {

    public BluRayPrice() {
    }

    @Override
    public double getRentalAmount(int duration) {
        // Blu-ray é mais caro, por exemplo:
        return 3 + (duration > 2 ? (duration - 2) * 2 : 0);
    }

    @Override
    public int getFrequentRentalPoints(int duration) {
        // dobro dos pontos normais, por exemplo
        return (duration > 1) ? 2 : 1;
    }
}
