/**
 *
 * Anton Petrov, 2017.
 * anton.a.petrov@gmail.com
 *
 */

package edu.petrov;

public class MagicBirthdayNumberGenerator {
    public static int getMagicNumber(int birthDay) {
        return (birthDay % 7) + 7;
    }
}
