package com.obsqura.JavaHomework;

import java.util.Scanner;

public class RevSentence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Input String :");

        String original = sc.nextLine();

        String rev = "";
        String s[] = original.split("");
        for (int i = s.length - 1; i >= 0; i--) {
            rev = rev + s[i] + "";
        }
        System.out.println("the original string  " + original);
        System.out.println("the reverse string is  " + rev);

    }
}
