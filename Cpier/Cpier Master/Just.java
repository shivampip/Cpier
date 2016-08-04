import java.io.File;
class Just
{


static File getPar(String a)
{
a.toUpperCase();
File pp=new File(a+":\\Ram").getParentFile();
return pp;
}


}