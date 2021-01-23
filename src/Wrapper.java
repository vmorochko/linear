// todo add lazy initialization

public class Wrapper {

    private int lowerBound;
    private int upperBound;
    private double[] values;
    private Expression expression;

    public int getLowerBound() {
        return lowerBound;
    }

    public int getUpperBound() {
        return upperBound;
    }

    public double[] getValues() {
        return values;
    }

    public Expression getExpression() {
        return expression;
    }

    public Wrapper(Expression expression, int lowerBound, int upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.expression = expression;
        this.values = new double[upperBound - lowerBound + 2];

        // temporary : values initialization
        int currentParameter = lowerBound;
        for (int i = 0; i < values.length; i++) {
            values[i] = expression.calculate(currentParameter);
            currentParameter++;
        }
    }

    public double calculate(double parameter) {
        if (parameter >= upperBound || parameter < lowerBound) {
            return expression.calculate(parameter);
        }
        int iPart = (int) parameter;
        double fPart = parameter - iPart;
        iPart -= lowerBound;
        double linearApprox = values[iPart] + (values[iPart + 1] - values[iPart]) * fPart;
        double correction = linearApprox - (values[iPart] + (values[iPart + 2] - values[iPart]) * fPart * .5);
        linearApprox += correction;
        return linearApprox;
    }
}
