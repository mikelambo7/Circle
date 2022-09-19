import java.util.ArrayList;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {
    private double[] radius = {5.5, 7.0, 49.0, 23.5, 6.5, -4.0, 17.3, 0.0};
    private double[] new_radius = {6.5, 42.5, 8.9, 0.0, 9.45, 5.23, -24.6, 44.4};
    private ArrayList<Circle> circleList;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        circleList = new ArrayList<>();
        for (int i = 0; i < radius.length; i++) {
            Circle ci = new Circle(radius[i]);
            circleList.add(ci);
        }
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() { circleList = null; }

    @org.junit.jupiter.api.Test
    void testToString() {
        for(Circle circle : circleList){
            System.out.println(circle);
        }
    }

    @org.junit.jupiter.api.Test
    void testEquals() {
        assert(circleList.size() == radius.length);
        for (Circle circle : circleList) {
            Circle copy = circle; // both variables point to same object
            assertEquals(circle,copy);
            Circle nullPointer = null;
            assertFalse(circle.equals(nullPointer));
            assertFalse(circle.equals("not a bank account"));
        }
        for (int i = 0; i < radius.length; i++) {
            Circle ci = circleList.get(i);
            Circle other_ci = new Circle(radius[i]);
            assertNotSame(other_ci,ci);
            assertEquals(other_ci,ci);
            Circle unequal_ci = new Circle(radius[i] + 20);
            assertNotEquals(unequal_ci,ci);
        }
    }

    @org.junit.jupiter.api.Test
    void testHashCode() {
        assert(circleList.size() == radius.length);
        for (int i = 0; i < circleList.size(); i++) {
            Circle ci = circleList.get(i);
            Circle other_ci = new Circle(radius[i]);
            assertNotSame(other_ci, ci);
            assertEquals(other_ci.hashCode(), ci.hashCode());
        }
    }

    @org.junit.jupiter.api.Test
    void getRadius() {
        assert(circleList.size() == radius.length);
        for (int i = 0; i < circleList.size(); i++) {
            double the_radius = circleList.get(i).getRadius();
            double expected_radius = radius[i] > 0 ? radius[i] : 0;
            assertEquals(expected_radius, the_radius);
        }
    }

    @org.junit.jupiter.api.Test
    void setRadius() {
        assert(new_radius.length == circleList.size());
        for (int i = 0; i < circleList.size(); i++) {
            Circle ci = circleList.get(i);
            ci.setRadius(new_radius[i]);
            double the_radius = ci.getRadius();
            double expected_radius = new_radius[i] > 0 ? new_radius[i] : 0;
            assertEquals(expected_radius, the_radius);
        }
    }

    @org.junit.jupiter.api.Test
    void getCircumference() {
        assert(radius.length == circleList.size());
        for (int i = 0; i < circleList.size(); i++) {
            double the_circumference = circleList.get(i).getCircumference();
            double expected_circumference = radius[i] > 0 ? 2 * Math.PI * radius[i] : 0;
            assertEquals(expected_circumference, the_circumference);
        }
    }

    @org.junit.jupiter.api.Test
    void getArea() {
        assert(radius.length == circleList.size());
        for (int i = 0; i < circleList.size(); i++) {
            double the_area = circleList.get(i).getArea();
            double expected_area = radius[i] > 0 ? Math.PI * Math.pow(radius[i], 2) : 0;
            assertEquals(expected_area, the_area);
        }
    }
}