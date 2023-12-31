# Coffee Machine

Coffee Machine is an awesome console application that from a few input parameters (drink type, amount of money, number of sugars, extra hot check) is capable to order a drink and show a cool message of the desired drink.

## How it works

Command
```
./gradlew run
```

Arguments

|#|Name|Type|Required|Description|Values|Default|
|---|---|---|---|---|---|---|
|1|drinkType|string|true|Type of drink|tea, coffee, chocolate|
|2|money|float|true|Amount of money given by the user in unit of currency||
|3|sugars|int|false|Number of sugars|0, 1, 2|0|

Options

|Name|Type|Required|Description|Values|Default|
|---|---|---|---|---|---|
|extraHot (--extra-hot, -e)| |false|Flag indicating if the user wants extra hot drink|true, false|false|

List prices

|Drink|Price|
|---|---|
|Tea|0.4|
|Coffee|0.5|
|Chocolate|0.6|

Validations
* If the drink type is not *tea*, *coffee* or *chocolate*, it shows the following message:
```
The drink type should be tea, coffee or chocolate.
```
* If the amount of money does not reach the price of the drink, a message as the following is displayed:
```
The tea costs 0.4.
```
* If the number of sugars is not between 0 and 2, it shows a message like this:
```
The number of sugars should be between 0 and 2.
```
* If the arguments are right, the displayed message is:
```
You have ordered a coffee
```
* If the number of sugars is greater than 0, it includes the stick to the drink and it shows a message similar tot this:
```
You have ordered a coffee with 2 sugars (stick included).
```
* If it adds extra hot option, the displayed message will be:
```
You have ordered a coffee extra hot with 2 sugars (stick included)    
```

## Legacy status

This application was implemented by a developer who is no longer in the company.

His legacy is the class `MakeDrinkCommandOld`. This class handle all the application logic:
* It reads input parameters
* It validates input parameters
* It shows output message

He also implemented a unit test covering all possibilities (`MakeDrinkCommandTest`)

As you can see, this class is a bit messy and I adapted to my coding standards

## Current status / What have I done?

I liked to have a reusable, maintainable and testable code, so I refactored
into `MakeDrinkCommand` following these principles:

* Clean code
* SOLID principles
* Decoupling
* Design patterns
* Error handling
* TDD

Also, I prepared the code for the implementation of a new feature
so that I could know how much money the machine made with each type of drink.

It shows something like the following table:

|Drink|Money|
|---|---|
|Tea|15|
|Coffee|25.75|
|Chocolate|36|

## Project set up

Install and run the application.
```
cd coffee-machine-java
./gradlew build
```

Examples of the use of the application.
```
./gradlew run --args="tea 0.5 1 -e"
./gradlew run --args="coffee 0.5"
./gradlew run --args="coffee 0.5 --extra-hot"
```

Run tests
```
./gradlew test
```
