import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.lazy.IBk;

public class KNNExample {
    public static void main(String[] args) throws Exception {
        // Load dataset
        DataSource source = new DataSource("yourdata.arff");
        Instances data = source.getDataSet();

        // Setting class attribute if the data format does not provide this information
        if (data.classIndex() == -1)
            data.setClassIndex(data.numAttributes() - 1);

        // Initialize the k-NN classifier (IBk in Weka) with k=3 for example
        IBk knn = new IBk(3);

        // Build the classifier
        knn.buildClassifier(data);

        // Output the classifier
        System.out.println(knn);
    }
}
