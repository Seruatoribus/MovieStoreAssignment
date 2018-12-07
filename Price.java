package bad.robot.refactoring.chapter1;

public abstract class Price {
    protected int priceCode;
    
    public abstract int getPriceCode();
    
    public abstract double getCharge(int daysRented);
}
