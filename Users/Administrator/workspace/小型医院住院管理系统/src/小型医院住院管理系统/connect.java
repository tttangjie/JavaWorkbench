package С��ҽԺסԺ����ϵͳ;
	import java.sql.*;  
	import javax.swing.JOptionPane;
	public class connect {
		Connection con;  
	    PreparedStatement sql;  
	    ResultSet res;  
	    String user,pwd; 
	  //���������ݿ�ķ�����װΪһ������  
	    public Connection getConnection()  
	    {  
	    	try{
	    		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    		System.out.println("���ݿ������ɹ�");
	    	}catch(ClassNotFoundException e)
	        {
	            System.out.println("�������ݿ�����ʧ��");
	            System.exit(0);
	        }
	    	try{
	    		con=DriverManager.getConnection("jdbc:sqlserver://DESKTOP-T25VSKF\\MYABYSS:1433;"+"DatabaseName=Hospital","sa","123");
	    		System.out.println("�������ݿ�ɹ�");
	    		
	    	}catch(SQLException e)
	        {
	    		e.printStackTrace();
	            System.out.print(e.getErrorCode());
	            System.out.println("���ݿ����Ӵ���");
	            System.exit(0);
	        }     
	        return con;
	        }	
	    
	    public void SQLverify(String a,String b)  
        {  
            try {  
                sql=con.prepareStatement("select * from USER_LOGIN where id=? and password=? ");  
                sql.setString(1, a);  
                sql.setString(2, b);  
                  
                // ResultSet�����,��ҿ��԰�ResultSet���ɷ���һ�ű��еĽ����  
                res = sql.executeQuery();  
                if(res.next())  
                {   if(a.equals("doctor")){
                		JOptionPane.showMessageDialog(null, "ҽ����¼�ɹ�������", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE); 
                		DOCTOR_LOGIN doctor_login = new DOCTOR_LOGIN();
                		doctor_login.jf.setVisible(true);
                	}
                	else if(a.equals("admin")){
                		JOptionPane.showMessageDialog(null, "����Ա��¼�ɹ�������", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE); 
                		ADMINISTRATOR_LOGIN administrator_login = new ADMINISTRATOR_LOGIN();
                		administrator_login.jf.setVisible(true);
                	}
                }else  
                {  
                	JOptionPane.showMessageDialog(null, "�û�����������������������룡", "��ʾ��Ϣ", JOptionPane.ERROR_MESSAGE);  
                	LOGIN login = new LOGIN();
                } 
            } catch (SQLException e) {  
                  
                e.printStackTrace();  
            }  
        }	    
        
	    public void MP(String a,String b,String c,String d)  
        {  
            try {  
                sql=con.prepareStatement("insert into PRESCRIPTION values (?,?,?,?)");  
                sql.setString(1, a);  
                sql.setString(2, b);  
                sql.setString(3, c);  
                sql.setString(4, d);   
                sql.executeUpdate();  
                JOptionPane.showMessageDialog(null, "����ɹ�������");     
            } catch (SQLException e) {  
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "���˱�š�ҩƷ����Ѵ��ڣ�");
            }  
           
        }
	    
	   
	    
	    public void DRUGI(String a){
	    	try {  
                sql=con.prepareStatement("select name,number,price from DRUG where drug_id=?");  
                sql.setString(1, a);  
                
                res = sql.executeQuery(); 
                if(res.next()){
                	String name=res.getString(1);
                	String number=res.getString(2);
                	String price=res.getString(3);
                	new Drug_Inquire_result(a,name,number,price);
                	
                } 
                else
                	 JOptionPane.showMessageDialog(null, "ҩƷ��Ų����ڣ�");
            } catch (SQLException e) {  
                e.printStackTrace();
               
            }  
	    }
	    
	    public void HOSPITALI(String a){
	    	int i=0;
	    	try {  
	    		String name = null,sex = null,age = null,premoney = null,phone = null,room_id=null,bed_id=null;
                sql=con.prepareStatement("select name,sex,age,premoney,phone from PATIENT where patient_id=?");  
                sql.setString(1, a);  
                res = sql.executeQuery(); 
                if(res.next()){
                	name=res.getString(1);
                	sex=res.getString(2);
                	age=res.getString(3);
                	premoney=res.getString(4);
                	phone=res.getString(5);
                	i=1;
                } 
                else
                	JOptionPane.showMessageDialog(null, "���˱�Ų����ڣ�");           
                if(i==1){
                sql=con.prepareStatement("select room_id,bed_id from HOSPITAL where patient_id=?");  
                sql.setString(1, a);  
                res = sql.executeQuery(); 
                if(res.next()){
                	room_id=res.getString(1);
                	bed_id=res.getString(2);
                } 
                new Hospital_Inquire_result(a,name,sex,age,premoney,phone,room_id,bed_id);
                }
            	} catch (SQLException e) {  
                e.printStackTrace();
            }  
	    }
	    
	    public void DE(String a){
	    	try {  
                sql=con.prepareStatement("select * from DRUG where drug_id=?");  
                sql.setString(1, a);  
                
                res = sql.executeQuery(); 
                if(res.next()){
                	
                	String id=res.getString(1);
                	new Drug_Edit_result(id);
                	
                } 
                else{
                	JOptionPane.showMessageDialog(null, "��ҩƷ�����ڣ�����");
                }
            } catch (SQLException e) {  
                e.printStackTrace();
            }  
           
	    	
	    }
	    
	    public void DER(String a,String b,String c,String d){
	    	try {  
	    			sql=con.prepareStatement("update DRUG set name=?,number=number+?,price=? where drug_id=?");  
	    			sql.setString(1, b);  
	    			sql.setString(2, c);  
	    			sql.setString(3, d);  
	    			sql.setString(4, a);   
	    			sql.executeUpdate();  
	    			JOptionPane.showMessageDialog(null, "�޸ĳɹ�������");  
            } catch (SQLException e) {  
                e.printStackTrace();
            }  
	    
	    }
	
	    public void HIN(String patient_id,String patient_name,String sex,String age,String patient_phone,String premoney,String room_id,String bed_number){
	    	 try {  
	                sql=con.prepareStatement("insert into PATIENT values (?,?,?,?,?,?)");  
	                sql.setString(1, patient_id);  
	                sql.setString(2, patient_name);  
	                sql.setString(3, sex);  
	                sql.setString(4, age);   
	                sql.setString(5, premoney);  
	                sql.setString(6, patient_phone);  
	                sql.executeUpdate();  
	                
	                sql=con.prepareStatement("insert into HOSPITAL values (?,?,?)");  
	                sql.setString(1, patient_id);  
	                sql.setString(2, room_id);  
	                sql.setString(3, bed_number);  
	                sql.executeUpdate();  
	                
	                JOptionPane.showMessageDialog(null, "��Ӳ��˳ɹ�������");     
	            } catch (SQLException e) {  
	                e.printStackTrace();
	            }  
	           
	    }
	    
	    public void OA(String id, String name){
	    	try {  
                sql=con.prepareStatement("insert into OFFICE(office_no,name) values (?,?)");  
                sql.setString(1, id);  
                sql.setString(2, name);  
 
                sql.executeUpdate();  
                JOptionPane.showMessageDialog(null, "����ɹ�������");     
            } catch (SQLException e) {  
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "���Һ��Ѵ��ڣ�");
            }
	    }
	    
	    public void OI(String a){
	    	try {  
                sql=con.prepareStatement("select name,doctor_number from OFFICE where office_no=?");  
                sql.setString(1, a);  
                
                res = sql.executeQuery(); 
                if(res.next()){
                	String name=res.getString(1);
                	String doctor_number=res.getString(2);
                	new  Office_Inquire_result(a,name,doctor_number);
                	
                } 
                else
                	 JOptionPane.showMessageDialog(null, "���ұ�Ų����ڣ�");
            } catch (SQLException e) {  
                e.printStackTrace();
            }  
	    }
	    
	    public void DA(String doctor_id,String doctor_name,String sex,String office_id,String phone){
	    	try {  
                sql=con.prepareStatement("insert into DOCTOR values (?,?,?,?,?)");  
                sql.setString(1, doctor_id);  
                sql.setString(2, doctor_name);  
                sql.setString(3, sex);  
                sql.setString(4, office_id);  
                sql.setString(5, phone);  
                sql.executeUpdate();  
                JOptionPane.showMessageDialog(null, "����ɹ�������");     
            } catch (SQLException e) {  
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "ҽ������Ѵ��ڣ�");
            }
	    }
	    
	    
	    public void DD(String a)  
        {  
            try {  
                sql=con.prepareStatement("delete from DOCTOR where doctor_id=?");  
                sql.setString(1, a);    
                sql.executeUpdate();  
                JOptionPane.showMessageDialog(null, "ɾ���ɹ�������");     
            } catch (SQLException e) {  
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "ҽ����Ų����ڣ�");
            }  
           
        }
	    
	    
	     public void DI(String a){
	    	 try {  
	                sql=con.prepareStatement("select name,sex,office_no,phone from DOCTOR where doctor_id=?");  
	                sql.setString(1, a);  
	                
	                res = sql.executeQuery(); 
	                if(res.next()){
	                	String name=res.getString(1);
	                	String sex=res.getString(2);
	                	String office_no=res.getString(3);
	                	String phone=res.getString(4);
	                	new Doctor_Inquire_result(a,name,sex,office_no,phone);
	                	
	                } 
	                else
	                	 JOptionPane.showMessageDialog(null, "ҽ����Ų����ڣ�");
	            } catch (SQLException e) {  
	                e.printStackTrace();
	               
	            }  
	    }
	     
	     public void DR(String a){
	    	 try {  
	                sql=con.prepareStatement("select PATIENT.premoney,ROOM.price,PRESCRIPTION.number,DRUG.price from PATIENT,ROOM,PRESCRIPTION,DRUG,HOSPITAL where PATIENT.patient_id=? and HOSPITAL.patient_id=? and HOSPITAL.room_id=ROOM.room_id and PRESCRIPTION.patient_id=? and PRESCRIPTION.drug_id=DRUG.drug_id;");  
	                sql.setString(1, a); 
	                sql.setString(2, a); 
	                sql.setString(3, a); 
	                res = sql.executeQuery(); 
	                if(res.next()){
	                	String premoney1=res.getString(1);
	                	String ROOM_price1=res.getString(2);
	                	String number1=res.getString(3);
	                	String DRUG_price1=res.getString(4);
	                	
	                	float premoney=Float.parseFloat(premoney1);
	                	float ROOM_price=Float.parseFloat(ROOM_price1);
	                	float number=Float.parseFloat(number1);
	                	float DRUG_price=Float.parseFloat(DRUG_price1);
	                	float sum;
	                	sum=premoney-ROOM_price-number*DRUG_price;
	                	if(sum>=0){
	                		new Do_Recover_result1(sum);
	                	}
	                	else
	                		new Do_Recover_result2(-sum);
	                	
	                } 
	                else
	                	 JOptionPane.showMessageDialog(null, "���˱�Ų����ڣ�");
	            } catch (SQLException e) {  
	                e.printStackTrace();
	            }  
	     }
	     
	     public void DP(String a){
	    	 try {  
	                sql=con.prepareStatement("delete from PATIENT where patient_id=?");  
	                sql.setString(1, a);    
	                sql.executeUpdate();  
	                JOptionPane.showMessageDialog(null, "ɾ���ɹ�������");     
	            } catch (SQLException e) {  
	                e.printStackTrace();
	                JOptionPane.showMessageDialog(null, "���˱�Ų����ڣ�");
	            }  
	     }
	     
}
