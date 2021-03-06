package bad.robot.refactoring.chapter1;

public class RegularPrice extends Price {
    public int getPriceCode(){
        return Movie.REGULAR;
    }
    
    public double getCharge(int daysRented){
        double newAmount = 0;
        newAmount += 2;
        if (daysRented > 2)
            newAmount += (daysRented - 2) * 1.5;
        return newAmount;
    }
}
