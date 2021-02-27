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
		
		boolean[] measureCollection = { false, true, false, true, true, true, true, true };
		
		BatchCmd.runBatch(file, clusterer, measureCollection, amountInstances, out_file);
	}
	
	public static void main(String[] args) throws IOException {
		// fazer amanha: olhar o member ship da matriz 
		// e fazer os testes pra ver se esta calculando certo a pureza inversa
		// pelos resultados está saindo errado
		


		// Nome do arquivo
        String file = "dados_artificiais";
		
		// Arquivo de entrada (caminho)
		String input = "datasets\\" + file + ".arff";
		
		// Arquivo de saida (caminho)
		String output = "results\\DenStream_" + file;
	
        DenStream exp = new DenStream();
        exp.run(-1, input, output);	
	}
}
