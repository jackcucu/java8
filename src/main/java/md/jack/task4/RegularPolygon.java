package md.jack.task4;


public interface RegularPolygon {

    public abstract int getNumSides();

    public abstract double getSideLength();

    static  int totalSides(RegularPolygon[] regularPolygons)
    {
     int sum = 0;
        for (RegularPolygon polygon:regularPolygons
             ) {
            sum += polygon.getNumSides();
        }
        return sum;
    }

    default double getPerimeter()
    {
     return (getNumSides() * getSideLength());
    }

    default double getInteriorAngle()
    {
     return ((getNumSides()-2) * Math.PI / getNumSides());
    }

}
