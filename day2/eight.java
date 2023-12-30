
// Write a function that takes in an array of objects and returns a new array with only the objects that have a specific property
import java.util.ArrayList;
import java.util.List;

public class eight {

    static class CustomObject {
        // Assuming this class has some properties
        private String name;
        private int age;

        public CustomObject(String name, int age) {
            this.name = name;
            this.age = age;
        }

        // Getter for the property you want to filter
        public String getName() {
            return name;
        }
    }

    // Function to filter objects with a specific property
    static CustomObject[] filterObjectsWithProperty(CustomObject[] objects, String propertyName) {
        List<CustomObject> filteredList = new ArrayList<>();

        for (CustomObject obj : objects) {
            // Assuming the property is a string (adjust as needed)
            if (obj.getName() != null && obj.getName().equals(propertyName)) {
                filteredList.add(obj);
            }
        }

        // Convert the list to an array
        return filteredList.toArray(new CustomObject[0]);
    }

    // Main function for testing
    public static void main(String[] args) {
        // Creating an array of CustomObject
        CustomObject[] objects = {
                new CustomObject("John", 25),
                new CustomObject("Alice", 30),
                new CustomObject("John", 28),
                new CustomObject("Bob", 22),
                new CustomObject("John", 35)
        };

        // Filtering objects with the name "John"
        String propertyNameToFilter = "John";
        CustomObject[] filteredObjects = filterObjectsWithProperty(objects, propertyNameToFilter);

        // Displaying the filtered objects
        System.out.println("Objects with property '" + propertyNameToFilter + "':");
        for (CustomObject obj : filteredObjects) {
            System.out.println("Name: " + obj.getName() + ", Age: " + obj.age);
        }
    }
}
