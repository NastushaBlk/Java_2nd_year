package SVG;

import java.util.ArrayList;
import java.util.List;

public class PositionedShape implements Shape{
    private Shape shape;
    private int x;
    private int y;
    private List<Tag> listTags = new ArrayList<>();

    public PositionedShape(Shape shape, int x, int y) {
        this.shape = shape;
        x = 100;
        y = 100;
    }

    public List<Tag> getTags() {
        Tag g = new Tag("g", TagType.OPEN);
        g.set("transform", "translate(" + x + ", " + y + ")");
        Tag gClose = new Tag("g", TagType.CLOSE);

        listTags.add(g);
        listTags.addAll(shape.getTags());
        listTags.add(gClose);

        return listTags;
    }
}
