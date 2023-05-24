package idw.model.rn.integracao.tdba;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.dao.erp.DAOGenericoErp;
import idw.model.excessoes.RegistroJaDesativadoException;
import idw.model.pojos.DwRap;
import idw.model.pojos.DwTprap;
import idw.model.pojos.OmJobdet;
import idw.model.pojos.OmJobdetlog;
import idw.model.pojos.OmJoblog;
import idw.model.pojos.PpCliente;
import idw.model.rn.ClienteRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.DwRapRN;
import idw.model.rn.PpClienteRN;
import idw.util.IdwLogger;
import idw.util.Util;
import idw.webservices.dto.DwRapDTO;

public class IntegracaoTDBAFerramentaRN extends AIntegracaoTDBA {

	public IntegracaoTDBAFerramentaRN(DAOGenerico dao, DAOGenericoErp daoERP) {
		super(dao, daoERP);
	}

	@Override
	public boolean integrar(OmJoblog joblog, OmJobdet det, IdwLogger log, int idLog) {
		boolean retorno = true;

		MapQuery q = new MapQuery(daoERP.getSession());
		q.append(
				"select id, idempresa, idarea, cd_ferramenta, ds_ferramenta, tp_interacao, cd_cliente, producaobrutaporciclo, producaoliquidaporciclo from mi_ferramenta_idw where st_registro = 0 order by id");

		List<Object> lista = q.querySQL().list();

		// Abrir DAO com session
		DAOGenerico daoSessao = new DAOGenerico();

		BigInteger id = BigInteger.ZERO;
		
		try {

			daoSessao.iniciaConexaoBanco();

			for (Object linha : lista) {
				Date dthr = DataHoraRN.getDataHoraAtual();
				Object[] registro = (Object[]) linha;

				id = (BigInteger) registro[0];
				// String idEmpresa = registro[1].toString();
				String idArea = registro[2].toString().trim();
				String cdferramenta = registro[3].toString();
				String dsferramenta = registro[4].toString();
				Short tpinteracao = (Short) registro[5];
				String cdcliente = registro[6].toString().trim();
				Integer producaoBrutaPorCiclo = (Integer) registro[7];
				Integer producaoLiquidaPorCiclo = (Integer) registro[8];

				if (tpinteracao == 0) {
					// Inclusao
					incluirFerramenta(daoSessao, id, cdferramenta, dsferramenta, idArea, cdcliente, producaoBrutaPorCiclo,
							producaoLiquidaPorCiclo);
					// se falhou alguma importacao setar retorno como false
					if (getStregistro() != 1)
						retorno = false;

				} else if (tpinteracao == 1) {
					// Alteracao
					alterarFerramenta(daoSessao, id, cdferramenta, dsferramenta, idArea, cdcliente, producaoBrutaPorCiclo,
							producaoLiquidaPorCiclo);
					// se falhou alguma importacao setar retorno como false
					if (getStregistro() != 1)
						retorno = false;
				} else if (tpinteracao == 2) {
					// exclusao
					excluirFerramenta(daoSessao, id, cdferramenta);
					// se falhou alguma importacao setar retorno como false
					if (getStregistro() != 1)
						retorno = false;
				} else {
					// tipo interacao desconhecido
					atualizarResultado(id, 2, "tipo interação desconhecido. validos 0-2", "mi_ferramenta_idw");
				}

				// Incluir o resultado da importação do registro
				OmJobdetlog detlog = new OmJobdetlog();
				detlog.setIdJobdetlog(null);
				detlog.setDsExecucao(getResultado());
				detlog.setDthrIexecucao(dthr);
				detlog.setDthrFexecucao(DataHoraRN.getDataHoraAtual());
				detlog.setOmJoblog(joblog);
				detlog.setOmJobdet(det);
				detlog.setUrlOrigem("id " + id + " em mi_ferramenta_idw");
				detlog.setStExecucao((byte) (getStregistro() == 1 ? 1 : 0));

				dao.makePersistent(detlog);

			}
		} catch (Exception e) {
			e.printStackTrace();
			atualizarResultado(id, 2, "Ferramenta erro desconhecido " + e.getMessage(), "mi_ferramenta_idw");
		} finally {
			daoSessao.finalizaConexaoBanco();
		}

		return retorno;

	}

	private void incluirFerramenta(DAOGenerico daoSessao, BigInteger id, String cdferramenta, String dsferramenta, String idArea,
			String cdcliente, Integer producaoBrutaPorCiclo, Integer producaoLiquidaPorCiclo) {

		DwRapRN rn = new DwRapRN(daoSessao);
		rn.setCdRap(cdferramenta);

		omcfg = Util.getConfigGeral(daoSessao.getSession());

		// pesquisa ferramenta. Se nao existir marcar como erro na importacao
		DwRap dwrap = rn.pesquisarDwRapByCdRap();
		if (dwrap != null) {
			atualizarResultado(id, 2, "Ferramenta " + cdferramenta + " já existe no idw.", "mi_ferramenta_idw");
		} else {
			// Pesquisa se o cliente existe
			ClienteRN crn = new ClienteRN(daoSessao);
			PpCliente ppCliente = crn.pesquisarByCdClienteEStAtivo(cdcliente);
			
			if (ppCliente == null) {
				atualizarResultado(id, 2, "Cliente " + cdcliente + " da Ferramenta " + cdferramenta + " NÃO existe no idw.", "mi_ferramenta_idw");
			} else {
			
				// Pesquisa o grupo de ferramentas molde
				DwTprap dwtprap;
				dwtprap = rn.pesquisarTipoRAPByCd("MOLDE");
				if (dwtprap == null) {
					atualizarResultado(id, 2, "Tipo Ferramenta [MOLDE desconhecido. Cadastrar.", "mi_ferramenta_idw");
				} else {
	
					// Incluir dados do cliente
					rn.setIdRap(null);
					rn.setCdRap(cdferramenta);
					rn.setDtRevisao(DataHoraRN.getDataHoraAtual());
					rn.setDsRap(dsferramenta);
					// dwrap.setTpRap(); sem uso
					rn.setSegTempoliberacao(BigDecimal.ZERO);
					rn.setQtTotal(BigDecimal.ONE);
					rn.setDwTprap(dwtprap);
					rn.setOmUsrByIdUsrrevisao(omcfg.getOmUsrimpprog());
					rn.setOmUsrByIdUsrstativo(omcfg.getOmUsrimpprog());
					rn.setPpCliente(ppCliente);
	
	
					DwRapDTO retorno = rn.salvarRegistro();
					
					if (retorno.getResultadoDTO().getIdmensagem() == retorno.getResultadoDTO().getCOM_SUCESSO()) {
						// Marcar como importado com sucesso
						atualizarResultado(id, 1, "Ferramenta " + cdferramenta + " incluida com sucesso.", "mi_ferramenta_idw");
						qtItensImportados++;
					} else {
						atualizarResultado(id, 2, "Ferramenta " + cdferramenta + " NÃO incluida. Erro " + retorno.getResultadoDTO().getDescricaoMensagem(), "mi_ferramenta_idw");
					}
				}
			}
		}

	}

	private void alterarFerramenta(DAOGenerico daoSessao, BigInteger id, String cdferramenta, String dsferramenta, String idArea,
			String cdcliente, Integer producaoBrutaPorCiclo, Integer producaoLiquidaPorCiclo) {
		
		DwRapRN rn = new DwRapRN(daoSessao);
		rn.setCdRap(cdferramenta);

		omcfg = Util.getConfigGeral(daoSessao.getSession());

		// pesquisa ferramenta. Se nao existir marcar como erro na importacao
		DwRap dwrap = rn.pesquisarDwRapByCdRap();
		if (dwrap == null) {
			atualizarResultado(id, 2, "Ferramenta " + cdferramenta + " NÃO existe no idw.", "mi_ferramenta_idw");
		} else {
			// Pesquisa se o cliente existe
			ClienteRN crn = new ClienteRN(daoSessao);
			PpCliente ppCliente = crn.pesquisarByCdClienteEStAtivo(cdcliente);
			
			if (ppCliente == null) {
				atualizarResultado(id, 2, "Cliente " + cdcliente + " da Ferramenta " + cdferramenta + " NÃO existe no idw.", "mi_ferramenta_idw");
			} else {
			
				// Pesquisa o grupo de ferramentas molde
				DwTprap dwtprap;
				dwtprap = rn.pesquisarTipoRAPByCd("MOLDE");
				if (dwtprap == null) {
					atualizarResultado(id, 2, "Tipo Ferramenta [MOLDE desconhecido. Cadastrar.", "mi_ferramenta_idw");
				} else {
	
					// Incluir dados do cliente
					rn.setIdRap(dwrap.getIdRap());
					rn.setDtRevisao(DataHoraRN.getDataHoraAtual());
					rn.setDsRap(dsferramenta);
					// dwrap.setTpRap(); sem uso
					rn.setSegTempoliberacao(BigDecimal.ZERO);
					rn.setQtTotal(BigDecimal.ONE);
					rn.setDwTprap(dwtprap);
					rn.setOmUsrByIdUsrrevisao(omcfg.getOmUsrimpprog());
					rn.setOmUsrByIdUsrstativo(omcfg.getOmUsrimpprog());
					rn.setPpCliente(ppCliente);
	
	
					DwRapDTO retorno = rn.salvarRegistro();
					
					if (retorno.getResultadoDTO().getIdmensagem() == retorno.getResultadoDTO().getCOM_SUCESSO()) {
						// Marcar como importado com sucesso
						atualizarResultado(id, 1, "Ferramenta " + cdferramenta + " alterada com sucesso.", "mi_ferramenta_idw");
						qtItensImportados++;
					} else {
						atualizarResultado(id, 2, "Ferramenta " + cdferramenta + " NÃO alterada. Erro " + retorno.getResultadoDTO().getDescricaoMensagem(), "mi_ferramenta_idw");
					}
				}
			}
		}

	}

	private void excluirFerramenta(DAOGenerico daoSessao, BigInteger id, String cdferramenta) {
		DwRapRN rn = new DwRapRN(daoSessao);
		rn.setCdRap(cdferramenta);

		
		omcfg = Util.getConfigGeral(daoSessao.getSession());

		// pesquisa ferramenta. Se nao existir marcar como erro na importacao
		DwRap dwrap = rn.pesquisarDwRapByCdRap();
		if (dwrap == null) {
			atualizarResultado(id, 2, "Ferramenta " + cdferramenta + " NÃO existe no idw.", "mi_ferramenta_idw");
		} else {
			try {
				rn.setIdRap(dwrap.getIdRap());
				rn.setOmUsrByIdUsrstativo(omcfg.getOmUsrimpprog());
				DwRapDTO retorno = rn.excluirRegistro();
				
				if (rn.getResultadoDTO().getIdmensagem() == rn.getResultadoDTO().getCOM_SUCESSO()) {
					// Marcar como importado com sucesso
					atualizarResultado(id, 1, "Ferramenta " + cdferramenta + " excluida com sucesso.", "mi_ferramenta_idw");
					qtItensImportados++;
				} else {
					atualizarResultado(id, 2, "Ferramenta " + cdferramenta + " NÃO excluida. Erro " + retorno.getResultadoDTO().getDescricaoMensagem(), "mi_ferramenta_idw");
				}
			} catch (Exception e) {
				e.printStackTrace();
				atualizarResultado(id, 2, "Ferramenta " + cdferramenta + " erro desconhecido. " + e.getMessage(), "mi_ferramenta_idw");
			}
			
		}
	}

}
