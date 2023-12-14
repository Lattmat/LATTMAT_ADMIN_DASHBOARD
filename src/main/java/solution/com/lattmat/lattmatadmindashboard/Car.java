package solution.com.lattmat.lattmatadmindashboard;

public class Car {

    private Engine engine;

    public Car (Engine engine){
        this.engine = engine;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void drive(){
        System.out.println(engine);
        System.out.println("Car is driving");
    }
}
