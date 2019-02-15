package Liquidator;

import GUI.EditorGUI;
import Liquid.Renderer;

import javax.swing.*;
import java.util.HashMap;

public class App {
    public static void main(String[] args) {

        JFrame.setDefaultLookAndFeelDecorated(true);
        new EditorGUI();

        HashMap context = new HashMap<String, String>();
        context.put("name", "WORLD");
        Renderer view = new Renderer("Hi there {{ name }}!", context);
        System.out.println(view.render());
    }
}
