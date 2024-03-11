import java.util.Comparator;
import java.util.ListIterator;


public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
	
	private Comparator<T> comparator;
	
	/** Constructor that takes in a comparator used for adding data
	 * 
	 * @param comparator2 The comparator to compare data
	 */
	public SortedDoubleLinkedList(Comparator<T> comparator2) {
		comparator = comparator2;
	}
	
	/** Adds data in a certain order. Order is decided
	 *  with the comparator that used to create an instance of this class
	 */
	public SortedDoubleLinkedList<T> add(T data) {
		Node<T> newNode = new Node<T>(data);
		if (head == null)
			head = tail = newNode;
		else {
			Node<T> current = head;
			
			do {
				
				if (comparator.compare(newNode.getData(), current.getData()) == 0) {
					newNode.setNext(current.getNext());
					current.setNext(newNode);
					
					newNode.setPrev(current);
					newNode.getNext().setPrev(newNode);
					
					break;
				} else if (comparator.compare(newNode.getData(), current.getData()) < 0) {
					if (current == head) {
						newNode.setNext(current);
						current.setPrev(newNode);
						newNode.setPrev(tail);
						tail.setNext(newNode);
						
						head = newNode;
					} else {
						newNode.setNext(current);
						newNode.setPrev(current.getPrev());
						current.setPrev(newNode);
						newNode.getPrev().setNext(newNode);
					}
					
					break;
				} else if (comparator.compare(newNode.getData(), current.getData()) > 0) {
					if (current == tail) {
						tail.setNext(newNode);
						newNode.setPrev(tail);
						newNode.setNext(head);
						head.setPrev(newNode);
						
						tail = newNode;
						
						break;
					} else {
						current = current.getNext();
					}
				}
			} while(current != head);
		}
		
		size++;
		return this;
	}
	
	@Override
	public void addToEnd(T data) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void addToFront(T data) {
		throw new UnsupportedOperationException();
	}
	
	/** Iterator used to go through the list
	 * @return The iterator of the superclass
	 */
	@Override
	public ListIterator<T> iterator() {
		return super.iterator();
	}
	
	/** Removes an item in the list
	 */
	public SortedDoubleLinkedList<T> remove(T data, Comparator<T> comparator){
		super.remove(data, comparator);
		return this;
	}
}