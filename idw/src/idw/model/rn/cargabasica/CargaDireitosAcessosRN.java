package idw.model.rn.cargabasica;

import java.util.HashMap;
import java.util.Map;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.dao.SqlServerIdentityInsertToggle;
import idw.model.pojos.OmResgui;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;

public class CargaDireitosAcessosRN extends AbstractRN<DAOGenerico>{

	private MapQuery q;
	private Map<Integer, String> descricoes = new HashMap<Integer, String>();
	
	public CargaDireitosAcessosRN(DAOGenerico dao) {
		super(dao);
	}
	
	public void carrega(){
		// Inicializa consulta
		q = new MapQuery(getDaoSession());
		q.append("from OmResgui omresgui");
		q.append("where omresgui = :omresgui");
		
		
		// Inicializa vetor com direitos de acesso
		descricoes.put(1, "M�dulo - Engenharia de processo");
		descricoes.put(2, "CLP - Alimenta��o materia-prima");
		descricoes.put(3, "Menu - Mapa de Alimenta��o");
		descricoes.put(4, "Menu - Consulta de Alimenta��es");
		descricoes.put(5, "Menu - Importa��o de componentes DE-PARA");
		descricoes.put(6, "Menu - Importa��o de programas");
		descricoes.put(7, "Menu - Gerencia usu�rios - Todos os grupos");
		descricoes.put(8, "Menu - Gerencia usu�rios - Grupo de Usu�rios");
		descricoes.put(9, "Menu - Grupo de Trabalho");
		descricoes.put(10, "Menu - Fornecedor");
		descricoes.put(11, "Menu - Produto");
		descricoes.put(12, "Menu - Posto de trabalho");
		descricoes.put(13, "M�dulo - Monitoriza��o em tempo real");
		descricoes.put(14, "Site - Exporta��o para o CVS");
		descricoes.put(15, "Site - Emiss�o relat�rio gerencial");
		descricoes.put(16, "Site - M�dulo web");
		descricoes.put(17, "Menu - Lay-out monitoriza��o");
		descricoes.put(18, "Menu - Plataforma");
		descricoes.put(19, "Menu - Par�metro de testes");
		descricoes.put(20, "Menu - Etapas e sub-etapas de testes");
		descricoes.put(21, "Menu - Folha de processo");
		descricoes.put(22, "Menu - Roteiro de produ��o");
		descricoes.put(23, "Menu - Gerencia de usu�rios - Engenharia");
		descricoes.put(24, "Menu - Gerencia de usu�rios - Gerencial");
		descricoes.put(25, "Menu - Gerencia de usu�rios - Manuten��o");
		descricoes.put(26, "Menu - Gerencia de usu�rios - Metrologia");
		descricoes.put(27, "Menu - Gerencia de usu�rios - Montagem");
		descricoes.put(28, "Menu - Turnos");
		descricoes.put(29, "Menu - Tabela de defeitos");
		descricoes.put(30, "Menu - Tabela de a��o");
		descricoes.put(31, "Menu - Calend�rio");
		descricoes.put(32, "Menu - Ger�ncia usu�rios - Supervis�o");
		descricoes.put(33, "M�dulo - Planejamento produ��o");
		
		descricoes.put(39, "Menu - Configura��o - Geral");
		descricoes.put(40, "Menu - Configura��o - Geral - Aba coletores");
		descricoes.put(41, "Menu - Configura��o - Geral - Aba coletores - Barra ferramenta");
				
		descricoes.put(42, "CLP - Pr�-confer�ncia");
		
		// Inicializa pojos
		SqlServerIdentityInsertToggle toggle = new SqlServerIdentityInsertToggle("om_resgui");
		toggle.setIdentityInsertOn(true);
		toggle.execute(getDao());
		
		for (Integer id : descricoes.keySet()){
			OmResgui resgui = new OmResgui();
			resgui.setRevisao(1l);
			resgui.setDtRevisao(DataHoraRN.getDataHoraAtual());
			resgui.setDtStativo(DataHoraRN.getDataHoraAtual());
			resgui.setStAtivo((byte) 1);

			resgui.setIdResgui((long) id);
			resgui.setDsResgui(descricoes.get(id));
			
			inserirSeNaoExistir(resgui);
		}
		
		toggle.setIdentityInsertOn(false);
		toggle.execute(getDao());
	}
	
	public void inserirSeNaoExistir(OmResgui resgui){
		q.defineParametro("omresgui", resgui);
		if (q.isExists() == false) {
			resgui.setCdResgui(String.valueOf(resgui.getIdResgui()));
			getDao().makePersistent(resgui);
			getDao().flushReiniciandoTransacao();
		}
	}

}
