package ms.model.rn.coletaComAndon;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.hibernate.type.DoubleType;
import org.hibernate.type.StringType;

import ms.coleta.dto.IntervaloTempoInjetDTO;
import ms.coleta.dto.ParadaColetaComAndonDTO;
import ms.coleta.dto.ParadasColetaComAndonDTO;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.excessoes.SemCalendarioException;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.injet.FuncoesApoioInjet;
import idw.model.rn.injet.TurnoInjetDTO;

public class ParadaColetaComAndonRN extends AbstractRN<DAOGenericoInjet>{

	public ParadaColetaComAndonRN() {
		super(new DAOGenericoInjet());
	}
	

	public ParadaColetaComAndonDTO getMaiorParadaColetaComAndon(String cdMaquina, Date dthrini, Date dthrFim){
		
		ParadaColetaComAndonDTO retorno = new ParadaColetaComAndonDTO();
		
		return retorno;
	}
	
	public ParadasColetaComAndonDTO getMaioresParadasColetaComAndon(String cdMaquina, Date dthrAtual){
		
		ParadasColetaComAndonDTO retorno = new ParadasColetaComAndonDTO();
		
		String hql="";

		Date dthriniTur;
		Date dthrfimTur;
		TurnoInjetDTO turnoAtual = new TurnoInjetDTO();
		List<IntervaloTempoInjetDTO> listaHoras = new ArrayList<IntervaloTempoInjetDTO>();
		
		try {
			
			// recupera data de referencia e turnos atual
			turnoAtual = FuncoesApoioInjet.encontraTurno(this.getDao(), dthrAtual);
			
			// recupera início e fim do turno
			dthriniTur = FuncoesApoioInjet.calcularInicioTurno(this.getDao(), turnoAtual.getDtReferencia(), turnoAtual.getIjtbtur().getCdturno());
			dthrfimTur = FuncoesApoioInjet.calcularFimTurno(this.getDao(), turnoAtual.getDtReferencia(), turnoAtual.getIjtbtur().getCdturno());
			
			// recupera intervalos de hora que façam interseção com o turno
			listaHoras = FuncoesApoioInjet.horasPeriodo(this.getDao(), dthriniTur, dthrfimTur);
			
		}
		catch (SemCalendarioException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		hql += "SELECT a.cdparada, c.dsparada, SUM(a.TmpParadas  + a.tmpparadassempeso) AS tempoparada";
		hql += "  FROM ijReaParCNSOcorUT a, ijTbInj b, ijTbPar c, ";
		hql += "        (SELECT CdMolde, CdEstrutura, DtHrIVal FROM ijMolPro WHERE DtHrFVal IS NULL) d ";
		hql += " WHERE d.CdMolde = b.CdMoldeAtual ";
		hql += "   AND d.CdEstrutura = b.CdEstruturaAtual ";
		hql += "   AND a.CdInjetora = b.CdInjetora ";
		hql += "   AND a.NrOP = b.OPAtual ";
		hql += "   AND a.CdMolde = b.CdMoldeAtual ";
		hql += "   AND a.CdEstrutura = b.CdEstruturaAtual ";
		hql += "   AND a.DtHrIValEstru = d.DtHrIVal ";
		hql += "   AND a.DtHripar between ':dthrini' AND ':dthrfim' ";
		hql += "   AND b.CdInjetora = ':cdmaq' "; 
		hql += "   AND c.CdParada = a.CdParada ";
		hql += "GROUP BY a.cdparada, c.dsparada ";
		hql += "ORDER BY 3 DESC";

		hql = hql.replaceAll(":dthrini", DataHoraRN.dateToStringYYYYMMDDHHMMSS(listaHoras.get(0).getDtHrIniPeriodo()));
		hql = hql.replaceAll(":dthrfim", DataHoraRN.dateToStringYYYYMMDDHHMMSS(listaHoras.get(listaHoras.size()-1).getDtHrFimPeriodo()));
		hql = hql.replaceAll(":cdmaq", cdMaquina);
		
		Query q = getDao().getSession().createSQLQuery(hql)
				.addScalar("cdparada", StringType.INSTANCE)
				.addScalar("dsparada", StringType.INSTANCE)
				.addScalar("tempoparada", DoubleType.INSTANCE)
				.setResultTransformer(Transformers.aliasToBean(ParadaColetaComAndonDTO.class));
		
		List<ParadaColetaComAndonDTO> listaParadas = q.list();
		
		if(listaParadas.size() > 0){
			retorno.setLista(listaParadas);
			retorno.setTNC(true);
		}
		
		return retorno;
		
	}
	
}
