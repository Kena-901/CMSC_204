import java.util.ArrayList;

public class MyQueue<T> implements QueueInterface<T>{
	
	private T [] queue;
	private int last;
	private int count;
	private static final int DEFUALT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 100000;
	
	public MyQueue() {
		this(DEFUALT_CAPACITY);
	}
	
	public MyQueue (int initial)
	{
		T [] temp = (T []) new Object [initial];
		
		queue = temp;
		last = -1;
		count = initial;
	}

	/**
	 * Determines if Queue is empty
	 * @return true if Queue is empty, false if not
	 */
	public boolean isEmpty() {

		if(size() == 0)
			return true;
		else
			return false;
	}

	/**
	 * Determines of the Queue is Full
	 * @return true if Queue is full, false if not
	 */
	public boolean isFull() {
		if(size() == queue.length)
			return true;
		else
			return false;
	}

	/**
	 * Deletes and returns the element at the front of the Queue
	 * @return the element at the front of the Queue
	 * @throws QueueUnderflowException if queue is empty
	 */
	public T dequeue() throws QueueUnderflowException {
		T hold;
		if(this.isEmpty())
		{
			throw  new QueueUnderflowException();
		}
		else
		{
			hold = queue[0];
			queue[0] = null;
			
			for(int i=0; i<queue.length-1; i++)
			{
				queue[i] = queue[i+1];
			}
			last--;
			return hold;
		}
	}
	
	/**
	 * Returns number of elements in the Queue
	 * @return the number of elements in the Queue
	 */
	public int size() {
		int size= last + 1;
		return size;
	}

	/**
	 * Adds an element to the end of the Queue
	 * @param e the element to add to the end of the Queue
	 * @return true if the add was successful
	 * @throws QueueOverflowException if queue is full
	 */
	public boolean enqueue(T e) throws QueueOverflowException {
		if(this.isFull())
		{
			throw  new QueueOverflowException();
		}
		else
		{
			queue[last+1] = e;
			last++;
			return true;
		}
	}
	
	/**
	 * Returns the string representation of the elements in the Queue, 
	 * the beginning of the string is the front of the queue
	 * @return string representation of the Queue with elements
	 */
	public String toString() {
		StringBuilder content = new StringBuilder();
		
		 for (int i = 0; i < this.size(); i++) {
	            content.append(this.queue[i]);
	        } 		 
		return content.toString();
	}

	/**
	 * Returns the string representation of the elements in the Queue, the beginning of the string is the front of the queue
	 * Place the delimiter between all elements of the Queue
	 * @return string representation of the Queue with elements separated with the delimiter
	 */
	public String toString(String delimiter) {
		StringBuilder content = new StringBuilder();
		
		for (int i = 0; i < this.size(); i++) {
			 if(i == this.size()-1)
	            content.append(this.queue[i]);
			 else
				 content.append(this.queue[i] + delimiter);
				 
	        } 		 
		return content.toString();
	}

	 /**
	  * Fills the Queue with the elements of the ArrayList, First element in the ArrayList
	  * is the first element in the Queue
	  * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE QUEUE, if you use the
	  * list reference within your Queue, you will be allowing direct access to the data of
	  * your Queue causing a possible security breech.
	  * @param list elements to be added to the Queue
	  * @throws QueueOverflowException if queue is full
	 
	  */
	public void fill(ArrayList<T> list) throws QueueOverflowException {
		
		T [] temp = (T []) new Object [list.size()];
		
		for(int i =0; i < temp.length; i++)
		{
			temp[i]= list.get(i); 
		}
		
		for(int i =0; i < temp.length; i++)
		{
			if(this.isFull())
			{
				throw new QueueOverflowException();
			}
			else
				this.enqueue(temp[i]); 
		}		
		
	}
	

}
