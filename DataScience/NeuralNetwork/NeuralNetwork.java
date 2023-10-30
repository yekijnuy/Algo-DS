import org.deeplearning4j.datasets.iterator.impl.MnistDataSetIterator;
import org.deeplearning4j.nn.api.OptimizationAlgorithm;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.layers.DenseLayer;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.nn.weights.WeightInit;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.lossfunctions.LossFunctions;

public class NeuralNetworkExample {
    public static void main(String[] args) throws Exception {
        // Configure neural network
        MultiLayerNetwork model = new MultiLayerNetwork(new NeuralNetConfiguration.Builder()
                .weightInit(WeightInit.XAVIER)
                .activation(Activation.RELU)
                .optimizationAlgo(OptimizationAlgorithm.STOCHASTIC_GRADIENT_DESCENT)
                .list()
                .layer(0, new DenseLayer.Builder().nIn(784).nOut(256).build())
                .layer(1, new OutputLayer.Builder(LossFunctions.LossFunction.NEGATIVELOGLIKELIHOOD)
                        .nIn(256).nOut(10).activation(Activation.SOFTMAX).build())
                .build());

        model.init();

        // Load dataset
        MnistDataSetIterator mnistTrain = new MnistDataSetIterator(128, true, 12345);
        while (mnistTrain.hasNext()) {
            DataSet batch = mnistTrain.next();
            model.fit(batch);
        }

        System.out.println("Training completed.");
    }
}
