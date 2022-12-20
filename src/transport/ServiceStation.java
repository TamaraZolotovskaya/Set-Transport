package transport;

import java.util.LinkedList;
import java.util.Queue;

public class ServiceStation<T extends Car> {
    private String name;
    private Queue<T> queue = new LinkedList<>();

    public void addCar(T car) {
        queue.add(car);
        System.out.println("Автомобиль " + car.getBrand() + " поставлен в очередь на техобслуживание");
    }

    public void doServise() {
        if (!queue.isEmpty()) {
            T car = queue.poll();
            System.out.println("Проведено техобслуживание автомобиля " + car.getBrand());
        }
    }


    public ServiceStation(String name) {
        setName(name);
    }

    public void setName(String name) {
        if (StringUtils.IsNullOrBlank(name)) {
            name = "Станция";
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
