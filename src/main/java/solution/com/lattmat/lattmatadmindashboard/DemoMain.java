package solution.com.lattmat.lattmatadmindashboard;

public class DemoMain {

    public static void main(String[] args) {
        Engine engine = new Engine();
        Engine engine2 = new Engine();
        Car car = new Car(engine);
        car.drive();
    }
}
