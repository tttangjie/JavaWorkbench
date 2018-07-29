package javaUtil;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FileUtils {
	public static void moveTo(String oldPath,String newPath)
	{
		File afile = new File(oldPath);  
		String[] filename = afile.list();
		
		for(int i=0;i<4;i++)
		{
			  File temp = new File(oldPath+File.separator+filename[i]);
			 if (temp.renameTo(new File(newPath +"/"+ temp.getName()))) {  
		            System.out.println("File is moved successful!");  
		        } else {  
		            System.out.println("File is failed to move!");  
		        }  
		}
   

	}
	public static void moveToAndDivid(String sourcePath,String movePath,String start,int capacity ,String oldPath) throws 
IOException
	{
		File afile = new File(sourcePath);
		String[] filename = afile.list();
		String newFileName = start+"-"+(start+capacity);
		File sourceFile = new File(sourcePath);
		String[] files =  sourceFile.list();
		File tempFile = null;
		for(int i=0;i<capacity;i++)
		{
			if(sourcePath.endsWith(File.separator))
			{
				tempFile = new File(sourcePath+files[i]);
			}
			else
			{
				tempFile = new File(sourcePath+File.separator+files[i]);
				
			}
		
		if(tempFile.isFile())
		{
			if(i%capacity==0)
			{
				newFileName =  start+"-"+(start+capacity);
				(new File(sourcePath+"/"+newFileName+"/images")).mkdirs();// 把運行文件寫入文件夾中
				copyFolder(oldPath,newFileName);// 將oldpath里的內容拷貝到文件夾中
				start +=capacity+1;
		   }
		  tempFile.renameTo(new File(sourcePath+"/"+newFileName+"/images/"+tempFile.getName()));
		}
   }
	
			
		
	}
	public static void copyFolder(String oldPath,String newFileName) throws IOException
	{
		if(oldPath==null)
		{
			return ;
		}
		File exeRun = new File(oldPath);
		String file2[] = exeRun.list();
		File exeRunOne=null;
		for(int j=0;j<file2.length;j++)
		{
			exeRunOne = new File(oldPath+File.separator+file2[j]);
			FileInputStream intput = new FileInputStream(exeRunOne);
			FileOutputStream output = new FileOutputStream(oldPath  +"/"+newFileName + "/" +  
                    (exeRunOne.getName()).toString());
			 byte[]  b  =  new  byte[1024  *  5];    
              int  len;    
              while  (  (len  =  intput.read(b))  !=  -1)  {    
              }    
              output.flush();    
              output.close();    
              intput.close();   
	   }
	}

    public static void copyFolder2(String oldPath,String newPath) throws IOException
    {
    	String newfilename=null;
    	int start=0001;
    	int end=1000;
    	newfilename = start+"-"+end;
    	(new File(newPath+"/"+newfilename)).mkdirs();
    	File oldFile = new File(oldPath);
    	String[] file = oldFile.list();
    	File temp = null;
    	for(int i=0;i<file.length;i++)
    	{
    		if(oldPath.endsWith(File.separator))
    		{
    			temp = new File(oldPath+file[i]);
    		}
    		else
    		{
    			temp = new File(oldPath+File.separator+file[i]);
    		}
    		if(temp.isFile())
    		{
    			
    			if(i%1000==0)
    			{
    				
    				newfilename=start+"-"+end;
    				(new File(newPath+"/"+newfilename+"/images")).mkdirs();
    				File exeRun = new File("E:/work/plate_recog");
    				String file2[] = exeRun.list();
    				File exeRunOne=null;
    				for(int j=0;j<file2.length;j++)
    				{
    					exeRunOne = new File("E:/work/plate_recog"+File.separator+file2[j]);
    					FileInputStream inttput = new FileInputStream(exeRunOne);
    	    			FileOutputStream output = new FileOutputStream(newPath  +"/"+newfilename + "/" +  
    	                        (exeRunOne.getName()).toString());
    	    			 byte[]  b  =  new  byte[1024  *  5];    
    	                  int  len;    
    	                  while  (  (len  =  inttput.read(b))  !=  -1)  {    
    	                      output.write(b,  0,  len);    
    	                  }    
    	                  output.flush();    
    	                  output.close();    
    	                  inttput.close();   
    	                  //stem.out.println("第"+j+"个文件");
    	    			
    				}
    				System.out.println("第"+(i+1)/1000+"个文件创建成功");
    				start+=1000;
    				end+=1000;
    			}
    			FileInputStream input = new FileInputStream(temp);
    			FileOutputStream output = new FileOutputStream(newPath  +"/"+newfilename+  "/" +"images" + "/" +  
                        (temp.getName()).toString());
    	          byte[]  b  =  new  byte[1024  *  5];    
                  int  len;    
                  while  (  (len  =  input.read(b))  !=  -1)  {    
                      output.write(b,  0,  len);    
                  }    
                  output.flush();    
                  output.close();    
                  input.close();    
              }    
              if(temp.isDirectory()){//如果是子文件夹    
                  copyFolder2(oldPath+"/"+file[i],newPath+"/"+file[i]);    
              }    
          }   
    		}
    	
    
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//readPicture();
		String oldPath="E:/车牌数据/101/009/05";
		String newPath="E:/车牌数据_2/101/009/05";
		moveTo("E:/lyx/picture","E:/lyx/test");
		
		//copyFolder(oldPath,newPath);

	}

}
