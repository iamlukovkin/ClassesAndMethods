public class Line {
    private double slopeCoefficient;
    private double yIntercept;

    public Line(double slopeCoefficient, double yIntercept) {
        setSlopeCoefficient(slopeCoefficient);
        setyIntercept(yIntercept);
    }

    public double getyIntercept() {
        return yIntercept;
    }

    public void setyIntercept(double yIntercept) {
        this.yIntercept = yIntercept;
    }

    public double getSlopeCoefficient() { return slopeCoefficient; }

    public void setSlopeCoefficient(double slopeCoefficient) {
        this.slopeCoefficient = slopeCoefficient;
    }

    public String toString() {
        return "y = " + slopeCoefficient + "x + " + yIntercept;
    }

    public double[] getIntersectionX() {
        double[] result = new double[2];
        result[0] = -yIntercept / slopeCoefficient;   // x = -b / k
        result[1] = 0;
        return result;
    }

    private double[] getIntersectionY() {
        double[] result = new double[2];
        result[0] = 0;
        result[1] = getyIntercept();     // y = b
        return result;
    }
    private double[][] getIntersectionWithAxis() {
        double[][] result = new double[2][2];
        result[0] = getIntersectionX();
        result[1] = getIntersectionY();
        return result;
    }

    public double[] getIntersectionTwoLines(Line line2) {
        double[] result = new double[2];
        // x = (b2 - b1) / (k1 - k2)
        result[0] = (line2.getyIntercept() - yIntercept) / (slopeCoefficient - line2.getSlopeCoefficient());
        // y = k1 * x + b1
        result[1] = slopeCoefficient * result[0] + yIntercept;
        return result;
    }

    public static void exampleForUsage() {
        Line line = new Line(2, 3);
        System.out.println(line);
        double[][] linesIntersection = line.getIntersectionWithAxis();
        System.out.println("Прямая пересекает ось X в точке (" + linesIntersection[0][0] + ", 0) и ось Y в точке (0, " + linesIntersection[1][1] + ")");
        Line line2 = new Line(3, 2);
        double[] linesIntersection2 = line.getIntersectionTwoLines(line2);
        System.out.println("Прямая" + line2 + " пересекает прямую " + line + " в точке (" + linesIntersection2[0] + ", " + linesIntersection2[1] + ")");

    }
}
