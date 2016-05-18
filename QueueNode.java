import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * Stores all the information about a specific caller
 * 
 * @author Gavin Henderson 
 * @version 1.0
 */
public class QueueNode
{
    String name;
    String number;
    LocalTime createdDate;
    
    /**
     * Constructor for objects of class QueueNode
     */
    public QueueNode()
    {
        name = "";
        number = "";
        createdDate = LocalTime.now();
    }
    
    /**
     * Alternative constructor
     * 
     * @param int - name
     * @param int - number
     */
    public QueueNode(String newName, String newNumber)
    {
        name = newName;
        number = newNumber;
        createdDate = LocalTime.now();
    }
    
    /**
     * Prints the time that the caller has waited from the point it was created
     */
    public void printTimeWaited()
    {
        LocalTime now = LocalTime.now();
        long hours = ChronoUnit.HOURS.between(createdDate, now);
        long minutes = ChronoUnit.MINUTES.between(createdDate, now);
        minutes = minutes%60;
        long seconds = ChronoUnit.SECONDS.between(createdDate, now);
        seconds = seconds%60;
        
        System.out.println(hours+":"+minutes+":"+seconds);
    }
    
    /**
     * Return the name of the caller
     * 
     * @return String - the name of the caller
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Return the number of the caller
     * 
     * @return String - number of the caller
     */
    public String getNumber()
    {
        return number;
    }
    
    /**
     * set the name of the caller
     * 
     * @param String - name
     */
    public void setName(String newName)
    {
        name = newName;
    }
    
    /**
     * set the number of the caller
     * 
     * @param String - number
     */
    public void setNumber(String newNumber)
    {
        number = newNumber;
    }
}
