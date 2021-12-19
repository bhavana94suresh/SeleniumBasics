package com.obsqura.JavaHomework;

import java.util.Scanner;

public class PrimeNum {
   static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {

        System.out.print("Enter Starting Number : ");
        int start = sc.nextInt();
        System.out.print("Enter Ending Number : ");
        int end = sc.nextInt();
        System.out.println("Prime numbers between "+start+" and "+end+" are : ");
        int count;
        for(int i = start ; i <= end ; i++)
        {
            count = 0;
            for(int j = 1 ; j <= i ; j++)
            {
                if(i % j == 0)
                    count = count+1;
            }
            if(count == 2)
                System.out.println(i);
        }


    }

}
