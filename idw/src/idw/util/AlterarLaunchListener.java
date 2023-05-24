package idw.util;


import idw.model.IdwFacade;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import javax.management.AttributeNotFoundException;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.Query;
import javax.management.ReflectionException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
//import org.apache.catalina.ServerFactory;

public class AlterarLaunchListener implements ServletContextListener {

	private File arquivo;
	private FileWriter arquivonovo;

	private IdwLogger log = new IdwLogger("Configlauncherjnlp");
	private List<String> listaAdress = new ArrayList<String>();

	public static List<String> listaJnlps = new ArrayList<String>();

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// este metodo tem q estar aqui
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		log.info("INICIO ALTERACAO DO ARQUIVO launch.jnlp");
		String hostname = "";
		int porta = getServerPorta();
		listaJnlps = new ArrayList<String>();

		try {
			hostname = InetAddress.getLocalHost().getHostName();
			log.info("hostname " + hostname);
			listaAdress.add(hostname);
		} catch (UnknownHostException e) {
			log.info("UnknownHostException", e);
		}
		
		try {
			// Obtem o nome do servidor
			// pega as interfaces de redes
			Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces();
			log.info("Tem interfaces? " + e.hasMoreElements());
			while (e.hasMoreElements()) {
				NetworkInterface i = (NetworkInterface) e.nextElement();
				Enumeration<InetAddress> ds = i.getInetAddresses();
				while (ds.hasMoreElements()) {

					InetAddress myself = (InetAddress) ds.nextElement();
					if (!myself.isLoopbackAddress()) {

						if (!myself.getHostAddress().contains(":")) {
							listaAdress.add(myself.getHostAddress());
						}

						log.info("hostname: " + myself.getHostName() + " IP: "
								+ myself.getHostAddress() + " Linklocal: "
								+ myself.isLinkLocalAddress() + " sitelocal: "
								+ myself.isSiteLocalAddress() + " Anylocal:  "
								+ myself.isAnyLocalAddress() + " mcglobal:"
								+ myself.isMCGlobal());
					}
				}
			}

			// Obtem o Ip do Servidor
			// ip = InetAddress.getLocalHost().getHostAddress();

		} catch (SocketException e1) {
			log.info("SocketException", e1);
		}
		// TODO: Senoj
		// Esta é uma soulçao paleativa ao problema de resolução de nome do
		// ambiente WHP
		if (hostname.equals("rcl-saappp3"))
			hostname = "10.12.96.136"; // Endereço Servidor INJET WHPRC Produção
		if (hostname.equals("TI11239"))
			hostname = "10.12.102.100"; // Endereço Servidor INJET WHPRC QA

		// Aqui esta sendo adicionado o caminho do ms para acessar diversos
		// arquivos
		// MsFacade.getInstancia().setCaminhoRelativo(arg0.getServletContext().getRealPath(""));

		log.info("server info :" + arg0.getServletContext().getServerInfo());

		log.info("porta do Tomcat:" + porta);
		// arquivo = new
		// File("C:\\crysthian\\projetos\\ms\\eclipse\\ms\\WebContent\\jws\\launch.jnlp");
		log.info("Qtde de enderecos: " + listaAdress.size());
		for (String endereco : listaAdress) {
			try {
				log.info("Abrindo jws/launch.jnlp");
				
				arquivo = new File(arg0.getServletContext().getRealPath("jws/launch.jnlp"));

				log.info("Real Path: " + arg0.getServletContext().getRealPath("jws/launch.jnlp"));

				String linha = null;
				// File nfile = new File(arg0)
				arquivonovo = new FileWriter(arg0.getServletContext().getRealPath("jws/launch" + endereco + ".jnlp"));
				listaJnlps.add("jws/launch" + endereco + ".jnlp");
				// arquivonovo = new BufferedWriter(new FileWriter(new
				// File(arg0.getServletContext().getRealPath("jws/launch" +
				// endereco +".jnlp"))));

				// arquivonovo.flush();

				FileReader fileReader = new FileReader(arquivo.getAbsolutePath());
				BufferedReader leitor = new BufferedReader(fileReader);
				Vector<String> linhas = new Vector<String>();
				linha = leitor.readLine();
				boolean isUrl = false;
				while (linha != null) {

					if (linha.contains("codebase=")) {
						StringBuilder aux = new StringBuilder();
						aux.append("<jnlp spec=\"1.0+\" codebase=\"http://");
						aux.append(endereco);
						aux.append(":");
						aux.append(porta);
						aux.append("/idw/jws");
						aux.append("\"");
						aux.append(" href=\"launch");
						aux.append(endereco);
						aux.append(".jnlp\">");
						
						linha = aux.toString();

					}

					if (linha.contains("<homepage href=")) {
						linha = "<homepage href=\"http://" + endereco + ":" + porta + "/idw";
					}
					

					if (linha.contains("<argument>-url</argument>")) {
						isUrl = true;
					}
					if (linha.contains("<argument>-wellcome</argument>")) {
						isUrl = false;
					}
					if (linha.contains("<argument>-background</argument>")) {
						isUrl = false;
					}
					if (linha.contains("<argument>-icone</argument>")) {
						isUrl = false;
					}
						
					if (linha.contains("<argument>") && !linha.contains("<argument>-") && isUrl) {
						linha = "<argument>" + endereco + ":" + porta + "/idw</argument>";
					}
					log.info(linha);
					linhas.add(linha + "\n");
					linha = leitor.readLine();
				}
				leitor.close();
				fileReader.close();
				FileWriter writer = new FileWriter(arquivo);
				BufferedWriter escritor = new BufferedWriter(writer);
				// BufferedWriter escritornovo = new
				// BufferedWriter(arquivonovo);
				for (String line : linhas) {
					escritor.write(line);
					arquivonovo.write(line);
				}
				arquivonovo.close();
				escritor.close();
			} catch (FileNotFoundException e) {
				log.info("Erro, arquivo não encontrado", e);
				e.printStackTrace();
			} catch (IOException e) {
				log.info("Erro de I/O", e);
			} catch (Exception e) {
				log.info("erro generico", e);
			} finally {
				log.info("FIM ALTERACAO DO ARQUIVO launch.jnlp");
			}
		}		
		
		if (Boolean.parseBoolean(arg0.getServletContext().getInitParameter("IDWAtivo")) == true) {
            IdwFacade.IS_IDW_ATIVO = true;
        } else {
        	IdwFacade.IS_IDW_ATIVO = false;
        }

		try {
			IdwFacade.TEMPO_EM_SEGUNDOS_REFRESH_MATERIALIZED_VIEW_BI = Integer.parseInt(arg0.getServletContext().getInitParameter("RefreshMaterializedViewBI"));			
		} catch (Exception e) {
			IdwFacade.TEMPO_EM_SEGUNDOS_REFRESH_MATERIALIZED_VIEW_BI = 0;
		}
		
		log.info("Saida do alteralaunch");
	}

	
	private int getServerPorta() {
		int retorno = 8080;
		
		try {
			retorno = Integer.valueOf(
					getEndPoints().get(1)
					);
		} catch (Exception e) {
			retorno = 8080;
		}
		
		return retorno;
	}
		
	
	private List<String> getEndPoints() throws MalformedObjectNameException, NullPointerException, UnknownHostException, AttributeNotFoundException, InstanceNotFoundException, MBeanException, ReflectionException {
		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
		Set<ObjectName> objs = mbs.queryNames(new ObjectName("*:type=Connector,*"), Query.match(Query.attr("protocol"), Query.value("HTTP/1.1")));
		
		String hostname = InetAddress.getLocalHost().getHostName();
		InetAddress[] addresses = InetAddress.getAllByName(hostname);
		ArrayList<String> endPoints = new ArrayList<String>();
		for (Iterator<ObjectName> i = objs.iterator(); i.hasNext();) {
			ObjectName obj = i.next();
			//String scheme = mbs.getAttribute(obj, "scheme").toString();
			String port = obj.getKeyProperty("port");
			for (InetAddress addr : addresses) {
				String host = addr.getHostAddress();
				//String ep = scheme + "://" + host + ":" + port;
				endPoints.add(host);
				endPoints.add(port);
				break;
			}
		}
		return endPoints;
	}

}
