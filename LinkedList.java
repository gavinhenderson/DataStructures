/**
 * This class will setup and control a linked list
 * 
 * @author Gavin Henderson
 * @version 1.0
 */
public class LinkedList
{ 
    ListNode head; //Makes the head of the list a local variable to this class
    
    /**
     * Constructor for objects of class LinkedList
     */
    public LinkedList()
    {
        head = null; //Initialises the head as null as the list is initially empty
    }
    
    /**
     * Create a new node
     * 
     * @param boolean - true if the node is succefully added
     */
    public boolean createNode()
    {
        System.out.print('\u000c');
        ListNode newNode = new ListNode(); //Creates an instance of ListNode to add to the list
        
        //Changes the attributes of the item you are adding to the list
        System.out.print("Please enter the ID of the student: ");
        newNode.setID(Genio.getInteger());
        System.out.print("Please enter the mark of the student: ");
        newNode.setMark(Genio.getInteger());
        
        ListNode current = head;
        
        if(head==null) //If the list is empty then it sets the newNode as the start of the list
        {
            head = newNode;
        }
        else //Otherwise it goes through the list (using current) till it finds the end
        {

            boolean added = false;
            
            while(added==false) //This loops while the current is not null
            {
                if(newNode.getID()==current.getID())
                {
                    added=true;
                }
                else if(current.getNext()==null) //The end of the list is found when the node after current is null
                {
                    added=true;
                    current.setNext(newNode); //set the next of the current to
                }
                else
                {
                    current = current.getNext(); //Iterates through the list
                }
            }
        }
        
        if(newNode.getID()==current.getID())
        {
            System.out.println("A node with this ID already exists");
            return false;
        }
        else
        {
            newNode.printInfo(); //Prints out the info of the new node
            return true;
        }
    }
    
    /**
     * Search the linked list by ID and return the node
     */
    public void searchByID()
    {
        System.out.print('\u000c');
        boolean found = false;
        
        //Gets the user to enter the ID of the student and saves it

        
        ListNode current = head;
        if(head==null) //If the list is empty tell the user then dont continue
        {
            System.out.println("This could not be found because the list is empty");
        }
        else //If the list is not empty dont continue
        {
            System.out.print("Please enter the ID of the student you would like to print :");
            int ID = Genio.getInteger();
            while(found==false) //Loop through the list starting at the head
            {
                if(current.getID()==ID) //if current ID matches the one that is being searched for
                {
                    found = true; //Exits the loop
                    current.printInfo(); //Prints the info for the found node
                }
                else if(current==null) //If it reaches the end of the list and its null then exit loop
                {
                    found = true; //Exit loop
                }
                else
                {
                    current = current.getNext(); //Increments through the list
                }
            }
        }
        
        if (current==null) //Runs if the list didnt have the item
        {
            System.out.println("This node does not exist");
        }
    }
    
    /**
     * Prints out the entire linked list in one
     */
    public void printList()
    {
        System.out.print('\u000c'); //Clears the screen
        
        ListNode current = head;
        while(current!=null) //Loops through every thing in the loop
        {
            current.printInfo(); //Prints the current nodes information
            current = current.getNext(); //Increments though the list
        }
    }
    
    /**
     * Remove node by ID
     */
    public void removeNode()
    {
        System.out.print('\u000c');
        boolean found = false;
        
        //Initalises variables to store the current and previous nodes in the loop
        ListNode current = head;
        ListNode previous = head;
        
        if(head==null) //If the list is empty tell the user and do not continue
        {
            System.out.println("This could not be found because the list is empty");
        }
        else
        {
            System.out.print("Please enter the ID of the student you would like to remove :");
            int ID = Genio.getInteger();
        
            if(head.getID()==ID) //If the head is being removed run this
            {
                head = head.getNext(); //Set the second item in the list as the first
            }
            else
            {
                while(found==false) //Loop through the nodes until the corrent node is found
                {
                    if(current.getID()==ID) //When the current node ID matches what is being searched for
                    {
                        found = true; //Dont run loop again
                        previous.setNext(current.getNext()); //Makes the list skip the node that is being removed
                    }
                    else if(current==null) //If the end of the loop is reached without having found the node
                    {
                        found = true; //Exit the loop
                    }
                    else
                    {
                        previous = current; //Update previous
                        current = current.getNext(); //Increment through the list
                    }
                }
            }
        }
        
        if (current==null) //If the node was not found tell the user
        {
            System.out.println("This node does not exist");
        }
    }
}
