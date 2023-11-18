public class DataTypes {
    public static void main(String a[]) {
        // byte => 1 byte(8 bits) [-2^7 to 2^7 -1] => [-128 to 127]
        // short => 
        // chat => 2 bytes following the UNICODE system rather than the ASCII
        // All floating point values are considered as of type "double" in java 

        float cgpa = 7.5f; // This is how you specify a float type variable in java
        boolean isHappy = true;
        char c = 'A';
        long lng = 158796l; // literals
        String sentence = "My name is Subho .";

        int bin = 0b101;
        int hex = 0x7E;
        System.out.println("Binary number in java "+bin);

        System.out.println("Hexadecimal number in java "+hex);


        System.out.println(sentence);
    }
}