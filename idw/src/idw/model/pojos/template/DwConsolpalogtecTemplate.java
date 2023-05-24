package idw.model.pojos.template;

import idw.model.pojos.DwConsolpalogtec;

public abstract class DwConsolpalogtecTemplate extends AbstractTemplate<DwConsolpalogtec> {

	public enum _TpUsuario {
		TEC1((byte)1),
		TEC2((byte)2),
		TECRESP((byte)3);
		
		private final byte tpUsuario;
		
		private _TpUsuario(byte valor) {
			this.tpUsuario = valor;
		}
		
		public byte getValue() {
			return this.tpUsuario;
		}
		
	}
	@Override
	protected DwConsolpalogtec atribuir(DwConsolpalogtec from, DwConsolpalogtec to, boolean isCopiarFK) {
		
		if(to == null){
			to = new DwConsolpalogtec();
		}
		to.setIdConsolpalogtec(from.getIdConsolpalogtec());

		if(isCopiarFK){
			if (from.getOmUsr() != null)
				to.setOmUsr(from.getOmUsr().clone(false));
		}
		
		return to;
		
	}
}