import edu.petrov.MagicBirthdayNumberGenerator;
import edu.petrov.Pizza;
import org.junit.Assert;
import org.junit.Test;

public class PizzaTest {
    @Test
    public void PizzaTest1() {
        Pizza pizza = new Pizza(MagicBirthdayNumberGenerator.getMagicNumber(21101985));
        Assert.assertEquals("[1/8, 1/8, 1/8, 1/8, 1/8, 1/8, 1/8, 1/8, 1/8]\n" +
                "[1/4, 1/8, 1/8, 1/8, 1/8, 1/8, 1/8, 1/8]\n" +
                "[1/4, 1/4, 1/8, 1/8, 1/8, 1/8, 1/8]\n" +
                "[1/4, 1/4, 1/4, 1/8, 1/8, 1/8]\n" +
                "[1/4, 1/4, 1/4, 1/4, 1/8]\n" +
                "[1/2, 1/8, 1/8, 1/8, 1/8, 1/8]\n" +
                "[1/2, 1/4, 1/8, 1/8, 1/8]\n" +
                "[1/2, 1/4, 1/4, 1/8]\n" +
                "[1/2, 1/2, 1/8]\n" +
                "[1, 1/8]\n", pizza.getCuttingOptions());
    }

    @Test
    public void PizzaTest2() {
        Pizza pizza = new Pizza(1);
        Assert.assertEquals("[1/8]\n", pizza.getCuttingOptions());
    }

    @Test
    public void PizzaTest3() {
        Pizza pizza = new Pizza(0);
        Assert.assertEquals("[]\n", pizza.getCuttingOptions());
    }

}