/**
 * @author Mahliet Admasu
 */
import java.util.ListIterator; 

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> 
{ 
	java.util.Comparator<T> compare = null; 
	 
	public SortedDoubleLinkedList<T> add(T data) 
	{ 
		if (data == null) 
		{ 
			return this; 
		} 

		Node node = new Node(data, null, null); 
		if (head == null) 
		{ 
			head = tail = new Node(data, null, null); 
		} 
		else 
		{ 
			if (compare.compare(data, (T) tail.data) >= 0)	
			{ 
				tail.next = node; 
				tail = node; 
			} 
			
			else if (compare.compare(data, (T) head.data) <= 0) 
			{ 
				node.next = head; 
				head = node; 
			} 
			
			else 
			{ 
				Node next = head.next; 
				Node prev = head; 
				while (compare.compare(data, (T) next.data) > 0) 
				{ 
					prev = next; 
					next = next.next; 
				} 
				prev.next = node; 
				node.next = next; 
			} 
		} 
		size++; 
		return this; 
	} 
	public SortedDoubleLinkedList(java.util.Comparator<T> comparator) 
	{ 
		compare = comparator; 
	} 

	@Override 
	public BasicDoubleLinkedList<T> addToEnd(T data) 
	{ 
	   throw new UnsupportedOperationException("Invalid operation for sorted list"); 
	} 

	@Override 
	public BasicDoubleLinkedList<T> addToFront(T data) 
	{ 
		throw new UnsupportedOperationException(); 
	} 


	public SortedDoubleLinkedList<T> remove(T data, java.util.Comparator<T> comparator)
	{ 
		Node next = head; 
		Node prev = null; 
		if (next != null) 
		{ 
			if (comparator.compare((T) next.data, data) == 0) 
			{ 
				size--; 
				if (prev != null) 
				{ 
					prev.next = next.next; 
				} 
				else 
				{ 
					head = next.next; 
				} 
				if (next == tail) 
				{ 
					tail = prev; 
				} 
			} 
			prev = next; 
			next = next.next; 
		} 

		return this; 
	} 

	public ListIterator<T> iterator() 
	{ 
		return new DoubleLinkedListIterator(); 
	} 
}
