package idw.servlets;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import idw.model.pojos.OmCfg;
import idw.model.pojos.OmCfgurl;
import idw.model.pojos.OmPt;
import idw.model.rn.ConfiguracaoRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.integracao.ipackchem.IntegracaoIpackChemRN;
import idw.model.rn.integracao.ipackchem.client.IPCINJSOAPProxy;
import idw.model.rn.integracao.ipackchem.client.XPAR01;
import idw.model.rn.integracao.ipackchem.client.XPAR02;
import idw.model.rn.integracao.ipackchem.client.XPAR02LST;
import idw.model.rn.integracao.ipackchem.client.XPAR03;
import idw.model.rn.integracao.ipackchem.client.XRET01;
import idw.model.rn.integracao.ipackchem.client.XRET02;
import idw.model.rn.integracao.ipackchem.client.XRET03;
import idw.model.rn.integracao.ipackchem.dto.IntIpackChemAlteracaoFimPlanejadoDTO;
import idw.model.rn.integracao.ipackchem.dto.IntIpackChemApontamentoProducaoDTO;
import idw.model.rn.integracao.ipackchem.dto.IntIpackChemCGQLiberadoDTO;
import idw.model.rn.integracao.ipackchem.dto.ListaIntIpackChemApontamentosProducaoDTO;
import idw.model.rn.integracao.ipackchem.dto.ListaIntIpackChemLiberacaoCertificadoDTO;
import idw.model.rn.integracao.ipackchem.dto.ListaIntIpackChemListaComAltDataFimPlanDTO;
import idw.util.IdwLogger;
import idw.util.Util;

public class ImportarIpackChemThread extends Thread 
{
	private IdwLogger log = null;
	private boolean isThreadExecutando = true;
	private final int DELAY_AUTO_UPDATE = 120000;
	
	public ImportarIpackChemThread()
	{
		this.setName("ImportarIpackChemThread -" + DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(DataHoraRN.getDataHoraAtual()));
	}
	
	@Override
	public void run() {

		
		this.log = new IdwLogger("ImportarIpackChemThread");
		
		ConfiguracaoRN confRN = new ConfiguracaoRN();
		IntegracaoIpackChemRN iipcRN = new IntegracaoIpackChemRN();

		while (isThreadExecutando) 
		{
			try 
			{
				confRN.iniciaConexaoBanco();
				iipcRN.iniciaConexaoBanco();
	
				// recuperar primeira url de conex„o. Essa ser√° a URL onde o web service do cliente estar√° rodando 
				List<OmCfgurl> listaCfgurl = confRN.getCfgurls();
				OmCfgurl cfgUrl = new OmCfgurl();
				
				if (! listaCfgurl.isEmpty() )
				{
					cfgUrl = listaCfgurl.iterator().next();
					OmCfg omcfg = Util.getConfigGeral(confRN.getSession());

					log.info("Iniciando verificaÁ„oo de exportaÁ„oo em " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(new Date()));
					
					try {
						if (!confRN.getSession().isOpen()) 
						{
							confRN.iniciaConexaoBanco();
						}

						OmPt omPt = new OmPt();
						
						//aqui devo chamar o webservice
						IPCINJSOAPProxy wsipc = null;
						wsipc = new IPCINJSOAPProxy(cfgUrl.getUrlConexao() + "/IPCINJ.apw");
						log.info("chamou web service totvs " + cfgUrl.getUrlConexao() + "/IPCINJ.apw");
						
						log.info("Recuperando lista de ops com final planejado alterado - " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(new Date()));
						ListaIntIpackChemListaComAltDataFimPlanDTO listaAltData = iipcRN.getIntIpackChemListaOPsComAltDataFimPlan();
						for (IntIpackChemAlteracaoFimPlanejadoDTO itemLista : listaAltData.getListaOPsComFimPlanAlterado())
						{
							XRET01 retorno = new XRET01();
							XPAR01 regAltData = new XPAR01();
							
							regAltData.setXDATA_PREVISTA(itemLista.getDtFimPlan());
							regAltData.setXNOME_MAQUINA(iipcRN.getIntIpackChemCdMaquina(itemLista.getNropERP()));
							regAltData.setXNUMERO_OP(itemLista.getNropERP());
							
							retorno =  wsipc.getIPCINJSOAP().XOPDTPREV(regAltData);
							
							if (retorno.getXSTATUS().toUpperCase().equals("FALHA"))
							{
								iipcRN.setIntIpackChemAltDataFimPlan(itemLista.getIdRegistro(), 3, retorno.getXMENSAGEM());
							}
							else
							{
								iipcRN.setIntIpackChemAltDataFimPlan(itemLista.getIdRegistro(), 2, "");
							}
						}
						
 
						log.info("Recuperando lista de CQs liberados - " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(new Date()));
						ListaIntIpackChemLiberacaoCertificadoDTO listaCQ = iipcRN.getIntIpackChemListaLiberacaoCertificado();
						for (IntIpackChemCGQLiberadoDTO itemLista : listaCQ.getListaCertificadosLiberados())
						{
							XRET03 retorno = new XRET03();
							XPAR03 regLibera = new XPAR03();
							
							regLibera.setXDATA_LIBERACAO(itemLista.getDthrRegistro());
							regLibera.setXNUMERO_OP(itemLista.getNropERP());
							
							retorno =  wsipc.getIPCINJSOAP().XLIBCERTIFICADO(regLibera);
							
							if (retorno.getXSTATUS().toUpperCase().equals("FALHA"))
							{
								iipcRN.setIntIpackChemListaLiberacaoCertificado(itemLista.getIdRegistro(), 3, retorno.getXMENSAGEM());
							}
							else
							{
								iipcRN.setIntIpackChemListaLiberacaoCertificado(itemLista.getIdRegistro(), 2, "");
							}
						}
						
						
						log.info("Recuperando lista de apontamentos de producao - " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(new Date()));
						ListaIntIpackChemApontamentosProducaoDTO listaApt= iipcRN.getIntIpackChemListaApontamentosProducao();
						for (IntIpackChemApontamentoProducaoDTO itemLista : listaApt.getListaApontamentosOP())
						{
							XRET02 retorno = new XRET02();
							XPAR02 regAptPro = new XPAR02();
							
							// precisa estar instanciado senao ocorre erro
							XPAR02LST[] listaVazia;
							XPAR02LST mp = new XPAR02LST();
							listaVazia = new XPAR02LST[1];
							mp.setXPRODUTO_PESADO("");
							mp.setXQUANTIDADE_PESADA(0f);
							listaVazia[0] = mp;
							
				 
							regAptPro.setXDATA_PRODUCAO(itemLista.getDthrSaidaOP());
							regAptPro.setXNUMERO_OP(itemLista.getNropERP());
							regAptPro.setXQUANTIDADE(itemLista.getQtdProdBruta().floatValue());
							regAptPro.setXQUANTIDADE_REFUGO(0f);
														
							if ( (itemLista.getQtdProdRefugada().doubleValue() > 0d) && (itemLista.getQtdProdRefEstorno().doubleValue() > 0d))
							{
								// apontamento ocorrido na saida da op - situacao normal
								regAptPro.setXQUANTIDADE_REFUGO(itemLista.getQtdProdRefugada().subtract(itemLista.getQtdProdRefEstorno()).floatValue());
							}
							else
							{
								// apontamento de refugo
								if (itemLista.getQtdProdRefugada().doubleValue() > 0)
								{
									regAptPro.setXQUANTIDADE_REFUGO(itemLista.getQtdProdRefugada().floatValue());
								}
								else
								{
									// apontamento de cancelamento de refugo
									if (itemLista.getQtdProdRefEstorno().doubleValue() > 0)
									{
										regAptPro.setXQUANTIDADE_REFUGO(itemLista.getQtdProdRefEstorno().multiply(new BigDecimal(-1)).floatValue());
									}
								}
							}
							
							regAptPro.setXPAR02LSTS(listaVazia);
							retorno =  wsipc.getIPCINJSOAP().XPRODUCAO(regAptPro);
							
							if (retorno.getXSTATUS().toUpperCase().equals("FALHA"))
							{
								iipcRN.setIntIpackChemListaApontamentosProducao(itemLista.getIdRegistro(), 3, retorno.getXMENSAGEM());
							}
							else
							{
								iipcRN.setIntIpackChemListaApontamentosProducao(itemLista.getIdRegistro(), 2, "");
							}
						}
						
 
					} 
					catch (Exception e) 
					{
						e.printStackTrace();
						log.info("Reiniciando a thread de exportaÁ„oo IpackChem", e);
					}
					
					
					
				}
				confRN.finalizaConexaoBanco();
				iipcRN.finalizaConexaoBanco();
				
				log.info("Fim emportacao IpackChem");

				Thread.sleep(DELAY_AUTO_UPDATE);
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
				log.info("Erro ", e);
			}
		}
	}

	public void pararThread() {
		this.isThreadExecutando = false;
	}
	
}
