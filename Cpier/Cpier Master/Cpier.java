/* Created by   Shivam Agrawal   
    Date       :    12/19/2015    1:17PM     */

import java.io.*;
import java.util.StringTokenizer;
import java.util.Scanner;

class Cpier extends Thread
{

final static String nn=System.getProperty("line.separator");
static String ll="-----------------------------------------------------------------------------------------------";
String perpath;
static String cnm="!!Computer!!\\";
static String cnmm="!!Computer!!";



/*------------------Size Converter-------------------------------*/
static String sizecon(long ln)
{
if(ln<1024)
return ln+" Bytes";
else if(ln<(1024*1024))
return (float)(ln/1024.0)+" Kb";
else if(ln<(1024*1024*1024.0))
return (float)(ln/(1024*1024.0))+" Mb";
else 
return (float)(ln/(1024*1024*1024.0))+" Gb";
//else
//return "File size couldn't be obtained";
}




/**************************************Directory ka tree************************************************/

void folder(File manf,String ppath)   throws IOException
{
FileOutputStream fout=null;
File listf[]=manf.listFiles();
for(File ff:listf)
{	
	/*------------------------------For Files----------------------------------------------------------------------*/
	if(ff.isFile())
	{
	fout=new FileOutputStream(ppath+"\\["+ff.getName()+"].txt");
	
	
                /*-----------------------------------Files Details--------------------------------------------------------------*/
	String pp=" Name:-\t\t";
	pp+=" "+ff.getName()+nn+ll+nn;
	pp+=" Size:-\t\t"+sizecon(ff.length())+nn+ll+nn;
	pp+=" Modified Date:-\t";
	pp+=" "+new java.util.Date(ff.lastModified())+nn+ll+nn;
	pp+=" Writable:-\t";
	pp+=" "+ff.canWrite()+nn+ll+nn;
	pp+=" Path:-\t\t";
	pp+=" "+ff.getCanonicalPath()+nn+ll+nn;
	
	byte bb[]=pp.getBytes();
	fout.write(bb);	
	}
	}
	
	/*-----------------------------------For Folders--------------------------------------*/
	for(File ff:listf)
	{
	if(ff.isDirectory())
	{
	String sm=ff.getName();
            if(!sm.equals(perpath)&&!sm.equals(cnmm)&&!sm.equals("$RECYCLE.BIN")&&!sm.equals("zzzz"))
	{
	File fd=new File(ppath+"\\"+ff.getName());
	fd.mkdirs();
	folder(ff,ppath+"\\"+ff.getName());   //Recurtion
	}
	}  
}
}












/*------------------------------------------------------------------------------------------------------------------------------------*/



/*------------------------------------------Line-------------------------------------------------*/
static void line(char a)
{

}


static int welCh()
{
Scanner sc=new Scanner(System.in);
line('=');
line('*');
return sc.nextInt();
}
 
String ayushi;
Cpier(String ayu)
{
ayushi=ayu;
}


/*$$$$$$$$$$$$$$$$$$$$$$$$$$$$$___RUN___$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$*/

public void run()
{
String shivpath;
File paarfi;
File nf;
/*-------------------------------------------------------------------------------------------*/
shivpath="Disk "+ayushi;
perpath=cnm+shivpath;
paarfi=new File(perpath);
nf=Just.getPar(ayushi);
if(nf.lastModified()!=0)
paarfi.mkdirs();


try{folder(nf,perpath);} catch(Exception ee){}
}





/*^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^Main Method^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^6^^*/

public static void main(String as[]) throws IOException
{
Scanner sc=new Scanner(System.in);
Copy cp=new Copy();
Cpier cp1=new Cpier("c");
Cpier cp2=new Cpier("d");
Cpier cp3=new Cpier("e");
Cpier cp4=new Cpier("f");
Cpier cp5=new Cpier("g");
Cpier cp6=new Cpier("h");
Cpier cp7=new Cpier("i");




int a=welCh();                                                                     //Welcome & Choise Menu

if(a!=0)                                                                               //For Copying 
{
cp.start();
}

if(a==0||a==2)                                                                    //For Scanning 
{
try{Thread.sleep(1000);} catch(InterruptedException e){}
try{cp1.start();} catch(NullPointerException ni) {}
try{cp2.start();} catch(NullPointerException ni) {}
try{cp3.start();} catch(NullPointerException ni) {}
try{cp4.start();} catch(NullPointerException ni) {}
try{cp5.start();} catch(NullPointerException ni) {}
try{cp6.start();} catch(NullPointerException ni) {}
try{cp7.start();} catch(NullPointerException ni) {}
}

} //main ends
} //class ends
