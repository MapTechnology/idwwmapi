package idw.model.rn.monitorizacao.injet;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.webservices.dto.FiltroDetalhePTInjetDTO;
import idw.webservices.dto.GraficoBIItemRecorrenciaDTO;
import idw.webservices.dto.GraficoBIRecorrenciaDTO;

public abstract class GraficoRecorrenciaInjetFactory  extends AbstractRN<DAOGenericoInjet>{
	
	public static final Byte RECORRENCIA_PARADA = 1;
	public static final Byte RECORRENCIA_REFUGO = 2;

	public GraficoRecorrenciaInjetFactory() {
		super(new DAOGenericoInjet());
	}
	
	public GraficoRecorrenciaInjetFactory(DAOGenericoInjet dao) {
		super(dao);
	}

	public abstract GraficoBIRecorrenciaDTO getGraficoBIParetoRecorrencia(FiltroDetalhePTInjetDTO filtroBI, Byte tipoRecorrencia,String cdItem);
	
	public static GraficoRecorrenciaInjetFactory getInstancia(Byte tipoRecorrencia) {
		GraficoRecorrenciaInjetFactory retorno = null;
		
		if (tipoRecorrencia.equals(RECORRENCIA_PARADA)) {
			retorno = new GraficoRecorrenciaParadaInjetRN();
		} else if (tipoRecorrencia.equals(RECORRENCIA_REFUGO)) {
			retorno = new GraficoRecorrenciaRefugoInjetRN();
		}
		return retorno;
	}

	protected void ordenarDetalheBIRecorrenciaPorPeriodo(List<GraficoBIItemRecorrenciaDTO> grafBIParetoDet) {
		
		Collections.sort(grafBIParetoDet,
				new Comparator<GraficoBIItemRecorrenciaDTO>() {
					@Override
					public int compare(final GraficoBIItemRecorrenciaDTO o1,
							final GraficoBIItemRecorrenciaDTO o2) {
						final GraficoBIItemRecorrenciaDTO item1 = o1;
						final GraficoBIItemRecorrenciaDTO item2 = o2;
						return DataHoraRN.compareTo(item1.getDthrIni(), item2.getDthrIni());
					}
				});
	}
}
