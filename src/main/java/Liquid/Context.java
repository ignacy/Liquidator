package Liquid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Context extends HashMap<String, String> {

    public String[][] asTableContents() {
        String[][] contents = new String[this.keySet().size()][2];

        int index = 0;

        for (String key : this.keySet()) {
            contents[index][0] = key;
            contents[index][1] = this.get(key);
            index++;
        }

        return contents;
    }
}
