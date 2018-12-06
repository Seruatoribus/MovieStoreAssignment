package bad.robot.refactoring.chapter1;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private List<Rental> rentals = new ArrayList<Rental>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;

        String result = "Rental record for " + getName() + "\n";
        for (Rental rental : rentals) {
            double amount = amountFor(rental);

            // add frequent renter points
            frequentRenterPoints++;
            // add bonus for a two day new release rental
            if (rental.getMovie().getPriceCode() == Movie.NEW_RELEASE && rental.getDaysRented() > 1)
                frequentRenterPoints++;

            // show figures for this rental
            result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(amount) + "\n";

            totalAmount += amount;
        }

        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";

        return result;
    }
    
    double amountFor(Rental aRental){
        double newAmount = 0;
        switch (aRental.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                newAmount += 2;
                if (aRental.getDaysRented() > 2)
                    newAmount += (aRental.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                newAmount += aRental.getDaysRented() * 3;
                break;
            case Movie.CHILDREN:
                newAmount += 1.5;
                if (aRental.getDaysRented() > 3)
                    newAmount += (aRental.getDaysRented() - 3) * 1.5;
                break;
        }
        return newAmount;
    }
}
