import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class Utils
{
  public static String readFile(String filename)throws Exception{
	  String data = "";
	  data = new String(Files.readAllBytes(Paths.get(filename)));
	  return data;
  }  
  
  public static void loadTitles() throws Exception
  {
   String data = readFile("/Users\\FAMILY\\eclipse-workspace\\Bookstore\\src\\Book.text");
   System.out.println("We have the following Terry McMillin Books Avaialable ");
   System.out.println(data);
}
}

