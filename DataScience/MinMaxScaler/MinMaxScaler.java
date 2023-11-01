public class MinMaxScaler {
    private double min;
    private double max;

    public MinMaxScaler(double min, double max) {
        this.min = min;
        this.max = max;
    }

    public double[] transform(double[] data) {
        double dataMin = findMin(data);
        double dataMax = findMax(data);

        for (int i = 0; i < data.length; i++) {
            data[i] = (data[i] - dataMin) / (dataMax - dataMin) * (max - min) + min;
        }
        return data;
    }

    private double findMin(double[] data) {
        double minVal = data[0];
        for (double v : data) {
            if (v < minVal)
                minVal = v;
        }
        return minVal;
    }

    private double findMax(double[] data) {
        double maxVal = data[0];
        for (double v : data) {
            if (v > maxVal)
                maxVal = v;
        }
        return maxVal;
    }
}
