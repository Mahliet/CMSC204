/**
 * @author- Mahliet Admasu
 */
import java.util.ArrayList;
/**
*Queue class 
*
* @param <T> Generic parameter
*/
public class MyQueue<T> implements QueueInterface<T> 
{


   private ArrayList<T> queue;
   private int capacity;
   
   /**
    * constructor
    */
   public MyQueue()
   {
       queue = new ArrayList<>();
       capacity = 10;
   }
   /**
    * constructor
    * @param capacity
    */
   public MyQueue(int capacity)
   {
       queue = new ArrayList<>(capacity);
       this.capacity = capacity;
   }
   /**
    * Determines if Queue is empty
    * @return true if Queue is empty, false if not
    */
   @Override
   public boolean isEmpty() 
   {
       if (queue.isEmpty()) 
       {
           return true;
       }
       return false;
   }
   /**
	 * Determines of the Queue is Full
	 * @return true if Queue is full, false if not
	 */
   @Override
   public boolean isFull()
   {

       if (queue.size() == capacity) 
       {
           return true;
       }
       return false;
   }
   /**
	 * Deletes and returns the element at the front of the Queue
	 * @return the element at the front of the Queue
	 * @throws QueueUnderflowException if queue is empty
	 */
   @Override
   public T dequeue() throws QueueUnderflowException
   {

       if (isEmpty()) 
       {
           throw new QueueUnderflowException();
       }

       T next = queue.get(0);
       queue.remove(0);
       queue.trimToSize();
       queue.ensureCapacity(capacity);

       return next;
   }
   /**
	 * Returns number of elements in the Queue
	 * @return the number of elements in the Queue
	 */
   @Override
   public int size() 
   {

       return queue.size();
   }
   /**
	 * Adds an element to the end of the Queue
	 * @param e the element to add to the end of the Queue
	 * @return true if the add was successful
	 * @throws QueueOverflowException if queue is full
	 */
   @Override
   public boolean enqueue(T e) throws QueueOverflowException 
   {

       if (queue.size() == capacity)
       {
           throw new QueueOverflowException();
       }

       queue.add(e);
       return true;
   }
   /**
	 * Returns the string representation of the elements in the Queue 
	 * @return string representation of the Queue with elements
	 */
   @Override
   public String toString() 
   {
       String s = "";
      
       for(T item: queue) {
           s += item.toString();
       }
       return s;
   }
   /**
	 * Returns the string representation of the elements in the Queue
	 * @return string representation of the Queue with elements separated with the delimiter
	 * @param delimiter
	 */
   @Override
   public String toString(String delimiter) 
   {
       String s = "";
      
       for(T item: queue) {
           s += item.toString();
           s += delimiter;
       }
      
       s = s.substring(0,s.length()-1);
      
       return s;
   }
   /**
	  * Fills the Queue with the elements of the ArrayLiist
	  * @param list elements to be added to the Queue
	  * @throws QueueOverflowException if queue is full
	  */
   @Override
   public void fill(ArrayList<T> list) 
   {
      
       queue.clear();
      
       for (T item : list) 
       {
           queue.add(item);
       }

   }

}