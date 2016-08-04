import java.io.*;
import java.util.StringTokenizer;
class Process extends Thread
{
final static String nn=System.getProperty("line.separator");

static long size() throws Exception
{
FileInputStream ffin=new FileInputStream("copy.txt");
int ii=0;
String pa="";
while((ii=ffin.read())!=-1)
pa+=(char)ii;
ffin.close();
String ap=pa.replace('\\','/');

StringTokenizer sttr=new StringTokenizer(ap,nn);
int r=0;
String aap[]=new String[sttr.countTokens()];

// System.out.println("Number of Tokens is  "+sttr.countTokens());

while(sttr.hasMoreTokens())
{
aap[r]=sttr.nextToken();
r++;
}

long size=0;
for(String cp:aap)
{

File f=new File(cp);
size+=f.length();

//System.out.println("The path is "+cp);
//int lo=cp.lastIndexOf('/');
//String fnm=cp.substring(lo+1);
//System.out.println("\nThe file name is "+fnm);

}


return size;
}


public void run() 
{
try{long size=size();
pro(size);} catch(Exception e){}
System.out.println("");
line('"');
System.out.println(" \n File Successfully Copied.");
line('-');
try{Thread.sleep(2000);} catch(Exception e) {}
}


/*------------------------------------------Line-------------------------------------------------*/
static void line(char a)
{
for(int i=0;i<100;i++)
System.out.print(a);
}


static void pro(long ln) throws Exception
{
long lg=(long)(ln/4700);

line('_');
System.out.println("");
for(int i=0;i<100;i++)
{
for(int j=0;j<=i;j++)
System.out.print("#");

for(int k=99;k>i;k--)
System.out.print(" ");

System.out.print("["+(i+1)+"]% "+((lg/10)-((lg*(i+1))/1000))+ " sec left");
Thread.sleep(lg);
System.out.print("\r");
}
}




}

