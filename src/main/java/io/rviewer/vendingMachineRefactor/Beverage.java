package io.rviewer.vendingMachineRefactor;

public enum Beverage {
    TEA ("tea",0.4f, 0),
    COFFEE ("coffee",0.5f, 0),
    CHOCOLATE ("chocolate",0.6f, 0);

    private String name;
    private float price;
    private float earned;

    Beverage(String name, float price, float earned) {
        this.name = name;
        this.price = price;
        this.earned = earned;
    }

    public void sold(){
        this.earned += this.price;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getEarned() {
        return earned;
    }

    public void setEarned(float earned) {
        this.earned = earned;
    }

}
