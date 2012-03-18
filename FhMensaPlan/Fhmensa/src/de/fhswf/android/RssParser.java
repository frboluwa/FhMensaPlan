package de.fhswf.android;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class RssParser {

	String surl = "http://www-in.fh-swf.de/stwdo/rss.php/Ha-FH";

	public RssParser() {
		// TODO Auto-generated constructor stub
	}

	public void getLatestArticles(String eUrl) throws Exception {

		String url = eUrl;
		System.out.println("URL " + url);
		SAXReader reader = new SAXReader();
		reader.setStripWhitespaceText(true);
		reader.setMergeAdjacentText(true);
		reader.setEncoding("iso-8859-1");

		URL rssFeed = new URL(url);

		Document document = reader.read(rssFeed);

		parseDocumentToJson(document);

	}

	private void parseDocumentToJson(Document eDocument) {
		Document document = eDocument;
		Element rootElement = document.getRootElement();
		String title = rootElement.element("title").getText();
		System.out.println("Titel " + title);
		Element elem;
		List<Element> infoList = new ArrayList<Element>();
		for (Iterator<Element> iter = rootElement.elementIterator(); iter
				.hasNext();) {
			elem = (Element) iter.next();
			infoList.add(elem);
			System.out.println(elem.getName());
		}
		
	}
}
