import java.io.Serializable;
import java.time.LocalDate;

public class Producto implements Serializable {
    //region Atributos
    private int id;
    private String name;
    private double price;
    private boolean isAvailable;
    private LocalDate regDate;
    private String category;
    //endregion
    
    //region Constructores

    public Producto() {
        this.id = -1;
        this.name = "";
        this.price = -1;
        this.isAvailable = false;
        this.regDate = LocalDate.now();
        this.category = "";
    }

    public Producto(int id, String name, double price, boolean available, LocalDate regDate, String category) {
        setId(id);
        setName(name);
        setPrice(price);
        setAvailable(available);
        setRegDate(regDate);
        setCategory(category);
    }

    //endregion
    
    //region Getters&Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    //endregion

    //region Override

    @Override
    public String toString() {
        return "Producto{" +
                "id:" + id +
                ", name:'" + name + '\'' +
                ", price:" + price +
                ", available:" + isAvailable +
                ", regDate:" + regDate +
                ", category:'" + category + '\'' +
                '}';
    }

    //endregion
    
}
