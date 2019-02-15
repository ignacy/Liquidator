package Liquid;

import java.util.HashMap;
import liqp.*;

public class Renderer {
    private String template;
    private HashMap context;

    public Renderer(String template, HashMap context) {
        this.template = template;
        this.context = context;
    }

    public String render() {
        Template liquidTemplate = Template.parse(template);
        return liquidTemplate.render(context);
    }
}
