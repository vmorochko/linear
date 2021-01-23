

public class Linear {
    public static void main(String[] args) {
        Expression e = new Expression();
        Wrapper w = new Wrapper(e, 1, 5);
        for (int i = 1; i <= 60; i++) {
            System.out.print("parameter = ");
            double parameter = .1 * i;
            double linearApprox = w.calculate(parameter);
            double exact = w.getExpression().calculate(parameter);
            System.out.print(parameter);
            System.out.print(" ");
            System.out.print("linear = ");
            System.out.print(linearApprox);
            System.out.print(" ");
            System.out.print("expression = ");
            System.out.print(exact);
            System.out.print(" ");
            System.out.print("error = ");
            System.out.print(linearApprox - exact);
            System.out.println();

//        int tries = 1000000;
//        int skip = 500000;
//        double[] exTime = new double[tries];
//        double[] wrTime = new double[tries];
//        long time1, time2, time3;
//        for (int i = 0; i < tries; i++) {
//            double parameter = w.getLowerBound() + Math.random() * (w.getUpperBound() - w.getLowerBound());
//            time1 = System.nanoTime();
//            e.calculate(parameter);
//            time2 = System.nanoTime();
//            w.calculate(parameter);
//            time3 = System.nanoTime();
//
//            exTime[i] = time2 - time1;
//            wrTime[i] = time3 - time2;
//        }
//
//        long tmp = 0;
//        for (int i = skip; i < exTime.length; i++) {
//            tmp += exTime[i];
//        }
//        double avgEx = (double) tmp / (exTime.length - skip);
//        tmp = 0;
//        for (int i = skip; i < wrTime.length; i++) {
//            tmp += wrTime[i];
//        }
//        double avgWr = (double) tmp / (wrTime.length - skip);
//        System.out.println("avg expression time: " + avgEx);
//        System.out.println("avg wrapper time: " + avgWr);
        }
    }
}

