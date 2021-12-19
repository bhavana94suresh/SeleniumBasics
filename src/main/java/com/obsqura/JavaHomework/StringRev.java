package com.obsqura.JavaHomework;

import java.util.Scanner;

public class StringRev {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Input String :");

        String original = sc.nextLine();

        String rev = "";
        for (int i = original.length() - 1; i >= 0; i--) {
            rev = rev + original.charAt(i);
        }
        System.out.println("the original string  " + original);
        System.out.println("the reverse string is  " + rev);
        sc.close();
    }
}
