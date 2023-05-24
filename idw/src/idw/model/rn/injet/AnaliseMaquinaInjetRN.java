package idw.model.rn.injet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.pojos.injet.Ijgalobj;
import idw.model.pojos.injet.Ijtbgal;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.injet.dto.AODetalheInjetDTO;
import idw.model.rn.injet.dto.AOGalpaoInjetDTO;
import idw.model.rn.injet.dto.AOMaquinaInjetDTO;
import idw.model.rn.injet.dto.AnaliseOEEMaquinaInjetDTO;
import idw.model.rn.injet.dto.FiltroInjetDTO;
import idw.model.rn.injet.dto.FiltroMaquinaInjetDTO;
import idw.model.rn.injet.dto.MaquinaInjetDTO;
import idw.model.rn.injet.dto.MesInjetDTO;
import idw.util.FormulasInjet;

public class AnaliseMaquinaInjetRN extends AbstractRN<DAOGenericoInjet>{

	public AnaliseMaquinaInjetRN(DAOGenericoInjet dao) {
		super(dao);
	}

	private boolean isMesNaRangeDoFiltro(MesInjetDTO mes, FiltroInjetDTO filtro){

		boolean retorno = false;
		
		String mesInicio = "";
		String mesFim = "";
		String mesAtual = "";
		
		if (filtro.getMesInicio() < 10)
			mesInicio = "0";
		
		mesInicio = mesInicio + filtro.getMesInicio();
		
		if (filtro.getMesFinal() < 10)
			mesFim = "0";
		
		mesFim = mesFim + filtro.getMesFinal();
		
		if (mes.getMes() < 10)
			mesAtual = "0";
		
		mesAtual = mesAtual + mes.getMes();
		
		int anoMesInicio = Integer.valueOf(filtro.getAnoInicio() + "" + mesInicio);
		int anoMesFim = Integer.valueOf(filtro.getAnoFinal() + "" + mesFim);
		
		int anoMesAvaliado = Integer.valueOf(mes.getAno() + "" + mesAtual);
		
		if (anoMesAvaliado >= anoMesInicio && anoMesAvaliado <= anoMesFim)
			retorno = true;
		
		if (mes.getMes() == 13)
			retorno = true;

		return retorno;	
	}
	
	public AnaliseOEEMaquinaInjetDTO getAnaliseOEEMaquina(FiltroInjetDTO filtro){
		List<MesInjetDTO> meses = new ArrayList<MesInjetDTO>();
		List<String> descricaoMeses = new ArrayList<String>();

		List<AOGalpaoInjetDTO> galpoes = new ArrayList<AOGalpaoInjetDTO>();
		List<AOMaquinaInjetDTO> maquinas = new ArrayList<AOMaquinaInjetDTO>();
		List<AODetalheInjetDTO> detalhes = new ArrayList<AODetalheInjetDTO>();
		List<AODetalheInjetDTO> acumulado = new ArrayList<AODetalheInjetDTO>();

		// Gera em meses, os meses a serem apresentados de acordo com o filtro

		for (int iano = filtro.getAnoInicio();iano<=filtro.getAnoFinal();iano++){
			for (int imes = 1; imes <= 12; imes++){
				meses.add(new MesInjetDTO(iano, imes));
			}
			meses.add(new MesInjetDTO(iano, 13));
		}

		// Obtem a descricao dos meses
		for (MesInjetDTO mes : meses){
			if (isMesNaRangeDoFiltro(mes, filtro)){
				descricaoMeses.add(mes.getDescricaoReduzidaMes() + "/" + mes.getAno());
			}
		}

		// Fixo sao as linhas detalhes fixas (nao paradas) com todos os messes

		List<Ijtbgal> listaIjtbgal = filtro.getListaDeIjtbgal(getDao());

		Date dtInicioFuncionamentoInjet = DataHoraRN.getDataInicioInjetNaSulbras();
		
		MaquinaInjetRN maquinaRN = new MaquinaInjetRN(null);
		maquinaRN.setDaoSession(getDaoSession());
		
		ConsultasInjetRN consultasRN = new ConsultasInjetRN(null);
		consultasRN.setDaoSession(getDaoSession());

		// Avalia cada maquina encontrada
		if (listaIjtbgal != null){
			for (Ijtbgal ijtbgal : listaIjtbgal){

				AOGalpaoInjetDTO galpao;

				if (ijtbgal.getIjgalobjs() == null || ijtbgal.getIjgalobjs().size() <= 0){
					continue;
				}

				maquinas = new ArrayList<AOMaquinaInjetDTO>();
				
				List<Ijgalobj> injetoras = new ArrayList<Ijgalobj>();
				for (Ijgalobj ijgalobj : ijtbgal.getIjgalobjs()){
					injetoras.add(ijgalobj);
				}
				// Ordena as injetoras
				try{
				Collections.sort(injetoras, new Comparator<Object>(){
					public int compare(Object o1, Object o2) {
						int retorno = 0;

						Ijgalobj dadosUm = (Ijgalobj) o1;
						Ijgalobj dadosDois = (Ijgalobj) o2;

						retorno = dadosUm.getIjtbinj().getCdinjestendido().compareToIgnoreCase(dadosDois.getIjtbinj().getCdinjestendido());

						return retorno;
					}
				});
				} catch (Exception e){
					e.printStackTrace();
				}

				for (Ijgalobj ijgalobj : injetoras){
					if (filtro.getCdMaquina() != null && !filtro.getCdMaquina().equals("")){
						if (!ijgalobj.getIjtbinj().getCdinjetora().equals(filtro.getCdMaquina()))
							continue;
					}


					detalhes = new ArrayList<AODetalheInjetDTO>();

					// Para cada maquina avaliar todos os meses
					
					Float somaEficienciaCiclo = 0f;
					Float somaEficienciaRealizacao = 0f;
					Float somaIndiceParada = 0f;
					Float somaIndicePerda = 0f;
					Float somaIndiceRefugo = 0f;
					Float somaOee = 0f;
					Float somaOeeCapital = 0f;

					Float quantidadeMesesParaMedia = 0f;
					
					for (MesInjetDTO mes : meses){

						if (mes.getMes() == 13){ // Valor da média no ano
							// Calcula da media
							Float mediaEficienciaCiclo = FormulasInjet.dividir(somaEficienciaCiclo, quantidadeMesesParaMedia);
							Float mediaEficienciaRealizacao = FormulasInjet.dividir(somaEficienciaRealizacao, quantidadeMesesParaMedia);
							Float mediaIndiceParada = FormulasInjet.dividir(somaIndiceParada, quantidadeMesesParaMedia);
							Float mediaIndicePerda = FormulasInjet.dividir(somaIndicePerda, quantidadeMesesParaMedia);
							Float mediaIndiceRefugo = FormulasInjet.dividir(somaIndiceRefugo, quantidadeMesesParaMedia);
							Float mediaOee = FormulasInjet.dividir(somaOee, quantidadeMesesParaMedia);
							Float mediaOeeCapital = FormulasInjet.dividir(somaOeeCapital, quantidadeMesesParaMedia);
							
							AODetalheInjetDTO detalhe; 
							detalhe = new AODetalheInjetDTO();
							detalhe.setMes(mes.getMes());
							detalhe.setAno(mes.getAno());
							detalhe.setDivisorParaMediaAcumulada(quantidadeMesesParaMedia);
							detalhe.setDsDetalhe(mes.getDescricaoMes() + "/" + mes.getAno());
							detalhe.setEficiclo(mediaEficienciaCiclo);
							detalhe.setEficienciareal(mediaEficienciaRealizacao);
							detalhe.setIndparada(mediaIndiceParada);
							detalhe.setIndperda(mediaIndicePerda);
							detalhe.setIndrefugo(mediaIndiceRefugo);
							detalhe.setOee(mediaOee);
							detalhe.setOeecapital(mediaOeeCapital);
							detalhes.add(detalhe);
							
							somaEficienciaCiclo = 0f;
							somaEficienciaRealizacao = 0f;
							somaIndiceParada = 0f;
							somaIndicePerda = 0f;
							somaIndiceRefugo = 0f;
							somaOee = 0f;
							somaOeeCapital = 0f;

							quantidadeMesesParaMedia = 0f;
							
							
							
							// Inclui entrada para media no vetor que armazena o total geral
							AODetalheInjetDTO detalheAcumulado; 
							detalheAcumulado = new AODetalheInjetDTO();
							detalheAcumulado.setMes(mes.getMes());
							detalheAcumulado.setAno(mes.getAno());
							detalheAcumulado.setDivisorParaMediaAcumulada(detalhe.getDivisorParaMediaAcumulada());
							detalheAcumulado.setDsDetalhe(mes.getDescricaoMes() + "/" + mes.getAno());
							detalheAcumulado.setEficiclo(0f);
							detalheAcumulado.setEficienciareal(0f);
							detalheAcumulado.setIndparada(0f);
							detalheAcumulado.setIndperda(0f);
							detalheAcumulado.setIndrefugo(0f);
							detalheAcumulado.setOee(0f);
							detalheAcumulado.setOeecapital(0f);
							boolean isExiste = false;
							for (AODetalheInjetDTO acu : acumulado){
								if (acu.getAno() == mes.getAno() && acu.getMes() == mes.getMes()){
									isExiste = true;
								}
							}
							if (isExiste==false)
								acumulado.add(detalheAcumulado);
			
							continue;
						}
						
						FiltroMaquinaInjetDTO filtroMaquina = new FiltroMaquinaInjetDTO();
						filtroMaquina.setCdMaquina(ijgalobj.getIjtbinj().getCdinjetora());
						filtroMaquina.setCdMolde(filtro.getCdMolde());
						filtroMaquina.setCdProduto(filtro.getCdProduto());
						filtroMaquina.setCdTurno(filtro.getCdTurno());
						filtroMaquina.setCdMoldeGrupo(filtro.getCdMoldeGrupo());
						filtroMaquina.setData(mes.getDataInicioMes()); //mes.getDataInicioMes());
						filtroMaquina.setDtFinal(mes.getDataFinalMes()); // mes.getDataFinalMes());
						filtroMaquina.setNrop(filtro.getNrop());

						if (filtro.getTipoDetalhe() == 1)
							filtroMaquina.setObterParadasPorMotivo(true);

						if (filtro.getTipoDetalhe() == 2)
							filtroMaquina.setObterParadasPorArea(true);

						// Atualizar informacoes da maquina
						MaquinaInjetDTO maquinaDTO = null;

						try{
							if ( 
									(filtro.getNrop() != null && !filtro.getNrop().equals("") ) ||
									(filtro.getCdMolde() != null && !filtro.getCdMolde().equals("") ) ||
									(filtro.getCdMoldeGrupo() != null && !filtro.getCdMoldeGrupo().equals("") ) ||
									(filtro.getCdProduto() != null && !filtro.getCdProduto().equals("")) )
								maquinaDTO = maquinaRN.analisarMaquina(filtroMaquina);
							else
								maquinaDTO = consultasRN.analisarConsultas(filtroMaquina);
						} catch (Exception e){
							e.printStackTrace();
						}
						
					
						somaEficienciaCiclo += maquinaDTO.getMaquinaTotalDTO().getEficienciaCiclo();
						somaEficienciaRealizacao += maquinaDTO.getMaquinaTotalDTO().getEficienciaRealizacao();
						somaIndiceParada += maquinaDTO.getMaquinaTotalDTO().getIndiceParada();
						somaIndicePerda += maquinaDTO.getMaquinaTotalDTO().getIndicePerda();
						somaIndiceRefugo += maquinaDTO.getMaquinaTotalDTO().getIndiceRefugo();
						somaOee += maquinaDTO.getMaquinaTotalDTO().getOee();
						somaOeeCapital += maquinaDTO.getMaquinaTotalDTO().getOeeCapital();

						// Soma se o mes for posterior a entrada em funcionamento do injet
						// ou se o mes eh anterior ou igual a data atual
						if (DataHoraRN.before(dtInicioFuncionamentoInjet, mes.getDataFinalMes()) &&
								DataHoraRN.after(DataHoraRN.getDataHoraAtual(), mes.getDataInicioMes()) ){
							quantidadeMesesParaMedia++;
						}

						AODetalheInjetDTO detalhe; 
						detalhe = new AODetalheInjetDTO();
						detalhe.setMes(mes.getMes());
						detalhe.setAno(mes.getAno());
						detalhe.setDivisorParaMediaAcumulada(quantidadeMesesParaMedia);
						detalhe.setDsDetalhe(mes.getDescricaoMes() + "/" + mes.getAno());
						detalhe.setEficiclo(maquinaDTO.getMaquinaTotalDTO().getEficienciaCiclo());
						detalhe.setEficienciareal(maquinaDTO.getMaquinaTotalDTO().getEficienciaRealizacao());
						detalhe.setIndparada(maquinaDTO.getMaquinaTotalDTO().getIndiceParada());
						detalhe.setIndperda(maquinaDTO.getMaquinaTotalDTO().getIndicePerda());
						detalhe.setIndrefugo(maquinaDTO.getMaquinaTotalDTO().getIndiceRefugo());
						detalhe.setOee(maquinaDTO.getMaquinaTotalDTO().getOee());
						detalhe.setOeecapital(maquinaDTO.getMaquinaTotalDTO().getOeeCapital());
						detalhe.setMaquinaDTO(maquinaDTO);

						// Atualiza informacoes da maquina se o mes processado est� na range de meses solicitados
						if (isMesNaRangeDoFiltro(mes, filtro)){
							detalhes.add(detalhe);
						}
						
						// Abaixo inclui valores para o acumulado
						boolean isExiste = false;
						for (AODetalheInjetDTO det : acumulado){
							if (det.getMes() == mes.getMes() && det.getAno() == mes.getAno()){
								isExiste = true;
								MaquinaInjetDTO maquinaA = new MaquinaInjetDTO();
								maquinaA.addMaquinaDTO(maquinaDTO);
								det.getMaquinaDTO().addMaquinaDTO(maquinaA);
							}
						}
						if (isExiste == false){
							AODetalheInjetDTO detalheAcumulado; 
							detalheAcumulado = new AODetalheInjetDTO();
							detalheAcumulado.setMes(mes.getMes());
							detalheAcumulado.setAno(mes.getAno());
							detalheAcumulado.setDivisorParaMediaAcumulada(quantidadeMesesParaMedia);
							detalheAcumulado.setDsDetalhe(mes.getDescricaoMes() + "/" + mes.getAno());
							detalheAcumulado.setEficiclo(maquinaDTO.getMaquinaTotalDTO().getEficienciaCiclo());
							detalheAcumulado.setEficienciareal(maquinaDTO.getMaquinaTotalDTO().getEficienciaRealizacao());
							detalheAcumulado.setIndparada(maquinaDTO.getMaquinaTotalDTO().getIndiceParada());
							detalheAcumulado.setIndperda(maquinaDTO.getMaquinaTotalDTO().getIndicePerda());
							detalheAcumulado.setIndrefugo(maquinaDTO.getMaquinaTotalDTO().getIndiceRefugo());
							detalheAcumulado.setOee(maquinaDTO.getMaquinaTotalDTO().getOee());
							detalheAcumulado.setOeecapital(maquinaDTO.getMaquinaTotalDTO().getOeeCapital());
							detalhe.setMaquinaDTO(maquinaDTO);
							acumulado.add(detalheAcumulado);
						}
					}
					AOMaquinaInjetDTO maquina;
					maquina = new AOMaquinaInjetDTO();
					maquina.setCodigo(ijgalobj.getIjtbinj().getCdinjestendido());
					maquina.setDescricao(ijgalobj.getIjtbinj().getCdidentific());
					maquina.setDetalhes(detalhes);
					maquinas.add(maquina);
				}

				galpao = new AOGalpaoInjetDTO();
				galpao.setCodigo(ijtbgal.getCdgalpao());
				galpao.setDescricao(ijtbgal.getDsgalpao());
				galpao.setMaquinas(maquinas);
				galpoes.add(galpao);

			}
		}
		
		Float somaEficienciaCiclo = 0f;
		Float somaEficienciaRealizacao = 0f;
		Float somaIndiceParada = 0f;
		Float somaIndicePerda = 0f;
		Float somaIndiceRefugo = 0f;
		Float somaOee = 0f;
		Float somaOeeCapital = 0f;
		
		// calcula o total no acumulado
		for (AODetalheInjetDTO det : acumulado){
			if (det.getMes() == 13){ // deve ter o valor da media
				Float mediaEficienciaCiclo = FormulasInjet.dividir(somaEficienciaCiclo, det.getDivisorParaMediaAcumulada());
				Float mediaEficienciaRealizacao = FormulasInjet.dividir(somaEficienciaRealizacao, det.getDivisorParaMediaAcumulada());
				Float mediaIndiceParada = FormulasInjet.dividir(somaIndiceParada, det.getDivisorParaMediaAcumulada());
				Float mediaIndicePerda = FormulasInjet.dividir(somaIndicePerda, det.getDivisorParaMediaAcumulada());
				Float mediaIndiceRefugo = FormulasInjet.dividir(somaIndiceRefugo, det.getDivisorParaMediaAcumulada());
				Float mediaOee = FormulasInjet.dividir(somaOee, det.getDivisorParaMediaAcumulada());
				Float mediaOeeCapital = FormulasInjet.dividir(somaOeeCapital, det.getDivisorParaMediaAcumulada());

				det.setEficiclo(mediaEficienciaCiclo);
				det.setEficienciareal(mediaEficienciaRealizacao);
				det.setIndparada(mediaIndiceParada);
				det.setIndperda(mediaIndicePerda);
				det.setIndrefugo(mediaIndiceRefugo);
				det.setOee(mediaOee);
				det.setOeecapital(mediaOeeCapital);
				
				somaEficienciaCiclo = 0f;
				somaEficienciaRealizacao = 0f;
				somaIndiceParada = 0f;
				somaIndicePerda = 0f;
				somaIndiceRefugo = 0f;
				somaOee = 0f;
				somaOeeCapital = 0f;

				continue;
			}
			det.setEficiclo(det.getMaquinaDTO().getMaquinaTotalDTO().getEficienciaCiclo());
			det.setEficienciareal(det.getMaquinaDTO().getMaquinaTotalDTO().getEficienciaRealizacao());
			det.setIndparada(det.getMaquinaDTO().getMaquinaTotalDTO().getIndiceParada());
			det.setIndperda(det.getMaquinaDTO().getMaquinaTotalDTO().getIndicePerda());
			det.setIndrefugo(det.getMaquinaDTO().getMaquinaTotalDTO().getIndiceRefugo());
			det.setOee(det.getMaquinaDTO().getMaquinaTotalDTO().getOee());
			det.setOeecapital(det.getMaquinaDTO().getMaquinaTotalDTO().getOeeCapital());
			
			somaEficienciaCiclo += det.getMaquinaDTO().getMaquinaTotalDTO().getEficienciaCiclo();
			somaEficienciaRealizacao += det.getMaquinaDTO().getMaquinaTotalDTO().getEficienciaRealizacao();
			somaIndiceParada += det.getMaquinaDTO().getMaquinaTotalDTO().getIndiceParada();
			somaIndicePerda += det.getMaquinaDTO().getMaquinaTotalDTO().getIndicePerda();
			somaIndiceRefugo += det.getMaquinaDTO().getMaquinaTotalDTO().getIndiceRefugo();
			somaOee += det.getMaquinaDTO().getMaquinaTotalDTO().getOee();
			somaOeeCapital += det.getMaquinaDTO().getMaquinaTotalDTO().getOeeCapital();

		}
		
		// Remove de acumulado os registros que nao fazem parte do periodo filtrado
		List<AODetalheInjetDTO> acumuladoAlterado = new ArrayList<AODetalheInjetDTO>();
		try{
		for (AODetalheInjetDTO det : acumulado){
			MesInjetDTO mes = new MesInjetDTO(det.getAno(), det.getMes());
			
			if (isMesNaRangeDoFiltro(mes, filtro)){
				acumuladoAlterado.add(det);
			}
		}
		} catch (Exception e){
			e.printStackTrace();
		}
		
		//acumulado = detalhes;
		
		AnaliseOEEMaquinaInjetDTO rel = new AnaliseOEEMaquinaInjetDTO();
		rel.setAcumulado(acumuladoAlterado);
		rel.setGalpoes(galpoes);
		rel.setMeses(descricaoMeses);

		// Salvar os filtros usados pelo relatorio
		DiversosInjetRN diversosRN = new DiversosInjetRN(getDao());
		diversosRN.setDaoSession(getDaoSession());
		
		diversosRN.salvarFiltro(filtro, 3);

		return rel;

	}
}