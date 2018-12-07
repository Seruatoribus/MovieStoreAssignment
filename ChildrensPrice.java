package bad.robot.refactoring.chapter1;

public class ChildrensPrice extends Price {
    public int getPriceCode(){
        return Movie.CHILDREN;
    }
    
    public double getCharge(int daysRented){
        double newAmount = 0;
        newAmount += 1.5;
        if (daysRented > 3)
            newAmount += (daysRented - 3) * 1.5;
        return newAmount;
    }
}