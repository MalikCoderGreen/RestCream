package restCream;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "ice_cream_flavors")
public class IceCreamFlavor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String iceCreamFlavor;
    private boolean vegan;
    private double price;
    private String brand;
    private boolean seasonal;

    public IceCreamFlavor() {
        new IceCreamFlavor(0, "", false, 0.00, "ABC", false);
    }
    public IceCreamFlavor(int id, String iceCreamFlavor, boolean vegan, double price, String brand, boolean seasonal) {
        this.id = id;
        this.iceCreamFlavor = iceCreamFlavor;
        this.vegan = vegan;
        this.price = price;
        this.brand = brand;
        this.seasonal = seasonal;
    }

    public int getId() {
        return id;
    }

    public String getIceCreamFlavor() {
        return iceCreamFlavor;
    }

    public boolean isVegan() {
        return vegan;
    }

    public double getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }

    public boolean isSeasonal() {
        return seasonal;
    }

    public void setIceCreamFlavor(String iceCreamFlavor) {
        this.iceCreamFlavor = iceCreamFlavor;
    }

    public void setVegan(boolean vegan) {
        this.vegan = vegan;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setSeasonal(boolean seasonal) {
        this.seasonal = seasonal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IceCreamFlavor that = (IceCreamFlavor) o;
        return id == that.id && vegan == that.vegan && Double.compare(price, that.price) == 0 && seasonal == that.seasonal && Objects.equals(iceCreamFlavor, that.iceCreamFlavor) && Objects.equals(brand, that.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, iceCreamFlavor, vegan, price, brand, seasonal);
    }
}
