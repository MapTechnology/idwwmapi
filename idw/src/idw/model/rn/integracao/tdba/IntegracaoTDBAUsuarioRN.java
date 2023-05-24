package idw.model.rn.integracao.tdba;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.dao.erp.DAOGenericoErp;
import idw.model.excessoes.DigestFileException;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.RegistroJaDesativadoException;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmJobdet;
import idw.model.pojos.OmJobdetlog;
import idw.model.pojos.OmJoblog;
import idw.model.pojos.OmUsr;
import idw.model.pojos.OmUsrgrp;
import idw.model.rn.DataHoraRN;
import idw.model.rn.GTRN;
import idw.model.rn.HashMD5;
import idw.model.rn.UsuarioRN;
import idw.util.IdwLogger;
import idw.util.Util;
import idw.webservices.dto.UsuarioDTO;

public class IntegracaoTDBAUsuarioRN extends AIntegracaoTDBA {

	public IntegracaoTDBAUsuarioRN(DAOGenerico dao, DAOGenericoErp daoERP) {
		super(dao, daoERP);
	}

	@Override
	public boolean integrar(OmJoblog joblog, OmJobdet det, IdwLogger log, int idLog) {
		boolean retorno = true;

		MapQuery q = new MapQuery(daoERP.getSession());
		q.append(
				"select id, idempresa, idarea, cd_usuario, matricula, nome, login_acesso, senha_acesso, codigo_cargo, descricao_cargo, usuario_tm, usuario_tecnico, usuario_operador, situacao, data_afastamento, tp_interacao from mi_operador_idw where st_registro = 0 order by id");

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
				String cdusuario = registro[3].toString();
				String matricula = registro[4].toString();
				String nome = registro[5].toString();
				String login = registro[6].toString();
				String senha = registro[7].toString();
				String cdcargo = registro[8].toString();
				String dscargo = registro[9].toString();
				Integer usuarioTM = (Integer) registro[10];
				Integer usuarioTecnico = (Integer) registro[11];
				Integer usuarioOperador = (Integer) registro[12];
				Integer situacao = (Integer) registro[13];
				Date dtAfastamento = null;
				if (registro[14] != null)
					dtAfastamento = (Date) registro[14];
				Short tpinteracao = (Short) registro[15];

				if (tpinteracao == 0) {
					// Inclusao/
					incluirUsuario(daoSessao, id, cdusuario, matricula, idArea, nome, login, senha, cdcargo, dscargo, usuarioTM, usuarioTecnico, usuarioOperador, situacao, dtAfastamento);
					// se falhou alguma importacao setar retorno como false
					if (getStregistro() != 1)
						retorno = false;

				} else if (tpinteracao == 1) {
					// Alteracao
					alterarUsuario(daoSessao, id, cdusuario, matricula, idArea, nome, login, senha, cdcargo, dscargo, usuarioTM, usuarioTecnico, usuarioOperador, situacao, dtAfastamento);
					// se falhou alguma importacao setar retorno como false
					if (getStregistro() != 1)
						retorno = false;
				} else if (tpinteracao == 2) {
					// exclusao
					excluirUsuario(daoSessao, id, cdusuario, matricula, idArea, nome, login, senha, cdcargo, dscargo, usuarioTM, usuarioTecnico, usuarioOperador, situacao, dtAfastamento);
					// se falhou alguma importacao setar retorno como false
					if (getStregistro() != 1)
						retorno = false;
				} else {
					// tipo interacao desconhecido
					atualizarResultado(id, 2, "tipo interação desconhecido. validos 0-2", "mi_operador_idw");
				}

				// Incluir o resultado da importação do registro
				OmJobdetlog detlog = new OmJobdetlog();
				detlog.setIdJobdetlog(null);
				detlog.setDsExecucao(getResultado());
				detlog.setDthrIexecucao(dthr);
				detlog.setDthrFexecucao(DataHoraRN.getDataHoraAtual());
				detlog.setOmJoblog(joblog);
				detlog.setOmJobdet(det);
				detlog.setUrlOrigem("id " + id + " em mi_operador_idw");
				detlog.setStExecucao((byte) (getStregistro() == 1 ? 1 : 0));

				dao.makePersistent(detlog);

			}
		} catch (Exception e) {
			e.printStackTrace();
			atualizarResultado(id, 2, "Usuario com erro desconhecido " + e.getMessage(), "mi_operador_idw");
		} finally {
			daoSessao.finalizaConexaoBanco();
		}

		return retorno;

	}

	private void incluirUsuario(DAOGenerico daoSessao, BigInteger id, String cdusuario, String matricula, String idArea, String nome,
			String login, String senha, String cdcargo, String dscargo, Integer usuarioTM, Integer usuarioTecnico, Integer usuarioOperador,
			Integer situacao, Date dtAfastamento) {

		UsuarioRN rn = new UsuarioRN(daoSessao);
		GTRN grn = new GTRN();
		grn.setDao(daoSessao);
		grn.setSession(daoSessao.getSession());

		omcfg = Util.getConfigGeral(daoSessao.getSession());

		// pesquisa PT. Se nao existir marcar como erro na importacao
		OmUsr omusr;
		try {
			omusr = rn.getOmUsr(cdusuario);
		} catch (RegistroDesconhecidoException e) {
			omusr = null;
		}
		if (omusr != null) {
			atualizarResultado(id, 2, "Usuario " + cdusuario + " já existe no idw.", "mi_operador_idw");
		} else {
			// Incluir dados no posto
			omusr = new OmUsr();
			omusr.setIdUsr(0l);
			omusr.setCdUsr(cdusuario);
			omusr.setDtRevisao(DataHoraRN.getDataHoraAtual());
			omusr.setDsApelido(matricula);
			omusr.setDsNome(nome);
			omusr.setLogin(login);
			try {
				omusr.setSenha(HashMD5.getHashCode(senha) );
			} catch (DigestFileException e) {
				atualizarResultado(id, 2, "Usuario " + cdusuario + " não foi possivel criptografar a senha", "mi_operador_idw");
				return;
			}

			OmGt omgt = grn.getOmGtByCdGt(idArea);
			if (omgt == null) {
				atualizarResultado(id, 2, "Usuario " + cdusuario + " não encontrou grupo " + idArea, "mi_operador_idw");
				return;
			}

			// obter o grupo de acesso do operador
			OmUsrgrp omusrgrp = null;
			
			if (usuarioOperador == 1) {
				omusrgrp = omcfg.getOmUsrgrpByIdUsrgrpoperador();
			} else if (usuarioTecnico == 1) {
				omusrgrp = omcfg.getOmUsrgrpByIdUsrgrptecnico();
			} else if (usuarioTM == 1) {
				omusrgrp = omcfg.getOmUsrgrpByIdUsrgrpmonitor();
			}
			
			omusr.setOmUsrgrp(omusrgrp);
			omusr.setOmGt(omgt);
			omusr.setOmUsrByIdUsrrevisao(omcfg.getOmUsrimpprog());
			omusr.setOmUsrByIdUsrstativo(omusr.getOmUsrByIdUsrrevisao());
			UsuarioDTO dto = new UsuarioDTO();
			dto.setUsuario(omusr);
			UsuarioDTO retorno = rn.setUsuarioDTO(dto);
			if (retorno.getResultadoEvento() == retorno.getEVENTO_BEM_SUCEDIDO()) {
				// Marcar como importado com sucesso
				atualizarResultado(id, 1, "Usuario " + cdusuario + " incluido com sucesso.", "mi_operador_idw");
				qtItensImportados++;
			} else {
				atualizarResultado(id, 2, "Usuario " + cdusuario + " erro " + retorno.getDescricaoResultado(), "mi_operador_idw");
			}

		}

	}

	
	
	private void alterarUsuario(DAOGenerico daoSessao, BigInteger id, String cdusuario, String matricula, String idArea, String nome,
			String login, String senha, String cdcargo, String dscargo, Integer usuarioTM, Integer usuarioTecnico, Integer usuarioOperador,
			Integer situacao, Date dtAfastamento) {
		UsuarioRN rn = new UsuarioRN(daoSessao);
		GTRN grn = new GTRN();
		grn.setDao(daoSessao);
		grn.setSession(daoSessao.getSession());

		omcfg = Util.getConfigGeral(daoSessao.getSession());

		// pesquisa PT. Se nao existir marcar como erro na importacao
		OmUsr omusr;
		try {
			omusr = rn.getOmUsr(cdusuario);
		} catch (RegistroDesconhecidoException e) {
			omusr = null;
		}
		if (omusr == null) {
			atualizarResultado(id, 2, "Usuario " + cdusuario + " não existe no idw.", "mi_operador_idw");
		} else {
			
			
			
			
			
			
			// Incluir dados no posto
			omusr.setDtRevisao(DataHoraRN.getDataHoraAtual());
			omusr.setDsApelido(matricula);
			omusr.setDsNome(nome);
			omusr.setLogin(login);
			try {
				omusr.setSenha(HashMD5.getHashCode(senha) );
			} catch (DigestFileException e) {
				atualizarResultado(id, 2, "Usuario " + cdusuario + " não foi possivel criptografar a senha", "mi_operador_idw");
				return;
			}

			OmGt omgt = grn.getOmGtByCdGt(idArea);
			if (omgt == null) {
				atualizarResultado(id, 2, "Usuario " + cdusuario + " não encontrou grupo " + idArea, "mi_operador_idw");
				return;
			}

			// obter o grupo de acesso do operador
			OmUsrgrp omusrgrp = null;
			
			if (usuarioOperador == 1) {
				omusrgrp = omcfg.getOmUsrgrpByIdUsrgrpoperador();
			} else if (usuarioTecnico == 1) {
				omusrgrp = omcfg.getOmUsrgrpByIdUsrgrptecnico();
			} else if (usuarioTM == 1) {
				omusrgrp = omcfg.getOmUsrgrpByIdUsrgrpmonitor();
			}
			
			omusr.setOmUsrgrp(omusrgrp);
			omusr.setOmGt(omgt);
			omusr.setOmUsrByIdUsrrevisao(omcfg.getOmUsrimpprog());
			omusr.setOmUsrByIdUsrstativo(omusr.getOmUsrByIdUsrrevisao());
			UsuarioDTO dto = new UsuarioDTO();
			dto.setUsuario(omusr);
			UsuarioDTO retorno = rn.setUsuarioDTO(dto);
			if (retorno.getResultadoEvento() == retorno.getEVENTO_BEM_SUCEDIDO()) {
				// Marcar como importado com sucesso
				atualizarResultado(id, 1, "Usuario " + cdusuario + " alterado com sucesso.", "mi_operador_idw");
				qtItensImportados++;
			} else {
				atualizarResultado(id, 2, "Usuario " + cdusuario + " erro " + retorno.getDescricaoResultado(), "mi_operador_idw");
			}

		}

		
	}

	private void excluirUsuario(DAOGenerico daoSessao, BigInteger id, String cdusuario, String matricula, String idArea, String nome,
			String login, String senha, String cdcargo, String dscargo, Integer usuarioTM, Integer usuarioTecnico, Integer usuarioOperador,
			Integer situacao, Date dtAfastamento) {
		
		UsuarioRN rn = new UsuarioRN(daoSessao);

		// pesquisa PT. Se nao existir marcar como erro na importacao
		OmUsr omusr;
		try {
			omusr = rn.getOmUsr(cdusuario);
		} catch (RegistroDesconhecidoException e) {
			omusr = null;
		}
		if (omusr == null) {
			atualizarResultado(id, 2, "Usuario " + cdusuario+ " não existe no idw.", "mi_operador_idw");
		} else {
			// Marcar como excluido
			try {
				rn.desativarUsr(omusr.getIdUsr(), DataHoraRN.getDataHoraAtual(), omcfg.getOmUsrimpprog());
				// Marcar como importado com sucesso
				atualizarResultado(id, 1, "Usuario " + cdusuario + " excluido com sucesso.", "mi_operador_idw");
				qtItensImportados++;
			} catch (RegistroJaDesativadoException e) {
				atualizarResultado(id, 2, "Usuario " + cdusuario+ " já excluído no idw.", "mi_operador_idw");
			} catch (Exception e) {
				e.printStackTrace();
				atualizarResultado(id, 2, "Usuario " + cdusuario + " com erro desconhecido. " + e.getMessage(), "mi_operador_idw");
			}
		}
	}
}
