package grokkingfp;

import java.util.ArrayList;
import java.util.List;

public class ch02 {
    public static class ShoppingCart {
        private List<String> items = new ArrayList<>();
        // private boolean bookAdded = false - removing the state

        public void addItem(String item) {
            items.add(item);
        }

        public static int getDiscountPercentage(List<String> items) {
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
        List<String> items = new ArrayList<>();
        items.add("Apple");
        System.out.println(ShoppingCart.getDiscountPercentage(items));

        items.add("Book");
        System.out.println(ShoppingCart.getDiscountPercentage(items));
    }
}
