package observer;

import java.util.Stack;

/**
 * This class provides a support for the UNDO operation to the StringBuilder Java api.
 * @author Jonatan Boritsky : 207254194,  Ilan Meyer Souffir : 342615648
 */
public class UndoableStringBuilder {
    // Private variables
    private StringBuilder strBuild; // Delegator to the standard StringBuilder of Java
    private Stack<String> operations; // FIFO list of all opposite operations to what were done

    /**
     * Constructs an undoable string builder by constructing default StringBuilder object
     */
    public UndoableStringBuilder() {
        this.strBuild = new StringBuilder();
        this.operations = new Stack<String>();
    }

    /**
     * This function delegate the append function from the standard StringBuilder of Java
     * @param str The string to append
     * @return UndoableStringBuilder object contains the string
     */
    public UndoableStringBuilder append(String str){
        String temp = this.strBuild.toString();
        this.strBuild.append(str);
        this.operations.push(temp);
        return this;
    }

    /**
     *This function delegate the delete function from the standard StringBuilder of Java
     * @param start - where we start to delete
     * @param end - where we end up deleting
     * @return UndoableStringBuilder object contains the string after deletion
     */
    public UndoableStringBuilder delete(int start, int end)  {
        String temp = this.strBuild.toString();
        try{
            this.strBuild.delete(start, end);
            this.operations.push(temp);
        }
        catch (StringIndexOutOfBoundsException e) {
            System.out.println(e);
        }
        return this;
    }

    /**
     * This function delegate the insert function from the standard StringBuilder of Java
     * @param offset - where we start to insert
     * @param str - the String that we want to insert
     * @return - The UndoableStringBuilder object with the inserted specified string
     */
    public UndoableStringBuilder insert(int offset, String str){
        String temp = this.strBuild.toString();
        try {
            this.strBuild.insert(offset, str);
            this.operations.push(temp);
        }
        catch (StringIndexOutOfBoundsException e) {
            System.out.println(e);
        }
        return this;
    }

    /**
     * This function delegate the replace function from the standard StringBuilder of Java
     * @param start - where we start to replace
     * @param end - where we end up replacing
     * @param str - the String that we want to write in the place
     * @return - The original UndoableStringBuilder object with the replaced substring
     */
    public UndoableStringBuilder replace(int start,int end, String str){
        String temp = this.strBuild.toString();
        try {
            this.strBuild.replace(start, end, str);
            this.operations.push(temp);
        }
        catch (StringIndexOutOfBoundsException e) {
            System.out.println(e);
        }
        catch (NullPointerException e){
            System.out.println(e);
        }
        return this;
    }

    /**
     * This function delegate the reverse function from the standard StringBuilder of Java
     * @return - The reverse of our String
     */
    public UndoableStringBuilder reverse() {
        this.operations.push(this.strBuild.toString());
        this.strBuild.reverse();
        return this;
    }

    /**
     * back to the previous step like (ctrl + z)
     */
    public void undo() {
        if(!this.operations.isEmpty()) {
            this.strBuild = new StringBuilder();
            this.strBuild.append(this.operations.pop());
        }
    }

    /**
     * Customised toString for UndoableStringBuilder
     * @return - A string of our object
     */
    @Override
    public String toString() {
        return strBuild.toString();
    }
}