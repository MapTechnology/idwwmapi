package idw.servlets;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.Validate;

import idw.model.IdwFacade;
import idw.model.dao.DAOGenerico;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.injet.Ijtbmestres;
import idw.model.rn.DataHoraRN;
import idw.model.rn.PTRN;
import idw.model.rn.imp.injet.ImportacaoInjetFactory;
import idw.model.rn.imp.injet.ImportacaoInjetFactory.TipoImportacao;
import idw.model.rn.imp.injet.ImportacaoInjetRN;
import idw.model.rn.injet.MestreInjetRN;
import idw.util.IdwLogger;
import idw.util.ThreadUtil;
import idw.util.Util;
import ms.coleta.ic.inova.Stubdelegate;
import ms.model.rn.importacao.pdba.ImportaIjtbinjParaMsUpRN;
import ms.model.rn.importacao.pdba.ImportaMsUpParaPrUpRN;

public class ImportacaoInjetThread extends Thread{

	private final long _DELAY_IMPORTACAO = 120000;

	private IdwLogger log = null;
	private boolean isThreadExecutando = true;

	public ImportacaoInjetThread() {
		this.setName("ImportacaoInjetThread-" + DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(DataHoraRN.getDataHoraAtual()));
	}
	

	@Override
	public void run() {
		// Ja que essa thread foi ativa, entao informar que a conexao com a base do injet deve ser estabelecida
		Stubdelegate.getInstancia().setInjetAtivo(true);

		this.log = new IdwLogger("ImportacaoInjetThread");

		// Loop infinito para thread de importação do Injet
		while (this.isThreadExecutando == true){

			int idLog = this.log.getIdAleatorio();
			int identacao = 5;

	        // Obtem dados do MS que irá ser executado
			this.log.info(idLog, 0, "Iniciando ImportacaoInjetThread " + DataHoraRN.getDataHoraMiliAtualFormatada());

			DAOGenerico daoIdw = new DAOGenerico();
			DAOGenericoInjet daoInjet = new DAOGenericoInjet();
			List<Ijtbmestres> listaMestres = null;


			try {
				// Inicia comunicação com o banco de dados
				this.log.info(idLog, identacao, "Abrindo conexao com o banco de dados " + DataHoraRN.getDataHoraMiliAtualFormatada());
				daoIdw.iniciaConexaoBanco();
				daoInjet.iniciaConexaoBanco();				

				// Pega o usuário padrão usado na importação
				OmCfg omcfg = Util.getConfigGeral(daoIdw.getSession());
				Validate.notNull(omcfg, "omCfg - Configuração não encontrada");
				Validate.notNull(omcfg.getOmUsrimpprog(), "omCfg.getOmUsrimpprog() - Não há usuário para importação. Informe o usuário no módulo de configuração, Geral.");
				Validate.notNull(omcfg.getOmGtimpcic(), "omCfg.getOmGtimpcic() - Não há Gt para a importação. Informe o Gt no módulo de configuração, Geral.");
				OmUsr omUsrImportacao = omcfg.getOmUsrimpprog();
				OmGt omGt = omcfg.getOmGtimpcic();


				// Lista com os mestres disponívies no banco injet
				this.log.info(idLog, identacao, "Obtem lista de ijtbmestres " + DataHoraRN.getDataHoraMiliAtualFormatada());
				MestreInjetRN mestreInjetRN = new MestreInjetRN(daoInjet);
				listaMestres = mestreInjetRN.listaMestres();
				Validate.notNull(listaMestres, "listaMestres - não há Mestre cadastrado no banco Injet");
				Validate.validState(listaMestres.size() > 0, "listaMestres - não há Mestre cadastrado no banco Injet");

				// Importa Usuario
				this.log.info(idLog, identacao, "Executando importacaoInjetUsuario " + DataHoraRN.getDataHoraMiliAtualFormatada());
				ImportacaoInjetRN importacaoInjetUsuario = ImportacaoInjetFactory.getInstance(TipoImportacao.USUARIO, this.log, idLog, identacao + 5, daoIdw , daoInjet);
				
				importacaoInjetUsuario.importar(listaMestres, null, omUsrImportacao, null);
				importacaoInjetUsuario = null;

				// Os flushs estao sendo usados para reduzir o consumo de memoria
				daoIdw.flushReiniciandoTransacao();
				daoInjet.flushReiniciandoTransacao();
				
				// Importa Máquina
				this.log.info(idLog, identacao, "Executando importacaoInjetMaquina " + DataHoraRN.getDataHoraMiliAtualFormatada());
				ImportacaoInjetRN importacaoInjetMaquina = ImportacaoInjetFactory.getInstance(TipoImportacao.MAQUINA, this.log, idLog, identacao + 5, daoIdw , daoInjet);
				importacaoInjetMaquina.importar(listaMestres, null, omUsrImportacao, null);
				importacaoInjetMaquina = null;

				daoIdw.flushReiniciandoTransacao();
				daoInjet.flushReiniciandoTransacao();
				

				/* Alessandre em 05-02-15 inclui a importacao para msup e para pr_up nessa thread a fim de desabilitar o listener de importacao do pdba
				 * pois esta gerando muito snapshot em pr_up
				 */
				// Importa de IjtbInj para msUP
				ImportaIjtbinjParaMsUpRN importaMaquina = new ImportaIjtbinjParaMsUpRN(log, daoInjet, daoIdw);
				importaMaquina.importar(null);
				
				//daoIdw.flushReiniciandoTransacao();
				
				// Importa MsUp para PrUp
				/* Alessandre em 12-04-17 vou importar para prup apenas se o idw não estiver ativo
				 * Assim evito de alterar a prup sem necessidade, visto que para a viqua que deseja usar o inova eco com o idw
				 * essa importacao prejudica a desativacao da up pois o bc nao existe na instalacao
				 */
				if (IdwFacade.getInstancia().isIDWAtivo() == false) {
					ImportaMsUpParaPrUpRN importaMsUp = new ImportaMsUpParaPrUpRN(log, daoInjet, daoIdw);
					importaMsUp.importar(null);
				}
				
				// Os flushs estao sendo usados para reduzir o consumo de memoria
				daoIdw.flushReiniciandoTransacao();
				daoInjet.flushReiniciandoTransacao();

				// Importa Produto
				this.log.info(idLog, identacao, "Executando importacaoInjetProduto " + DataHoraRN.getDataHoraMiliAtualFormatada());
				ImportacaoInjetRN importacaoInjetProduto = ImportacaoInjetFactory.getInstance(TipoImportacao.PRODUTO, this.log, idLog, identacao + 5, daoIdw , daoInjet);
				importacaoInjetProduto.importar(listaMestres, null, omUsrImportacao, null);
				importacaoInjetProduto = null;

				// Os flushs estao sendo usados para reduzir o consumo de memoria
				daoIdw.flushReiniciandoTransacao();
				daoInjet.flushReiniciandoTransacao();

				// Importa OP
				// Para a empresa MONDIAL a importacao de OP esta desativada
				omcfg = Util.getConfigGeral(daoIdw.getSession());
				if (omcfg.getOmEmpresa().getCdEmpresa().toUpperCase().equals("MONDIAL") == false) {
					this.log.info(idLog, identacao, "Executando importacaoInjetPlanejamento " + DataHoraRN.getDataHoraMiliAtualFormatada());
					ImportacaoInjetRN importacaoInjetPlanejamento = ImportacaoInjetFactory.getInstance(TipoImportacao.PLANEJAMENTO, this.log, idLog, identacao + 5, daoIdw , daoInjet);
					importacaoInjetPlanejamento.importar(listaMestres, null, omUsrImportacao, omGt);
					importacaoInjetPlanejamento = null;
	
					// Os flushs estao sendo usados para reduzir o consumo de memoria
					daoIdw.flushReiniciandoTransacao();
					daoInjet.flushReiniciandoTransacao();
				}

				this.log.info(idLog, identacao, "Executando importacaoInjetFerramenta " + DataHoraRN.getDataHoraMiliAtualFormatada());
				ImportacaoInjetRN importacaoInjetFerramenta = ImportacaoInjetFactory.getInstance(TipoImportacao.MOLDE, this.log, idLog, identacao + 5, daoIdw , daoInjet);
				importacaoInjetFerramenta.importar(listaMestres, null, omUsrImportacao, omGt);
				importacaoInjetFerramenta = null;

				// Lista de Tppt válidos
				this.log.info(idLog, identacao, "Obtendo lista em omtppt " + DataHoraRN.getDataHoraMiliAtualFormatada());
				PTRN ptRN = new PTRN(daoIdw);
				List<OmTppt> listaOmTppts = ptRN.getOmTpptsAssociadasPt();
				ptRN = null;

				// Importações que dependem da lista OmTppt
				if(listaOmTppts.isEmpty()){

					this.log.info(idLog, 0, DataHoraRN.getDataHoraMiliAtualFormatada() + "listaOmTppts - nao ha TpPt ativo nas maquinas ativadas: importacao nao serao executadas: justificativa, causa, nao, parada, refugo");

				} else {

					// Importa Justificativa
					this.log.info(idLog, identacao, "Executando importacaoInjetJustificativa " + DataHoraRN.getDataHoraMiliAtualFormatada());
					ImportacaoInjetRN importacaoInjetJustificativa = ImportacaoInjetFactory.getInstance(TipoImportacao.JUSTIFICATIVA , this.log, idLog, identacao + 5, daoIdw , daoInjet);
					importacaoInjetJustificativa.importar(listaMestres, listaOmTppts, omUsrImportacao, null );
					importacaoInjetJustificativa = null;

					// Os flushs estao sendo usados para reduzir o consumo de memoria
					daoIdw.flushReiniciandoTransacao();
					daoInjet.flushReiniciandoTransacao();

					// Importa Causa
					this.log.info(idLog, identacao, "Executando importacaoInjetCausa " + DataHoraRN.getDataHoraMiliAtualFormatada());
					ImportacaoInjetRN importacaoInjetCausa = ImportacaoInjetFactory.getInstance(TipoImportacao.CAUSA, this.log, idLog, identacao + 5, daoIdw , daoInjet);
					importacaoInjetCausa.importar(listaMestres, listaOmTppts, omUsrImportacao, null );
					importacaoInjetCausa = null;

					// Os flushs estao sendo usados para reduzir o consumo de memoria
					daoIdw.flushReiniciandoTransacao();
					daoInjet.flushReiniciandoTransacao();

					// Importa Acao
					this.log.info(idLog, identacao, "Executando importacaoInjetAcao " + DataHoraRN.getDataHoraMiliAtualFormatada());
					ImportacaoInjetRN importacaoInjetAcao = ImportacaoInjetFactory.getInstance(TipoImportacao.ACAO, this.log, idLog, identacao + 5, daoIdw , daoInjet);
					importacaoInjetAcao.importar(listaMestres, listaOmTppts, omUsrImportacao, null );
					importacaoInjetAcao = null;

					// Os flushs estao sendo usados para reduzir o consumo de memoria
					daoIdw.flushReiniciandoTransacao();
					daoInjet.flushReiniciandoTransacao();

					// Importa Alerta
					this.log.info(idLog, identacao, "Executando importacaoInjetAlerta " + DataHoraRN.getDataHoraMiliAtualFormatada());
					ImportacaoInjetRN importacaoInjetAlerta = ImportacaoInjetFactory.getInstance(TipoImportacao.ALERTA, this.log, idLog, identacao + 5, daoIdw , daoInjet);
					importacaoInjetAlerta.importar(listaMestres, listaOmTppts, omUsrImportacao, null );
					importacaoInjetAlerta = null;

					// Os flushs estao sendo usados para reduzir o consumo de memoria
					daoIdw.flushReiniciandoTransacao();
					daoInjet.flushReiniciandoTransacao();

					// Importa Area
					this.log.info(idLog, identacao, "Executando importacaoInjetArea " + DataHoraRN.getDataHoraMiliAtualFormatada());
					ImportacaoInjetRN importacaoInjetArea = ImportacaoInjetFactory.getInstance(TipoImportacao.AREA, this.log, idLog, identacao + 5, daoIdw , daoInjet);
					importacaoInjetArea.importar(listaMestres, listaOmTppts, omUsrImportacao, null);
					importacaoInjetArea = null;
					
					// Os flushs estao sendo usados para reduzir o consumo de memoria
					daoIdw.flushReiniciandoTransacao();
					daoInjet.flushReiniciandoTransacao();

					// Importa Parada
					this.log.info(idLog, identacao, "Executando importacaoInjetParada " + DataHoraRN.getDataHoraMiliAtualFormatada());
					ImportacaoInjetRN importacaoInjetParada = ImportacaoInjetFactory.getInstance(TipoImportacao.PARADA, this.log, idLog, identacao + 5, daoIdw , daoInjet);
					importacaoInjetParada.importar(listaMestres, listaOmTppts, omUsrImportacao, null);
					importacaoInjetParada = null;

					// Os flushs estao sendo usados para reduzir o consumo de memoria
					daoIdw.flushReiniciandoTransacao();
					daoInjet.flushReiniciandoTransacao();

					// Importa Refugo
					this.log.info(idLog, identacao, "Executando importacaoInjetRefugo " + DataHoraRN.getDataHoraMiliAtualFormatada());
					ImportacaoInjetRN importacaoInjetRefugo = ImportacaoInjetFactory.getInstance(TipoImportacao.REFUGO, this.log, idLog, identacao + 5, daoIdw , daoInjet);
					importacaoInjetRefugo.importar(listaMestres, listaOmTppts, omUsrImportacao, null);
					importacaoInjetRefugo = null;

					// Os flushs estao sendo usados para reduzir o consumo de memoria
					daoIdw.flushReiniciandoTransacao();
					daoInjet.flushReiniciandoTransacao();

				}

				//marca que foi atualizado
		        for(Ijtbmestres ijtdmestres :listaMestres){
					ijtdmestres.setAtualizartabacoes(0);
					ijtdmestres.setAtualizartabalerta(0);
					ijtdmestres.setAtualizartabcausas(0);
					ijtdmestres.setAtualizartabjustif(0);
					ijtdmestres.setAtualizartabparada(0);
					ijtdmestres.setAtualizartabrefugo(0);
					ijtdmestres.setAtualizartabtecnic(0);
					ijtdmestres.setAtualizartabmolde(BigDecimal.ZERO);
					ijtdmestres.setAtualizarcfgandmaq(BigDecimal.ZERO);
					daoInjet.makePersistent(ijtdmestres);
					this.log.info(idLog, identacao, "Setou flags de atualizacao para 0 mestre " + ijtdmestres.getCdmestre() + " " + DataHoraRN.getDataHoraMiliAtualFormatada());
				}

			} catch (Exception e){
				this.log.info(idLog, identacao, "Ocorreu a excessao", e);
				e.printStackTrace();
			} finally {

		        try {
			        // finaliza Sessao
					daoInjet.finalizaConexaoBanco();
					daoIdw.finalizaConexaoBanco();
				} catch (Exception e) {
					this.log.info(idLog, identacao, "Ocorreu a excessao ao fechar conexao", e);
					e.printStackTrace();
				}

		        this.log.info(idLog, 0,
		        		  " Finalizando ImportacaoInjetThread "		        		 
		        		+ " com " + this.log.getAvaliacaoCompleta()
		        		+ ". Esperando " + (this._DELAY_IMPORTACAO /1000 /60) + "min para proxima importação.");

			}
			
			// Limpa objectos
			listaMestres = null;
			daoInjet = null;
			daoIdw = null;

	        // Pausa para uma nova Importacao
	        ThreadUtil.pausaNaThread(this._DELAY_IMPORTACAO);

		}
	}

	public void pararThread(){
		this.isThreadExecutando = false;
	}
}
