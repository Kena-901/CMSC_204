import java.util.ArrayList;

public class MyStack <T> implements StackInterface<T>{

	private T [] stack;
	private int topIndex;
	private int count;
	private static final int DEFUALT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 100000;
	
	public MyStack() {
		this(DEFUALT_CAPACITY);
	}
	
	public MyStack (int initial)
	{
		T [] temp = (T []) new Object [initial];
		
		this.stack = temp;
		this.topIndex = -1;
		this.count = initial;
	}
	
	
	/**
	 * Determines if Stack is empty
	 * @return true if Stack is empty, false if not
	 */
	public boolean isEmpty() {
		
		if(size() == 0)
			return true;
		else
			return false;
	}

	/**
	 * Determines if Stack is full
	 * @return true if Stack is full, false if not
	 */
	public boolean isFull() {
		if(size() == stack.length)
			return true;
		else
			return false;
	}

	/**
	 * Deletes and returns the element at the top of the Stack
	 * @return the element at the top of the Stack
	 * @throws StackUnderflowException if stack is empty
	 */
	public T pop() throws StackUnderflowException {
		T hold;
		if(this.isEmpty())
		{
			throw  new StackUnderflowException();
		}
		else
		{
			hold = stack[size()-1];
			stack[size()-1] = null;
			topIndex--;			
			return hold;
		}
	}

	/**
	 * Returns the element at the top of the Stack, does not pop it off the Stack
	 * @return the element at the top of the Stack
	 * @throws StackUnderflowException if stack is empty
	 */
	public T top() throws StackUnderflowException {
		if(this.isEmpty())
		{
			throw  new StackUnderflowException();
		}
		else
		{
			return stack[size()-1];
		}
	}

	/**
	 * Number of elements in the Stack
	 * @return the number of elements in the Stack
	 */
	public int size() {
		int size= topIndex + 1;
		return size;
	}

	/**
	 * Adds an element to the top of the Stack
	 * @param e the element to add to the top of the Stack
	 * @return true if the add was successful, false if not
	 * @throws StackOverflowException if stack is full
	 */
	public boolean push(T e) throws StackOverflowException {
		if(this.isFull())
		{
			throw  new StackOverflowException();
		}
		else
		{
			stack[topIndex+1] = e;
			topIndex++;
			return true;
		}
		
	}
	
	/**
	 * Returns the elements of the Stack in a string from bottom to top, the beginning 
	 * of the String is the bottom of the stack
	 * @return an string which represent the Objects in the Stack from bottom to top
	 */
	public String toString() {
		 StringBuilder content = new StringBuilder();
	
		 for (int i = 0; i < this.size(); i++) {
	            content.append(this.stack[i]);
	        } 		 
		return content.toString();
	}

	/**
	 * Returns the string representation of the elements in the Stack, the beginning of the 
	 * string is the bottom of the stack
	 * Place the delimiter between all elements of the Stack
	 * @return string representation of the Stack from bottom to top with elements 
	 * separated with the delimiter
	 */
	public String toString(String delimiter) {
		StringBuilder content = new StringBuilder();
		
		 for (int i = 0; i < this.size(); i++) {
			 if(i == this.size()-1)
	            content.append(this.stack[i]);
			 else
				 content.append(this.stack[i] + delimiter);
				 
	        } 		 
		return content.toString();
	}

	/**
	  * Fills the Stack with the elements of the ArrayList, First element in the ArrayList
	  * is the first bottom element of the Stack
	  * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE STACK, if you use the
	  * list reference within your Stack, you will be allowing direct access to the data of
	  * your Stack causing a possible security breech.
	  * @param list elements to be added to the Stack from bottom to top
	  * @throws StackOverflowException if stack gets full
	  */
	public void fill(ArrayList<T> list) throws StackOverflowException {
		
		T [] temp = (T []) new Object [list.size()];
		
		for(int i =0; i < temp.length; i++)
		{
			temp[i]= list.get(i); 
		}
		
		for(int i =0; i < temp.length; i++)
		{
			if(this.isFull())
			{
				throw new StackOverflowException();
			}
			else
				this.push(temp[i]); 
		}		
	}
}
