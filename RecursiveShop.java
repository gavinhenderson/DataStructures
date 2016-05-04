/**
 * A shop which calculates the how to give change in the least amount of coins.
 * 
 * @author Gavin Henderson
 * @version 1.0
 */
public class RecursiveShop
{
    int food;
    int foodCounter;
    int shoes;
    int shoesCounter;
    int scarf;
    int scarfCounter;
    int book;
    int bookCounter;
    int knife;
    int knifeCounter;
    int tennerCounter;
    int fiverCounter;
    int twoPoundCounter;
    int onePoundCounter;
    int fiftyCounter;
    int twentyCounter;
    int tenCounter;
    int fiveCounter;
    int twoCounter;
    int oneCounter;
    float cashGiven;
    
    /**
     * Constructor for objects of class RecursiveShop
     */
    public RecursiveShop()
    {
        food  = 2099;
        foodCounter = 0;
        shoes = 2523;
        shoesCounter = 0;
        scarf = 572;
        scarfCounter = 0;
        book = 742;
        bookCounter = 0;
        knife = 229;
        knifeCounter = 0;
    }
    
    /**
     * This method will make the shop run
     */
    public void runShop()
    {
        float total = chooseBasket();
        float change = calculateChange(total);
        howToChange(change);
        
        System.out.println("Your total was £"+(total/100));
        System.out.println("You paid £"+(cashGiven/100));
        System.out.println("You get £"+(change/100)+" change");
        System.out.println("Your change will be given in:");
        if(tennerCounter>0)
        {
            System.out.println(tennerCounter+"x £10");
        }
        if(fiverCounter>0)
        {
            System.out.println(fiverCounter+"x £5");
        }
        if(twoPoundCounter>0)
        {
            System.out.println(twoPoundCounter+"x £2");
        }
        if(onePoundCounter>0)
        {
            System.out.println(onePoundCounter+"x £1");
        }
        if(fiftyCounter>0)
        {
            System.out.println(fiftyCounter+"x 50p");
        }
        if(twentyCounter>0)
        {
            System.out.println(twentyCounter+"x 20p");
        }
        if(tenCounter>0)
        {
            System.out.println(tenCounter+"x 10p");
        }
        if(fiveCounter>0)
        {
            System.out.println(fiveCounter+"x 5p");
        }
        if(twoCounter>0)
        {
            System.out.println(twoCounter+"x 2p");
        }
        if(oneCounter>0)
        {
            System.out.println(oneCounter+"x 1p");
        }
        
    }
    
    /**
     * Chose the items you want in your basket and how much they will cost
     * 
     * @return float - the total cost of all the items
     */
    public float chooseBasket()
    {
        int choice = 1;
        float basketTotal = 0;

        while(choice!=0)
        {
            System.out.print('\u000c');
            System.out.println("Your current basket:");
            if(foodCounter>0)
            {
                System.out.println(foodCounter+"x Food");
            }
            if(shoesCounter>0)
            {
                System.out.println(shoesCounter+"x Shoes");
            }
            if(scarfCounter>0)
            {
                System.out.println(scarfCounter+"x Scarf");
            }
            if(bookCounter>0)
            {
                System.out.println(bookCounter+"x Book");
            }
            if(knifeCounter>0)
            {
                System.out.println(knifeCounter+"x Knife");
            }
            System.out.println("Total: £"+(basketTotal/100));
        

            System.out.println("1: Food - £20.99");
            System.out.println("2: Shoes - £25.23");
            System.out.println("3: Scarf - £5.72");
            System.out.println("4: Book - £7.42");
            System.out.println("5: Knife - £2.29");
            System.out.println("0: Finished Shopping");
            
            System.out.print("What would you like to add to your basket: ");
            choice = Genio.getInteger();
            switch (choice){
                case 1: foodCounter++;
                        basketTotal += 2099;
                        break;
                case 2: shoesCounter++;
                        basketTotal += 2523;
                        break;
                case 3: scarfCounter++;
                        basketTotal += 572;
                        break;
                case 4: bookCounter++;
                        basketTotal += 742;
                        break;
                case 5: knifeCounter++;
                        basketTotal += 229;
                        break;
            }
        }
        
        return basketTotal;
    }
    
    /**
     * Calculate the how much change should be given
     * 
     * @param float - the total cost of all items
     * @return float - the amount of change needed
     */
    public float calculateChange(float totalCost)
    {
        boolean valid = false;
        cashGiven = 0;
        while(!valid)
        {
            System.out.print("How much money are you going to hand over: ");
            cashGiven = Genio.getFloat();
            cashGiven = cashGiven*100;
            
            if(cashGiven>=totalCost)
            {
                valid=true;
            }
            else
            {
                System.out.println("You did not hand over enough money");
            }
        }
        
        return (cashGiven-totalCost);
    }
    
    /**
     * Recursive method to see how the change should be given
     * 
     * @param float - how much change needs to be given
     */
    public void howToChange(float changeNeeded)
    {
        if(changeNeeded!=0)
        {
            if(changeNeeded>=1000)
            {
                tennerCounter++;
                changeNeeded -= 1000;
                howToChange(changeNeeded);
            }
            else if(changeNeeded>=500)
            {
                fiverCounter++;
                changeNeeded -= 500;
                howToChange(changeNeeded);
            }
            else if(changeNeeded>=200)
            {
                twoPoundCounter++;
                changeNeeded -= 200;
                howToChange(changeNeeded);
            }
            else if(changeNeeded>=100)
            {
                onePoundCounter++;
                changeNeeded -= 100;
                howToChange(changeNeeded);
            }
            else if(changeNeeded>=50)
            {
                fiftyCounter++;
                changeNeeded -= 500;
                howToChange(changeNeeded);
            }
            else if(changeNeeded>=20)
            {
                twentyCounter++;
                changeNeeded -= 20;
                howToChange(changeNeeded);
            }
            else if(changeNeeded>=10)
            {
                tenCounter++;
                changeNeeded -= 10;
                howToChange(changeNeeded);
            }
            else if(changeNeeded>=5)
            {
                fiveCounter++;
                changeNeeded -= 5;
                howToChange(changeNeeded);
            }
            else if(changeNeeded>=2)
            {
                twoCounter++;
                changeNeeded -= 2;
                howToChange(changeNeeded);
            }
            else if(changeNeeded>=1)
            {
                oneCounter++;
                changeNeeded -= 1;
                howToChange(changeNeeded);
            }
        }
    }
}
