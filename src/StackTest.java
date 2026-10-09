/**
 * Lab3 - StackTest
 * Tests the reference-based implementation of the ADT Stack.
 * Exercises push, pop and peek, using displayStack() to print
 * the stack after each change so the ADT operations can be
 * visually confirmed.
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
  }
}
