package idw.model.rn;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwConsolpalog;
import idw.model.pojos.PpCpproduto;
import idw.webservices.dto.FiltroRelatorioParadasAbertasDTO;
import idw.webservices.dto.ListaRelatorioParadasAbertasDTO;
import idw.webservices.dto.RelatorioParadasAbertasDTO;

public class RelatorioParadasAbertasRN extends AbstractRN<DAOGenerico>{

	public RelatorioParadasAbertasRN() {
		this(null);
	}
	
	public RelatorioParadasAbertasRN(DAOGenerico dao) {
		super(dao);
		if (dao == null) {
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}
	
	public ListaRelatorioParadasAbertasDTO getConsolpaLogDTO( FiltroRelatorioParadasAbertasDTO filtro) {
		
		List<DwConsolpalog> listaConsolpalog = new ArrayList<>();
		MapQuery q = new MapQuery(getDaoSession());
		ListaRelatorioParadasAbertasDTO retorno = new ListaRelatorioParadasAbertasDTO();
		q.append("SELECT DISTINCT consolpalog");
		q.append("FROM DwConsolpalog consolpalog");
		q.append("JOIN consolpalog.dwTParada parada");
		q.append("JOIN consolpalog.omPt omPt");
		q.append("LEFT JOIN omPt.omObjs omobj");
		q.append("LEFT JOIN parada.dwTArea area");
		q.append("JOIN omPt.ppCp ppcp");
		q.append("JOIN ppcp.ppCpprodutos ppcpproduto");
		q.append("WHERE consolpalog.dthrFparada IS NULL");
		
		if (filtro.getArea() != null){
			q.append("AND parada.dwTArea.idArea = :dwtarea");
		}
		if (filtro.getCdop() != null) {
			q.append("AND ppcpproduto.nrDoc = :cdop");
		}		
		if (filtro.getOmpt() != null) {
			q.append("AND omPt.idPt = :idpt");
		}
		if (filtro.getOmgt() != null) {
			q.append("AND omobj.omGtByIdGt.idGt = :idGt");
		}
		
		if (filtro.getArea() != null) {
			q.defineParametro("dwtarea", filtro.getArea().getIdArea());
		}
		if (filtro.getCdop() != null){
			q.defineParametro("cdop", filtro.getCdop());
		}
		if (filtro.getOmpt() != null) {
			q.defineParametro("idpt", filtro.getOmpt().getIdPt());
		}
		if (filtro.getOmgt() != null) {
			q.defineParametro("idGt", filtro.getOmgt().getIdGt());
		}
		
		listaConsolpalog = q.list();
		
		if(!listaConsolpalog.isEmpty()){
			retorno = montaRelatorioParadasAbertas(listaConsolpalog);
		}
		
		return retorno;
		
	}

	private ListaRelatorioParadasAbertasDTO montaRelatorioParadasAbertas(List<DwConsolpalog> listaConsolpalog) {
		
		ListaRelatorioParadasAbertasDTO retorno = new ListaRelatorioParadasAbertasDTO();
		retorno.setAbertasDTOs(new ArrayList<RelatorioParadasAbertasDTO>());
		for(DwConsolpalog consolpalog : listaConsolpalog){
			
			BigDecimal pcsProducaoplanejada = BigDecimal.ZERO;
			BigDecimal gPesoBruto = BigDecimal.ZERO;
			for(PpCpproduto ppCpproduto : consolpalog.getOmPt().getPpCp().getPpCpprodutos()){
				
				if(ppCpproduto.getOmProduto().getGPesoBruto() != null){
					gPesoBruto = gPesoBruto.add(ppCpproduto.getOmProduto().getGPesoBruto());
				}
				if(ppCpproduto.getPcsProducaoplanejada() != null){
					pcsProducaoplanejada = pcsProducaoplanejada.add(ppCpproduto.getPcsProducaoplanejada());
				}
			}
			
			String area = consolpalog.getDwTParada() != null && consolpalog.getDwTParada().getDwTArea() != null ? consolpalog.getDwTParada().getDwTArea().getCdArea() + " - " + consolpalog.getDwTParada().getDwTArea().getDsArea() : "";
			String maquina = consolpalog.getOmPt() != null ? consolpalog.getOmPt().getCdPt() : "";
			String parada = consolpalog.getDwTParada() != null ? consolpalog.getDwTParada().getCdTparada()+ " - " + consolpalog.getDwTParada().getDsTparada() : "";
			String dataInicio = DataHoraRN.dateToStringDDMMYYYYHHMMSS(consolpalog.getDthrIparada());
			String duracao = DataHoraRN.formatMilisegundosParaHHMMSSmmm(DataHoraRN.getQuantidadeMilisegundosNoPeriodo(consolpalog.getDthrIparada(), DataHoraRN.getDataHoraAtual())); //DataHoraRN.formatSegundosParaHHMMSS(data.intValue());
			
			RelatorioParadasAbertasDTO relatorio = new RelatorioParadasAbertasDTO();
			relatorio.setgPesoBruto(gPesoBruto);
			relatorio.setPcsProducaoplanejada(pcsProducaoplanejada);
			relatorio.setAreaResp(area);
			relatorio.setMaquina(maquina);
			relatorio.setDsMaquinaCurta(consolpalog.getOmPt().getDsCurta());
			relatorio.setParada(parada);
			relatorio.setDthrInicio(dataInicio);
			relatorio.setDuracao(duracao);
			retorno.getAbertasDTOs().add(relatorio);
		}
		Comparator<RelatorioParadasAbertasDTO> comparator = new Comparator<RelatorioParadasAbertasDTO>() {
			@Override
			public int compare(RelatorioParadasAbertasDTO o1, RelatorioParadasAbertasDTO o2) {
				String area1 = o1.getAreaResp()+o1.getMaquina()+o1.getDthrInicio();
				String area2 = o2.getAreaResp()+o2.getMaquina()+o2.getDthrInicio();
				return area1.compareTo(area2);
			}
		};
		
		Collections.sort(retorno.getAbertasDTOs(), comparator);
		
		return retorno;
	}
}
