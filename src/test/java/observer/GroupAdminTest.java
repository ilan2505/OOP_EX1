package observer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class GroupAdminTest {

    public static final Logger logger = LoggerFactory.getLogger(GroupAdminTest.class);


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void register() {
        logger.info(()->"JVM info: " + JvmUtilities.jvmInfo());
        final int NUM_OF_MEMBERS = 10000;
        UndoableStringBuilder usb = new UndoableStringBuilder();
        ConcreteMember[] members = new ConcreteMember[NUM_OF_MEMBERS];
        for (int i = 0; i < members.length; i++) {
            members[i] = new ConcreteMember("Member no. " + i);
        }

        GroupAdmin groupAdmin = new GroupAdmin(usb);

        logger.info(()->"groupAdmin is now created, the total size of the groupAdmin is: " + JvmUtilities.objectTotalSize(groupAdmin));
        logger.info(()->JvmUtilities.objectFootprint(groupAdmin));
        for (Member member : members) {
            groupAdmin.register(member);
        }

        for (int i=0; i<NUM_OF_MEMBERS; i++) {
            ConcreteMember currMember = members[i];
            assertAll(() -> assertEquals(currMember.getLastChange(), ""),
                        () -> assertEquals(currMember.getUsb(),  usb));
        }

        logger.info(()->"After registering all members, the total size of the groupAdmin is: " + JvmUtilities.objectTotalSize(groupAdmin));
        logger.info(()->JvmUtilities.objectFootprint(groupAdmin));

        // now we register a member again
        groupAdmin.register(members[0]);

        if (groupAdmin.getObservers().size() != NUM_OF_MEMBERS){
            logger.error(()->"Duplicate member registered!");
            fail();
        }

        // now we register a member again, but this time we use a new member
        ConcreteMember newMember = new ConcreteMember("New Member");
        groupAdmin.register(newMember);

        if (groupAdmin.getObservers().size() != NUM_OF_MEMBERS+1){
            logger.error(()->"New member not registered!");
            fail();
        }

        logger.info(()->"JVM info: " + JvmUtilities.jvmInfo());
        System.out.println("-----------------------------------------------------------------------------------------"+System.lineSeparator());
    }

    @Test
    void unregister() {
        logger.info(()->"JVM info: " + JvmUtilities.jvmInfo());
        final int NUM_OF_MEMBERS = 10000;
        UndoableStringBuilder usb = new UndoableStringBuilder();
        ConcreteMember[] members = new ConcreteMember[NUM_OF_MEMBERS];
        for (int i = 0; i < members.length; i++) {
            members[i] = new ConcreteMember("Member no. " + i);
        }

        GroupAdmin groupAdmin = new GroupAdmin(usb);

        logger.info(()->"groupAdmin is now created, the total size of the groupAdmin is: " + JvmUtilities.objectTotalSize(groupAdmin));
        logger.info(()->JvmUtilities.objectFootprint(groupAdmin));
        for (Member member : members) {
            groupAdmin.register(member);
        }

        logger.info(()->"After registering all members, the total size of the groupAdmin is: " + JvmUtilities.objectTotalSize(groupAdmin));
        logger.info(()->JvmUtilities.objectFootprint(groupAdmin));

        // now we unregister a member
        groupAdmin.unregister(members[0]);
        assertFalse(groupAdmin.getObservers().contains(members[0]));

        // now we unregister a member again
        groupAdmin.unregister(members[0]);
        assertAll(() -> assertFalse(groupAdmin.getObservers().contains(members[0])),
                () -> assertEquals(groupAdmin.getObservers().size(), NUM_OF_MEMBERS-1));

        // now we unregister a member again, but this time we use a new member
        ConcreteMember newMember = new ConcreteMember("New Member");
        groupAdmin.unregister(newMember);
        assertEquals(groupAdmin.getObservers().size(), NUM_OF_MEMBERS-1);

        for (int i = 0; i < NUM_OF_MEMBERS - 1; i++) {
            groupAdmin.unregister(members[i + 1]);
        }

        logger.info(()->"After unregistering all members, the total size of the groupAdmin is: " + JvmUtilities.objectTotalSize(groupAdmin));
        logger.info(()->JvmUtilities.objectFootprint(groupAdmin));


        assertEquals(groupAdmin.getObservers().size(), 0);

        //now we unregister a member again from empty groupAdmin
        groupAdmin.unregister(newMember);
        assertEquals(groupAdmin.getObservers().size(), 0);
        logger.info(()->"JVM info: " + JvmUtilities.jvmInfo());
        System.out.println("-----------------------------------------------------------------------------------------"+System.lineSeparator());
    }

    @Test
    void insert() {
    }

    @Test
    void append() {
    }

    @Test
    void delete() {
    }

    @Test
    void undo() {
    }
}