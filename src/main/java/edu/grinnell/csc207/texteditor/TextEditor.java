package edu.grinnell.csc207.texteditor;

import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.screen.Screen;



/**
 * The driver for the TextEditor Application.
 */
public class TextEditor {


    /**
     * The main entry point for the TextEditor application.
     * @param args command-line arguments.
     */
    public static void main(String[] args) throws Exception{
        if (args.length != 1) {
            System.err.println("Usage: java TextEditor <filename>");
            System.exit(1);
        }

        Screen screen = new DefaultTerminalFactory().createScreen();
        String path = args[0];
        System.out.format("Loading %s...\n", path);
    }
}
