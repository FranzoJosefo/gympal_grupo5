package edu.uade.gympal.backend.db;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class GsonDataBase {

	private GsonDataBase() {
	}

	public static <T> void grabarBulk(List<T> list, String fileName) {
		File archivo = new File(fileName);
		FileWriter fileWriter;
		BufferedWriter bwEscritor;
		String texto;
		Gson g = new Gson();
		texto = g.toJson(list);
		// grabo el String
		try {
			// Este bloque de codigo obligatoriamente debe ir dentro de un try.
			fileWriter = new FileWriter(archivo);
			fileWriter.write(texto);
			bwEscritor = new BufferedWriter(fileWriter);
			bwEscritor.close();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}

	public static <T> List<T> leerBulk(Class<T> dtoClass, String fileName) {
		List<T> dtos = new ArrayList<T>();
		String cadena;
		File archivo = new File(fileName);
		if (archivo.exists()) {
			FileReader f;
			try {
				f = new FileReader(archivo);
				BufferedReader b = new BufferedReader(f);
				cadena = b.readLine();
				//System.out.println(cadena);
				JsonParser parser = new JsonParser();
				JsonArray gsonArr = parser.parse(cadena).getAsJsonArray();
				Gson g = new Gson();
				for (JsonElement js : gsonArr) // System.out.println(js.toString());
					dtos.add((T) g.fromJson(js, dtoClass));

				b.close();

				// for(Object o : aux)
				// scores.add((Score) o);
				return dtos;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return dtos;
	}

}
