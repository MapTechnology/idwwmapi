package idw.model.rn.imp.injet;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.Validate;

import idw.model.dao.DAOGenerico;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.excessoes.DigestFileException;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.pojos.OmCargo;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.OmUsrgrp;
import idw.model.pojos.injet.Ijtbmestres;
import idw.model.pojos.injet.Ijtbusu;
import idw.model.pojos.template.OmUsrTemplate;
import idw.model.pojos.template.OmUsrgrpTemplate;
import idw.model.rn.CargoRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.HashMD5;
import idw.model.rn.UsuarioRN;
import idw.model.rn.imp.injet.ImportacaoInjetFactory.TipoImportacao;
import idw.model.rn.injet.SenhaRN;
import idw.model.rn.injet.UsuarioInjetRN;
import idw.util.IdwLogger;

/**
 *
 * @author milton
 *
 */
public class ImportacaoInjetUsuarioRN extends ImportacaoInjetRN {

	private final UsuarioInjetRN usuarioInjetRN;
	private final UsuarioRN usuarioRN;
	private final CargoRN cargoRN;
	
	private final static String CD_USRGRP_OPERADOR = "4"; // Grupo de operadores
	private final static String CD_USRGRP_TECNICO = "5"; // Grupo de manutencao
	private final static String CD_USRGRP_METROLOGIA = "6"; // Grupo de aferidor
	private final static String CD_USRGRP_DEFAULT = "9"; // Grupo de monitoramento;

	public ImportacaoInjetUsuarioRN(IdwLogger log, int idLog, int identacao, DAOGenerico dao, DAOGenericoInjet daoInjet){
		super(log, idLog, identacao, dao, daoInjet);
		this.usuarioInjetRN = new UsuarioInjetRN(daoInjet);
		this.usuarioRN = new UsuarioRN(dao);
		this.cargoRN = new CargoRN(dao);
	}

	@Override
	public boolean isPrecisaImportar(Ijtbmestres ijtbmestres){
		Validate.notNull(ijtbmestres,"ijtbmestres");
		return ijtbmestres.getAtualizartabtecnic().equals(1);
	}

	@Override
	public void importar(List<Ijtbmestres> listaMestres, List<OmTppt> listaOmTppt, OmUsr omUsr, OmGt omGt) {
		Validate.notNull(listaMestres,"listaMestres");
		Validate.notNull(omUsr,"omUsr");

		this.getLog().iniciaAvaliacao(this.getIdLog(), "Importa��o da tabela de usuario");

		
		// Verifica se precisa
		if( this.isPrecisaImportar(listaMestres) ){

			// Lista de usuario dispon�veis na base do injet
			List<Ijtbusu> listUsuarioInjet = this.usuarioInjetRN.listaUsuariosAtivos();

			// Importa cargos dos usu�rios
			ImportacaoInjetCargoRN importacaoInjetCargoRN = (ImportacaoInjetCargoRN) ImportacaoInjetFactory.getInstance(TipoImportacao.CARGO, this.getLog(), 0, 0, this.getDao(), this.getDaoInjet());
			importacaoInjetCargoRN.importar(listaMestres, omUsr, listUsuarioInjet);
			importacaoInjetCargoRN = null;

			if(listUsuarioInjet.size() > 0){

				List<String> listCdUsuarioInjet = new ArrayList<String>();

				Date date = DataHoraRN.getDataHoraAtual();

				// Atualiza registros existentes
				for(Ijtbusu ijtbusu: listUsuarioInjet){
					// O usuario MAP nao deve ser importado
					if (ijtbusu.getNmacesso().toUpperCase().equals("MAP"))
						continue;

					try {
						this.importar(ijtbusu, date, omUsr);
					} catch (RegistroDesconhecidoException e) {
						this.getLog().info(this.getIdLog(), this.getIdentacao(), "Usu�rio " + ijtbusu.getCdusuario() + " n�o importado porque n�o existe grupo de usu�rio default (" + ImportacaoInjetUsuarioRN.CD_USRGRP_DEFAULT + ")" );
					} catch (DigestFileException e){
 
						this.getLog().info(this.getIdLog(), this.getIdentacao(), "Usu�rio n�o pode ser importado, n�o foi possivel gerar a criptografia da senha (cdUsuario " + ijtbusu.getCdusuario() + ")" );
					}
					listCdUsuarioInjet.add(ijtbusu.getCdusuario());
				}
				this.getLog().info(this.getIdLog(), this.getIdentacao(), "Foram Atualizados:" + listUsuarioInjet.size() + " registros");

				// Desativa registros em desuso
				this.getLog().info(this.getIdLog(), this.getIdentacao(), "Desativando registros obsoletos");
				this.usuarioRN.desativarUsrs(listCdUsuarioInjet, date, omUsr);

			}else {
				this.getLog().info(this.getIdLog(), this.getIdentacao(), "Todos os registros marcados como obsoletos");
				this.usuarioRN.desativarUsrs(DataHoraRN.getDataHoraAtual(), omUsr);
			}

			this.getDao().flush();
			this.getDao().clear();

		} else {
			this.getLog().info(this.getIdLog(), this.getIdentacao(), "Importa��o n�o � necess�ria. N�o marcado para importa��o");
		}
		
		this.getLog().paraAvaliacao(this.getDao());
		this.getLog().info(this.getIdLog(), this.getIdentacao(), "FIM: " + this.getLog().getAvaliacaoCompleta());

	}

	/**
	 * Importa os dados de {@code ijtbusu} para {@code omUsr}
	 * @param ijtbusu
	 * @param dateOperacao
	 * @param omUsrOperacao
	 * @throws RegistroDesconhecidoException quando grupo para us�rio n�o � encontrado
	 * @throws DigestFileException
	 */
	private void importar(Ijtbusu ijtbusu, Date dateOperacao, OmUsr omUsrOperacao) throws RegistroDesconhecidoException, DigestFileException{

		Validate.notNull(ijtbusu, "ijtbusu");
		Validate.notNull(omUsrOperacao, "omUsr");

		// Descriptogravar senha pela forma do injet
		String senha = SenhaRN.descriptografarSenha(ijtbusu.getSenha());

		// Criptograva
		senha = HashMD5.getHashCode(senha);

		// Nesse momento � importante decidir qual o grupo do usuario sera usado no novo cadastro. Pode ser como OPERADOR, TECNICO, ou o resto.
		// TECNICO no injet sera o omusrgrp = 5 (manutencao)
		// OPERADOR no injet sera o omusrgro = 4 (operadores)
		// o resto ser� o omusrgrp = 9 (monitorizacao)
		/*
		 *  Codigo do VB
		 *   If numTpUsuario = 0 Or numTpUsuario > 10 Then
	            Me.chkTM.Value = 1
	        End If
	        If numTpUsuario = 1 Or numTpUsuario = 3 Or numTpUsuario = 11 Or numTpUsuario = 13 Then
	            Me.chkOperador.Value = 1
	        End If
	        If numTpUsuario = 2 Or numTpUsuario = 3 Or numTpUsuario = 12 Or numTpUsuario = 13 Then
	            Me.chkTecnico.Value = 1
	        End If
		 */
		boolean isOperador = false;
		boolean isTecnico = false;
		boolean isAferidor = false; // Tem o direito de operar e manter o posto
		
		
		if (ijtbusu.getTpusuario().equals(BigDecimal.ONE) || ijtbusu.getTpusuario().equals(new BigDecimal(11)) ) {
			isOperador = true;
		}

		if (ijtbusu.getTpusuario().equals(new BigDecimal(2)) || ijtbusu.getTpusuario().equals(new BigDecimal(12)) ) {
			isTecnico= true;
		}

		if (ijtbusu.getTpusuario().equals(new BigDecimal(3)) || ijtbusu.getTpusuario().equals(new BigDecimal(13))) {
			isAferidor = true;
		}
		
			
		
		OmUsrgrp omUsrgrp = null;

		if (isOperador) {
			omUsrgrp = this.getDao().findByCd(OmUsrgrp.class, ImportacaoInjetUsuarioRN.CD_USRGRP_OPERADOR, OmUsrgrpTemplate._FIELD_NAME_CD, true);
		} else if (isTecnico) {
			omUsrgrp = this.getDao().findByCd(OmUsrgrp.class, ImportacaoInjetUsuarioRN.CD_USRGRP_TECNICO, OmUsrgrpTemplate._FIELD_NAME_CD, true);
		} else if (isAferidor){
			omUsrgrp = this.getDao().findByCd(OmUsrgrp.class, ImportacaoInjetUsuarioRN.CD_USRGRP_METROLOGIA, OmUsrgrpTemplate._FIELD_NAME_CD, true);
		} else {
			omUsrgrp = this.getDao().findByCd(OmUsrgrp.class, ImportacaoInjetUsuarioRN.CD_USRGRP_DEFAULT, OmUsrgrpTemplate._FIELD_NAME_CD, true);
		}
		
		/* Procurar o cargo
		 * 
		 */
		OmCargo omcargo = null;
		if (ijtbusu.getIjtbcar() != null) {
			omcargo = cargoRN.getOmCargo(ijtbusu.getIjtbcar().getCdcargo());
		}

		
		OmUsr omUsr = new OmUsr();

		// Pega os campos que n�o est�o no banco do injet
		OmUsr omUsrDB = null;
		try {
			// Alessandre: em 2-9-14 mudei o find abaixo para pesquisar somente o registro ativo
			omUsrDB = this.getDao().findByCd(OmUsr.class, ijtbusu.getCdusuario(), OmUsrTemplate._FIELD_NAME_CD, true);
			
			// Criar um novo registo desativado
			omUsr.set(0, omUsrDB.getOmUsrByIdUsrstativo(), omUsrDB.getOmUsrgrp(), omUsrDB.getOmUsrByIdUsrrevisao(), omUsrDB.getOmCargo(), 
					omUsrDB.getOmCc(),
					null, ijtbusu.getCdusuario(), omUsrDB.getRevisao(), null, null, (byte) 0 /* stativo*/ ,
					ijtbusu.getNmacesso(), senha, ijtbusu.getNmusuario(), ijtbusu.getNmusuario(), omUsrDB.getUrlSms(),
					omUsrDB.getUrlEmail(), null);
			
			// Alterar os campos no registro original
			omUsrDB.setOmUsrgrp(omUsrgrp);
			omUsrDB.setOmUsrByIdUsrstativo(omUsrOperacao);
			omUsrDB.setOmUsrByIdUsrrevisao(omUsrOperacao);
			omUsrDB.setCdUsr(ijtbusu.getCdusuario());
			omUsrDB.setRevisao(omUsrDB.getRevisao() + 1l);
			omUsrDB.setStAtivo((byte) 1);
			omUsrDB.setLogin(ijtbusu.getCdusuario());
			omUsrDB.setSenha(senha);
			omUsrDB.setDsNome(ijtbusu.getNmusuario());
			omUsrDB.setDsApelido(ijtbusu.getNmusuario());
			omUsrDB.setOmCargo(omcargo);

			omUsrDB.limitarStrings();
			
			getDao().makePersistent(omUsrDB);
			
			
		} catch (RegistroDesconhecidoException e) {
			omUsr.set(0, omUsrOperacao, omUsrgrp, omUsrOperacao, null, null, null, ijtbusu.getCdusuario(), (long) 0, null, null, (byte)1 ,
					ijtbusu.getNmacesso(), senha, ijtbusu.getNmusuario(), ijtbusu.getNmusuario(), null, null, null);
		}

		omUsr.limitarStrings();

		omUsr = this.getDao().makePersistent(omUsr);

	}


}
