package idw.model.pojos.template;

import java.math.BigDecimal;

import idw.model.pojos.DwEst;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwRota;
import idw.model.pojos.DwRotapasso;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmImg;
import idw.model.pojos.OmObj;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmTexto;
import idw.model.pojos.OmWebcam;

public abstract class OmObjTemplate extends AbstractTemplate<OmObj> {

	public enum TpObj{
		TIPO_OBJ_PT((byte)0),
		TIPO_OBJ_GT((byte)1),
		TIPO_OBJ_RETANGULO((byte)2),
		TIPO_EMPURRADA((byte) 3),
        TIPO_INFO_MANUAL((byte) 4),
        TIPO_INFO_ELETRO((byte) 5),
        TIPO_EXTERNO_MATERIAL((byte) 6),
		TIPO_OBJ_TEXTO((byte)7),
		TIPO_OBJ_FOLHA((byte)8),
		TIPO_OBJ_ESTOQUE((byte)9),
		TIPO_OBJ_IMAGEM((byte)10),
		TIPO_KANBAN((byte)11);
		private final byte value;
		private TpObj(byte value){
			this.value = value;
		}
		public byte getValue(){
			return this.value;
		}

		public boolean equals(Byte value){
			return new Byte(this.value).equals(value);
		}		
	}

	//Tipo do objeto
	private  byte TIPO_OBJ_PT = 0;
	private  byte TIPO_OBJ_GT = 1;
	private  byte TIPO_OBJ_RETANGULO = 2;
	private  byte TIPO_OBJ_CIRCULO = 3;
	private  byte TIPO_OBJ_RETA_SETA_1 = 4;
	private  byte TIPO_OBJ_RETA_SETA_2 = 5;
	private  byte TIPO_OBJ_RETA_SETA_1_2 = 6;
	private  byte TIPO_OBJ_TEXTO = 7;
	private  byte TIPO_OBJ_FOLHA = 8;
	private  byte TIPO_OBJ_ESTOQUE = 9;
	private  byte TIPO_OBJ_IMAGEM = 10; // eh 10 mesmo?
	
	
	@Override
	/**
	 * N�o far� o clone dos objetos FK por padr�o
	 */
	public OmObj clone() {
		
		return clone(false);
	}

	@Override
	protected OmObj atribuir(OmObj from, OmObj to, boolean isCopiarFK) {
		if(to == null){
			to = new OmObj();
		}
		
		to.setIdObj(from.getIdObj());
		to.setCorFrente(from.getCorFrente());
		to.setCorFundo(from.getCorFundo());
		
		if(from.getTpObj() != null){
			to.setTpObj(new Byte(from.getTpObj().byteValue()));
		// se o tipo do objeto n�o estiver preenchido, tenta descrobrir
		}else {
			if(from.getOmPt() != null){
				to.setTpObj(new Byte(TIPO_OBJ_PT));
			} else if(from.getOmGtByIdGtfilho() != null){
				to.setTpObj(new Byte(TIPO_OBJ_GT));
			}
		}
		
		if(from.getX() != null){
			to.setX(new BigDecimal(from.getX().doubleValue()));
		}

		if(from.getX2() != null){
			to.setX2(new BigDecimal(from.getX2().doubleValue()));
		}

		if(from.getY() != null){
			to.setY(new BigDecimal(from.getY().doubleValue()));
		}

		if(from.getY2() != null){
			to.setY2(new BigDecimal(from.getY2().doubleValue()));
		}
		
		if(from.getTpObj() != null){
			to.setTpObj(from.getTpObj());	
		}
		
		
		if(from.getOmGtByIdGt() != null){
			OmGt omGtByIdGt = null;
			if(isCopiarFK){
				omGtByIdGt = from.getOmGtByIdGt().clone(false);
								
			} else {
				omGtByIdGt = new OmGt();
				omGtByIdGt.setIdGt(from.getOmGtByIdGt().getIdGt());
			}
			to.setOmGtByIdGt(omGtByIdGt);
		}
	
		if(from.getOmGtByIdGtfilho() != null){
			OmGt omGtByIdGtfilho = null;
			if(isCopiarFK){
				omGtByIdGtfilho = from.getOmGtByIdGtfilho().clone(false);
			} else {
				omGtByIdGtfilho = new OmGt();
				omGtByIdGtfilho.setIdGt(from.getOmGtByIdGtfilho().getIdGt());
			}
			to.setOmGtByIdGtfilho(omGtByIdGtfilho);
		}
		
		if(from.getOmImg() != null){
			OmImg omImg = null;
			if(isCopiarFK){
				omImg = from.getOmImg().clone(false);
			} else {
				omImg = new OmImg();
				omImg.setIdImg(from.getOmImg().getIdImg());
				//MADS: NIDW
				omImg.setCdImg(from.getOmImg().getCdImg());
				omImg.setDsImg(from.getOmImg().getDsImg());
			}
			to.setOmImg(omImg);
		}
		
		if(from.getOmPt() != null){	
			OmPt omPt = null;
			if(isCopiarFK){
				omPt = from.getOmPt().clone(false);	
			} else {
				omPt = new OmPt();
				omPt.setIdPt(from.getOmPt().getIdPt());
				omPt.setCdPt(from.getOmPt().getCdPt());
			}
			to.setOmPt(omPt);			
		}
		
		if(from.getOmWebcam() != null){
			OmWebcam omWebcam = null;
			if(isCopiarFK){
				omWebcam = (OmWebcam) from.getOmWebcam().clone(false);
			} else {
				omWebcam = new OmWebcam();
				omWebcam.setIdWebcam(from.getOmWebcam().getIdWebcam());				
			}
							
			to.setOmWebcam(omWebcam);
		}

		if(from.getOmTexto() != null){
			OmTexto omTexto = null;
			if(isCopiarFK){
				omTexto = (OmTexto) from.getOmTexto().clone(false);
			} else {
				omTexto = new OmTexto();
				omTexto.setIdTexto(from.getOmTexto().getIdTexto());
			}
			to.setOmTexto(omTexto);
		}
		
		if(from.getDwEstByIdEst() != null){
			DwEst dwest = null;
			if(isCopiarFK){
				dwest = (DwEst) from.getDwEstByIdEst().clone(false);
			}else{
				dwest = new DwEst();
				dwest.setIdEst(from.getDwEstByIdEst().getIdEst());
			}
			to.setDwEstByIdEst(dwest);
		}
		
		if(from.getDwFolhaByIdFolha() != null){
			DwFolha dwfolha = null;
			if(isCopiarFK){
				dwfolha = (DwFolha) from.getDwFolhaByIdFolha().clone(false);
			}else{
				dwfolha= new DwFolha();
				dwfolha.setIdFolha(from.getDwFolhaByIdFolha().getIdFolha());
			}
			to.setDwFolhaByIdFolha(dwfolha);
		}
		
		if(from.getDwRotaByIdRota() != null){
			DwRota dwrota = null;
			if(isCopiarFK){
				dwrota = (DwRota) from.getDwRotaByIdRota().clone(false);
			}else{
				dwrota = new DwRota();
				dwrota.setIdRota(from.getDwRotaByIdRota().getIdRota());
			}
			to.setDwRotaByIdRota(dwrota);
		}
		
		if(from.getDwRotapasso() != null){
			DwRotapasso dwrotapasso = null;
			if(isCopiarFK){
				dwrotapasso = (DwRotapasso) from.getDwRotapasso().clone(false);
			}else{
				dwrotapasso = new DwRotapasso();
				dwrotapasso.setIdRotapasso(from.getDwRotapasso().getIdRotapasso());
			}
			to.setDwRotapasso(dwrotapasso);
		}

		return to;
	}

	public byte getTIPO_OBJ_PT() {
		return TIPO_OBJ_PT;
	}

	public void setTIPO_OBJ_PT(byte tIPO_OBJ_PT) {
		TIPO_OBJ_PT = tIPO_OBJ_PT;
	}

	public byte getTIPO_OBJ_GT() {
		return TIPO_OBJ_GT;
	}

	public void setTIPO_OBJ_GT(byte tIPO_OBJ_GT) {
		TIPO_OBJ_GT = tIPO_OBJ_GT;
	}

	public byte getTIPO_OBJ_RETANGULO() {
		return TIPO_OBJ_RETANGULO;
	}

	public void setTIPO_OBJ_RETANGULO(byte tIPO_OBJ_RETANGULO) {
		TIPO_OBJ_RETANGULO = tIPO_OBJ_RETANGULO;
	}

	public byte getTIPO_OBJ_CIRCULO() {
		return TIPO_OBJ_CIRCULO;
	}

	public void setTIPO_OBJ_CIRCULO(byte tIPO_OBJ_CIRCULO) {
		TIPO_OBJ_CIRCULO = tIPO_OBJ_CIRCULO;
	}

	public byte getTIPO_OBJ_RETA_SETA_1() {
		return TIPO_OBJ_RETA_SETA_1;
	}

	public void setTIPO_OBJ_RETA_SETA_1(byte tIPO_OBJ_RETA_SETA_1) {
		TIPO_OBJ_RETA_SETA_1 = tIPO_OBJ_RETA_SETA_1;
	}

	public byte getTIPO_OBJ_RETA_SETA_2() {
		return TIPO_OBJ_RETA_SETA_2;
	}

	public void setTIPO_OBJ_RETA_SETA_2(byte tIPO_OBJ_RETA_SETA_2) {
		TIPO_OBJ_RETA_SETA_2 = tIPO_OBJ_RETA_SETA_2;
	}

	public byte getTIPO_OBJ_RETA_SETA_1_2() {
		return TIPO_OBJ_RETA_SETA_1_2;
	}

	public void setTIPO_OBJ_RETA_SETA_1_2(byte tIPO_OBJ_RETA_SETA_1_2) {
		TIPO_OBJ_RETA_SETA_1_2 = tIPO_OBJ_RETA_SETA_1_2;
	}

	public byte getTIPO_OBJ_TEXTO() {
		return TIPO_OBJ_TEXTO;
	}

	public void setTIPO_OBJ_TEXTO(byte tIPO_OBJ_TEXTO) {
		TIPO_OBJ_TEXTO = tIPO_OBJ_TEXTO;
	}

	public byte getTIPO_OBJ_FOLHA() {
		return TIPO_OBJ_FOLHA;
	}

	public void setTIPO_OBJ_FOLHA(byte tIPO_OBJ_FOLHA) {
		TIPO_OBJ_FOLHA = tIPO_OBJ_FOLHA;
	}

	public byte getTIPO_OBJ_ESTOQUE() {
		return TIPO_OBJ_ESTOQUE;
	}

	public void setTIPO_OBJ_ESTOQUE(byte tIPO_OBJ_ESTOQUE) {
		TIPO_OBJ_ESTOQUE = tIPO_OBJ_ESTOQUE;
	}

	public byte getTIPO_OBJ_IMAGEM() {
		return TIPO_OBJ_IMAGEM;
	}

	public void setTIPO_OBJ_IMAGEM(byte tIPO_OBJ_IMAGEM) {
		TIPO_OBJ_IMAGEM = tIPO_OBJ_IMAGEM;
	}
}
