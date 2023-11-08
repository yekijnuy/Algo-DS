import weka.classifiers.functions.Logistic;
import weka.core.Instances;
import java.io.BufferedReader;
import java.io.FileReader;

public class LogisticRegressionExample {
    public static void main(String[] args) throws Exception {
        // Load dataset
        BufferedReader datafile = new BufferedReader(new FileReader("yourdata.arff"));
        Instances data = new Instances(datafile);

        // Build logistic regression model
        data.setClassIndex(data.numAttributes() - 1);
        Logistic model = new Logistic();
        model.buildClassifier(data);

        // Output the model
        System.out.println(model);
    }
}
