import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;


public class BasicDoubleLinkedList<T> implements Iterable<T>{

	/** Node class for linked list
	 */
	protected class Node<T> {
		private T data;
		private Node<T> prev;
		private Node<T> next;
		
		public Node(T data) 
		{
			this.data = data;
			this.prev = null; 
			this.next = null;
		}
		
		/** Setter for  next
		 */
		public void setNext(Node next) {
			this.next = next;
		}
		
		/** Setter for  prev
		 */
		public void setPrev(Node prev) {
			this.prev = prev;
		}
		
		/** Getter for next 
		 */
		public Node getNext(){
			return next;
		}

		/** Getter for prev
		 */
		public Node getPrev(){
			return prev;
		}
		
		/** Getter for data
		 */
		public T getData() {
			return data;
		}
		
	}
	
	/**Iterator to go through the list
	 */
	private class BasicDoubleLinkedListIterator<T> implements ListIterator<T> {
		
		private Node<T> current;
		private int index;
		
		/** Constructor that sets the current node to the head
		 *  and the current index set to 0
		 */
		public BasicDoubleLinkedListIterator(Node head) {
			current = head;
			index = 0;
		}
		
		/** Checks if there is a next item
		 */
		@Override
		public boolean hasNext() {
			return index < size;
		}

		/** Gets the next item in the list 
		 */
		@Override
		public T next() throws NoSuchElementException {
			if (hasNext()) {
				T result = current.getData();
				current = current.getNext();
				index++;
				return result;
			}
			
			throw new NoSuchElementException();
		}

		/** Checks if there is a previous node in the list
		 */
		@Override
		public boolean hasPrevious() {
			return index > 0;
		}

		/** Gets the previous element in the list if it exists
		 */
		@Override
		public T previous() throws NoSuchElementException {
			if (hasPrevious()) {
				current = current.getPrev();
				index--;
				return current.getData();
			}
			
			throw new NoSuchElementException("There is no such element!");
		}
		
		@Override
		public int nextIndex() throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}
		@Override
		public int previousIndex() throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}
		@Override
		public void remove() throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}
		@Override
		public void set(T e)throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}
		@Override
		public void add(T e) throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}
	}
	
	protected Node<T> head;
	protected Node<T> tail;
	protected int size;
	
	/** Default Constructor
	 */
	public BasicDoubleLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	/** Adds an element to the end of the list
	 * 
	 * @param data The data to be added to the end of the list
	 * @return A reference to this class
	 */
	public void addToEnd(T data) {
		Node<T> newNode = new Node<T> (data);
		if(tail == null)
			head = tail = newNode;
		else {
			newNode.setPrev(tail);
			newNode.setNext(head);
			tail.setNext(newNode);
			tail = newNode;
			head.setPrev(tail);
		}
		size++;
	}
	
	/** Adds an element to the front of the list
	 * 
	 * @param data The data to be added to the front of the list
	 * @return A reference to this class
	 */
	public void addToFront(T data) {
		Node<T> newNode = new Node<T>(data);
		
		if (head == null)
			head = tail = newNode;
		else {
			newNode.setNext(head);
			newNode.setPrev(tail);
			head.setPrev(newNode);
			head = newNode;
			tail.setNext(head);
		}
		
		size++;
	}
	
	/** Gets the first element of the list 
	 */
	public T getFirst() {
		return head.getData();
	}
	
	/** Gets the last element of the list
	 */
	public T getLast() {
		return tail.getData();
	}
	
	/** Gets the size of the list
	 */
	public int getSize() {
		return size;
	}
	
	/** The iterator for going through the list
	 */
	@Override
	public ListIterator<T> iterator() throws UnsupportedOperationException, NoSuchElementException{
		return new BasicDoubleLinkedListIterator<T>(head);
	}
	
	/** Removes a node from the list
	 */
	public BasicDoubleLinkedList<T> remove(T targetData, Comparator<T> comparator){
		if (head != null) {
			Node<T> check = head;
			while(check != null && comparator.compare(check.getData(), targetData) < 0) {
				check = check.getNext();
			}
			
			if (check != null) {
			
				if (check == head)
					retrieveFirstElement();
				else if (check == tail)
					retrieveLastElement();
				else {
					check.getPrev().setNext(check.getNext());
					check.getNext().setPrev(check.getPrev());
					check.setPrev(null);
					check.setNext(null);
					size--;
				}
				
				check = null;
			}
		}
		
		return this;
	}
	
	/** Gets the first element of the list and removes it
	 */
	public T retrieveFirstElement() {
		if (head == null)
			return null;
		T result = head.getData();
		head = head.getNext();
		head.setPrev(tail);
		tail.setNext(head);
		
		size--;
		return result;
	}
	
	/** Gets the last element of the list and removes it
	 */
	public T retrieveLastElement() {
		if (tail == null)
			return null;
		T result = tail.getData();
		tail = tail.getPrev();
		tail.setNext(head);
		head.setPrev(tail);
		
		size--;
		return result;
	}
	
	/** Turns the list into an ArrayList
	 * 
	 * @return An ArrayList of the data in the list.
	 */
	public ArrayList<T> toArrayList(){
		ArrayList<T> list = new ArrayList<>();
		Node<T> check = head;
		do {
			if (size == 1)
				list.add(head.getData());
			else {
				list.add(check.getData());
				check = check.getNext();
			}
		} while(check != head);
		return list;
	}
}