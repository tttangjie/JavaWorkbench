package Model;

/**
 * 2017/5/7
 * author£∫Œ‚ÃÏ“∞
 */
public class Admin {
	private int id;
	private String name;
	private String password;
	private int level;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level = level;
	}


	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public Admin(int id,String name,String password,int level){
		this.set(id, name, password,level);
	}
	public Admin(Admin admin){
		this.set(admin.id, admin.name, admin.password,admin.level);
	}
	public void set(int id,String name,String password,int level){
		this.name = name;
		this.id = id;
		this.password = password;
		this.level = level;
	}
}
