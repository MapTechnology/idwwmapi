package idw.model.rn.injet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.pojos.injet.Ijtbinj;
import idw.model.pojos.injet.Ijtbtur;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.injet.dto.AnalisePeriodoInjetDTO;
import idw.model.rn.injet.dto.FiltroAnalisePeriodoInjetDTO;
import idw.model.rn.injet.dto.FiltroMaquinaInjetDTO;
import idw.model.rn.injet.dto.IndicadoresPorDataInjetDTO;
import idw.model.rn.injet.dto.MaquinaInjetDTO;
import idw.model.rn.injet.dto.RodapeAnalisePeriodoInjetDTO;

public class AnalisePeriodoInjetRN extends AbstractRN<DAOGenericoInjet>{

	public AnalisePeriodoInjetRN(DAOGenericoInjet dao) {
		super(dao);
	}

	public AnalisePeriodoInjetDTO analisarPeriodo(FiltroAnalisePeriodoInjetDTO filtro)  {
		AnalisePeriodoInjetDTO analisePeriodoDTO = new AnalisePeriodoInjetDTO();
		RodapeAnalisePeriodoInjetDTO rodapeAnalisePeriodoDTO = new RodapeAnalisePeriodoInjetDTO();
		RodapeAnalisePeriodoInjetDTO rodapeApenasDaDataAvaliada = new RodapeAnalisePeriodoInjetDTO();

		MaquinaInjetDTO maquinaDTO = new MaquinaInjetDTO();

		List<Ijtbinj> listaIjtbinj = new ArrayList<Ijtbinj>();
		List<Ijtbtur> listaIjtbtur = new ArrayList<Ijtbtur>();
		try{
			
			CalendarioInjetRN calendarioRN = new CalendarioInjetRN(getDao());
			calendarioRN.setDaoSession(getDaoSession());
			
			MaquinaInjetRN maquinaRN = new MaquinaInjetRN(getDao());
			maquinaRN.setDaoSession(getDaoSession());
			
			if (filtro.getCdTurno() == null || filtro.getCdTurno().equals("999999") || filtro.getCdTurno().equals("")){
				filtro.setCdTurno("");
				listaIjtbtur = calendarioRN.pesquisarTodosOsTurnosValidos();
			} else {
				Ijtbtur ijtbturno = calendarioRN.pesquisarIjtbtur(filtro.getCdTurno());
				listaIjtbtur.add(ijtbturno);
			}
	
			if (filtro.getCdMaquinaGrupo() == null || filtro.getCdMaquinaGrupo().equals("")){
				Ijtbinj ijtbinj = new Ijtbinj();
				ijtbinj.setCdinjetora(filtro.getCdMaquina());
				listaIjtbinj.add(ijtbinj);
			} else
				listaIjtbinj = maquinaRN.pesquisarListaMaquinasDeUmGrupo(filtro.getCdMaquinaGrupo());
	
			for (Date dataEmAvaliacao = filtro.getDtInicio(); !DataHoraRN.after(dataEmAvaliacao, filtro.getDtFim());){
	
				rodapeApenasDaDataAvaliada = new RodapeAnalisePeriodoInjetDTO();
	
				for (Ijtbinj ijtbinj : listaIjtbinj){
	
					for (Ijtbtur ijtbtur : listaIjtbtur){
						FiltroMaquinaInjetDTO filtroMaquinaDTO = new FiltroMaquinaInjetDTO();
						filtroMaquinaDTO.setCdMaquina(ijtbinj.getCdinjetora());
						filtroMaquinaDTO.setCdMaquinaGrupo(filtro.getCdMaquinaGrupo());
						filtroMaquinaDTO.setCdMolde(filtro.getCdMolde());
						filtroMaquinaDTO.setCdMoldeGrupo(filtro.getCdMoldeGrupo());
						filtroMaquinaDTO.setCdProduto(filtro.getCdProduto());
						filtroMaquinaDTO.setCdTurno(ijtbtur.getCdturno());
						filtroMaquinaDTO.setData(dataEmAvaliacao);
						filtroMaquinaDTO.setObterParadasPorArea(filtro.isObterParadasPorArea());
						filtroMaquinaDTO.setObterParadasPorMotivo(filtro.isObterParadasPorMotivo());
	
						try{
							maquinaDTO = maquinaRN.analisarMaquina(filtroMaquinaDTO);
						} catch (Exception e){
							e.printStackTrace();
						}
						maquinaDTO.setIjtbinj(ijtbinj);
	
						rodapeAnalisePeriodoDTO.addMaquinaTotalDTO(maquinaDTO.getMaquinaTotalDTO());
						rodapeApenasDaDataAvaliada.addMaquinaTotalDTO(maquinaDTO.getMaquinaTotalDTO());
	
						// Salva informacoes da maquina processada
						if (maquinaDTO.getProdutos().size() != 0){
							analisePeriodoDTO.addIndicadoresPorMaquina(maquinaDTO);
						}
	
						// Salva informacoes do turno processado
						analisePeriodoDTO.addIndicadoresPorTurno(ijtbtur, maquinaDTO);
					}
				}
				// Armazena dados para o Grafico 1 e 2
				IndicadoresPorDataInjetDTO indicadoresPorData = new IndicadoresPorDataInjetDTO();
				indicadoresPorData.setData(dataEmAvaliacao);
				indicadoresPorData.setEc(rodapeApenasDaDataAvaliada.getEficienciaCiclo());
				indicadoresPorData.setEr(rodapeApenasDaDataAvaliada.getEficienciaRealizacao());
				indicadoresPorData.setIp(rodapeApenasDaDataAvaliada.getIndiceParada());
				indicadoresPorData.setIpd(rodapeApenasDaDataAvaliada.getIndicePerda());
				indicadoresPorData.setIr(rodapeApenasDaDataAvaliada.getIndiceRefugo());
				indicadoresPorData.setPerdasCavidades(rodapeApenasDaDataAvaliada.getPerdaCavidadeUnidade());
				indicadoresPorData.setPerdasCiclo(rodapeApenasDaDataAvaliada.getPerdaCicloUnidade());
				indicadoresPorData.setPerdasParada(rodapeApenasDaDataAvaliada.getPerdaParadasUnidade());
				indicadoresPorData.setPerdasRefugo(rodapeApenasDaDataAvaliada.getProducaoRefugadaUnidade());
				analisePeriodoDTO.addIndicadoresPorData(indicadoresPorData);
	
	
				dataEmAvaliacao = DataHoraRN.advanceDate(dataEmAvaliacao, 1);
			}
			// Realizar calculos necessarios para o periodo e maquinas somadas
			rodapeAnalisePeriodoDTO.calcularFormulasNecessarias();
	
			analisePeriodoDTO.setRodape(rodapeAnalisePeriodoDTO);
		}catch(Exception e){
			e.printStackTrace();
		}
		return analisePeriodoDTO;
	}
}