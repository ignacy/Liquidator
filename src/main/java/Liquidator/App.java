package Liquidator;

import GUI.EditorGUI;
import Liquid.Context;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        Context context = new Context<String, String>();
        context.put("co", "tekst");
        context.put("gdzie", "po prawej stronie");


        new EditorGUI(context);
    }
}
