package baseDatos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

public class Serializador {
	private static File ruta = new File("src\\basedatos\\temp");
	
	public static void serializar(/* Clase principal(Main)*/ ) {
		FileOutputStream fos;
		ObjectOutputStream oos;
		File[] docs = ruta.listFiles();
		PrintWriter pw;
		
		for (File file: docs) {
			try {
				pw = new PrintWriter(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		for(File file: docs) {
			if(file.getAbsolutePath().contains("barcos")) {
				/*try {
					fos = new FileOutputStream(file);
					oos = new ObjectOutputStream(fos);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}*/
			}
		}
	}

}
