/**
 * Stores all the information for one node including the infromation so it can be used in a biary tree
 * 
 * @author Gavin Henderson
 * @version 1.0
 */
public class BinaryNode
{
    BinaryNode left;
    BinaryNode right;
    int ID;
    int mark;
    String name;
    
    /**
     * Constructor for objects of class BinaryNode
     */
    public BinaryNode()
    {
        left = null;
        right = null;
        ID = 0;
        mark = 0;
        name = "";
    }
    
    /**
     * Returns the left binary node
     * 
     * @return BinaryNode - The left hand node
     */
    public BinaryNode getLeft()
    {
        return left;
    }
    
    /**
     * Returns the right binary bode
     * 
     * @return BinaryNode - The right hand node
     */
    public BinaryNode getRight()
    {
        return right;
    }
    
    /**
     * Returns the ID
     * 
     * @return int - the Id of the student
     */
    public int getID()
    {
        return ID;
    }
    
    /**
     * Returns the mark the student got
     * 
     * @return int - the mark of the student
     */
    public int getMark()
    {
        return mark;
    }
    
    /**
     * Returns the name of the student
     * 
     * @return String - name of the student
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Sets the left node
     * 
     * @param BinaryNode - the new left node
     */
    public void setLeft(BinaryNode newLeft)
    {
        left = newLeft;
    }
    
    /**
     * Sets the right node
     * 
     * @param BinaryNode - the new right node
     */
    public void setRight(BinaryNode newRight)
    {
        right = newRight;
    }
    
    /**
     * Sets the new ID
     * 
     * @param int - the new ID
     */
    public void setID(int newID)
    {
        ID = newID;
    }
    
    /**
     * Sets the new mark
     * 
     * @param int - the new Mark
     */
    public void setMark(int newMark)
    {
        mark = newMark;
    }
    
    /**
     * Sets the new name
     * 
     * @param String - the new name
     */
    public void setName(String newName)
    {
        name = newName;
    }
    
    /**
     * Prints the data in an ordered fashion
     */
    public void print()
    {
        System.out.println("******************");
        System.out.println("Student: "+name+" ("+ID+")");
        System.out.println("Mark: "+mark);
        System.out.println("******************");
    }
}
