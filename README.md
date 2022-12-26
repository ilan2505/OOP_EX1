# OOP_2021_Ex1
Second Assignment in Object-oriented programming course in Java @Ariel_University_2022

# Authors :
* Boritsky Jonatan : 207254194
* Souffir Ilan Meir : 342615648

# Dependencies

* ``JAVA`` JDK 19.0.1
* ``JUNIT`` Jupiter 5.9.0
* ``Maven`` Apache Maven 3.8.1
* ``JOL`` Java Object Layout 0.14
* ``JUnit Platform Launcher`` 1.4.0

**_NOTE:_**  You can just use the ``pom.xml`` file to download all dependencies (except for Maven itself)

### IDE platform
* ``IntelliJ IDEA`` 2021.1.1 (Community Edition)

# Topic of the Assignment :
In this assignment we will add some more functionality to the UndoableStringBuilder which we built in the previous assignment (Matala 0).
We will add an option to organize a group of recipients of updates on the status of UndoableStringBuilder and send all updates to it in real time.
We need to use the Observer Design Pattern for this assignment.

# UML of the project :
<p align="center">
  <img align="center" width=80% src = "https://user-images.githubusercontent.com/55143087/209473572-de7a35b5-0b2f-4bad-8bb0-a2f3dc9abccc.png"/>
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

# How to run ? (Installing)
For Windows OS:  
1. Make sure you have git installed on your machine
2. Download the project from GitHub
```
$ git clone https://github.com/ilan2505/OOP_EX1.git
```
3. Download Apache Maven from [here](https://maven.apache.org/download.cgi)
4. Add a new system variable named ``MAVEN_HOME`` and set its value to the path of your Maven installation directory
   * Add New System variable for example directory: ``C:\Program Files\apache-maven-3.8.1``
   ```
    MAVEN_HOME = C:\Program Files\apache-maven-3.8.1
    ```
   * Add ``%MAVEN_HOME%\bin`` to the ``PATH`` variable
    ```
     PATH = %MAVEN_HOME%\bin
    ```
5. Open the command line as an **administrator** and navigate to the project folder.
6. Run the following command to build the project using ``Maven``:
```
$ mvn clean test
```
7. If the build was successful, you should see the following output:
```
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  10.470 s
[INFO] Finished at: 2022-12-25T09:42:09+02:00
[INFO] ---------------------------------
```
8. You can also see the results of the tests in command line:
```
-------------------------------------------------------
 T E S T S
----------------------------------------------------------------------------------------------------
Running observer.ConcreteMemberTest
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.149 sec - in observer.ConcreteMemberTest
Running observer.GroupAdminTest
???? 25, 2022 2:14:17 ????? observer.GroupAdminTest register
INFO: JVM info: PID= 18252, Total Memory = 132120576, Available Cores = 4
# WARNING: Unable to attach Serviceability Agent. You can try again with escalated privileges. Two options: a) use -Djol.tryWithSudo=true to try with sudo; b) echo 0 | sudo tee /proc/sys/kernel/yama/ptrace_scope
???? 25, 2022 2:14:19 ????? observer.GroupAdminTest register
INFO: groupAdmin is now created, the total size of the groupAdmin is: Total Memory = 256
???? 25, 2022 2:14:19 ????? observer.GroupAdminTest register
INFO: Address = observer.GroupAdmin@20d28811d footprint:
     COUNT       AVG       SUM   DESCRIPTION
         1        32        32   [B
         1        56        56   [Ljava.lang.Object;
         1        24        24   java.lang.StringBuilder
         1        48        48   java.util.HashMap
         1        16        16   java.util.HashSet
         1        32        32   java.util.Stack
         1        24        24   observer.GroupAdmin
         1        24        24   observer.UndoableStringBuilder
         8                 256   (total)
...
```

 # Results for the test of GroupAdmin 
```
-------------------------------------------------------------------------------
Test set: observer.GroupAdminTest
-------------------------------------------------------------------------------
Tests run: 6, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 24.413 sec - in observer.GroupAdminTest

```
 
 # Results for the test of ConcretMember 
 



