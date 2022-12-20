package transport;

public class Truck extends Car implements Compete {
    private LoadCapacity loadCapacity;

    public Truck(String brand, String model, double engineVolume, LoadCapacity loadCapacity) {
        super(brand, model, engineVolume);
        this.loadCapacity = loadCapacity;
    }

    public LoadCapacity getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(LoadCapacity loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public enum LoadCapacity {
        N1(null, 3.5F),
        N2(3.5F, 12F),
        N3(12F, null);

        private final Float min;
        private final Float max;

        LoadCapacity(Float min, Float max) {
            this.min = min;
            this.max = max;
        }

        public Float getMin() {
            return min;
        }

        public Float getMax() {
            return max;
        }

        @Override
        public String toString() {
            if (min == null) {
                return "Грузоподьемность до " + max;
            }
            if (max == null) {
                return "Грузоподьемность от " + min;
            }
            return "Грузоподьемность от " + min + " тонн до " + max + " тонн";
        }
    }


    @Override
    public void start() {
        System.out.println("Грузовой автомобиль " + getBrand() + " начинает движение");
    }

    @Override
    public void finish() {
        System.out.println("Легковой автомобиль " + getBrand() + "  заканчивает движение");
    }

    @Override
    public void pitStop() {
        System.out.println("Грузовой автомобиль " + getBrand() + " " + getModel() + " делает пит-стоп");
    }

    @Override
    public void bestLapTime() {
        System.out.println("Выводим лучшее время круга для грузового автомобиля " + getBrand() + " " + getModel());
    }

    @Override
    public void maxSpeed() {
        System.out.println("Выводим максимальную скорость для грузового автомобиля " + getBrand() + " " + getModel());
    }

    @Override
    public void printType() {
        if (loadCapacity == null) {
            System.out.println("Данных по транспортному средству недостаточно");
        } else {
            String from = loadCapacity.min == null ? "" : "от " + loadCapacity.max + " ";
            String to = loadCapacity.max == null ? "" : "до " + loadCapacity.max;
            System.out.println(getBrand() + " имеет грузоподьемность " + from + to);
        }
    }

    @Override
    public boolean servise() {
        return Math.random() > 0.5;
    }


}
