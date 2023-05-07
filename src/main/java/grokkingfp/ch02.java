package grokkingfp;

import java.util.ArrayList;
import java.util.List;

public class ch02 {
    public class ShoppingCart {
        private List<String> items = new ArrayList<>();
        // private boolean bookAdded = false - removing the state

        public void addItem(String item) {
            items.add(item);
        }

        public int getDiscountPercentage() {
            if (items.contains("Book")) {
                return 5;
            } else {
                return 0;
            }
        }

        public List<String> getItems() {
            return new ArrayList<>(items);
        }

        public void removeItem(String item) {
            items.remove(item);
        }
    }


    public void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Apple");
        System.out.println(cart.getDiscountPercentage());

        cart.addItem("Book");
        System.out.println(cart.getDiscountPercentage());

    }
}
