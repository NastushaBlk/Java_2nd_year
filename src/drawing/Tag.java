package drawingSVG;

import java.util.HashMap;
import java.util.Map;

public class Tag {

    private Map<String, String> map = new HashMap<>();
    private String name;

    public Tag(String name){
        this.name = name;
    }

    public void set(String key, String value) {
        map.put(key, value);
    }

    public Map<String, String> getMap() {
        return map;
    }

    public String getName() {
        return name;
    }
}

/* 2. Класс Tag - это описание одного тега.
        Tag rect1 = new Tag("rect");
        rect1.set("x", "200");
        rect1.set("y", "200");
        rect1.set("width", "10");
        rect1.set("height", "20");
        rect1.set("style", "stroke:#ff0000; fill: #0000ff");
*/
