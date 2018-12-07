package bad.robot.refactoring.chapter1;

public class Movie {

    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private Price moviePrice;

    public Movie(String title, int priceCode) {
        this.title = title;
        setPriceCode(priceCode);
    }

    public String getTitle() {
        return title;
    }

    public int getPriceCode() {
        return moviePrice.getPriceCode();
    }

    public void setPriceCode(int priceCode) {
        if(priceCode == REGULAR)
            moviePrice = new RegularPrice();
        else if(priceCode == CHILDREN)
            moviePrice = new ChildrensPrice();
        else
            moviePrice = new NewReleasePrice();
    }
    
    public double getCharge(int daysRented){
        return moviePrice.getCharge(daysRented);
    }
    
    public int getFrequentRenterPoints(int daysRented){
        return moviePrice.getFrequentRenterPoints(daysRented);
    }

}
