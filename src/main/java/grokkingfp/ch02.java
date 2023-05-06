package grokkingfp;

import java.util.ArrayList;
import java.util.List;

public class ch02 {
    public class ShoppingCart {
        private List<String> items = new ArrayList<>();
        private boolean bookAdded = false;

        public void addItem(String item) {
            items.add(item);
            if (item.equals("Book")) {
                bookAdded = true;
            }
        }

        public int getDiscountPercentage() {
            if (bookAdded) {
                return 5;
            } else {
                return 0;
            }
        }

        public List<String> getItems() {
            return items;
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
