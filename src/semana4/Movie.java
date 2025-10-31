package semana4;

public class Movie {

	public int getFrequentRentalPoints(int duration) {
		return ((_priceCode  == Code.NEW_RELEASE) && duration > 1) ? 2 : 1;
	}

	public double getRentalAmount(int duration) {
	double thisAmount = 0;

	// determine amounts for each line
	switch (_priceCode)
	{
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

	public enum Code {REGULAR, CHILDRENS, NEW_RELEASE};

	private String _title;
	private Code _priceCode;

	public Movie(String title, Code priceCode) {
		_title = title;
		_priceCode = priceCode;
	}

	public String getTitle() {
		return _title;
	}

	public Code getPriceCode() {
		return _priceCode;
	}
}
