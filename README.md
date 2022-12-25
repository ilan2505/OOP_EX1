# OOP_EX1

## About

## Getting Started
### Dependencies

* ``JAVA`` JDK 19.0.1
* ``JUNIT`` Jupiter 5.9.0
* ``Maven`` Apache Maven 3.8.1
* ``JOL`` Java Object Layout 0.14
* ``JUnit Platform Launcher`` 1.4.0

**_NOTE:_**  You can just use the ``pom.xml`` file to download all dependencies (except for Maven itself)

### IDE platform
* ``IntelliJ IDEA`` 2021.1.1 (Community Edition)

### Installing
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
8. You can also see the results of the tests in command line under this print:
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
???? 25, 2022 2:14:21 ????? observer.GroupAdminTest register
INFO: After registering all members, the total size of the groupAdmin is: Total Memory = 1585824
???? 25, 2022 2:14:23 ????? observer.GroupAdminTest register
INFO: Address = observer.GroupAdmin@20d28811d footprint:
     COUNT       AVG       SUM   DESCRIPTION
     20001        24    480032   [B
         1        56        56   [Ljava.lang.Object;
         1     65552     65552   [Ljava.util.HashMap$Node;
         1        16        16   java.lang.Object
     20000        24    480000   java.lang.String
         1        24        24   java.lang.StringBuilder
         1        48        48   java.util.HashMap
     10000        32    320000   java.util.HashMap$Node
         1        16        16   java.util.HashSet
         1        32        32   java.util.Stack
     10000        24    240000   observer.ConcreteMember
         1        24        24   observer.GroupAdmin
         1        24        24   observer.UndoableStringBuilder
     60010             1585824   (total)
This observer has already registered
???? 25, 2022 2:14:23 ????? observer.GroupAdminTest register
INFO: JVM info: PID= 18252, Total Memory = 220200960, Available Cores = 4
...
...
...
...
...
```




