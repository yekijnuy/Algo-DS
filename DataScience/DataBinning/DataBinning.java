public class DataBinning {

    public int[] transform(double[] data, int bins) {
        double min = findMin(data);
        double max = findMax(data);
        double interval = (max - min) / bins;
        int[] binnedData = new int[data.length];

        for (int i = 0; i < data.length; i++) {
            binnedData[i] = (int) ((data[i] - min) / interval);
            if (binnedData[i] == bins)
                binnedData[i]--;
        }
        return binnedData;
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
