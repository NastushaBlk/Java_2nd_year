public class CircleGradient implements Fractal {
    @Override
    public double getColor(double x, double y){
        if (x*x + y*y <= 1)
            return x*x + y*y;
        else
            return 1;
    }

}
