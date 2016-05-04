/**
 * Stores all the information about a specific student
 * 
 * @author Gavin Henderson
 * @version 1.0
 */
public class ListNode
{
    ListNode next; //Stores the node that will be after this node in the list
    int ID; //Store the ID of the current student
    int mark; //Stores the mark that the student recieved
    
    /**
     * Constructor for objects of class ListNode
     */
    public ListNode()
    {
        next = null;
        ID = 0;
        mark = 0;
    }
    
    /**
     * Acessor for the next variable
     * 
     * @return ListNode - The next node in the list
     */
    public ListNode getNext()
    {
        return next;
    }
    
    /**
     * Acessor for the ID variable
     * 
     * @return int - the ID of the student
     */
    public int getID()
    {
        return ID;
    }
    
    /**
     * Acessor for the mark variable
     * 
     * @return int - mark of the current student
     */
    public int getMark()
    {
        return mark;
    }
    
    /**
     * Mutator for the next variable
     * 
     * @params ListNode - The node that you want to be set as the next node
     */
    public void setNext(ListNode newNext)
    {
        next = newNext;
    }
    
    /**
     * Mutator for the ID variable
     * 
     * @params int - the new ID of the student
     */
    public void setID(int newID)
    {
        ID = newID;
    }
    
    /**
     * Mutator for the mark variable
     * 
     * @params int - the new mark of the student
     */
    public void setMark(int newMark)
    {
        mark = newMark;
    }
    
    /**
     * Prints all the data for the node
     */
    public void printInfo()
    {
        System.out.println("*********************");
        System.out.println("Student ID: "+ID);
        System.out.println("Mark: "+mark);
        System.out.println("*********************");
    }
}
