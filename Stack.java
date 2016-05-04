/**
 * Write a description of class Stack here.
 * 
 * @author Gavin Henderson 
 * @version 1.0
 */
public class Stack
{
    StackNode top;
    
    /**
     * Constructor for objects of class Stack
     */
    public Stack()
    {
        StackNode top = null;
    }
    
    /**
     * Push a number to the top of the stack
     * 
     * @param int - the number that you want to add to the stack
     */
    public void push(int number)
    {
        StackNode newNode = new StackNode(number);
        
        if(top==null)
        {
            top = newNode;
        }
        else
        {
            newNode.setNext(top);
            top = newNode;
        }
    }
    
    /**
     * Pop a number from the top of the stack
     * 
     * @return int - the number from the top of the list
     */
    public int pop()
    {
        int popNumber = top.getNumber();
        top = top.getNext();
    
        return popNumber;
    }
    
    /**
     * Check to see if the stack is empty or not
     * 
     * @return boolean - true if the stack is empty
     */
    public boolean isStackEmpty()
    {
        if (top==null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
