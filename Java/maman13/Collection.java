/**
 * This collection class contains A collection of boxes. 
 * 
 * @author (TOMER DORE) ID:(311309165)
 * @version (20.4.19) 
 */ 

public class Collection
{
    //Instance Variables and FINALS
    private final int EMPTY=0;
    private final int MAX_NUM_BOXES=100;
    private Box3D[] _boxes;
    int _noOfBoxes;

    //Constructors
    /**
     * This constructor initializes the class attributes so that the array is maximized.
     */
    public Collection()
    {
        _noOfBoxes=0;
        _boxes=new Box3D[MAX_NUM_BOXES];
    }//end of constructor

    //Methods
    /**
     * adds a box to the array. It accepts box attributes (base point, length, width, and height) 
     * and inserts the box into an array to the appropriate place in the order of the boxes. There may already be an arithmetic 
     * box in the same dimensions. It does not interfere. In this case, the new box must enter the array
     * before the box in those dimensions.
     * @param p  the added box base point
     * @param length length of box
     * @param width width of box
     * @param height height of box
     * @return true if there is room in the array to add a box, false otherwise.
     */
    public boolean addBox(Point3D p,int length, int width, int height)
    {
        int size=_noOfBoxes;
        // checks if the arr is full
        if (size==MAX_NUM_BOXES)
            return false;

        //if got here, the arr is not full
        Box3D myBox=new Box3D(p,length,width,height);
        int myVolume = myBox.getVolume();

        //if its empty:
        if(size==EMPTY)
        {
            insert(myBox,EMPTY);
            return true;
        }

        //checks where the new box should go
        int myPlace=0;
        for(int i=0;i<size&&myVolume>_boxes[i].getVolume();i++)
            myPlace++;

        //taking care of the inserting process
        insert(myBox,myPlace);
        return true;

        //WORKS WITHOUT THIS!
        //        //if biggest:
        //        if(myVolume>_boxes[size-1].getVolume())
        //        {
        //            insert(myBox,size);
        //            return true;
        //        }
        //        //if smallest
        //        if(myVolume<=_boxes[0].getVolume())
        //        {
        //            insert(myBox,0);
        //            return true;
        //        }
    }

    // PRIVATE METHOD!! this handles the insert of a box to the array
    private void insert(Box3D myBox, int myPlace)
    {
        int size = _noOfBoxes;
        for(int i=size-1;i>=myPlace;i--)
            _boxes[i+1]=_boxes[i];
        _boxes[myPlace]=myBox;
        _noOfBoxes++;
    }//end of insert

    /**
     * returns the box whose basic corner is the largest in the array.
     * If there are several such boxes, the first box will be returned between them.
     * @return the Box that has the highest base point, null if the arr is empty.
     */
    public Box3D mostUpperBaseCorner()
    {
        int highBoxLocation=0;
        if(_noOfBoxes==EMPTY)
            return null;
        for(int i=0;i<_noOfBoxes;i++)
            if(_boxes[i].getBase().isAbove(_boxes[highBoxLocation].getBase()))
                highBoxLocation=i;

        return new Box3D(_boxes[highBoxLocation]); // THIS IS THE NON-ALIASING WAY!
        //return _boxes[highBoxLocation];  THIS IS THE ALIASING WAY!
    }//end of mostUpperBaseCorner

    /**
     * returns the total surface area of all the boxes in the array.
     * @return the total surface area of all the boxes in the array.
     */
    // Comment - method should return double   -2 points
    //public int totalSurfaceArea()
    public double totalSurfaceArea()
    {
        int total=0;
        for(int i=0;i<_noOfBoxes;i++)
            total+=_boxes[i].getSurfaceArea();
        return total;
    }//end of totalSurfaceArea

    /**
     * Returns the largest distance between two arrays in the array (between the two main points of the boxes).
     * If the number of boxes in an array is less than 2,Will be returned 0.
     * @return the largest distance between two arrays in the array (between the two main points of the boxes).
     * If the number of boxes in an array is less than 2,Will be returned 0.
     */                              
    public double longestDistance()
    {
        double longest=0;
        if(_noOfBoxes<2)
            return longest;
        for(int i=0;i<_noOfBoxes;i++)
            for(int j=0;j<_noOfBoxes;j++)
                if((_boxes[i].distance(_boxes[j]))>=longest)
                    longest=_boxes[i].distance(_boxes[j]);
        return longest;
    }//end of longestDistance

    /**
     * accepts a box as a parameter and returns a number indicating how many
     * boxes in the array can contain the box received in the parameter.
     * @param other the given box
     * @return  the number of boxes that can contain the given box
     */
    public int  howManyContains(Box3D other)
    {
        int total=0;
        for(int i=0;i<_noOfBoxes;i++)
            if(_boxes[i].contains(other))
                total++;
        return total;
    }//end of howManyContains

    /**
     * Accepts two indexes in the array (i and j), and returns the volume of the smallest box (in volume) that
     * can contain the boxes in the array between indexes (index range includes i and j themselves).
     * This is the inclusion of each box separately, not together.
     * You can not put anything on i and j. If they do not represent - a valid array will be returned 0.
     * @param i index 1
     * @param j index 2
     * @return the volume of the smallest box as described. a valid array will be returned 0.
     */
    public int volumeOfSmallestBox(int i, int j)
    {
        //making sure i is the smaller index
        if(j<i)
        {
            int temp=i;
            i=j;
            j=temp;
        }
        //return 0 if invalid input of index's.
        if(j>=_noOfBoxes||i<EMPTY)
            return 0;

        int maxHeight=0, maxWidth=0, maxLength=0;
        // a box that can contain each of the boxes from i to j must have
        // dimensions that are bigger that the biggest dimension of all the boxes
        for(;i<=j;i++)
        {
            if(_boxes[i].getHeight()>maxHeight)
                maxHeight=_boxes[i].getHeight();

            if(_boxes[i].getWidth()>maxWidth)
                maxWidth=_boxes[i].getWidth();

            if(_boxes[i].getLength()>maxLength)
                maxLength=_boxes[i].getLength();
        }
        return (maxLength+1)*(maxHeight+1)*(maxWidth+1);
    }//end of volumeOfSmallestBox

    /**
     * Returns an array of boxes the size of the actual number of boxes in the array, containing a copy of each
     * of the boxes in the array.
     * @return Returns an array of boxes the size of the actual
     * number of boxes in the array, containing a copy of each of the boxes in the array. 
     */
    public Box3D[] getBoxes()
    {
        int size = _noOfBoxes;
        Box3D[] arr=new Box3D[size];
        for(int i=0;i<size;i++)
            arr[i]=new Box3D(_boxes[i]);
        return arr;
    } // end of getBoxes

    /**
     * Returns the number of boxes in the array.
     * @return the number of boxes in the array. 
     */
    public int getNumOfBoxes()
    {
        /* int result=0;
        for(int i=0;i<_boxes.length&&_boxes[i]!=null;i++)
        result++;
        return result;*/
        return _noOfBoxes;
    }//end of getNumOfBoxes

    /**
     * Returns a string containing the information about all the boxes in the array.
     * Information on each box will start in a new row.
     * @return Returns a string containing the information about all the boxes in the array.
     * Information on each box will start in a new row
     */
    public String toString(){ 
        String str="";
        for(int i=0;i<_noOfBoxes;i++)
        {
            str+="Box no. "+ (i+1) + ": " + _boxes[i]+"\n";
        }
        return str;
    }

} //end of Methods and class Collection