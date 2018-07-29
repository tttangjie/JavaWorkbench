package 实验八;
import java.io.*;
//使用数据字节流将指定范围内的所有素数写入整数类型文件
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
			System.out.println("数据异常");
		}
	}

	public static void main(String[] args) throws IOException{
		new WritePrime("WritePrime.dat",2,100);

	}

}
