package transport;

import java.util.Objects;

public class Sponsor {
    private final String name;
    private int amountOfMoney;

    public Sponsor(String name, int amountOfMoney) {
        if (StringUtils.IsNullOrBlank(name)) {
            name = "Спонсор";
        }
        this.name = name;
        setAmountOfMoney(amountOfMoney);
    }

    public void becomeSponsor(Transport transport){
        transport.getSponsors().add(this);
    }

    public void setAmountOfMoney(int amountOfMoney) {
        if (amountOfMoney<0)
        {amountOfMoney=Math.abs(amountOfMoney);}
        this.amountOfMoney = amountOfMoney;
    }

    public String getName() {
        return name;
    }

    public int getAmountOfMoney() {
        return amountOfMoney;
    }

    @Override
    public String toString() {
        return "Sponsor{" +
                "name='" + name + '\'' +
                ", amountOfMoney=" + amountOfMoney +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sponsor sponsor = (Sponsor) o;
        return amountOfMoney == sponsor.amountOfMoney && Objects.equals(name, sponsor.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, amountOfMoney);
    }
}
