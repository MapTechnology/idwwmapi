package idw.model.rn.relatorios.R101;

import java.util.ArrayList;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwNserie;
import idw.model.pojos.DwNserieobs;
import idw.model.pojos.DwPassagem;
import idw.model.pojos.DwPassdef;
import idw.model.pojos.DwPassmon;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.diariobordo.DiarioBordoDTO;
import idw.util.IdwLogger;
import idw.webservices.dto.DefeitoDTO;
import idw.webservices.dto.MontagemDTO;

public class RelatorioR101RN extends AbstractRN<DAOGenerico> {

	public RelatorioR101RN() {
		super(new DAOGenerico());
	}
	
	public RelatorioR101RN(DAOGenerico dao) {
		super(dao);
	}

	public RelatorioR101DTO getRelatorioR101DTO(FiltroR101DTO filtro) {
		
		IdwLogger log = new IdwLogger("ChamadasUsuarios");
		int idLog = log.getIdAleatorio();
		log.iniciaAvaliacao(idLog, "RelatorioR101RN.getRelatorioR101DTO");
		log.info( idLog , 0, "RelatorioR101RN.getRelatorioR101DTO filtro usado:" + filtro.toString());
		
		RelatorioR101DTO retorno = new RelatorioR101DTO();
		List<LinhaDetalheR101DTO> linhas = obtemLinhas(filtro);
		retorno.setLinhas(linhas);
		log.mostrarAvaliacaoCompleta();
		return retorno;
	}
	
	private List<LinhaDetalheR101DTO> obtemLinhas(FiltroR101DTO filtro) {
		MapQuery q = new MapQuery(getDaoSession());
		
		q.append("select distinct a");
		q.append("from DwPassagem a");
		q.append("join fetch a.omPt b");
		q.append("join b.omGt omgt");
		q.append("join fetch a.dwNserie c");
		q.append("join a.dwConsolid id");
		q.append("join id.ppCp ppcp");
		q.append("join ppcp.ppCpprodutos cpprodutos");
		q.append("left join fetch a.dwPassmons d");
		q.append("left join fetch a.dwPassdefs e");
		q.append("left join fetch e.dwPasscau f");
		q.append("left join fetch c.dwNserieobses g");
		q.appendWhere(MapQuery._NULL, "b.cdPt = :cdpt", filtro.getOmpt() != null && filtro.getOmpt().getCdPt() != null && filtro.getOmpt().getCdPt().equals("") == false);
		q.appendWhere(MapQuery._AND, "id.dtReferencia between :dti and :dtf", filtro.getIsPeriodo());
		q.appendWhere(MapQuery._AND, "id.dwTurno = :dwturno", filtro.getIsTodosTurnos() == false && filtro.getDwturno() != null);
		q.appendWhere(MapQuery._AND, "id.dwTurno.idTurno <> 1", filtro.getIsTodosTurnos());
		q.appendWhere(MapQuery._AND, "b.cdGt = :cdgt", filtro.getOmgt() != null && filtro.getOmgt().getCdGt() != null && filtro.getOmgt().getCdGt().equals("") == false);
		q.appendWhere(MapQuery._AND, "cpprodutos.nrDoc = :op", filtro.getOp() != null && filtro.getOp().equals("") == false);
		q.appendWhere(MapQuery._AND, "c.cb = :cb", filtro.getNs() != null && filtro.getNs().equals("") == false);
		
		if (filtro.getOmpt() != null)
			q.defineParametro("cdpt", filtro.getOmpt().getCdPt());
		if (filtro.getOmgt() != null)
			q.defineParametro("cdgt", filtro.getOmgt().getCdGt());
		q.defineParametroData("dti", filtro.getDthrInicio());
		q.defineParametroData("dtf", filtro.getDthrFinal());
		q.defineParametro("dwturno", filtro.getDwturno());
		q.defineParametro("op", filtro.getOp());
		q.defineParametro("cb", filtro.getNs());
		
		List<DwPassagem> lista = q.list();
		List<LinhaDetalheR101DTO> retorno = new ArrayList<>();
		for (DwPassagem passagem : lista) {
			LinhaDetalheR101DTO dto = new LinhaDetalheR101DTO();
			dto.setDefeitos(obtemDefeitos(passagem));
			dto.setDthrPassagem(DataHoraRN.dateToStringDDMMYYYYHHMMSS(passagem.getDthr()));
			dto.setMontagem(obtemMontagem(passagem));
			dto.setNs(passagem.getDwNserie().getCb());
			dto.setOp(passagem.getDwConsolid().getPpCp().getNrop());
			dto.setPosto(passagem.getOmPt().getCdPt());
			dto.setStNserie(passagem.getStNserie().intValue());
			
			
			//
			List<DiarioBordoDTO> diariosNovos = new ArrayList<>();
			List<DiarioBordoDTO> diario =  obtemDiario(passagem.getDwNserie());
			for (DiarioBordoDTO dirdto : diario) {
				boolean isExiste = false;
				for (LinhaDetalheR101DTO deldto : retorno) {
					for (DiarioBordoDTO dtoaux : deldto.getDiarioBordo()) {
						if (dtoaux.getIdObs().equals(dirdto.getIdObs()))
							isExiste = true;
					}
				}
				if (isExiste == false) {
					diariosNovos.add(dirdto);
				}
			}
			dto.setDiarioBordo(diariosNovos);

			
			
			retorno.add(dto);
		}
		return retorno;
	}
	
	private List<DefeitoDTO> obtemDefeitos(DwPassagem passagem) {
		List<DefeitoDTO> retorno = new ArrayList<>();
		for (DwPassdef def : passagem.getDwPassdefs()) {
			DefeitoDTO dto = new DefeitoDTO();
			dto.setPosicoes(def.getDsPosicaomecanica());
			dto.setCdDefeito(def.getDwTDefeito().getCdTdefeito() + "-" + def.getDwTDefeito().getDsTdefeito());

			if (def.getDwTArea() != null)
				dto.setCdAreaResponsavel(def.getDwTArea().getCdArea() + "-" + def.getDwTArea().getDsArea());
			if (def.getDwPasscau() != null && def.getDwPasscau().getDwTAcao() != null)
				dto.setCdAcao(def.getDwPasscau().getDwTAcao().getCdTacao() + "-" + def.getDwPasscau().getDwTAcao().getDsTacao());
			retorno.add(dto);
		}
		return retorno;
	}
	
	private List<DiarioBordoDTO> obtemDiario(DwNserie dwnserie) {
		List<DiarioBordoDTO> retorno = new ArrayList<>();
		for (DwNserieobs obs : dwnserie.getDwNserieobses()) {
			DiarioBordoDTO dto = new DiarioBordoDTO();
			dto.setDthrObs(obs.getDthrObs());
			dto.setIdPosto(obs.getOmPt().getIdPt());
			dto.setPosto(obs.getOmPt().getCdPt());
			dto.setUsuario(obs.getOmUsr().getCdUsr());
			dto.setNs(obs.getDwNserie().getCb());
			dto.setObs(obs.getDsObs());
			dto.setIdObs(obs.getIdNserieobs());
			retorno.add(dto);
		}
		return retorno;
	}
	
	private List<MontagemDTO> obtemMontagem(DwPassagem passagem) {
		List<MontagemDTO> retorno = new ArrayList<>();
		for (DwPassmon mon : passagem.getDwPassmons()) {
			MontagemDTO dto = new MontagemDTO();
			dto.setCb(mon.getCb());
			if (mon.getOrdem() != null)
				dto.setOrdem(mon.getOrdem());
			retorno.add(dto);
		}
		return retorno;
	}
}
