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
        double newAmount = 0;
        switch (getPriceCode()) {
            case Movie.REGULAR:
                newAmount += 2;
                if (daysRented > 2)
                    newAmount += (daysRented - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                newAmount += daysRented * 3;
                break;
            case Movie.CHILDREN:
                newAmount += 1.5;
                if (daysRented > 3)
                    newAmount += (daysRented - 3) * 1.5;
                break;
        }
        return newAmount;
    }
    
    public int getFrequentRenterPoints(int daysRented){
        if (getPriceCode() == Movie.NEW_RELEASE && daysRented > 1)
            return 2;
        else
            return 1;
    }

}
