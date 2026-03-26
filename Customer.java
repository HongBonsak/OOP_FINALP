public class Customer extends User {

    public Customer(String name) {
        super(name);
    }

    public String buyItem(ClothingItem item) {
        return buyItem(item, 1, item.getPrice());
    }

    public double calculateTotal(ClothingItem item, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be at least 1.");
        }
        return item.getPrice() * quantity;
    }

    public String buyItem(ClothingItem item, int quantity, double payment) {
        if (payment < 0) {
            return "Payment cannot be negative.";
        }
        if (item.getStock() < quantity) {
            return item.getName() + " does not have enough stock.";
        }
        double total;
        try {
            total = calculateTotal(item, quantity);
        } catch (IllegalArgumentException ex) {
            return ex.getMessage();
        }
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
