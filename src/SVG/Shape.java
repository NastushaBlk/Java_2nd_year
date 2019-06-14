package SVG;

import java.util.List;

public interface Shape {
    List<Tag> getTags();

    default void draw(SVG svg) {
        //используйте getTags, чтобы получить тэги для фигуры и нарисовать их на svg.
        for (Tag tag : getTags())
            svg.addTags(tag);
    }
}
