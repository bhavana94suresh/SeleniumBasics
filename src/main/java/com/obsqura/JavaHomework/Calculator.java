package com.obsqura.JavaHomework;

import java.util.Scanner;

public class Calculator {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the operator");
        char oper = sc.nextLine().charAt(0);
        Double num1, num2, result;
        System.out.println("enter the first number");
        num1 = sc.nextDouble();
        System.out.println("enter the second number");
        num2 = sc.nextDouble();
        switch (oper) {
            case '+':
                result = num1 + num2;
                System.out.println("the sum is " + result);
                break;
            case '-':
                result = num1 - num2;
                System.out.println("the difference is " + result);
                break;
            case '*':
                result = num1 * num2;
                System.out.println("the product is " + result);
                break;
            case '/':
                if (num1 > num2) {
                    result = num1 / num2;
                } else {
                    result = num2 / num1;
                }
                System.out.println("the sum is " + result);
                break;
            default:
                System.out.println("invalid operator");

        }

    }
}
