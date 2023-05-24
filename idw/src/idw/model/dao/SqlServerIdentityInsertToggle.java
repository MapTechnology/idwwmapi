package idw.model.dao;

import org.hibernate.Query;

public class SqlServerIdentityInsertToggle {

	protected boolean identityInsertOn = false;
	protected String tableName;

	public SqlServerIdentityInsertToggle(String tabela){
		this.tableName = tabela;
	}
	
	public boolean isIdentityInsertOn() {
		return identityInsertOn;
	}

	public void setIdentityInsertOn(boolean identityInsertOn) {
		this.identityInsertOn = identityInsertOn;
	}


	public void execute(DAOGenerico dao) {
//		 String schema = "dbo";
		 StringBuilder sql = new StringBuilder("SET IDENTITY_INSERT ");

//		 if(schema != null && !schema.isEmpty())
//			 sql.append(schema).append(".");
	        
		 sql.append(this.tableName).append(" ").append(this.identityInsertOn ? "ON" : "OFF");

		 try{
			 //System.out.println(sql.toString());
			 Query q = dao.getSession().createSQLQuery(sql.toString());
			 q.executeUpdate();
			 dao.flushReiniciandoTransacao();
//			 PreparedStatement statement = connection.prepareStatement(sql.toString());
//			 statement.executeUpdate();
		 } catch (Exception e){
			 e.printStackTrace();
		 }
	}
}
