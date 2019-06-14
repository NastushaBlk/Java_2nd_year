package SVG;

import java.util.ArrayList;
import java.util.List;

public class RedCircle implements Shape {
    private List<Tag> listTags = new ArrayList<>();

    public RedCircle() {
        Tag circle = new Tag("circle", TagType.OPEN_AND_CLOSE);
        circle.set("cx", "150");
        circle.set("cy", "50");
        circle.set("r", "30");
        circle.set("style", "stroke:blue; fill: green");

        listTags.add(circle);
    }

    @Override
    public List<Tag> getTags() {
        return listTags;
    }
}
