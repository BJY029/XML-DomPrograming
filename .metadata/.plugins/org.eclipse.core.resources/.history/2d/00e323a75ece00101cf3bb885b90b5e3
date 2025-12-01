import org.w3c.dom.*;
import org.w3c.dom.Document;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSSerializer;
import java.io.*;

import javax.swing.JOptionPane;

public class SaveFile {
	public static void saveFile() {
		if (!FileData.isLoaded()) {
			JOptionPane.showMessageDialog(null, "No files have been loaded, please load the files first.", "ERROR",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		try {
			StringWriter stringOut = new StringWriter();

			DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
			DOMImplementationLS impl = (DOMImplementationLS)registry.getDOMImplementation("LS");
			LSSerializer writer = impl.createLSSerializer();
			
			LSOutput output = impl.createLSOutput();
			output.setCharacterStream(stringOut);
			output.setEncoding("UTF-8");
			
			writer.getDomConfig().setParameter("format-pretty-print", true);
			writer.write(FileData.document, output);
			
			String uri = FileData.uri;
			FileWriter fw = new FileWriter(uri);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(output.getCharacterStream().toString());
			bw.close();
			
			JOptionPane.showMessageDialog(null, "success to save : " + uri);
			FileData.uri = null;
			FileData.document = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
