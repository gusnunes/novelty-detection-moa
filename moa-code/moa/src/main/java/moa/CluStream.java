package moa;

import java.io.IOException;
import java.net.URISyntaxException;

import moa.clusterers.clustream.WithKmeans;
import moa.gui.BatchCmd;
import moa.streams.clustering.FileStream;

public class CluStream {

	public void run(int numInstances, String stream, String out_file, int k) {
		// setar o arquivo arff para stream
		FileStream file = new FileStream();
		file.arffFileOption.setValue(stream);

		file.restart();

		// setar o valor k de grupos
		WithKmeans clusterer = new WithKmeans();
		clusterer.kOption.setValue(k);
		clusterer.resetLearningImpl();

		// escolher quais grupos de medidas serão usadas
		boolean[] measureCollection = { false, true, false, true, true, true, true, true };

		// -1 indica que não tem um limite
		int amountInstances = numInstances;

		// executa a tarefa
		BatchCmd.runBatch(file, clusterer, measureCollection, amountInstances, out_file);
	}

	public static void main(String[] args) throws IOException, URISyntaxException {
		// Arquivo de entrada
        String in_file = "moa\\datasets\\airlines.arff";
		
		// Arquivo de saida
		String out_file = "moa\\resultados\\CluStream_airlines.csv";
	
        int k = 5;		
        CluStream exp = new CluStream();
        exp.run(-1, in_file, out_file,k);
     	
        /*
		//Variar o valor de k do CluStream
        while(k < 13) {
        	out_covtype = "C:\\Users\\Dennis Nunes\\Documents\\danilo\\IC\\clustream" + k + ".csv";
			exp.run(-1, covtype, out_covtype,k);
			
			k++;
			
		}*/
	}
}