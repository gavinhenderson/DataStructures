/**
 * Allows the stack to have instances that stores a number
 * 
 * @author Gavin Henderson
 * @version 1.0
 */
public class StackNode
{
    StackNode next; //Stores the node that will be after this node in the list
    double number; //Stores the number value
    
    /**
     * Constructor for objects of class ListNode
     */
    public StackNode()
    {
        next = null;
        number = 0;
    }
    
    /**
     * Alternative constructor for objects of class ListNode
     */
    public StackNode(double newNumber)
    {
        next = null;
        number = newNumber;
    }
    
    /**
     * Acessor for the next variable
     * 
     * @return ListNode - The next node in the list
     */
    public StackNode getNext()
    {
        return next;
    }
    
    /**
     * Acessor for the ID variable
     * 
     * @return int - the number stored in the instance
     */
    public double getNumber()
    {
        return number;
    }
    
    /**
     * Mutator for the next variable
     * 
     * @params StackNode - The node that you want to be set as the next node
     */
    public void setNext(StackNode newNext)
    {
        next = newNext;
    }
    
    /**
     * Mutator for the ID variable
     * 
     * @params int - the new number this node stores
     */
    public void setNumber(double newNumber)
    {
        number = newNumber;
    }    
}
