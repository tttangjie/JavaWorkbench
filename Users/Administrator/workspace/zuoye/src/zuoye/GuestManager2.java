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

	BufferedReader br = null; // һ��������
	String s = null;

	// ��ȡ��������
	public String getInput() {
		s = null;
		if (br == null)
			br = new BufferedReader(new InputStreamReader(System.in));
		try {
			s = br.readLine();
		} catch (IOException e) {
			System.out.println("��ȡ������Ϣʧ��!");
			e.printStackTrace();
		}

		return s.trim();// ���ص���ȥ�����˿ո���ַ���

	}

	public void login() throws IOException {
		String username = null;
		String password = null;
		StringBuilder sb = null;
		String res = null;

		sb = new StringBuilder();
		System.out.println("�밴��ʾ�����û����������Ե�¼��ϵͳ!");
		System.out.println("�������û�����");
		username = getInput();
		sb.append(username);
		System.out.println("����������");
		password = getInput();
		sb.append(" " + password); // �Կո������û���������

		res = query("userInfo.txt", sb.toString());

		if ("findadmin".equals(res)) {
			System.out.println("���Ĺ���Ա�����ȷ��,��ӭʹ��!");
			operate(welcome_1());

		} else if ("findnormal".equals(res)) {
			System.out.println("������ͨ�û������ȷ��,��ӭʹ��!");
			operate(welcome_2());
			
		} else {
			System.out.println("��������û��������޷�ȷ��������Ϣ,�����µ�¼!");
			login();
		}
	}

	public String query(String filename, String info) {
		String ret = null;

		BufferedReader bufr = null;// �ļ���������

		try {
			if (!new File(filename).exists()) {
				System.out.println("û�пɹ���ѯ����Ϣ,���ȴ���!");
				System.exit(0);
			}

			bufr = new BufferedReader(new FileReader(filename));
			String line = null;
			while ((line = bufr.readLine()) != null) {
				String s = null;
				s = line.replaceAll("\\s+", " ");// ����ȡ��ÿһ���еĿհ׷��滻��һ���ո�
				String[] buf = s.split(" ");// ��ÿһ�������Կո�ָ������飬�����ȡÿ���ֶε���Ϣ

				if (info.contains(" ")) {// ������ѯ�û���Ϣ��
					String[] infobuf = info.split(" ");// �ָ�ݽ��������ݷ������û���������

					if (buf[0].equals(infobuf[0])) {// �û���ƥ��
						if (buf[1].equals(infobuf[1]) && buf[2].equals("admin"))// ����ƥ���ҹ���Ա�ֶ���ʾ�ǹ���Ա
							return "findadmin";
						else if (buf[1].equals(infobuf[1]) && buf[2].equals("normal"))// ����ƥ���ҹ���Ա�ֶ���ʾ����ͨ�û�
							return "findnormal";
					}
					continue;
				} else {// �������ҿͻ���Ϣ��
					if (buf[0].equals(info) || buf[1].equals(info)) {// ����ƥ����߹�����ַƥ��
						System.out.println(line);
						ret = "success";
					}
				}
			}
		} catch (IOException e) {
			throw new RuntimeException("��ѯ������ʧ��!");
		} finally {
			try {
				if (bufr != null)
					bufr.close();
			} catch (IOException e) {
				throw new RuntimeException("�رղ�ѯ��ʧ��!");
			}
		}
		return ret;
	}

	public String insert(String filename, String info) {
		String ret = null;

		BufferedWriter bufw = null;// �ļ�д������
		try {
			bufw = new BufferedWriter(new FileWriter(filename, true));
			bufw.write("\n");
			bufw.write(info);
			// bufw.newLine();
		} catch (IOException e) {
			ret = "fail";
			throw new RuntimeException("��ӿͻ���Ϣʧ��!");
		} finally {
			try {
				if (bufw != null)
					bufw.close();
			} catch (IOException e) {
				throw new RuntimeException("�ر���ʧ��");
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
			throw new RuntimeException("��ӿͻ���Ϣʧ��!");
		} finally {
			try {
				if (bufw != null)
					bufw.close();
				bufw = null;
			} catch (IOException e) {
				throw new RuntimeException("�ر���ʧ��");
			}
			try {
				if (bufr != null)
					bufr.close();
				bufr = null;
			} catch (IOException e) {
				throw new RuntimeException("�ر���ʧ��");
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

		System.out.println("=====================�ͻ����Ϲ���ϵͳ=====================\n"
				+ "|                                                       |\n"
				+ "|---------------------0.�˳�����ϵͳ---------------------|\n"
				+ "|                                                       |\n"
				+ "|---------------------1.��ѯ�û���Ϣ---------------------|\n"
				+ "|                                                       |\n"
				+ "|---------------------2.�����û���Ϣ---------------------|\n"
				+ "|                                                       |\n"
				+ "|---------------------3.�޸��û���Ϣ---------------------|\n"
				+ "|                                                       |\n"
				+ "|---------------------4.ɾ���û���Ϣ---------------------|\n"
				+ "|                                                       |\n"
				+ "|====================================================== |\n");

		do {
			System.out.println("������ָ��������Ӧ����ţ�");
			res = getInput();
		} while (res.length() != 1 || !s.contains(res));

		return res + ";" + Thread.currentThread().getStackTrace()[1].getMethodName();
	}

	public String welcome_2() {
		String s = "01";
		String res = null;

		System.out.println("=====================�ͻ����Ϲ���ϵͳ=====================\n"
				+ "|                                                       |\n"
				+ "|---------------------0.�˳�����ϵͳ---------------------|\n"
				+ "|                                                       |\n"
				+ "|---------------------1.��ѯ�û���Ϣ---------------------|\n"
				+ "|                                                       |\n"
				+ "|====================================================== |\n");

		do {
			System.out.println("������ָ��������Ӧ����ţ�");
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

		String[] str = s.split(";");// ��Ҫ��Ϊ���жϵ�ѡ����ǹ���1֮��ý��ĸ������
		switch (str[0]) {
		case "0":
			System.out.println("��ӭ���ٴ�ʹ��,�ټ�!");
			System.exit(0);
			break;
		case "1":
			System.out.println("������Ҫ���ҵĿͻ����������߹�����λ��");

			s = getInput();
			if ("null".equals(query("guestInfo.txt", s)))
				System.out.println("û�������ѯ�Ŀͻ���Ϣ����ȷ�ϸ��û�������λ����!");

			// System.out.println(str[1]);
			if (str[1].equals("welcome_1"))
				operate(welcome_1());
			else
				operate(welcome_2());
			break;
		case "2":

			sb = new StringBuilder();

			System.out.println("�����������ͻ���������");
			name = getInput();
			sb.append(name);
			System.out.println("�����������ͻ��Ĺ�����ַ��");
			address = getInput();
			sb.append("\t" + address);
			System.out.println("�����������ͻ�����ϵ��ʽ��");
			phone = getInput();
			sb.append("\t" + phone);

			if ("success".equals(insert("guestInfo.txt", sb.toString())))
				System.out.println("����ͻ���Ϣ�ɹ�!");
			else
				System.out.println("����ͻ���Ϣʧ��!");

			operate(welcome_1());
			break;
		case "3":
			sb = new StringBuilder();
			
			System.out.println("������Ҫ�޸ĵĿͻ���������");
			name = getInput();
			sb.append(name);
			System.out.println("������ͻ����¹�����ַ��");
			newAddress = getInput();
			sb.append("\t" + newAddress);
			System.out.println("������ͻ�������ϵ��ʽ��");
			newPhone = getInput();
			sb.append("\t" + newPhone);

			if ("success".equals(modify("guestInfo.txt", sb.toString())))
				System.out.println("�ͻ���Ϣ�޸ĳɹ�!");
			else
				System.out.println("�ͻ���Ϣ�޸�ʧ��!");

			operate(welcome_1());
			break;
		case "4":
			System.out.println("�������ɾ���ͻ���������");
			name = getInput();
			if ("success".equals(delete("guestInfo.txt", name))) {
				System.out.println("ɾ���ͻ���Ϣ�ɹ�!");
			} else {
				System.out.println("ɾ���ͻ���Ϣʧ��!");
			}

			operate(welcome_1());
			break;
		default:
			System.out.println("�������Ӧ�������ʹ�ù���!");
			operate(getInput());
		}
	}
}