package idw.model.rn.impprog.erp;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.json.JSONObject;

import br.com.pst.scam.server.presentation.web.endpoint.ProgramacaoWSProxy;
import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.OmPrg;
import idw.model.pojos.OmPrgpos;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.impprog.IImportaProgramaRN;
import idw.util.IdwLogger;
import idw.util.UtilsString;
import idw.webservices.dto.ProgramaInsersoraDTO;
import idw.webservices.dto.ProgramasInsersorasDTO;
import ms.util.UtilsThreads;

public class ImportaProgramaErpPstRN extends AbstractRN<DAOGenerico>  implements IImportaProgramaRN{

	public ImportaProgramaErpPstRN(){
		super(new DAOGenerico());
		//servico = new ProgramacaoWSService(this.urlWebService, qnameWebService);
	}
	
	public ImportaProgramaErpPstRN(DAOGenerico dao) {
		super(dao);
	}

	
	/*
	 * (non-Javadoc)
	 * @see idw.model.rn.impprog.IImportaProgramaRN#getProgramasInsersorasDTO(idw.model.pojos.OmPt)
	 * Obtem a lista de programas do pt. Com base nessa lista a integracao ir� decidir se atualiza ou nao os programas e mapas de alimentacao.
	 */
	@Override
	public ProgramasInsersorasDTO getProgramasInsersorasDTO(OmPt ompt) {
		IdwLogger log = new IdwLogger(ompt.getCdPt() + "importaProgramaPst");
		int idLog = log.getIdAleatorio();
		
		ProgramasInsersorasDTO retorno = new ProgramasInsersorasDTO();
		
		retorno.setCdPt(ompt.getCdPt());
		retorno.setDepara(ompt.getDepara());
		retorno.setIdPt(ompt.getIdPt());
		
		ProgramacaoWSProxy ws = new ProgramacaoWSProxy();
		
		String  mensagemformatojson = null;

		//mensagemformatojson = "{" + (char) 34 + "status" + (char) 34 + ":" + (char) 34 + "sucesso" + (char) 34 + "," + (char) 34 + "mensagem" + (char) 34 + ":" + (char) 34 + "sucesso.programacao.consulta.programacaoencontrada" + (char) 34 + ", " + (char) 34 + "programacao6280" + (char) 34 + ":" + (char) 34 + "[[Produto=025884000][ID Programacao=6280][Produto=025884000]]" + (char) 34 + ", " + (char) 34 + "programacao6773" + (char) 34 + ":" + (char) 34 + "[[Produto=025869000][ID Programacao=6773][Produto=025869000]]" + (char) 34 + ", " + (char) 34 + "programacao7194" + (char) 34 + ":" + (char) 34 + "[[Produto=026507100][ID Programacao=7194][Produto=026507100]]" + (char) 34 + "," + (char) 34 + "programacao7999" + (char) 34 + ":" + (char) 34 + "[[Produto=026663100][ID Programacao=7999][Produto=026663100]]" + (char) 34 + ", " + (char) 34 + "programacao8126" + (char) 34 + ":" + (char) 34 + "[[Produto=026648100][ID Programacao=8126][Produto=026648100]]" + (char) 34 + ", " + (char) 34 + "programacao8192" + (char) 34 + ":" + (char) 34 + "[[Produto=026653100][ID Programacao=8192][Produto=026653100]]" + (char) 34 + ", " + (char) 34 + "programacao8207" + (char) 34 + ":" + (char) 34 + "[[Produto=026664100][ID Programacao=8207][Produto=026664100]]" + (char) 34 + ", " + (char) 34 + "programacao8740" + (char) 34 + ":" + (char) 34 + "[[Produto=026716100][ID Programacao=8740][Produto=026716100]]" + (char) 34 + ", " + (char) 34 + "programacao8743" + (char) 34 + ":" + (char) 34 + "[[Produto=026715100][ID Programacao=8743][Produto=026715100]]" + (char) 34 + ", " + (char) 34 + "programacao8888" + (char) 34 + ":" + (char) 34 + "[[Produto=026557110][ID Programacao=8888][Produto=026557110]]" + (char) 34 + ", " + (char) 34 + "programacao8895" + (char) 34 + ":" + (char) 34 + "[[Produto=026556110][ID Programacao=8895][Produto=026556110]]" + (char) 34 + ", " + (char) 34 + "programacao8921" + (char) 34 + ":" + (char) 34 + "[[Produto=026109110][ID Programacao=8921][Produto=026109110]]" + (char) 34 + ", " + (char) 34 + "programacao8938" + (char) 34 + ":" + (char) 34 + "[[Produto=026616110][ID Programacao=8938][Produto=026616110]]" + (char) 34 + ", " + (char) 34 + "programacao8945" + (char) 34 + ":" + (char) 34 + "[[Produto=026615110][ID Programacao=8945][Produto=026615110]]" + (char) 34 + ", " + (char) 34 + "programacao8952" + (char) 34 + ":" + (char) 34 + "[[Produto=026784100][ID Programacao=8952][Produto=026784100]]" + (char) 34 + ", " + (char) 34 + "programacao8963" + (char) 34 + ":" + (char) 34 + "[[Produto=026783100][ID Programacao=8963][Produto=026783100]]" + (char) 34 + ", " + (char) 34 + "programacao9065" + (char) 34 + ":" + (char) 34 + "[[Produto=025892000][ID Programacao=9065][Produto=025892000]]" + (char) 34 + ", " + (char) 34 + "programacao9072" + (char) 34 + ":" + (char) 34 + "[[Produto=025891000][ID Programacao=9072][Produto=025891000]]" + (char) 34 + ", " + (char) 34 + "programacao9198" + (char) 34 + ":" + (char) 34 + "[[Produto=026514100][ID Programacao=9198][Produto=026514100]]" + (char) 34 + ", " + (char) 34 + "programacao9203" + (char) 34 + ":" + (char) 34 + "[[Produto=026513100][ID Programacao=9203][Produto=026513100]]" + (char) 34 + ", " + (char) 34 + "programacao9507" + (char) 34 + ":" + (char) 34 + "[[Produto=026500100][ID Programacao=9507][Produto=026500100]]" + (char) 34 + ", " + (char) 34 + "programacao9511" + (char) 34 + ":" + (char) 34 + "[[Produto=026499100][ID Programacao=9511][Produto=026499100]]" + (char) 34 + ", " + (char) 34 + "programacao9576" + (char) 34 + ":" + (char) 34 + "[[Produto=026489100][ID Programacao=9576][Produto=026489100]]" + (char) 34 + ", " + (char) 34 + "programacao9685" + (char) 34 + ":" + (char) 34 + "[[Produto=026708100][ID Programacao=9685][Produto=026708100]]" + (char) 34 + ", " + (char) 34 + "programacao9900" + (char) 34 + ":" + (char) 34 + "[[Produto=026649100][ID Programacao=9900][Produto=026649100]]" + (char) 34 + ", " + (char) 34 + "programacao9916" + (char) 34 + ":" + (char) 34 + "[[Produto=026638100][ID Programacao=9916][Produto=026638100]]" + (char) 34 + ", " + (char) 34 + "programacao10011" + (char) 34 + ":" + (char) 34 + "[[Produto=026827100][ID Programacao=10011][Produto=026827100]]" + (char) 34 + ", " + (char) 34 + "programacao10074" + (char) 34 + ":" + (char) 34 + "[[Produto=026832100][ID Programacao=10074][Produto=026832100]]" + (char) 34 + "," + (char) 34 + "programacao10405" + (char) 34 + ":" + (char) 34 + "[[Produto=027019100][ID Programacao=10405][Produto=027019100]]" + (char) 34 + ", " + (char) 34 + "programacao10446" + (char) 34 + ":" + (char) 34 + "[[Produto=027020100][ID Programacao=10446][Produto=027020100]]" + (char) 34 + ", " + (char) 34 + "programacao10468" + (char) 34 + ":" + (char) 34 + "[[Produto=026826100][ID Programacao=10468][Produto=026826100]]" + (char) 34 + ", " + (char) 34 + "programacao10579" + (char) 34 + ":" + (char) 34 + "[[Produto=026120110][ID Programacao=10579][Produto=026120110]]" + (char) 34 + ", " + (char) 34 + "programacao10607" + (char) 34 + ":" + (char) 34 + "[[Produto=027456000][ID Programacao=10607][Produto=027456000]]" + (char) 34 + ", " + (char) 34 + "programacao10639" + (char) 34 + ":" + (char) 34 + "[[Produto=026831100][ID Programacao=10639][Produto=026831100]]" + (char) 34 + ", " + (char) 34 + "programacao10695" + (char) 34 + ":" + (char) 34 + "[[Produto=027252000][ID Programacao=10695][Produto=027252000]]" + (char) 34 + ", " + (char) 34 + "programacao10702" + (char) 34 + ":" + (char) 34 + "[[Produto=027253000][ID Programacao=10702][Produto=027253000]]" + (char) 34 + ", " + (char) 34 + "programacao10812" + (char) 34 + ":" + (char) 34 + "[[Produto=025847000][ID Programacao=10812][Produto=025847000]]" + (char) 34 + ", " + (char) 34 + "programacao10822" + (char) 34 + ":" + (char) 34 + "[[Produto=025716000][ID Programacao=10822][Produto=025716000]]" + (char) 34 + "}";
		
		JSONObject objson = null;
		try {
			mensagemformatojson = ws.getProgramacaosByMaquinaWS("MAP", "88220", ompt.getDepara());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.info(idLog, 0, "Ocorreu a excessa", e);
			return null;
		}
		objson = new JSONObject(mensagemformatojson);
		
		// Verifica se o webservice foi chamado com sucesso
		String status = objson.get("status").toString();
		if (status.equals("erro")) {
			log.info(idLog, 0, "O status do pt " + ompt.getCdPt() + " = erro");
			return null;
		}
		
		// Monta um array com os ids identificados na string, para em seguinda obter os dados
		StringBuilder mensagem = new StringBuilder(mensagemformatojson);
		List<String> idsProgramacao = new ArrayList<String>();
		int i = 0;
		do {
			i = mensagem.indexOf("ID Programacao=");
			if (i < 0)
				break;
			mensagem.delete(0, i + 15);
			i = mensagem.indexOf("]");
			idsProgramacao.add(mensagem.substring(0, i));
			mensagem.delete(0, i);
		} while(i >= 0);

		List<ProgramaInsersoraDTO> programas = new ArrayList<ProgramaInsersoraDTO>();
		
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select omprg");
		q.append("from OmPrg omprg");
		q.append("join omprg.omPt ompt");
		q.append("where omprg.stAtivo = 1");
		q.append("and ompt.cdPt = :cdpt");
		q.append("and omprg.cdPrg = :cdprg");
		q.append("order by omprg.idPrg desc");
		q.setMaxResults(1);
		q.defineParametro("cdpt", ompt.getCdPt());

		for (String idProgramacao : idsProgramacao) {

			// Obtem os dados da programacao
			String produto = objson.getString("programacao" + idProgramacao);
			produto = produto.substring(produto.indexOf("=") + 1);
			produto = produto.substring(0, produto.indexOf("]"));
			
			Long idPrg = Long.valueOf(idProgramacao);
			
			// Pesquisar o programa para analisar se ser� necess�rio se a revisao ser� outra; Isso � feito pq nao vem a dt de revisao
			Date dtrevisao = null;
			q.defineParametro("cdprg", produto);
			
			OmPrg omprgPesquisado = (OmPrg) q.uniqueResult();
			// Se exisitr um programa e o mesmo possui a mesma revisao, entao utilizar a dt da revisao para que a frente o programa nao seja importado

			if (omprgPesquisado != null && omprgPesquisado.getDsPrg().equals(idPrg.toString())) {
				dtrevisao = omprgPesquisado.getDtRevisao();
				log.info(idLog, 0, "Mesma revisao para o programa " + produto + " no pt " + ompt.getCdPt());
				continue; // passa pro proximo e nao pega esse programa
			} else {
				dtrevisao = DataHoraRN.getDataHoraAtual();
				log.info("NOVA revisao para o programa " + produto + " para o pt " + ompt.getCdPt());
			}

			// Inicializar o programa para ser incluido posteriormente
			OmPrg omprg = new OmPrg();
			omprg.setCdPrg(produto);
			omprg.setDsPrg(idPrg.toString());
			omprg.setDtRevisao(dtrevisao);
			omprg.setRevisao(idPrg);

			ProgramaInsersoraDTO programa = new ProgramaInsersoraDTO();
			programa.setCicloPadrao(60d);
			programa.setOmprg(omprg);
			

			// Pode ser que o programa ja exista no list, se existir nao incluir novamente
			boolean isExiste = false;
			for (ProgramaInsersoraDTO p : programas) {
				if (p.getOmprg().getCdPrg().equals(programa.getOmprg().getCdPrg())) {
					isExiste = true;
					break;
				}
			}
			if (isExiste == false)
				programas.add(programa);

			
			// Da um delay para nao sobrecarregar a CPU
			UtilsThreads.pausaNaThread(1000);
		}
			
		retorno.setProgramasInsersorasDTO(programas);
		
		return retorno;
	}

	
	@Override
	public ProgramaInsersoraDTO getProgramaInsersoraDTO(ProgramaInsersoraDTO programaInsersoraDTO) {
		IdwLogger log = new IdwLogger(programaInsersoraDTO.getOmpt().getCdPt() + programaInsersoraDTO.getOmprg().getCdPrg());
		int idLog = log.getIdAleatorio();
		
		ProgramaInsersoraDTO retorno = new ProgramaInsersoraDTO();

		retorno.setCicloPadrao(programaInsersoraDTO.getCicloPadrao());
		retorno.setDthrRevisao(programaInsersoraDTO.getDthrRevisao());
		retorno.setOmprg(programaInsersoraDTO.getOmprg());
		retorno.setOmpt(programaInsersoraDTO.getOmpt());
		
		retorno.setOmprgpos(new HashSet<OmPrgpos>());
		
		// Chama o webservice que ira retornar todas as posicoes do mapa da pst
		ProgramacaoWSProxy ws = new ProgramacaoWSProxy();

		String mensagemformatojson = null; // = "{" + (char) 34 + "status" + (char) 34 + ":" + (char) 34 + "sucesso" + (char) 34 + "," + (char) 34 + "mensagem" + (char) 34 + ":" + (char) 34 + "sucesso.programacao.consulta.itemexistente" + (char) 34 + ", " + (char) 34 + "item121450" + (char) 34 + ":" + (char) 34 + "[[Componente=050449000][Mesa=1][Slot=1][Quantidade=1]]" + (char) 34 + ", " + (char) 34 + "item121451" + (char) 34 + ":" + (char) 34 + "[[Componente=050486000][Mesa=1][Slot=2][Quantidade=1]]" + (char) 34 + ", " + (char) 34 + "item121452" + (char) 34 + ":" + (char) 34 + "[[Componente=060254000][Mesa=1][Slot=3][Quantidade=1]]" + (char) 34 + ", " + (char) 34 + "item121453" + (char) 34 + ":" + (char) 34 + "[[Componente=060663000][Mesa=1][Slot=4][Quantidade=1]]" + (char) 34 + ", " + (char) 34 + "item121454" + (char) 34 + ":" + (char) 34 + "[[Componente=060266000][Mesa=1][Slot=5][Quantidade=2]]" + (char) 34 + ", " + (char) 34 + "item121455" + (char) 34 + ":" + (char) 34 + "[[Componente=060090000][Mesa=1][Slot=6][Quantidade=0]]" + (char) 34 + ", " + (char) 34 + "item121456" + (char) 34 + ":" + (char) 34 + "[[Componente=050235000][Mesa=1][Slot=7][Quantidade=1]]" + (char) 34 + ", " + (char) 34 + "item121457" + (char) 34 + ":" + (char) 34 + "[[Componente=050449000][Mesa=2][Slot=1][Quantidade=1]]" + (char) 34 + ", " + (char) 34 + "item121458" + (char) 34 + ":" + (char) 34 + "[[Componente=050486000][Mesa=2][Slot=2][Quantidade=1]]" + (char) 34 + ", " + (char) 34 + "item121459" + (char) 34 + ":" + (char) 34 + "[[Componente=060254000][Mesa=2][Slot=3][Quantidade=1]]" + (char) 34 + ", " + (char) 34 + "item121460" + (char) 34 + ":" + (char) 34 + "[[Componente=060663000][Mesa=2][Slot=4][Quantidade=1]]" + (char) 34 + ", " + (char) 34 + "item121461" + (char) 34 + ":" + (char) 34 + "[[Componente=060266000][Mesa=2][Slot=5][Quantidade=2]]" + (char) 34 + ", " + (char) 34 + "item121462" + (char) 34 + ":" + (char) 34 + "[[Componente=060090000][Mesa=2][Slot=6][Quantidade=0]]" + (char) 34 + ", " + (char) 34 + "item121463" + (char) 34 + ":" + (char) 34 + "[[Componente=050235000][Mesa=2][Slot=7][Quantidade=1]]" + (char) 34 + "}";

		
		JSONObject objson = null;
		try {
			mensagemformatojson = ws.getProgramacaoCompletoWS("MAP", "88220", programaInsersoraDTO.getOmprg().getRevisao().toString());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.info(idLog, 0, "Ocorreu a excessao", e);
		}
		
		objson = new JSONObject(mensagemformatojson);
		
		log.info(idLog, 0, "Iniciando importacao posicoes do programa " + programaInsersoraDTO.getOmprg().getCdPrg() + " com Quantidade de chaves = " + objson.length());
		
		for (Object chave : objson.keySet()) {
			log.info(idLog, 0, "Lendo  " + chave + " do programa " + programaInsersoraDTO.getOmprg().getCdPrg());
			
			if (chave.equals("status") || chave.equals("mensagem")) 
				continue;
			
			String componente = getConteudo("Componente", objson.getString(chave.toString()));
			String mesa = getConteudo("Mesa", objson.getString(chave.toString()));
			String slot = getConteudo("Slot", objson.getString(chave.toString()));
			String quantidade = getConteudo("Quantidade", objson.getString(chave.toString()));
			
			OmPrgpos omprgpos = new OmPrgpos();
			omprgpos.setDwRapByIdRaptipofeeder(null);
			omprgpos.setDwRapByIdRaptipomesa(null);
			omprgpos.setFeedertable(null);
			omprgpos.setFeedertrack(mesa.trim() + UtilsString.getZerosAEsquerda(slot.trim(), 4)); // Esse eh o campo importante para identificar o slot
			omprgpos.setIdPrgpos(0l);
			omprgpos.setName(null);
			omprgpos.setOrdem(Integer.parseInt(quantidade));
			omprgpos.setPocket(null);
			omprgpos.setPosicao(null);
			omprgpos.setScantrack(null);
			
			OmProduto omproduto = new OmProduto();
			omproduto.setCdProduto(componente);
			omprgpos.setOmProduto(omproduto);
			retorno.getOmprgpos().add(omprgpos);
			
			// Da um delay para nao sobrecarregar a CPU
			UtilsThreads.pausaNaThread(1000);

		}

		log.info(idLog, 0, "Finalizando programa " + programaInsersoraDTO.getOmprg().getCdPrg());
		
		return retorno;
	}

	private String getConteudo(String chave, String valor) {
		String retorno = valor.substring(valor.indexOf(chave + "=") + chave.length() + 1);
		retorno = retorno.substring(0, retorno.indexOf("]"));
		return retorno;
	}
	public static void main(String[] args) {
		ImportaProgramaErpPstRN rn = new ImportaProgramaErpPstRN();
		OmPt ompt = new OmPt();
		ompt.setDepara("oi");
		ompt.setId(1l);
		ompt.setCdPt("oi");
		
		rn.getProgramasInsersorasDTO(ompt);
	}


	@Override
	public void inicializacao() {
		iniciaConexaoBanco();
	}

	@Override
	public void finalizacao() {
		finalizaConexaoBanco();
	}
}
