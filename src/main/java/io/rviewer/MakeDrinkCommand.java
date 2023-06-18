package io.rviewer;

import io.rviewer.vendingMachineRefactor.Beverage;
import io.rviewer.vendingMachineRefactor.BeverageException;
import io.rviewer.vendingMachineRefactor.BeverageMessage;
import io.rviewer.vendingMachineRefactor.BeverageValidator;

public class MakeDrinkCommand implements Command {


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
}
