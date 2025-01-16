package assignment7.MethodOverLoading;
class Point {

    private double x;
    private double y;


    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }


    //Method to obtain distance of a point w.r.t origin
    public double distance(){
        //code here
        return Math.sqrt(x*x + y*y);
    }

    //Method to obtain distance of a point w.r.t another point
    public double distance(Point point){
        //code here
        return Math.sqrt((x-point.x)*(x-point.x) + (y-point.y)*(y-point.y));
    }

    // constructor
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

}
public class Exercise1 {
    public static void main(String[] args) {
        //code here
        Point p1 = new Point(2,3);
        Point p2 = new Point(5,6);
        System.out.println("Distance of p1 from origin: "+p1.distance());
        System.out.println("Distance of p1 from p2: "+p1.distance(p2));
    }
}
