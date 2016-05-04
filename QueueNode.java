
/**
 * Write a description of class QueueNode here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class QueueNode
{
    String name;
    String number;
    
    /**
     * Constructor for objects of class QueueNode
     */
    public QueueNode()
    {
        name = "";
        number = "";
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
