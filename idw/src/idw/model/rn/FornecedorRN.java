package idw.model.rn;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.dao.OmForDAO;
import idw.model.dao.OmUsrDAO;
import idw.model.pojos.OmFor;
import idw.model.pojos.OmUsr;
import idw.webservices.dto.FornecedorDTO;
import idw.webservices.dto.FornecedoresDTO;

public class FornecedorRN extends DAOGenerico{

	public FornecedoresDTO getFornecedoresDTO(FornecedorDTO filtro){
		OmForDAO forDAO = new OmForDAO(getSession());
		List<OmFor> listaOmfornecedor = null;
		try{
			listaOmfornecedor = forDAO.getOmFor(filtro.getFornecedor());
		} catch (Exception e){
			e.printStackTrace();
		}

		List<FornecedorDTO> lista = new ArrayList<FornecedorDTO>();

		if (listaOmfornecedor != null){
			for (OmFor omFornecedor : listaOmfornecedor) {
				FornecedorDTO fornecedor = new FornecedorDTO();								
				fornecedor.setFornecedor((OmFor)omFornecedor.clone());
				
				fornecedor.setResultadoEvento(0);
				lista.add(fornecedor);
			}
		}

		FornecedoresDTO fornecedors = new FornecedoresDTO();
		fornecedors.setFornecedores(lista);
		return fornecedors;
	}

	public FornecedorDTO setFornecedorDTO(FornecedorDTO fornecedor){
		FornecedorDTO fornecedorRetorno = new FornecedorDTO();
		fornecedorRetorno.setResultadoEvento(fornecedorRetorno.getEVENTO_BEM_SUCEDIDO());

		if (fornecedor.getFornecedor().getCdFor().trim().equals("")){
			fornecedorRetorno.setResultadoEvento(fornecedorRetorno.getERRO_CDFORNECEDOR_INVALIDO());
			return fornecedorRetorno;
		}

		boolean isInclusao = false;

		OmForDAO forDAO = new OmForDAO(getSession());

		OmFor omFornecedorOriginal = forDAO.getOmForPorId(fornecedor.getFornecedor().getIdFor());

		OmFor omFornecedorAlteracao = null;

		if (omFornecedorOriginal == null){			
			omFornecedorOriginal = (OmFor)fornecedor.getFornecedor().clone();
			omFornecedorOriginal.setRevisao(1l);
			omFornecedorOriginal.setDtRevisao(new Date());
			omFornecedorOriginal.setStAtivo((byte)1);
			omFornecedorOriginal.setDtStativo(new Date());			
			isInclusao = true;
			
			// Verifica se o codigo + revisao do grupo de usuario ja existe no banco, se exitir retornar ao cliente a excessao
			OmFor forAux = forDAO.getOmForPorCdAtivoOrderById(omFornecedorOriginal.getCdFor());
			if(forAux != null){
				fornecedorRetorno.setResultadoEvento(fornecedorRetorno.getERRO_FORNECEDOR_JA_EXISTE());
				return fornecedorRetorno;
			}
		}else{
			omFornecedorAlteracao = new OmFor();
			omFornecedorAlteracao.copy(omFornecedorOriginal, true);
			omFornecedorAlteracao.setIdFor(0l);			
			omFornecedorAlteracao.setStAtivo((byte)0);
			omFornecedorOriginal.copy(fornecedor.getFornecedor(), false);			
			omFornecedorOriginal.setDtRevisao(new Date());
		}			

		// Somente apos pesquisar se a nova revisao ja existe é que o pojo original deve ter a revisao somada, se for antes,
		// a pesquisa acima ira trazer o pojo somado
		if (isInclusao == false){			
			omFornecedorOriginal.setRevisao(omFornecedorOriginal.getRevisao()+1);			
		}				

		OmUsrDAO usrDAO = new OmUsrDAO(getSession());
		
		try {
			OmUsr omUsrRevisao = usrDAO.getOmUsrPorCdAtivoOrderById(fornecedor.getFornecedor().getOmUsrByIdUsrrevisao().getCdUsr());//(OmUsr) q.list().get(0);
			omFornecedorOriginal.setOmUsrByIdUsrrevisao(omUsrRevisao);
			if(omUsrRevisao == null){
				fornecedorRetorno.setResultadoEvento(fornecedorRetorno.getERRO_USUARIO_REVISAO_DESCONHECIDO());
				return fornecedorRetorno;
			}
		} catch (Exception e) {
			fornecedorRetorno.setResultadoEvento(fornecedorRetorno.getERRO_USUARIO_REVISAO_DESCONHECIDO());
			e.printStackTrace();
			return fornecedorRetorno;
		}

		try {
			OmUsr omUsrStAtivo = usrDAO.getOmUsrPorCdAtivoOrderById(fornecedor.getFornecedor().getOmUsrByIdUsrstativo().getCdUsr());//(OmUsr) q.list().get(0);
			omFornecedorOriginal.setOmUsrByIdUsrstativo(omUsrStAtivo);
			if(omUsrStAtivo == null){
				fornecedorRetorno.setResultadoEvento(fornecedorRetorno.getERRO_USUARIO_STATUS_DESCONHECIDO());
				return fornecedorRetorno;
			}
		} catch (Exception e) {
			fornecedorRetorno.setResultadoEvento(fornecedorRetorno.getERRO_USUARIO_STATUS_DESCONHECIDO());
			e.printStackTrace();
			return fornecedorRetorno;
		}

		if (fornecedorRetorno.getResultadoEvento() == fornecedorRetorno.getEVENTO_BEM_SUCEDIDO()){
			try{
				omFornecedorOriginal = (OmFor) makePersistent(omFornecedorOriginal);
				if (omFornecedorAlteracao != null){
					makePersistent(omFornecedorAlteracao);
				}
			} catch (Exception e){
				fornecedorRetorno.setResultadoEvento(fornecedorRetorno.getERRO_DESCONHECIDO());
				e.printStackTrace();
			}

			fornecedorRetorno.setFornecedor((OmFor)omFornecedorOriginal.clone());
			
		}

		return fornecedorRetorno;
	}	

	public FornecedoresDTO removeFornecedoresDTO(FornecedoresDTO fornecedors){

		List<FornecedorDTO> listaRetorno = new ArrayList<FornecedorDTO>();
		for (FornecedorDTO fornecedor : fornecedors.getFornecedores()){
			FornecedorDTO dto = new FornecedorDTO();
			OmForDAO forDAO = new OmForDAO(getSession());
			OmFor omFornecedor = forDAO.getOmForPorId(fornecedor.getFornecedor().getIdFor());

			if (omFornecedor == null){			
				dto.setResultadoEvento(dto.getERRO_DESCONHECIDO());
				dto.setFornecedor(fornecedor.getFornecedor());				
			}else if (omFornecedor.getStAtivo() == 0){			
				dto.setResultadoEvento(dto.getERRO_DESCONHECIDO());
				dto.setFornecedor((OmFor)omFornecedor.clone());				
			}else{
				omFornecedor.setStAtivo((byte)0);
				omFornecedor.setDtStativo(new Date());
				try{
					omFornecedor = (OmFor) makePersistent(omFornecedor);			
				} catch (Exception e){
					e.printStackTrace();
				}
				dto.setFornecedor((OmFor)omFornecedor.clone());
				dto.setResultadoEvento(dto.getEVENTO_BEM_SUCEDIDO());
			}									

			listaRetorno.add(dto);
		}

		FornecedoresDTO retorno = new FornecedoresDTO();
		retorno.setFornecedores(listaRetorno);
		return retorno;
	}

	public FornecedorDTO ativaFornecedorDTO(FornecedorDTO fornecedor){
		FornecedorDTO retorno = new FornecedorDTO();

		// Verifica se a revisao que está sendo reativada á a maior para o codigo
		OmForDAO forDAO = new OmForDAO(getSession());
		OmFor forAux = forDAO.getOmForPorCdMaiorRevisao(fornecedor.getFornecedor().getCdFor(), 
				fornecedor.getFornecedor().getRevisao());
		if(forAux != null){
			retorno.setResultadoEvento(retorno.getERRO_REATIVACAO_INDISPONIVEL());
			return retorno;
		}

		OmFor omFornecedor = forDAO.getOmForPorId(fornecedor.getFornecedor().getIdFor());

		if (omFornecedor == null){			
			retorno.setResultadoEvento(retorno.getERRO_DESCONHECIDO());
			retorno.setFornecedor(fornecedor.getFornecedor());
			return retorno;
		}else if (omFornecedor.getStAtivo() == 1){			
			retorno.setResultadoEvento(retorno.getERRO_DESCONHECIDO());
			retorno.setFornecedor((OmFor)omFornecedor.clone());				
		}else{
			omFornecedor.setStAtivo((byte)1);
			omFornecedor.setDtStativo(new Date());			
		}					

		try{
			omFornecedor = (OmFor) makePersistent(omFornecedor);			
		} catch (Exception e){
			e.printStackTrace();
		}				
		
		retorno.setFornecedor((OmFor)omFornecedor.clone());
		retorno.setResultadoEvento(retorno.getEVENTO_BEM_SUCEDIDO());
		return retorno;
	}		
	
	public OmFor pesquisarOmForByCdStAtivo(String cd){
		MapQuery q = new MapQuery(getSession());
		
		q.append("from OmFor omfor");
		q.append("where omfor.cdFor = :cd");
		q.append("and omfor.stAtivo = 1");
		
		q.defineParametro("cd", cd);
		q.setMaxResults(1);
		
		return (OmFor) q.uniqueResult();
	}
}

