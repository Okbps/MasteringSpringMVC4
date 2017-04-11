package masterSpringMvc;

/**
 * Created by Aspire on 06.04.2017.
 */
public class TestClass {
    public static class Product {
        public Product(String title, int size) {
            this.title = title;
            this.size = size;
        }
        public String title;
        public int size;

        public String getTitle() {
            return title;
        }

        public int getSize() {
            return size;
        }

        public String toString() {
            return title + ":" + size;
        }
    }
}
