package ms.model.rn;

import ms.excessao.FuncionalidadeIndisponivelException;
import ms.model.dto.ConfiguraHibernateDTO;
import ms.util.ParserXML;

public class ConfiguraHibernateRN{
	
	private String servidor;
	private String porta;
	private String instanciaBanco;
	
	public void configuraHibernate(ConfiguraHibernateDTO configuracao) throws FuncionalidadeIndisponivelException {
		
		
			ParserXML parse = new ParserXML(configuracao.getCaminhoArquivo());
			parse.iniciaManipulacao();
			// Configura o tipo do banco
			String url = "";
			if (configuracao.getTipoBanco() == 0){
				url = "jdbc:oracle:thin:@SERVIDOR:PORTA:INSTANCIA";
				parse.setAtributo("property", "hibernate.connection.driver_class", "oracle.jdbc.driver.OracleDriver");
				parse.setAtributo("property", "hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
				parse.setAtributo("property", "default_schema", configuracao.getNomeBanco().toUpperCase());
			}
			if (configuracao.getTipoBanco() == 1){
				url = "jdbc:sqlserver://SERVIDOR:PORTA;DatabaseName=INSTANCIA;SelectMethod=direct";
				parse.setAtributo("property", "hibernate.connection.driver_class", "com.microsoft.sqlserver.jdbc.SQLServerDriver");
				parse.setAtributo("property", "hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
				parse.setAtributo("property", "default_schema", "dbo");
			}
			url = url.replaceAll("SERVIDOR", configuracao.getNomeHost());
			url = url.replaceAll("PORTA", configuracao.getPortaBanco());
			url = url.replaceAll("INSTANCIA", configuracao.getInstanciaBanco());
			
			
			parse.setAtributo("property", "hibernate.connection.url", url);
			parse.setAtributo("property", "hibernate.connection.username", configuracao.getUsuario());
			parse.setAtributo("property", "hibernate.connection.password", configuracao.getSenha());
			parse.setAtributo("property", "hibernate.connection.release_mode", "on_close");

			parse.finalizaManipulacao(configuracao.getTipoBanco());
		}
	
	public ConfiguraHibernateDTO recuperaConfiguracaoHibernate(String caminhoArquivo){
		ParserXML parse = new ParserXML(caminhoArquivo);
		ConfiguraHibernateDTO retorno = new ConfiguraHibernateDTO();
		try {
			parse.iniciaManipulacao();
			retorno.setUsuario(parse.getAtributo("property", "hibernate.connection.username"));
			retorno.setSenha(parse.getAtributo("property", "hibernate.connection.password"));
			retorno.setNomeBanco(parse.getAtributo("property", "default_schema"));
			
			if (verificaTipoBanco(parse.getAtributo("property", "hibernate.connection.url")) == 0){
				retorno.setTipoBanco(0);
				getValoresConfiguracaoOracle(retorno, parse.getAtributo("property", "hibernate.connection.url"));
			
			}else{
				retorno.setTipoBanco(1);
				getValoresConfiguracaoSQL(retorno,parse.getAtributo("property", "hibernate.connection.url") );
				
			}
			
			retorno.setNomeHost(servidor);
			retorno.setPortaBanco(porta);
			retorno.setInstanciaBanco(instanciaBanco);
		} catch (FuncionalidadeIndisponivelException e) {
		
			e.printStackTrace();
			retorno = null;
		}
		return retorno;
	}
	
	private int verificaTipoBanco(String valorAtributo){
		String temp = "";
		temp = valorAtributo.substring(valorAtributo.indexOf(":") + 1);
		temp = temp.substring(0,temp.indexOf(":"));
		if (temp.equals("oracle")){
			return 0;
		}else{
			return 1;
		}
	}
	
	private void getValoresConfiguracaoSQL(ConfiguraHibernateDTO retorno ,String valorAtributo){
		String temp = "";
           		
			temp = valorAtributo.substring(valorAtributo.indexOf("//") + 1);
			servidor = temp.substring(0, temp.indexOf(":"));
            temp = temp.substring(temp.indexOf(":") + 1);
            porta = temp.substring(0,temp.indexOf(";"));
            temp = temp.substring(0,temp.indexOf(";" + 1));
            instanciaBanco = temp.substring(temp.indexOf("DatabaseName=") + 1, temp.indexOf(";") );

	}
	
	private void getValoresConfiguracaoOracle(ConfiguraHibernateDTO retorno ,String valorAtributo){
		String temp = "";
           		
			temp = valorAtributo.substring(valorAtributo.indexOf("@")+1);
			
			servidor = temp.substring(0, temp.indexOf(":"));
            temp = temp.substring(temp.indexOf(":") + 1);
            porta = temp.substring(0,temp.indexOf(":"));
            instanciaBanco = temp.substring(temp.indexOf(":") + 1);
            
	}

}
