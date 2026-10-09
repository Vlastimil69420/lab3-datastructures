/**
 * Lab3 - StackTest
 * Tests the reference-based implementation of the ADT Stack.
 * Exercises push, pop and peek, using displayStack() to print
 * the stack after each change, and tests isBalanced() which uses
 * a stack to check that the braces {} in a String are balanced.
 *
 * @author Vlastimil Finger (B00176858)
 */

public class StackTest
{
  public static void main(String[] args)
  {
    StackReferenceBased stack = new StackReferenceBased();
    // test displayStack on an empty stack
    stack.displayStack();
    // test push, the last item pushed is the top
    stack.push("Apple");
    stack.push("Banana");
    stack.push("Cherry");
    stack.displayStack();
    // test pop, removes the top
    System.out.println("pop: " + stack.pop());      // Cherry
    stack.displayStack();
    // test peek, the stack is unchanged
    System.out.println("peek: " + stack.peek());    // Banana
    stack.displayStack();
    // test isBalanced
    System.out.println("{a{b}c}: " + isBalanced("{a{b}c}"));   // true
    System.out.println("{a{b}c: " + isBalanced("{a{b}c"));     // false
    System.out.println("}{: " + isBalanced("}{"));             // false
  }

  /**
   * Returns true if every { in s has a matching } and they are
   * properly nested. Uses its own stack so the caller's stack
   * is never touched.
   */
  
  public static boolean isBalanced(String s)
  {
    StackReferenceBased braces = new StackReferenceBased();
    for (int i = 0; i < s.length(); i++)
    {
      char c = s.charAt(i);
      if (c == '{')
      {
        braces.push(c);
      }
      else if (c == '}')
      {
        if (braces.isEmpty())
        {
          return false;                // } with no { to match
        }
        braces.pop();
      }
    }
    return braces.isEmpty();           // false if any { is left over
  }
}
