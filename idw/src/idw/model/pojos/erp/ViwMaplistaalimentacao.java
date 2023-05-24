package idw.model.pojos.erp;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="viw_maplistaalimentacao")
public class ViwMaplistaalimentacao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ViwMaplistaalimentacaoId id;
	
	
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "nomprograma", column = @Column(name = "nomprograma", nullable = false)),
			@AttributeOverride(name = "numrevisao", column = @Column(name = "numrevisao")),
			@AttributeOverride(name = "datstatus", column = @Column(name = "datstatus", nullable = false)),
			@AttributeOverride(name = "codmodelo", column = @Column(name = "codmodelo", nullable = false)),
			@AttributeOverride(name = "codstatus", column = @Column(name = "codstatus", nullable = false)),
			@AttributeOverride(name = "nommaq", column = @Column(name = "nommaq", nullable = false)),
			@AttributeOverride(name = "coditem", column = @Column(name = "coditem", nullable = false)),
			@AttributeOverride(name = "mesa", column = @Column(name = "mesa", nullable = false)),
			@AttributeOverride(name = "numestacaoz", column = @Column(name = "numestacao", nullable = false)),
			@AttributeOverride(name = "flgleftright", column = @Column(name = "flgleftright")),
			@AttributeOverride(name = "nomprogramaoriginal", column = @Column(name = "nomprogramaoriginal", nullable = false)),
			@AttributeOverride(name = "quantidade", column = @Column(name = "quantidade", nullable = false)),
			@AttributeOverride(name = "desitem", column = @Column(name = "desitem", nullable = false)) })
	
	public ViwMaplistaalimentacaoId getId() {
		return id;
	}
	public void setId(ViwMaplistaalimentacaoId id) {
		this.id = id;
	}
}
