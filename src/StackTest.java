import java.util.Scanner;

/**
 * Lab3 - StackTest
 * Menu-driven test of the reference-based implementation of the ADT Stack.
 * The user can push, pop, peek, empty the stack and check a string for
 * balanced braces {} using isBalanced(). displayStack() is called after
 * every selection so the contents of the stack can be visually confirmed.
 *
 * @author Vlastimil Finger (B00176858)
 */

public class StackTest
{
  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);
    StackReferenceBased stack = new StackReferenceBased();
    boolean quit = false;
    while (!quit)
    {
      displayMenu();
      String choice = in.nextLine().trim();
      switch (choice)
      {
        case "1":
          System.out.print("Enter a string to push: ");
          stack.push(in.nextLine());
          break;
        case "2":
          try
          {
            System.out.println("Popped: " + stack.pop());
          }
          catch (StackException e)
          {
            System.out.println(e.getMessage());
          }
          break;
        case "3":
          try
          {
            System.out.println("Top of the stack: " + stack.peek());
          }
          catch (StackException e)
          {
            System.out.println(e.getMessage());
          }
          break;
        case "4":
          stack.popAll();
          break;
        case "5":
          System.out.print("Enter a string to check: ");
          String text = in.nextLine();
          System.out.println("Balanced: " + isBalanced(text));
          break;
        case "6":
          quit = true;
          break;
        default:
          System.out.println("Invalid selection, please enter 1-6.");
      }
      if (!quit)
      {
        stack.displayStack();
      }
    }
    in.close();
  }

  /**
   * Prints the menu shown to the user before every selection.
   */
  
  public static void displayMenu()
  {
    System.out.println();
    System.out.println("Welcome to StackTest! Please select a number from the list.");
    System.out.println("1. Push a string on to the stack");
    System.out.println("2. Pop a string from the stack");
    System.out.println("3. Peek at the top of the stack");
    System.out.println("4. Empty the stack");
    System.out.println("5. Check if a string has balanced brackets.");
    System.out.println("6. Quit the program");
  }

  /**
   * Returns true if every { in s has a matching } and they are
   * properly nested. Uses its own stack so the stack the user is
   * working with in the menu is never touched.
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
