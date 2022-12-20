package transport;

import java.util.Objects;

public class Mechanic<T extends Transport> {
    private final String name;
    private String company;


    public Mechanic(String name, String company) {
        if (StringUtils.IsNullOrBlank(name)) {
            name = "Механик";
        }
        this.name = name;
        setCompany(company);
    }

    public boolean servise(T t) {
        t.getMechanics().add(this);
        return t.servise();
    }

    public void repair(T t) {
        t.getMechanics().add(this);
        System.out.println("Механик " + getName() + " починил машину " + t.getBrand());
    }

    public void setCompany(String company) {
        if (StringUtils.IsNullOrBlank(company)) {
            company = "Компания";
        }
        this.company = company;
    }


    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    @Override
    public String toString() {
        return "Mechanic{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mechanic<?> mechanic = (Mechanic<?>) o;
        return Objects.equals(name, mechanic.name) && Objects.equals(company, mechanic.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, company);
    }
}
