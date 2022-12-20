import driver.DriverB;
import driver.DriverC;
import driver.DriverD;
import transport.*;

import java.util.Arrays;
import java.util.List;


public class Main {


    public static void main(String[] args) {
        PassengerCar passengerCar1 = new PassengerCar("Lada",
                "Granta",
                1.7,
                null);
        PassengerCar passengerCar2 = new PassengerCar("Audi",
                "A8 50 L TDI quattro",
                3,
                PassengerCar.BodyType.SUV);
        PassengerCar passengerCar3 = new PassengerCar("BMW",
                "Z8",
                3,
                PassengerCar.BodyType.CROSSOVER);
        PassengerCar passengerCar4 = new PassengerCar("Kia",
                "Sportage 4-го поколения",
                2.4,
                PassengerCar.BodyType.UNIVERSAL);

        Bus bus1 = new Bus("VAZ",
                "Ф-12",
                3.1,
                Bus.Capacity.MEDIUM);
        Bus bus2 = new Bus("Mersedes",
                "РА234",
                5.5,
                Bus.Capacity.SMALL);
        Bus bus3 = new Bus("Subary",
                "НТ-2",
                4.3,
                Bus.Capacity.LARGE);
        Bus bus4 = new Bus("Honda",
                "АА",
                4.3,
                Bus.Capacity.EXTRALARGE);

        Truck track1 = new Truck("Volvo",
                "FH",
                4.1,
                Truck.LoadCapacity.N1);
        Truck track2 = new Truck("DAF",
                "XF",
                5.1,
                Truck.LoadCapacity.N2);
        Truck track3 = new Truck("Scania",
                "R730 V8",
                4.7,
                Truck.LoadCapacity.N3);

        Truck track4 = new Truck("Iveco",
                "S-Way",
                6.1,
                Truck.LoadCapacity.N2);


        bus1.pitStop();
        passengerCar1.bestLapTime();
        track1.maxSpeed();
        passengerCar1.start();

        DriverB sam = new DriverB("Sam", 18);
        sam.info(passengerCar1);
        sam.refuel(passengerCar1);
        sam.start(passengerCar1);
        sam.finish(passengerCar1);
        DriverC bill = new DriverC("Bill", 10);
        bill.info(track1);
        DriverD jack = new DriverD("Jack", 12);
        jack.info(bus1);

        System.out.println(Arrays.toString(PassengerCar.BodyType.values()));
        System.out.println(Arrays.toString(Truck.LoadCapacity.values()));
        System.out.println(Arrays.toString(Bus.Capacity.values()));

        passengerCar1.printType();
        track1.printType();
        bus1.printType();

        service(passengerCar1, passengerCar2, passengerCar3, passengerCar4,
                track1, track2, track3, track4,
                bus1, bus2, bus3, bus4);

        //List carList = new ArrayList<Transport>();
        // carList.add(passengerCar1);

        List <Transport> carList = List.of(passengerCar1, passengerCar2, passengerCar3, passengerCar4,
                track1, track2, track3, track4, bus1, bus2, bus3, bus4);


        passengerCar1.addDrivers(sam);
        passengerCar1.addDrivers(bill);

        //Спонсоры
        Sponsor adidas = new Sponsor("Adidas", 1000);
        Sponsor nike = new Sponsor("Nike", 2000);
        Sponsor puma = new Sponsor("Puma", 3000);

        adidas.becomeSponsor(passengerCar1);
        nike.becomeSponsor(passengerCar1);

        System.out.println(passengerCar1.getSponsors().toString());

        //Механики
        Mechanic<PassengerCar> jane = new Mechanic("Jane", "F1");
        Mechanic<PassengerCar> mary = new Mechanic("Mary", "F2");
        passengerCar1.addMechanic(jane);
        mary.servise(passengerCar2);

        passengerCar1.PrintPeopleInfo();

        //Очередь на техобслуживание
        ServiceStation station1 = new ServiceStation<>("Станция 1");
        station1.addCar(passengerCar1);
        station1.addCar(track1);
        station1.addCar(track2);
        station1.doServise();
        station1.doServise();



    }
    private static void service(Transport... transports) {
        for (int i = 0; i < transports.length; i++) {
            if (!transports[i].servise()) {
                try {
                    throw new RuntimeException("Автомобиль " + transports[i].getBrand() + " нуждается в диагностике");
                }
                catch (RuntimeException e){
                    System.out.println(e.getMessage());
                }
            }

        }
    }
}