// Comment - Good work!

/**
 * This class represents a three-dimensional box The box is represented
 * by its lower-left-front point and three integers for the length (x axis), <br>
 * width (y axis) and height (z axis) of the box. the box dimensions must be equal or greater than 1. <br>
 * <br>
 * Version: <br>
 * 06.04.2019 <br>
 * Author: <br>
 * Tomer Dore<br>
 * ID:<br>
 * 311309165<br>
 */

public class Box3D
{
    //Instance Variables and FINALS
    private static final int MIN_VALUE=1 ,NUM_OF_SAME_FACE=2;
    private Point3D _base;
    private int _length;
    private int _width;
    private int _height;

    //Constructors
    /**
     *Constructs and initializes a box with a default base point and all dimensions to 1.
     */
    public Box3D()
    {
        _length=_width=_height=MIN_VALUE;
        _base=new Point3D();
    }//end of empty constructor 

    /**
     * 
     * Constructs and initializes a box object from a given base point and 3 integers as the dimentions of the Box
     * @param p the base point of the box
     * @param lenth the length of the box
     * @param width the width of the box
     * @param heigth the height of the box 
     */
    public Box3D(Point3D p, int length, int width, int height)
    {
        _base=new Point3D(p);
        //checking if excist invalid inputs for length,width,height.
        if(length>=MIN_VALUE) _length=length;
        else _length=MIN_VALUE;

        if(width>=MIN_VALUE) _width=width;
        else _width=MIN_VALUE;

        if(height>=MIN_VALUE) _height=height;
        else _height=MIN_VALUE;
    }//end of full constructor

    /**
     * Constructs and initializes a Box3D object from a given Box3D.
     * @param other the box to copy from. Contains the initialization of the base point and all dimentions.
     */
    public Box3D(Box3D other)
    {
        _length=other._length;
        _width=other._width;
        _height=other._height;
        _base=other.getBase();
    } //end of copy constructor

    //Methods
    /**
     * returns the length dimension
     * @return the length of the box
     */
    public int getLength()
    {
        return _length;
    } //end of getLength

    /**
     * returns the width dimension
     * @return the width of the box
     */
    public int getWidth()
    {
        return _width;
    } //end of getWidth

    /**
     * returns the height dimension
     * @return the height of the box
     */
    public int getHeight()
    {
        return _height;
    } //end of getHeight

    /**
     * returns the lower-left-front (base) Point3D of the box
     * @return the base point of the box
     */
    public Point3D getBase()
    {
        return new Point3D(_base);
    }//end of getBase

    /**
     * Sets the length of the box only if the given value is equal or greater than 1.
     * @param num the length to set
     */
    public void setLength(int num)
    {
        if(num>=MIN_VALUE) 
            _length=num;
    }//end of setLength

    /**
     * Sets the width of the box only if the given value is equal or greater than 1.
     * @param num the width to set
     */
    public void setWidth(int num)
    {
        if (num>=MIN_VALUE)
            _width = num;
    }//end of setWidth

    /**
     * Sets the height of the box only if the given value is equal or greater than 1.
     * @param num the height to set
     */
    public void setHeight(int num)
    {
        if (num>=MIN_VALUE) 
            _height=num;
    } //end of setHeight

    /**
     * Sets the base point of the box
     * @param otherBase the Point3D to set
     */
    public void setBase(Point3D otherBase)
    {
        _base.setX(otherBase.getX());
        _base.setY(otherBase.getY());
        _base.setZ(otherBase.getZ());
    }//end of setBase

    /**
     * Returns a string representation of this Box3D object. 
     */
    public String toString()
    {
        return ("The base point is "+_base+", length = "+_length+", width = "+
            _width+", height = "+_height);
    }//end of toString

    /**
     * Determines whether or not the two boxes are equal.
     * @param other a Box3D object to be compared with this Box3D
     * @return true if two boxes are equals,false otherwise.
     */
    public boolean equals(Box3D other)
    {
        return (other._height==_height && other._length==_length 
            && other._width==_width && _base.equals(other._base));    
    } //end of equals

    /**
     * Moves the box in the (x,y,z) coordinate system to (x+dx,y+dy,z+dz) without changing the box dimensions
     * @return the new box in its new location
     */
    public Box3D move(double dx, double dy, double dz)
    {
        Box3D newBox=new Box3D(this);
        newBox._base.move(dx,dy,dz);
        return newBox;
    }//end of move

    /**
     * Calculates and returns the upper-right-back point of this box
     * @return the upper-right-back point of this box
     */
    public Point3D getUpRightBackPoint()
    {
        Point3D p=new Point3D(this._base);
        p.move(-_length,_width,_height);
        return p;
    }//end of getUpRightBackPoint

    /**
     * Calculates and returns the center point of the box
     * @return the center point of the box
     */
    public Point3D getCenter()
    { 
        Point3D p = new Point3D(_base);
        p.move(-_length/2.0, _width/2.0, _height/2.0);
        return p;
    }//end of getCenter

    /**
     * Computes the distance between two boxes based on the distance of their center points.
     * @param other the other point
     * @return the distance between two Box3D objects
     */
    public double distance(Box3D other)
    {
        Point3D newCenter=new Point3D(other.getCenter());
        Point3D origCenter=new Point3D(this.getCenter());
        return origCenter.distance(newCenter);     
    } //end of distance

    /**
     * Computes the volume of the box.
     * @return volume of the Box3D object
     */
    public int getVolume()
    {
        return _height*_width*_length;
    } //end of getVolume

    /**
     * Computes the surface area of a box.
     * @return the surface area of a Box3D object
     */
    public int getSurfaceArea()
    {
        int rightFace,frontFace,bottomFace;
        rightFace=_height*_length;
        frontFace=_width*_height;
        bottomFace=_width*_length;
        return NUM_OF_SAME_FACE*rightFace+NUM_OF_SAME_FACE*frontFace+NUM_OF_SAME_FACE*bottomFace; 
    } //end of getSurfaceArea

    /**
     * Determines whether this box has a greater volume in compare to other box.
     * @param other a Box3D object whose volume will be compared with the volume of this Box3D
     */
    public boolean isLargerCapacity(Box3D other)
    {
        if(this.getVolume()>other.getVolume())
            return true;
        return false;
    }//end of isLargerCapacity

    /**
     * Determines whether this box can contain the other box.
     * @param other  a Box3D object to check if it can be contained within this box
     */
    public boolean contains(Box3D other)
    {
        if(_height>other._height && _width>other._width && _length>other._length)
            return true;
        return false;
    }//end of contains

    /**
     * Checks if this box is above the other box.
     * @param other The box to check if this box is above it
     * @return true if this box is above the other box, false otherwise.
     */
    public boolean isAbove(Box3D other)
    {   
        if (this._base.isAbove(other.getUpRightBackPoint()))
            return true;
        return false;
    } //end of distance

} //end of Methods and Box3D class