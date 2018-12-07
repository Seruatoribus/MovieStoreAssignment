package bad.robot.refactoring.chapter1;

import java.util.ArrayList;
import java.util.List;

public class Rental {

    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDaysRented() {
        return daysRented;
    }
    
    public double getCharge(){
        double newAmount = 0;
        switch (getMovie().getPriceCode()) {
            case Movie.REGULAR:
                newAmount += 2;
                if (getDaysRented() > 2)
                    newAmount += (getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                newAmount += getDaysRented() * 3;
                break;
            case Movie.CHILDREN:
                newAmount += 1.5;
                if (getDaysRented() > 3)
                    newAmount += (getDaysRented() - 3) * 1.5;
                break;
        }
        return newAmount;
    }
    
    int getFrequentRenterPoints(){
        if (getMovie().getPriceCode() == Movie.NEW_RELEASE && getDaysRented() > 1)
            return 2;
        else
            return 1;
    }

}
