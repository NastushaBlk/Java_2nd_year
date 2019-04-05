package drawingSVG;

public class drawSVG {
    public static void main(String[] args) {

        Tag rect1 = new Tag("rect");
        rect1.set("x", "200");
        rect1.set("y", "200");
        rect1.set("width", "10");
        rect1.set("height", "20");
        rect1.set("style", "stroke:#ff0000; fill: #0000ff");

        SVG svg = new SVG("a.svg", 300, 300);
        svg.addTags(rect1);
//        svg.addTags(rect2);
//        svg.close();
    }
}
