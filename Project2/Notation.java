/**
 * @author- Mahliet Admasu
 */
public class Notation 
{

   /**
   * Convert an infix expression into a postfix expression
   * @param infix The infix expression in string format
   * @return The postfix expression in a string format
   * @throws InvalidNotationFormatException If the infix expression format is invalid
   */
   public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException 
   {

       MyQueue<Character> queue = new MyQueue<>(infix.length());
       MyStack<Character> stack = new MyStack<>(infix.length());
       char[] str = infix.toCharArray();

       try 
       {
           for (Character nextChar : str) 
           {
               if (nextChar == ' ') 
               {
                   continue;
               }
               if (Character.isDigit(nextChar)) 
               {
                   queue.enqueue(nextChar);
                   continue;
               }
               if (nextChar == '(')
               {
                   stack.push(nextChar);
               }
               if (nextChar == '*' || nextChar == '/' || nextChar == '+' || nextChar == '-'|| nextChar=='%')
               {
                   if (!queue.isEmpty()) 
                   {
                       char topOperator = stack.top();
                       if (topOperator == '*' || topOperator == '/' || nextChar == '-' && topOperator == '-' || nextChar == '-' && topOperator == '+'
                               || nextChar == '+' && topOperator == '-' || nextChar == '+' && topOperator == '+') 
                       {
                           queue.enqueue(stack.pop());

                       }
                   }
                   stack.push(nextChar);
                   continue;
               }
               if (nextChar == ')')
               {
                   while (!stack.isEmpty()&& stack.top() != '(') 
                   {
                       queue.enqueue(stack.pop());
                       if (!stack.isEmpty()&&stack.top()!='(') 
                       {
                           throw new InvalidNotationFormatException();
                       }
                   }
                   stack.pop();
               }

           }
       } 
       catch (QueueOverflowException | StackOverflowException | StackUnderflowException ignore) 
       {
           throw new InvalidNotationFormatException();
       }
       return queue.toString();

   }
   /**
   * Converts the postfix expression to the infix expression
   * @param postfix The postfix expression in string format
   * @return The infix expression in string format
   * @throws InvalidNotationFormatException If the postfix expression format is invalid
   */
   public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException 
   {

       MyStack<String> stack = new MyStack<>(postfix.length());

       try 
       {
           for (int i = 0; i < postfix.length(); i++) 
           {
               char current = postfix.charAt(i);

               if (current == ' ') 
               {
                   continue;
               }
               if (Character.isDigit(current))
               {
                   stack.push(Character.toString(current));
                   continue;
               }
               if (current == '*' || current == '/' || current == '+' || current == '-')
               {
                   if (stack.size() < 2)
                   {
                       throw new InvalidNotationFormatException();
                   }
                   String first = stack.pop();
                   String second = stack.pop();
                   String s = "(" + second + current + first + ")";
                   stack.push(s);

               }
           }

       } 
       catch (StackUnderflowException | StackOverflowException ignore)
       {
           throw new InvalidNotationFormatException();
       }
       if (stack.size() > 1)
       {
           throw new InvalidNotationFormatException();
       }
       return stack.toString();
   }
/**
* Evaluates a postfix expression from a string to a double
* @param postfixExpr The postfix expression in String format
* @return The evaluation of the postfix expression as a double
* @throws InvalidNotationFormatException If the postfix expression format is invalid
*/
   public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException 
   {

       MyStack<Double> stack = new MyStack<>(postfixExpr.length());
       char[] str = postfixExpr.toCharArray();

       try 
       {
           for (char current : str) 
           {
               if (current == ' ') 
               {
                   continue;
               }
               if (Character.isDigit(current) || current == '(') 
               {
                   stack.push(Double.parseDouble(Character.toString(current)));
                   continue;
               }
               if (current == '*' || current == '/' || current == '+' || current == '-')
               {
                   if (stack.size() < 2)
                   {
                       throw new InvalidNotationFormatException();
                   }
                   double right = stack.pop();
                   double left = stack.pop();

                   switch (current) 
                   {
                   case '*':
                       stack.push(left * right);
                       break;
                   case '/':
                       stack.push(left / right);
                       break;
                   case '+':
                       stack.push(left + right);
                       break;
                   case '-':
                       stack.push(left - right);
                   }

               }

           }

       } catch (StackOverflowException | StackUnderflowException ignore) {
           throw new InvalidNotationFormatException();
       }

       if (stack.size() > 1) 
       {
           throw new InvalidNotationFormatException();
       }

       return Double.parseDouble(stack.toString());

   }
   /**
   * Evaluates a infix expression from a String to double
   * @param infixExpr The infix expression in String format
   * @return  infix method as a double
   * @throws InvalidNotationFormatException If the infix expression format is invalid
   */
   public static double evaluateInfixExpression(String infixExpr) throws InvalidNotationFormatException 
   {
       return evaluatePostfixExpression(convertInfixToPostfix(infixExpr));
   }

}

