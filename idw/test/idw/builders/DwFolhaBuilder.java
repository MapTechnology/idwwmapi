package idw.builders;

import idw.model.dao.DAOGenericoTest;
import idw.model.pojos.DwFolha;

import java.util.Date;

public class DwFolhaBuilder extends AbstractPojoPersistentBuilder<DwFolha, DAOGenericoTest> {

	private String cdFolha = BuilderDefaults.CODIGO;
	private String dsFolha = BuilderDefaults.DESCRICAO;
	private Date dtStAtivo = BuilderDefaults.DATE;
	private Date dtRevisao = BuilderDefaults.DATE;
	private Byte stAtivo = BuilderDefaults.ST_ATIVO;
	private Long revisao = BuilderDefaults.REVISAO;
	
	public DwFolhaBuilder withCdFolha(String cdFolha){
		this.cdFolha = cdFolha;
		return this;
	}
	
	public DwFolhaBuilder withDsFolha(String dsFolha){
		this.dsFolha = dsFolha;
		return this;
	}
	
	public DwFolhaBuilder withDtStAtivo(Date dtStAtivo){
		this.dtStAtivo = dtStAtivo;
		return this;
	}
	
	public DwFolhaBuilder withDtRevisao(Date dtRevisao){
		this.dtRevisao = dtRevisao;
		return this;
	}
	
	public DwFolhaBuilder withStAtivo(Byte stAtivo){
		this.stAtivo = stAtivo;
		return this;
	}
	
	public DwFolhaBuilder withRevisao(Long revisao){
		this.revisao = revisao;
		return this;
	}
	
	@Override
	public DwFolha build(){
		DwFolha dwFolha = new DwFolha();
		dwFolha.setCdFolha(cdFolha);
		dwFolha.setDsFolha(dsFolha);
		dwFolha.setDtStativo(dtStAtivo);
		dwFolha.setDtRevisao(dtRevisao);
		dwFolha.setStAtivo(stAtivo);
		dwFolha.setRevisao(revisao);
		return dwFolha;
	}
	
}