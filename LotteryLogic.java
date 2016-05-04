import java.util.HashSet;
import java.util.Random;

/**
 * All the logic for the calculating lottery numbers
 * 
 * @author Gavin Henderson
 * @version 1.0
 */
public class LotteryLogic
{   
    Sets userSet;
    Sets randomSet;
    Random rand;
    
    /**
     * Constructor for objects of class LotteryLogic
     */
    public LotteryLogic()
    {
        userSet = new Sets();
        randomSet = new Sets();
        rand = new Random();
    }
    
    /**
     * This method will run the lottery
     */
    public void runLottery()
    {
        int total = 0;
        
        System.out.println("Pick six numbers between 1,49");
        while (total!=6)
        {
            System.out.print((total+1)+": ");
            if(userSet.addToSet(Genio.getInteger()))
            {
                total++;
            }
        }
        
        total=0;
        while (total!=6)
        {
            if(randomSet.addToSet(rand.nextInt(49)))
            {
                total++;
            }
        }
        
        System.out.println(userSet.getSet());
        System.out.println(randomSet.getSet());
        
        userSet.intersection(randomSet.getSet());
        int totalMatches = userSet.cardinality();
        
        switch(totalMatches)
        {
            case 3: System.out.println("You won £25");
                    break;
            case 4: System.out.println("You won £100");
                    break;
            case 5: System.out.println("You won £1,000");
                    break;
            case 6: System.out.println("You won £1,000,000");
                    break;
            default: System.out.println("You lost");
        }
    }
}
