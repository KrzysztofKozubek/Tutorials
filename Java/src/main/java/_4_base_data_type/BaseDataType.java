package _4_base_data_type;

public class BaseDataType {

    public static void main(String[] args) {

        /* primitive */
        byte primitiveByte = 10;        /* -128; 127 | 8bits*/
        short primitiveShort = 20;      /* -32k; 32k | 16bits */
        int primitiveInt = 30;          /* -2kkk; 2kkk | 32bits */
        long primitiveLong = 40;        /* -9kkkkkk | 9kkkkkk | 64bits */
        float primitiveFloat = 50;      /* 32bits IEEE 754 */
        double primitiveDouble = 60;    /* 64bits IEEE 754 */
        boolean primitiveBoolean = true; /* 1bit */
        char primitiveChar = 'e';       /* 16bits */


        System.out.println(primitiveByte);
        System.out.println(primitiveShort);
        System.out.println(primitiveInt);
        System.out.println(primitiveLong);
        System.out.println(primitiveFloat);
        System.out.println(primitiveDouble);
        System.out.println(primitiveBoolean);
        System.out.println(primitiveChar);

        /* Format write value */
        String binaryNumber = "101001101";
        System.out.println(Integer.parseInt(binaryNumber, 2));
        System.out.println(10);         /* decimal */
        System.out.println(0b00001010); /* binary */
        System.out.println(012);        /* octal */
        System.out.println(0xA);        /* hexadecimal */

        /* Byte operation */
        System.out.println(0b0101 & 0b0011); /* 0b0001 = 1 */
        System.out.println(0b0101 | 0b0011); /* 0b0111 = 7 */
        System.out.println(0b0101 ^ 0b0011); /* 0b0110 = 6 */
        System.out.println(~0b0101);         /* 0b1010 = -6 */
        System.out.println(0b0101 << 2);     /* 0b010100 = 20 */
        System.out.println(0b0101 >> 2);     /* 0b01 = 1 */
    }
}
