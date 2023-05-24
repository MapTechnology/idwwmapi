package idw.model.rn.relatorios.opprocessada;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.DwConsolmologDAO;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolmo;
import idw.model.pojos.DwConsolmolog;
import idw.model.pojos.DwConsolpa;
import idw.model.pojos.DwConsolpr;
import idw.model.pojos.OmCfg;
import idw.model.pojos.PpCpentsai;
import idw.model.pojos.template.DwPeproTemplate;
import idw.model.rn.DataHoraRN;
import idw.model.rn.detalhemonitorizacao.IndicadorCicloMedioRN;
import idw.model.rn.detalhemonitorizacao.IndicadoresDeTempoRN;
import idw.util.AritmeticaUtil;
import idw.util.FormulasInjet;
import idw.util.Util;
import idw.webservices.dto.UsuarioCODTO;

public class GeraLinhaDetalhe {

	private final RelatorioOrdemProducaoProcessadaDetalheDTO linha;
	private DwConsolid id;
	private DAOGenerico dao;

	public GeraLinhaDetalhe(RelatorioOrdemProducaoProcessadaDetalheDTO linha, DAOGenerico dao) {
		super();
		this.linha = linha;
		this.dao = dao;
	}

	public void acumularNovosValoresDoBanco(DwConsolid id) {
		this.id = id;
		acumularProdutosComProducao();
		acumularOperadores();
		acumularParadas();
		acumularDadosGerais();
	}

	private void acumularDadosGerais() {
		linha.setDtInicial(this.id.getPpCp().getDthrInicioreal());
		linha.setDtFinal(this.id.getPpCp().getDthrFinalreal());
		

		//Marcos Sardinha: 2017-09-14 >> Defeito #4340
        if (linha.getDtInicial() != null && linha.getDtFinal() != null)
            linha.setPeriodo(DataHoraRN.dateToStringDDMMYYYYHHMMSS(linha.getDtInicial()) + "\n" + DataHoraRN.dateToStringDDMMYYYYHHMMSS(linha.getDtFinal()));
        else if (linha.getDtInicial() != null) {
        	linha.setPeriodo(DataHoraRN.dateToStringDDMMYYYYHHMMSS(linha.getDtInicial()) + "\n---");
        } else
        	linha.setPeriodo("---");

        
		if (this.id.getPpCp().getPpCpentsais() != null) {
			if (this.id.getPpCp().getPpCpentsais().size() > 0) {
				
				//Montar lista de entradas e saidas em ordem decrescente
				class PeriodoIniFim
				{
					Date dtHrIni;
					Date dtHrFim;
				}
				
				List<PeriodoIniFim> periodos = new ArrayList<PeriodoIniFim>();
				for (PpCpentsai entsai : this.id.getPpCp().getPpCpentsais()) {
					PeriodoIniFim periodoIniFim = new PeriodoIniFim();
					periodoIniFim.dtHrIni = entsai.getDthrInicio();
					periodoIniFim.dtHrFim = entsai.getDthrFim();
					
					periodos.add(periodoIniFim);
				}


		        //ordenar ferramentas        
		        Comparator<PeriodoIniFim> comparatorDataHoraDesc = new Comparator<PeriodoIniFim>() {
		            @Override
		            public int compare(PeriodoIniFim o1, PeriodoIniFim o2) {
		                Date valor1 = o1.dtHrIni;
		                Date valor2 = o2.dtHrIni;
		                return valor2.compareTo(valor1);
		            }
		        };

		        Collections.sort(periodos, comparatorDataHoraDesc);				
				
				
				
				linha.setPeriodo("");
				for (PeriodoIniFim entsai : periodos) {
					
					String periodo = "";
					
			        if (entsai.dtHrIni != null && entsai.dtHrFim != null)
			        	periodo = DataHoraRN.dateToStringDDMMYYYYHHMMSS(entsai.dtHrIni) + "\n" + DataHoraRN.dateToStringDDMMYYYYHHMMSS(entsai.dtHrFim);
			        
			        else if (entsai.dtHrIni != null) {
			        	periodo = DataHoraRN.dateToStringDDMMYYYYHHMMSS(entsai.dtHrIni) + "\n---";
			        	
			        } else
			        	periodo = "---";
										
					
					if (linha.getPeriodo().equals("")) {
						linha.setPeriodo(periodo);
					} else {
						linha.setPeriodo(linha.getPeriodo() + "\n\n" + periodo);
					}
				}
			}			
		}
		
		
        
		
		
		for (DwConsol consol : id.getDwConsols()) {
			//Marcos Sardinha: 2017-08-08 >> regulagem nao deve acumular tempos e outras qtd... deve ficar no padrao do mapa da ops
			if (id.getDwPepro().getIdPepro() == DwPeproTemplate.Type.REGULAGEM.getId()) {
				continue;
			}
			
			if (consol.getSegAutoCiclopadrao() != null)
				linha.setSegCicloPadrao(consol.getSegAutoCiclopadrao().doubleValue());
			if (consol.getSegAutoCiclomedio() != null)
				linha.setSegCicloMedio(consol.getSegAutoCiclomedio().doubleValue());
			linha.setEficienciaCiclo(FormulasInjet.calcularEficienciaCiclo(new BigDecimal(linha.getSegCicloPadrao()), new BigDecimal(linha.getSegCicloMedio())).doubleValue());

			IndicadoresDeTempoRN rn = new IndicadoresDeTempoRN(consol);

			/* Alessandre em 08-08-17 comentei a obtencao do tempo ativo e trabalhado pelo recalculo e usei o que
			 * foi consolidado em dwconsol 
			linha.setTempoAtivo(AritmeticaUtil.somar(new BigDecimal(linha.getTempoAtivo()), rn.getTempoAtivo()).doubleValue());
			linha.setTempoTrabalhado(AritmeticaUtil.somar(new BigDecimal(linha.getTempoTrabalhado()), rn.getTempoTrabalhado()).doubleValue());
			*/
			linha.setTempoAtivo(AritmeticaUtil.somar(new BigDecimal(linha.getTempoAtivo()), consol.getSegAutoTempoativo()).doubleValue());
			linha.setTempoTrabalhado(AritmeticaUtil.somar(new BigDecimal(linha.getTempoTrabalhado()), consol.getSegAutoTempotrabalhado()).doubleValue());
			
			//ciclo  padrao medio
			linha.setTempoCicloPadrao(linha.getTempoCicloPadrao() + rn.getTempoCicloPadrao().doubleValue());
			linha.setQtCicloPadrao(linha.getQtCicloPadrao() + 1d);
			linha.setSegCicloPadrao(linha.getTempoCicloPadrao() / linha.getQtCicloPadrao());
			
			// ciclo medio 
			OmCfg omcfg = Util.getConfigGeral(this.dao.getSession());
			
			linha.setTempoCiclosProdutivos(linha.getTempoCiclosProdutivos() + rn.getTempoCiclosProdutivos().doubleValue());
			linha.setQtdCiclosProdutivos(linha.getQtdCiclosProdutivos() + rn.getQtdCiclosProdutivos().doubleValue());
			
			IndicadorCicloMedioRN cmRN = new IndicadorCicloMedioRN(omcfg, null,	new BigDecimal(linha.getTempoCiclosProdutivos()), new BigDecimal(linha.getQtdCiclosProdutivos()), BigDecimal.ZERO);			
			linha.setSegCicloMedio(cmRN.calcularCicloMedio().setScale(2, RoundingMode.HALF_EVEN) .doubleValue());
			linha.setEficienciaCiclo(FormulasInjet.calcularEficienciaCiclo(new BigDecimal(linha.getSegCicloPadrao()), new BigDecimal(linha.getSegCicloMedio())).doubleValue());
		}

		linha.setProducaoSaldoOP(id.getPpCp().getSaldoAProduzir());

	}

	private void acumularProdutosComProducao() {
		GeraLinhaDetalheProduto rn = new GeraLinhaDetalheProduto();
		for (DwConsol consol : id.getDwConsols()) {
			for (DwConsolpr produto : consol.getDwConsolprs()) {
				rn.acumulaProduto(produto, linha);
			}
		}
	}

	private void acumularOperadores() {

		DwConsol consol = id.getDwConsol();

		List<DwConsolmo> lista = new ArrayList<>(consol.getDwConsolmos());

		for (DwConsolmo mo : lista) {
			UsuarioCODTO usuario = new UsuarioCODTO();
			usuario.setMatricula(mo.getOmUsr().getCdUsr());
			usuario.setApelido(mo.getOmUsr().getDsApelido());
			if (linha.getOperadores().contains(usuario) == false)
				linha.getOperadores().add(usuario);
		}

		// Atencao com os logins em aberto que tenham interseccao com o periodo
		// do id
		DwConsolmologDAO dao = new DwConsolmologDAO(this.dao.getSession());
		//List<DwConsolmolog> loginsAbertos = dao.getOperadoresNoPeriodoPorPtComLoginEmAberto(id.getOmPt().getIdPt(), id.getDthrIturno(), id.getDthrFturno());
		List<DwConsolmolog> loginsAbertos = dao.getOperadoresNoPeriodoPorPtNaCPComLoginEmAberto(id.getOmPt().getIdPt(), consol.getDwConsolid().getPpCp().getIdCp(), id.getDthrFturno());
		
		for (DwConsolmolog log : loginsAbertos) {
			UsuarioCODTO usuario = new UsuarioCODTO();
			usuario.setMatricula(log.getOmUsr().getCdUsr());
			usuario.setApelido(log.getOmUsr().getDsApelido());
			if (linha.getOperadores().contains(usuario) == false)
				linha.getOperadores().add(usuario);
		}

	}

	private void acumularParadas() {

		GeraLInhaDetalheParada rn = new GeraLInhaDetalheParada();

		for (DwConsol consol : id.getDwConsols()) {
			// Atencao com as paradas em aberto
			List<DwConsolpa> lista = new ArrayList<>(consol.getDwConsolpas());
			
			for (DwConsolpa consolpa : lista) {
				if (consolpa.isRegistroInvalido() == false)
					rn.acumulaParada(consolpa, linha);
			}
		}
	}
}
