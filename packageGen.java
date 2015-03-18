import java.io.File;
import java.nio.file.*;
import java.io.IOException;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class packageGen {

    static Map <String, ArrayList<String>> fileDirectory = new HashMap<>();
    static Set<String> suffixes = packageHelper.suffixHelper();
    static Set<String> directoryNames = packageHelper.directoryNameHelper();
    static Map<String, String> directoryMapping = packageHelper.directoryMappingHelper();

    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Probably added too many args, try again");
            System.exit(0);
        }

        PrintFiles pf = new PrintFiles();
        Path startingDir = Paths.get(args[0]);

        if (Files.exists(startingDir)) {

            try {
                Files.walkFileTree(startingDir, pf);
            } catch (Exception e) {
                System.out.println("An error has occured while scanning the directory: " + e);
            }
            try {
                generateXML();
            } catch (Exception e) {
                System.out.println("Error generating the XML File: " + e);
            }

        } else {
            System.out.println("Invalid file path, try again");
            System.exit(0);
        }

    }

    private static void generateXML() {
        DocumentBuilderFactory icFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder icBuilder;

        try {

            icBuilder = icFactory.newDocumentBuilder();
            Document doc = icBuilder.newDocument();
            Element mainRootElement = doc.createElementNS("http://soap.sforce.com/2006/04/metadata", "Package");
            doc.appendChild(mainRootElement);

            for (Map.Entry<String, ArrayList<String>> entry : fileDirectory.entrySet()) {
                String key = entry.getKey();
                ArrayList<String> value = entry.getValue();
                Element types = doc.createElement("types");
                mainRootElement.appendChild(types);

                for (String s: value) {
                    Element members = doc.createElement("members");
                    types.appendChild(members);
                    members.setTextContent(s);
                }

                Element name = doc.createElement("name");
                types.appendChild(name);
                name.setTextContent(key);


            }

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("package.xml"));
            transformer.transform(source, result);

            System.out.println("\nXML DOM Created Successfully..");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class PrintFiles extends SimpleFileVisitor<Path> {

        // Print information about
        // each type of file.
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {
            String[] filename = file.getFileName().toString().split("\\.", 2);
            String directoryName = file.getName(file.getNameCount() - 2).toString();
            String mappedDirectory = directoryMapping.get(directoryName);

            if (attr.isRegularFile() && suffixes.contains(filename[1])) {

                if (!fileDirectory.containsKey(directoryMapping.get(directoryName))) {
                    fileDirectory.put(mappedDirectory, new ArrayList<>());
                } else {
                    fileDirectory.get(directoryMapping.get(directoryName)).add(filename[0]);
                }
            }

            return FileVisitResult.CONTINUE;
        }

        // Print each directory visited.
        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) {

            if (!directoryNames.contains(dir)) {
                return FileVisitResult.SKIP_SUBTREE;
            } else {
                System.out.format("Directory: %s%n", dir);
                return FileVisitResult.CONTINUE;
            }
        }

        // If there is some error accessing
        // the file, let the user know.
        // If you don't override this method
        // and an error occurs, an IOException
        // is thrown.
        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) {
            System.err.println(exc);
            return FileVisitResult.CONTINUE;
        }
    }
}
