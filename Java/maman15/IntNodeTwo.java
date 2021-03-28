/**
 * The next class represents an organ in a two-way 
 * cross-reference list containing integers.
 *
 * @author (Tomer Dore)
 * @version (311309165)
 */
public class IntNodeTwo
{     
    private int _num;
    private IntNodeTwo _next, _prev; 

    /**
     * This Constructor initializes the head and
     * tail in the node to null and the number value to user choice.
     * 
     * @param int num.
     */
    public IntNodeTwo(int n)
    { 
        _num = n;
        _next = null; 
        _prev = null;
    } 

    /**
     * This Constructor initializes the num ,the next
     * and previous of the node.
     * 
     * @param int num.
     * @param IntNodeTwo next.
     * @param IntNodeTwo previous.
     */
    public IntNodeTwo(int num, IntNodeTwo n, IntNodeTwo p)
    { 
        _num = num;
        _next = n;
        _prev = p; 
    }         

    /**
     * get the number value in current node.
     */
    public int getNum()  
    {
        return _num;
    }     

    /**
     * get the next node after current node.
     */
    public IntNodeTwo getNext()
    {
        return _next;
    }     

    /**
     * get the previous node to current node.
     */
    public IntNodeTwo getPrev() 
    {
        return _prev;
    }       

    /**
     * set the number value in node.
     * 
     * @param int n.
     */
    public void setNum (int n) 
    {
        _num = n; 
    }     

    /**
     * set the next node to the current node.
     * 
     * @param IntNodeTwo node.
     */
    public void setNext (IntNodeTwo node) 
    {
        _next = node;
    }     

    /**
     * set the previous node to the current node.
     * 
     * @param IntNodeTwo node.
     */
    public void setPrev (IntNodeTwo node) 
    { 
        _prev = node;
    }
}//end of class