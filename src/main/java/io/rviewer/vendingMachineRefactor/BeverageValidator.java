package io.rviewer.vendingMachineRefactor;

public class BeverageValidator {

    BeverageMessage msg;
    Beverage[] beverages;
    Beverage beverage;
    String drinkType;
    float money;
    int sugar;

    public BeverageValidator(String drinkType, float money, int sugar){
        this.msg = new BeverageMessage();
        this.beverages = Beverage.values();
        this.drinkType = drinkType;
        this.money = money;
        this.sugar = sugar;
    }

    public boolean isValid() throws BeverageException {
        if (!beverageValidator()){
            throw new BeverageException(this.msg.getTypeError(this.beverages));
        }

        this.beverage = Beverage.valueOf(this.drinkType);

        if (!priceValidator()){
            throw new BeverageException(this.msg.getBeverageError(this.beverage));
        }

        if (this.sugar < 0 || this.sugar > 2){
            throw new BeverageException(this.msg.getSugarError());
        }

        return true;
    }

    private boolean beverageValidator(){
        for(Beverage beverage : this.beverages){
            if (this.drinkType.equalsIgnoreCase(beverage.getName())){
                return true;
            }
        }
        return false;
    }

    private boolean priceValidator() throws BeverageException {
        return  this.money  >= this.beverage.getPrice();
    }
}
