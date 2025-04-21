package my_code;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.util.ArrayList;
import java.util.Collection;

public class FoldersXML {
    public static Collection<String> folderNames(String xml, char startingLetter) throws Exception {
        Collection<String> folderNames = new ArrayList<>(); // Liste pour stocker les noms

        // Créer un parseur XML
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new java.io.ByteArrayInputStream(xml.getBytes("UTF-8")));

        // Trouver tous les éléments "folder"
        NodeList folders = document.getElementsByTagName("folder");
        
        for (int i = 0; i < folders.getLength(); i++) {
            Element folder = (Element) folders.item(i);
            String name = folder.getAttribute("name"); // Récupérer le nom

            // Vérifier si le nom commence par la lettre spécifiée
            if (name.toLowerCase().charAt(0) == Character.toLowerCase(startingLetter)) {
                folderNames.add(name); // Ajouter à la liste
            }
        }

        return folderNames; // Retourner la liste des noms
    }
    
    public static void main(String[] args) throws Exception {
        String xml =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<folder name=\"c\">" +
                    "<folder name=\"program files\">" +
                        "<folder name=\"uninstall information\" />" +
                    "</folder>" +
                    "<folder name=\"users\" />" +
                "</folder>";

        Collection<String> names = folderNames(xml, 'u'); // Appeler la méthode
        for (String name : names) {
            System.out.println(name);  // Afficher les noms trouvés
        }
    }
}
