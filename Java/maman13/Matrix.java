// Comment -Good work!

/**
 * This class represents a two-dimensional image in black and white,when the numbers 
 * representing the grayscale in the image (0 is white and 225 is black).
 * 
 * @author (TOMER DORE) ID:(311309165)
 * @version (20.4.19)  
 */

public class Matrix
{
    //Instance Variables and FINALS
    private final int REG_AVE=8, WALL_AVE=5, CORNER_AVE=3;
    private final int MIN_VALUE=0, MAX_VALUE=255;
    private int _array[][];

    //Constructors
    /**
     * Constructs a Matrix from a two-dimensional array; the dimensions as well 
     * as the values of this Matrix will be the same as the dimensions and values
     * of the two-dimensional array.
     * @param arr the arr to copy to the Matrix
     */
    public Matrix(int[][] arr)
    {
        _array = new int[arr.length][arr[0].length];
        for(int i=0;i<_array.length;i++)
            for(int j=0;j<_array[0].length;j++)
                _array[i][j]=arr[i][j];
    }

    /**
     * constructs a size 1 by size 2 Matrix of zeroes.
     * @param size1 number of lines .
     * @param size2 number of columms.
     */
    public Matrix(int size1, int size2)
    {
        _array = new int[size1][size2];
        for(int i=0;i<size1;i++)
            for(int j=0;j<size2;j++)
                _array[i][j]=MIN_VALUE;
    }//end of constructor

    //Methods
    /**
     * Returns a representation of the Matrix
     * @return a String describing the Matrix
     */
    public String toString()
    {
        String result = "";
        for(int i=0;i<_array.length;i++)
        {
            for(int j=0;j<_array[0].length;j++)
            {
                result += _array[i][j];
                if(j!=_array[0].length-1)
                    result += "\t";
            }
            result += "\n";
        }
        return result;
    }//end of String toString 

    /**
     * Creates a new Matrix wich is the Negative of the Matrix 
     * @return the Negative Matrix
     */
    public Matrix makeNegative()
    {
        int[][] negArr = new int[_array.length][_array[0].length];
        for(int i=0;i<_array.length;i++)
            for(int j=0;j<_array[0].length;j++)
                negArr[i][j]=MAX_VALUE-_array[i][j];
        Matrix negMatrix = new Matrix(negArr);
        return negMatrix;
    }//end of makeNegative 

    /**
     * creates a new Matrix that is a filtered Matrix of the Matrix that uses this. (filter - average of  all the neighbors of the pixel)
     * @return the Filtered Matrix
     */
    public Matrix imageFilterAverage()
    {
        int[][] filteredArr = new int[_array.length][_array[0].length];
        Matrix filteredMatrix;
        for(int i=0;i<_array.length;i++)
        {
            for(int j=0;j<_array[0].length;j++)
            {
                int sum=0;
                int count=0;
                //  this loops check all the neighbors for existance and sums up 
                //  the ones they do. and of course, count the neighbors.
                for(int s=i-1;s<=i+1;s++) // from i-1 to i+1
                    for(int t=j-1;t<=j+1;t++) // from j-1 to j+1
                        if(isThere(s,t))  // checks if the neighbor exists.
                        {
                            sum+= _array[s][t];
                            count++;
                        }
                filteredArr[i][j]=sum/count;
            }
        }
        filteredMatrix = new Matrix(filteredArr);
        return filteredMatrix;
    }//end of imageFilterAverage

    // CHECKS IF WE CAN ADRESS TO A COORDINATE IN THE ARRAY!
    private boolean isThere(int i, int j)
    {
        return i>=0&&i<_array.length&&j<_array[0].length&&j>=0;
    }

    /**
     * creates a new Matrix that is the rotated Matrix that uses this clockwised.
     * @return the clockwised rotated Matrix 
     */
    public Matrix rotateClockwise()
    {
        int[][] rotatedArr=new int[_array[0].length][_array.length];
        for(int i=0;i<rotatedArr.length;i++)// passing over all the lines of rotatedArr
            for(int j=0;j<rotatedArr[0].length;j++)// passing over all the places in line i.
            // clockwise turn.
                rotatedArr[i][j]=_array[_array.length-1-j][i];
        return new Matrix(rotatedArr);
    }//end of rotateClockwise

    /**
     * creates a new Matrix that is the rotated Matrix that uses this, counterClockwised.
     * @return the counterClockwised rotated Matrix 
     */
    public Matrix rotateCounterClockwise()
    {
        int[][] rotatedArr=new int[_array[0].length][_array.length];
        for(int i=0;i<rotatedArr.length;i++)  //passing over all the lines of rotatedArr
            for(int j=0;j<rotatedArr[0].length;j++)  //passing over all the places in line i.
            // CounterClockwise turn.
                rotatedArr[i][j]=_array[j][_array[0].length-1-i];
        return new Matrix(rotatedArr);
    }//end of rotateCounterClockwise

}//end of methods and class Matrix