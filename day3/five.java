// Write a function that takes an array of objects and returns a new array with the values of a specific property

import java.util.Arrays;

public class five {
    static class obj {
        String name, phone;
        int age;

        public obj(String name, String phone, int age) {
            this.name = name;
            this.age = age;
            this.phone = phone;
        }

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) {
        obj obj1 = new obj("Vaibhav", "8383838383", 20);
        obj obj2 = new obj("abc", null, 20);
        obj obj3 = new obj("Vaibhav", "xxxxxxx", 21);
        obj obj4 = new obj("Vaibhav", "00000000000", 20);

        System.out.println(Arrays.toString(getProp(new obj[] { obj1, obj2, obj3, obj4 })));
    }

    private static String[] getProp(obj[] objs) {
        String[] ret = new String[objs.length];
        for (int i = 0; i < objs.length; i++) {
            ret[i] = objs[i].getName();
        }
        return ret;
    }
}
