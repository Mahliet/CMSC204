/**
 *@author- Mahliet Admasu
 */
import java.util.ArrayList;
/**
* stack class
*
* @param <T> parameter for stack
*/
public class MyStack<T> implements StackInterface<T>
{

   private ArrayList<T> stack;
   private int capacity;
  /**
   * constructor
   */
  public MyStack() 
   {

       stack = new ArrayList<>();
       capacity = 10;
   }
  /**
   * constructor
   * @param capacity the capacity of the stack
   */
   public MyStack(int capacity) 
   {

       stack = new ArrayList<>(capacity);
       this.capacity = capacity;

   }
   /**
    * Determines if Stack is empty
    * @return true if the stack is empty, false if not
    */
   @Override
   public boolean isEmpty() 
   {
      
       if (stack.isEmpty()) 
       {
           return true;
       }
      
       return false;
   }
   /**
    * Determines if the stack is full
    * @return true if the stack is full, false if not
    */
   @Override
   public boolean isFull() 
   {
       if (stack.size() == capacity)
       {
           return true;
       }
       return false;
   }
   /**
    * Deletes and returns the element at the top of the Stack
    * @return the element at the top of the Stack
    * @throws StackUnderflowException if stack is empty
    */
   @Override
   public T pop() throws StackUnderflowException 
   {
       if(stack.size() == 0) {
           throw new StackUnderflowException();
       }

       T top = stack.get(stack.size() - 1);
       stack.remove(stack.size() - 1);
       return top;
   }
   /**
    * Returns the element at the top of the Stack, does not pop it off the Stack
    * @return the element at the top of the Stack
    * @throws StackUnderflowException if stack is empty
    */
   @Override
   public T top() throws StackUnderflowException
   {
       if (stack.size() == 0) {
           throw new StackUnderflowException();
       }
       return stack.get(stack.size()-1);
   }
   /**
    * Number of elements in the Stack
    * @return the number of elements in the Stack
    */
   @Override
   public int size() 
   {
       return stack.size();
   }
   /**
    * Adds an element to the top of the Stack
	* @param e the element to add to the top of the Stack
	* @return true if the add was successful, false if not
	* @throws StackOverflowException if stack is full
	*/
   @Override
   public boolean push(T e) throws StackOverflowException
   {
       if (stack.size() == capacity) 
       {
           throw new StackOverflowException();
       }
      
       stack.add(e);
      
       return true;
   }
  /**
   * Returns the elements of the Stack in a string from bottom to top
   * @return an string which represent the Objects in the Stack from bottom to top
   */

   @Override
   public String toString() 
   {
   String s = "";
      
       for(T item: stack) 
       {
           s += item.toString();
       }
       return s;
      
   }
   /**
    * 
    * Returns the string representation of the elements in the Stack
	* @return string representation of the Stack from bottom to top with elements 
	* separated with the delimiter
	*/
   @Override
   public String toString(String delimiter) 
   {
       String s = "";
      
       for(T item: stack) 
       {
           s += item.toString();
           s += delimiter;
       }
      
       s = s.substring(0,s.length()-1);
      
       return s;
   }
   /**
    * Fills the Stack with the elements of the ArrayList
	* @param list elements to be added to the Stack from bottom to top
	* @throws StackOverflowException if stack gets full
	*/
   @Override
   public void fill(ArrayList<T> list) 
   {
      
       stack.clear();

       for (T item : list) 
       {
      
           stack.add(item);
       }

      
   }

}