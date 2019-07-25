///**
// * Created by Nishant on Dec, 2018
// */
//import java.io.File;
//
//import javax.xml.parsers.DocumentBuilderFactory;
//
//import org.w3c.dom.CDATASection;
//import org.w3c.dom.Document;
//import org.w3c.dom.Element;
//
//public class CDATA {
//    public static void main(String[] argv) throws Exception {
//
//        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//        factory.setValidating(true);
//
//        factory.setExpandEntityReferences(false);
//
//        Document doc = factory.newDocumentBuilder().parse(new File("/Users/b0095748/filename"));
//        Element element = doc.getElementById("DocumentXML");
//
//        // Add a CDATA section to the root element
//        element = doc.getDocumentElement();
//        CDATASection cdata = doc.createCDATASection("data");
//        element.appendChild(cdata);
//
//    }
//}
