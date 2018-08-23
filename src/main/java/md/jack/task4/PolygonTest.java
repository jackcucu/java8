package md.jack.task4;

import java.util.Arrays;
import java.util.stream.Stream;

public class PolygonTest {
    public static void main(String[] args) {

        RegularPolygon[] polygons = {new EquilateralTriangle(9),new EquilateralTriangle(5), new Square(10), new Square(4)};
        System.out.printf("Polygons = %s%n.", Arrays.asList(polygons));
        System.out.printf("Total number of sides =%s%n", RegularPolygon.totalSides(polygons));
        Stream.of(polygons)
                .map(RegularPolygon::getPerimeter)
                .forEach(System.out::println);

        Stream.of(polygons)
                .map(RegularPolygon::getInteriorAngle)
                .forEach(System.out::println);

    }
}
