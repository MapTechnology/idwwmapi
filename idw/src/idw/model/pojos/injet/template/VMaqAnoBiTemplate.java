package idw.model.pojos.injet.template;

import java.math.BigDecimal;

import idw.model.pojos.injet.VMaqMesBi;


public abstract class VMaqAnoBiTemplate {

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

	
	public void addVMaqMesBi(VMaqMesBi vmaqmesbi){
		setDsMaquina(vmaqmesbi.getDsMaquina());
		setDsTurno(vmaqmesbi.getDsTurno());

		setSegTempoativo(getSegTempoativo().add(vmaqmesbi.getSegTempoativo()));
		setSegTempoparada(getSegTempoparada().add(vmaqmesbi.getSegTempoparada()));
		setSegTempoparadaSp(getSegTempoparadaSp().add(vmaqmesbi.getSegTempoparadaSp()));
		setSegCicloprodutivo(getSegCicloprodutivo().add(vmaqmesbi.getSegCicloprodutivo()));
		setSegCicloimprodutivo(getSegCicloimprodutivo().add(vmaqmesbi.getSegCicloimprodutivo()));
		setSegTempotrabalhado(getSegTempotrabalhado().add(vmaqmesbi.getSegTempotrabalhado()));
		setSegTemporefugadas(getSegTemporefugadas().add(vmaqmesbi.getSegTemporefugadas()));
		setSegRitmo(getSegRitmo().add(vmaqmesbi.getSegRitmo()));
		setSegTempoprodutivas(getSegTempoprodutivas().add(vmaqmesbi.getSegTempoprodutivas()));
		setSegTempodisponivel(getSegTempodisponivel().add(vmaqmesbi.getSegTempodisponivel()));
		setSegPerdaciclo(getSegPerdaciclo().add(vmaqmesbi.getSegPerdaciclo()));
		setSegCiclomedio(getSegCiclomedio().add(vmaqmesbi.getSegCiclomedio()));
		if (vmaqmesbi.getSegCiclopadrao() == null)
			vmaqmesbi.setSegCiclopadrao(new BigDecimal(0));
		setSegCiclopadrao(getSegCiclopadrao().add(vmaqmesbi.getSegCiclopadrao()));
		setPcsPerdaparada(getPcsPerdaparada() + vmaqmesbi.getPcsPerdaparada());
		setPcsPerdaparadaSp(getPcsPerdaparadaSp() + vmaqmesbi.getPcsPerdaparadaSp());
		if (vmaqmesbi.getPcsPerdaciclo() != null)
			setPcsPerdaciclo(getPcsPerdaciclo().add(vmaqmesbi.getPcsPerdaciclo()));
		setPcsPerdacavidades(getPcsPerdacavidades() + vmaqmesbi.getPcsPerdacavidades());
		setPcsProducaobruta(getPcsProducaobruta() + vmaqmesbi.getPcsProducaobruta());
		setPcsProducaorefugada(getPcsProducaorefugada() + vmaqmesbi.getPcsProducaorefugada());
		setPcsProducaoprevista(getPcsProducaoprevista() + vmaqmesbi.getPcsProducaoprevista());

		if (vmaqmesbi.getSegPerdacav() == null)
			vmaqmesbi.setSegPerdacav(new BigDecimal(0));
		if (getSegPerdacav()==null)
			setSegPerdacav(new BigDecimal(0));
		setSegPerdacav(getSegPerdacav().add(vmaqmesbi.getSegPerdacav()));
		
		if (vmaqmesbi.getSegCtt() == null)
			vmaqmesbi.setSegCtt(new BigDecimal(0));
		if (getSegCtt()==null)
			setSegCtt(new BigDecimal(0));
		setSegCtt(getSegCtt().add(vmaqmesbi.getSegCtt()));

		if (vmaqmesbi.getSegBoas() == null)
			vmaqmesbi.setSegBoas(new BigDecimal(0));
		if (getSegBoas()==null)
			setSegBoas(new BigDecimal(0));
		setSegBoas(getSegBoas().add(vmaqmesbi.getSegBoas()));

	}
}
