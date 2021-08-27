package app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Files {
	
	public void leituraDeArquivo(String path, ArrayList arrayList) {
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String line = br.readLine();
			while(line != null) {
				arrayList.add(line);
				line = br.readLine();
			}
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	public void escreveArquivo(String path, ArrayList arrayList, String content) {
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String line = br.readLine();
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){
				if(br.readLine() == null) {
					bw.write(content);
				}
				else {
					bw.newLine();
					bw.write(content);
				}
			}
			
			catch(IOException e) {
				System.out.println(e.getMessage());
			}
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	public boolean contem(String path, String content) {
		boolean contem = false;
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String line = br.readLine();
			while(contem == false && line != null) {
				contem = line.contains(content);
				line = br.readLine();
			}
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		return contem;
	}
	public String mostrarSenha(String content) {
		String path = "C:\\Users\\Daniel\\Desktop\\Lab1\\Lab1Project\\src\\app\\users.txt";
		boolean contem = false;
		String auxLine = "aux";
		String line = "";
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			line = br.readLine();
			while(contem == false && line != null) {
				contem = line.contains(content);
				auxLine = line;
				line = br.readLine();
			}
				line = auxLine.substring(content.length() + 1);
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		return line;
	}
}
