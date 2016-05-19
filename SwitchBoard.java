import java.util.Iterator;

/**
 * The class that makes the queue act like a caller switchboard
 * 
 * @author Gavin Henderson
 * @version 1.0
 */
public class SwitchBoard
{
    CallQueue queueOne;
    CallQueue queueTwo;
    CallQueue queueThree;
    
    /**
     * Constructor for objects of class SwitchBoard
     */
    public SwitchBoard()
    {
        queueOne = new CallQueue();
        queueTwo = new CallQueue();
        queueThree = new CallQueue();
        
        boolean run = true;
        while(run)
        {
            System.out.println("1: Add a caller");
            System.out.println("2: Forward callers");
            System.out.println("3: Display callers");
            System.out.println("0: Exit");
            
            int choice = 0;
            boolean valid = false;
            while(!valid)
            {
                System.out.print("What would you like to do: ");
                choice = Genio.getInteger();
                
                if((choice>=0)&&(choice<=3))
                {
                    valid = true;
                }
                else
                {
                    System.out.print('\u000c');
                    System.out.println("You did not enter a valid choice");
                }
            }
            
            switch(choice)
            {
                case(1):
                    addCaller();
                    break;
                case(2):
                    forwardCaller();
                    break;
                case(3):
                    displayCallers();
                    break;
                case(0):
                    run = false;
                    break;
            }
        }
    }
    
    /**
     * Get the information from the operator and add it to the queue
     */
    public void addCaller()
    {
        System.out.print('\u000c');
        System.out.println("1: Doctor 1");
        System.out.println("2: Doctor 2");
        System.out.println("3: Doctor 3");
        System.out.print("Which doctor would you the caller like to contact: ");

        int queueNo = 0;
        boolean valid = false;
        while(!valid)
        {
            queueNo = Genio.getInteger();
            if((queueNo>0)&&(queueNo<=3))
            {
                valid = true;
            }
            else
            {
                System.out.println("You did not enter a valid number");
            }
        }        
        
        System.out.print("Enter the name of the caller: ");
        String name = Genio.getString();
        
        valid = false;
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
        
        switch(queueNo)
        {
            case(1): 
                queueOne.addToQueue(name,number);
                break;
            case(2):
                queueTwo.addToQueue(name,number);
                break;
            case(3):
                queueThree.addToQueue(name,number);
                break;
        }
        
        System.out.print('\u000c');
    }
    
    /**
     * Remove the caller from the queue and display their details
     */
    public void forwardCaller()
    {
        System.out.print('\u000c');
        System.out.println("1: Doctor 1");
        System.out.println("2: Doctor 2");
        System.out.println("3: Doctor 3");
        System.out.print("Which doctor would you like to forward a caller to: ");

        int queueNo = 0;
        boolean valid = false;
        while(!valid)
        {
            queueNo = Genio.getInteger();
            if((queueNo>0)&&(queueNo<=3))
            {
                valid = true;
            }
            else
            {
                System.out.println("You did not enter a valid number");
            }
        }     
        
        QueueNode forwarded = null;
        
        switch(queueNo)
        {
            case(1): 
                forwarded = queueOne.removeFromQueue();
                break;
            case(2):
                forwarded = queueTwo.removeFromQueue();
                break;
            case(3):
                forwarded = queueThree.removeFromQueue();
                break;
        }
        
        System.out.print('\u000c');
        
        if(forwarded!=null)
        {
            System.out.println("********************");
            System.out.println("Name: "+forwarded.getName());
            System.out.println("Number: "+forwarded.getNumber());
            System.out.print("Time waited: ");
            forwarded.printTimeWaited();
            System.out.println("********************");
        }
    }
    
    /**
     * Display all callers in the queue
     */
    public void displayCallers()
    {
        System.out.print('\u000c');
        System.out.println("1: Doctor 1");
        System.out.println("2: Doctor 2");
        System.out.println("3: Doctor 3");
        System.out.print("Which doctor would you like to view the callers of: ");

        int queueNo = 0;
        boolean valid = false;
        while(!valid)
        {
            queueNo = Genio.getInteger();
            if((queueNo>0)&&(queueNo<=3))
            {
                valid = true;
            }
            else
            {
                System.out.println("You did not enter a valid number");
            }
        } 
        
        CallQueue currentQueue = null;
        
        switch(queueNo)
        {
            case(1): 
                currentQueue = queueOne;
                break;
            case(2):
                currentQueue = queueTwo;
                break;
            case(3):
                currentQueue = queueThree;
                break;
        }
        
        System.out.print('\u000c');
        if(!currentQueue.isEmpty())
        {
            Iterator<QueueNode> iterator = currentQueue.getIterator();
            
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