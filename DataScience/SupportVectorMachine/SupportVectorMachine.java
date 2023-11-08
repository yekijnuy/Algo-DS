import weka.classifiers.functions.SMO;
import weka.core.Instances;
import java.io.BufferedReader;
import java.io.FileReader;

public class SVMExample {
    public static void main(String[] args) throws Exception {
        // Load dataset
        BufferedReader datafile = new BufferedReader(new FileReader("yourdata.arff"));
        Instances data = new Instances(datafile);

        // Set class index to the last attribute
        data.setClassIndex(data.numAttributes() - 1);

        // Build SVM model
        SMO svm = new SMO();
        svm.buildClassifier(data);

        // Output the model
        System.out.println(svm);
    }
}
