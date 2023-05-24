package idw.model.rn.geraplano.passos.tipoA;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.SortedMap;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwEst;
import idw.model.pojos.DwEstpro;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmProcomest;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpCpfaltamp;
import idw.model.pojos.PpPlano;
import idw.model.rn.DataHoraRN;
import idw.model.rn.geraplano.dtos.CtDTO;
import idw.model.rn.geraplano.dtos.IdCtDTO;
import idw.model.rn.geraplano.dtos.PassosDTO;
import idw.util.IdwLogger;
import idw.util.Util;

public class TipoAAvaliandoMateriaPrima {

	private DAOGenerico dao;

	public TipoAAvaliandoMateriaPrima(DAOGenerico dao){
		this.dao = dao;
	}
	
	public SortedMap<IdCtDTO, CtDTO> geraCpsAvaliandoMP(IdwLogger log, int idLog, int identacao, PpPlano ppplano, OmUsr omusr, 
			SortedMap<IdCtDTO, CtDTO> listaParaProcessamento){
		// Obter uma lista com todas as CPs ordenadas cronologicamente
		List<PassosDTO> todosOsPassos = new ArrayList<PassosDTO>();
		for (IdCtDTO idctdto : listaParaProcessamento.keySet()){
			CtDTO ctdto = listaParaProcessamento.get(idctdto);

			for (PassosDTO p : ctdto.getPassosAlocados()) {
				todosOsPassos.add(p);
			}
		}
		// Ordena cronologicamente pela data inicial
		Collections.sort(todosOsPassos, new Comparator<PassosDTO>() {
			@Override
			public int compare(PassosDTO o1, PassosDTO o2) {
				return (DataHoraRN.before(o1.getInicio(), o2.getInicio()) ? -1 : DataHoraRN.after(o1.getInicio(), o2.getInicio()) ? +1 : 0);
			}
		});
		
		MapQuery q = new MapQuery(dao.getSession());
		q.append("from OmProcomest omprocomest");
		q.append("where omprocomest.omProdutoByIdProduto = :omproduto");
		
		MapQuery qSaldo = new MapQuery(dao.getSession());
		qSaldo.append("from DwEstpro dwestpro");
		qSaldo.append("where dwestpro.omProduto = :omproduto");
		qSaldo.setMaxResults(1);

		// Obtem o estoque a ser usado quando for necessario incluir o saldo de estoque de um componente
		OmCfg omcfg = Util.getConfigGeral(dao.getSession());
		DwEst dwest = omcfg.getDwEstByIdEstmp();
		
		// Interagir sobre a lista de CPs ordenadas cronologicamente
		for (PassosDTO p : todosOsPassos){

			boolean isPossuiMPSuficiente = true;
			
			// Para o produto da CP, obter a estrutura de materia-prima a ser consumida, sem os produtos semi-acabados
			// Os produtos semi-acabados estão presentes em algum roteiro
			log.info("Avaliando consumo materia-prima para o produto " + p.getOmproduto().getOmproduto().getCdProduto());
			
			// Interagir sobre cada componentes
			q.defineParametro("omproduto", p.getOmproduto().getOmproduto());
			List<OmProcomest> lista = q.list();
			
			for (OmProcomest est : lista){
				log.info("Materia-prima " + est.getOmProdutoByIdProdutomp().getCdProduto());
				if(est.getOmProdutoByIdProdutomp().getCdProduto().equals("493204")){
					log.info("DEBUG");
				}
			
				// Verificar se o componentes possui estoque suficiente
				double qtNecessariaDoEstoque = est.getQtUsada().doubleValue() * p.getProducaoPlanejada();
				double qtParaReservar = 0d;
				qSaldo.defineParametro("omproduto", est.getOmProdutoByIdProdutomp());
				DwEstpro dwestpro = (DwEstpro) qSaldo.uniqueResult();
				
				if (dwestpro == null){
					dwestpro = new DwEstpro();
					dwestpro.setDwEst(dwest);
					dwestpro.setIdEstpro(null);
					dwestpro.setOmProduto(est.getOmProdutoByIdProdutomp());
					dwestpro.setPpCliente(p.getOmproduto().getOmproduto().getPpCliente());
					dwestpro.setQtAjuste(BigDecimal.ZERO);
					dwestpro.setQtEntrada(BigDecimal.ZERO);
					dwestpro.setQtSaida(BigDecimal.ZERO);
					dwestpro.setQtReservada(BigDecimal.ZERO);
				}
				
				if (dwestpro.getQtReservada() == null)
					dwestpro.setQtReservada(BigDecimal.ZERO);
				
				// Se tiver estoque suficiente passa para o proximo componente
				if (qtNecessariaDoEstoque <= obtemSaldoConsiderandoReserva(dwestpro)) {
					qtParaReservar = dwestpro.getQtReservada().add(new BigDecimal(qtNecessariaDoEstoque)).doubleValue();
				} else {
					qtParaReservar = obtemSaldoConsiderandoReserva(dwestpro);
					isPossuiMPSuficiente = false;

					// Se nao tiver estoque suficiente verificar se tem materia-prima agendada para chegar
					
					// Se nao tiver estoque materia-prima � pra considerar componentes alternativo
					
					// Se for, entao avaliar o estoque do alternativo
					
					// Salvar na Cp a materia-prima faltante
					PpCpfaltamp mp = new PpCpfaltamp();
					mp.setIdCpfaltamp(null);
					mp.setOmProduto(est.getOmProdutoByIdProdutomp());
					mp.setQtde( new BigDecimal(qtNecessariaDoEstoque - obtemSaldoConsiderandoReserva(dwestpro))); // quantidade que falta da materia-prima
					mp.setStMp(1);
					p.getMpfaltante().add(mp);
				}
				
				// Reservar a materia-prima necessaria
				dwestpro.setQtReservada(new BigDecimal(qtParaReservar));
				dao.makePersistent(dwestpro);
			
				// Se não, entao marcar a CP como falta de materia prima e passa para a proxima
				p.setPossuiMPSuficiente(isPossuiMPSuficiente);
			}
		}
		
		return listaParaProcessamento;
	}


	private double obtemSaldoConsiderandoReserva(DwEstpro dwestpro) {
		double saldo = dwestpro.getQtEntrada().doubleValue();

		saldo -= dwestpro.getQtSaida().doubleValue();
		saldo += dwestpro.getQtAjuste().doubleValue();

		return saldo;
	}

}
