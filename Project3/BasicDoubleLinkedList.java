/**
 * @author Mahliet Admasu
 */
import java.util.ArrayList; 
import java.util.ListIterator; 
import java.util.NoSuchElementException; 

public class BasicDoubleLinkedList<T> implements java.lang.Iterable<T> 
{ 
	protected class Node 
	{ 
		protected T data; 
		protected Node next, prev; 

		protected Node(T data, Node next, Node prev) 
		{ 
			this.data = data; 
			this.next = next; 
			this.prev = prev; 
		} 
	} 

	protected int size; 
	protected Node head, tail; 
	/**
	 * Constructor
	 */
	public BasicDoubleLinkedList() 
	{ 
		size = 0; 
		head = tail = null; 
	} 
	
	public class DoubleLinkedListIterator implements ListIterator<T> 
	{ 
		private Node curr; 
		private Node last; 
		
		public DoubleLinkedListIterator() 
		{ 
			curr = head; 
			last = null; 
		} 
		public T next() 
		{ 
			if(curr != null) 
			{ 
				T returnData = curr.data; 
				last = curr; 
				curr = curr.next; 
				if(curr != null)
				{ 
					curr.prev = last;
				} 
				return returnData; 
			} 
			else 
				throw new NoSuchElementException(); 
		} 
		public boolean hasNext() 
		{ 
			return curr!=null; 
		} 
		public T previous() 
		{ 
			if(last != null) 
			{ 
				curr = last; 
				last= curr.prev; 
				T returnData = curr.data; 
				return returnData; 
			} 
			else 
				throw new NoSuchElementException(); 
		} 
		public boolean hasPrevious() 
		{ 
			return last!=null; 
		} 
		public void set(T elem) 
		{ 
			curr.data = elem; 
		} 
		@Override 
		public int nextIndex() 
		{ 
			throw new UnsupportedOperationException(); 
		} 

		@Override 
		public int previousIndex() 
		{ 
			throw new UnsupportedOperationException(); 
		} 

		@Override 
		public void remove() 
		{ 
			throw new UnsupportedOperationException(); 
		} 

		@Override 
		public void add(T e) 
		{ 
			throw new UnsupportedOperationException(); 
		}
		
	} 
	
	/**
	 * Adds an element to the end of the list and updated the size of the list
	 * @param data
	 */
	public BasicDoubleLinkedList<T> addToEnd(T data) 
	{ 
		Node temp = new Node(data, null, tail); 
		if (tail != null) 
		{ 
			tail.next = temp; 
		} 
		tail = temp; 
		if (head == null) 
		{ 
			head = temp; 
		} 
		size++; 
		return this; 
	} 
	
	/**
	 * Adds element to the front of the list and updated the size of the list
	 * @param data
	 */
	public BasicDoubleLinkedList<T> addToFront(T data) 
	{ 
		Node temp = new Node(data, head, null); 
		if (head != null) 
		{ 
			head.prev = temp; 
		} 
		head = temp; 
		if (tail == null) 
		{ 
			tail = temp; 
		} 
		size++; 
		return this; 
	} 
	
	/**
	 * Returns but does not remove the first element from the list.
	 * @return
	 */
	public T getFirst() 
	{ 
		return head.data; 
	} 
	
	/**
	 * Returns but does not remove the last element from the list.
	 * @return
	 */
	public T getLast() 
	{ 
		return tail.data; 
	}
	
	/**
	 * Returns the number of nodes in the list.
	 * @return
	 */
	public int getSize() 
	{ 
		return size; 
	} 
 
	/**
	 * This method returns an object of the DoubleLinkedListIterator.
	 * @return
	 */
	public java.util.ListIterator<T> iterator() 
	{ 
		return new DoubleLinkedListIterator(); 
	} 
	
	/**
	 * Removes the first instance of the targetData from the list.
	 * @param targetData
	 * @param comparator
	 * @return
	 */
	public BasicDoubleLinkedList<T> remove(T targetData, java.util.Comparator<T> comparator) 
	{ 
		Node previous = null, curr = head; 
		while (curr != null) 
		{ 
			if (comparator.compare(curr.data, targetData) == 0) 
			{ 
				if (curr == head) 
				{ 
					head = head.next; 
					curr = head; 
				} 
				else if (curr == tail) 
				{ 
					curr = null; 
					tail = previous; 
					previous.next = null; 
				}
				else 
				{ 
					previous.next = curr.next; 
					curr = curr.next; 
				} 
				size--; 
			} 
			else 
			{ 
				previous = curr; 
				curr = curr.next; 
			} 
		} 
		return this; 
	} 
	
	/**
	 * Removes and returns the first element from the list.
	 * @return
	 */
	public T retrieveFirstElement()
	{ 
		if (size == 0) 
		{ 
			throw new NoSuchElementException("Linked list is empty"); 
		} 
		Node temp = head; 
		head = head.next; 
		head.prev = null; 
		size--; 
		return temp.data; 
	} 
	
	/**
	 * Removes and returns the Last element from the list.
	 * @return last element
	 */
	public T retrieveLastElement() 
	{ 
		if (head == null) 
		{ 
			throw new NoSuchElementException("Linked list is empty"); 
		} 
	
		Node currentNode = head; 
		Node previousNode = null; 

		while (currentNode != null) 
		{ 
			if (currentNode.equals(tail)) 
			{ 
				tail = previousNode; 
				break; 
			} 
			previousNode = currentNode; 
			currentNode = currentNode.next; 
		} 
		size--; 
		return currentNode.data; 
	} 
	
	/**
	 * Returns an arraylist of all the items in the Double Linked list
	 * @return AList
	 */
	public BasicDoubleLinkedList.DoubleLinkedListIterator toArrayList()
	{ 
		ArrayList<T> AList = new ArrayList<T>(); 
		ListIterator<T> iterator = new DoubleLinkedListIterator(); 

		BasicDoubleLinkedList.DoubleLinkedListIterator temp = null;
		while (iterator.hasNext()) 
		{ 
			temp.add(iterator.next()); 
		} 
		return temp; 
	} 
	

} 