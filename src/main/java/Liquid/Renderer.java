package Liquid;

import java.util.HashMap;
import liqp.*;

/*
 * Klasa odpowiedzialna za połączenie kontekstu (wartości dla szablonu),
 * oraz szablonu i utworzenie postaci wynikowej.
 */
public class Renderer {
    private String template;
    private HashMap context;

    public Renderer(String template, HashMap context) {
        this.template = template;
        this.context = context;
    }

    public String render() throws LiquidException {
        try {
            Template liquidTemplate = Template.parse(template)
                    .withRenderSettings(new RenderSettings.Builder().withStrictVariables(true).build());
            return liquidTemplate.render(context);
        } catch (RuntimeException ex) {
            throw new LiquidException(ex.getMessage());
        }
    }
}
