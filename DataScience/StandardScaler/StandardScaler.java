public class StandardScaler {
    private double mean;
    private double stdDev;

    public double[] transform(double[] data) {
        mean = computeMean(data);
        stdDev = computeStdDev(data, mean);

        for (int i = 0; i < data.length; i++) {
            data[i] = (data[i] - mean) / stdDev;
        }
        return data;
    }

    private double computeMean(double[] data) {
        double sum = 0;
        for (double v : data) {
            sum += v;
        }
        return sum / data.length;
    }

    private double computeStdDev(double[] data, double mean) {
        double sum = 0;
        for (double v : data) {
            sum += Math.pow(v - mean, 2);
        }
        return Math.sqrt(sum / data.length);
    }
}
