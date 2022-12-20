package transport;

public class PassengerCar extends Car implements Compete {
    private BodyType bodyType;

    public PassengerCar(String brand, String model, double engineVolume, BodyType bodyType) {
        super(brand, model, engineVolume);
        this.bodyType = bodyType;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }

    public enum BodyType {SEDAN("Седан"),
            HATCHBACK("Хетчбек"),
            COUPE ("Купе"),
            UNIVERSAL ("Универсал"),
            SUV ("Внедорожник"),
            CROSSOVER ("Кроссовер"),
            PICKAP ("Пикап"),
            VAN ("Фургон"),
            MINIVAN ("Минивэн");


        private final String russianName;

        @Override
        public String toString() {
            return name() +
                    ": <" + russianName + "> ";
        }

        BodyType(String russianName) {
            this.russianName = russianName;


        }

        public String getRussianName() {
            return russianName;
        }
    }
    @Override
    public void start() {
        System.out.println("Легковой автомобиль " + getBrand() + " начинает движение");
    }

    @Override
    public void finish() {
        System.out.println("Легковой автомобиль " + getBrand() + " заканчивает движение");
    }

    @Override
    public void pitStop() {
        System.out.println("Легковой автомобиль " + getBrand() + " " + getModel() + " делает пит-стоп");
    }

    @Override
    public void bestLapTime() {
        System.out.println("Выводим лучшее время круга для легкового автомобиля " + getBrand() + " " + getModel());

    }

    @Override
    public void maxSpeed() {
        System.out.println("Выводим максимальную скорость для легкового автомобиля " + getBrand() + " " + getModel());
    }

    @Override
    public void printType() {
        if (bodyType==null) {
            System.out.println("Данных по транспортному средству недостаточно");
        }
        else
            System.out.println(getBrand()+" имеет тип кузова " + bodyType.russianName);
    }

    @Override
    public boolean servise() {
        return Math.random()>0.5;
    }
}

