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

        String result = "Rental record for " + getName() + "\n";
        for (Rental rental : rentals) {

            // show figures for this rental
            result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(amountFor(rental)) + "\n";

        }

        result += "Amount owed is " + getTotalCharge() + "\n";
        result += "You earned " + getTotalFrequentRenterPoints() + " frequent renter points";

        return result;
    }
    
    double amountFor(Rental aRental){
        return aRental.getCharge();
    }
    
    double getTotalCharge(){
        double result = 0;
        for (Rental rental : rentals){
            result += rental.getCharge();
        }
        return result;
    }
    
    int getTotalFrequentRenterPoints(){
        int result = 0;
        for (Rental rental : rentals) {
            // add frequent renter points
            result += rental.getFrequentRenterPoints();

        }
        return result;
    }
}
