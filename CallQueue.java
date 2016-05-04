import java.util.LinkedList;
import java.util.Queue;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The queue will store the list of callers
 * 
 * @author Gavin Henderson
 * @version 1.0
 */
public class CallQueue
{
    private Queue<QueueNode> callerQueue;
    /**
     * Constructor for objects of class Queue
     */
    public CallQueue()
    {
        callerQueue = new LinkedList<QueueNode>();
    }
    
    /**
     * Add a caller to the queue
     * 
     * @param QueueNode - The node that is going to be added to the queue
     */
    public boolean addToQueue(QueueNode nodeToAdd)
    {
        return callerQueue.add(nodeToAdd);
    }
    
    /**
     * Add a caller to the queue when you pass in a name and number
     * 
     * @param String - caller name
     * @param String - caller number
     */
    public boolean addToQueue(String name, String number)
    {
        QueueNode newNode = new QueueNode(name,number);
        
        return callerQueue.add(newNode);
    }
    
    /**
     * Removes a caller from the queue
     * 
     * @return QueueNode - Caller that is removerd
     */
    public QueueNode removeFromQueue()
    {
        QueueNode callerRemoved;
        
        try
        {
            callerRemoved = callerQueue.remove();
        }
        catch(NoSuchElementException e)
        {
            callerRemoved = null;
        }
        
        return callerRemoved;
    }
    
    /**
     * Find out if the queue is empty or nodt
     * 
     * @return True if queue is empty
     */
    public boolean isEmpty()
    {
        return callerQueue.isEmpty();
    }
    
    /**
     * Get the length of the queue
     * 
     * @return the number of items in the queue
     */
    public int getLength()
    {
        return callerQueue.size();
    }
    
    /**
     * Get the iterator for the queue so you can traverse it
     * 
     * @return the iterator for the queue
     */
    public Iterator<QueueNode> getIterator()
    {
        return callerQueue.iterator();
    }
}
