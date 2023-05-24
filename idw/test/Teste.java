import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Teste {

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\alessandre\\temporario\\todosmev.txt"))) {
 
			String sCurrentLine;
 
			while ((sCurrentLine = br.readLine()) != null) {
				if (sCurrentLine.contains("board end") && sCurrentLine.contains("Stage No2"))
					System.out.println(sCurrentLine);
			}
 
		} catch (IOException e) {
			e.printStackTrace();
		} 
 
	}
}
