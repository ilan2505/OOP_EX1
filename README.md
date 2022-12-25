# OOP_2021_Ex1
Second Assignment in Object-oriented programming course in Java @Ariel_University_2022

# Authors :
* Boritsky Jonatan : 207254194
* Souffir Ilan Meir : 342615648

# Topic of the Assignment :
In this assignment we will add some more functionality to the UndoableStringBuilder which we built in the previous assignment (Matala 0).
We will add an option to organize a group of recipients of updates on the status of UndoableStringBuilder and send all updates to it in real time.
We need to use the Observer Design Pattern for this assignment.

# UML of the project :
<p align="center">
  <img align="center" width=100% src = ""/>
</p>

# Ex1 contains 2 Interfaces :
* Member.java
* Sender.java

# Ex1 contains 2 implementations :
* ConcreteMember.java : which is an implement of Member interface which describes the recipient of the updates (Observer).
* GroupAdmin.java : which is an implement of Sender interface which describes the sender of the updates (Observable).
 
# Ex1 contains also :
* UndoableStringBuilder.java : our class from the assignment 0.
* JvmUtilities.java
* Our tests in the test package : ConcreteMemberTest.java , GroupAdminTest.java , Tests.java (from the assignment).

# 1) ConcreteMember.java
This class is an implement of Member interface which describes the recipient of the updates (Observer) and contains a copy (copy sallow) of the shared UndoableStringBuilder. This class includes an update method to notify the member on the last change done to the UndoableStringBuilder.
The JUNIT test of this class is ConcreteMemberTest.java in OOP_EX1/src/test/java/observer/ConcreteMemberTest.java/

Objects of this class :
* private String name --> the name of the member
* private UndoableStringBuilder usb --> the copy of the shared UndoableStringBuilder
* private String lastChange --> the last change done to the UndoableStringBuilder
 
We are going to explains each methods :
* ConcreteMember(String name) --> Constructor (given name of the member).
* update(UndoableStringBuilder usb) --> Updates the member on the last change done to the UndoableStringBuilder.
 
# 2) GroupAdmin.java
This class is an implement of Sender interface, which describes the sender of the updates (Observable) and contains the states pool (UndoableStringBuilder)
This class includes a list of observers (members) who should receive updates on any change made to the data, the list of observers is implemented with a HashSet (because it's the better data structure when we compare the רuntime efficiency. The class includes methods to register and unregister observers, and contains calls to the UndoableStringBuilder methods.
The JUNIT test of this class is GroupAdminTest.java in OOP_EX1/src/test/java/observer/GroupAdminTest.java/

Objects of this class :
* private HashSet<Member> observers --> the list of observers (members)
* private UndoableStringBuilder usb --> the states pool (UndoableStringBuilder)

We are going to explains each methods :
* GroupAdmin(UndoableStringBuilder usb) --> Constructor (the states pool (UndoableStringBuilder)).
* register(Member obj) --> Registers a new observer (member) to the list of observers. Check if the observer is already in the list, if not, add it.
* unregister(Member obj) --> Unregisters an observer (member) from the list of observers. Check if the observer is in the list, if so, remove it.
* insert(int offset, String obj) --> Inserts the string into mutable characters sequence.
* append(String obj) --> Appends the required string to the mutable characters sequence.
* delete(int start, int end) --> Removes the characters from specified range of this sequence.
* undo() --> Come back to the previous state of the UndoableStringBuilder.
 
 
 



