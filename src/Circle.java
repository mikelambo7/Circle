import java.util.Objects;

public class Circle {

    private double radius; // must be >= 0

    public Circle() {
        radius = 0;
    }

    public Circle(double r) {
        radius = r >= 0 ? r : 0;
    }

    @Override
    public String toString() {
        return String.format("Circle(r=%f , c=%f , a=%f)",
                radius, getCircumference(), getArea());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        /*
        TODO: currently comparing floating point values for EXACT equality; modify to use a tolerance
         */
        double tolerance = 0.0001;
        return Math.abs(circle.radius - radius) < tolerance ? true : false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double r) {
        radius = r >= 0 ? r : 0;
    }

    public double getCircumference() {
        return 2 * Math.PI * radius;
    }

    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}
