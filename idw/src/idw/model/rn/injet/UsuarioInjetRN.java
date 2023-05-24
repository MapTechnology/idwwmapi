package idw.model.rn.injet;

import java.util.List;

import org.hibernate.Query;

import idw.model.dao.MapQuery;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.excessoes.DigestFileException;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.injet.Ijlogope;
import idw.model.pojos.injet.Ijtbgal;
import idw.model.pojos.injet.Ijtbusu;
import idw.model.rn.AbstractRN;
import idw.model.rn.HashMD5;
import idw.model.rn.injet.dto.MaquinaInjetDTO;
import ms.util.ConversaoTipos;

public class UsuarioInjetRN extends AbstractRN<DAOGenericoInjet> {

	public UsuarioInjetRN(DAOGenericoInjet dao) {
		super(dao);
	}

	public List<Ijtbusu> listaUsuariosAtivos() {

		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("from Ijtbusu ijtbusu ");
		q.appendWhere(MapQuery._NULL, "ijtbusu.cdusuario <> :cdusuario", true);
		q.appendWhere(MapQuery._AND, "ijtbusu.stusuario=:stusuario", true);
		q.defineParametro("cdusuario", "999999");
		q.defineParametro("stusuario", 0);

		return q.list();
	}

	public List<Ijlogope> getOperadoresLogadosAcumulado(MaquinaInjetDTO maquinaDTO) {
		// Obtem lista ijcnsturno do filtro
		String HQL = "";

		HQL += "select ijlogope ";
		HQL += "from Ijlogope ijlogope ";
		HQL += "join fetch ijlogope.ijtbusu ijtbusu ";
		HQL += "where ijlogope.id.cdinjetora = '::cdmaquina' ";
		HQL += "and (ijlogope.nrop = '::nrop' or dthrlogout is null) ";
		HQL += "order by ijlogope.id.dthrlogin ";

		HQL = HQL.replaceAll("::cdmaquina", maquinaDTO.getCdMaquina());
		if (maquinaDTO.getIjtbinj().getOpatual() != null)
			HQL = HQL.replaceAll("::nrop", maquinaDTO.getIjtbinj().getOpatual());

		List<Ijlogope> listaIjlogope = null;

		Query q = getDaoSession().createQuery(HQL);

		try {
			listaIjlogope = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listaIjlogope;
	}

	public List<Ijlogope> getOperadoresLogadosNoTurno(MaquinaInjetDTO maquinaDTO) {
		// Obtem lista ijcnsturno do filtro
		String HQL = "";

		HQL += "select ijlogope ";
		HQL += "from Ijlogope ijlogope ";
		HQL += "join fetch ijlogope.ijtbusu ijtbusu ";
		HQL += "where ( (ijlogope.id.dthrlogin between :data1 and :data2) or (dthrlogout between :data1 and :data2) or dthrlogout is null) ";
		HQL += "and ijlogope.id.cdinjetora = '::cdmaquina' ";

		if (maquinaDTO.getNrop() != null && !maquinaDTO.getNrop().equals("")) {
			HQL += "and ijlogope.nrop = '::nrop' ";
			HQL = HQL.replaceAll("::nrop", maquinaDTO.getNrop());
		}
		HQL += "order by ijlogope.id.dthrlogin ";

		// if (maquinaDTO.getNrop().equals("101318"))
		// //System.out.println("analisando 101318");

		HQL = HQL.replaceAll("::cdmaquina", maquinaDTO.getCdMaquina());

		List<Ijlogope> listaIjlogope = null;

		Query q = getDaoSession().createQuery(HQL);

		q.setTimestamp("data1", maquinaDTO.getDthrITurno());
		q.setTimestamp("data2", maquinaDTO.getDthrFTurno());

		try {
			listaIjlogope = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listaIjlogope;
	}

	public OmUsr getUsuarioInjet(String login, String senha) {
		MapQuery q = new MapQuery(getDaoSession());
		q.append("SELECT DISTINCT a");
		q.append("FROM Ijtbusu a");
		q.append("LEFT JOIN FETCH a.ijcfgusus b");
		q.append("JOIN a.ijgruusus c");
		q.append("WHERE UPPER(a.nmacesso) = :login");
		q.append("AND a.stusuario = :stAtivo");
		q.append("AND c.ijtbgru.cdgrupo IN (SELECT a.ijtbgru.cdgrupo FROM Ijdirace a WHERE a.ijtbopcmenu.cdopcao = '000002')");
		q.defineParametro("login", login.toUpperCase());
		q.defineParametro("stAtivo", (Integer) 0); // 0-ativo; 1-inativo
		q.setMaxResults(1);

		Ijtbusu usuario = (Ijtbusu) q.uniqueResult();

		if (usuario != null) {
			if (usuario.getTpusuario().longValue() > 0 && usuario.getTpusuario().longValue() < 10) {
				usuario = null;
				
			} else {
				if (usuario.getSenha() == null) {
					usuario.setSenha("");
				}

				try {
					if (SenhaRN.criptografarSenha(senha).equals(usuario.getSenha())) {
						String senhaCriptMD5 = HashMD5.getHashCode(senha);

						OmUsr omUsr = new OmUsr();
						omUsr.setIdUsr(ConversaoTipos.converteParaBigDecimal(usuario.getCdusuario()).longValue());
						omUsr.setCdUsr(usuario.getCdusuario());
						omUsr.setLogin(usuario.getNmacesso());
						omUsr.setDsNome(usuario.getNmusuario());
						omUsr.setDsApelido(usuario.getNmacesso());
						omUsr.setSenha(senhaCriptMD5);
						omUsr.setStAtivo((byte) 1);
						omUsr.setOmGt(null);

						// GT
						if (usuario.getIjcfgusus() != null && usuario.getIjcfgusus().size() > 0) {
							OmGt gt = new OmGt();
							Ijtbgal galpaoUsu = usuario.getIjcfgusus().iterator().next().getIjtbgal();
							gt.setIdGt(ConversaoTipos.converteParaBigDecimal(galpaoUsu.getCdgalpao()).longValue());
							gt.setCdGt(galpaoUsu.getCdgalpao());
							gt.setDsGt(galpaoUsu.getDsgalpao());
							gt.setDsCurta(gt.getDsCurta());
							omUsr.setOmGt(gt);
						}

						return omUsr;
					}
				} catch (DigestFileException e) {
					e.printStackTrace();
				}
			}
		}

		return null;
	}
	
	// Operador = 1
	// Operador  + Tecnico = 3
	// Operador  + TM = 11
	// Operador  + Tecnico + TM = 13
	public OmUsr getOperadorInjetAtivoPorCdUsuario(String cdUsuario, String senha) {
		MapQuery q = new MapQuery(getDaoSession());
		q.append("SELECT DISTINCT a");
		q.append("FROM Ijtbusu a");
		q.append("WHERE UPPER(a.cdusuario) = :cdUsuario");
		q.append("AND a.stusuario = :stAtivo");
		q.defineParametro("cdUsuario", cdUsuario.toUpperCase());
		q.defineParametro("stAtivo", (Integer) 0); // 0-ativo; 1-inativo
		q.setMaxResults(1);

		Ijtbusu usuario = (Ijtbusu) q.uniqueResult();

		if (usuario != null) {
			if (usuario.getTpusuario().longValue() != 1 
					&& usuario.getTpusuario().longValue() != 3 
					&& usuario.getTpusuario().longValue() != 11
					&& usuario.getTpusuario().longValue() != 13) {
				usuario = null;
			} else {
				
				if (usuario.getSenha() == null) {
					usuario.setSenha("");
				}

				try {
					if (SenhaRN.criptografarSenha(senha).equals(usuario.getSenha())) {
						String senhaCriptMD5 = HashMD5.getHashCode(senha);

						OmUsr omUsr = new OmUsr();
						omUsr.setIdUsr(ConversaoTipos.converteParaBigDecimal(usuario.getCdusuario()).longValue());
						omUsr.setCdUsr(usuario.getCdusuario());
						omUsr.setLogin(usuario.getNmacesso());
						omUsr.setDsNome(usuario.getNmusuario());
						omUsr.setDsApelido(usuario.getNmacesso());
						omUsr.setSenha(senhaCriptMD5);
						omUsr.setStAtivo((byte) 1);
						omUsr.setOmGt(null);
						return omUsr;
					}
				} catch (DigestFileException e) {
					e.printStackTrace();
				}
			}
		}

		return null;
	}

}
