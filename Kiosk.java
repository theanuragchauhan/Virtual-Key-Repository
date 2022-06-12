import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
public class Kiosk {
	
	//private static ArrayList<String> lst=new ArrayList<>();
	private static String dirPath="D:\\Tutorial\\ArrayList\\bin";
	
	public static void addFile()   {
		System.out.println("Enter file Name to add the file");
		Scanner sc = new Scanner(System.in);
		String s=sc.nextLine();
		File fileWithAbsolutePath = new File(dirPath + "/"+s+".txt");

		if(fileWithAbsolutePath.exists()) {
			System.out.println("file with the given name already exists");
			keyRepository();
			
		}
		else {
		//File.touch(fileWithAbsolutePath);
			try {
			fileWithAbsolutePath.createNewFile();
			}
			catch(Exception e) {System.out.println("file with the given name already exists");}
		//assertTrue(fileWithAbsolutePath.exists());
		System.out.println("File Added Successfully");
		keyRepository();
		
		
		
		
		}
	}
	public static void deleteFile() {
		System.out.println("Enter file Name to Delete");
		Scanner sc = new Scanner(System.in);
		String s=sc.nextLine();
		File file
        = new File(dirPath+"/"+s+".txt");

    if (file.delete()) {
        System.out.println("File deleted successfully");
        
    }
    else {
        System.out.println("Failed to delete the file");
        System.out.println("FileNot found");
		keyRepository();
    }
		

	}
	public static void searchFile() {
		System.out.println("Enter file Name to Search");
		Scanner sc = new Scanner(System.in);
		String s=sc.nextLine();
		File directory=new File(dirPath);
		int fileCount=directory.list().length;
	    System.out.println("File Count:"+fileCount);
	  //List of all files and directories
	    String contents[] = directory.list();
		for(String str: contents) {
			if(str.equals(s)) {
				System.out.println("File "+ s +" found");
				keyRepository();
			}
		}
		System.out.println("FileNot found");
		keyRepository();

	}
	
	public static void keyRepository() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Choose a Operation");
		System.out.println("1. Display file names");
		System.out.println("2.perform operation a.add file b.delete file c.search file");
		System.out.println("3. close application");
		
		try {
		Integer input= sc.nextInt();
		
	
		if(input==1) {
			showFiles();
			keyRepository();
		}
		else if(input==2){
			
			System.out.println("Which operation do you want to perform");
			String operation= sc.next();
			if(operation.equals("a")) {
				addFile();
			}
			else if(operation.equals("b")) {
				deleteFile();
			}
			else if(operation.equals("c")) {
				searchFile();
			}
			else {
				System.out.println("please select proper input from above");
			}
		}
		else if(input==3){
			closeApplication();
		}
		else {
			System.out.println("please select proper number from above");
			keyRepository();
		}
		
		 }
		
		catch(Exception e) {
	            System.out.println("It should be number");
	            keyRepository();
	        }
	}
	
	public static void showFiles() {
		File directory=new File(dirPath);
		int fileCount=directory.list().length;
	    System.out.println("File Count:"+fileCount);
	  //List of all files and directories
	      String contents[] = directory.list();
	      Arrays.sort(contents);
	      System.out.println("List of files and directories in the specified directory:");
	      for(int i=0; i<contents.length; i++) {
	         System.out.println(contents[i]);
	      }
	}
	
	public static void closeApplication() {
		System.exit(0);
		
	}

	//driving code
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to virtual key repository");
		//showFiles();
		keyRepository();
		
		
	

	}

}