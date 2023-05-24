package idw.model.rn;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.SemCicloPadraoException;
import idw.model.pojos.DwFolha;
import idw.model.pojos.OmPt;
import idw.util.IdwLogger;
import idw.webservices.dto.ItemRelatorioFichaTecnica;
import idw.webservices.dto.ProdutoDTO;

public class RelatorioFichaTecnicaRN extends AbstractRN<DAOGenerico> {

	public RelatorioFichaTecnicaRN() {
		this(null);
	}

	public RelatorioFichaTecnicaRN(DAOGenerico dao) {
		super(dao);
		if (dao == null) {
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}

	public ItemRelatorioFichaTecnica getRelatorioFichaTecnica(ProdutoDTO filtro) {
		
		IdwLogger log = new IdwLogger("ChamadasUsuarios");
		int idLog = log.getIdAleatorio();
		log.iniciaAvaliacao(idLog, "RelatorioFichaTecnicaRN.getRelatorioFichaTecnica");
		log.info( idLog , 0, "RelatorioFichaTecnicaRN.getRelatorioFichaTecnica filtro usado:" + filtro.toString());
		
		List<Object> lista = consultaRelario(filtro);

		ItemRelatorioFichaTecnica retorno = new ItemRelatorioFichaTecnica();
		retorno.setItens(new ArrayList<ItemRelatorioFichaTecnica>());

		final int CD_PRODUTO = 0;
		final int DS_PRODUTO = 1;
		final int CD_PRODUTO2 = 2;
		final int DS_PRODUTO2 = 3;
		final int CD_FOLHA = 4; // MOLDE
		final int QTD_ATIVA = 5;
		final int QTD_ATIVA2 = 6;
		final int QTD_TOTAL = 7;
		final int DS_PT = 8;
		final int CIC_PADRAO = 9;
		final int CD_CLIENTE = 10;
		final int NM_CLIENTE = 11;
		final int PS_BRUTO = 12;
		final int PS_LIQUIDO = 13;
		final int PS_BRUTO2 = 14;
		final int PS_LIQUIDO2 = 15;
		final int CICLO_PADRAO_DEFAULT = 16;
		final int CD_RAP = 17;
		final int CD_PT = 18;
		final int ID_FOLHA = 19;

		PTRN prn = new PTRN(getDao());
		FolhaRN frn = new FolhaRN(getDao());

		for (Object item : lista) {
			Object[] registro = (Object[]) item;

			String cdProduto = "";
			if (registro[CD_PRODUTO] != null) {
				cdProduto = (String) registro[CD_PRODUTO];

			} else if (registro[CD_PRODUTO2] != null) {
				cdProduto = (String) registro[CD_PRODUTO2];
			} else {
				cdProduto = "";
			}

			if (!cdProduto.equals("")) {
				String dsProduto = "";
				if (registro[DS_PRODUTO] != null) {
					dsProduto = (String) registro[DS_PRODUTO];
				} else if (registro[DS_PRODUTO2] != null) {
					dsProduto = (String) registro[DS_PRODUTO2];
				} else {
					dsProduto = "";
				}
				String molde = (String) registro[CD_FOLHA];
				String cdrap = (String) registro[CD_RAP];
				String cavAtiv = "";

				if (registro[QTD_ATIVA] != null) {
					cavAtiv = ((BigDecimal) registro[QTD_ATIVA]).setScale(2, RoundingMode.HALF_UP) + "/"
							+ ((BigDecimal) registro[QTD_TOTAL]).setScale(2, RoundingMode.HALF_UP);
				} else if (registro[QTD_ATIVA2] != null) {
					cavAtiv = ((BigDecimal) registro[QTD_ATIVA2]).setScale(2, RoundingMode.HALF_UP) + "/"
							+ ((BigDecimal) registro[QTD_ATIVA2]).setScale(2, RoundingMode.HALF_UP);
				} else {
					cavAtiv = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP) + "/" + BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
				}

				String dsPt = (String) registro[DS_PT];
				String cdPt = (String) registro[CD_PT];
				String cdCliente = (String) registro[CD_CLIENTE];
				String nmCliente = (String) registro[NM_CLIENTE];
				BigDecimal cioPadrao = (BigDecimal) registro[CIC_PADRAO];
				Long idFolha = (Long) registro[ID_FOLHA];
				BigDecimal pBruto = BigDecimal.ZERO;
				BigDecimal pLiquido = BigDecimal.ZERO;
				if (registro[CD_PRODUTO] != null) {
					pBruto = registro[PS_BRUTO] == null ? BigDecimal.ZERO : (BigDecimal) registro[PS_BRUTO];
					pLiquido = registro[PS_LIQUIDO] == null ? BigDecimal.ZERO : (BigDecimal) registro[PS_LIQUIDO];
				} else {
					pBruto = registro[PS_BRUTO2] == null ? BigDecimal.ZERO : (BigDecimal) registro[PS_BRUTO2];
					pLiquido = registro[PS_LIQUIDO2] == null ? BigDecimal.ZERO : (BigDecimal) registro[PS_LIQUIDO2];
				}
				
				/* Alessandre em 26-05-22 obtendo o ciclo especializado
				 * 
				 */
				OmPt ompt;
				try {
					ompt = prn.getOmPt(cdPt);
				} catch (RegistroDesconhecidoException e) {
					ompt = null;
				}
				DwFolha dwfolha = frn.pesquisarFolhaPorID(idFolha);
				try {
					if (ompt != null)
						cioPadrao = frn.getCicloPadraoFromDwFolhacisOuDwFolha(dwfolha, ompt);
				} catch (SemCicloPadraoException e) {
				}
				
				
				BigDecimal cicloPadraoDefault = (BigDecimal) registro[CICLO_PADRAO_DEFAULT];
				if (cioPadrao == null)
					cioPadrao = cicloPadraoDefault;
				if (cdCliente == null)
					cdCliente = "";
				if (nmCliente == null)
					nmCliente = "";

				ItemRelatorioFichaTecnica itemRelatorio = new ItemRelatorioFichaTecnica();
				itemRelatorio.setCdProduto(cdProduto);
				itemRelatorio.setDsProduto(dsProduto);
				//Marcos Sardinha: Defeito #4284 >> alterei de - para / para deixar no padrao do novo cabecalho
				itemRelatorio.setMolde(molde + (cdrap != null ? " / " + cdrap : ""));
				itemRelatorio.setCavAtivas(cavAtiv);
				if (cdPt != null && cdPt.equals("") == false)
					itemRelatorio.setMaquina(cdPt);
				else
					itemRelatorio.setMaquina(dsPt);
				itemRelatorio.setCioPadrao(cioPadrao.setScale(3, RoundingMode.HALF_UP));
				itemRelatorio.setCdCliente(cdCliente);
				itemRelatorio.setNmCliente(nmCliente);
				itemRelatorio.setPsBruto(pBruto.setScale(3, RoundingMode.HALF_UP));
				itemRelatorio.setPsLiquido(pLiquido.setScale(3, RoundingMode.HALF_UP));

				retorno.getItens().add(itemRelatorio);
			}
		}

		Collections.sort(retorno.getItens(), new Comparator<ItemRelatorioFichaTecnica>() {
			@Override
			public int compare(ItemRelatorioFichaTecnica o1, ItemRelatorioFichaTecnica o2) {
				String campos1 = o1.getCdProduto() + o1.getDsProduto() + o1.getMolde() + o1.getMaquina();
				String campos2 = o2.getCdProduto() + o2.getDsProduto() + o2.getMolde() + o2.getMaquina();
				return campos1.compareTo(campos2);
			}
		});
		
		log.mostrarAvaliacaoCompleta();

		return retorno;
	
	}

	private List<Object> consultaRelario(ProdutoDTO filtro) {
		//Marcos Sardinha: 2017-08-01 >> Defeito #4271 >> left join em  dw_folharap e dw_folharapcom
		
		MapQuery q = new MapQuery(getDaoSession());
		q.append("SELECT DISTINCT");
		q.append("produto.cdProduto,"); // 0
		q.append("produto.dsProduto,"); // 1
		q.append("produto2.cdProduto,"); // 2
		q.append("produto2.dsProduto,"); // 3
		q.append("folha.cdFolha,"); // 4
		q.append("folharapcom.qtAtiva,"); // 5
		q.append("folhaiac.qtAtiva,"); // 6
		q.append("folharapcom.qtTotal,"); // 7
		// q.append("omtppt.cdTppt,");
		q.append("pt.dsPt,"); // 8
		//
		q.append("folhacic.segCiclopadrao,"); // 9
		q.append("cliente.cdCliente,"); // 10
		q.append("cliente.nmCliente,"); // 11
		q.append("produto.GPesoBruto,"); // 12
		q.append("produto.GPesoLiquido,"); // 13
		q.append("produto2.GPesoBruto,"); // 14
		q.append("produto2.GPesoLiquido,"); // 15
		q.append("folha.segCiclopadrao,"); // 16
		q.append("rap.cdRap,"); // 17
		q.append("pt.cdPt,"); // 18
		q.append("folha.idFolha"); //19
		q.append("FROM DwFolha folha");
		q.append("JOIN folha.omTppt omtppt");
		q.append("JOIN omtppt.omPts pt");
		q.append("LEFT JOIN folha.dwFolharaps folharap");
		q.append("LEFT JOIN folharap.dwFolharapcoms folharapcom");
		q.append("LEFT JOIN folharapcom.omProduto produto");
		q.append("LEFT JOIN folha.dwFolhaiacs folhaiac");
		q.append("LEFT JOIN folhaiac.omProduto produto2");
		q.append("LEFT JOIN folharap.dwRap rap");
		q.append("LEFT JOIN folha.dwFolhacics folhacic");
		q.append("LEFT JOIN rap.ppCliente cliente");
		q.append("WHERE folha.stAtivo = :stAtivo");
		q.append("AND pt.stAtivo = :stAtivo ");

		if (filtro.getProduto() != null && filtro.getProduto().getCdProduto() != null && filtro.getProduto().getCdProduto().equals("") == false) {
			q.append("AND (produto.cdProduto = :cdProduto OR produto2.cdProduto = :cdProduto)");
		}

		if (filtro.getProduto() != null && filtro.getProduto().getCdProduto() != null && filtro.getProduto().getCdProduto().equals("") == false) {
			q.defineParametro("cdProduto", filtro.getProduto().getCdProduto());
		}

		q.defineParametro("stAtivo", (byte) 1);

		return q.list();
	}

}