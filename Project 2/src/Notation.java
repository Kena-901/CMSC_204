import javax.management.OperationsException;

public class Notation {
	 /**
	  * converts infix notation to postfix notation
	  * @param infix
	  * @return a converted format of the initial infix notation
	  * @throws InvalidNotationFormatException
	  */
	 public static String convertInfixToPostfix(String infix)throws InvalidNotationFormatException
	 {
		 MyQueue<Character> postfixSolution = new MyQueue<Character>(); 
		 MyStack<Character> operators = new MyStack<Character>();
		 		 
		 char ch;
		 try
		 {
			 for(int i=0; i< infix.length();i++)
			 {
				 ch = infix.charAt(i);
				
					 if(Character.isDigit(ch))
					 {
						postfixSolution.enqueue(ch);
					 }
					 else if(ch == '(')
					 {
						operators.push(ch);
					 }
					 else if(ch == '+' || ch == '-' || ch == '*' || ch == '/')
					 {
						 if(!operators.isEmpty()) 
						 {
							 switch(ch)
							 {
							 	case '+':
								case '-':
									if(operators.top() == '+' || operators.top() == '-' || operators.top() == '*'|| operators.top() == '/')
										postfixSolution.enqueue(ch);
										operators.push(ch);
										break;
								case '*':
								case '/':
									if(operators.top() == '+' || operators.top() == '-' || operators.top() == '*'|| operators.top() == '/')
									{
										if(operators.top() == '+' || operators.top() == '-')
											postfixSolution.enqueue(ch);
										else
											postfixSolution.enqueue(operators.pop());
									}
									operators.push(ch);
									break;
							 }
						 }
					 }
					
					 else if(ch == ')')
					 {
						 while(operators.top() != '(')
						 {
							 postfixSolution.enqueue(operators.pop());
							 if(operators.isEmpty())
								 throw  new InvalidNotationFormatException();												 					 
						 }
						 if(operators.top() == '(')
							 operators.pop();			   
					 } 
			 }
			 while(operators.size()> 1)
			 {
				 postfixSolution.enqueue(operators.pop());
			 }
		 }
		 catch(StackUnderflowException | InvalidNotationFormatException| StackOverflowException | QueueOverflowException e)
		 {
			throw new InvalidNotationFormatException();
		 }
		
		 return postfixSolution.toString();
	 }
	 
	 /**
	  * converts postfix notation to infix notation
	  * @param postfix
	  * @return a converted format of the initial postfix notation
	  * @throws InvalidNotationFormatException
	  */
	 public static  String convertPostfixToInfix(String postfix)throws InvalidNotationFormatException
	 {
		 MyStack<String> infix = new MyStack<String>();
		 char ch;
		 String hold1,hold2,result;
		 
		 try 
		 {
			 for (int i = 0; i < postfix.length(); i++) 
			 { 
				 ch =postfix.charAt(i);
				 if(Character.isDigit(ch))
				 {
					 infix.push(Character.toString(ch));
				 }
				 else if(ch == '+' || ch == '-' || ch == '*' || ch == '/')
				 {
					 if(infix.size() < 2)
						 throw new InvalidNotationFormatException();
					 else
					 {
						hold2 = infix.pop();
						hold1 = infix.pop();
						result = "("+ hold1+ ch+ hold2+ ")";
						infix.push(result);				
					 }	 
				 }
			 }
			 if(infix.size() != 1)
			 {
				 throw new InvalidNotationFormatException();
			 }
		 }
		 catch(StackUnderflowException | InvalidNotationFormatException| StackOverflowException e)
		 {
			 throw new InvalidNotationFormatException();
		 }
	 
		 return infix.toString();
	 }
	 
	 /**
	  * Evaluates the value of a postfix notaion
	  * @param postfixExp
	  * @return value of a postfix notaion
	  * @throws InvalidNotationFormatException
	  */
	 public static double evaluatePostfixExpression(String postfixExp)throws InvalidNotationFormatException
	 {
		 MyStack<Integer> value = new MyStack<Integer>();
		 char ch;
		 int hold1,hold2,result = 0;
		 
		 try {
			 for (int i = 0; i < postfixExp.length(); i++) 
			 { 
				 ch =postfixExp.charAt(i);
				 if(Character.isDigit(ch))
				 {
					 value.push(Character.getNumericValue(ch));
				 }
				 else if(ch == '+' || ch == '-' || ch == '*' || ch == '/')
				 {
					 if(value.size() < 2)
						 throw new InvalidNotationFormatException();
					 else
					 {
						hold2 = value.pop();
						hold1 = value.pop();
						switch(ch)
						{
						case '+' :
							result = hold1 + hold2;
							break;
						case '-' :
							result = hold1 - hold2;
							break;
						case '*' :
							result = hold1 * hold2;
							break;
						default :
							result = hold1 / hold2;
						}
						value.push(result);				
					 }	 
				 }
			 }
			 if(value.size() != 1)
			 {
				 throw new InvalidNotationFormatException();
			 }
		 }
		 catch(StackUnderflowException | InvalidNotationFormatException| StackOverflowException e)
		 {
			 throw new InvalidNotationFormatException();
		 }
		 return result;
	 }

}
