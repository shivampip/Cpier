import java.io.*;
import java.util.StringTokenizer;

class Copy extends Thread
{
final static String nn=System.getProperty("line.separator");

public void run() 
{
try {copy();} catch(IOException ee){}
}

static void copy() throws IOException
{
File ff=new File("CpierOutput");
ff.mkdir();

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


while(sttr.hasMoreTokens())
{
aap[r]=sttr.nextToken();
r++;
}

for(String cp:aap)
{


int lo=cp.lastIndexOf('/');
String fnm=cp.substring(lo+1);

FileInputStream fin=new FileInputStream(cp);
FileOutputStream fout=new FileOutputStream("CpierOutput\\"+fnm);

ii=0;
while((ii=fin.read())!=-1)
fout.write(ii);
}
}


}