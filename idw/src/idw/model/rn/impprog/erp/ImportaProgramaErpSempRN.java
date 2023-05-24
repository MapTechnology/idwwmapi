package idw.model.rn.impprog.erp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import idw.model.IdwFacade;
import idw.model.dao.MapQuery;
import idw.model.dao.erp.DAOGenericoErp;
import idw.model.pojos.OmPrg;
import idw.model.pojos.OmPrgpos;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.erp.ViwMaplistaalimentacao;
import idw.model.rn.AbstractRN;
import idw.model.rn.impprog.IImportaProgramaRN;
import idw.util.UtilsString;
import idw.webservices.dto.ComponenteDeParaDTO;
import idw.webservices.dto.ComponentesDeParaDTO;
import idw.webservices.dto.ProgramaInsersoraDTO;
import idw.webservices.dto.ProgramasInsersorasDTO;

public class ImportaProgramaErpSempRN extends AbstractRN<DAOGenericoErp>  implements IImportaProgramaRN{

	public ImportaProgramaErpSempRN(){
		super(new DAOGenericoErp());
	}
	
	public ImportaProgramaErpSempRN(DAOGenericoErp dao) {
		super(dao);
	}

	@Override
	public ProgramaInsersoraDTO getProgramaInsersoraDTO(ProgramaInsersoraDTO programaInsersoraDTO) {
		ProgramaInsersoraDTO retorno = new ProgramaInsersoraDTO();
		retorno.setCicloPadrao(programaInsersoraDTO.getCicloPadrao());
		retorno.setDthrRevisao(programaInsersoraDTO.getDthrRevisao());
		retorno.setOmprg(programaInsersoraDTO.getOmprg());
		retorno.setOmpt(programaInsersoraDTO.getOmpt());
		List<ComponenteDeParaDTO> listaComponentesAlternativos = new ArrayList<ComponenteDeParaDTO>();
		ComponentesDeParaDTO componentesAlternativos = new ComponentesDeParaDTO();
		
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select viw");
		q.append("from ViwMaplistaalimentacao viw");
		q.append("where viw.id.nomMaq = :depara");
		q.append("and viw.id.numEstacaoZ > 0");
		q.append("and viw.id.nomPrograma like :omprg");
		q.append("and viw.id.nomPrograma <> ''");
		q.append("and viw.id.nomPrograma <> ' '");
		
		q.defineParametro("depara", programaInsersoraDTO.getOmpt().getDepara());
		q.defineParametro("omprg", programaInsersoraDTO.getOmprg().getCdPrg() + "%");
		
		List<ViwMaplistaalimentacao> lista = q.list();
		retorno.setOmprgpos(new HashSet<OmPrgpos>());
		
		for (ViwMaplistaalimentacao viw : lista) {
			if (viw.getId().getNomPrograma().trim().equals(""))
				continue;
			
			String strFlagLR = viw.getId().getFlgLeftRight();
			if (strFlagLR.equals("L"))
				strFlagLR = "1";
			else if (strFlagLR.equals("R"))
				strFlagLR = "2";
			else
				strFlagLR = "";
			
			OmPrgpos omprgpos = new OmPrgpos();
			omprgpos.setDwRapByIdRaptipofeeder(null);
			omprgpos.setDwRapByIdRaptipomesa(null);
			omprgpos.setFeedertable(null);
			omprgpos.setFeedertrack(viw.getId().getMesa().trim() + UtilsString.getZerosAEsquerda(viw.getId().getNumEstacaoZ().trim(), 4) + strFlagLR); // Esse eh o campo importante para identificar o slot
			omprgpos.setIdPrgpos(0l);
			omprgpos.setName(null);
			omprgpos.setOrdem(0);
			omprgpos.setPocket(null);
			omprgpos.setPosicao(null);
			omprgpos.setScantrack(null);
			
			if(viw.getId().getQuantidade() != null){
				omprgpos.setQtUsada(new BigDecimal(viw.getId().getQuantidade()));	
			}
			
			
			OmProduto omproduto = new OmProduto();
			omproduto.setCdProduto(viw.getId().getCodItem());
			omproduto.setDsProduto(viw.getId().getDesItem());
			omprgpos.setOmProduto(omproduto);
			//Luiz 03072019 É necessário checar se o componente é alternativo através da posição
			OmPrgpos encontrado = null;
			for(OmPrgpos a : retorno.getOmprgpos()) {
				if(a.getFeedertrack().equals(omprgpos.getFeedertrack())) {
					encontrado = a;
					break;
				}
			}
			// Luiz 03072019 Caso exista uma posição já encontrada esse componente deve ser cadastrado como alternativo
			if(encontrado != null) {
				ComponenteDeParaDTO componenteAlternativo = new ComponenteDeParaDTO();
				componenteAlternativo.setComponente(encontrado.getOmProduto().getCdProduto());
				componenteAlternativo.setFornecedor(omprgpos.getOmProduto().getCdProduto());
				//componentesAlternativos.getComponentes().add(componenteAlternativo);
				listaComponentesAlternativos.add(componenteAlternativo);
			} else
				retorno.getOmprgpos().add(omprgpos);
		}
		if (listaComponentesAlternativos != null && listaComponentesAlternativos.size() > 0) {
			componentesAlternativos.setComponentes(listaComponentesAlternativos);
			IdwFacade.getInstancia().importarComponentesDePara(componentesAlternativos);
		}
		
		return retorno;
	}

	@Override
	public ProgramasInsersorasDTO getProgramasInsersorasDTO(OmPt ompt) {
		ProgramasInsersorasDTO retorno = new ProgramasInsersorasDTO();
		
		retorno.setCdPt(ompt.getCdPt());
		retorno.setDepara(ompt.getDepara());
		retorno.setIdPt(ompt.getIdPt());
		
		
		List<ProgramaInsersoraDTO> programas = new ArrayList<ProgramaInsersoraDTO>();

		MapQuery q = new MapQuery(getDaoSession());
		
//		q.append("select distinct viwmap.id.nomPrograma, viwmap.id.datStatus");
//		q.append("from ViwMaplistaalimentacao viwmap");
//		q.append("where viwmap.id.nomMaq = :depara ");
//		//Luiz 20190705 em conversa com o Fabricio, decidimos adicionar esse filtro da importação
//		q.append("AND viwmap.id.datStatus > '20220620'");
//		q.append("");
		
		
		q.append("select distinct nomprograma, datstatus");
		q.append("from viw_maplistaalimentacao_novo a (nolock)");
		q.append("where");
		q.append("nommaq = :depara");
		q.append("and datstatus > '20220620'");
		
		q.querySQL().setString("depara", ompt.getDepara());
		
		List<Object[]> lista = q.querySQL().list();
		
		for (Object[] viw : lista) {
			OmPrg omprg = new OmPrg();
			omprg.setCdPrg(viw[0].toString());
			if (omprg.getCdPrg().contains("@"))
				omprg.setCdPrg(omprg.getCdPrg().substring(0, omprg.getCdPrg().indexOf("@")));
			
			// Aqui definir qual o programa principal vindo do ERP da SEMP;
			// TODO descomentar qdo a SEMP enviar o semi
			//omprg.setOmProduto(omProduto);
			
			omprg.setDtRevisao((Date) viw[1]);
			ProgramaInsersoraDTO programa = new ProgramaInsersoraDTO();
			programa.setCicloPadrao(60d);
			programa.setDthrRevisao((Date) viw[1]);
			programa.setOmprg(omprg);
			
			// Pode ser que o programa ja exista no list, se existir nao incluir novamente
			boolean isExiste = false;
			for (ProgramaInsersoraDTO p : programas) {
				if (p.getOmprg().getCdPrg().equals(programa.getOmprg().getCdPrg())) {
					isExiste = true;
					break;
				}
			}
			if (isExiste == false){
				programas.add(programa);
			}
				
		}		
		
		retorno.setProgramasInsersorasDTO(programas);
		
		return retorno;
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
