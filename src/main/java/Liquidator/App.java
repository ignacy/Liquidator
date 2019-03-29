package Liquidator;

import GUI.EditorGUI;

import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

/**
 * Punk wejściowy programu, uruchamia edytor.
 */
public class App {
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        MetalLookAndFeel.setCurrentTheme(new OceanTheme());
        try  {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        }  catch(Exception e)  {
            System.err.println("Problem z ustawieniem look and feel: " + e);
        }
        new EditorGUI();
    }
}
