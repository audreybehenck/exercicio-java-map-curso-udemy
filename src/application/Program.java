package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		
		Map<String, Integer> votos = new HashMap<>();

		System.out.println("Digite o caminho completo do arquivo: ");
		String path = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {


			
			String line = br.readLine();
			while (line != null) {
				
				String[] fields = line.split(",");
				String candidato = fields[0]; 
				Integer qntVotos = Integer.parseInt(fields[1]);
				line = br.readLine();
				
				
				
				if (votos.containsKey(candidato)) {
					int votosAteAgora = votos.get(candidato);
					votos.put(candidato, qntVotos + votosAteAgora);
				}
				else {
					votos.put(candidato, qntVotos);
				}
			}
			
			for (String key : votos.keySet()) {
				System.out.println(key + ": " + votos.get(key));
			}
			
		} 
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

			sc.close();
		}
}