package io.rviewer.vendingMachineRefactor;

import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BeverageMessage {

    public BeverageMessage() {
    }

    public String getTypeError(Beverage[] beverages){
        StringBuilder response = new StringBuilder();

        String listOfBeverages = Stream.of(beverages)
                .map(Beverage::getName)
                .collect(Collectors.joining(", "));

        int lastIndex = listOfBeverages.lastIndexOf(", ");

        response.append("The drink type should be ");

        if (lastIndex != -1) {
            response.append(listOfBeverages, 0, lastIndex)
                    .append(" or ")
                    .append(listOfBeverages.substring(lastIndex+2));
        } else { //if there's only 1 element
            response.append(listOfBeverages);
        }

        response.append(".");

        return response.toString();
    }

    public String getBeverageError(Beverage beverage){
        StringBuilder response = new StringBuilder();

        response.append("The ")
                .append(beverage.getName())
                .append(" costs ")
                .append(beverage.getPrice())
                .append(".");

        return response.toString();
    }

    public String getSugarError(){
        return "The number of sugars should be between 0 and 2.";
    }

    public String getResponse(Beverage beverage, int sugar, boolean hot){
        StringBuilder response = new StringBuilder();

        response.append("You have ordered a ")
                .append(beverage.getName())
                .append(hot ? " extra hot" : "");

        if (sugar != 0){
            response.append(" with ")
                    .append(sugar)
                    .append(sugar == 1 ? " sugar" : " sugars")
                    .append(" (stick included)");
        }

        return response.toString();
    }

}
