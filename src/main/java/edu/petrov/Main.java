package edu.petrov;

import static java.lang.System.out;

public class Main {

    private static Pizza pizza = new Pizza();

    public static void main(String[] args) throws InterruptedException {
        int birthDay = 0;
        if (args.length == 0) {
            out.println("Application for calculating the number of ways to cutting pizza! Shareware version. Full version" +
                    " costs only 9.99$\n" +
                    "Use the following format for command line arguments: pizza.jar MMDDYYYY.\n" +
                    "For example: pizza.jar 21101984\n");
            System.exit(0);
        }
        try {
            birthDay = Integer.parseInt(args[0]);
            // checking for correct date of birth
            if (birthDay < 0 || (args[0].length() != 6 || args[0].length() != 8))
                throw new NumberFormatException();
        } catch (NumberFormatException e) {
            out.println("Please, enter correct birthday in format DDMMYYYY or DDMMYY. Thank you for patience!");
            System.exit(-1);
        }

        pizza.setSize(MagicBirthdayNumberGenerator.getMagicNumber(birthDay));

        int timeToSleep = 3000;
        new Thread(() -> {
            out.print("Please wait, calculating the number of ways to cutting pizza");
            int ms = timeToSleep;
            while (ms > 0) {
                out.print(".");
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ms -= 250;
            }
        }).start();
        Thread.sleep(timeToSleep);
        out.println("done!");

        out.println(pizza.getCuttingOptions());
    }
}
