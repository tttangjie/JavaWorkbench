package Dao;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
public class Dao {
	 private static Connection conn = null;
     private static Statement stmt;
     private static String dbClassName = "com.mysql.jdbc.Driver";
     private static String url = "jdbc:mysql://localhost:3306/wty_1?useUnicode=true&characterEncoding=utf-8";
     private static String sql;
     protected static String second = null;
     static{
    	 try{
    		 if(conn==null){
    			 Class.forName(dbClassName);
    			 conn = DriverManager.getConnection(url, "root", "7988783");
    			 System.out.println("�ɹ�");
    		 }              
        }catch(Exception e){
        	System.out.println("ʧ��");
        	e.printStackTrace();
        }	
     }
     //��ȡ��¼�û�����
     public static Admin LoginDao(int user_id,String user_password){   	 
         try {
        	stmt = conn.createStatement();
        	sql = "select * from admin where id='"+user_id+"'";
        	ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
	             int id = rs.getInt("id");
	             String name = rs.getString("name");
	             String password  =rs.getString("password");
	             int level = rs.getInt("level");
	             if(user_password.equals(password)){
	            	 return new Admin(id,name,password,level);
	             }	             
	         }
	         if (rs != null) {
	             rs.close();
	             rs = null;
	         }
	         if (stmt != null) {
	             stmt.close();
	             stmt = null;
	         }
	     }catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
     }
     
     //���ҽ����Ϣ����
     public static int addDoctor(Doctor doctor){
    	 if (doctor == null)
 			return 0;
    	 return insert(  "insert doctor values('"+doctor.getId()+"','"+doctor.getName()+"','"+doctor.getDepartment()+"','"+doctor.getSex()
    	 		+"','"+doctor.getTel()+"')"  );    	 
     }
    
	//����ҽ����Ϣ����
     public static int updateDoctor(Doctor doctor,String sex,String department,String tel){
    	 if (doctor == null)
 			return 0;
    	 return update( "update doctor set sex='"+sex+"',department='"+department+"',tel='"+tel+"'"
 			+ "where name='" +doctor.getName()+ "'"); 
     }
     //ɾ��ҽ���������
     public static int deleteDoctor(Doctor doctor){
    	 if(doctor == null)
    		 return 0;
    	 return update("delete from doctor where name='"+doctor.getName()+"'");
     }
     //��ȡ����ҽ����Ϣ����
     public static List doctorList(){
    	 List list = findForList("select * from doctor");
 		 return list;
     }
     //��ȡ����ҽ����Ϣ����
     public static Doctor getDoctor(String d_name){   	 
         try {
        	stmt = conn.createStatement();
        	sql = "select * from doctor where name='"+d_name+"'";
        	ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
	             int id = rs.getInt("id");
	             String name = rs.getString("name");
	             String department  =rs.getString("department");
	             String sex = rs.getString("sex");
	             String tel = rs.getString("tel");	            
	             return new Doctor(id, name,sex,department,tel);	                   
	         }
	         if (rs != null) {
	             rs.close();
	             rs = null;
	         }
	         if (stmt != null) {
	             stmt.close();
	             stmt = null;
	         }
	     }catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
     }
     
     //���ҩƷ��Ϣ����
     public static int addMedicine(Medicine m){
    	 if (m == null)
 			return 0;
    	 return insert(  "insert medicine values('"+m.getNumber()+"','"+m.getName()+"','"+m.getMoney()+"')");    	 
     }
    //����ҩƷ��Ϣ����
     public static int updateMedicine(Medicine m,int number,int money){
    	 if (m == null)
 			return 0;
    	 return update( "update medicine set number='"+number+"',money='"+money+ "'"+ "where name='" +m.getNumber()+ "'"); 
     }
     //ɾ��ҩƷ�������
     public static int deleteMedicine(Medicine m){
    	 if(m == null)
    		 return 0;
    	 return update("delete from medicine where name='"+m.getName()+"'");
     }
    //��ȡ����ҩƷ��Ϣ����
     public static List medicineList(){
    	 List list = findForList("select * from medicine");
 		 return list;
     }
    //��ȡ����ҩƷ��Ϣ����
     public static Medicine getMedicine(String m_name){   	 
         try {
        	stmt = conn.createStatement();
        	sql = "select * from medicine where name='"+m_name+"'";
        	ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
	             int number = rs.getInt("number");
	             String name = rs.getString("name");
	             int money = rs.getInt("money");          
	             return new Medicine(number,name,money);	                   
	         }
	         if (rs != null) {
	             rs.close();
	             rs = null;
	         }
	         if (stmt != null) {
	             stmt.close();
	             stmt = null;
	         }
	     }catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
     }
     
     //��Ӳ�����Ϣ����
     public static int addPatient(Patient p){
    	 if (p == null)
 			return 0;
    	 return insert(  "insert patient values('"+p.getId()+"','"+p.getName()+"','"+p.getSex()+"','"+p.getRoom()
    	 +"','"+p.getMoney()+"','"+p.getAge()+"','"+"��')");    	 
     }
    //���²�����Ϣ����
     public static int updatePatient(Patient p,String room,String sex,int money,int age){
    	 if (p == null)
 			return 0;
    	 return update( "update patient set room='"+room+"',money='"+money+ "'"+"',sex='"+sex
    			 +"',age='"+age+ "where name='"+p.getName()+ "'"); 
     }
     //���½ɷ����
     public static int updateJiaoFei(Patient p){
    	 if (p == null)
  			return 0;
     	 return update("update patient set ��Ժ�ɷ�='��' where name='"+p.getName()+"'"); 
     }
     //ɾ�����˶������
     public static int deletePatient(Patient p){
    	 if(p == null)
    		 return 0;
    	 return update("delete from patient where name='"+p.getName()+"'");
     }
    //��ȡ���в�����Ϣ����
     public static List patientList(){
    	 List list = findForList("select * from patient");
 		 return list;
     }
    //��ȡ����������Ϣ����
     public static Patient getPatient(String p_name){   	 
         try {
        	stmt = conn.createStatement();
        	sql = "select * from patient where name='"+p_name+"'";
        	ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
	             int id = rs.getInt("id");
	             String name = rs.getString("name");
	             String sex = rs.getString("sex");
	             String room = rs.getString("room");
	             int money = rs.getInt("money"); 
	             int age = rs.getInt("age");
	             String b=rs.getString("��Ժ�ɷ�");
	             return new Patient(room, name, sex, id, money,age,b);                 
	         }
	         if (rs != null) {
	             rs.close();
	             rs = null;
	         }
	         if (stmt != null) {
	             stmt.close();
	             stmt = null;
	         }
	     }catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
     }
     
     public static int insert(String sql) {
    	 int result = 0;
    	 try {
 			stmt = conn.createStatement();
 			result = stmt.executeUpdate(sql);
 		} catch (SQLException e) {
 			e.printStackTrace();
 		}
 		return result;
 	}
     public static int update(String sql) {
 		int result = 0;
 		try {
 			stmt = conn.createStatement();
 			result = stmt.executeUpdate(sql);
 		} catch (SQLException e) {
 			e.printStackTrace();
 		}
 		return result;
 	}
     public static List findForList(String sql) {
 		List<List> list = new ArrayList<List>();
 		ResultSet rs = findForResultSet(sql);
 		try {
 			ResultSetMetaData metaData = rs.getMetaData();
 			int colCount = metaData.getColumnCount();
 			while (rs.next()) {
 				List<String> row = new ArrayList<String>();
 				for (int i = 1; i <= colCount; i++) {
 					String str = rs.getString(i);
 					if (str != null && !str.isEmpty())
 						str = str.trim();
 					row.add(str);
 				}
 				list.add(row);
 			}
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
 		return list;
 	}
     public static ResultSet findForResultSet(String sql) {
 		if (conn == null)
 			return null;
 		long time = System.currentTimeMillis();
 		ResultSet rs = null;
 		try {
 			Statement stmt = null;
 			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
 					ResultSet.CONCUR_READ_ONLY);
 			rs = stmt.executeQuery(sql);
 			second = ((System.currentTimeMillis() - time) / 1000d) + "";
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
 		return rs;
 	}

}
