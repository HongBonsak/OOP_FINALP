public class Seller extends User {

    public Seller(String name) {
        super(name);
    }

    @Override
    public String getRole() {
        return "Seller";
    }

    public String addItem(StoreManager store, ClothingItem item) {
        store.addItem(item);
        return getSummary() + " added: " + item.getName();
    }
}
