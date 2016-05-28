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
        boolean run = true;
        
        System.out.println('\u000c');
        while(run)
        {
            System.out.println("1: Run");
            System.out.println("0: Exit");
            
            int choice = 0;
            boolean valid = false;
            while(!valid)
            {
                System.out.print("What would you like to do: ");
                choice = Genio.getInteger();
                
                if((choice>=0)&&(choice<=1))
                {
                    valid = true;
                }
                else
                {
                    System.out.print('\u000c');
                    System.out.println("You did not enter a valid choice");
                }
            }
            
            switch(choice)
            {
                case(1):
                    runCalc();
                    break;
                case(0):
                    run = false;
                    break;
                }
        }
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
        boolean valid = false;
        String expression="";
        System.out.print('\u000c');
        while(!valid)
        {
            System.out.println("Please enter you expression using commas to seperate numbers and using no spaces");
            expression = Genio.getString();
            
            if(checkExpressionValid(expression))
            {
                valid = true;
            }
            else
            {
                System.out.println("You entered an invalid expression");
            }
        }
            
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
        
        System.out.println("The answer is: "+(String.format("%.2f", numberStack.pop())));
    }
    
    /**
     * Check if the expression that is passed is valid
     * 
     * @return Boolean - true if its valid
     * @params String - the expression
     */
    public boolean checkExpressionValid(String expression)
    {
        Stack tempStack = new Stack();
        boolean valid = true;
        String[] expressionList = expression.split(",");
        int numberCounter = 0;
        int operatorCounter = 0;
        
        for (int i=0;i<expressionList.length;i++)
        {
            try
            {
                double currentNumber = Double.parseDouble(expressionList[i]);
                numberCounter++;
                tempStack.push(currentNumber);
            }
            catch(NumberFormatException e)
            {
                if((expressionList[i].equals("+"))||(expressionList[i].equals("-"))||(expressionList[i].equals("/"))||(expressionList[i].equals("*")))
                {
                    operatorCounter++;
                    double number1 = 0;
                    double number2 = 0;
                    
                    if(tempStack.isPopPossible())
                    {
                        number1 = tempStack.pop();
                    }
                    else
                    {
                        return false;
                    }
                    
                    if(tempStack.isPopPossible())
                    {
                        number2 = tempStack.pop();
                    }
                    else
                    {
                        return false;
                    }
                    
                    if(expressionList[i].equals("+"))
                    {
                        tempStack.push((number1+number2));
                    }
                    else if(expressionList[i].equals("-"))
                    {
                        tempStack.push((number2-number1));
                    }
                    else if(expressionList[i].equals("*"))
                    {
                        tempStack.push((number1*number2));
                    }
                    else if(expressionList[i].equals("/"))
                    {
                        tempStack.push((number2/number1));
                    }
                }
                else
                {
                    valid = false;
                }
            }
            catch(NullPointerException e)
            {
                valid = false;
            }
        }
        
        if(operatorCounter<1)
        {
            valid = false;
        }
        if(numberCounter<2)
        {
            valid = false;
        }
        if((numberCounter-operatorCounter)!=1)
        {
            valid = false;
        }
        
        return valid;
    }
}
