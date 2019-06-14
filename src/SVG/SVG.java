package SVG;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Map;

public class SVG implements AutoCloseable {
    private String file;
    private int width;
    private int height;
    private PrintStream printSvg;

    public SVG(String file, int width, int height) throws FileNotFoundException {
        this.file = file;
        this.width = width;
        this.height = height;
        printSvg = new PrintStream(file);
        printSvg.println(String.format("<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"%d\" height=\"%d\">", width, height));
    }

    public void addTags(Tag tag) {
        TagType chooseTag = tag.getTgt();
        //printSvg = new PrintStream(file);


        Map<String, String> rect = tag.getMap();
        String props = "";

        for (String key : rect.keySet()){
            props += " " + key + "=" + "\"" + rect.get(key) + "\"";
        }
        //printSvg.print("<" + tag.getName() + props + "/>\n");

        if (chooseTag == TagType.OPEN)
            printSvg.print("<" + tag.getName() + props + ">\n");

        if (chooseTag == TagType.CLOSE)
            printSvg.print("</" + tag.getName() + props + ">\n");

        if (chooseTag == TagType.OPEN_AND_CLOSE)
            printSvg.print("<" + tag.getName() + props + "/>\n");

    }

    @Override
    public void close() {
        printSvg.print("</svg>");
        printSvg.close();
    }
}



