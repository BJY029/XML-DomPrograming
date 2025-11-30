import java.io.File;
import java.util.Arrays;
import org.w3c.dom.Document;

public class FileData {
	//파일 경로
	public static String uri;
	//Document 객체 생성
	public static Document document;
	public static String mainXSD;
	
	//특정 폴더에서 .xml 파일을 읽어서 해당 파일 이름들을 배열로 반환하는 함수
	public static String[] getXMLFileLists() {
		File folder = new File("XMLFiles"); // source 폴더 경로

		String[] xmlFiles = folder.list((dir, name) -> name.toLowerCase().endsWith(".xml"));
		String[] xsdMain = folder.list((dir, name) -> name.toLowerCase().endsWith("main.xsd"));
		mainXSD = xsdMain[0];

		if(xmlFiles == null) System.out.println("null");
		if (xmlFiles != null) {
			Arrays.stream(xmlFiles).forEach(System.out::println);
		}
		
		return xmlFiles;
	}
	
	//현재 로드된 문서가 있는지 화인하는 함수
	public static boolean isLoaded()
	{
		if(FileData.document == null) {
			System.out.println("null document");
			return false;
		}
		else return true;
			
	}
}
