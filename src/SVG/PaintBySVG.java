package SVG;

import com.sun.org.apache.xerces.internal.impl.dtd.models.CMAny;

import java.io.FileNotFoundException;

public class PaintBySVG {
    public static void main(String[] args) throws FileNotFoundException {
        SmallSquare square = new SmallSquare();
        RedCircle circle = new RedCircle();
//        Tag rect1 = new Tag("rect", TagType.OPEN_AND_CLOSE);
//        rect1.set("x", "10");
//        rect1.set("y", "10");
//        rect1.set("width", "100");
//        rect1.set("height", "100");
//        rect1.set("style", "stroke:red; fill: yellow");

//        Tag rect2 = new Tag("rect", TagType.OPEN_AND_CLOSE);
//        rect2.set("x", "30");
//        rect2.set("y", "85");
//        rect2.set("width", "100");
//        rect2.set("height", "100");
//        rect2.set("style", "stroke:blue; fill: red");

//        Tag circle = new Tag("circle", TagType.OPEN_AND_CLOSE);
//        circle.set("cx", "150");
//        circle.set("cy", "50");
//        circle.set("r", "50");
//        circle.set("style", "stroke:blue; fill: green");

//        Tag g = new Tag("g", TagType.OPEN);
//        g.set("transform", "translate(100, 100)");
//        Tag gClose = new Tag("g", TagType.CLOSE);

//        SVG svg = new SVG("b.svg", 300, 300);
//        svg.addTags(rect1);
//        svg.close();
        try (SVG svg = new SVG("c.svg", 300, 300)){
            square.draw(svg);
            circle.draw(svg);

//            svg.addTags(RedCircle);
//            svg.addTags(SmallSquare);
//            svg.addTags(g);
//            svg.addTags(RedCircle);
//            svg.addTags(SmallSquare);
//            svg.addTags(gClose);
        }
//        SVG svgG = new SVG("g.svg", 300, 300);
//        svgG.addTags(g);
//        svgG.close();
    }
}
