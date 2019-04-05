package drawingSVG;

import java.io.PrintStream;

public class SVG {

    private String properties;
    private PrintStream out;
    private String nameOfSVG;
    private int height;
    private int width;

    public SVG(String nameOfSVG, int width, int height) {
        this.nameOfSVG = nameOfSVG;
        this.width = width;
        this.height = height;
        properties = "<svg  xmlns=\"http://www.w3.org/2000/svg\" " +
                "width=\"" + width + "\"" +
                "height=\"" + height + "\"> ";
    }

    public void addTags(Tag tag) {

    }
//
//    public void close() {
//        out.println("</svg>");
//    }
}

/* 1. Вспомогательные классы для рисования SVG
    Класс SVG, содержит открытый PrintStream для печати SVG:
        SVG svg = new SVG("a.svg", 300, 300);
        svg.addTags(rect1);
        svg.addTags(rect2);
        svg.close();
    В конце обязательно будет вызвано закрытие, чтобы закрыть PrintStream
*/
