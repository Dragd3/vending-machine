package io.rviewer;

import io.rviewer.vendingMachineRefactor.Beverage;
import io.rviewer.vendingMachineRefactor.BeverageException;
import io.rviewer.vendingMachineRefactor.BeverageMessage;
import io.rviewer.vendingMachineRefactor.BeverageValidator;

import java.util.stream.Stream;

public class MakeDrinkCommand implements Command {

    Beverage[] beverages = Beverage.values();

    @Override
    public void execute(Input input, Output out) {
        String drinkType = input.getParameter("drinkType").toString().toUpperCase();
        Float money = input.getParameter("money");
        Integer sugar = input.getParameter("sugar");
        Boolean hot = input.getParameter("extraHot");
        BeverageMessage msg = new BeverageMessage();
        Beverage beverage;

        try {
            BeverageValidator valid = new BeverageValidator(drinkType, money, sugar);
            if (valid.isValid()) {
                beverage = Beverage.valueOf(drinkType);
                beverage.sold();
                out.run(msg.getResponse(beverage, sugar, hot));
            }
        }catch (BeverageException e){
            out.run(e.getMessage());
        }

    }

    public void getEarned(){ //You can call it from a loop in CoffeeMachine.main() and it shows a table of earnings
        System.out.format("%10s%3s%7s","DRINK","|", "MONEY");
        System.out.println();
        Stream.of(this.beverages)
                .forEach(beverage -> {
                    System.out.format("%10s%3s%.2f", beverage.getName(), "|", beverage.getEarned());
                    System.out.println();
                });
    }
}
