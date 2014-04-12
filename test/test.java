import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class test {

	public void test2(){
		String path="d:/process.xml";
//		System.out.println(System.currentTimeMillis());
		String tempString=path.substring(0,path.lastIndexOf("."));
		String tempString2=path.substring(path.lastIndexOf("."));
		System.out.println(tempString);
		System.out.println(tempString2);
//		Calendar calendar=Calendar.getInstance();
//		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		SimpleDateFormat simpleDateFormat2=new SimpleDateFormat("yyyyMMddhhmmss");
//		System.err.println(simpleDateFormat.format(new Date()));
//		System.err.println(simpleDateFormat2.format(new Date()));
		File file=new File("g:/processdefinition.xml");
		System.out.println(file.toString());
		System.out.println(file.getAbsolutePath());
	}
	public static void main(String[] args) {

	}
}
