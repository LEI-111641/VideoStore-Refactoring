package semana4;

public class Price {
    public enum Code {REGULAR, CHILDRENS, NEW_RELEASE}
    private Code _code;

    public Price(Code code) {_code = code;
    }
    public Code getCode() {return _code;
    }
    public int getFrequentRentalPoints(int duration) {
        return ((_code == Code.NEW_RELEASE) && duration > 1) ? 2 : 1;
    }

    public double getRentalAmount(int duration) {
        double thisAmount = 0;

        // determine amounts for each line
        switch (_code) {
            case REGULAR:
                thisAmount += 2;
                if (duration > 2)
                    thisAmount += (duration - 2) * 1.5;
                break;
            case NEW_RELEASE:
                thisAmount += duration * 3;
                break;
            case CHILDRENS:
                thisAmount += 1.5;
                if (duration > 3)
                    thisAmount += (duration - 3) * 1.5;
                break;
        }
        return thisAmount;
    }


}