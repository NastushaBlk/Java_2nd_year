package SVG;

import java.util.HashMap;
import java.util.Map;

public class Tag {
    private String name;
    private TagType tgt;

    public Map<String, String> rect = new HashMap<>();

    public Tag(String name, TagType tgt) {
        this.name = name;
        this.tgt = tgt;
    }

    public String getName() {
        return name;
    }

    public TagType getTgt() {
        return tgt;
    }

    public void set (String key, String value) {
        rect.put(key, value);
    }

    public Map<String, String> getMap() {
        return rect;
    }







}

