package idw.model.rn.alimentacao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import idw.model.dao.DAOGenerico;
import idw.model.dao.OmAlimreaDAO;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.pojos.OmAlim;
import idw.model.pojos.OmAlimrea;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmUsr;
import idw.model.pojos.template.OmAlimTemplate;
import idw.model.pojos.template.OmAlimreaTemplate;
import idw.model.pojos.template.OmAlimreaTemplate.TpLeitura;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.ProdutoRN;
import idw.util.IdwLogger;
import idw.webservices.dto.ListaRelatorioAlimentacaoDTO;
import idw.webservices.dto.RelatorioAlimentacaoDTO;

public class RelatorioAlimentacaoRN extends AbstractRN<DAOGenerico> {
	private ProdutoRN produtoRN;
	public RelatorioAlimentacaoRN(DAOGenerico dao) {
		super(dao);
		this.produtoRN = new ProdutoRN(dao);
	}

	public ListaRelatorioAlimentacaoDTO getListaRelatorioAlimentacaoDTO(Long idAlim, boolean isApenasRealimentacao, Date dtHrInicioLeitura, Date dtHrFimLeitura ) {
		
		IdwLogger log = new IdwLogger("ChamadasUsuarios");
		int idLog = log.getIdAleatorio();
		log.iniciaAvaliacao(idLog, "RelatorioAlimentacaoRN.getListaRelatorioAlimentacaoDTO");
		log.info( idLog , 0, "RelatorioAlimentacaoRN.getListaRelatorioAlimentacaoDTO filtro usado:" + "[idAlim=" + idAlim +", isApenasRealimentacao=" + isApenasRealimentacao + ", dtHrInicioLeitura=" + dtHrInicioLeitura + ", dtHrFimLeitura=" + dtHrFimLeitura + "]" );
		
		ListaRelatorioAlimentacaoDTO listaRelatorioAlimentacaoDTO = 
				new ListaRelatorioAlimentacaoDTO(new ArrayList<RelatorioAlimentacaoDTO>());
		
		OmAlimreaDAO omAlimreaDAO = new OmAlimreaDAO(getDaoSession());
		List<OmAlimrea> lista = omAlimreaDAO.getOmAlimreaPorIdAlim(idAlim, isApenasRealimentacao, dtHrInicioLeitura, dtHrFimLeitura);
		
		Map<String, String> mapDsProduto = new HashMap<>();
		
		for (OmAlimrea omAlimrea : lista) {
			RelatorioAlimentacaoDTO dto = new RelatorioAlimentacaoDTO();
			
			OmAlim omAlim = omAlimrea.getOmAlim();
			OmProduto omProdutoPrevisto =  omAlimrea.getOmMapapa().getOmProduto();
			OmUsr omUsr = omAlimrea.getOmUsr();
			
			dto.setDthrLeitura(
					DataHoraRN.dateToStringDDMMYYYYHHMMSS(omAlimrea.getDthrLeitura()));
			dto.setTpAlim(omAlim.getTpAlim());
			dto.setStAlim(omAlim.getStAlim());
			dto.setTpLeitura(omAlimrea.getTpLeitura());
			dto.setDsTpLeitura(getDsTpLeitura(omAlimrea));
			dto.setStLeitura(omAlimrea.getStLeitura());
			dto.setDsStLeitura(getDsStLeitura(omAlimrea));
			dto.setPosicao(omAlimrea.getOmMapapa().getOmPa().getCdPa());
			dto.setCdProdutoLido(omAlimrea.getCdLido());
			dto.setDsProdutoLido(getDsProduto(mapDsProduto, omAlimrea.getCdLido()));			
			dto.setCdProdutoPrevisto(omProdutoPrevisto.getCdProduto());
			dto.setDsProdutoPrevisto(omProdutoPrevisto.getDsProduto());
			dto.setCdUsr(omUsr.getCdUsr());
			dto.setDsUsr(omUsr.getDsNome());
			dto.setQtd(omAlimrea.getQtAlimentada());
			
			listaRelatorioAlimentacaoDTO.getLista().add(dto);
			
		}
		
		log.mostrarAvaliacaoCompleta();
		
		return listaRelatorioAlimentacaoDTO;
		
	}

	private String getDsProduto(Map<String, String> mapDsProduto, String cdProduto) {
		String dsProduto = mapDsProduto.get(cdProduto); 
		if (dsProduto == null) {
			try {
				OmProduto omProduto = produtoRN.getOmProduto(cdProduto);
				dsProduto = omProduto.getDsProduto();					
			} catch (RegistroDesconhecidoException e) {
				dsProduto = "";
			}
			mapDsProduto.put(cdProduto, dsProduto);
		}
		return dsProduto;
	}

	private String getDsStLeitura(OmAlimrea omAlimrea) {
		String dsStLeitura = "";
		if(OmAlimreaTemplate.StLeitura.SUCESSO.equals(omAlimrea.getStLeitura())) {
			dsStLeitura = "Sucesso";
		} else {
			dsStLeitura = "Falhou";
		}
		return dsStLeitura;
	}

	private String getDsTpLeitura(OmAlimrea omAlimrea) {
		String dsTpLeitura;
		TpLeitura tpLeitura = OmAlimreaTemplate.TpLeitura.get(omAlimrea.getTpLeitura());			
		switch(tpLeitura) {
			case CONFERENCIA_OU_ALIMENTACAO:
				OmAlim omAlim = omAlimrea.getOmAlim();
				if (OmAlimTemplate.TpAlim.CONFERENCIA.equals(omAlim.getTpAlim())) {
					dsTpLeitura = "Conferência";
				} else {
					dsTpLeitura = "Alimentação";
				}
				break;
			case DESALIMENTACAO:
				dsTpLeitura = "Desalimentação";
				break;
			case REALIMENTACAO:
				dsTpLeitura = "Realimentação";
				break;
			case TERMINO_CONSUMO:
				dsTpLeitura = "Término consumo";
				break;
			default:
				dsTpLeitura = "Desconhecida(" + omAlimrea.getTpLeitura() + ")";
				break;
		}
		return dsTpLeitura;
	}
	
}
