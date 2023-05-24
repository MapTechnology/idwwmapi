package idw.relatorio.analiseproducaoeficiencia;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import idw.model.excessoes.SemPcsPorCicloAtivasException;
import idw.model.pojos.DwFolha;
import idw.model.pojos.OmProduto;
import idw.model.rn.FolhaRN;

final class Cache {
	// private Map<String, Map<Date, List<AnaliseProducaoEficienciaHoraAHoraDetalheDTO>>> horasDetalhesProdutos;
	private final Map<String, Set<Long>> idsFolhasPorProduto;
	private final Map<String, Map<String, ProducaoHora>> grupoProducaoHoraPorProduto;

	private final Map<String, Map<Long, BigDecimal>> cacheCavidadesAtivasProdutoFolha = new HashMap<String, Map<Long, BigDecimal>>();
	private final Map<String, Map<Long, BigDecimal>> cacheCavidadesTotaisProdutoFolha = new HashMap<String, Map<Long, BigDecimal>>();
	private final FolhaRN folhaRN;

	Cache(FolhaRN folhaRN) {
		this.folhaRN = folhaRN;
		idsFolhasPorProduto = new HashMap<String, Set<Long>>();
		grupoProducaoHoraPorProduto = new HashMap<String, Map<String, ProducaoHora>>();

	}

	public void agruparProducaoHora(String cdProduto, DwFolha dwFolha, ProducaoHora producaoHora) {

		Map<String, ProducaoHora> agrupamentoHoraDoChaveGrupo = getAgrupamentoHoraChaveGrupo(cdProduto);

		String key = getKeyAgrumanentoHora(producaoHora.getDthrIHora(), dwFolha.getIdFolha());
		ProducaoHora producaoHoraPesquisada = agrupamentoHoraDoChaveGrupo.get(key);
		if (producaoHoraPesquisada == null) {
			agrupamentoHoraDoChaveGrupo.put(key, producaoHora);
		} else {
			producaoHoraPesquisada.agrupar(producaoHora);
		}

	}

	private Map<String, ProducaoHora> getAgrupamentoHoraChaveGrupo(String cdProduto) {
		Map<String, ProducaoHora> agrupamentoHoraDoChaveGrupo = grupoProducaoHoraPorProduto.get(cdProduto);
		if (agrupamentoHoraDoChaveGrupo == null) {
			agrupamentoHoraDoChaveGrupo = new HashMap<String, ProducaoHora>();
			grupoProducaoHoraPorProduto.put(cdProduto, agrupamentoHoraDoChaveGrupo);
		}
		return agrupamentoHoraDoChaveGrupo;
	}

	public Collection<ProducaoHora> getProducoesHora(String cdProduto) {
		return getAgrupamentoHoraChaveGrupo(cdProduto).values();
	}

	public Set<String> getProdutos() {
		return grupoProducaoHoraPorProduto.keySet();
	}

	public AnaliseProducaoEficienciaHoraAHoraDTO getRelatorioProduto(ListaDTOAnaliseProducaoEficienciaHoraAHora relatorio,
			Map<String, AnaliseProducaoEficienciaHoraAHoraDTO> relatorioProdutos, final OmProduto omProduto) {
		AnaliseProducaoEficienciaHoraAHoraDTO relatorioProduto = relatorioProdutos.get(omProduto.getCdProduto());
		if (relatorioProduto == null) {
			relatorioProduto = AnaliseProducaoEficienciaHoraAHoraRN.createRelatorioProduto(omProduto);
			relatorioProdutos.put(omProduto.getCdProduto(), relatorioProduto);
			relatorio.getListaDTOs().add(relatorioProduto);
		}
		return relatorioProduto;
	}

	/**
	 * Chave pra o grupo de dados da hora. <br>
	 * Existem situações em que é criado um novo DwConsolid dentro da mesma hora para um PpCp, <br>
	 * fazendo a quebra por DwPeproTemplate.Type. <br>
	 * Mas para o relatório, este dados devem aparecer juntos, e não em linhas diferentes.<br>
	 * Para isso os dados que devem ficar relacionados ao mesmo intervalo de hora, são agrupados usando esta chave gerada.
	 *
	 * @param dwConsolid
	 * @return
	 */
	private String getKeyAgrumanentoHora(Date dtHrIHora, long idFolha) {

		return new StringBuilder().append(dtHrIHora).append('.').append(idFolha).toString();
	}

	private BigDecimal getCavidades(Map<String, Map<Long, BigDecimal>> cache, OmProduto omProduto, DwFolha dwFolha) {
		Map<Long, BigDecimal> cacheCavidadesAtivaProduto = cache.get(omProduto.getCdProduto());
		if (cacheCavidadesAtivaProduto == null) {
			cacheCavidadesAtivaProduto = new HashMap<Long, BigDecimal>();
			cache.put(omProduto.getCdProduto(), cacheCavidadesAtivaProduto);
		}
		return cacheCavidadesAtivaProduto.get(dwFolha.getIdFolha());
	}

	private void putCavidades(Map<String, Map<Long, BigDecimal>> cache, OmProduto omProduto, DwFolha dwFolha, BigDecimal valor) {
		Map<Long, BigDecimal> valores = cache.get(omProduto.getCdProduto());
		valores.put(dwFolha.getIdFolha(), valor);
	}

	public BigDecimal getCavidadesTotais(DwFolha dwFolha, OmProduto omProduto) {

		BigDecimal cavidadesTotais = getCavidades(cacheCavidadesTotaisProdutoFolha, omProduto, dwFolha);
		if (cavidadesTotais == null) {
			try {
				cavidadesTotais = folhaRN.getPcsPorCicloTodas(dwFolha, omProduto);
			} catch (SemPcsPorCicloAtivasException e) {
				cavidadesTotais = BigDecimal.ONE;
			}
			putCavidades(cacheCavidadesTotaisProdutoFolha, omProduto, dwFolha, cavidadesTotais);
		}
		return cavidadesTotais;
	}

	public BigDecimal getCavidadesAtivas(DwFolha dwFolha, OmProduto omProduto) {
		BigDecimal cavidadesAtivas = getCavidades(cacheCavidadesAtivasProdutoFolha, omProduto, dwFolha);
		if (cavidadesAtivas == null) {
			try {
				cavidadesAtivas = folhaRN.getPcsPorCicloAtivas(dwFolha, omProduto);
			} catch (SemPcsPorCicloAtivasException e) {
				cavidadesAtivas = BigDecimal.ONE;
			}
			putCavidades(cacheCavidadesAtivasProdutoFolha, omProduto, dwFolha, cavidadesAtivas);
		}
		return cavidadesAtivas;
	}

	public boolean addFolha(String cdProduto, DwFolha dwFolha) {
		Set<Long> idsFolha = idsFolhasPorProduto.get(cdProduto);
		if (idsFolha == null) {
			idsFolha = new HashSet<Long>();
			idsFolhasPorProduto.put(cdProduto, idsFolha);
		}
		return idsFolha.add(dwFolha.getIdFolha());
	}

}
