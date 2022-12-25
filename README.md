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
```




