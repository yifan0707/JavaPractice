public class CalculatorModel {
    int result;

    public CalculatorModel() {
        result = 0;
    }

    public int add(int num1, int num2) {
        return num1 + num2;
    }

    public int getResult() {
        return result;
    }

    public void reset() {
        result = 0;
    }
}
