package moa;

import java.io.IOException;
import moa.clusterers.denstream.WithDBSCAN;
import moa.gui.BatchCmd;
import moa.streams.clustering.FileStream;

public class DenStream {
	
	public void run(int amountInstances, String stream, String out_file){
		FileStream file = new FileStream();
		file.arffFileOption.setValue(stream);
		file.restart();
		
		WithDBSCAN clusterer = new WithDBSCAN();
		clusterer.resetLearningImpl();
		
		boolean[] measureCollection = {false,true,false,true,true,true,true,true};
		
		BatchCmd.runBatch(file, clusterer, measureCollection, amountInstances, out_file);
	}
	
	public static void main(String[] args) throws IOException {
		// Arquivo de entrada
        String in_file = "datasets\\elecNormNew.arff";
		
		// Arquivo de saida
		String out_file = "teste2_resultado.csv";
	
        DenStream exp = new DenStream();
        exp.run(-1, in_file, out_file);	
	}
}
