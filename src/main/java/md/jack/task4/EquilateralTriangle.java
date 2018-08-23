package md.jack.task4;

public class EquilateralTriangle implements RegularPolygon{

    private  double sideLength;

    public EquilateralTriangle(double sideLength)
    {
        this.sideLength = Math.abs(sideLength);
    }

    @Override
    public int getNumSides() {
        return(3);
    }

    @Override
    public double getSideLength() {
        return (sideLength);
    }
}
