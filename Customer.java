public class Customer extends User {

    public Customer(String name) {
        super(name);
    }

    public String buyItem(ClothingItem item) {
        return buyItem(item, 1, item.getPrice());
    }

    public String buyItem(ClothingItem item, int quantity, double payment) {
        if (quantity <= 0) {
            return "Quantity must be at least 1.";
        }
        if (item.getStock() < quantity) {
            return item.getName() + " does not have enough stock.";
        }
        double total = item.getPrice() * quantity;
        if (payment < total) {
            return String.format("Insufficient payment. Total: $%.2f", total);
        }

        item.setStock(item.getStock() - quantity);
        double change = payment - total;
        return String.format(
                "%s bought: %s x%d%nPrice: $%.2f%nTotal: $%.2f%nPayment: $%.2f%nChange: $%.2f",
                getName(),
                item.getName(),
                quantity,
                item.getPrice(),
                total,
                payment,
                change
        );
    }
}
