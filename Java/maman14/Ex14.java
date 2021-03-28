/**
 * Maman 14
 * @author Tomer Dore 311309165
 * @version 01/06/2019
 */
public class Ex14
{
    final static int DEFAULT=0;
    final static int ONE=1;
    /**
     * QUESTION NUMBER 1
     * Calculates the volume of the rain water that trapped between the towers.
     * @param heights The array that represents the height of the pillers.
     */
    // Time complexity O(n) memory complexity O(1)
    public static int waterVolume (int[] heights){
        int sum=DEFAULT;// The total volume of the rain water.
        int I=DEFAULT;// The index of the tallest tower.
        int tempHeight=heights[DEFAULT];//a veriable that contains the height of the reference tower for calculation of the volume(starting from the first tower).
        // Locating the highest tower.
        for(int i=DEFAULT;i<heights.length;i++){
            if(heights[i]>heights[I])
                I=i;	
        }
        // Calculating the volume from the left tower to the highest.
        for(int i=DEFAULT;i<I;i++){
            if(heights[i+ONE]<tempHeight){
                sum+=tempHeight-heights[i+ONE];
            }
            else{
                tempHeight=heights[i+ONE];
            }
        }

        tempHeight=heights[heights.length-ONE];
        // Calculating the volume from the right tower to the highest.
        for(int i=heights.length-ONE;i>I;i--){
            if(heights[i-ONE]<tempHeight){
                sum+=tempHeight-heights[i-ONE];
            }
            else{
                tempHeight=heights[i-ONE];
            }
        }
        return sum;
    }

    /**
     * QUESTION NUMBER 2 
     * A - This program returns the biggest number of organs in the array that their sum(in a row) is an even number. 
     * B -
     * Time complexity : O(n^3)
     * Space complexity : O(1)
     * C - is below.
     * D - 
     * Time complexity : O(n) because we have two separate for loops. 
     * Space complexity : O(1) because we use a specific array and do not copy it, or crate more 
     * during the code.
     *
     *@param a Is the numbers array where we neet to find the biggest number of organs in the array that their sum(in a row) is an even number.
     *@return The biggest number of organs in the array that their sum(in a row) is an even number.
     */
    public static int what(int []a) {
        int sum = DEFAULT ; // This is the sum of the array numbers. 
        int temp=DEFAULT; // This is the biggest number of organs that their sum is even. 
        // Adding all the numbers in the array one by one and checking each time if their sum is even.
        for (int i = DEFAULT; i < a.length ; i++){
            sum += a[i];
            if (sum%2==DEFAULT){
                if(i+ONE>temp){
                    temp=i+ONE;
                }
            }
        }
        // Subtraction all the numbers in the array one by one and checking each time if their sum is even.
        for (int i = DEFAULT; i < a.length ; i++){
            sum -= a[i];
            if (sum%2==DEFAULT){
                if(a.length-i-ONE>temp){
                    temp=a.length-i-ONE;
                }
            }
        }   
        return temp;
    }

    /**
     * QUESTION NUMBER 3
     * Finds the number of solutions to the equation x1+x2+x3=num where x1-x3 are netural numbers 1-10 and prints the different solutions.
     * @param num The result of x1+x2+x3
     * @return The number of solutions to the equation x1+x2+x3=num.
     */    
    // Comment- your method doesn't work ok for the following case   -2 points
    // Checking method 'solutions' with number 13
    // Error!!! Expected result => 63 student's result => 66

    public static int solutions (int num){
        if(num<3)
            return DEFAULT;
        if(num>30)
            return DEFAULT;
        return solutions(num,ONE,ONE);
    }

    /**
     * Finds the number of solutions to the equation x1+x2+x3=num where x1-x3 are netural numbers 1-10 and prints the different solutions.
     * @param num the result of x1+x2+x3.
     * @param x1 The first number in the equation x1+x2+x3=num.
     * @param x2 The second number in the equation x1+x2+x3=num.
     * @return The number of solutions to the equation x1+x2+x3=num.
     */
    private static int solutions (int num,int x1,int x2){
        int sum=DEFAULT;// The number of solutions to the equation x1+x2+x3=num.
        if(x1<num-1){
            System.out.println(x1+"+"+x2+"+"+(num-x1-x2));
            if(x2>=num-x1-ONE){
                sum += ONE+solutions(num,x1+ONE,ONE);
            }
            else{
                sum += ONE+solutions(num,x1,x2+ONE);
            }			
        }	
        return sum;
    }

    /**
     * QUESTION NUMBER 4
     * Find the path of numbers in the matrix that thier sum is the given sum and returns true if the path is found and false otherwise.
     * Further more the method show the path by adding '1' in another metrix.
     * @param mat The given matrix to find the path in.
     * @param sum The given sum of numbers.
     * @param path The matrix that "shows" the path.
     * @return True if the path is found, false otherwise.
     */
    public static boolean findSum (int[][] mat, int sum, int[][] path){
        if(mat.length>DEFAULT && mat[DEFAULT].length>DEFAULT)
            return scanArray(mat, sum ,path,DEFAULT,DEFAULT);
        return false;
    }

    /**
     * Finds the path starting from a given point in the array and returns if the path was found.
     * @param mat The given matrix to find the path in.
     * @param sum The given sum of numbers.
     * @param path The matrix that "shows" the path.
     * @param currentSum The calculated sum up until a certain point.
     * @param i The row index of the array where we start searching for the path. 
     * @param j The column index of the array where we start searching for the path. 
     * @return True if the path is found, false otherwise.
     */
    private static boolean findSum (int[][] mat, int sum,int[][] path,int currentSum,int i,int j){
        if(i<mat.length && j< mat[i].length){
            path[i][j]=ONE;
            currentSum += mat[i][j];
            if(currentSum==sum){
                path[i][j]=ONE;
                return true;
            }
            if(currentSum<sum){	
                if(i+ONE<mat.length && path[i+1][j]==DEFAULT)
                    if(findSum(mat,sum,path,currentSum,i+ONE,j)){
                        return true;
                    }

                if(j+ONE<mat[i].length && path[i][j+ONE]==DEFAULT)
                    if(findSum(mat,sum,path,currentSum,i,j+ONE)){
                        return true;
                    }

                if(i-ONE>=DEFAULT && path[i-ONE][j]==DEFAULT)
                    if(findSum(mat,sum,path,currentSum,i-ONE,j)){
                        return true;
                    }

                if(j-ONE>=DEFAULT && path[i][j-ONE]==DEFAULT)
                    if(findSum(mat,sum,path,currentSum,i,j-ONE)){
                        return true;
                    }
            }
            else{
                path[i][j]=DEFAULT;
                return false;
            }
            path[i][j]=DEFAULT;
        }
        return false;
    }

    /**
     * Scans the matrix and calling for findSum() for every cell in the array and returns if the path was found.
     * @param mat The given matrix to find the path in.
     * @param sum The given sum of numbers.
     * @param path The matrix that "shows" the path.
     * @param i The current row index in the array.
     * @param j The current column index in the array.
     * @return True if the path is found, false otherwise.
     */
    private static boolean scanArray(int[][] mat,int sum, int[][] path, int i, int j){
        boolean found=findSum(mat,sum,path,DEFAULT,i,j);
        if(i<mat.length && !found)
        {
            if(j==mat[i].length){
                found = found || scanArray(mat,sum,path,i+ONE,DEFAULT);
            }
            else{
                found = found || scanArray(mat,sum,path,i,j+ONE);
            }
        }
        return found;	
    }

}