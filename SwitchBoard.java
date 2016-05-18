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
    
    /**
     * Get the information from the operator and add it to the queue
     */
    public void addCaller()
    {
        System.out.print("Enter the name of the caller: ");
        String name = Genio.getString();
        
        System.out.print("Enter the number of the caller: ");
        String number = Genio.getString();
        
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
