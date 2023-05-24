package idw.model.rn;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;

import idw.model.dao.DAOGenerico;
import idw.model.dao.IDao;
import idw.model.dao.MapQuery;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpNecimp;
import idw.model.pojos.PpNecimpurl;
import idw.webservices.dto.ConfiguracaoNecessidadeDTO;
import idw.webservices.dto.ConfiguracoesNecessidadesDTO;
import idw.webservices.dto.ResultadoDTO;


@SuppressWarnings("serial")
public class ConfiguracaoNecessidadeRN extends ConfiguracaoNecessidadeDTO implements IDao{

	private DAOGenerico dao;

	public ConfiguracaoNecessidadeRN(){
		if (this.dao == null) {
			this.dao = new DAOGenerico();
		}
	}
	public ConfiguracaoNecessidadeRN(DAOGenerico dao){
		this.dao = dao;
	}
	public ConfiguracaoNecessidadeRN(ConfiguracaoNecessidadeDTO configuracaoNecessidadeDTO){
		super(configuracaoNecessidadeDTO);
		if (this.dao == null) {
			this.dao = new DAOGenerico();
		}
	}
	public void iniciaConexaoBanco() {
		iniciaConexaoBanco(null);
	}
	@Override
	public void iniciaConexaoBanco(Session sessao) {
		this.dao.iniciaSessao();
		this.dao.iniciaTransacao();
	}

	@Override
	public void finalizaConexaoBanco() {
		this.dao.finalizaTransacao();
		this.dao.finalizaSessao();
	}

	public ConfiguracoesNecessidadesDTO pesquisar(ConfiguracaoNecessidadeDTO configuracaoNecessidadeDTO){
		ConfiguracoesNecessidadesDTO retorno = new ConfiguracoesNecessidadesDTO();

		MapQuery q = new MapQuery(this.dao.getSession());

		q.append("select distinct ppnecimp from PpNecimp ppnecimp left join fetch ppnecimp.ppNecimpurls ppnecimpurl ");

		q.appendWhere(MapQuery._NULL, "ppnecimp.cdNecimp = :cdnecimp", ((configuracaoNecessidadeDTO.getCdNecimp() != null) && (configuracaoNecessidadeDTO.getCdNecimp().equals("") == false)));
		q.appendWhere(MapQuery._AND, "ppnecimp.idNecimp = :idnecimp", (configuracaoNecessidadeDTO.getIdNecimp() != null) && (configuracaoNecessidadeDTO.getIdNecimp() > 0) );
		q.appendWhere(MapQuery._AND, "ppnecimp.stAtivo = :stativo", configuracaoNecessidadeDTO.getStAtivo() != null);
		q.appendWhere(MapQuery._AND, "ppnecimp.stAtivo = 1", configuracaoNecessidadeDTO.getStAtivo() == null);

		q.defineParametro("cdnecimp", configuracaoNecessidadeDTO.getCdNecimp());
		q.defineParametro("idnecimp", configuracaoNecessidadeDTO.getIdNecimp());
		q.defineParametro("stativo", configuracaoNecessidadeDTO.getStAtivo());

		List<PpNecimp> lista = q.list();

		for (PpNecimp ppnecimp : lista){
			ConfiguracaoNecessidadeDTO c = new ConfiguracaoNecessidadeDTO(ppnecimp.clone());
			retorno.getConfiguracoesNecessidadesDTO().add(c);
		}
		return retorno;
	}

	public PpNecimp pesquisarPpnecimpByCdESt() {
		MapQuery q = new MapQuery(this.dao.getSession());

		q.append("select ppnecimp from PpNecimp ppnecimp  where ppnecimp.cdNecimp = :cdNecimp ");
		q.append("and ppnecimp.stAtivo = 1 ");

		q.defineParametro("cdNecimp", this.getCdNecimp());
		q.setMaxResults(1);

		return (PpNecimp) q.uniqueResult();
	}

	public PpNecimp pesquisarPpnecimpById() {
		MapQuery q = new MapQuery(this.dao.getSession());

		q.append("select ppnecimp from PpNecimp ppnecimp  where ppnecimp.idNecimp = :idNecimp ");

		q.defineParametro("idNecimp", this.getIdNecimp());

		return (PpNecimp) q.uniqueResult();
	}

	public ConfiguracaoNecessidadeDTO excluirRegistro() {
		ConfiguracaoNecessidadeDTO retorno = this;
		ResultadoDTO resultadoDTO = new ResultadoDTO();
		retorno.setResultadoDTO(resultadoDTO);

		// Pesquisa o ppnecimp que se deseja excluir
		PpNecimp ppnecimp = this.pesquisarPpnecimpById();

		// Se nao existir o registro desejado para exclusao, entao retornar ao solicitante informando registro desconhecido
		if (ppnecimp == null){
			resultadoDTO.setIdmensagem(resultadoDTO.CODIGO_DESCONHECIDO);
			return retorno;
		}

		// Se o registro solicitado para exclusao ja estiver marcado como excluir, retornar ao solicitante informando a situacao
		if(ppnecimp.getStAtivo() == BigDecimal.ZERO.toString().charAt(0)) {
			resultadoDTO.setIdmensagem(resultadoDTO.ERRO_EXCLUI_STATIVO_ZERO);
			return retorno;
		}

		// Pesquisar o usuario logado
		OmUsr msusr = null;
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.setDaoSession(this.dao.getSession());

		try {
			msusr = usuarioRN.getDao().findById(OmUsr.class, this.getOmUsrByIdUsrstativo().getIdUsr(), false);

			if(msusr == null){
				resultadoDTO.setIdmensagem(resultadoDTO.USUARIO_DESCONHECIDO);
				return retorno;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}


		// Marca stAtivo com zero informando que registro foi desativado
		ppnecimp.setStAtivo( (byte) 0);
		ppnecimp.setDtStativo(DataHoraRN.getDataHoraAtual());
		ppnecimp.setOmUsrByIdUsrstativo(msusr);

		this.dao.makePersistent(ppnecimp);


		retorno = new ConfiguracaoNecessidadeDTO(ppnecimp.clone());
		resultadoDTO.setIdmensagem(resultadoDTO.COM_SUCESSO);

		return retorno;
	}


	public ConfiguracaoNecessidadeDTO salvarRegistro() {
		ConfiguracaoNecessidadeDTO retorno =  new ConfiguracaoNecessidadeDTO();
		ResultadoDTO resultadoDTO = new ResultadoDTO();
		retorno.setResultadoDTO(resultadoDTO);

		PpNecimp ppnecimp = this.pesquisarPpnecimpByCdESt();

		// Se existir o registro, entao marcalo como removido
		if (ppnecimp != null) {
			if ((this.getIdNecimp() != null) && (this.getIdNecimp() > 0)) {
				this.excluirRegistro();
			} else {
				resultadoDTO.setIdmensagem(Integer.valueOf(resultadoDTO.REGISTRO_JA_EXISTE).intValue());
				return retorno;
			}
		}

		PpNecimp ppNecimpNovo = this.clone();

		ppNecimpNovo.setIdNecimp(null);
		ppNecimpNovo.setStAtivo((byte) 1);
		ppNecimpNovo.setDtRevisao(DataHoraRN.getDataHoraAtual());
		ppNecimpNovo.setDtStativo(DataHoraRN.getDataHoraAtual());

		// Define o numero da revisao
		if ((ppNecimpNovo.getRevisao() == null) || ((ppNecimpNovo.getRevisao() != null) && (ppNecimpNovo.getRevisao() <= 0)) ){
			ppNecimpNovo.setRevisao(1);
		} else {
			ppNecimpNovo.setRevisao(ppNecimpNovo.getRevisao() + 1);
		}

		//pesquisa o Usuario do stativo
		OmUsr omUsrStAtivo = null;
		OmUsr omUsrRevisao = null;
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.setDaoSession(this.dao.getSession());

		try {
			omUsrStAtivo = usuarioRN.getDao().findById(OmUsr.class, this.getOmUsrByIdUsrstativo().getIdUsr(), false);

			if(omUsrStAtivo == null) {
				resultadoDTO.setIdmensagem(Integer.valueOf(resultadoDTO.USUARIO_DESCONHECIDO).intValue());
				return retorno;

			}
		} catch(Exception e) {
			resultadoDTO.setIdmensagem(Integer.valueOf(resultadoDTO.USUARIO_DESCONHECIDO).intValue());
			return retorno;
		}

		try {
			omUsrRevisao = usuarioRN.getDao().findById(OmUsr.class, this.getOmUsrByIdUsrstativo().getIdUsr(), false);

			if(omUsrRevisao == null) {
				resultadoDTO.setIdmensagem(Integer.valueOf(resultadoDTO.USUARIO_DESCONHECIDO).intValue());
				return retorno;

			}
		} catch(Exception e) {
			resultadoDTO.setIdmensagem(Integer.valueOf(resultadoDTO.USUARIO_DESCONHECIDO).intValue());
			return retorno;
		}

		ppNecimpNovo.setOmUsrByIdUsrstativo(omUsrStAtivo);
		ppNecimpNovo.setOmUsrByIdUsrrevisao(omUsrRevisao);

		if((ppNecimpNovo.getPpNecimpurls() != null) && (ppNecimpNovo.getPpNecimpurls().size() > 0)) {
			// Interage sobre os registros para setar o pai com o objetivo de salvar por cascata
			for (PpNecimpurl purl : ppNecimpNovo.getPpNecimpurls()){
				purl.setIdNecimpurl(null);
				purl.setPpNecimp(ppNecimpNovo);
			}
		}

		this.dao.makePersistent(ppNecimpNovo);

		resultadoDTO.setIdmensagem(resultadoDTO.COM_SUCESSO);

		ConfiguracaoNecessidadeDTO resultadoPersistent = new ConfiguracaoNecessidadeDTO(ppNecimpNovo.clone());
		resultadoPersistent.setResultadoDTO(resultadoDTO);

		retorno = resultadoPersistent;


		return retorno;
	}

}
