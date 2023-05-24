package idw.model.rn;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.Validate;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.pojos.DwRap;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpCliente;
import idw.model.pojos.PpCp;
import idw.model.pojos.PpNec;
import idw.model.pojos.PpPlanec;
import idw.model.pojos.PpPlano;
import idw.model.pojos.template.DwRapTemplate;
import idw.model.pojos.template.PpClienteTemplate;
import idw.model.pojos.template.PpCpTemplate;
import idw.webservices.dto.PlanoDTO;
import idw.webservices.dto.PlanoListDTO;
import idw.webservices.dto.ResultadoDTO;

public class PlanejamentoProducaoRN extends AbstractRN<DAOGenerico>{

	public PlanejamentoProducaoRN() {
		this(new DAOGenerico());
	}
	public PlanejamentoProducaoRN(DAOGenerico dao) {
		super(dao);
		if(this.getDao() == null){
			this.setDao(new DAOGenerico());
		}		
	}

	public Map<String, OmProduto> getProdutosFinaisDosPlanosAtivos(List<PpPlano> listaPpPlano){
		
		Map<String, OmProduto> listaOmProduto = new HashMap<String, OmProduto>();
		
		for(PpPlano ppPlano: listaPpPlano){
			for (PpPlanec ppplanec : ppPlano.getPpPlanecs()){
				PpNec ppnec = ppplanec.getPpNec();
				OmProduto omProduto = ppnec.getOmProduto();
				listaOmProduto.put(omProduto.getCdProduto(), omProduto);				
			}
		}
		
		return listaOmProduto;		
	}
	
	public Map<String, OmProduto> getProdutosFinaisDosPlanosAtivos(PlanoDTO plano, boolean isJoinClienteProduto, boolean isJoinUnidadeMedidaProduto, boolean isJoinProdutoComGrupo,  
			boolean isJoinEstruturaProduto, int niveisEstruturaProduto, boolean isJoinProdutoEstuturaComUnidadeMedida){

		List<PpPlano> listaPpPlano = pesquisarPlanosAtivos(plano, isJoinUnidadeMedidaProduto, isJoinClienteProduto, isJoinProdutoComGrupo, true, niveisEstruturaProduto, isJoinProdutoEstuturaComUnidadeMedida);
		
		return getProdutosFinaisDosPlanosAtivos(listaPpPlano);
		
	}

	public List<PpPlano> pesquisarPlanosAtivos(PlanoDTO plano, boolean isJoinProdutoComCliente, boolean isJoinUnidadeMedidaProduto, boolean isJoinProdutoComGrupo, 
			boolean isJoinEstruturaProduto, int niveisEstruturaProduto, boolean isJoinProdutoEstuturaComUnidadeMedida) {
		
		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("select distinct plano from PpPlano plano");
		q.append("inner join fetch plano.ppPlanecs planec");
		q.append("inner join fetch planec.ppNec ppnec");
		q.append("inner join fetch ppnec.ppNeccrons neccron");
		
		if(isJoinEstruturaProduto){			
			
			q.append("INNER JOIN FETCH ppnec.omProduto omProduto");
			
			if(isJoinUnidadeMedidaProduto){
				q.append(ProdutoRN.getHqlLeftJoinProdutoComUnidadeMedida("omProduto",""));
			}
			
			if(isJoinProdutoComCliente){
				q.append(ProdutoRN.getHqlLeftJoinProdutoComCliente("omProduto", ""));
			}
			
			if(isJoinProdutoComGrupo){
				q.append(ProdutoRN.getHqlLeftJoinProdutoComGrupoProduto("omProduto", ""));
			}
			
			q.append(ProdutoRN.getHqlLeftJoinProdutoComEstrutura("omProduto", niveisEstruturaProduto, isJoinProdutoEstuturaComUnidadeMedida, false));
			
		}

		q.appendWhere(MapQuery._NULL, "plano.cdPlano = :cdplano", ((plano.getCdPlano() != null) && (!plano.getCdPlano().isEmpty())));
		q.appendWhere(MapQuery._AND, "plano.dsPlano = :dsplano", ((plano.getDsPlano() != null) && (!plano.getDsPlano().isEmpty())));
		q.appendWhere(MapQuery._AND, "plano.stPlano = :stplano", (plano.getStPlano() != null));
		q.appendWhere(MapQuery._AND, "plano.stAtivo = 1", true);

		q.defineParametro("cdplano", plano.getCdPlano());
		q.defineParametro("dsplano", plano.getDsPlano());
		q.defineParametro("stplano", plano.getStPlano());

		return q.list();
				
	}
	
	public PlanoListDTO pesquisarPlanosAtivosParaPlanoListDTO(PlanoDTO plano) {
		PlanoListDTO retorno = new PlanoListDTO();
		ResultadoDTO resultado = new ResultadoDTO();
		retorno.setResultado(resultado);

		List<PpPlano> listaPlano = pesquisarPlanosAtivos(plano, false, false, false, false, 0, false);
			
		if((listaPlano != null) && (!listaPlano.isEmpty())) {
			retorno.setPlanos(new ArrayList<PlanoDTO>());

			for(PpPlano p : listaPlano) {
				PlanoDTO planoDTO = new PlanoDTO(p, this.getDao());

				planoDTO.setPpPlancols(null);
				planoDTO.setPpPlanptgts(null);
				planoDTO.setPpTpplano(null);
				planoDTO.setDwCal(null);

				Set<PpPlanec> listaPlanecs = planoDTO.getPpPlanecs();
				if((listaPlanecs != null) && (!listaPlanecs.isEmpty())) {
					planoDTO.setPpPlanecs(new HashSet<PpPlanec>());

					for(PpPlanec planec : listaPlanecs) {
						PpPlanec ppPlanec = planec.clone();

						//no clone do ppnec ele ja retorna o clone dos Neccrons
						ppPlanec.setPpNec(planec.getPpNec().clone(false));

						//porem o clone tambem traz os pais, por isso devem ser setados para null
						ppPlanec.getPpNec().setPpPlanecs(null);
						ppPlanec.getPpNec().setPpCliente(null);

						planoDTO.getPpPlanecs().add(ppPlanec);
					}
				}

				retorno.getPlanos().add(planoDTO);
			}

			resultado.setIdmensagem(resultado.COM_SUCESSO);
		}

		return retorno;
	}

	@Override
	public void iniciaConexaoBanco() {
		this.getDao().iniciaSessao();
		this.getDao().iniciaTransacao();
	}

	@Override
	public void finalizaConexaoBanco() {
		this.getDao().finalizaTransacao();
		this.getDao().finalizaSessao();
	}

	/**
	 * Busca �ltima revis�o {@code PpCp} pelo c�digo e ativo
	 * @param cdCp
	 * @return
	 * @throws RegistroDesconhecidoException
	 */
	public PpCp findPpCpByCdCp(String cdCp) throws RegistroDesconhecidoException{
		Validate.notBlank(cdCp, "n�o foi possivel consultar ppCp, o cdCp est� vazio");
		return this.getDao().findByCd(PpCp.class, cdCp, PpCpTemplate._FIELD_NAME_CD, true);
	}
	/**
	 * Busca �ltima revis�o {@code PpCliente} pelo c�digo e ativo
	 * @param cdCliente
	 * @return
	 * @throws RegistroDesconhecidoException
	 */
	public PpCliente findPpClienteByCdCliente(String cdCliente) throws RegistroDesconhecidoException{
		Validate.notBlank(cdCliente, "cdCliente");
		return this.findPpClienteByCdCliente(cdCliente, true);
	}

	/**
	 * Busca �ltima revis�o {@code PpCliente} pelo c�digo
	 * @param cdCliente
	 * @param isFiltroAtivo se true, busca apenas o ativo
	 * @return
	 * @throws RegistroDesconhecidoException
	 */
	public PpCliente findPpClienteByCdCliente(String cdCliente, boolean isFiltroAtivo) throws RegistroDesconhecidoException{
		Validate.notBlank(cdCliente, "cdCliente");
		return this.getDao().findByCd(PpCliente.class, cdCliente, PpClienteTemplate._FIELD_NAME_CD, isFiltroAtivo);
	}

	/**
	 * Busca �ltima revis�o {@code DwRap} pelo c�digo e ativo
	 * @param cdRap
	 * @return
	 * @throws RegistroDesconhecidoException
	 */
	public DwRap findDwRapByCdRap(String cdRap) throws RegistroDesconhecidoException{
		Validate.notBlank(cdRap, "cdRap");
		return this.findDwRapByCdRap(cdRap, true);
	}

	/**
	 * Busca �ltima revis�o {@code DwRap} pelo c�digo
	 * @param cdRap
	 * @param isFiltroAtivo se true, apenas o ativo
	 * @return
	 * @throws RegistroDesconhecidoException
	 */
	public DwRap findDwRapByCdRap(String cdRap, boolean isFiltroAtivo) throws RegistroDesconhecidoException{
		Validate.notBlank(cdRap, "cdRap");
		return this.getDao().findByCd(DwRap.class, cdRap, DwRapTemplate._FIELD_NAME_CD, isFiltroAtivo);
	}

	public DwRap salvarDesativandoOriginal(DwRap dwRapDB, DwRap dwRap, Date dateOperacao, OmUsr omUsrOperacao) {
		return this.getDao().salvarDesativandoOriginal(dwRapDB, dwRap, dateOperacao, omUsrOperacao);
	}

	public PpCliente salvarDesativandoOriginal(PpCliente ppClienteDB, PpCliente ppCliente, Date dateOperacao, OmUsr omUsrOperacao) {
		return this.getDao().salvarDesativandoOriginal(ppClienteDB, ppCliente, dateOperacao, omUsrOperacao);
	}

	public PpCliente salvarDesativandoOriginal(PpCliente ppCliente, Date dateOperacao, OmUsr omUsrOperacao) {
		return this.getDao().salvarDesativandoOriginal(ppCliente, dateOperacao, omUsrOperacao);
	}

	public PpCp salvarDesativandoOriginal(PpCp ppCp, Date dateOperacao, OmUsr omUsrOperacao) {
		return this.getDao().salvarDesativandoOriginal(ppCp, dateOperacao, omUsrOperacao);
	}

}
