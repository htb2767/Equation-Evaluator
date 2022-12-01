import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * 
 */

/**
 * @author huongbui
 *
 */
public class TesterEquation {
	 private static Scanner keyboard = new Scanner(System.in);
	 private static int middleIndex=0;
	 private static String comparisonToken=null;
	 private static String[] stringArr=null;
	 private static double variableVal;
	private static String variable;


	/**
	 * @Algorithm
	 * DECLARE VARIABLES:
	 * boolean result=true
	 * String yesNo =null
	 * String menuChoice = null
	 * double ans =0
	 * DO
	 * Display :You may perform one of the following opperations
	 * Display: 1. Compare two numbers or equations
	 * Display: 2. Calculate the equation
	 * Display: 3. Exit
	 * DO
	 * Display: Please enter a menu choice number
	 * Prompt menuChoice = keyboard.nextLine()
	 * UNTIL menuChoice.matches("([1-3])")
	 * SWITCH (menuChoice)
	 * case "1": result=comparison()
	 * if(result) Display :The comparison you input is true
	 * else Display: The comparison you input is false
	 * break
	 * case "2": ans=calculation()
	 * Display: The result of calculation is %.2f \n", ans 
	 * break
	 * default
	 * break
	 * Display: Would you like to compare or calculate the equations again?
	 * DO
	 * Display: Please enter yes or no
	 * yesNo = keyboard.nextLine()
	 * Until yesNo equals Yes or No
	 * Until yesNo equalsIgnoreCase yes
	 */
	public static void main(String[] args) {
		boolean result=true;
		String yesNo =null;
		String menuChoice = null;
		double ans =0;
		do {
		 System.out.println("You may perform one of the following opperations:");
	      System.out.println("1. Compare two numbers or equations");
	      System.out.println("2. Calculate the equation");
	      System.out.println("3. Exit");
		 do
	      {
			 variable=null;
	    	  variableVal=0;
	        System.out.println("Please enter a menu choice number.");
	        menuChoice = keyboard.nextLine();
	      } while (!menuChoice.matches("([1-3])"));
	      switch (menuChoice)
	      {
	      case "1":
	
	    	  result=comparison();
	  		
	  		if(result)
	  		{
	  			System.out.println("The comparison you input is true");
	  		}
	  		else
	  		{
	  			System.out.println("The comparison you input is false");
	  		}
	  		break;
	      case "2":
	    	  ans=calculation();
	    	  System.out.printf("The result of calculation is %.2f \n", ans );
	    	  break;
	        default:
	        break;
	    	 
	      }
	      System.out.println("Would you like to compare or calculate the equations again?");
	      
	      do
	      {
	        System.out.println("Please enter yes or no");
	        yesNo = keyboard.nextLine();

	      } while (!yesNo.equalsIgnoreCase("yes") && !yesNo.equalsIgnoreCase("no"));
	    } while (yesNo.equalsIgnoreCase("yes"));


	}
	/**
	 * @Algorithm:
	 * DECLARE VARIABLES:
	 * boolean isNotValid=true
	 * double value =0
	 * int countComp=0
	 * do
	 * try 
	 * Call countComp=input()
	 * if(countComp>0) throw new EquationException("")
	 * Call value=calculate(stringArr)
	 * isNotValid=false
	 * catch(EquationException myException)
	 * Until isNotValid is false
	 * @return: value
	 */
	
	private static double calculation()
	{
		
		boolean isNotValid=true;
		double value =0.0;
		int countComp=0;
		
		do {
		try {
			countComp=input();
		if(countComp>0)
		{
			throw new EquationException("");
		}
		
		value=calculate(stringArr);
		
		isNotValid=false;
		
		}catch(EquationException myException)
		{
			System.out.println(myException.getMessage());
		}
		}while(isNotValid);
		
		return value;
		
	}
	/**
	 * @Algorithm:
	 * DECLARE VARIABLES
	 * String userInput=null
	 * int length=0
	 * String token=null
	 * int index=0
	 * int countComp =0
	 * Display : please enter your equation.  Each token is separated by a space
	 * userInput=keyboard.nextLine()
	 * stringArr=userInput.split(" ")
	 * length= stringArr.length
	 * while(index<length)
	 * token=stringArr[index]
	 * if(!token.matches("[-+]?[0-9]*[.]?[0-9]+|[-+]?[a-zA-z]|[()]|[=<>@!]=|[+-<>]
	 * throw new EquationException()
	 * if(token.matches("[><]|[=<>@!]="))
	 * countComp++
	 * middleIndex=index
	 * comparisonToken=token
	 * index++
	 * @return countComp;
	 */
	 
	private static int input() throws EquationException
	{
		String userInput=null;
		int length=0;
		String token=null;
		int index=0;
		int countComp =0;
		System.out.println("please enter your equation.  Each token is separated by a space.");
		userInput=keyboard.nextLine();
		stringArr=userInput.split(" ");
		length= stringArr.length;
		while(index<length)
		{
			token=stringArr[index];
			
			if(!token.matches("[-+]?[0-9]*[.]?[0-9]+|[-+]?[a-zA-Z]|[()]|[=<>@!]=|[+-<>*/%]"))
			{
				throw new EquationException();
			}
			if(token.matches("[><]|[=<>@!]="))
			{
				countComp++;
				middleIndex=index;
				comparisonToken=token;
			}
			index++;
		}
		return countComp;
	}
	/**
	 * DECLARE VARIABLES:
	 * String[] firstArray=null
	 * String[] secondArray=null
	 * double leftValue=0
	 * double rightValue=0
	 * boolean compareResult=true
	 * boolean isNotValid=true
	 * int countComp=0
	 * do
	 * try
	 * countComp=input()
	 * if(countComp!=1) throw new EquationException()
	 * else
	 * firstArray= Arrays.copyOfRange(stringArr, 0, middleIndex)
	 * secondArray = Arrays.copyOfRange(stringArr, middleIndex+1, stringArr.length)
	 * leftValue=calculate(firstArray)
	 * rightValue=calculate(secondArray)
	 * isNotValid=false
	 * catch(EquationException myException)
	 * Until isNotValid) is false 
	 * @return: boolean
	 */

	private static boolean comparison() {
		String[] firstArray=null;
		String[] secondArray=null;
		double leftValue=0;
		double rightValue=0;
		boolean compareResult=true;
		boolean isNotValid=true;
		int countComp=0;
		do {
		try {
			countComp=input();
		if(countComp!=1)
		{
			//System.out.println("hshshs");
			throw new EquationException();
		}
		else
		{
			firstArray= Arrays.copyOfRange(stringArr, 0, middleIndex);
			secondArray = Arrays.copyOfRange(stringArr, middleIndex+1, stringArr.length);
		}
		leftValue=calculate(firstArray);
		rightValue=calculate(secondArray);
		isNotValid=false;
		
		}catch(EquationException myException)
		{
			System.out.println(myException.getMessage());
		}
		}while(isNotValid);
		//System.out.println("left" + leftValue);
		//System.out.println("right" + rightValue);

		
		if(comparisonToken.equals("=="))
		{
			if(leftValue==rightValue)
			{
				compareResult=true;
			}
			else
			{
				compareResult=false;
			}
		}
		else if(comparisonToken.equals(">="))
		{
			if(leftValue>=rightValue)
			{
				compareResult=true;
			}
			else
			{
				compareResult=false;
			}
		}
		else if(comparisonToken.equals("<="))
		{
			if(leftValue<=rightValue)
			{
				compareResult=true;
			}
			else
			{
				compareResult=false;
			}
		}
		else if(comparisonToken.equals(">"))
		{
			if(leftValue>rightValue)
			{
				compareResult=true;
			}
			else
			{
				compareResult=false;
			}
		}
		else if(comparisonToken.equals("<"))
		{
			if(leftValue<rightValue)
			{
				compareResult=true;
			}
			else
			{
				compareResult=false;
			}
		}
		else if(comparisonToken.equals("!="))
		{
			if(leftValue!=rightValue)
			{
				compareResult=true;
			}
			else
			{
				compareResult=false;
			}
		}
		else if(comparisonToken.equals("@="))
		{
			leftValue=Math.abs(leftValue);
			rightValue=Math.abs(rightValue);
			if(leftValue==rightValue)
			{
				compareResult=true;
			}
			else
			{
				compareResult=false;
			}
		}
		return compareResult;
		
		
	}
	/**
	 * @Algorithm:
	 * DECLARE VARIABLES:
	 * Stack<Double> valueStack = new Stack<Double>()
	 * Stack<String> operatorStack = new Stack<String>()
	 * int index=0
	 * int length = fArray.length
	 * double myNums=0.0
	 * double variableVal =0.0
	 * String variable=null
	 * String operator=null
	 * double firstVal=0.0
	 * double secondVal=0.0
	 * double finalValue=0.0
	 * String input =null
	 * 1. While there are still tokens to be read in
	 * 1.1 Get the next token
	 * 1.2 If the token is:
	 * 1.2.1 A number: push it onto the value stack.
	 * 1.2.2 A variable: get its value, and push onto the value stack.
	 * 1.2.3 A left parenthesis: push it onto the operator stack.
	 * 1.2.4 A right parenthesis:
	 * 1 While the thing on top of the operator stack is not a left parenthesis,
	 * 1 Pop the operator from the operator stack.
	 * 2 Pop the value stack twice, getting two operands.
	 * 3 Apply the operator to the operands, in the correct order.
	 * 4 Push the result onto the value stack.
	 * 2 Pop the left parenthesis from the operator stack, and discard it.
	 * 1.2.5 An operator (call it thisOp):
	 * 1 While the operator stack is not empty, and the top thing on the
	 * operator stack has the same or greater precedence as thisOp,
	 * 1 Pop the operator from the operator stack.
	 * 3 Apply the operator to the operands, in the correct order.
	 * 4 Push the result onto the value stack.
	 * 2 Push thisOp onto the operator stack.
	 * 2. While the operator stack is not empty,
	 * 1 Pop the operator from the operator stack.
	 * 2 Pop the value stack twice, getting two operands.
	 * 4 Push the result onto the value stack.
	 * 3. At this point the operator stack should be empty, and the value
	 * stack should have only one value in it, which is the final result.
	 * @param fArray
	 * @return
	 * @throws EquationException
	 */

	private static double calculate(String[] fArray) throws EquationException {
		Stack<Double> valueStack = new Stack<Double>();
		Stack<String> operatorStack = new Stack<String>();
		int index=0;
		int length = fArray.length;
		double myNums=0.0;
		
		String operator=null;
		double firstVal=0.0;
		double secondVal=0.0;
		double finalValue=0.0;
		String input =null;
		String token=null;
		while(index<length)
		{
			String myToken=fArray[index];
			if(myToken.matches("[-+]?[0-9]*[.]?[0-9]+"))
			{
				myNums=Double.parseDouble(myToken);
				//System.out.println("mynum " + myNums);
				valueStack.push(myNums);
			}
			else if(myToken.matches("[-+]?[a-zA-Z]"))
			{
				if(myToken.charAt(0)=='-')
				{
					token = myToken.substring(1);
				}
				else
				{
					token=myToken;
				}
				if(!token.equals(variable))
				{
				do
				{
				System.out.println("Please enter the value of " + token);
				input = keyboard.next();
				 keyboard.nextLine();
				}while(!input.matches("[-+]?[0-9]*[.]?[0-9]+"));
				variableVal=Double.parseDouble(input);
				if(myToken.charAt(0)=='-')
				{
					//myToken = myToken.substring(1);
					valueStack.push(-variableVal);
				}
				else
				{
					valueStack.push(variableVal);
				}
				//System.out.println("my variable " + variableVal);
				variable = token;
				
				
				}
				else
				{
					if(myToken.charAt(0)=='-')
					{
						//myToken = myToken.substring(1);
						valueStack.push(-variableVal);
					}
					else
						{
						valueStack.push(variableVal);
						}
					//System.out.println("cai 2");
				}
				//System.out.println("varabke"+variableVal);
			}
			else if(myToken.matches("[(]"))
			{
				operatorStack.push(myToken);
			}
			else if(myToken.matches("[)]"))
			{
				
				if(operatorStack.isEmpty()|| valueStack.isEmpty())
				{
					//System.out.println("djdj");
					throw new EquationException();
					
				}
				
				else if(valueStack.size()>=1&&operatorStack.peek().equals("("))
				{
					operatorStack.pop();
				}
				else
				{
				while(!operatorStack.peek().equals("(")&&valueStack.size()>=2&&operatorStack.size()>=1)
				{
					if(operatorStack.size()==1&&!operatorStack.peek().equals("("))
					{
						throw new EquationException();
					}
					//System.out.println("precendence");
					operator = operatorStack.pop();
					if(valueStack.size()<2)
					{
						throw new EquationException();
					}
					firstVal=valueStack.pop();
					//System.out.println("first val " + firstVal);
					secondVal=valueStack.pop();
					//System.out.println("second val " + secondVal);
					insertElement(operator,firstVal,secondVal,valueStack);
					
					
				}
				if(operatorStack.peek().equals("("))
				{
					operatorStack.pop();
				}
				}
			}
			else if(myToken.matches("[+-]|[*/%]"))
			{
				while(!operatorStack.isEmpty()&&precendence(myToken,operatorStack.peek()))
				{
					//System.out.println("thuc hien precedence");
					operator = operatorStack.pop();
					if(valueStack.size()<2)
					{
						//System.out.println("loi cong tru");
						throw new EquationException();
					}
					firstVal=valueStack.pop();
					secondVal=valueStack.pop();
					insertElement(operator,firstVal,secondVal,valueStack);
					
				
				}
				operatorStack.push(myToken);
				
			}
			index++;
			
		}
		
		while(!operatorStack.isEmpty()&&!operatorStack.peek().equals("("))
		{
			operator = operatorStack.pop();
			if(valueStack.size()<2)
			{
				throw new EquationException();
			}
			firstVal=valueStack.pop();
			secondVal=valueStack.pop();
			insertElement(operator,firstVal,secondVal,valueStack);
		}
		//System.out.println("value stack "+ valueStack.peek());
				
		if(!operatorStack.isEmpty()||valueStack.size()!=1)
		{
			throw new EquationException();
		}
		//System.out.println("size"+valueStack.size());
		finalValue=valueStack.pop();
		
		return finalValue;
		
	}
	/**
	 * boolean valid=true
	 * if(curToken.matches("[+-]")&&prevToken.matches("[+-]"))
	 * valid=true
	 * else if(curToken.matches("[/*%]")&&prevToken.matches("[/*%]"))
	 * valid=true
	 * else if(curToken.matches("[+-]")&&prevToken.matches("[/*%]"))
	 * valid=true
	 * else valid=false
	 * @param curToken
	 * @param prevToken
	 * @return: valid
	 */

	private static boolean precendence(String curToken, String prevToken) {
		boolean valid=true;
		if(curToken.matches("[+-]")&&prevToken.matches("[+-]"))
		{
			valid=true;
		}
		else if(curToken.matches("[*/%]")&&prevToken.matches("[*/%]"))
		{
			valid=true;
		}
		else if(curToken.matches("[+-]")&&prevToken.matches("[*/%]"))
		{
			valid=true;
		}
		else
		{
			valid=false;
		}
		return valid;
	}
	/**
	 * double value=0
	 * if(operator.equals("+")) value=firstVal+secondVal
	 * else if(operator.equals("-")) value= secondVal-firstVal
	 * else if(operator.equals("*")) value=firstVal*secondVal
	 * else if(operator.equals("/")) value= secondVal/firstVal
	 * else if(operator.equals("%")) value= secondVal%firstVal
	 * valueStack.push(value);
	 * @param operator
	 * @param firstVal
	 * @param secondVal
	 * @param valueStack
	 */

	private static void insertElement(String operator, double firstVal, double secondVal, Stack<Double> valueStack) {
		double value=0;
		if(operator.equals("+"))
		{
			value=firstVal+secondVal;
			
		}
		else if(operator.equals("-"))
		{
			value= secondVal-firstVal;
		}
		else if(operator.equals("*"))
		{
			value=firstVal*secondVal;
		}
		else if(operator.equals("/"))
		{
			value= secondVal/firstVal;
		}
		else if(operator.equals("%"))
		{
			value= secondVal%firstVal;
		}
		valueStack.push(value);
		
	}

	
	

}
