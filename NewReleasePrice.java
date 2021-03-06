package bad.robot.refactoring.chapter1;

public class NewReleasePrice extends Price {
    public int getPriceCode(){
        return Movie.NEW_RELEASE;
    }
    
    public double getCharge(int daysRented){
        double newAmount = 0;
        newAmount += daysRented * 3;
        return newAmount;
    }
    
    @Override
    public int getFrequentRenterPoints(int daysRented){
        if(daysRented > 1)
            return 2;
        else
            return 1;
    }
}