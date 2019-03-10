package Liquidator;

import GUI.EditorGUI;
import Liquid.Context;

import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

public class App {
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        Context context = new Context<String, String>();
        context.put("co", "tekst");
        context.put("gdzie", "po prawej stronie");


        MetalLookAndFeel.setCurrentTheme(new OceanTheme());
        try  {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        }  catch(Exception e)  {
            System.err.println(e);
        }

        JFrame.setDefaultLookAndFeelDecorated(true);

        new EditorGUI(context);
    }
}
