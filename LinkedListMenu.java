/**
 * This class calls all the functions from the linked list in an ordered fashion
 * 
 * @author Gavin Henderson
 * @version 1.0
 */
public class LinkedListMenu
{
    LinkedList list;
    /**
     * Constructor for objects of class LinkedListMenu
     */
    public LinkedListMenu()
    {
        list = new LinkedList();
        proccessUserChoice();
    }
    
    /**
     * This will display the menu
     */
    public void displayMenu()
    {
        System.out.println("Please select one of the options below");
        System.out.println("1: Create a node and add it to the list");
        System.out.println("2: Print the whole list");
        System.out.println("3: Search the list by ID");
        System.out.println("4: Remove node by ID");
        System.out.println("0: Close linked list");
    }
    
    /**
     * Reads and decides what action should be taken with the user choice
     */
    public void proccessUserChoice()
    {
        boolean exit = false;
        while(exit==false)
        {
            displayMenu();
            
            boolean valid = false;
            int choice = 0;
            
            while(valid==false)
            {
                System.out.print("Enter the choice: ");
                choice = Genio.getInteger();
                
                if((choice>=0)&&(choice<=4))
                {
                    valid = true;
                }
                else
                {
                    System.out.print('\u000c');
                    System.out.println("You did not enter a valid choice");
                    System.out.println("Please enter a choice between 0-4");
                }
            }
            
            switch(choice)
            {
                case 1: list.createNode();
                        break;
                case 2: list.printList();
                        break;
                case 3: list.searchByID();
                        break;
                case 4: list.removeNode();
                        break;
                case 0: exit = true;
                        break;
            }
        }
    }
}
