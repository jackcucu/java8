package md.jack.task4;

public class Square implements RegularPolygon {

    private  double sideLength;

    public Square(double sideLength)
    {
        this.sideLength = Math.abs(sideLength);
    }

    @Override
    public int getNumSides() {
        return(4);
    }

    @Override
    public double getSideLength() {
        return (sideLength);
    }
}
