package editor;

import stack.ArrayStack;
import stack.Stack;

/** A text editor that is supposed to support operations such as
 * add text, undo and redo.
 */
public class TextEditor {
    private StringBuilder text;
    private Stack stack1;
    private Stack stack2;

    public TextEditor() {
        stack1 = new ArrayStack();
        stack2 = new ArrayStack();
        text = new StringBuilder();
    }

    public void addText(String edit) {
        text.append(edit);
        stack1.push(edit);
        while (!stack2.empty())
            stack2.pop();
    }

    public void undo() {
        if (!stack1.empty()) {
            String lastEdit = (String)stack1.pop();
            stack2.push(lastEdit);
            text.delete(text.length() - lastEdit.length(), text.length());
        }
    }

    public void redo() {
        if (!stack2.empty()) {
            String lastEdit = (String)stack2.pop();
            stack1.push(lastEdit);
            text.append(lastEdit);
        }
    }

    public String getText() {
        return text.toString();
    }

}
