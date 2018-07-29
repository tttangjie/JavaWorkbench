package zuoye;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class GuestManager2 {

	public static void main(String[] args) throws IOException {
		new Manager().login();

	}

}

class Manager {

	BufferedReader br = null; // 一个输入流
	String s = null;

	// 获取键盘输入
	public String getInput() {
		s = null;
		if (br == null)
			br = new BufferedReader(new InputStreamReader(System.in));
		try {
			s = br.readLine();
		} catch (IOException e) {
			System.out.println("获取输入信息失败!");
			e.printStackTrace();
		}

		return s.trim();// 返回的是去除两端空格的字符串

	}

	public void login() throws IOException {
		String username = null;
		String password = null;
		StringBuilder sb = null;
		String res = null;

		sb = new StringBuilder();
		System.out.println("请按提示输入用户名和密码以登录本系统!");
		System.out.println("请输入用户名：");
		username = getInput();
		sb.append(username);
		System.out.println("请输入密码");
		password = getInput();
		sb.append(" " + password); // 以空格连接用户名和密码

		res = query("userInfo.txt", sb.toString());

		if ("findadmin".equals(res)) {
			System.out.println("您的管理员身份已确认,欢迎使用!");
			operate(welcome_1());

		} else if ("findnormal".equals(res)) {
			System.out.println("您的普通用户身份已确认,欢迎使用!");
			operate(welcome_2());
			
		} else {
			System.out.println("您输入的用户名密码无法确认您的信息,请重新登录!");
			login();
		}
	}

	public String query(String filename, String info) {
		String ret = null;

		BufferedReader bufr = null;// 文件读缓冲流

		try {
			if (!new File(filename).exists()) {
				System.out.println("没有可供查询的信息,请先创建!");
				System.exit(0);
			}

			bufr = new BufferedReader(new FileReader(filename));
			String line = null;
			while ((line = bufr.readLine()) != null) {
				String s = null;
				s = line.replaceAll("\\s+", " ");// 将读取的每一行中的空白符替换成一个空格
				String[] buf = s.split(" ");// 将每一行数据以空格分隔成数组，方便获取每个字段的信息

				if (info.contains(" ")) {// 用来查询用户信息的
					String[] infobuf = info.split(" ");// 分割传递进来的数据方便获得用户名和密码

					if (buf[0].equals(infobuf[0])) {// 用户名匹配
						if (buf[1].equals(infobuf[1]) && buf[2].equals("admin"))// 密码匹配且管理员字段显示是管理员
							return "findadmin";
						else if (buf[1].equals(infobuf[1]) && buf[2].equals("normal"))// 密码匹配且管理员字段显示是普通用户
							return "findnormal";
					}
					continue;
				} else {// 用来查找客户信息的
					if (buf[0].equals(info) || buf[1].equals(info)) {// 姓名匹配或者工作地址匹配
						System.out.println(line);
						ret = "success";
					}
				}
			}
		} catch (IOException e) {
			throw new RuntimeException("查询过程中失败!");
		} finally {
			try {
				if (bufr != null)
					bufr.close();
			} catch (IOException e) {
				throw new RuntimeException("关闭查询流失败!");
			}
		}
		return ret;
	}

	public String insert(String filename, String info) {
		String ret = null;

		BufferedWriter bufw = null;// 文件写缓冲流
		try {
			bufw = new BufferedWriter(new FileWriter(filename, true));
			bufw.write("\n");
			bufw.write(info);
			// bufw.newLine();
		} catch (IOException e) {
			ret = "fail";
			throw new RuntimeException("添加客户信息失败!");
		} finally {
			try {
				if (bufw != null)
					bufw.close();
			} catch (IOException e) {
				throw new RuntimeException("关闭流失败");
			}
		}
		if (!"fail".equals(ret))
			ret = "success";

		return ret;

	}

	public String modify(String filename, String info) {
		int count = 0;
		String ret = null;
		BufferedReader bufr = null;
		BufferedWriter bufw = null;
		String line = null;
		String[] bufinfo = info.split("\t");
		String newFileName = null;

		try {
			bufr = new BufferedReader(new FileReader(filename));
			if (filename.contains(".")) {
				String[] basename = filename.split("\\.");
				newFileName = basename[0] + "_bak." + basename[1];
				bufw = new BufferedWriter(new FileWriter(newFileName));
			} else {
				newFileName = filename + "_bak";
				bufw = new BufferedWriter(new FileWriter(newFileName));
			}
			while ((line = bufr.readLine()) != null && (!line.equals("\n"))) {
				count++;
				String s = null;
				s = line.replaceAll("\\s+", " ");
				String[] buf = s.split(" ");
				if (!buf[0].equals(bufinfo[0])) {

					bufw.write(line);
					// bufw.newLine();
					bufw.write("\n");

				} else {
					bufw.write(info);
					// bufw.newLine();
					bufw.write("\n");

				}
			}

		} catch (IOException e) {
			ret = "fail";
			throw new RuntimeException("添加客户信息失败!");
		} finally {
			try {
				if (bufw != null)
					bufw.close();
				bufw = null;
			} catch (IOException e) {
				throw new RuntimeException("关闭流失败");
			}
			try {
				if (bufr != null)
					bufr.close();
				bufr = null;
			} catch (IOException e) {
				throw new RuntimeException("关闭流失败");
			}
		}
		// System.out.println(count);
		// ret = rename(newFileName, filename);
		ret = writeToFile(newFileName, filename + " " + count);

		return ret;

	}

	public String writeToFile(String srcname, String info) {
		String[] buf = info.split(" ");
		String destname = buf[0];
		int count = Integer.parseInt(buf[1]);

		// System.out.println(count);

		String ret = null;
		BufferedReader bufr = null;
		BufferedWriter bufw = null;
		String line = null;

		try {
			bufr = new BufferedReader(new FileReader(srcname));
			bufw = new BufferedWriter(new FileWriter(destname));

			while ((line = bufr.readLine()) != null && (!line.equals("\n")) && count > 0) {
				if (count > 1) {
					count--;
					bufw.write(line);
					// bufw.newLine();
					bufw.write("\n");
				} else {
					count--;
					bufw.write(line);
				}

			}
		} catch (FileNotFoundException e) {
			ret = "fail";
			e.printStackTrace();
		} catch (IOException e) {
			ret = "fail";
			e.printStackTrace();
		} finally {
			try {
				if (bufr != null)
					bufr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (bufw != null)
					bufw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (!"fail".equals(ret))
			ret = "success";
		return ret;
	}

	public String delete(String filename, String info) {
		String ret = null;
		BufferedReader bufr = null;
		BufferedWriter bufw = null;
		String newFileName = null;
		String line = null;
		int count = 0;

		try {
			bufr = new BufferedReader(new FileReader(filename));
			if (filename.contains(".")) {
				String[] basename = filename.split("\\.");
				newFileName = basename[0] + "_bak." + basename[1];
				bufw = new BufferedWriter(new FileWriter(newFileName));
			} else
				newFileName = filename + "_bak";
			bufw = new BufferedWriter(new FileWriter(newFileName));

			while ((line = bufr.readLine()) != null && !line.equals("\n")) {
				count++;
				String s = null;
				s = line.replaceAll("\\s+", " ");
				String[] buf = s.split(" ");
				if (!buf[0].equals(info)) {
					bufw.write(line);
					// bufw.newLine();
					bufw.write("\n");
				}
			}

		} catch (IOException e) {
			ret = "fail";
			e.printStackTrace();
		} finally {
			try {
				if (bufr != null)
					bufr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (bufw != null)
					bufw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		ret = writeToFile(newFileName, filename + " " + (count - 1));
		return ret;
	}


	public String welcome_1() {

		String s = "012345";
		String res = null;

		System.out.println("=====================客户资料管理系统=====================\n"
				+ "|                                                       |\n"
				+ "|---------------------0.退出管理系统---------------------|\n"
				+ "|                                                       |\n"
				+ "|---------------------1.查询用户信息---------------------|\n"
				+ "|                                                       |\n"
				+ "|---------------------2.插入用户信息---------------------|\n"
				+ "|                                                       |\n"
				+ "|---------------------3.修改用户信息---------------------|\n"
				+ "|                                                       |\n"
				+ "|---------------------4.删除用户信息---------------------|\n"
				+ "|                                                       |\n"
				+ "|====================================================== |\n");

		do {
			System.out.println("请输入指定操作对应的序号：");
			res = getInput();
		} while (res.length() != 1 || !s.contains(res));

		return res + ";" + Thread.currentThread().getStackTrace()[1].getMethodName();
	}

	public String welcome_2() {
		String s = "01";
		String res = null;

		System.out.println("=====================客户资料管理系统=====================\n"
				+ "|                                                       |\n"
				+ "|---------------------0.退出管理系统---------------------|\n"
				+ "|                                                       |\n"
				+ "|---------------------1.查询用户信息---------------------|\n"
				+ "|                                                       |\n"
				+ "|====================================================== |\n");

		do {
			System.out.println("请输入指定操作对应的序号：");
			res = getInput();

		} while (res.length() != 1 || !s.contains(res));

		return res + " " + Thread.currentThread().getStackTrace()[1].getMethodName();
	}

	public void operate(String s) throws IOException {
		String name = null;
		String address = null;
		String phone = null;
		StringBuilder sb = null;
		String newAddress = null;
		String newPhone = null;

		String[] str = s.split(";");// 主要是为了判断当选择的是功能1之后该进哪个界面的
		switch (str[0]) {
		case "0":
			System.out.println("欢迎您再次使用,再见!");
			System.exit(0);
			break;
		case "1":
			System.out.println("请输入要查找的客户的姓名或者工作单位：");

			s = getInput();
			if ("null".equals(query("guestInfo.txt", s)))
				System.out.println("没有您想查询的客户信息，请确认该用户或工作单位存在!");

			// System.out.println(str[1]);
			if (str[1].equals("welcome_1"))
				operate(welcome_1());
			else
				operate(welcome_2());
			break;
		case "2":

			sb = new StringBuilder();

			System.out.println("请输入待插入客户的姓名：");
			name = getInput();
			sb.append(name);
			System.out.println("请输入待插入客户的工作地址：");
			address = getInput();
			sb.append("\t" + address);
			System.out.println("请输入待插入客户的联系方式：");
			phone = getInput();
			sb.append("\t" + phone);

			if ("success".equals(insert("guestInfo.txt", sb.toString())))
				System.out.println("插入客户信息成功!");
			else
				System.out.println("插入客户信息失败!");

			operate(welcome_1());
			break;
		case "3":
			sb = new StringBuilder();
			
			System.out.println("请输入要修改的客户的姓名：");
			name = getInput();
			sb.append(name);
			System.out.println("请输入客户的新工作地址：");
			newAddress = getInput();
			sb.append("\t" + newAddress);
			System.out.println("请输入客户的新联系方式：");
			newPhone = getInput();
			sb.append("\t" + newPhone);

			if ("success".equals(modify("guestInfo.txt", sb.toString())))
				System.out.println("客户信息修改成功!");
			else
				System.out.println("客户信息修改失败!");

			operate(welcome_1());
			break;
		case "4":
			System.out.println("请输入待删除客户的姓名：");
			name = getInput();
			if ("success".equals(delete("guestInfo.txt", name))) {
				System.out.println("删除客户信息成功!");
			} else {
				System.out.println("删除客户信息失败!");
			}

			operate(welcome_1());
			break;
		default:
			System.out.println("请输入对应的序号以使用功能!");
			operate(getInput());
		}
	}
}