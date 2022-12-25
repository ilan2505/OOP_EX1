package observer;

/**
 * this class is an implement of Member interface which describes the recipient of the updates (Observer).
 * The class contains a copy (copy sallow) of the shared UndoableStringBuilder.
 * This class includes an update method to notify the member on the last change done to the UndoableStringBuilder.
 * @author Jonatan Boritsky : 207254194,  Ilan Meyer Souffir : 342615648
 */

public class ConcreteMember implements Member {
    private String name; // the name of the member
    private UndoableStringBuilder usb; // the copy of the shared UndoableStringBuilder
    private String lastChange; // the last change done to the UndoableStringBuilder

    /**
     * Constructor
     * @param name - Given name of the member
     */
    public ConcreteMember(String name) {
        this.name = name;
        this.lastChange = "";
    }

    /**
     * This method updates the member on the last change done to the UndoableStringBuilder.
     * @param usb - the shared UndoableStringBuilder
     */
    @Override
    public void update(UndoableStringBuilder usb) {
        //System.out.println("Member " + this.name + " was notified of the change: " + this.lastChange + " -> " + usb.toString());
        this.usb = usb;
        if (usb != null) {
            this.lastChange = usb.toString();
        }
    }

    /**
     * This method returns the name of the member (for testing purpose).
     * @return the name of the member
     */
    public String getName() {
        return name;
    }

    /**
     * This method returns the UndoableStringBuilder (for testing purpose).
     * @return - the UndoableStringBuilder
     */
    public UndoableStringBuilder getUsb() {
        return usb;
    }

    /**
     * This method returns the last change done to the UndoableStringBuilder (for testing purpose).
     * @return - the last change done to the UndoableStringBuilder
     */
    public String getLastChange() {
        return lastChange;
    }
}
