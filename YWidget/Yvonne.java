package YWidget;

import java.awt.*;
import java.awt.image.*;
import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.*;
import javax.xml.parsers.*;

import org.w3c.dom.*;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class Yvonne {

	public class ImgYvonne {
		public String thumb;
		public String image;
		
		public ImgYvonne(String t, String i) {
			this.thumb = t;
			this.image = i;
		}
		
		public String toString() {
			return "{t:'"+this.thumb+"',i:'"+this.image+"'}";
		}
	}
	
	private String linkUrl = "http://pics.mytrapster.com/yvonne-list.php";
	private ArrayList<ImgYvonne> pics = null;
	
	public Yvonne() throws Exception {
		try {
			String xml = this.LoadXML(linkUrl);
			this.pics = this.ParseXML(xml);
		}
		catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	public BufferedImage RandomPic() throws Exception{
		try {
			BufferedImage t_img = ImageIO.read(new URL(this.RandomUrl().thumb));
			return t_img;
		} catch (Exception e) {
			throw new Exception(e);
		}		
	}
	
	private ImgYvonne RandomUrl() {
		Random r = new Random();
		return pics.get(r.nextInt(this.pics.size() - 1));
	}
	
	// Copypasta: http://stackoverflow.com/questions/4328711/read-url-to-string-in-few-lines-of-java-code
	private String LoadXML(String url) throws Exception {
		URL website = new URL(url);
		URLConnection connection = website.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		StringBuilder response = new StringBuilder();
		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		return response.toString();
	}
	
	
	private ArrayList<ImgYvonne> ParseXML(String xml) throws ParserConfigurationException, SAXException, Exception {
		ArrayList<ImgYvonne> pics = new ArrayList<ImgYvonne>();
		
		InputSource is = new InputSource(new StringReader(xml));
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder builder = factory.newDocumentBuilder();
	    Document doc = builder.parse(is);
	    
	    NodeList nodeList = doc.getDocumentElement().getChildNodes();
	    
	    for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
            	Element elem = (Element) node;
            	
            	String t = elem.getElementsByTagName("thumb").item(0).getChildNodes().item(0).getNodeValue();
            	String f = elem.getElementsByTagName("full").item(0).getChildNodes().item(0).getNodeValue();
            	
            	pics.add(new ImgYvonne(t, f));
            }
	    }
	    
	    if (pics.isEmpty()) { throw new Exception("No images"); }
	    
		return pics;
	}
}
