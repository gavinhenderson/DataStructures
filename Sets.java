import java.util.HashSet;

/**
 * Interacts with the hashset java library so that the lottery can create instances of this
 * class to access the feautres needed of a set
 * 
 * @author Gavin Henderson
 * @version 1.0
 */
public class Sets
{
    HashSet set;
    
    /**
     * Constructor for objects of class Sets
     */
    public Sets()
    {
        set = new HashSet<Integer>();
    }
    
    /**
     * Add an integer to the set
     * 
     * @param int - The number to be added to the set
     * @return boolean - true if the number is added to the set
     */
    public boolean addToSet(int number)
    {
        return set.add(number);
    }
    
    /**
     * Checks to see if the specified number is in the set
     * 
     * @param int - the number you want to check is in the set
     * @return boolean - true if the number is in the set
     */
    public boolean includes(int number)
    {
        return set.contains(number);
    }
    
    /**
     * Removes a specific number from the set
     * 
     * @param int - the number that is being removed from the set
     * @return boolean - true if the number is removed from the set
     */
    public boolean remove(int number)
    {
        return set.remove(number);
    }
    
    /**
     * Checks the cardinality of the set
     * 
     * @return int - the size of the set
     */
    public int cardinality()
    {
        return set.size();
    }
    
    /**
     * Intersection, the set that this method is called on will become the intersection
     * 
     * @param HashSet - a set that is being intersected
     * @return boolean - true if this is completed successfully
     */
    public boolean intersection(HashSet secondSet)
    {
        return set.retainAll(secondSet);
    }
    
    /**
     * This returns the hashSet so it can be used in the intersection method
     * 
     * @return HashSet - The hashset object of itself
     */
    public HashSet getSet()
    {
        return set;
    }
    
    /**
     * The returns a set that is the difference between sets
     * 
     * set = A
     * newSet = B
     * A-B
     * set-newSet
     * 
     * @param set - the set that you want to subtract from
     * @return boolean - true if is successful
     */
    public boolean difference(HashSet newSet)
    {
        return set.removeAll(newSet);
    }
    
    
}
