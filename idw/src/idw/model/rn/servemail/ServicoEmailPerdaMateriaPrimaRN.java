package idw.model.rn.servemail;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.DwConsolid;
import idw.model.pojos.MsTrigger;
import idw.model.pojos.OmMapa;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.template.MsTpevtTemplate.Type;
import idw.util.Email;
import idw.util.IdwLogger;

public class ServicoEmailPerdaMateriaPrimaRN extends ServicoEmailFactory {
	
	private OmMapa mapa;
	private String cdFeeder;
	private String nRop;


	public ServicoEmailPerdaMateriaPrimaRN(IdwLogger log, int idLog, int identacao, Session session) {
		super(log, idLog, identacao, session);
	}

	@Override
	public void tratarEnviarEmail(DwConsolid dwConsolid, MsTrigger msTrigger, OmPt ompt, List<OmUsr> listOmUsr) {

		List<String> destinatarios = new ArrayList<String>();
		for(OmUsr usuario : listOmUsr){
			if(usuario.getUrlEmail() != null && !usuario.getUrlEmail().equals("")){
				destinatarios.add(usuario.getUrlEmail());
			}
		}
		
		StringBuilder assuntoEmail = new StringBuilder();
		StringBuilder mensagemEmail = new StringBuilder();
		
		assuntoEmail.append("Feeder ");
		assuntoEmail.append(cdFeeder);
		if (mapa != null){
			assuntoEmail.append(" no mapa ");
			assuntoEmail.append(mapa.getCdMapa());
		} else {
			assuntoEmail.append("' n�o está ativo na máquina ou no mapa correspondente.");
		}
		
		mensagemEmail.append("O feeder ");
		mensagemEmail.append(cdFeeder);
		if(mapa != null){
			mensagemEmail.append(" para a máquina: ");
			mensagemEmail.append(mapa.getOmPt().getCdPt());
			mensagemEmail.append(", n�o está ativo no mapa ");
			mensagemEmail.append(mapa.getCdMapa()); 
		}else {
			mensagemEmail.append(" n�o está ativo na máquina "+ompt.getCdPt()+" ou no mapa ");
			mensagemEmail.append(nRop);
			mensagemEmail.append(".");
		}
		
		Email email = new Email(this.log, this.idLog, this.identacao, destinatarios, assuntoEmail.toString(), mensagemEmail.toString());
//		email.start(); alessandre desativevi rever futuramente
		
	}

	@Override
	protected Type getType() {
		return Type.PERDA_MATERIA_PRIMA;
	}

	@Override
	protected String complementoAssuntoEmail(DwConsolid dwConsolid) {
		return null;
	}

	@Override
	protected String complementoMensagemEmail(DwConsolid dwConsolid) {
		return null;
	}
	
	public void setMapa(OmMapa mapa) {
		this.mapa = mapa;
	}
	
	public void setCdFeeder(String cdFeeder) {
		this.cdFeeder = cdFeeder;
	}
	
	public void setnRop(String nRop) {
		this.nRop = nRop;
	}

}
