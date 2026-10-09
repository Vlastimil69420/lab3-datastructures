/**
 * Lab3 - StackReferenceBased
 * Reference-based (linked) implementation of the ADT Stack.
 * displayStack() was added to print the stack vertically,
 * marking the top, so the contents can be visually confirmed.
 *
 * @author Vlastimil Finger (B00176858)
 */

public class StackReferenceBased implements StackInterface
{
  private Node top;

  public StackReferenceBased()
  {
    top = null;
  }  // end default constructor
  //============================================================================
  //============================================================================
  //============================================================================

  public boolean isEmpty()
  {
    return top ==  null;
  }  // end isEmpty
//============================================================================
//============================================================================
//============================================================================

  public void push(Object newItem)
  {
    top = new Node(newItem, top);
  }  // end push
  //============================================================================
  //============================================================================
  //============================================================================

  public Object pop() throws StackException
  {
    if (!isEmpty())
    {
      Node temp = top;
      top = top.getNext();
      return temp.getItem();
    }
    else
    {
      throw new StackException("StackException on " + "pop: stack empty");
    }  // end if
  }  // end pop
  //============================================================================
  //============================================================================
  //============================================================================

  public void popAll()
  {
    top = null;
  }  // end popAll

//============================================================================
//============================================================================
//============================================================================
  public Object peek() throws StackException
  {
    if (!isEmpty())
    {
      return top.getItem();
    }
    else
    {
      throw new StackException("StackException on " + "peek: stack empty");
    }  // end if

  } // end peek
//============================================================================
//============================================================================
//============================================================================

  /**
   * Prints the stack vertically, top item first, and marks the top.
   * The nodes are only read, so the stack is left unchanged.
   */
  public void displayStack()
  {
    System.out.println("Stack:");
    if (isEmpty())
    {
      System.out.println("  (empty)");
    }
    else
    {
      Node current = top;
      while (current != null)
      {
        System.out.print("  " + current.getItem());
        if (current == top)
        {
          System.out.print("   <-- top");
        }
        System.out.println();
        current = current.getNext();
      } // end while
    } // end if
  }  // end displayStack
//============================================================================
//============================================================================
//============================================================================

}  // end StackReferenceBased}  // end StackReferenceBased