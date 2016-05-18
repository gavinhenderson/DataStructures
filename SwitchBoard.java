import java.util.Iterator;

/**
 * The class that makes the queue act like a caller switchboard
 * 
 * @author Gavin Henderson
 * @version 1.0
 */
public class SwitchBoard
{
    CallQueue callerQueue;
    
    /**
     * Constructor for objects of class SwitchBoard
     */
    public SwitchBoard()
    {
        callerQueue = new CallQueue();
    }
    
    /**
     * Runs the switchboard
     */
    public void runSwitchBoard()
    {
    }
    
    /**
     * Get the information from the operator and add it to the queue
     */
    public void addCaller()
    {
        System.out.print("Enter the name of the caller: ");
        String name = Genio.getString();
        
        boolean valid = false;
        String number="";
        while(!valid)
        {
            System.out.print("Enter the number of the caller: ");
            number = Genio.getString();
            if(number.length()==11)
            {
                if((number.charAt(0)=='0')&&(number.charAt(1)=='7'))
                {
                    valid=true;
                }
                else
                {
                    System.out.println("The first two numbers were not '07'");
                }
            }
            else
            {
                System.out.println("You did not enter a phone number with the right amount of numbers");
            }
        }
        
        callerQueue.addToQueue(name,number);
    }
    
    /**
     * Remove the caller from the queue and display their details
     */
    public void forwardCaller()
    {
        QueueNode forwarded = callerQueue.removeFromQueue();
        System.out.println("********************");
        System.out.println("Name: "+forwarded.getName());
        System.out.println("Number: "+forwarded.getNumber());
        System.out.print("Time waited: ");
        forwarded.printTimeWaited();
        System.out.println("********************");
    }
    
    /**
     * Display all callers in the queue
     */
    public void displayCallers()
    {
        System.out.print('\u000c');
        if(!callerQueue.isEmpty())
        {
            Iterator<QueueNode> iterator = callerQueue.getIterator();
            
            while(iterator.hasNext())
            {
                QueueNode nextCaller = iterator.next();
                
                System.out.println("********************");
                System.out.println("Name: "+nextCaller.getName());
                System.out.println("Number: "+nextCaller.getNumber());
                System.out.print("Time waited: ");
                nextCaller.printTimeWaited();
                System.out.println("********************");
            }
        }
        else
        {
            System.out.println("There are no callers");
        }
    }
}
