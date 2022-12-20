package transport;

public class Bus extends Transport implements Compete {
    private Capacity capacity;

    public Bus(String brand, String model, double engineVolume, Capacity capacity) {
        super(brand, model, engineVolume);
        this.capacity = capacity;
    }

    public Capacity getCapacity() {
        return capacity;
    }

    public void setCapacity(Capacity capacity) {
        this.capacity = capacity;
    }

    public enum Capacity {
        EXTRASMALL(0,10),
        SMALL(0,25),
        MEDIUM(40,50),
        LARGE (60,80),
        EXTRALARGE(100,120);

    private  final Integer minSeats;
    private final Integer maxSeats;

        Capacity(Integer minSeats, Integer maxSeats) {
            this.minSeats = minSeats;
            this.maxSeats = maxSeats;
        }

        public Integer getMinSeats() {
            return minSeats;
        }

        public Integer getMaxSeats() {
            return maxSeats;
        }

        @Override
        public String toString() {
            if (minSeats==0){return "Вместимость до "+ maxSeats;}
            return "Вместимость:" + minSeats +" - " + maxSeats;
        }
    }


    @Override
    public void start() {
        System.out.println("Автобус " + getBrand() + "  начинает движение");
    }

    @Override
    public void finish() {
        System.out.println("Автобус " + getBrand() + "  заканчивает движение");

    }

    @Override
    public void pitStop() {
        System.out.println("Автобус " + getBrand() + " " + getModel() + " делает пит-стоп");
    }

    @Override
    public void bestLapTime() {
        System.out.println("Выводим лучшее время круга для автобуса " + getBrand() + " " + getModel());
    }

    @Override
    public void maxSpeed() {
        System.out.println("Выводим максимальную скорость для автобуса " + getBrand() + " " + getModel());
    }

    @Override
    public void printType() {
        if (getCapacity()==null) {
            System.out.println("Данных по транспортному средству недостаточно");
        }
        else
        System.out.println(getBrand()+" имеет вместимость "+getCapacity().name());
    }

    @Override
    public boolean servise() {
        System.out.println("Диагностика "+getBrand()+" автобуса не требуется");
        return true;
    }
}
