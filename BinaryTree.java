/**
 * This class controls the binary tree
 * 
 * @author Gavin Henderson
 * @version 1.0
 */
public class BinaryTree
{
    BinaryNode top;
    
    /**
     * Constructor for objects of class BinaryTree
     */
    public BinaryTree()
    {
        top = null;
    }
    
    /**
     * Create and add new node
     * 
     * @return boolean - true if successfully added
     */
    public void addNode()
    {
        BinaryNode newNode = new BinaryNode();
        
        System.out.print("Enter the ID of the student: ");
        newNode.setID(Genio.getInteger());
        
        System.out.print("Enter the name of the student: ");
        newNode.setName(Genio.getString());
        
        System.out.print("Enter the mark of the student: ");
        newNode.setMark(Genio.getInteger());
        
        int newID = newNode.getID();
        BinaryNode current = top;
        BinaryNode previous = top;
        
        if (top==null)
        {
            top = newNode;
        }
        else
        {
            while(current!=null)
            {
                if (newID<current.getID())
                {
                    previous = current;
                    current = current.getLeft();
                }
                else if (newID>current.getID())
                {
                    previous = current;
                    current = current.getRight();
                }
                else if (newID==current.getID())
                {
                    System.out.println("This ID has already been assigned");
                }
            }
            
            if(newID<previous.getID())
            {
                previous.setLeft(newNode);
            }
            else if(newID>previous.getID())
            {
                previous.setRight(newNode);
            }
        }
    }
    
    /**
     * Deleting a node
     * 
     * @param int - The id of the node you want to delete
     * @return boolean - true if the node is deleted from the tree
     */
    public boolean deleteNode(int ID)
    {
        BinaryNode current = top;
        BinaryNode previous = top;
        boolean found = false;
        
        if(top.getID()==ID)
        {
            System.out.println("You cannot delete the head");
        }
        else
        {
            while(!found)
            {
                if(current.getID()==ID)
                {
                    found=true;
                }
                else if(ID<current.getID())
                {
                    previous = current;
                    current = current.getLeft();
                }
                else if(ID>current.getID())
                {
                    previous = current;
                    current = current.getRight();
                }
                else if(current == null)
                {
                    found = true;
                }
            }
            
            if(current==null)
            {
                System.out.println("Node does not exist");
                return false;
            }
            
            //Find out number of children
            int noOfChildren = 0;
            if(current.getRight()!=null)
            {
                noOfChildren++;
            }
            if(current.getLeft()!=null)
            {
                noOfChildren++;
            }
            
            //delete a node with no children
            if(noOfChildren==0)
            {
                if(previous.getLeft()==current)
                {
                    previous.setLeft(null);
                }
                else if(previous.getRight()==current)
                {
                    previous.setRight(null);
                }
            }
            else if(noOfChildren==1)
            {
                if(previous.getLeft()==current)
                {
                    if(current.getLeft()!=null)
                    {
                        previous.setLeft(current.getLeft());
                    }
                    if(current.getRight()!=null)
                    {
                        previous.setLeft(current.getRight());
                    }
                }
                else if(previous.getRight()==current)
                {
                    if(current.getLeft()!=null)
                    {
                        previous.setRight(current.getLeft());
                    }
                    if(current.getRight()!=null)
                    {
                        previous.setRight(current.getRight());
                    }
                }
            }
            else if(noOfChildren==2)
            {
                //Find the rightmost left tree
                BinaryNode newCurrent = current.getLeft();
                BinaryNode newPrevious = current;
                found=false;
                
                while(!found)
                {
                    if(newCurrent.getRight()==null)
                    {
                        found = true;
                    }
                    else
                    {
                        newPrevious = newCurrent;
                        newCurrent = newCurrent.getRight();
                    }
                }
                
                newPrevious.setRight(newCurrent.getLeft());
                
                if(previous.getRight()==current)
                {
                    previous.setRight(newCurrent);
                }
                else if(previous.getLeft()==current)
                {
                    previous.setLeft(newCurrent);
                }
                
                newCurrent.setLeft(current.getLeft());
                newCurrent.setRight(current.getRight());
            }
        }
        return true;
    }
    
    /**
     * Find and print a specific node
     */
    public void findAndPrint()
    {
        System.out.print("Enter the ID of the student you want to see the details of: ");
        int searchID = Genio.getInteger();
        
        BinaryNode current = top;
        boolean found = false;
        
        if(top.getID()==searchID)
        {
            top.print();
        }
        else
        {
            while(found==false)
            {
                if(current.getID()==searchID)
                {
                    current.print();
                    found = true;
                }
                else if(searchID>current.getID())
                {
                    current = current.getRight();
                }
                else if(searchID<current.getID())
                {
                    current = current.getLeft();
                }
            }
        }
    }
    
    /**
     * Prints the entire tree
     */
    public void printTree()
    {
        traverseTree(top);
    }
    
    /**
     * Print entire tree in numerical order
     * 
     * @param BinaryNode - Pass in the node you want to print from
     */
    private void traverseTree(BinaryNode root)
    {
        if(root!=null)
        {
            traverseTree(root.getLeft());
            root.print();
            traverseTree(root.getRight());
        }
    }
}
