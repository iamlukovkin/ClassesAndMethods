import java.util.random.RandomGenerator;

public class Polynom {
    private int[] coefficients;

    public Polynom(int[] coefficients) {
        setCoefficients(coefficients);
    }

    public int[] getCoefficients() {
        return coefficients;
    }

    public void setCoefficients(int[] coefficients) {
        this.coefficients = coefficients;
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < coefficients.length; i++) {
            result += coefficients[i] + "x^" + (i + 1);
            if (i < coefficients.length - 1) { result += " + "; }
        }
        return result;
    }

    public static Polynom getPolynomSum(Polynom[] polynomials) {
        int maxLength = 0;

        for (Polynom polynom : polynomials) {
            for (int i = polynom.getCoefficients().length - 1; i >= 0; i--) {
                int polynomLength = polynom.getCoefficients().length;
                if (polynomLength > maxLength) {
                    maxLength = polynomLength;
                }
            }
        }
        Polynom result = new Polynom(new int[maxLength]);

        for (Polynom polynom : polynomials) {
            for (int i = polynom.getCoefficients().length - 1; i >= 0; i--) {
                result.coefficients[i] += polynom.getCoefficients()[i];
            }
        }

        return result;
    }

    public static void exampleForUsage() {
        Polynom[] polynomials = new Polynom[10];
        for (int i = 0; i < polynomials.length; i++) {
            int[] coefficients = new int[RandomGenerator.getDefault().nextInt(1, 10)];
            for (int j = 0; j < coefficients.length; j++) {
                coefficients[j] = RandomGenerator.getDefault().nextInt(0, 10);
            }
            polynomials[i] = new Polynom(coefficients);
            System.out.println("Полином " + (i + 1) + ": " + polynomials[i].toString());
        }
        Polynom polynomSum = getPolynomSum(polynomials);
        System.out.println(polynomSum.toString());
    }
}
