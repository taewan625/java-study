package io_stream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArray {
    public static void main(String[] args) {
        byte[] inStr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        byte[] outSrc;
        byte[] temp = new byte[4];

        ByteArrayInputStream input = new ByteArrayInputStream(inStr);
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try {
            while (input.available() > 0) {
                System.out.println(input.available()); // 10 -> 6 -> 2

                int len = input.read(temp);
                System.out.println("len = " + len);

                // output.write(temp); // 중복 문제 발생
                output.write(temp, 0, len);
                System.out.println("len = " + len);

                outSrc = output.toByteArray();
                System.out.println(Arrays.toString(outSrc));
            }
        } catch (IOException e) {
            System.out.println("Error : " + e);
        }
    }


}
