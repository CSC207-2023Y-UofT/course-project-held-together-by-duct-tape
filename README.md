# Course Simulator
The program is a course simulator where users can create and take different courses and get evaluated for them. We chose to create this program as it felt relevant as we are all students and the subject matter felt familiar! Moreover, the program can be used as a way for students to create quizzes that they can test themselves for upcoming assessments with that allows them to monitor how they progress.
The Tests cover 76% of all components but this includes portions that we would not be testing below is a picture showing the coverage of our tests:


<img width="628" alt="image" src="images/test_coverage.jpg">


#Set up (Windows)

In order to set up the databases on Windows use this link (https://dev.mysql.com/downloads/mysql/) and 


<img width="544" alt="image" src="https://github.com/CSC207-2023Y-UofT/course-project-held-together-by-duct-tape/assets/133050886/956cfa37-d5aa-4130-9ad5-66cdd0f29650">



download the version above all the default settings that the installer provides ensuring that the configuration is typical and when it asks for a root password please type 
coursesimgroup. After you have successfully installed the server login to the mysQl command  using the root password and carry out the commands (press enter after each semicolon). To install on mac, first, go to https://dev.mysql.com/downloads/mysql/ or search MySQL Community Server.

Choose the operating system as MacOS, then select the OSVersion. If you are using MacBook M1 or M2, choose the ARM, if you are using MacBook Intel, Choose x86.

<img width="347" alt="image" src="https://github.com/CSC207-2023Y-UofT/course-project-held-together-by-duct-tape/assets/133050886/2d96e065-58d0-4b5a-8d2d-ca48f257c425">

Second, open the download package, (if the Mac says the program can not be authenticated， just open the setting->Security and privacy->allow the file to install.)
After installation is successful, if you did everything in the instructions, you can open the setting on MacBook now, and you will see a cute dolphin and two green dots.
Finally, activate your MySQL. Go to terminal to type: mysql -u root -p
If there is an error like: “zsh:command not found: mysql”
Just type: alias mysql=/user/local/mysql/bin/mysql
Then re-enter: mysql -u root -p, enter your password (coursesimgroup).
Tip, you can use terminal to operate MySQL, or you can choose to download MySQL Workbench(to download workbench are pretty easy, just go to the MySQL website and choose your version of workbench, install it as other normal apps.)

<img width="290" alt="image" src="https://github.com/CSC207-2023Y-UofT/course-project-held-together-by-duct-tape/assets/133050886/62a0ffd5-a552-4727-a456-ca0101e7c13a">

## Commands (In Order):
Note: only perform these commands in MySQL if the files do not work.

- Create database course_simulator;

- use course_simulator;

- create table students (StudentID Varchar(25), Password Varchar(25), CourseID Varchar(25), CourseGrade float);

- create table courses (CourseID Varchar(25), PrerequisiteCourseID Varchar(25), PrerequisiteGrade float, Question Varchar(250), Answer Varchar(250), Points int);

- create table sessioncourse (CourseID Varchar(25), Question Varchar(250), Answer Varchar(250), Points int);

- create table sessionstudent (StudentID Varchar(25), Password Varchar(25), CourseID Varchar(25), CourseGrade float);

- Show tables;  (use this command to confirm that the above tables were made successfully!)

![image](https://github.com/CSC207-2023Y-UofT/course-project-held-together-by-duct-tape/assets/133050886/e2a3341e-1f98-408f-a854-be762390c056)


This is a course simulator in which the user can pick between an instructor mode and a student mode. 


<img width="392" alt="image" src="https://github.com/CSC207-2023Y-UofT/course-project-held-together-by-duct-tape/assets/133050886/c7615b93-334d-4bbd-a902-bc55b4c786c1">


In instructor mode, the user can create a course. They must give a course code, prerequisites and the grade in them if the prerequisite field is left blank default is fifty and if they don't have prereqs this is reflected in the database, questions, answers and their corresponding number of points. Then that specific course is saved if all inputs are valid and the instructor can no longer modify the course. 


<img width="348" alt="image" src="https://github.com/CSC207-2023Y-UofT/course-project-held-together-by-duct-tape/assets/133050886/26581797-4d73-4a4e-9326-6fe127520c46">



In the student mode, the student must input a unique username and a password which creates a student account. They can go to the login screen and log in to this new account using the username and password.


<img width="391" alt="image" src="https://github.com/CSC207-2023Y-UofT/course-project-held-together-by-duct-tape/assets/133050886/330d4817-dc69-499d-9e43-b6f745ac4747">


<img width="317" alt="image" src="https://github.com/CSC207-2023Y-UofT/course-project-held-together-by-duct-tape/assets/133050886/6e9f47a0-0490-47e6-affd-d8278f0e333e">
 
 The student is then able to see a list of all the courses. The student can choose to enroll in a course, however, they must meet the prerequisites to do that, if they don’t, they are not allowed to enroll. 
 
 <img width="347" alt="image" src="https://github.com/CSC207-2023Y-UofT/course-project-held-together-by-duct-tape/assets/133050886/6274c125-913d-4e0c-845d-4a8fd5524d85">
 
 Once the student picks a course, they can answer questions and then the course is evaluated for a grade.
 
 <img width="187" alt="image" src="https://github.com/CSC207-2023Y-UofT/course-project-held-together-by-duct-tape/assets/133050886/9a7efefb-21cc-48f5-b141-6b3d3ca2d627">
 
 <img width="194" alt="image" src="https://github.com/CSC207-2023Y-UofT/course-project-held-together-by-duct-tape/assets/133050886/7c2b9b13-a77a-4357-8473-3a8a012992ce">
 

## User stories
- The user can create different student users that will have their own respective data on how they performed in different courses
- The user can log in to a created student user using a unique username and a password
- The user can create a course with a unique course id that may or may not have a prerequisite but will have questions and answers (as well as points assigned to them)
- The user can enrol in a course that they have the appropriate prerequisites for
- The user can run a course and answer its questions
- the user can evaluate their course and see what grade they got for that attempt
  
## Packaging
The different files are separated by what layer they fall in according to the clean architecture guidelines  and are further divided by what feature they are specifically needed for.

<img width="253" alt="image" src="https://github.com/CSC207-2023Y-UofT/course-project-held-together-by-duct-tape/assets/133050886/fa4a9f59-c69b-486e-af1a-6841c952bb07">


## Design Patterns and choices
We implemented a factory design patterns so that our program could potentially be extended and future subclasses of our courses, prerequisites or student entities can be incorporated and it also allowed for greater separation between our layers.

<img width="576" alt="image" src="https://github.com/CSC207-2023Y-UofT/course-project-held-together-by-duct-tape/assets/133050886/3fcd846b-81bf-4c6f-9071-c43f9358542d">

We included a builder design pattern for the creation of our courses as the courses are containing both questions and prerequisites which both require different methods to construct so it felt cleaner to implement this design pattern for this more complex class.

<img width="712" alt="image" src="https://github.com/CSC207-2023Y-UofT/course-project-held-together-by-duct-tape/assets/133050886/737beea5-feeb-4df7-894f-878ce6581e29">

We also implemented an iterator design pattern within our course class as we needed a way to seamlessly iterate through the questions so that they can be presented to the user so they can answer them.

<img width="551" alt="image" src="https://github.com/CSC207-2023Y-UofT/course-project-held-together-by-duct-tape/assets/133050886/5ccf090c-0f03-4610-9682-e1949e125485">

We used mock gateways so that we could test our interactors without causing issues to our set-up databases. 

<img width="221" alt="image" src="https://github.com/CSC207-2023Y-UofT/course-project-held-together-by-duct-tape/assets/133050886/61d8a1d6-b46f-4467-aa30-21d5b36d3be1">

## Structure 
This is the diagram showing the related relationships regarding the create student feature:

<img width="710" alt="image" src="https://github.com/CSC207-2023Y-UofT/course-project-held-together-by-duct-tape/assets/133050886/f283ccb8-fc5c-4b30-abd2-06f396f1989d">

This diagram illustrates the relationships between the components for the Login feature:

<img width="631" alt="image" src="https://github.com/CSC207-2023Y-UofT/course-project-held-together-by-duct-tape/assets/133050886/ff0f4c04-70b9-44ee-8792-af564db46046">


This is the diagram illustrating the course evaluator feature:

<img width="293" alt="image" src="https://github.com/CSC207-2023Y-UofT/course-project-held-together-by-duct-tape/assets/133050886/b89f7bcf-9008-4227-a344-e22e9004edf2">



This is the diagram illustrating the run course feature:

<img width="662" alt="image" src="https://github.com/CSC207-2023Y-UofT/course-project-held-together-by-duct-tape/assets/133050886/ed9699b2-e75c-4c2e-beab-cfe9b5866f34">


This is a diagram for the course enrollment feature:

<img width="311" alt="image" src="https://github.com/CSC207-2023Y-UofT/course-project-held-together-by-duct-tape/assets/133050886/8025c2ce-5118-416f-b448-8bca30650e13">

This is a diagram for the courses creation feature:

<img width="409" alt="image" src="https://github.com/CSC207-2023Y-UofT/course-project-held-together-by-duct-tape/assets/133050886/32dfdd39-a8a6-4beb-b2e8-95f3d3ee51a3">





















