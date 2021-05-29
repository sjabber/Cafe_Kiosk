package page.menu;

public class Menu {

    final String Name;
    final int Price;

    public Menu(String Name, int Price) {
        this.Name = Name;
        this.Price = Price;
    }

    public String getName() {
        return Name;
    }

    public int getPrice() {
        return Price;
    }

}
