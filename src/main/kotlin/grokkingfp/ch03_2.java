package grokkingfp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ch03_2 {

    public static String abbreviate(String before) {
        return "";
    }

    public static void main(String[] args) {
        List<String> appleBook = Arrays.asList("Apple", "Book");
        List<String> appleBookMango = new ArrayList<>(appleBook);
        appleBookMango.add("Mango");

        System.out.println(appleBook.size());
        System.out.println(appleBookMango.size());

        /* *******************/
        System.out.println(abbreviate("Alonzo Church")); // "A. Church"
    }
}
