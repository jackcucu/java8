package md.jack.task4;


import java.util.stream.Stream;

public interface RegularPolygon {

    static  int totalSides(RegularPolygon[] regularPolygons)
    {
        return Stream.of(regularPolygons)
                .mapToInt(RegularPolygon::getNumSides)
                .sum();
    }

    int getNumSides();

    double getSideLength();
    default double getPerimeter()
    {
     return (getNumSides() * getSideLength());
    }

    default double getInteriorAngle()
    {
     return ((getNumSides()-2) * Math.PI / getNumSides());
    }

}
