package ru.mirea.task18;

import java.util.Scanner;

public class Exception2 {
    public void exceptionDemo() {
        Scanner myScanner = new Scanner( System.in );
        System.out.print( "Enter an integer ");
        String intString = myScanner.next();
        int i = Integer.parseInt(intString); System.out.println( 2 / i );
    }

    public static void main(String[] args) {
        Exception2 task = new Exception2();
        task.exceptionDemo();
    }
}
