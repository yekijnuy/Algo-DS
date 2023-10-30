import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.functions.LinearRegression;

public class LinearRegressionExample {
    public static void main(String[] args) throws Exception {
        // Load dataset
        DataSource source = new DataSource("path_to_dataset.arff");
        Instances dataset = source.getDataSet();
        dataset.setClassIndex(dataset.numAttributes() - 1);

        // Train linear regression model
        LinearRegression lr = new LinearRegression();
        lr.buildClassifier(dataset);

        System.out.println(lr);
    }
}
