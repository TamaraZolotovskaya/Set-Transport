package transport;


import driver.Driver;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class Transport {
    private final String brand;
    private final String model;
    private double engineVolume;
    private Set<Driver<?>> drivers = new HashSet<Driver<?>>();
    private Set<Sponsor> sponsors = new HashSet<Sponsor>();
    private Set<Mechanic<?>>  mechanics = new HashSet<Mechanic<?>>();


    public Transport(String brand,
                     String model,
                     double engineVolume) {
        if (StringUtils.IsNullOrBlank(brand)) {
            brand = "default";
        }
        this.brand = brand;

        if (StringUtils.IsNullOrBlank(model)) {
            model = "default";
        }
        this.model = model;
        setEngineVolume(engineVolume);

    }

    public void addDrivers(Driver<?> driver) {
        if (drivers.size() < 1) {
            drivers.add(driver);
        } else {
            try {
                throw new RuntimeException("У автомобиля может быть только один водитель");
            }
            catch (RuntimeException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addSponsors(Sponsor... sponsors){
        this.sponsors.addAll(Arrays.asList(sponsors));
    }

    public  void addMechanic(Mechanic<?> mechanic){
        mechanics.add(mechanic);
    }

    public Set<Mechanic<?>> getMechanics() {
        return mechanics;
    }

    public Set<Sponsor> getSponsors() {
        return sponsors;
    }

    public Set<Driver<?>> getDrivers() {
        return drivers;
    }

    public abstract void start();

    public abstract void finish();

    public abstract void printType();

    public abstract boolean servise();

    public void PrintPeopleInfo() {
        drivers=getDrivers();
        ArrayList<Driver>driverslist = new ArrayList<>(drivers);

        System.out.println("Aвтомобиль "+ getBrand()+" "+ getModel()+"\n"+
                           "водитель: "+ driverslist.get(0).getName());
        System.out.print("спонсоры: ");
        for(Sponsor sponsor: getSponsors())
        {
            System.out.print(sponsor.getName()+" ");
        }
        System.out.print("\n"+"механики: ");
        for(Mechanic<?> mechanic: getMechanics())
        {
            System.out.print(mechanic.getName()+" ");
            System.out.println(" ");
        }
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        if (Double.compare(engineVolume, 0D) == 0) {
            engineVolume = 1.5;
        }
        this.engineVolume = engineVolume;
    }


    @Override
    public String toString() {
        return getClass() +
                ", " + brand +
                ", " + model +
                ", объем двигателя" + engineVolume + "\n";
    }


}
