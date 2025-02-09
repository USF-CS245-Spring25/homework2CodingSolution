import editor.TextEditor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TextEditorTest {
    private TextEditor editor;

    @BeforeEach
    void setUp() {
        editor = new TextEditor();
    }

    @Test
    void testAddText() {
        editor.addText("Hello");
        assertEquals("Hello", editor.getText());

        editor.addText(" World!");
        assertEquals("Hello World!", editor.getText());
    }

    @Test
    void testUndo() {
        editor.addText("Hello");
        editor.addText(" World!");
        editor.undo();
        assertEquals("Hello", editor.getText());

        editor.undo();
        assertEquals("", editor.getText());

        // nothing to undo
        editor.undo();
        assertEquals("", editor.getText());
    }

    @Test
    void testRedo() {
        editor.addText("Hello");
        editor.addText(" World!");
        editor.undo();
        editor.redo();
        assertEquals("Hello World!", editor.getText());

        // should do nothing
        editor.redo();
        assertEquals("Hello World!", editor.getText());
    }

    @Test
    void testRedoAfterNewEdit() {
        editor.addText("Hello");
        editor.addText(" World!");
        editor.undo();
        editor.addText(" Java"); // When we make a new edit, stack2 ('redo' stack) should be cleared
        editor.redo(); // nothing should happen when we redo after a new edit
        assertEquals("Hello Java", editor.getText());
    }

    @Test
    void testMultipleUndosAndRedos() {
        editor.addText("A");
        editor.addText("B");
        editor.addText("C");

        editor.undo();
        editor.undo();
        assertEquals("A", editor.getText());

        editor.redo();
        assertEquals("AB", editor.getText());

        editor.redo();
        assertEquals("ABC", editor.getText());
    }
}

