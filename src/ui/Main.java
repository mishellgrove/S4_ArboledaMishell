package ui;
import java.io.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String line = br.readLine();
		int n = Integer.parseInt(line);
		for(int i =0;i<n;i++){
			line = br.readLine();
			String[] datos = line.split(" ");
			double[] edades = new double[datos.length];
			for(int j=0;j<datos.length;j++){
				edades[j] = Double.parseDouble(datos[j]);
			}
			//bubble algorithm
			double intercambios = 0;
			for ( int j = 0;j < edades.length; j++){
				for (int k = 0; k < edades.length-1; k++){
					if (edades[k]>edades[k+1]){
						intercambios++;
						double temp = edades[k];
						edades[k]= edades[k+1];
						edades[k+1] = temp;
					}
				}
			}
			double promedio = intercambios/(edades.length-1);
			String edadesOrdenadas = ""+edades[0];
			for(int j=1;j<edades.length;j++){
				edadesOrdenadas += " "+edades[j];
			}
			DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
			separadoresPersonalizados.setDecimalSeparator('.');
			DecimalFormat df = new DecimalFormat("#.0#",separadoresPersonalizados);
			df.setRoundingMode(RoundingMode.DOWN);
			System.out.println(""+df.format(promedio)+"-"+edadesOrdenadas);
		}
		br.close();
	}
}