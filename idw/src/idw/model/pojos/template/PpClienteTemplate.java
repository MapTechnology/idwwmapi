package idw.model.pojos.template;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import idw.model.IPojoMAP;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpCliente;
import idw.util.CloneUtil;
import idw.util.EqualsBuilderIdw;
import idw.util.HashCodeBuilderIdw;

public abstract class PpClienteTemplate extends AbstractTemplate<PpCliente> implements IPojoMAP{
	public static final String _FIELD_NAME_CD = "CdCliente";

	private static final int _MAX_LEN_CD_CLIENTE = 30;
	private static final int _MAX_LEN_NM_CLIENTE = 253;

	public enum TpCliente{
		PESSOA_JURIDICA(0), PESSOA_FISICA(1);
		private int value;
		TpCliente(int value){
			this.value = value;
		}
		public int getValue(){
			return this.value;
		}
	}

	
	@Override
	public Long getId() {		
		return getInstanceT().getIdCliente();
	}
	
	@Override
	public void setId(Long id) {
		getInstanceT().setIdCliente(id);
	}	
	
	@Override
	public String getCd() {
		return ((PpCliente) this).getCdCliente();
	}

	@Override
	public String getFieldNameCd() {
		return PpClienteTemplate._FIELD_NAME_CD;
	}

	@Override
	public boolean equals(Object o){
		boolean equals = false;
		if((o != null) && this.getClass().isAssignableFrom(o.getClass())){
			final PpCliente ppClienteOther = (PpCliente) o;
			final PpCliente ppCliente = (PpCliente) this;
			equals = (new EqualsBuilderIdw())
						.append(ppCliente.getCdCliente(), ppClienteOther.getCdCliente())
						.append(ppCliente.getCidade(), ppClienteOther.getCidade())
						.append(ppCliente.getCnpjCpf(), ppClienteOther.getCnpjCpf())
						.append(ppCliente.getContato(), ppClienteOther.getContato())
						.append(ppCliente.getDepara(), ppClienteOther.getDepara())
						.append(ppCliente.getEndereco(), ppClienteOther.getEndereco())
						.append(ppCliente.getEstado(), ppClienteOther.getEstado())
						.append(ppCliente.getHrLeadtime(), ppClienteOther.getHrLeadtime())
						.append(ppCliente.getNmCliente(), ppClienteOther.getNmCliente())
						.append(ppCliente.getPais(), ppClienteOther.getPais())
						.append(ppCliente.getTelefonedois(), ppClienteOther.getTelefonedois())
						.append(ppCliente.getTelefonetres(), ppClienteOther.getTelefonetres())
						.append(ppCliente.getTelefoneum(), ppClienteOther.getTelefoneum())
						.append(ppCliente.getTpCliente(), ppClienteOther.getTpCliente())
						.append(ppCliente.getUrlSite(), ppClienteOther.getUrlSite())
						.append(ppCliente.getStAtivo(), ppClienteOther.getStAtivo())
						.isEquals();
		}
		return equals;
	}

	/**
	 * Campos usados no hashCode:
	 *   CdUsr, Login, Senha, DsNome, DsApelido, UrlSms, UrlEmail, OmCc, OmUsrgrp, StAtivo
	 */
	@Override
	public int hashCode(){

		PpCliente ppCliente = (PpCliente) this;

		return (new HashCodeBuilderIdw())
						.append(ppCliente.getCdCliente())
						.append(ppCliente.getCidade())
						.append(ppCliente.getCnpjCpf())
						.append(ppCliente.getContato())
						.append(ppCliente.getDepara())
						.append(ppCliente.getEndereco())
						.append(ppCliente.getEstado())
						.append(ppCliente.getHrLeadtime())
						.append(ppCliente.getNmCliente())
						.append(ppCliente.getPais())
						.append(ppCliente.getTelefonedois())
						.append(ppCliente.getTelefonetres())
						.append(ppCliente.getTelefoneum())
						.append(ppCliente.getTpCliente())
						.append(ppCliente.getUrlSite())
						.append(ppCliente.getStAtivo())
						.toHashCode();
	}

	public void set(Long idCliente, OmUsr omUsrByIdUsrstativo,
			OmUsr omUsrByIdUsrrevisao, String cdCliente, Long revisao,
			Date dtRevisao, Date dtStativo, Byte stAtivo,
			String nmCliente, Integer tpCliente, String cnpjCpf,
			String endereco, String cidade, String estado, String pais,
			String telefoneum, String telefonedois, String telefonetres,
			String contato, BigDecimal hrLeadtime, String urlSite){

		PpCliente ppCliente = (PpCliente) this;

		ppCliente.setIdCliente(idCliente);
		ppCliente.setOmUsrByIdUsrstativo(omUsrByIdUsrstativo);
		ppCliente.setOmUsrByIdUsrrevisao(omUsrByIdUsrrevisao);
		ppCliente.setCdCliente(cdCliente);
		ppCliente.setRevisao(revisao);
		ppCliente.setDtRevisao(dtRevisao);
		ppCliente.setDtStativo(dtStativo);
		ppCliente.setStAtivo(stAtivo);
		ppCliente.setNmCliente(nmCliente);
		ppCliente.setTpCliente(tpCliente);
		ppCliente.setCnpjCpf(cnpjCpf);
		ppCliente.setEndereco(endereco);
		ppCliente.setCidade(cidade);
		ppCliente.setEstado(estado);
		ppCliente.setPais(pais);
		ppCliente.setTelefoneum(telefoneum);
		ppCliente.setTelefonedois(telefonedois);
		ppCliente.setTelefonetres(telefonetres);
		ppCliente.setContato(contato);
		ppCliente.setHrLeadtime(hrLeadtime);
		ppCliente.setUrlSite(urlSite);

	}

	@Override
	protected PpCliente atribuir(PpCliente from, PpCliente to, boolean isCopiarFK) {

		if(to == null){
			to = new PpCliente();
		}

		to.set(
				from.getIdCliente(),
				(isCopiarFK ? CloneUtil.clone(from.getOmUsrByIdUsrstativo(),false) : null),
				(isCopiarFK ? CloneUtil.clone(from.getOmUsrByIdUsrrevisao(),false) : null),
				from.getCdCliente(),
				from.getRevisao(),
				from.getDtRevisao(),
				from.getDtStativo(),
				from.getStAtivo(),
				from.getNmCliente(),
				from.getTpCliente(),
				from.getCnpjCpf(),
				from.getEndereco(),
				from.getCidade(),
				from.getEstado(),
				from.getPais(),
				from.getTelefoneum(),
				from.getTelefonedois(),
				from.getTelefonetres(),
				from.getContato(),
				from.getHrLeadtime(),
				from.getUrlSite());

		return to;
	}

	public void limitarStrings(){
		PpCliente ppCliente = (PpCliente) this;
		ppCliente.setCdCliente(StringUtils.left(ppCliente.getCdCliente(), PpClienteTemplate._MAX_LEN_CD_CLIENTE));
		ppCliente.setNmCliente(StringUtils.left(ppCliente.getNmCliente(), PpClienteTemplate._MAX_LEN_NM_CLIENTE));
	}

}
