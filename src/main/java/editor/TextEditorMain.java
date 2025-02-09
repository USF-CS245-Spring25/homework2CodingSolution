package editor;

public class TextEditorMain {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        editor.addText("Hello! ");
        editor.addText("How are you? ");
        editor.addText("What are you up to these days? ");
        System.out.println(editor.getText());
        editor.undo();
        System.out.println("After undo: " + editor.getText());
        editor.redo();
        System.out.println("After redo: " + editor.getText());
        editor.undo();
        System.out.println("After undo: " + editor.getText());
        editor.undo();
        System.out.println("After undo: " + editor.getText());
        editor.addText("Nice weather! ");
        System.out.println("After a new edit: " + editor.getText());
        editor.redo(); // nothing should happen since we call redo() after making a new edit. Text does not change
        System.out.println("After redo: " + editor.getText());
        editor.undo();
        System.out.println("After undo: " + editor.getText());
        //System.out.println(editor.getText());
    }
}
