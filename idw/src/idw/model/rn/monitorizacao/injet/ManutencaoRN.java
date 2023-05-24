package idw.model.rn.monitorizacao.injet;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.rn.AbstractRN;
import idw.util.AritmeticaUtil;
import idw.webservices.rest.dto.monitorizacao.injet.manutencao.AcumTempoDispSemParManutDTO;
import idw.webservices.rest.dto.monitorizacao.injet.manutencao.AcumuladoManutencaoDTO;
import idw.webservices.rest.dto.monitorizacao.injet.manutencao.AcumuladosManutencaoDTO;
import idw.webservices.rest.dto.monitorizacao.injet.manutencao.AcumuladosTempoDispSemParManutDTO;
import idw.webservices.rest.dto.monitorizacao.injet.manutencao.CheckListDTO;
import idw.webservices.rest.dto.monitorizacao.injet.manutencao.CheckListsDTO;
import idw.webservices.rest.dto.monitorizacao.injet.manutencao.DetalheCheckListDTO;
import idw.webservices.rest.dto.monitorizacao.injet.manutencao.FerramentasDTO;
import idw.webservices.rest.dto.monitorizacao.injet.manutencao.FerramentaxProdutosDTO;
import idw.webservices.rest.dto.monitorizacao.injet.manutencao.FrequenciaCheckListDTO;
import idw.webservices.rest.dto.monitorizacao.injet.manutencao.FrequenciaManutDTO;
import idw.webservices.rest.dto.monitorizacao.injet.manutencao.FrequenciasManutDTO;
import idw.webservices.rest.dto.monitorizacao.injet.manutencao.ItemListaDTO;
import idw.webservices.rest.dto.monitorizacao.injet.manutencao.MaquinasDTO;
import idw.webservices.rest.dto.monitorizacao.injet.manutencao.MaquinasxFerramentasxProdutosDTO;
import idw.webservices.rest.dto.monitorizacao.injet.manutencao.MaquinaxFerramentasxProdutosDTO;
import idw.webservices.rest.dto.monitorizacao.injet.manutencao.ProdutoDTO;
import idw.webservices.rest.dto.monitorizacao.injet.manutencao.RecursosDTO;
import idw.webservices.rest.dto.monitorizacao.injet.manutencao.SetoresDTO;
import idw.webservices.rest.dto.monitorizacao.injet.manutencao.TarefaManutDTO;
import idw.webservices.rest.dto.monitorizacao.injet.manutencao.TarefasManutDTO;
import ms.util.ConversaoTipos;

public class ManutencaoRN extends AbstractRN<DAOGenericoInjet> {
	public ManutencaoRN() {
		super(new DAOGenericoInjet());
	}
	public ManutencaoRN(DAOGenericoInjet dao) {
		super(dao);
	}
	
	class TarefaAux {
		int sequencia;
		int nivel;
		int stObrigatorio;
		TarefaManutDTO tarefa;
		Map<String, TarefaAux> tarefasFilhas = new HashMap<String, TarefaAux>();
		String cdTarefaPai;
	}
	
	
	class CheckListAux {
		String cdCheckList;
		String dsCheckList;
		Map<String, TarefaAux> detalhe = new HashMap<String, TarefaAux>();
	}
	
	
	@SuppressWarnings("unchecked")
	public SetoresDTO getSetores() {
		SetoresDTO retorno = new SetoresDTO();
		retorno.setSetores(new ArrayList<ItemListaDTO>());
		
		int _codigo = 0;
		int _descricao = _codigo + 1;

		String strSQL = "";
		strSQL = strSQL.concat("SELECT a.cdsetor, a.dssetor");
		strSQL = strSQL.concat("  FROM ijtbset a");
		strSQL = strSQL.concat(" ORDER BY a.cdsetor");
		
		Object[] registroLido = null;
		List<Object> lista = this.getDaoSession().createSQLQuery(strSQL).list();
		
		for (Object regAux : lista) {
			ItemListaDTO registro = new ItemListaDTO();
			registroLido = null;
			Object registroLidoAux = (Object) regAux;
			registroLido = (Object[]) registroLidoAux;

			registro.setCdItem(((String) registroLido[_codigo]).trim());
			registro.setDsItem(((String) registroLido[_descricao]).trim());
			
			retorno.getSetores().add(registro);
		}

		return retorno;
	}

	@SuppressWarnings("unchecked")
	public MaquinasDTO getMaquinas() {
		MaquinasDTO retorno = new MaquinasDTO();
		retorno.setMaquinas(new ArrayList<ItemListaDTO>());
		
		int _codigo = 0;
		int _descricao = _codigo + 1;

		String strSQL = "";
		strSQL = strSQL.concat("SELECT a.cdinjestendido, a.cdidentific");
		strSQL = strSQL.concat("  FROM ijtbinj a");
		strSQL = strSQL.concat(" WHERE a.cdinjetora <> '999999'");	
		strSQL = strSQL.concat(" ORDER BY a.cdinjestendido");
		
		Object[] registroLido = null;
		List<Object> lista = this.getDaoSession().createSQLQuery(strSQL).list();
		
		for (Object regAux : lista) {
			ItemListaDTO registro = new ItemListaDTO();
			registroLido = null;
			Object registroLidoAux = (Object) regAux;
			registroLido = (Object[]) registroLidoAux;

			registro.setCdItem(((String) registroLido[_codigo]).trim());
			registro.setDsItem(((String) registroLido[_descricao]).trim());
			
			retorno.getMaquinas().add(registro);
		}
		
		return retorno;
	}
	
	@SuppressWarnings("unchecked")
	public FerramentasDTO getFerramentas() {
		FerramentasDTO retorno = new FerramentasDTO();	
		retorno.setFerramentas(new ArrayList<ItemListaDTO>());
		
		int _codigo = 0;
		int _descricao = _codigo + 1;

		String strSQL = "";
		strSQL = strSQL.concat("SELECT a.cdmolestendido, a.dsmolde");
		strSQL = strSQL.concat("  FROM ijtbmol a");
		strSQL = strSQL.concat(" WHERE a.cdmolde <> '999999'");	
		strSQL = strSQL.concat(" ORDER BY a.cdmolestendido");
		
		Object[] registroLido = null;
		List<Object> lista = this.getDaoSession().createSQLQuery(strSQL).list();
		
		for (Object regAux : lista) {
			ItemListaDTO registro = new ItemListaDTO();
			registroLido = null;
			Object registroLidoAux = (Object) regAux;
			registroLido = (Object[]) registroLidoAux;

			registro.setCdItem(((String) registroLido[_codigo]).trim());
			registro.setDsItem(((String) registroLido[_descricao]).trim());
			
			retorno.getFerramentas().add(registro);
		}
		
		return retorno;
	}
	
	@SuppressWarnings("unchecked")
	public RecursosDTO getRecursos() {
		RecursosDTO retorno = new RecursosDTO();	
		retorno.setRecursos(new ArrayList<ItemListaDTO>());
		
		int _codigo = 0;
		int _descricao = _codigo + 1;

		String strSQL = "";
		strSQL = strSQL.concat("SELECT a.cdrecman, a.dsrecman");
		strSQL = strSQL.concat("  FROM ijtbrecmanut a");
		strSQL = strSQL.concat(" ORDER BY a.cdrecman");
		
		Object[] registroLido = null;
		List<Object> lista = this.getDaoSession().createSQLQuery(strSQL).list();
		
		for (Object regAux : lista) {
			ItemListaDTO registro = new ItemListaDTO();
			registroLido = null;
			Object registroLidoAux = (Object) regAux;
			registroLido = (Object[]) registroLidoAux;

			registro.setCdItem(((String) registroLido[_codigo]).trim());
			registro.setDsItem(((String) registroLido[_descricao]).trim());
			
			retorno.getRecursos().add(registro);
		}
				
		return retorno;
	}
	
	@SuppressWarnings("unchecked")
	public MaquinasxFerramentasxProdutosDTO getMaquinasxFerramentasxProdutos() {		
		MaquinasxFerramentasxProdutosDTO retorno = new MaquinasxFerramentasxProdutosDTO();
		retorno.setMaquinasxFerramentasxProdutos(new ArrayList<MaquinaxFerramentasxProdutosDTO>());

		int _cdmaquina = 0;
		int _cdferramenta = _cdmaquina + 1;
		int _cdproduto = _cdferramenta + 1;
		int _dsproduto = _cdproduto + 1;

		class ProdutoAux {
			String cdProduto;
			String dsProduto;
		}
		
		class FerramentaAux {
			String cdFerramenta;
			Map<String, ProdutoAux> produtos = new HashMap<String, ProdutoAux>(); 
		}
		
		class MaquinaAux {
			String cdMaquina;
			Map<String, FerramentaAux> ferramentas = new HashMap<String, FerramentaAux>();
		}

		
		class RegistroLido {
			String cdMaquina;
			String cdFerramenta;
			String cdProduto;
			String dsProduto;
		}

		Map<String, MaquinaAux> mapMaq = new HashMap<String, MaquinaAux>();

		
		String strSQL = "";
		strSQL = strSQL.concat("SELECT DISTINCT c.cdinjestendido, d.cdmolestendido, b.cdproduto, e.dsproduto");
		strSQL = strSQL.concat("  FROM ijfictec a");
		strSQL = strSQL.concat("  JOIN ijmolpro b ON (b.cdmolde = a.cdmolde AND b.cdestrutura = a.cdestrutura AND b.dthrival = a.dthrivalestru)");
		strSQL = strSQL.concat("  JOIN ijtbinj  c ON (c.cdinjetora = a.cdinjetora)");
		strSQL = strSQL.concat("  JOIN ijtbmol  d ON (d.cdmolde = a.cdmolde)");
		strSQL = strSQL.concat("  JOIN ijtbpro  e ON (e.cdproduto = b.cdproduto)");
		strSQL = strSQL.concat(" WHERE a.cdinjetora <> '999999'");
		strSQL = strSQL.concat("   AND a.cdmolde <> '999999'");
		strSQL = strSQL.concat("   AND a.dthrfvalcic IS NULL");
		strSQL = strSQL.concat(" ORDER BY c.cdinjestendido, d.cdmolestendido, b.cdproduto");
		
		Object[] registroLido = null;
		List<Object> lista = this.getDaoSession().createSQLQuery(strSQL).list();
		
		for (Object regAux : lista) {
			RegistroLido registro = new RegistroLido();
			registroLido = null;
			Object registroLidoAux = (Object) regAux;
			registroLido = (Object[]) registroLidoAux;

			registro.cdMaquina = (((String) registroLido[_cdmaquina]).trim());
			registro.cdFerramenta = (((String) registroLido[_cdferramenta]).trim());
			registro.cdProduto = (((String) registroLido[_cdproduto]).trim());
			registro.dsProduto = (((String) registroLido[_dsproduto]).trim());
			
			ProdutoAux produto = new ProdutoAux();
			produto.cdProduto = registro.cdProduto;
			produto.dsProduto = registro.dsProduto;
			
			if (! mapMaq.containsKey(registro.cdMaquina)) {
				FerramentaAux ferr = new FerramentaAux();
				ferr.cdFerramenta = registro.cdFerramenta;
				ferr.produtos.put(registro.cdProduto, produto);
				
				MaquinaAux maq = new MaquinaAux();
				maq.cdMaquina = registro.cdMaquina;
				maq.ferramentas.put(registro.cdFerramenta, ferr);
				
				mapMaq.put(registro.cdMaquina, maq);
				
			} else {
				if (! mapMaq.get(registro.cdMaquina).ferramentas.containsKey(registro.cdFerramenta)) {
					FerramentaAux ferr = new FerramentaAux();
					ferr.cdFerramenta = registro.cdFerramenta;
					ferr.produtos.put(registro.cdProduto, produto);
					
					mapMaq.get(registro.cdMaquina).ferramentas.put(registro.cdFerramenta, ferr);
					
				} else {
					mapMaq.get(registro.cdMaquina).ferramentas.get(registro.cdFerramenta).produtos.put(registro.cdProduto, produto);
				}
			}
				
		}
		
		Set<String> keysMaq = mapMaq.keySet();		
		for (String kM : keysMaq) {
			MaquinaxFerramentasxProdutosDTO maq = new MaquinaxFerramentasxProdutosDTO();
			maq.setCdMaquina(mapMaq.get(kM).cdMaquina);
			maq.setFerramentaxProdutos(new ArrayList<FerramentaxProdutosDTO>());
			
			Set<String> keysFerr = mapMaq.get(kM).ferramentas.keySet();
			for (String kF : keysFerr) {
				FerramentaxProdutosDTO ferr = new FerramentaxProdutosDTO();
				ferr.setCdFerramenta(mapMaq.get(kM).ferramentas.get(kF).cdFerramenta);
				ferr.setProdutos(new ArrayList<ProdutoDTO>());
				
				Set<String> keysPro = mapMaq.get(kM).ferramentas.get(kF).produtos.keySet();
				for (String kP : keysPro) {
					ProdutoDTO produto = new ProdutoDTO();
					produto.setCdProduto(mapMaq.get(kM).ferramentas.get(kF).produtos.get(kP).cdProduto);
					produto.setDsProduto(mapMaq.get(kM).ferramentas.get(kF).produtos.get(kP).dsProduto);
					
					ferr.getProdutos().add(produto);
				}
							
				maq.getFerramentaxProdutos().add(ferr);
			}
			
			retorno.getMaquinasxFerramentasxProdutos().add(maq);
		}
		
		
		return retorno;
	}

	@SuppressWarnings("unchecked")
	public TarefasManutDTO getTarefas() {
		TarefasManutDTO retorno = new TarefasManutDTO();
		retorno.setTarefas(new ArrayList<TarefaManutDTO>());
		
		int _codigo = 0;
		int _descricao = _codigo + 1;
		int _sttarefa = _descricao + 1;

		String strSQL = "";
		strSQL = strSQL.concat("SELECT a.CdTarefa, a.DsTarefa, a.StTarefa");
		strSQL = strSQL.concat("  FROM IJMANUTtarefa a");
		strSQL = strSQL.concat(" ORDER BY a.CdTarefa");
		
		Object[] registroLido = null;
		List<Object> lista = this.getDaoSession().createSQLQuery(strSQL).list();
		
		for (Object regAux : lista) {
			TarefaManutDTO registro = new TarefaManutDTO();
			registroLido = null;
			Object registroLidoAux = (Object) regAux;
			registroLido = (Object[]) registroLidoAux;

			registro.setCdTarefa(((String) registroLido[_codigo]).trim());
			registro.setDsTarefa(((String) registroLido[_descricao]).trim());
			registro.setStTarefa(registroLido[_sttarefa] == null ? 0 : ConversaoTipos.converterParaBigDecimal(registroLido[_sttarefa]).intValue());
			
			retorno.getTarefas().add(registro);
		}
				
		return retorno;
	}
	
	@SuppressWarnings("unchecked")
	public CheckListsDTO getCheckLists() {
		CheckListsDTO retorno = new CheckListsDTO();	
		retorno.setCheckLists(new ArrayList<CheckListDTO>());
		
		int _cdchecklist = 0;
		int _dschecklist = _cdchecklist + 1;
		int _sequencia = _dschecklist + 1;
		int _nivel = _sequencia + 1;
		int _stobrigatoria = _nivel + 1;
		int _cdtarefa = _stobrigatoria + 1;
		int _dstarefa = _cdtarefa + 1;
		int _sttarefa = _dstarefa + 1;
		int _cdtarefapai = _sttarefa + 1;

		
		
		class RegistroLido {
			String cdCheckList;
			String dsCheckList;
			int sequencia;
			int nivel;
			int stObrigatorio;
			String cdTarefa;
			String dsTarefa;
			int stTarefa;
			String cdTarefaPai;
		}

		
		Map<String, CheckListAux> mapCheck = new HashMap<String, CheckListAux>();

		
		String strSQL = "";
		strSQL = strSQL.concat("SELECT a.cdchklst, a.dschklst, b.SeqItem, b.Nivel, b.StObrigatoria, c.CdTarefa, c.DsTarefa, c.StTarefa, d.CdTarefa as CdTarefaPai");
		strSQL = strSQL.concat("  FROM IJMANUTchklst a");
		strSQL = strSQL.concat("  JOIN IJMANUTchklstdet b ON (b.IdChkLst = a.IdChkLst)");
		strSQL = strSQL.concat("  JOIN IJMANUTtarefa c ON (c.IdTarefa = b.IdTarefa)");
		strSQL = strSQL.concat("  LEFT JOIN IJMANUTtarefa d ON (d.IdTarefa = b.IdTarefaPai)");
		strSQL = strSQL.concat(" WHERE a.DtFimVal IS NULL");
		strSQL = strSQL.concat(" ORDER BY a.cdchklst, b.Nivel, b.SeqItem");
		
		Object[] registroLido = null;
		List<Object> lista = this.getDaoSession().createSQLQuery(strSQL).list();
		
		for (Object regAux : lista) {
			RegistroLido registro = new RegistroLido();
			registroLido = null;
			Object registroLidoAux = (Object) regAux;
			registroLido = (Object[]) registroLidoAux;

			registro.cdCheckList = (((String) registroLido[_cdchecklist]).trim());
			registro.dsCheckList = (((String) registroLido[_dschecklist]).trim());
			registro.nivel = ConversaoTipos.converterParaBigDecimal(registroLido[_nivel]).intValue();
			registro.sequencia = ConversaoTipos.converterParaBigDecimal(registroLido[_sequencia]).intValue();
			registro.stObrigatorio = ConversaoTipos.converterParaBigDecimal(registroLido[_stobrigatoria]).intValue();
			registro.cdTarefa = (((String) registroLido[_cdtarefa]).trim());
			registro.dsTarefa = (((String) registroLido[_dstarefa]).trim());
			registro.stTarefa = ConversaoTipos.converterParaBigDecimal(registroLido[_sttarefa]).intValue();
			if (registroLido[_cdtarefapai] != null) {
				registro.cdTarefaPai = (((String) registroLido[_cdtarefapai]).trim());
			} else {
				registro.cdTarefaPai = "";
			}
				
			TarefaAux det = new TarefaAux();
			det.tarefa = new TarefaManutDTO();
			det.nivel = registro.nivel;
			det.sequencia = registro.sequencia;
			det.stObrigatorio = registro.stObrigatorio;
			det.tarefa.setCdTarefa(registro.cdTarefa);
			det.tarefa.setDsTarefa(registro.dsTarefa);
			det.tarefa.setStTarefa(registro.stTarefa);
			det.tarefasFilhas = new HashMap<String, TarefaAux>();
			det.cdTarefaPai = registro.cdTarefaPai;

			CheckListAux checklist = new CheckListAux();
			checklist.cdCheckList = registro.cdCheckList;
			checklist.dsCheckList = registro.dsCheckList;

			if (! mapCheck.containsKey(registro.cdCheckList)) {				
				checklist.detalhe.put(det.tarefa.getCdTarefa(), det);				
				mapCheck.put(registro.cdCheckList, checklist);				
			} else {
				checklist = mapCheck.get(registro.cdCheckList);
				if (registro.nivel == 1) {
					checklist.detalhe.put(det.tarefa.getCdTarefa(), det);				
					mapCheck.put(registro.cdCheckList, checklist);									
				} else {
					// procura e adiciona sub tarefa
					
					checklist.detalhe = adicionaFilha(checklist.detalhe, det);
					mapCheck.put(registro.cdCheckList, checklist);
				}
			}				
		}
		
		Set<String> keysCheck = mapCheck.keySet();
		for (String keyCheck : keysCheck) {
			CheckListDTO check = new CheckListDTO();
			check.setCdCheckList(mapCheck.get(keyCheck).cdCheckList);
			check.setDsCheckList(mapCheck.get(keyCheck).dsCheckList);
			check.setDetalhesCheckList(new ArrayList<DetalheCheckListDTO>());
			check.setDetalhesCheckList(getListTarefas(check.getDetalhesCheckList(), mapCheck.get(keyCheck).detalhe));
			retorno.getCheckLists().add(check);
		}
		
		return retorno;
	}
	
	private List<DetalheCheckListDTO> getListTarefas(List<DetalheCheckListDTO> retorno, Map<String, TarefaAux> tarefas) {
		Set<String> keysTarefa = tarefas.keySet();
		for (String keyTarefa : keysTarefa) {
			TarefaAux tarefaAux = tarefas.get(keyTarefa);
			
			DetalheCheckListDTO det = new DetalheCheckListDTO();
			det.setNivel(tarefaAux.nivel);
			det.setSequencia(tarefaAux.sequencia);
			det.setStObrigatorio(tarefaAux.stObrigatorio);
			det.setTarefa(new TarefaManutDTO());
			det.getTarefa().setCdTarefa(tarefaAux.tarefa.getCdTarefa());
			det.getTarefa().setDsTarefa(tarefaAux.tarefa.getDsTarefa());
			det.getTarefa().setStTarefa(tarefaAux.tarefa.getStTarefa());
			det.setTarefasFilhas(new ArrayList<DetalheCheckListDTO>());
			
			if (tarefaAux.tarefasFilhas.size() > 0) {
				det.setTarefasFilhas(getListTarefas(det.getTarefasFilhas(), tarefaAux.tarefasFilhas));	
			}
			
			retorno.add(det);
		}		
		
		return retorno;
	}
	
	
	private Map<String, TarefaAux> adicionaFilha(Map<String, TarefaAux> tarefas, TarefaAux filha) {
		Set<String> keysTarefa = tarefas.keySet();
		for (String keyTarefa : keysTarefa) {			
			if (tarefas.get(keyTarefa).tarefa.getCdTarefa().equals(filha.cdTarefaPai)) {
				tarefas.get(keyTarefa).tarefasFilhas.put(filha.tarefa.getCdTarefa(), filha);
				break;
			} else {
				if (tarefas.get(keyTarefa).tarefasFilhas.size() > 0) {				
					tarefas.get(keyTarefa).tarefasFilhas = adicionaFilha(tarefas.get(keyTarefa).tarefasFilhas, filha);
				}
			}
		}
		return tarefas;
	}

	
	
	@SuppressWarnings("unchecked")
	public FrequenciasManutDTO getFreqManutPrevMaq() {
		FrequenciasManutDTO retorno = new FrequenciasManutDTO();	
		retorno.setFrequencias(new ArrayList<FrequenciaManutDTO>());
		
		BigDecimal DIAS_SEMANA = new BigDecimal(7);
		BigDecimal DIAS_ANO = new BigDecimal(365);
		BigDecimal MULTIPLICAO_DIAS = new BigDecimal(86400);
		BigDecimal MULTIPLICACAO_SEMANAS = AritmeticaUtil.multiplicar(DIAS_SEMANA, MULTIPLICAO_DIAS);
		BigDecimal MULTIPLICACAO_MESES = AritmeticaUtil.multiplicar(DIAS_ANO, MULTIPLICAO_DIAS);
		
		int _cdmaq = 0;
		int _cdchecklist = _cdmaq + 1;
		int _tpfreq = _cdchecklist + 1;
		int _vlrfreq = _tpfreq + 1;
		int _stativo = _vlrfreq + 1;

		class RegistroLido {
			String cdRecurso;
			String cdCheckList;
			int tipoFrequencia;
			BigDecimal valorFrequencia = BigDecimal.ZERO;
			int stAtivo;			
		}
		
		String strSQL = "";
		strSQL = strSQL.concat("SELECT b.cdinjestendido, a.CdChkLst, a.TpFreqManut, a.VlrFreq, a.ativo as stativo");
		strSQL = strSQL.concat("  FROM ijfreqmanutprev a");
		strSQL = strSQL.concat("  JOIN ijtbinj b ON (RTRIM(b.cdinjetora) = RTRIM(a.IdRecurso)) ");
		strSQL = strSQL.concat(" WHERE a.TpRecurso = '01' ");	
		strSQL = strSQL.concat(" ORDER BY b.cdinjestendido, a.CdChkLst");
		
		Map<String, FrequenciaManutDTO> mapRec = new HashMap<String, FrequenciaManutDTO>();
		
		Object[] registroLido = null;
		List<Object> lista = this.getDaoSession().createSQLQuery(strSQL).list();
		
		for (Object regAux : lista) {
			RegistroLido registro = new RegistroLido();
			registroLido = null;
			Object registroLidoAux = (Object) regAux;
			registroLido = (Object[]) registroLidoAux;

			registro.cdRecurso = ((String) registroLido[_cdmaq]).trim();
			registro.cdCheckList = ((String) registroLido[_cdchecklist]).trim();
			registro.tipoFrequencia = ConversaoTipos.converterParaBigDecimal(registroLido[_tpfreq]).intValue();
			registro.valorFrequencia = ConversaoTipos.converterParaBigDecimal(registroLido[_vlrfreq]);
			registro.stAtivo = ConversaoTipos.converterParaBigDecimal(registroLido[_stativo]).intValue();
			
			if (registro.tipoFrequencia == 3) {
				// frequencias definida no Injet em dias
				registro.tipoFrequencia = 1;
				registro.valorFrequencia = AritmeticaUtil.multiplicar(registro.valorFrequencia, MULTIPLICAO_DIAS);
			}

			if (registro.tipoFrequencia == 4) {
				// frequencias definida no Injet em semanas
				registro.tipoFrequencia = 1;
				registro.valorFrequencia = AritmeticaUtil.multiplicar(registro.valorFrequencia, MULTIPLICACAO_SEMANAS);
			}

			if (registro.tipoFrequencia == 5) {
				// frequencias definida no Injet em meses
				registro.tipoFrequencia = 1;
				registro.valorFrequencia = AritmeticaUtil.multiplicar(registro.valorFrequencia, MULTIPLICACAO_MESES);
			}

			FrequenciaManutDTO freqRec = new FrequenciaManutDTO();
			freqRec.setCdRecurso(registro.cdRecurso);
			freqRec.setFrequencias(new ArrayList<FrequenciaCheckListDTO>());
			FrequenciaCheckListDTO frequencia = new FrequenciaCheckListDTO();
			frequencia.setCdCheckList(registro.cdCheckList);
			frequencia.setTipoFrequencia(registro.tipoFrequencia);
			frequencia.setValorFrequencia(registro.valorFrequencia);
			frequencia.setStAtivo(registro.stAtivo);			
			freqRec.getFrequencias().add(frequencia);
			
			
			if (! mapRec.containsKey(registro.cdRecurso)) {
				mapRec.put(registro.cdRecurso, freqRec);
			} else {
				mapRec.get(registro.cdRecurso).getFrequencias().add(frequencia);
			}
			
		}
		
		Set<String> keysRec = mapRec.keySet();
		for (String keyRec : keysRec) {
			FrequenciaManutDTO freqRec = new FrequenciaManutDTO();
			freqRec.setCdRecurso(mapRec.get(keyRec).getCdRecurso());
			freqRec.setFrequencias(mapRec.get(keyRec).getFrequencias());			
			retorno.getFrequencias().add(freqRec);
		}
		
		return retorno;
	}
	
	@SuppressWarnings("unchecked")
	public FrequenciasManutDTO getFreqManutPrevFerr() {
		FrequenciasManutDTO retorno = new FrequenciasManutDTO();	
		retorno.setFrequencias(new ArrayList<FrequenciaManutDTO>());
		
		BigDecimal DIAS_SEMANA = new BigDecimal(7);
		BigDecimal DIAS_ANO = new BigDecimal(365);
		BigDecimal MULTIPLICAO_DIAS = new BigDecimal(86400);
		BigDecimal MULTIPLICACAO_SEMANAS = AritmeticaUtil.multiplicar(DIAS_SEMANA, MULTIPLICAO_DIAS);
		BigDecimal MULTIPLICACAO_MESES = AritmeticaUtil.multiplicar(DIAS_ANO, MULTIPLICAO_DIAS);
		
		int _cdmaq = 0;
		int _cdchecklist = _cdmaq + 1;
		int _tpfreq = _cdchecklist + 1;
		int _vlrfreq = _tpfreq + 1;
		int _stativo = _vlrfreq + 1;

		class RegistroLido {
			String cdRecurso;
			String cdCheckList;
			int tipoFrequencia;
			BigDecimal valorFrequencia = BigDecimal.ZERO;
			int stAtivo;			
		}
		
		String strSQL = "";
		strSQL = strSQL.concat("SELECT b.cdmolestendido, a.CdChkLst, a.TpFreqManut, a.VlrFreq, a.ativo as stativo");
		strSQL = strSQL.concat("  FROM ijfreqmanutprev a");
		strSQL = strSQL.concat("  JOIN ijtbmol b ON (RTRIM(b.cdmolde) = RTRIM(a.IdRecurso)) ");
		strSQL = strSQL.concat(" WHERE a.TpRecurso = '02' ");	
		strSQL = strSQL.concat(" ORDER BY b.cdmolestendido, a.CdChkLst");
		
		Map<String, FrequenciaManutDTO> mapRec = new HashMap<String, FrequenciaManutDTO>();
		
		Object[] registroLido = null;
		List<Object> lista = this.getDaoSession().createSQLQuery(strSQL).list();
		
		for (Object regAux : lista) {
			RegistroLido registro = new RegistroLido();
			registroLido = null;
			Object registroLidoAux = (Object) regAux;
			registroLido = (Object[]) registroLidoAux;

			registro.cdRecurso = ((String) registroLido[_cdmaq]).trim();
			registro.cdCheckList = ((String) registroLido[_cdchecklist]).trim();
			registro.tipoFrequencia = ConversaoTipos.converterParaBigDecimal(registroLido[_tpfreq]).intValue();
			registro.valorFrequencia = ConversaoTipos.converterParaBigDecimal(registroLido[_vlrfreq]);
			registro.stAtivo = ConversaoTipos.converterParaBigDecimal(registroLido[_stativo]).intValue();
			
			if (registro.tipoFrequencia == 3) {
				// frequencias definida no Injet em dias
				registro.tipoFrequencia = 1;
				registro.valorFrequencia = AritmeticaUtil.multiplicar(registro.valorFrequencia, MULTIPLICAO_DIAS);
			}

			if (registro.tipoFrequencia == 4) {
				// frequencias definida no Injet em semanas
				registro.tipoFrequencia = 1;
				registro.valorFrequencia = AritmeticaUtil.multiplicar(registro.valorFrequencia, MULTIPLICACAO_SEMANAS);
			}

			if (registro.tipoFrequencia == 5) {
				// frequencias definida no Injet em meses
				registro.tipoFrequencia = 1;
				registro.valorFrequencia = AritmeticaUtil.multiplicar(registro.valorFrequencia, MULTIPLICACAO_MESES);
			}

			FrequenciaManutDTO freqRec = new FrequenciaManutDTO();
			freqRec.setCdRecurso(registro.cdRecurso);
			freqRec.setFrequencias(new ArrayList<FrequenciaCheckListDTO>());
			FrequenciaCheckListDTO frequencia = new FrequenciaCheckListDTO();
			frequencia.setCdCheckList(registro.cdCheckList);
			frequencia.setTipoFrequencia(registro.tipoFrequencia);
			frequencia.setValorFrequencia(registro.valorFrequencia);
			frequencia.setStAtivo(registro.stAtivo);			
			freqRec.getFrequencias().add(frequencia);
			
			
			if (! mapRec.containsKey(registro.cdRecurso)) {
				mapRec.put(registro.cdRecurso, freqRec);
			} else {
				mapRec.get(registro.cdRecurso).getFrequencias().add(frequencia);
			}
			
		}
		
		Set<String> keysRec = mapRec.keySet();
		for (String keyRec : keysRec) {
			FrequenciaManutDTO freqRec = new FrequenciaManutDTO();
			freqRec.setCdRecurso(mapRec.get(keyRec).getCdRecurso());
			freqRec.setFrequencias(mapRec.get(keyRec).getFrequencias());			
			retorno.getFrequencias().add(freqRec);
		}
		
		return retorno;
	}		

	@SuppressWarnings("unchecked")
	public AcumuladosManutencaoDTO getAcumCicloTempoMaq() {
		AcumuladosManutencaoDTO retorno = new AcumuladosManutencaoDTO();		
		retorno.setAcumulados(new ArrayList<AcumuladoManutencaoDTO>());

		int _cdmaq = 0;
		int _qtdcic = _cdmaq + 1;
		int _tmpcic = _qtdcic + 1;
		
		String strSQL = "";
		strSQL = strSQL.concat("SELECT b.cdinjestendido, ");
		strSQL = strSQL.concat("       SUM(a.qtinjnormal + a.qtinjnaparada + a.qtinjfinparada) as qtdciclos, ");
		strSQL = strSQL.concat("       SUM(a.tmpcicnormal + a.tmpcicfinparada + a.tmpcicnaparada) as tmpciclos ");
		strSQL = strSQL.concat("  FROM ijcnsmaqop a");
		strSQL = strSQL.concat("  JOIN ijtbinj b ON (b.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat(" GROUP BY b.cdinjestendido");	
		strSQL = strSQL.concat(" ORDER BY b.cdinjestendido");
		
		Object[] registroLido = null;
		List<Object> lista = this.getDaoSession().createSQLQuery(strSQL).list();
		
		for (Object regAux : lista) {
			AcumuladoManutencaoDTO registro = new AcumuladoManutencaoDTO();
			registroLido = null;
			Object registroLidoAux = (Object) regAux;
			registroLido = (Object[]) registroLidoAux;

			registro.setCdRecurso(((String) registroLido[_cdmaq]).trim());
			registro.setQtdCicExec(ConversaoTipos.converterParaBigDecimal(registroLido[_qtdcic]));
			registro.setHrsTrabEmSeg(ConversaoTipos.converterParaBigDecimal(registroLido[_tmpcic]));

			retorno.getAcumulados().add(registro);
		}

		return retorno;
	}

	@SuppressWarnings("unchecked")
	public AcumuladosManutencaoDTO getAcumCicloTempoFerr() {
		AcumuladosManutencaoDTO retorno = new AcumuladosManutencaoDTO();	
		retorno.setAcumulados(new ArrayList<AcumuladoManutencaoDTO>());

		int _cdferr = 0;
		int _qtdcic = _cdferr + 1;
		int _tmpcic = _qtdcic + 1;
		
		String strSQL = "";
		strSQL = strSQL.concat("SELECT b.cdmolestendido, ");
		strSQL = strSQL.concat("       SUM(a.qtinjnormal + a.qtinjnaparada + a.qtinjfinparada) as qtdciclos, ");
		strSQL = strSQL.concat("       SUM(a.tmpcicnormal + a.tmpcicfinparada + a.tmpcicnaparada) as tmpciclos ");
		strSQL = strSQL.concat("  FROM ijcnsmaqop a");
		strSQL = strSQL.concat("  JOIN ijtbmol b ON (b.cdmolde = a.cdmolde) ");
		strSQL = strSQL.concat(" GROUP BY b.cdmolestendido");	
		strSQL = strSQL.concat(" ORDER BY b.cdmolestendido");
		
		Object[] registroLido = null;
		List<Object> lista = this.getDaoSession().createSQLQuery(strSQL).list();
		
		for (Object regAux : lista) {
			AcumuladoManutencaoDTO registro = new AcumuladoManutencaoDTO();
			registroLido = null;
			Object registroLidoAux = (Object) regAux;
			registroLido = (Object[]) registroLidoAux;

			registro.setCdRecurso(((String) registroLido[_cdferr]).trim());
			registro.setQtdCicExec(ConversaoTipos.converterParaBigDecimal(registroLido[_qtdcic]));
			registro.setHrsTrabEmSeg(ConversaoTipos.converterParaBigDecimal(registroLido[_tmpcic]));

			retorno.getAcumulados().add(registro);
		}
		
		return retorno;
	}
	
	@SuppressWarnings("unchecked")
	public AcumuladosTempoDispSemParManutDTO getAcumTempoDispSemManutMaq() {
		AcumuladosTempoDispSemParManutDTO retorno = new AcumuladosTempoDispSemParManutDTO();
		retorno.setAcumulados(new ArrayList<AcumTempoDispSemParManutDTO>());
		
		int _cdmaq = 0;
		int _tmpsemmtbf = _cdmaq + 1;
		
		String strSQL = "";
		strSQL = strSQL.concat("SELECT b.cdinjestendido, (a.tmpativo - (CASE WHEN  c.tmpparNaoMTBF IS NULL THEN 0 ELSE c.tmpparNaoMTBF END)) as tmpdispSemMTBF ");
		strSQL = strSQL.concat("  FROM ( ");
		strSQL = strSQL.concat("        SELECT a.cdinjetora, ");
		strSQL = strSQL.concat("               SUM( (a.tmpcicnormal    + (CASE WHEN ct.Campo29 = '±¿²' THEN 0 ELSE a.ctcp END)) +  ");
		strSQL = strSQL.concat("                    (a.tmpcicfinparada + (CASE WHEN ct.Campo29 = '±¿²' THEN 0 ELSE a.ctci END)) +  ");
		strSQL = strSQL.concat("                    (a.tmpparadas)) as tmpativo");
		strSQL = strSQL.concat("          FROM ijcnsmaqop a ");
		strSQL = strSQL.concat("          LEFT JOIN IJtbFRESH ct ON (1=1) ");
		strSQL = strSQL.concat("         GROUP BY a.cdinjetora) a ");
		strSQL = strSQL.concat("  JOIN ijtbinj b ON (b.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat("  LEFT JOIN ( ");
		strSQL = strSQL.concat("             SELECT a.cdinjetora, ");
		strSQL = strSQL.concat("                    SUM(a.tmpparadas + a.tmpparadassempeso) as tmpparNaoMTBF ");
		strSQL = strSQL.concat("               FROM ijreaparcnsTUR a ");
		strSQL = strSQL.concat("               JOIN ijtbpar b ON (b.cdparada = a.cdparada AND b.CalcMTBFMTTR = '0') ");
		strSQL = strSQL.concat("               GROUP BY a.cdinjetora) c ON (c.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat(" ORDER BY b.cdinjestendido");

		
		Object[] registroLido = null;
		List<Object> lista = this.getDaoSession().createSQLQuery(strSQL).list();
		
		for (Object regAux : lista) {
			AcumTempoDispSemParManutDTO registro = new AcumTempoDispSemParManutDTO();
			registroLido = null;
			Object registroLidoAux = (Object) regAux;
			registroLido = (Object[]) registroLidoAux;

			registro.setCdRecurso(((String) registroLido[_cdmaq]).trim());
			registro.setTempo(ConversaoTipos.converterParaBigDecimal(registroLido[_tmpsemmtbf]));

			retorno.getAcumulados().add(registro);
		}
		
		return retorno;
	}

	@SuppressWarnings("unchecked")
	public AcumuladosTempoDispSemParManutDTO getAcumTempoDispSemManutFerr() {
		AcumuladosTempoDispSemParManutDTO retorno = new AcumuladosTempoDispSemParManutDTO();
		retorno.setAcumulados(new ArrayList<AcumTempoDispSemParManutDTO>());
		
		int _cdferr = 0;
		int _tmpsemmtbf = _cdferr + 1;
		
		String strSQL = "";
		strSQL = strSQL.concat("SELECT b.cdmolestendido, (a.tmpativo - (CASE WHEN  c.tmpparNaoMTBF IS NULL THEN 0 ELSE c.tmpparNaoMTBF END)) as tmpdispSemMTBF ");
		strSQL = strSQL.concat("  FROM ( ");
		strSQL = strSQL.concat("        SELECT a.cdmolde, ");
		strSQL = strSQL.concat("               SUM( (a.tmpcicnormal    + (CASE WHEN ct.Campo29 = '±¿²' THEN 0 ELSE a.ctcp END)) +  ");
		strSQL = strSQL.concat("                    (a.tmpcicfinparada + (CASE WHEN ct.Campo29 = '±¿²' THEN 0 ELSE a.ctci END)) +  ");
		strSQL = strSQL.concat("                    (a.tmpparadas)) as tmpativo");
		strSQL = strSQL.concat("          FROM ijcnsmaqop a ");
		strSQL = strSQL.concat("          LEFT JOIN IJtbFRESH ct ON (1=1) ");
		strSQL = strSQL.concat("         GROUP BY a.cdmolde) a ");
		strSQL = strSQL.concat("  JOIN ijtbmol b ON (b.cdmolde = a.cdmolde) ");
		strSQL = strSQL.concat("  LEFT JOIN ( ");
		strSQL = strSQL.concat("             SELECT a.cdmolde, ");
		strSQL = strSQL.concat("                    SUM(a.tmpparadas + a.tmpparadassempeso) as tmpparNaoMTBF ");
		strSQL = strSQL.concat("               FROM ijreaparcnsTUR a ");
		strSQL = strSQL.concat("               JOIN ijtbpar b ON (b.cdparada = a.cdparada AND b.CalcMTBFMTTR = '0') ");
		strSQL = strSQL.concat("               GROUP BY a.cdmolde) c ON (c.cdmolde = a.cdmolde) ");
		strSQL = strSQL.concat(" ORDER BY b.cdmolestendido");

		
		Object[] registroLido = null;
		List<Object> lista = this.getDaoSession().createSQLQuery(strSQL).list();
		
		for (Object regAux : lista) {
			AcumTempoDispSemParManutDTO registro = new AcumTempoDispSemParManutDTO();
			registroLido = null;
			Object registroLidoAux = (Object) regAux;
			registroLido = (Object[]) registroLidoAux;

			registro.setCdRecurso(((String) registroLido[_cdferr]).trim());
			registro.setTempo(ConversaoTipos.converterParaBigDecimal(registroLido[_tmpsemmtbf]));

			retorno.getAcumulados().add(registro);
		}
				
		return retorno;
	}
}
