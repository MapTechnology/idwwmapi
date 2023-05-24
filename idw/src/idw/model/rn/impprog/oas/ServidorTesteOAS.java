package idw.model.rn.impprog.oas;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTesteOAS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ServerSocket servidor = null;

		try {
			servidor = new ServerSocket(81);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Socket socket = null;

		try {
			socket = servidor.accept();
		} catch (Exception e) {
			e.printStackTrace();
		}

		DataInputStream canalEntrada = null;
		DataOutputStream canalSaida = null;

		try {
			canalEntrada = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			canalSaida = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}

		int k = 0;

		try {
			k = canalEntrada.readInt();
			//System.out.println("Valor de k = " + k);
		} catch (IOException e2) {
			e2.printStackTrace();
		}

		// Entrega setups
		if (k == 1001){
			String mensagem = "";
			mensagem += "GetSetups\n";
			mensagem += "In:	Line_PLB\n";
			mensagem += "Out:	\n";
			mensagem += "<?xml version=" + (char) 34 + "1.0" + (char) 34 + " encoding=" + (char) 34 + "windows-1252" + (char) 34 + "?>\n";
			mensagem += "<Setups>\n";
			mensagem += "<Setup Name=" + (char) 34 + "CDSP-DH-B1B-BOT" + (char) 34 + " JobName=" + (char) 34 + "CDSP-DH-B1B-BOT" + (char) 34 + " LineName=" + (char) 34 + "LINE_PLB" + (char) 34 + "/>\n";
			mensagem += "<Setup Name=" + (char) 34 + "CDSP-DH-B1B-TOP" + (char) 34 + " JobName=" + (char) 34 + "CDSP-DH-B1B-TOP" + (char) 34 + " LineName=" + (char) 34 + "LINE_PLB" + (char) 34 + "/>\n";
			mensagem += "<Setup Name=" + (char) 34 + "DSPC-BOT-A" + (char) 34 + " JobName=" + (char) 34 + "DSPC-BOT-A" + (char) 34 + " LineName=" + (char) 34 + "LINE_PLB" + (char) 34 + "/>\n";
			mensagem += "<Setup Name=" + (char) 34 + "DSPC-C-BOT-A" + (char) 34 + " JobName=" + (char) 34 + "DSPC-C-BOT-A" + (char) 34 + " LineName=" + (char) 34 + "LINE_PLB" + (char) 34 + "/>\n";
			mensagem += "<Setup Name=" + (char) 34 + "DSPC-C-TOP-A" + (char) 34 + " JobName=" + (char) 34 + "DSPC-C-TOP-A" + (char) 34 + " LineName=" + (char) 34 + "LINE_PLB" + (char) 34 + "/>\n";
			mensagem += "<Setup Name=" + (char) 34 + "DSPC-TOP-A" + (char) 34 + " JobName=" + (char) 34 + "DSPC-TOP-A" + (char) 34 + " LineName=" + (char) 34 + "LINE_PLB" + (char) 34 + "/>\n";
			mensagem += "<Setup Name=" + (char) 34 + "IW16P1A-BOT-A" + (char) 34 + " JobName=" + (char) 34 + "IW16P1A-BOT-A" + (char) 34 + " LineName=" + (char) 34 + "LINE_PLB" + (char) 34 + "/>\n";
			mensagem += "<Setup Name=" + (char) 34 + "IW16P1A-TOP-A" + (char) 34 + " JobName=" + (char) 34 + "IW16P1A-TOP-A" + (char) 34 + " LineName=" + (char) 34 + "LINE_PLB" + (char) 34 + "/>\n";
			mensagem += "<Setup Name=" + (char) 34 + "MBIF-B-BOT-B" + (char) 34 + " JobName=" + (char) 34 + "MBIF-B-BOT-B" + (char) 34 + " LineName=" + (char) 34 + "LINE_PLB" + (char) 34 + "/>\n";
			mensagem += "<Setup Name=" + (char) 34 + "MBIF-B-TOP-B" + (char) 34 + " JobName=" + (char) 34 + "MBIF-B-TOP-B" + (char) 34 + " LineName=" + (char) 34 + "LINE_PLB" + (char) 34 + "/>\n";
			mensagem += "<Setup Name=" + (char) 34 + "MBIF-C-K04-BOT-A" + (char) 34 + " JobName=" + (char) 34 + "MBIF-C-K04-BOT-A" + (char) 34 + " LineName=" + (char) 34 + "LINE_PLB" + (char) 34 + "/>\n";
			mensagem += "<Setup Name=" + (char) 34 + "MBIF-C-K04-TOP-A" + (char) 34 + " JobName=" + (char) 34 + "MBIF-C-K04-TOP-A" + (char) 34 + " LineName=" + (char) 34 + "LINE_PLB" + (char) 34 + "/>\n";
			mensagem += "<Setup Name=" + (char) 34 + "MBIF-CR-M04-BOT-A" + (char) 34 + " JobName=" + (char) 34 + "MBIF-CR-M04-BOT-A" + (char) 34 + " LineName=" + (char) 34 + "LINE_PLB" + (char) 34 + "/>\n";
			mensagem += "<Setup Name=" + (char) 34 + "MBIF-CR-M04-TOP-A" + (char) 34 + " JobName=" + (char) 34 + "MBIF-CR-M04-TOP-A" + (char) 34 + " LineName=" + (char) 34 + "LINE_PLB" + (char) 34 + "/>\n";
			mensagem += "<Setup Name=" + (char) 34 + "PCU-B-BOT-B" + (char) 34 + " JobName=" + (char) 34 + "PCU-B-BOT-B" + (char) 34 + " LineName=" + (char) 34 + "LINE_PLB" + (char) 34 + "/>\n";
			mensagem += "<Setup Name=" + (char) 34 + "PCU-B-TOP-B" + (char) 34 + " JobName=" + (char) 34 + "PCU-B-TOP-B" + (char) 34 + " LineName=" + (char) 34 + "LINE_PLB" + (char) 34 + "/>\n";
			mensagem += "<Setup Name=" + (char) 34 + "PCU2-D-BOT-B" + (char) 34 + " JobName=" + (char) 34 + "PCU2-D-BOT-B" + (char) 34 + " LineName=" + (char) 34 + "LINE_PLB" + (char) 34 + "/>\n";
			mensagem += "<Setup Name=" + (char) 34 + "PCU2-D-TOP-B" + (char) 34 + " JobName=" + (char) 34 + "PCU2-D-TOP-B" + (char) 34 + " LineName=" + (char) 34 + "LINE_PLB" + (char) 34 + "/>\n";
			mensagem += "<Setup Name=" + (char) 34 + "SW128B-BOT-A" + (char) 34 + " JobName=" + (char) 34 + "SW128B-BOT-A" + (char) 34 + " LineName=" + (char) 34 + "LINE_PLB" + (char) 34 + "/>\n";
			mensagem += "<Setup Name=" + (char) 34 + "SW128B-TOP-A" + (char) 34 + " JobName=" + (char) 34 + "SW128B-TOP-A" + (char) 34 + " LineName=" + (char) 34 + "LINE_PLB" + (char) 34 + "/>\n";
			mensagem += "<Setup Name=" + (char) 34 + "SW256B-BOT-A" + (char) 34 + " JobName=" + (char) 34 + "SW256B-BOT-A" + (char) 34 + " LineName=" + (char) 34 + "LINE_PLB" + (char) 34 + "/>\n";
			mensagem += "<Setup Name=" + (char) 34 + "SW256B-TOP-A" + (char) 34 + " JobName=" + (char) 34 + "SW256B-TOP-A" + (char) 34 + " LineName=" + (char) 34 + "LINE_PLB" + (char) 34 + "/>\n";
			mensagem += "<Setup Name=" + (char) 34 + "SW64B-BOT-A" + (char) 34 + " JobName=" + (char) 34 + "SW64B-BOT-A" + (char) 34 + " LineName=" + (char) 34 + "LINE_PLB" + (char) 34 + "/>\n";
			mensagem += "<Setup Name=" + (char) 34 + "SW64B-TOP-A" + (char) 34 + " JobName=" + (char) 34 + "SW64B-TOP-A" + (char) 34 + " LineName=" + (char) 34 + "LINE_PLB" + (char) 34 + "/>\n";
			mensagem += "<Setup Name=" + (char) 34 + "SWC-BOT-A" + (char) 34 + " JobName=" + (char) 34 + "SWC-BOT-A" + (char) 34 + " LineName=" + (char) 34 + "LINE_PLB" + (char) 34 + "/>\n";
			mensagem += "<Setup Name=" + (char) 34 + "SWC-TOP-A" + (char) 34 + " JobName=" + (char) 34 + "SWC-TOP-A" + (char) 34 + " LineName=" + (char) 34 + "LINE_PLB" + (char) 34 + "/>\n";
			mensagem += "<Setup Name=" + (char) 34 + "SWP-BOT-A" + (char) 34 + " JobName=" + (char) 34 + "SWP-BOT-A" + (char) 34 + " LineName=" + (char) 34 + "LINE_PLB" + (char) 34 + "/>\n";
			mensagem += "<Setup Name=" + (char) 34 + "SWP-TOP-A" + (char) 34 + " JobName=" + (char) 34 + "SWP-TOP-A" + (char) 34 + " LineName=" + (char) 34 + "LINE_PLB" + (char) 34 + "/>\n";
			mensagem += "<Setup Name=" + (char) 34 + "TR5561A-BOT-A" + (char) 34 + " JobName=" + (char) 34 + "TR5561A-BOT-A" + (char) 34 + " LineName=" + (char) 34 + "LINE_PLB" + (char) 34 + "/>\n";
			mensagem += "<Setup Name=" + (char) 34 + "TR5561A-TOP-A" + (char) 34 + " JobName=" + (char) 34 + "TR5561A-TOP-A" + (char) 34 + " LineName=" + (char) 34 + "LINE_PLB" + (char) 34 + "/>\n";
			mensagem += "<Setup Name=" + (char) 34 + "TR5561E-BOT-A" + (char) 34 + " JobName=" + (char) 34 + "TR5561E-BOT-A" + (char) 34 + " LineName=" + (char) 34 + "LINE_PLB" + (char) 34 + "/>\n";
			mensagem += "<Setup Name=" + (char) 34 + "TR5561E-TOP-A" + (char) 34 + " JobName=" + (char) 34 + "TR5561E-TOP-A" + (char) 34 + " LineName=" + (char) 34 + "LINE_PLB" + (char) 34 + "/>\n";
			mensagem += "</Setups>\n";

			try {
				canalSaida.writeUTF(mensagem);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		try {
			canalEntrada.close();
			canalSaida.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
