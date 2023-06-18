package io.rviewer.vendingMachineRefactor;

public class BeverageValidator {

    final static int MIN_SUGAR = 0;
    final static int MAX_SUGAR = 2;

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
            throw new BeverageException(this.msg.getBeverageError(this.beverages));
        }

        this.beverage = Beverage.valueOf(this.drinkType);

        if (!priceValidator()){
            throw new BeverageException(this.msg.getPriceError(this.beverage));
        }

        if (!sugarValidator()){
            throw new BeverageException(this.msg.getSugarError(MIN_SUGAR, MAX_SUGAR));
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

    private boolean priceValidator(){
        return  this.money  >= this.beverage.getPrice();
    }

    private boolean sugarValidator(){
        if (this.sugar < MIN_SUGAR || this.sugar > MAX_SUGAR){
            return false;
        }
        return true;
    }
}
