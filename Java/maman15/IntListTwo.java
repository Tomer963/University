/**
 * The class implements a cross-sectional list, 
 * each of which is an object from the IntNodeTwo class.<br>
 * the list is sorted.
 *
 * @author (Tomer Dore)
 * @version (311309165)
 */
import java.util.Scanner;
public class IntListTwo
{
    private IntNodeTwo _head, _tail;
    Scanner scan = new Scanner(System.in);

    //Constructors

    /**
     * This Constructor initializes the head and
     * tail in the list to null.
     */
    public IntListTwo()  
    {
        _head = null;
        _tail = null;
    }

    /**
     * This Constructor initializes the head and
     * tail of the list.
     */
    public IntListTwo(IntNodeTwo h, IntNodeTwo t)
    {
        _head = h;
        _tail = t;
    }

    //Methods

    /**
     * Time complexity O(n) ,memory complexity O(1).<br>
     * A method that accepts as an integer (num) parameter and adds
     * it to the list to the appropriate place in order.
     * @param int num
     */
    public void addNumber(int num)
    {
        IntNodeTwo temp= new IntNodeTwo(num);
        if (_head==null)//if list empty the node is the head of the list.
        {
            _head=temp;
            _tail=_head;
        }
        else if (temp.getNum() < _head.getNum())//set the node to be first on list if the head of the list 
        {                                      //is bigger(The linked list is sorted).
            temp.setNext(_head);
            _head=temp;
        }
        else 
        {
            IntNodeTwo current =_head;
            while (current.getNext()!= null && current.getNext().getNum() < temp.getNum())
                current = current.getNext(); // found the correct place the node should be in this sorted linked list.

            if(current.getNext()!= null)
            {
                temp.setNext(current.getNext());
                temp.setPrev(current);
            }
            current.setNext(temp);
        }
        
        temp =_head;//set the last node in list to be the tail.
        if (temp.getNext()!= null)
        {
            while (temp.getNext().getNext()!= null)
            {
                temp=temp.getNext();
            }
            _tail=temp.getNext();
            _tail.setPrev(temp);
        }

    }

    /**
     * Time complexity O(n) ,memory complexity O(1).<br>
     * A method that accepts as an integer parameter num and removes it from the list(if exists).
     * @param int num
     */
    // Comment - Exception in the removeNumber method when the list is {}, num =3
    //java.lang.NullPointerException    -5 points
    public void removeNumber(int num)
    {
        IntNodeTwo temp =_head;
        if(_head.getNum() == num)//if the number that sould be removed is the head, then the following node
                              //becomes the head.
        {
                _head=_head.getNext();
        } 
          
        while(temp.getNext() != null)
                {
                    if (temp.getNext().getNum()==num)//finds the number in the list if it exists and removes it.
                    {
                        temp.setNext(temp.getNext().getNext());
                        return;                                   
                    }
                    else
                        temp = temp.getNext();//move to next 
                }
    }//if the number is not found in list nothing will be done.

    /**
     * Time complexity O(n^2) ,memory complexity O(1).<br>
     * A method that reads a list of integers from the input 
     * and inserts them into the list. -9999 to quit!
     */
    public void readToList()
    {
        int userNum = scan.nextInt();;
        while (userNum != -9999)
        {
            this.addNumber(userNum);
            userNum = scan.nextInt();
        }
    }

    /**
     * Time complexity O(n) ,memory complexity O(n).<br>
     * return the string of the list.
     * @return the string of the list.
     */
    public String toString()
    {
        
        if (_head==null)
        {
            return "{}";
        }
        
        String retS = "" + _head.getNum();
        IntNodeTwo temp = _head.getNext();
        while (temp != null)
        {
            retS+= ","+temp.getNum();
            temp = temp.getNext();
        }
        return "{"+retS+"}";
    }

    /**
     * Time complexity O(n) ,memory complexity O(1).<br>
     * A method that returns the number of items in the list.
     * @return the number of items in the list.
     */
    public int length()
    {
        IntNodeTwo temp= _head;
        int count =0;
        while(temp !=null)
        {
            count++;
            temp=temp.getNext();
        }
        return count;
    }

    /**
     * Time complexity O(n) ,memory complexity O(1).<br>
     * A method that returns the sum of the organs in the list.
     * @return the sum of the organs in the list.
     */
    public int sum()
    {
        IntNodeTwo temp= _head;
        int sum =0;
        while(temp !=null)
        {
            sum=sum+temp.getNum();
            temp=temp.getNext();
        }
        return sum;
    }

    /**
     * Time complexity O(n) ,memory complexity O(1).<br>
     * Function to find length of the longest subarray such 
     * that sum of the subarray is even.
     * @return the maxLength the longest subarray such 
     * that sum of the subarray is even.
     */
    public int maxLength()
    {
        IntNodeTwo temp= _head;
        int sum = 0, maxLength = 0,length=0, otherCount= 0;  
        length=this.length();

        if (this.sum() % 2 == 0)//check if the sum of all organs in list even.
        {
            return length;
        }
        else /*Search for an odd number in the list and check the sub-list if it is longer: 
        one on the right or one on the left of the odd number node. 
        this happens for every odd number in the list*/
        {
            temp=_head;
            while(temp!=null)
            {
                otherCount++;
                if(temp.getNum() % 2 == 1)
                    maxLength = Math.max(maxLength,Math.max(length - otherCount , otherCount-1));
                temp=temp.getNext();
            }
        }
        return maxLength;
    }

    /**
     * Time complexity O(n) ,memory complexity O(1).<br>
     * A method that accepts as an actual number parameter and returns
     * if there is a sub-list whose average is num.
     * @param double num
     * @return true if exists, false otherwise.
     */
    public boolean isAverage(double num) 
    {
        if (_head == null)
            return false;
            
        int count = this.length();
        int sum = this.sum();
        double average = sum / (double) count;
        IntNodeTwo tempH = _head;
        IntNodeTwo tempT = _tail;
        
        while (tempH != null && tempT != null) 
        {
            if (average == num)
                return true;
            
            if(average < num)
            {
                sum = sum - tempH.getNum();
                count-= 1;
                tempH = tempH.getNext();
                average = sum / (double) count;
            }
            
            if(average > num)
            {
                sum = sum - tempT.getNum();
                count -= 1;
                tempT = tempT.getPrev();
                average = sum / (double) count;
            }

        }
        return false;
    }
}//end of class