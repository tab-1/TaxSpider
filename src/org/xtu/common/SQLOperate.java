package org.xtu.common;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.storm.command.list;

import com.qdcz.spider.dao.JDBC;

public class SQLOperate {
	//数据库连接参数
	private String host;
	private String port;
	private String databaseName;
	private String charset;
	private String user;
	private String psword;
	
    // 数据库
	public JDBC datatool = null;
    
    /**
     * 构造方法
     * @param host
     * @param port
     * @param databaseName
     * @param charset
     * @param user
     * @param psword
     */
    public SQLOperate(String host, String port,String databaseName,String charset,String user, String psword) {
    	this.host = host;
    	this.port = port;
    	this.databaseName = databaseName;
    	this.charset = charset;
    	this.user = user;
    	this.psword = psword;
    	datatool = getJDBC();
    }
    
    public SQLOperate(){
    	this.host = SpiderProperties.getProperty("mysql.host");
    	this.port = SpiderProperties.getProperty("mysql.port");
    	this.databaseName = SpiderProperties.getProperty("mysql.database");
    	this.charset = SpiderProperties.getProperty("mysql.charset");
    	this.user = SpiderProperties.getProperty("mysql.user");
    	this.psword = SpiderProperties.getProperty("mysql.password");
    	datatool = getJDBC();
    }

    private JDBC getJDBC() {
		JDBC jdbc = new JDBC(host, port,
				databaseName, charset,
				user, psword);
		jdbc.connect();
		return jdbc;
    }

    public void varifyDatatool() {
		try {
		    if (datatool == null) {
				datatool = getJDBC();
				return;
		    }
		    if (datatool.getConnection() == null) {
				datatool = getJDBC();
				return;
		    }
		    if (datatool.getConnection().isClosed()) {
				datatool = getJDBC();
				return;
		    }
		    if (datatool.getConnection().isValid(10000)) {
		    	datatool = getJDBC();
		    }
		} catch (SQLException e1) {
		    datatool = getJDBC();
		}
    }

    

    public static void main(String[] args) throws Exception {
    	SQLOperate mysql= new SQLOperate();
    	
    }

    public int saveLog(Timestamp ts,String LogText) {
		String sql = "INSERT INTO TaxLogs(saveTime,LogText) VALUES('" + ts + "','" + LogText + "');";
		System.out.println(sql);
		int num = execute(sql);
		return num;
	}
    
    public void InsertClassName(String className,String time){
    	String sql = "INSERT INTO ClassList(className,UpdateTime) VALUES('" + className + "','" + time  + "');";
    	System.out.println(sql);
//    	execute(sql);
    }

    public ResultSet executeQuery(String sql) {
    	varifyDatatool();
		ResultSet result = null;
		try {
		    result = datatool.executeQuery(sql);
		} catch (Exception ex) {
		    ex.printStackTrace();
		}
		return result;
    }

    public int execute(String sql) {
    	varifyDatatool();
    	int num = 0;//数据库操作影响的行数
    	try {
    		num =  datatool.executeUpdate(sql);
		} catch (Exception ex) {
		    ex.printStackTrace();
		}
    	return num;
    }

    public void close_db() {
    	datatool.close();
    }

}
