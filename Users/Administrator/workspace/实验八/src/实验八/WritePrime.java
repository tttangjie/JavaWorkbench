package ʵ���;
import java.io.*;
//ʹ�������ֽ�����ָ����Χ�ڵ���������д�����������ļ�
public class WritePrime {
	protected String filename;
	public WritePrime(String filename,int begin,int end)throws IOException
	{
		try{
			FileOutputStream fout=new FileOutputStream(filename);
			DataOutputStream dout=new DataOutputStream(fout);
			for(int i=begin+1;i<end;i++)
			{
				int j;
				for(j=2;j<i;j++)
				{
					if(i%j==0)break;
				}
				if(i==j) {
					dout.writeInt(i);
				}
			}
			dout.close();
			fout.close();
		}
		catch(IOException ex)
		{
			System.out.println("�����쳣");
		}
	}

	public static void main(String[] args) throws IOException{
		new WritePrime("WritePrime.dat",2,100);

	}

}
