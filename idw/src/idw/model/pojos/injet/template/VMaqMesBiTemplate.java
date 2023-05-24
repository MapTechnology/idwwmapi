package idw.model.pojos.injet.template;

import java.math.BigDecimal;

import idw.model.pojos.injet.VMaqDataBi;

public abstract class VMaqMesBiTemplate {

	public abstract String getDsMaquina();
	public abstract String getDsTurno();
	public abstract BigDecimal getSegTempoativo();
	public abstract BigDecimal getSegTempoparada();
	public abstract BigDecimal getSegTempoparadaSp();
	public abstract BigDecimal getSegCicloprodutivo();
	public abstract BigDecimal getSegCicloimprodutivo();
	public abstract BigDecimal getSegTempotrabalhado();
	public abstract BigDecimal getSegTemporefugadas();
	public abstract BigDecimal getSegRitmo();
	public abstract BigDecimal getSegTempoprodutivas();
	public abstract BigDecimal getSegTempodisponivel();
	public abstract BigDecimal getSegPerdaciclo();
	public abstract BigDecimal getSegCiclomedio();
	public abstract BigDecimal getSegCiclopadrao();
	public abstract Long getPcsPerdaparada();
	public abstract Long getPcsPerdaparadaSp();
	public abstract BigDecimal getPcsPerdaciclo();
	public abstract Long getPcsPerdacavidades();
	public abstract Long getPcsProducaobruta();
	public abstract Long getPcsProducaorefugada();
	public abstract Long getPcsProducaoprevista();

	public abstract BigDecimal getSegPerdacav();
	public abstract BigDecimal getSegCtt();
	public abstract BigDecimal getSegBoas();
	
	public abstract void setDsMaquina(String valor);
	public abstract void setDsTurno(String valor);
	public abstract void setSegTempoativo(BigDecimal valor);
	public abstract void setSegTempoparada(BigDecimal valor);
	public abstract void setSegTempoparadaSp(BigDecimal valor);
	public abstract void setSegCicloprodutivo(BigDecimal valor);
	public abstract void setSegCicloimprodutivo(BigDecimal valor);
	public abstract void setSegTempotrabalhado(BigDecimal valor);
	public abstract void setSegTemporefugadas(BigDecimal valor);
	public abstract void setSegRitmo(BigDecimal valor);
	public abstract void setSegTempoprodutivas(BigDecimal valor);
	public abstract void setSegTempodisponivel(BigDecimal valor);
	public abstract void setSegPerdaciclo(BigDecimal valor);
	public abstract void setSegCiclomedio(BigDecimal valor);
	public abstract void setSegCiclopadrao(BigDecimal valor);
	public abstract void setPcsPerdaparada(Long valor);
	public abstract void setPcsPerdaparadaSp(Long valor);
	public abstract void setPcsPerdaciclo(BigDecimal valor);
	public abstract void setPcsPerdacavidades(Long valor);
	public abstract void setPcsProducaobruta(Long valor);
	public abstract void setPcsProducaorefugada(Long valor);
	public abstract void setPcsProducaoprevista(Long valor);

	public abstract void setSegPerdacav(BigDecimal valor);
	public abstract void setSegCtt(BigDecimal valor);
	public abstract void setSegBoas(BigDecimal valor);

	public void addVMaqDataBi(VMaqDataBi vmaqdatabi){
		setDsMaquina(vmaqdatabi.getDsMaquina());
		setDsTurno(vmaqdatabi.getDsTurno());

		setSegTempoativo(getSegTempoativo().add(vmaqdatabi.getSegTempoativo()));
		setSegTempoparada(getSegTempoparada().add(vmaqdatabi.getSegTempoparada()));
		setSegTempoparadaSp(getSegTempoparadaSp().add(vmaqdatabi.getSegTempoparadaSp()));
		setSegCicloprodutivo(getSegCicloprodutivo().add(vmaqdatabi.getSegCicloprodutivo()));
		setSegCicloimprodutivo(getSegCicloimprodutivo().add(vmaqdatabi.getSegCicloimprodutivo()));
		setSegTempotrabalhado(getSegTempotrabalhado().add(vmaqdatabi.getSegTempotrabalhado()));
		setSegTemporefugadas(getSegTemporefugadas().add(vmaqdatabi.getSegTemporefugadas()));
		setSegRitmo(getSegRitmo().add(vmaqdatabi.getSegRitmo()));
		setSegTempoprodutivas(getSegTempoprodutivas().add(vmaqdatabi.getSegTempoprodutivas()));
		setSegTempodisponivel(getSegTempodisponivel().add(vmaqdatabi.getSegTempodisponivel()));
		setSegPerdaciclo(getSegPerdaciclo().add(vmaqdatabi.getSegPerdaciclo()));
		setSegCiclomedio(getSegCiclomedio().add(vmaqdatabi.getSegCiclomedio()));
		if (vmaqdatabi.getSegCiclopadrao() == null)
			vmaqdatabi.setSegCiclopadrao(new BigDecimal(0));
		setSegCiclopadrao(getSegCiclopadrao().add(vmaqdatabi.getSegCiclopadrao()));
		setPcsPerdaparada(getPcsPerdaparada() + vmaqdatabi.getPcsPerdaparada());
		setPcsPerdaparadaSp(getPcsPerdaparadaSp() + vmaqdatabi.getPcsPerdaparadaSp());
		if (vmaqdatabi.getPcsPerdaciclo() != null)
			setPcsPerdaciclo(getPcsPerdaciclo().add(vmaqdatabi.getPcsPerdaciclo()));
		setPcsPerdacavidades(getPcsPerdacavidades() + vmaqdatabi.getPcsPerdacavidades());
		setPcsProducaobruta(getPcsProducaobruta() + vmaqdatabi.getPcsProducaobruta());
		setPcsProducaorefugada(getPcsProducaorefugada() + vmaqdatabi.getPcsProducaorefugada());
		setPcsProducaoprevista(getPcsProducaoprevista() + vmaqdatabi.getPcsProducaoprevista());

		if (vmaqdatabi.getSegPerdacav() == null)
			vmaqdatabi.setSegPerdacav(new BigDecimal(0));
		if (getSegPerdacav()==null)
			setSegPerdacav(new BigDecimal(0));
		setSegPerdacav(getSegPerdacav().add(vmaqdatabi.getSegPerdacav()));
		
		if (vmaqdatabi.getSegCtt() == null)
			vmaqdatabi.setSegCtt(new BigDecimal(0));
		if (getSegCtt()==null)
			setSegCtt(new BigDecimal(0));
		setSegCtt(getSegCtt().add(vmaqdatabi.getSegCtt()));

		if (vmaqdatabi.getSegBoas() == null)
			vmaqdatabi.setSegBoas(new BigDecimal(0));
		if (getSegBoas()==null)
			setSegBoas(new BigDecimal(0));
		setSegBoas(getSegBoas().add(vmaqdatabi.getSegBoas()));
	}
}