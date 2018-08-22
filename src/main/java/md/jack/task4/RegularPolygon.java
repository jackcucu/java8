package md.jack.task4;

public interface RegularPolygon
{
    static int totalSides(RegularPolygon[] polygons)
    {
        int sum = 0;
        for (RegularPolygon polygon : polygons)
        {
            sum += polygon.getNumSides();
        }
        return (sum);
    }

    int getNumSides();

    double getSideLength();

    /** Calculates the interior angle in radians based on the number of sides. */

    default double getInteriorAngle()
    {
        int n = getNumSides();
        return ((n - 2) * Math.PI / n);
    }

    /** Calculates the perimeter based on the number of sides and the side length. */

    default double getPerimeter()
    {
        return (getNumSides() * getSideLength());
    }
}
