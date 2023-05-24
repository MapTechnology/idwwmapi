package idw.model.rn.pdba;

import java.util.Date;

import idw.model.pojos.MsEvt;
import idw.model.pojos.OmGrnts;
import idw.model.pojos.OmUsr;
import idw.model.pojos.template.MsEvtTemplate;
import idw.model.pojos.template.OmGrntsTemplate;
import idw.model.pojos.template.OmResguiTemplate;
import idw.model.rn.DataHoraRN;
import idw.model.rn.HashMD5;
import idw.model.rn.UsuarioRN;
import idw.webservices.dto.UsuarioDTO;
import injetws.webservices.dto.IwsAutenticacaoDTO;
import injetws.webservices.dto.IwsErroDTO;
import ms.coleta.servico.ServicoFactory;

public class MaoDeObraPdbaMsEvtRN extends AbstractPdbaMsEvtRN{

	/*
	 * Esse metododo � a substituicao do metodo com mesmo nome do injetws. Seu objetivo � chamar o metodo do inejtws e salvar o evento tambem em msevt
	 */
	public IwsErroDTO setTr_operadorInicio(String idUp, String cdOperador, Date dthrInicio){
		IwsErroDTO retorno = null;
		
		retorno = new IwsErroDTO();
		
		// Chama execuca do servico do ms. Se houver erro o metodo deve continuar para nao prejudicar o PDBA
		try {
			MsEvt msevt = executarServico(null, idUp, cdOperador, dthrInicio, null, null, ServicoFactory._LOGIN, "setTr_operadorInicio " + DataHoraRN.getDataHoraAtualFormatada());
			
			if (msevt == null || msevt.getStEvt().equals(MsEvtTemplate.StEvt.REJEITADO.getValueBigDecimal())) {
				retorno.setMensagem("Login falhou");
				retorno.setSucesso(false);
			} else {
				retorno.setMensagem("Login com sucesso");
				retorno.setSucesso(true);
			}
		} catch (Exception e){
			e.printStackTrace();
			retorno.setMensagem("Login falhou");
			retorno.setSucesso(false);
		}
		
		
		return retorno;

	}

	public IwsErroDTO setTr_operadorFim(String idUp, String cdOperador, Date dthrFim, Date dthrInicio){
		// Chama execucao do InjetWS para popular PRCOLETOREVENTOS
		IwsErroDTO retorno = new IwsErroDTO();
		
		// Chama execuca do servico do ms. Se houver erro o metodo deve continuar para nao prejudicar o PDBA
		try {
			MsEvt msevt = executarServico(null, idUp, cdOperador, dthrFim, dthrInicio, null, ServicoFactory._LOGOUT, "setTr_operadorFim " + DataHoraRN.getDataHoraAtualFormatada());
			if (msevt.getStEvt().equals(MsEvtTemplate.StEvt.REJEITADO.getValueBigDecimal())) {
				retorno.setMensagem("Logout falhou");
				retorno.setSucesso(false);
			} else {
				retorno.setMensagem("Logout com sucesso");
				retorno.setSucesso(true);
			}
		} catch (Exception e){
			e.printStackTrace();
			retorno.setMensagem("Logout falhou");
			retorno.setSucesso(false);
		}
		
		return retorno;
	}
	public IwsAutenticacaoDTO getTr_Autorizacao(String idUp, String login, String password, int avaliar,Date DataHrAtual,Boolean validaPorDsUsuario){
		IwsAutenticacaoDTO retorno = null;
		
		retorno = new IwsAutenticacaoDTO();

		UsuarioRN rn = new UsuarioRN();
		
//		try {
//			System.out.println("getTr_Autorizacao idUp=" + idUp + " login=" + login + " avaliar=" + avaliar + " dthr=" + DataHrAtual + " validarPorDsUsuario=" + validaPorDsUsuario);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		try {
			retorno.setIsAutorizado(false);
			retorno.setResultadoAutenticacao(IwsAutenticacaoDTO.NaoAutorizado);
			retorno.setDtHrLogin(DataHrAtual);
			retorno.setNomeOperador("");
			retorno.setIdOperador("");
			retorno.setCdUsuario("");

			rn.iniciaConexaoBanco();

			UsuarioDTO usuario = new UsuarioDTO();
			OmUsr omusr = new OmUsr();
			omusr.setLogin(login);
			
			omusr.setSenha(HashMD5.getHashCode(password));
			usuario.setUsuario(omusr);
			usuario = rn.isUsuarioAutenticado(usuario);

			
			/* Se usuario informou corretamente a senha, verificar se o cliente deseja verificar se eh necessario o logout
			 * 
			 */
			if (usuario.getResultadoEvento() == usuario.getEVENTO_BEM_SUCEDIDO()) {
				if (avaliar == IwsAutenticacaoDTO.AVALIAR_OPERADOR) {
					// Verificar se o usuario tem direitor de acesso negado ao recurso de operador
					for (OmGrnts direito : usuario.getUsuario().getOmUsrgrp().getOmGrntses()) {
						if (direito.getOmResgui().getIdResgui() == OmResguiTemplate._TIPO_RECURSO.CLP_LOGINOPERADOR.getValue()) {
							if (direito.getTpAcesso() == OmGrntsTemplate._TpAcesso._ACESSONEGADO.getValue()) {
								usuario.setResultadoEvento(-1); // forca um erro para gerar uma nao autorizacao
							}
						}
					}
				} else if (avaliar == IwsAutenticacaoDTO.AVALIAR_TEC_CIP){
					for (OmGrnts direito : usuario.getUsuario().getOmUsrgrp().getOmGrntses()) {
						if (direito.getOmResgui().getIdResgui() == OmResguiTemplate._TIPO_RECURSO.CLP_LOGINTECNICOCIP.getValue()) {
							if (direito.getTpAcesso() == OmGrntsTemplate._TpAcesso._ACESSONEGADO.getValue()) {
								usuario.setResultadoEvento(-1); // forca um erro para gerar uma nao autorizacao
							}
						}
					}
				}
			}
			
			if (usuario.getResultadoEvento() == usuario.getEVENTO_BEM_SUCEDIDO()) {
				
				retorno.setIsAutorizado(true);
				retorno.setNomeOperador(usuario.getUsuario().getDsApelido());
				retorno.setIdOperador(String.valueOf(usuario.getUsuario().getIdUsr()));
				retorno.setCdUsuario(usuario.getUsuario().getCdUsr());
				
				retorno.setResultadoAutenticacao(IwsAutenticacaoDTO.Autorizado);
			} else {
				retorno.setIsAutorizado(false);
				retorno.setResultadoAutenticacao(IwsAutenticacaoDTO.NaoAutorizado);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		
		return retorno;
	}
	
	public IwsAutenticacaoDTO getTr_AutorizacaoLogout(String idUp, String login, String password,Date DataHrAtual,Boolean validaPorDsUsuario){
		IwsAutenticacaoDTO retorno = null;
		
		retorno = new IwsAutenticacaoDTO();

		UsuarioRN rn = new UsuarioRN();

		try {
			retorno.setIsAutorizado(false);
			retorno.setResultadoAutenticacao(IwsAutenticacaoDTO.NaoAutorizado);
			retorno.setDtHrLogin(DataHrAtual);
			retorno.setNomeOperador("");
			retorno.setIdOperador("");
			retorno.setCdUsuario("");

			rn.iniciaConexaoBanco();

			UsuarioDTO usuario = new UsuarioDTO();
			OmUsr omusr = new OmUsr();
			omusr.setLogin(login);
			omusr.setSenha(HashMD5.getHashCode(password));
			usuario.setUsuario(omusr);
			usuario = rn.isUsuarioAutenticado(usuario);

			if (usuario.getResultadoEvento() == usuario.getEVENTO_BEM_SUCEDIDO()) {
				retorno.setIsAutorizado(true);
				retorno.setNomeOperador(usuario.getUsuario().getDsApelido());
				retorno.setIdOperador(String.valueOf(usuario.getUsuario().getIdUsr()));
				retorno.setCdUsuario(usuario.getUsuario().getCdUsr());
				retorno.setResultadoAutenticacao(IwsAutenticacaoDTO.Autorizado);

				// Realizar o logout agora (para semp)
				setTr_operadorFim(idUp, login, DataHrAtual, DataHrAtual);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public static void main(String[] args) {
		MaoDeObraPdbaMsEvtRN rn = new MaoDeObraPdbaMsEvtRN();
		//rn.getTr_Autorizacao("000004", "DAN", "1", 0, DataHoraRN.getDataHoraAtual(), true);
		rn.getTr_ValidaLoginSenha("1011", "1", 3);
	}

	public boolean getTr_ValidaLoginSenha(String login, String senha, int avaliar ){
		UsuarioRN rn = new UsuarioRN();
		boolean isRetorno = false;
		
		try {
			System.out.println("getTr_ValidaLoginSenha login=" + login + " avaliar=" + avaliar);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			rn.iniciaConexaoBanco();

			UsuarioDTO usuario = new UsuarioDTO();
			OmUsr omusr = new OmUsr();
			omusr.setLogin(login);
			
			omusr.setSenha(HashMD5.getHashCode(senha));
			usuario.setUsuario(omusr);
			usuario = rn.isUsuarioAutenticado(usuario);
			if (usuario.getResultadoEvento() == usuario.getEVENTO_BEM_SUCEDIDO()) {
				
				isRetorno = true;
				
				// Se avaliar == 3 (tecnico 1) avaliar se o direito CLP - Logar como tecnico esta negado. Se tiver bloquear acesso
				// Se avaliar == 4 (tecnico 2) avaliar se o direito CLP - Logar como tecnico esta negado. Se tiver bloquear acesso
				// Se avaliar == 5 (tecnico resp acho) avaliar se o direito CLP - Logar como tecnico esta negado. Se tiver bloquear acesso
				if (avaliar >= 3 && avaliar <= 5) {
					for (OmGrnts direito : usuario.getUsuario().getOmUsrgrp().getOmGrntses()) {
						if (direito.getOmResgui().getIdResgui() == OmResguiTemplate._TIPO_RECURSO.CLP_LOGINTECNICO.getValue()) {
							if (direito.getTpAcesso().equals(OmGrntsTemplate._TpAcesso._ACESSONEGADO.getValue()))
								isRetorno = false;
						}
					}
				}
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		
		return isRetorno;
	}
}
