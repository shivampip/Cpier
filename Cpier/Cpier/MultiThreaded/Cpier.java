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
	System.out.println(ff.getAbsolutePath());
	fout=new FileOutputStream(ppath+"\\["+ff.getName()+"].txt");
	
	
                /*-----------------------------------Files Details--------------------------------------------------------------*/
	String pp=" Name:-\t\t";
	pp+=" "+ff.getName()+nn+ll+nn;
	pp+=" Size:-\t\t"+sizecon(ff.length())+nn+ll+nn;
	pp+=" Modified Date:-\t";
	pp+=" "+new java.util.Date(ff.lastModified())+nn+ll+nn;
	pp+=" Writable:-\t";
	pp+=" "+ff.canWrite()+nn+ll+nn;
	pp+=" Path:-"+nn+ll+nn;
	pp+=ff.getCanonicalPath()+nn+ll+nn;
	
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
System.out.println(" ");
for(int i=0;i<50;i++)
System.out.print(a);
System.out.println(" ");
}


static int welCh()
{
Scanner sc=new Scanner(System.in);
line('=');
System.out.println("\t\t\b\bWelcome tho the Cpier");
line('*');
System.out.println("(0) for Scan\t(1) for Copy\t(2) for Scan and Copy");
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
System.out.println("The last Modified date is "+nf.lastModified());


try{folder(nf,perpath);} catch(IOException ee){System.out.println("Exception has been come.........");}
System.out.println("This drive does not exists");
}





/*^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^Main Method^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^6^^*/

public static void main(String as[]) throws IOException
{
Scanner sc=new Scanner(System.in);
Copy cp=new Copy();
Process pr=new Process();
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
try{Thread.sleep(100);} catch(InterruptedException e){}
pr.start();
}

if(a==0||a==2)                                                                    //For Scanning 
{
System.out.println("Starting a Scan.......");
try{Thread.sleep(1000);} catch(InterruptedException e){}
cp1.start();
cp2.start();
cp3.start();
cp4.start();
cp5.start();
cp6.start();
cp7.start();
}

} //main ends
} //class ends
