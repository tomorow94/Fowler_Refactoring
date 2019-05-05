public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private String title;
    private int priceCode;
    private Price price;

    public Movie(String newtitle, int newpriceCode) {
        title = newtitle;
        setPriceCode(newpriceCode);
    }

    public int getFrequentRenterPoints(int daysRented) {
        if ((priceCode == Movie.NEW_RELEASE) && daysRented > 1){
            return 2;
        }
        return 1;
    }

    public double getCharge(int daysRented) {
        return price.getCharge();
    }

    public int getPriceCode() {
        return price.getPriceCode();
    }

    public void setPriceCode(int newPriceCode){
        switch (newPriceCode) {
            case Movie.REGULAR:
                price = new RegularPrice();
                break;
            case Movie.NEW_RELEASE:
                price = new NewReleasePrice();
                break;
            case Movie.CHILDRENS:
                price = new ChildrensPrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
    }

    public String getTitle (){
        return title;
    }
}