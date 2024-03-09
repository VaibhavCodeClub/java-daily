// Write a function that takes in an array of objects and returns number the objects that have a specific property

public class nine {
    static class objects {
        private String name;
        // private int age;

        public objects(String name, int age) {
            this.name = name;
            // this.age = age;
        }

        public String getName() {
            return name;
        }

    }

    static int countObjectsWithProperty(objects[] objects, String propertyName) {
        int count = 0;

        for (objects obj : objects) {
            if (obj.getName() != null && obj.getName().equals(propertyName)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        // Creating an array of objects
        objects[] objects = {
                new objects("John", 25),
                new objects("Alice", 30),
                new objects("John", 28),
                new objects("Bob", 22),
                new objects("John", 35)
        };

        // Counting objects with the name "John"
        String propertyNameToCount = "Alice";
        int count = countObjectsWithProperty(objects, propertyNameToCount);

        // Displaying the result
        System.out.println("Number of objects with property '" + propertyNameToCount + "': " + count);
    }
}