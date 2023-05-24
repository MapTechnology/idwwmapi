package idw.model.rn;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.dao.TeTarifasDAO;
import idw.model.pojos.OmPt;
import idw.model.pojos.TeTarifas;
import idw.model.pojos.TeTarifasemanal;
import idw.webservices.dto.TeTarifaDTO;
import idw.webservices.dto.TeTarifasDTO;
import idw.webservices.dto.TeTarifasemanalDTO;

public class TarifaRN extends AbstractRN<DAOGenerico> {

	public TarifaRN() {
		this(null);
	}

	public TarifaRN(DAOGenerico dao) {
		super(dao);
		if(dao == null){
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}
	
	@SuppressWarnings("unchecked")
	public TeTarifasDTO getTeTarifaDTO (TeTarifaDTO filtro) {
		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("select t");
		q.append("from TeTarifas t");
		q.append("where 1 = 1");

		if(filtro.getTeTarifa().getIdTarifas()!=0) {
			q.append("AND t.idTarifas =:idTarifas");
		} else {
			if(filtro.getTeTarifa().getTeConcessionaria() != null) {
				if(filtro.getTeTarifa().getTeConcessionaria().getCdConcessionaria() != null 
						&& !filtro.getTeTarifa().getTeConcessionaria().getCdConcessionaria().equals("")) {
					q.append("AND t.teConcessionaria.cdConcessionaria =:cdConcessionaria");
				}
				if(filtro.getTeTarifa().getTeConcessionaria().getDsConcessionaria() != null 
						&& !filtro.getTeTarifa().getTeConcessionaria().getDsConcessionaria().equals("")) {
					q.append("AND t.teConcessionaria.dsConcessionaria =:dsConcessionaria");
				}
			}

			if(filtro.getTeTarifa().getTeLei() != null) {
				if(filtro.getTeTarifa().getTeLei().getCdLei() != null 
						&& !filtro.getTeTarifa().getTeLei().getCdLei().equals("")) {
					q.append("AND t.teLei.cdLei =:cdLei");
				}
				if(filtro.getTeTarifa().getTeLei().getDsLei() != null 
						&& !filtro.getTeTarifa().getTeLei().getDsLei().equals("")) {
					q.append("AND t.teLei.dsLei =:dsLei");
				}
			}

			if(filtro.getTeTarifa().getTeTipoConsumidor() != null) {
				if(filtro.getTeTarifa().getTeTipoConsumidor().getCdTipoConsumidor() != null
						&& !filtro.getTeTarifa().getTeTipoConsumidor().getCdTipoConsumidor().equals("")) {
					q.append("AND t.teTipoConsumidor.cdTipoConsumidor =:cdTipoConsumidor");
				}
				if(filtro.getTeTarifa().getTeTipoConsumidor().getDsTipoConsumidor() != null
						&& !filtro.getTeTarifa().getTeTipoConsumidor().getDsTipoConsumidor().equals("")) {
					q.append("AND t.teTipoConsumidor.dsTipoConsumidor =:dsTipoConsumidor");
				}
			}
			
		}

		if(filtro.getTeTarifa().getIdTarifas()!=0) {
			q.defineParametro("idTarifas", filtro.getTeTarifa().getIdTarifas());
		}

		if(filtro.getTeTarifa().getTeConcessionaria() != null) {
			if(filtro.getTeTarifa().getTeConcessionaria().getCdConcessionaria() != null 
					&& !filtro.getTeTarifa().getTeConcessionaria().getCdConcessionaria().equals("")) {
				q.defineParametro("cdConcessionaria", filtro.getTeTarifa().getTeConcessionaria().getCdConcessionaria());
			}
			if(filtro.getTeTarifa().getTeConcessionaria().getDsConcessionaria() != null 
					&& !filtro.getTeTarifa().getTeConcessionaria().getDsConcessionaria().equals("")) {
				q.defineParametro("dsConcessionaria", filtro.getTeTarifa().getTeConcessionaria().getDsConcessionaria());
			}
		}
		if(filtro.getTeTarifa().getTeLei() != null) {
			if(filtro.getTeTarifa().getTeLei().getCdLei() != null 
					&& !filtro.getTeTarifa().getTeLei().getCdLei().equals("")) {
				q.defineParametro("cdLei", filtro.getTeTarifa().getTeLei().getCdLei());
			}
			if(filtro.getTeTarifa().getTeLei().getDsLei() != null 
					&& !filtro.getTeTarifa().getTeLei().getDsLei().equals("")) {
				q.defineParametro("dsLei", filtro.getTeTarifa().getTeLei().getDsLei());
			}
		}
		if(filtro.getTeTarifa().getTeTipoConsumidor() != null) {
			if(filtro.getTeTarifa().getTeTipoConsumidor().getCdTipoConsumidor() != null
					&& !filtro.getTeTarifa().getTeTipoConsumidor().getCdTipoConsumidor().equals("")) {
				q.defineParametro("cdTipoConsumidor", filtro.getTeTarifa().getTeTipoConsumidor().getCdTipoConsumidor());
			}
			if(filtro.getTeTarifa().getTeTipoConsumidor().getDsTipoConsumidor() != null
					&& !filtro.getTeTarifa().getTeTipoConsumidor().getDsTipoConsumidor().equals("")) {
				q.defineParametro("dsTipoConsumidor", filtro.getTeTarifa().getTeTipoConsumidor().getDsTipoConsumidor());
			}
		}

		List<TeTarifas> listaPesquisa = null;
		try {
			listaPesquisa = q.query().list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<TeTarifaDTO> lista = new ArrayList<TeTarifaDTO>();

		if (listaPesquisa!=null) {
			for (TeTarifas item : listaPesquisa) {
				TeTarifaDTO teTarifaDTO = new TeTarifaDTO();
				teTarifaDTO.setTeTarifa(item.clone());
				lista.add(teTarifaDTO);
			}
		}

		TeTarifasDTO listaRetorno = new TeTarifasDTO ();
		listaRetorno.setListaTeTarifaDTO(lista);

		return listaRetorno;
	}

	public TeTarifaDTO setTeTarifaDTO(TeTarifaDTO itemDTO) {

		TeTarifaDTO dtoRetorno = new TeTarifaDTO();
		
		if(itemDTO == null || itemDTO.getTeTarifa() == null) {
			dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_DESCONHECIDO());
			return dtoRetorno;
		}
		if(itemDTO.getTeTarifa().getTeTipoConsumidor() == null || 
				itemDTO.getTeTarifa().getTeTipoConsumidor().getCdTipoConsumidor().equals("") || 
				itemDTO.getTeTarifa().getTeTipoConsumidor().getDsTipoConsumidor().equals("")) {
			dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_CDTIPOCONSUMIDOR_INVALIDA());
			return dtoRetorno;
		}
		if(itemDTO.getTeTarifa().getTeConcessionaria() == null || 
				itemDTO.getTeTarifa().getTeConcessionaria().getCdConcessionaria().equals("") || 
				itemDTO.getTeTarifa().getTeConcessionaria().getDsConcessionaria().equals("") ) {
			dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_CDCONCESSIONARIA_INVALIDA());	
			return dtoRetorno;
		}
		if(itemDTO.getTeTarifa().getTeLei() == null || 
				itemDTO.getTeTarifa().getTeLei().getCdLei().equals("") ||
				itemDTO.getTeTarifa().getTeLei().getDsLei() == null) {
			dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_CDLEI_INVALIDO());
			return dtoRetorno;
		}

		TeTarifasDAO dao = new TeTarifasDAO(getDaoSession());
		List<TeTarifas> listaTarifas = dao.getTodasTeTarifas();
		for(TeTarifas tarifa : listaTarifas) {
			if(DataHoraRN.after(itemDTO.getTeTarifa().getDtInicioTarifa(), tarifa.getDtInicioTarifa()) &&
					DataHoraRN.before(itemDTO.getTeTarifa().getDtInicioTarifa(), tarifa.getDtFimTarifa())) {
				dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_TARIFA_JA_EXISTE());
				return dtoRetorno;
			}
			if(DataHoraRN.before(itemDTO.getTeTarifa().getDtInicioTarifa(), tarifa.getDtInicioTarifa()) && 
					DataHoraRN.after(itemDTO.getTeTarifa().getDtFimTarifa(), tarifa.getDtInicioTarifa())){
				dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_TARIFA_JA_EXISTE());
				return dtoRetorno;
			}
		}

		TeTarifas tarifaOriginal = dao.getTeTarifasPorId(itemDTO.getTeTarifa().getIdTarifas());
		
		if (tarifaOriginal == null) {
			tarifaOriginal = itemDTO.getTeTarifa().clone();
			tarifaOriginal.getTeTarifasemanals().clear();
		} else {
			tarifaOriginal.copy(itemDTO.getTeTarifa(), false);
			tarifaOriginal.setTeConcessionaria(itemDTO.getTeTarifa().getTeConcessionaria());
			tarifaOriginal.setTeTipoConsumidor(itemDTO.getTeTarifa().getTeTipoConsumidor());
			tarifaOriginal.setTeLei(itemDTO.getTeTarifa().getTeLei());
		}
			
		excluirTarifasSemanaisDaTarifa(itemDTO, tarifaOriginal);

		if(tarifaOriginal.getTeTarifasemanals() != null) {
			for(TeTarifasemanal item : itemDTO.getTeTarifa().getTeTarifasemanals()) {
				if(item.getIdTarifasemanal() == 0) {
					incluirTarifaSemanalNaTarifa(tarifaOriginal, item);
				} else {
					alterarTarifaSemanalDaTarifa(tarifaOriginal, itemDTO);
				}
			}
		}
		
		if(dtoRetorno.getResultadoEvento() == dtoRetorno.getEVENTO_BEM_SUCEDIDO()) {
			try {
				tarifaOriginal = this.getDao().makePersistent(tarifaOriginal);
			} catch (Exception e) {
				e.printStackTrace();
				dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_DESCONHECIDO());
				return dtoRetorno;
			}
			dtoRetorno.setTeTarifa(tarifaOriginal.clone());
		}
		
		return dtoRetorno;
	}
	
	private void excluirTarifasSemanaisDaTarifa(TeTarifaDTO itemDTO, TeTarifas tarifaOriginal) {
		if(itemDTO.getTarifasSemanaisExcluidas() != null && itemDTO.getTarifasSemanaisExcluidas().getListaTeTarifasemanalDTO() != null) {
			if(!itemDTO.getTarifasSemanaisExcluidas().getListaTeTarifasemanalDTO().isEmpty()) {
				for(TeTarifasemanalDTO dto : itemDTO.getTarifasSemanaisExcluidas().getListaTeTarifasemanalDTO()) {
					for(Iterator<TeTarifasemanal> iterator = tarifaOriginal.getTeTarifasemanals().iterator() ; iterator.hasNext();){
						TeTarifasemanal tarifaSemanal = iterator.next();
						if (dto.getTeTarifasemanal().getIdTarifasemanal() == tarifaSemanal.getIdTarifasemanal()){
							this.getDaoSession().delete(tarifaSemanal);
							iterator.remove();
							continue;
						}
					}
				}
			}			
		}
	}
	
	private void incluirTarifaSemanalNaTarifa(TeTarifas tarifaOriginal, TeTarifasemanal item) {
		TeTarifasemanal novaTarifaSemanal = new TeTarifasemanal();
		novaTarifaSemanal.copy(item, false);
		novaTarifaSemanal.setTeTarifas(tarifaOriginal);
		tarifaOriginal.getTeTarifasemanals().add(novaTarifaSemanal);
	}
	
	private void alterarTarifaSemanalDaTarifa(TeTarifas tarifaOriginal, TeTarifaDTO itemDTO) {
		List<TeTarifasemanal> listaAlteracao = new ArrayList<>();
		for(TeTarifasemanal semanalBase : tarifaOriginal.getTeTarifasemanals()) {
			for(TeTarifasemanal semanalTela : itemDTO.getTeTarifa().getTeTarifasemanals()/*listaTarifasSemanais*/) {
				if(semanalTela.getIdTarifasemanal() == semanalBase.getIdTarifasemanal()) {
					semanalBase.setDiaSemanaInicio(semanalTela.getDiaSemanaInicio());
					semanalBase.setDiaSemanaFim(semanalTela.getDiaSemanaFim());
					semanalBase.setHrInicio(semanalTela.getHrInicio());
					semanalBase.setHrFim(semanalTela.getHrFim());
					semanalBase.setVlTarifademanda(semanalTela.getVlTarifademanda());
					semanalBase.setVlTarifaconsumo(semanalTela.getVlTarifaconsumo());
					listaAlteracao.add(semanalBase);
				}
			}
		}
		for(TeTarifasemanal alterado : listaAlteracao) {
			tarifaOriginal.getTeTarifasemanals().add(alterado);
		}
	}
	
	public TeTarifaDTO excluirTeTarifa(TeTarifaDTO itemDTO) {
		TeTarifaDTO retorno = new TeTarifaDTO();
		retorno.setResultadoEvento(retorno.getEVENTO_BEM_SUCEDIDO());
		try {
			TeTarifasDAO dao = new TeTarifasDAO(getDaoSession());
			TeTarifas tarifaOriginal = dao.getTeTarifasPorId(itemDTO.getTeTarifa().getIdTarifas());
			this.getDaoSession().delete(tarifaOriginal);
		} catch (Exception e) {
			e.printStackTrace();
			retorno.setResultadoEvento(retorno.getERRO_DESCONHECIDO());
		}
		return retorno;
	}
	
	public static void main(String[] args) {
		TarifaRN rn = new TarifaRN();
		rn.iniciaConexaoBanco();
		Date dthrConsumo = DataHoraRN.getDataHora(2015, 10, 15, 9, 04, 0, 0);

		BigDecimal retorno = rn.getValorMonetario(null, dthrConsumo, BigDecimal.ONE);
		System.out.println("valor momnetario = " + retorno);
		rn.finalizaConexaoBanco();
	}
	/*
	 * Metodo respons�vel em obter o valor monetario de determinado pt em determinada data e hora
	 */
	public BigDecimal getValorMonetario(OmPt ompt, Date dthrConsumo, BigDecimal energiaConsumida) {
		BigDecimal retorno = BigDecimal.ZERO;
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select a");
		q.append("from TeTarifas a");
		q.append("join fetch a.teTarifasemanals b");
		
		// Filtro para obter a tarifa na validade correta
		List<TeTarifas> lista = q.list();
		int diaSemana = DataHoraRN.getDiaSemana(dthrConsumo) - 1;
		int hora = DataHoraRN.getSegundosDoDia(dthrConsumo);
		
		for (TeTarifas tetarifas : lista) {
			if (DataHoraRN.isIntersecao(dthrConsumo, tetarifas.getDtInicioTarifa(), tetarifas.getDtFimTarifa())) {
				for (TeTarifasemanal semanal : tetarifas.getTeTarifasemanals()) {
					if (isIntersecaoDia(diaSemana, semanal.getDiaSemanaInicio(), semanal.getDiaSemanaFim()) ) {
						if (isIntersecaoHora(hora, semanal.getHrInicio().intValue(), semanal.getHrFim().intValue()))  {
							retorno = semanal.getVlTarifaconsumo();
						}
					}
				}
			}
		}
		return retorno.multiply(energiaConsumida).setScale(4);
	}

	private boolean isIntersecaoDia(int dia, int diaInicio, int diaFim) {
		return dia >= diaInicio && dia <= diaFim;
	}
	
	private boolean isIntersecaoHora(int hora, int horaInicio, int horaFim) {
		return hora >= horaInicio && hora <= horaFim;
	}
}