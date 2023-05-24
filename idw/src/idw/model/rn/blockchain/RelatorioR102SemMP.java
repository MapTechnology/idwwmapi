package idw.model.rn.blockchain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwNsMp;
import idw.model.pojos.DwPassagem;
import idw.model.pojos.OmAlim;
import idw.model.pojos.OmAlimrea;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;

public class RelatorioR102SemMP extends AbstractRN<DAOGenerico> {
	private List<OmAlimrea> omalimreas;
	private Map<OmAlim, Integer> qtdeTotal = new HashMap<>();
	

	public RelatorioR102SemMP() {
		super(new DAOGenerico());
	}
	public RelatorioR102SemMP(DAOGenerico dao) {
		super(dao);
	}
	
	public static void main(String[] args) {
		RelatorioR102SemMP rn = new RelatorioR102SemMP();
		rn.iniciaConexaoBanco();
		Date inicio = DataHoraRN.getData(2020, 01, 06);
		Date fim = DataHoraRN.getDataHora(2020, 01, 06, 17, 0, 0, 0);
		
		rn.gerar(inicio, fim, "AOIL12", "AOIL12", false);
		
	}

	// Metodo principal para geracao do relatorio
	public void gerar(Date dthri, Date dthrf, String cdpt, String cdptOrigem, boolean isConsiderarMontagem) {
		List<DwPassagem> passagensMO = getPassagens(dthri, dthrf, cdpt, isConsiderarMontagem);
		int qtSemMP =  0;
		int qtTotal = 0;
		int qtAbaixo = 0;
		int qtAcima = 0;
		
		int qtSemBot = 0;
		int qtSemTop = 0;
		int qtBotAbaixo = 0;
		int qtTopAbaixo = 0;
		
		for (DwPassagem passagem : passagensMO) {
			String cbTop = passagem.getDwNserie().getCb();
			String cbBot = null;
			if (passagem.getDwPassmons().isEmpty() == false)
				cbBot = passagem.getDwPassmons().iterator().next().getCb();
			
			int qtMontadoTop = getQtMPComGrupo(cbTop);
			int qtEsperadoTop = getQtEsperadoComGrupo(cbTop, cdptOrigem);
			
			int qtMontadoBot = 0;
			if (isConsiderarMontagem)
				qtMontadoBot = getQtMPComGrupo(cbBot);
			int qtEsperadoBot = 0;
			if (isConsiderarMontagem)
				qtEsperadoBot = getQtEsperadoComGrupo(cbBot, cdptOrigem);
			
			// Se a passagem que casou nao tiver passado originalmente por cdPtOrigem, entao descartar, dessa forma podemos analisar apenas o que passou por determinada  linha do smd
			if (qtEsperadoTop <= 0 && qtEsperadoBot <= 0) {
				qtTotal++;
				System.out.println("&&&&&&" + cbTop + " qtEsperadoTop=" + qtEsperadoTop + "  qtEsperadoBot=" + qtEsperadoBot);
				continue;
			}

			if (qtMontadoBot == 0 && qtMontadoTop == 0)
				System.out.println("......Procecssando " + cbTop + "=" + qtMontadoTop + "/" + qtEsperadoTop + " e " + cbBot + "=" + qtMontadoBot + "/" + qtEsperadoBot);
			else if (qtMontadoBot == 0 || qtMontadoTop == 0)
				System.out.println("Procecssando " + cbTop + "=" + qtMontadoTop + "/" + qtEsperadoTop +  " e " + cbBot + "=" + qtMontadoBot + "/" + qtEsperadoBot);
			else
				System.out.println("***************   Procecssando " + cbTop + "=" + qtMontadoTop + "/" + qtEsperadoTop +  " e " + cbBot + "=" + qtMontadoBot + "/" + qtEsperadoBot);

			// Se nao existe nenhuma mp associada
			if (qtMontadoTop == 0 && qtMontadoBot == 0)
				qtSemMP++;
			else 	if (qtMontadoBot == 0 && isConsiderarMontagem)
				qtSemBot++;
			else if (qtMontadoTop == 0)
				qtSemTop++;
			else  if (qtMontadoBot < qtEsperadoBot)
				qtBotAbaixo++;
			else if (qtMontadoTop < qtEsperadoTop)
				qtTopAbaixo++; 
			else  if (qtEsperadoTop > qtMontadoTop || qtEsperadoBot > qtMontadoBot)
				qtAbaixo++;
			else if (qtEsperadoTop < qtMontadoTop || qtEsperadoBot < qtMontadoBot)
				qtAcima++;
			
			
			qtTotal++;
		}
		System.out.println("Qt.Total Placas:" + qtTotal);
		System.out.println("Placas sem nada:" + qtSemMP);
		System.out.println("Placas sem bot :" + qtSemBot);
		System.out.println("Placas sem top :" + qtSemTop);
		
		System.out.println("Placas bot abaixo:" + qtBotAbaixo);
		System.out.println("Placas top abaixo:" + qtTopAbaixo);
	}
	
	private List<DwPassagem> getPassagens(Date dthri, Date dthrf, String cdpt, boolean isComMontagem) {
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select a");
		q.append("from DwPassagem a");
		if (isComMontagem)
			q.append(" join a.dwPassmons b");
		else
			q.append("left join a.dwPassmons b");
		q.append("join a.omPt c");
		q.append("join a.dwNserie d");
		q.append("where a.dthr between :dthri and :dthrf");
		q.append("and c.cdPt like :cdpt");
		
		q.defineParametroData("dthri", dthri);
		q.defineParametro("dthrf", dthrf);
		q.defineParametro("cdpt", cdpt);
		
		
		List<DwPassagem> retorno = q.list();
		
		return retorno;
	}

	private int getQtMPComGrupo(String cb) {
		int retorno = 0;
		
		MapQuery q = new MapQuery(getDaoSession());
		
		q.append("select a");
		q.append("from DwNsMp a");
		q.append("join a.dwNserie b");
		q.append("join a.omProduto c");
		q.append("join c.omProgrp d");
		q.append("where b.cb = :cb");
		q.append("and d.cdProgrp <> :cdprogrp");
		
		q.defineParametro("cb", cb);
		q.defineParametro("cdprogrp", "0");
		
		List<DwNsMp> lista = q.list();

		// Salva as alimentacoes para veriicar qtos itens são necessariois para o blockchain
		this.omalimreas = new ArrayList<>();
		for (DwNsMp mp : lista) {
			if (this.omalimreas.contains(mp.getOmAlimrea()) == false)
				this.omalimreas.add(mp.getOmAlimrea());
		}
		retorno = lista.size();
		return retorno;
	}

	
	
	
	private int getQtEsperadoComGrupo(String cb, String cdptorigem) {
		int retorno = 0;
		OmAlimrea omalimrea = null;
		if (this.omalimreas.isEmpty() == false) {
			omalimrea = this.omalimreas.iterator().next();
			
			// Se a alimentacao nao for do PT passado
			if (cdptorigem != null && omalimrea.getOmMapapa().getOmMapa().getOmPt().getCdPt().contains(cdptorigem))
				return -1;
		
			if (qtdeTotal.containsKey(omalimrea.getOmAlim())) {
				retorno += qtdeTotal.get(omalimrea.getOmAlim());
			} else {
				retorno += getQtdeAlim(omalimrea.getOmAlim());
				qtdeTotal.put(omalimrea.getOmAlim(), retorno);
			}
		
		}			
		return retorno;
	}
	

	
	private int getQtdeAlim(OmAlim omalim) {
		int retorno = 0;
		
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select distinct c.cdProduto");
		q.append("from OmAlimrea a");
		q.append("join a.omMapapa b");
		q.append("join b.omProduto c");
		q.append("join c.omProgrp d");
		q.append("where d.cdProgrp <> '0'");
		q.append("and a.omAlim = :omalim");
		
		q.defineParametro("omalim", omalim);

		List<Object> result = q.list();
		
		retorno = result.size();
		
		return retorno;
	}
	
}
