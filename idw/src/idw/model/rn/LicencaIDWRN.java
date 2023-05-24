package idw.model.rn;

import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.excessoes.CriptografiaException;
import idw.model.pojos.OmEmpresa;
import idw.model.pojos.OmLicenca;
import idw.model.pojos.OmLicmodrec;
import idw.util.CriptografiaRSA;
import idw.util.UtilsString;
import idw.webservices.dto.LicencaIDWDTO;

public class LicencaIDWRN extends AbstractRN<DAOGenerico> {

	public enum IdCamposEmpresa{
		CD_EMPRESA(0),
		DS_EMPRESA(1),
		ENDERECO(2),
		CIDADE(3),
		ESTADO(4),
		PAIS(5);
		private final int value;
		private IdCamposEmpresa(int value){
			this.value = value;
		}
		public int getValue(){
			return this.value;
		}
	}
	public enum IdCamposLicenca{
		ID_LICENCA(0),
		ID_EMPRESA(1),
		CD_EMPRESA(2),
		DOCUMENTO(3),
		DT_EMISSA(4),
		DT_VALIDADE(5),
		IS_TRYOUT(6),
		QT_LICENCA(7),
		ID_TPLICENCA(8);
		private final int value;
		private IdCamposLicenca(int value){
			this.value = value;
		}
		public int getValue(){
			return this.value;
		}
	}

	public LicencaIDWRN() {
		super(new DAOGenerico());
	}
	
	public LicencaIDWRN(DAOGenerico dao) {
		super(dao);
	}

	/*
	 * Metodo que informa se existe ou nao licenca
	 */
	public LicencaIDWDTO isLecenciado(LicencaIDWDTO dto) {
		LicencaIDWDTO retorno = dto;

		// Descomentar as linhas abaixo para remover o licenciamento
		retorno.setIsLicenciado(true);
		if (retorno.getIsLicenciado())
			return retorno;
		
		MapQuery q = new MapQuery(getDaoSession());
		
		q.append("select a");
		q.append("from OmEmpresa a");
		q.append("join a.omLicencas b");
		q.append("join b.omLicmodrecs c");
		q.append("join c.omModuloRecurso d");
		q.append("where a.idEmpresa = :idempresa");
		q.append("and d.idModuloRecurso = :idmodulo");
		q.append("and (b.dtValidade is null or (b.dtValidade is not null and b.dtValidade >= :dt) )");
		
		q.defineParametro("idempresa", dto.getIdEmpresa());
		q.defineParametro("idmodulo", dto.getIdModulo());
		q.defineParametroData("dt", DataHoraRN.getDataHoraAtual());
		
		List<OmEmpresa> lista = q.list();
		
		if (lista == null || lista.size() <= 0) {
			retorno.setIsLicenciado(false);
		}
		
		CriptografiaRSA rsa = new CriptografiaRSA();
		// Avaliar o retorno para pegar as chaves e validar se eh legitima
		for (OmEmpresa omempresa : lista) {
			// Valida se a chave da empresa eh valida
			String empresaDescriptografada;
			
			try {
				empresaDescriptografada =  rsa.descriptografar(omempresa.getChaveVerificacao());
			} catch (CriptografiaException e) {
				continue;
			}
			List<String> campoEmpresa = UtilsString.quebrarStringEmVetor(empresaDescriptografada, "|");
			// Avaliar se o cadastro da empresa esta integro
			if (
					omempresa.getCdEmpresa().equals(campoEmpresa.get(IdCamposEmpresa.CD_EMPRESA.getValue())) == false ||
					omempresa.getDsEmpresa().equals(campoEmpresa.get(IdCamposEmpresa.DS_EMPRESA.getValue())) == false ||
					omempresa.getEndereco().equals(campoEmpresa.get(IdCamposEmpresa.ENDERECO.getValue())) == false ||
					omempresa.getCidade().equals(campoEmpresa.get(IdCamposEmpresa.CIDADE.getValue())) == false ||
					omempresa.getEstado().equals(campoEmpresa.get(IdCamposEmpresa.ESTADO.getValue())) == false ||
					omempresa.getPais().equals(campoEmpresa.get(IdCamposEmpresa.PAIS.getValue())) == false
					) {
				retorno.setIsLicenciado(false);
				break; // sai para retornar falta de licenca
			}
			// Verifica se existe licenca valida para o modulo desejado
			for (OmLicenca omlicenca : omempresa.getOmLicencas()) {
				
				// Verifica se a licenca é valida para a empresa
				String licencaDescriptografada;
				try {
					licencaDescriptografada =  rsa.descriptografar(omlicenca.getChaveVerificacao());
				} catch (CriptografiaException e) {
					continue;
				}
				List<String> campoLicenca = UtilsString.quebrarStringEmVetor(licencaDescriptografada, "|");
				
				String dtEmissao = DataHoraRN.dateToStringYYYYMMDDHHMMSS(omlicenca.getDtEmissao());
				String dtValidade = DataHoraRN.dateToStringYYYYMMDDHHMMSS(omlicenca.getDtValidade());
				
				// Avalia se o cadastro está integro conforme a chave criptografada
				if (
						omlicenca.getIdLicenca().equals(Long.parseLong(campoLicenca.get(IdCamposLicenca.ID_LICENCA.getValue()))) == false ||
						omlicenca.getOmEmpresa().getIdEmpresa().equals(Long.parseLong(campoLicenca.get(IdCamposLicenca.ID_EMPRESA.getValue()))) == false ||
						campoEmpresa.get(IdCamposEmpresa.CD_EMPRESA.getValue()).equals(campoLicenca.get(IdCamposLicenca.CD_EMPRESA.getValue())) == false ||
						omlicenca.getDocumento().equals(campoLicenca.get(IdCamposLicenca.DOCUMENTO.getValue())) == false ||
						dtEmissao.equals(campoLicenca.get(IdCamposLicenca.DT_EMISSA.getValue())) == false ||
						dtValidade.equals(campoLicenca.get(IdCamposLicenca.DT_VALIDADE.getValue())) == false ||
						omlicenca.getIsTryout().equals(campoLicenca.get(IdCamposLicenca.IS_TRYOUT.getValue()).equals("1") ? true : false) == false ||
						omlicenca.getQtLicencas().equals(Integer.parseInt(campoLicenca.get(IdCamposLicenca.QT_LICENCA.getValue()))) == false ||
						omlicenca.getOmTplicenca().getIdTplicenca().equals(Long.parseLong(campoLicenca.get(IdCamposLicenca.ID_TPLICENCA.getValue()))) == false) {

					retorno.setIsLicenciado(false);
					break;
				}
				
				// Avalia se o recurso existe na lista dos licenciamentos
				for (OmLicmodrec licmodrec : omlicenca.getOmLicmodrecs()) {
					if (licmodrec.getOmLicenca().getIdLicenca().equals(retorno.getIdModulo())) {
						retorno.setIsLicenciado(true);
					}
				}
				
				// Se estiver licenciado verificar se a licenca esta no prazo de validade
				if (retorno.getIsLicenciado() && omlicenca.getDtValidade() != null && DataHoraRN.before(omlicenca.getDtValidade(), DataHoraRN.getDataHoraAtual())) {
					retorno.setIsLicenciado(false);
				}
			}
		}
		return retorno;
	}
	
	public static void main(String[] args) {
		LicencaIDWRN rn = new LicencaIDWRN();
		
		rn.iniciaConexaoBanco();
		LicencaIDWDTO dto = new LicencaIDWDTO();
		dto.setIdEmpresa(1l);
		dto.setIdModulo(1l);
		dto = rn.isLecenciado(dto);
		System.out.println("Licenciado = " + dto.getIsLicenciado());
		
		rn.finalizaConexaoBanco();
	}
}
