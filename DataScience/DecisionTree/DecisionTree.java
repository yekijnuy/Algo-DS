import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.trees.J48;

public class DecisionTreeExample {
    public static void main(String[] args) throws Exception {
        // Load dataset
        DataSource source = new DataSource("path_to_dataset.arff");
        Instances dataset = source.getDataSet();
        dataset.setClassIndex(dataset.numAttributes() - 1);

        // Train decision tree model
        J48 tree = new J48();
        tree.buildClassifier(dataset);

        System.out.println(tree);
    }
}
