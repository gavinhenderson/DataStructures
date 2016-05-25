import java.lang.NumberFormatException;

/**
 * Uses reverse polish notation calculation to accept an equation and produce an answer
 * 
 * @author Gavin Hederson
 * @version 1.0
 */
public class RPNCalc
{
    Stack numberStack;
    /**
     * Constructor for objects of class RPNCalc
     */
    public RPNCalc()
    {
        numberStack = new Stack();
    }
    
    /**
     * Runs the calculator
     * 
     * IMPROVEMENTS
     * -Needs expression validation
     */
    public void runCalc()
    {
        //Get the user to enter the expression sperating using commas and no spaces
        System.out.println("Please enter you expression using commas to seperate numbers and using no spaces");
        String expression = Genio.getString();
        
        //Split the expression variable into a list
        expression = expression.replaceAll("\\s+","");
        String[] expressionList = expression.split(",");
        
        //loop through the expressionList
        for (int i=0;i<expressionList.length;i++)
        {
            try
            {
                double currentNumber = Double.parseDouble(expressionList[i]);
                numberStack.push(currentNumber);
            }
            catch(NumberFormatException e)
            {
                double number1 = numberStack.pop();
                double number2 = numberStack.pop();
                
                if(expressionList[i].equals("+"))
                {
                    numberStack.push((number1+number2));
                }
                else if(expressionList[i].equals("-"))
                {
                    numberStack.push((number2-number1));
                }
                else if(expressionList[i].equals("*"))
                {
                    numberStack.push((number1*number2));
                }
                else if(expressionList[i].equals("/"))
                {
                    numberStack.push((number2/number1));
                }
            }
        }
        
        System.out.println("The answer is: "+numberStack.pop());
    }
}
