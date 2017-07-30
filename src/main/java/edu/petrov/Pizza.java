package edu.petrov;

import java.util.LinkedList;
import java.util.List;

public class Pizza {
    private final static Integer PIECE_SIZE = 8;
    private final List<List<Integer>> allPizzaCuttingOptions = new LinkedList<>();
    private final List<Integer> pizza = new LinkedList<>();

    public Pizza() {
    }

    public Pizza(int size) {
        for (int i = 0; i < size; i++) {
            pizza.add(PIECE_SIZE);
        }
    }

    public void setSize(int size) {
        pizza.clear();
        for (int i = 0; i < size; i++) {
            pizza.add(PIECE_SIZE);
        }
    }

    private void calculateAllCuttingOptions() {
        allPizzaCuttingOptions.add(pizza);
        List<List<Integer>> currentPizzaCuttingOptions = new LinkedList<>(allPizzaCuttingOptions);
        int divider = PIECE_SIZE / 2;
        while (divider > 0) {
            currentPizzaCuttingOptions = getPizzaCuttingOptionsByDivider(currentPizzaCuttingOptions, divider);
            allPizzaCuttingOptions.addAll(currentPizzaCuttingOptions);
            divider /= 2;
        }
    }

    private List<List<Integer>> getPizzaCuttingOptionsByDivider(List<List<Integer>> pizzaOptions, int divider) {
        List<List<Integer>> pizzaCuttingOptions = new LinkedList<>();
        for (List<Integer> pizzaCuttingOption : pizzaOptions) {
            boolean canCutDown = true;
            LinkedList<Integer> currentPizzaCuttingOption = new LinkedList<>(pizzaCuttingOption);
            while (canCutDown) {
                LinkedList<Integer> newPizzaCuttingOption = new LinkedList<>();
                canCutDown = false;
                for (int i = 0; i < currentPizzaCuttingOption.size() - 1; i++) {
                    if (currentPizzaCuttingOption.get(i) == divider * 2 && currentPizzaCuttingOption.get(i + 1) == divider * 2) {
                        newPizzaCuttingOption.add(divider);
                        currentPizzaCuttingOption.remove(i);
                        currentPizzaCuttingOption.remove(i);
                        newPizzaCuttingOption.addAll(currentPizzaCuttingOption);
                        currentPizzaCuttingOption = new LinkedList<>(newPizzaCuttingOption);
                        canCutDown = true;
                        break;
                    }
                }
                if (newPizzaCuttingOption.size() > 0) {
                    pizzaCuttingOptions.add(newPizzaCuttingOption);
                }
            }
        }
        return pizzaCuttingOptions;
    }

    @Override
    public String toString() {
        return pizzaToString(pizza);
    }

    private String pizzaToString(List<Integer> pizza) {
        int lastCounter = 0;
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (Integer piece : pizza) {
            String fmtStr = piece == 1 ? "%d" : "1/%d";
            lastCounter++;
            result.append(lastCounter < pizza.size() ? String.format(fmtStr + ", ", piece) : String.format(fmtStr, piece));
        }
        result.append("]");

        return result.toString();
    }

    public String getCuttingOptions() {
        calculateAllCuttingOptions();
        StringBuilder result = new StringBuilder();
        for (List<Integer> pizzaCuttingOption : allPizzaCuttingOptions) {
            result.append(pizzaToString(pizzaCuttingOption));
            result.append("\n");
        }
        return result.toString();
    }
}
