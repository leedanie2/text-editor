package edu.grinnell.csc207.texteditor;

import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.TerminalPosition;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * The driver for the TextEditor Application.
 */
public class TextEditor {

    public static void drawBuffer(GapBuffer buf, Screen screen) throws IOException{
        screen.clear();
        String str = buf.toString();
        for(int i = 0; i < str.length(); i++) {
            screen.setCharacter(0, i, TextCharacter.fromCharacter(str.charAt(i))[0]);
        }
        screen.setCursorPosition(new TerminalPosition(buf.getCursorPosition(), 0));
        screen.refresh();
    }


    /**
     * The main entry point for the TextEditor application.
     * @param args command-line arguments.
     */
    public static void main(String[] args) throws IOException{
        if (args.length != 1) {
            System.err.println("Usage: java TextEditor <filename>");
            System.exit(1);
        }

        Path path = Paths.get(args[0]);
        GapBuffer buf = new GapBuffer();

        if (Files.exists(path) && Files.isRegularFile(path)) {
            String contents = Files.readString(path);
            for (char c : contents.toCharArray()) {
                buf.insert(c);
            }
        }

        Screen screen = new DefaultTerminalFactory().createScreen();
        screen.startScreen();
        drawBuffer(buf, screen);

        boolean isRunning = true;
        while (isRunning) {
            KeyStroke stroke = screen.readInput();
            if (stroke.getKeyType() == KeyType.Escape) {
                isRunning = false;
            } else if (stroke.getKeyType() == KeyType.Character) {
                buf.insert(stroke.getCharacter());
            } else if (stroke.getKeyType() == KeyType.Backspace) {
                buf.delete();
            } else if (stroke.getKeyType() == KeyType.ArrowLeft) {
                try { buf.moveLeft(); } catch (IndexOutOfBoundsException e) { /* do nothing */ }
            } else if (stroke.getKeyType() == KeyType.ArrowRight) {
                try { buf.moveRight(); } catch (IndexOutOfBoundsException e) { /* do nothing */ }
            }
            drawBuffer(buf, screen);
        }

        screen.stopScreen();
        Files.writeString(path, buf.toString());
    }
}