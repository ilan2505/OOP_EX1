package observer;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.util.HashSet;

/**
 * This class is an implement of Sender interface, which describes the sender of the updates (Observable) .
 * This class contains the states pool (UndoableStringBuilder)
 * The class includes a list of observers (members) who should receive updates on any change made to the data.
 * The list of observers is implemented with a HashSet.
 * The class includes methods to register and unregister observers, and contains calls to the UndoableStringBuilder methods.
 * @author Jonatan Boritsky : 207254194,  Ilan Meyer Souffir : 342615648
 */

public class GroupAdmin implements Sender {
    private HashSet<Member> observers; // the list of observers (members)
    private UndoableStringBuilder usb; // the states pool (UndoableStringBuilder)

    /**
     * Constructor
     * @param usb - the states pool (UndoableStringBuilder)
     */
    public GroupAdmin(UndoableStringBuilder usb) {
        this.observers = new HashSet<Member>();
        this.usb = usb;
    }

    /**
     * This method registers a new observer (member) to the list of observers.
     * Check if the observer is already in the list, if not, add it.
     * @param obj - the new observer (member)
     */
    @Override
    public void register(Member obj) {
        if(this.observers.contains(obj)){
            System.out.println("This observer has already registered");
        }
        else{
            obj.update(usb);
            this.observers.add(obj);
        }
    }

    /**
     * This method unregisters an observer (member) from the list of observers.
     * Check if the observer is in the list, if so, remove it.
     * @param obj - the observer (member) to unregister
     */
    @Override
    public void unregister(Member obj) {
        if(this.observers.contains(obj)) {
            this.observers.remove(obj);
            obj.update(null);
        }
        else{
            System.out.println("This observer has not registered");
        }
    }

    /**
     * This method inserts the string into mutable characters sequence.
     * @param offset - the offset where we start to insert
     * @param obj - the string to insert
     */
    @Override
    public void insert(int offset, String obj) {
        this.usb.insert(offset, obj);
        for (Member obs : this.observers) {
            obs.update(this.usb);
        }
    }

    /**
     * This method appends the required string to the mutable characters sequence.
     * @param obj - the string to append
     */
    @Override
    public void append(String obj) {
        this.usb.append(obj);
        for (Member obs : this.observers) {
            obs.update(this.usb);
        }
    }

    /**
     * This method removes the characters from specified range of this sequence.
     * @param start - the start index of the substring to delete
     * @param end - the end index of the substring to delete
     */
    @Override
    public void delete(int start, int end) {
        this.usb.delete(start, end);
        for (Member obs : this.observers) {
            obs.update(this.usb);
        }
    }

    /**
     * The method come back to the previous state of the UndoableStringBuilder.
     */
    @Override
    public void undo() {
        this.usb.undo();
        for (Member obs : this.observers) {
            obs.update(this.usb);
        }
    }

    /**
     * The method come back to the list of members (observers) (for testing purpose).
     * @return - the list of members (observers)
     */
    public HashSet<Member> getObservers() {
        return observers;
    }

    /**
     * The method come back to the states pool (UndoableStringBuilder) (for testing purpose).
     * @return - the states pool (UndoableStringBuilder)
     */
    public UndoableStringBuilder getUsb() {
        return usb;
    }
}
