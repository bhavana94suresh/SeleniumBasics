package com.obsqura.JavaHomework;

import java.util.Scanner;

public class VowelOrCon {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter letter to check :");

        char x = sc.next().charAt(0);

        switch (x) {
            case 'a':
            case 'e':
            case 'o':
            case 'i':
            case 'u':
                System.out.println("charcher is vowel");
                break;
            default:
                System.out.println("the letter is consonant");
        }
    }
}
