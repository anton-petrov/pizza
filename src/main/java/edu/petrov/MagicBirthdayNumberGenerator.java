package edu.petrov;

public class MagicBirthdayNumberGenerator {
    public static int getMagicNumber(int birthDay) {
        return (birthDay % 7) + 7;
    }
}
