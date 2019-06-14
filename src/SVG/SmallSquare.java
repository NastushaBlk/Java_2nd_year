package SVG;

import java.util.ArrayList;
import java.util.List;

public class SmallSquare implements Shape {
    private List<Tag> listTags = new ArrayList<>();

    public SmallSquare() {
        Tag rect1 = new Tag("rect", TagType.OPEN_AND_CLOSE);
        rect1.set("x", "10");
        rect1.set("y", "10");
        rect1.set("width", "90");
        rect1.set("height", "90");
        rect1.set("rx", "20");
        rect1.set("ry", "20");
        rect1.set("style", "stroke:red; fill: yellow");

        Tag rect2 = new Tag("rect", TagType.OPEN_AND_CLOSE);
        rect2.set("x", "30");
        rect2.set("y", "85");
        rect2.set("width", "50");
        rect2.set("height", "80");
        rect2.set("style", "stroke:black; fill: red");

        listTags.add(rect1);
        listTags.add(rect2);
    }

    @Override
    public List<Tag> getTags() {
        return listTags;
    }
}
