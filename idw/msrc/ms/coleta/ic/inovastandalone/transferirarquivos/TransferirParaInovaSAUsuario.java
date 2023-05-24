package ms.coleta.ic.inovastandalone.transferirarquivos;

import ms.coleta.dto.SessaoUPDTO;
import idw.model.pojos.OmUsr;
import idw.model.pojos.template.OmResguiTemplate;
import idw.util.ArquivosDiretorios;
public class TransferirParaInovaSAUsuario extends TransferirParaInovaSAFactory{

	private OmUsr omusr = null;
	private SessaoUPDTO sessaoUP = null;
	
	@Override
	public void criarArquivo() {
		String urlConexao = msmsicup.getMsIc().getUrlConexao();
		try {
			urlConexao = urlConexao.substring(0, urlConexao.indexOf(":"));
		} catch (IndexOutOfBoundsException e){
			urlConexao = msmsicup.getMsIc().getUrlConexao();
		}
		String dir = getDiretorioDestino() + "/" + urlConexao + "/reg/re/";

		String fileName = "re" + omusr.getCdUsr();

		// Se o arquivo existir nao precisa criar denovo
		if(ArquivosDiretorios.isExisteArquivo(dir + fileName) == true)
			return;
		
		log.info("Gerando arquivo em " + dir + fileName);
		
		ArquivoOperadores operador = new ArquivoOperadores();
		operador.setLog(log);
		operador.setTipoUsr((int)omusr.getOmUsrgrp().getIdUsrgrp());
		/*Acrescentado por amaury em 13.10.14 para enviar a senha criptografada para o inovaSA*/
		operador.setSenha(omusr.getSenha());
		operador.setNome(omusr.getDsNome());
		operador.setIsOperador(false);
		operador.setIsTecnico(false);
		operador.setIsTecnicoCIP(false);
		for (idw.model.pojos.OmGrnts grnt : omusr.getOmUsrgrp().getOmGrntses()) {
			if (grnt.getOmResgui().getIdResgui() == OmResguiTemplate._TIPO_RECURSO.CLP_LOGINOPERADOR.getValue())
				operador.setIsOperador(true);
			if (grnt.getOmResgui().getIdResgui() == OmResguiTemplate._TIPO_RECURSO.CLP_LOGINTECNICO.getValue())
				operador.setIsTecnico(true);
			if (grnt.getOmResgui().getIdResgui() == OmResguiTemplate._TIPO_RECURSO.CLP_LOGINTECNICOCIP.getValue())
				operador.setIsTecnicoCIP(true);
		}
		operador.gerarArquivo(dir, fileName);
	}

	@Override
	public void criarArquivoStatus() {
		String urlConexao = msmsicup.getMsIc().getUrlConexao();
		try {
			urlConexao = urlConexao.substring(0, urlConexao.indexOf(":"));
		} catch (IndexOutOfBoundsException e){
			urlConexao = msmsicup.getMsIc().getUrlConexao();
		}
		String dir = getDiretorioDestino() + "/" + urlConexao + "/status/operador/";

		String fileName = "re" + sessaoUP.getIdPt();

		log.info("Gerando arquivo em " + dir + fileName);
		
		ArquivoOperadores operador = new ArquivoOperadores();
		operador.setLog(log);
		operador.setUsuarios(sessaoUP.getUsuarios());
		operador.gerarArquivoStatus(dir, fileName);
		
	}

	public OmUsr getOmusr() {
		return omusr;
	}

	public void setOmusr(OmUsr omusr) {
		this.omusr = omusr;
	}

	public SessaoUPDTO getSessaoUP() {
		return sessaoUP;
	}

	public void setSessaoUP(SessaoUPDTO sessaoUP) {
		this.sessaoUP = sessaoUP;
	}
	
}
