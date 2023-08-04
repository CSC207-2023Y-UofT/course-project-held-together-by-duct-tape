# Course Simulator

This is a course simulator in which the user can pick between an instructor mode and a student mode.

<img width="392" alt="image" src="https://github.com/CSC207-2023Y-UofT/course-project-held-together-by-duct-tape/assets/133050886/c7615b93-334d-4bbd-a902-bc55b4c786c1">


In instructor mode, the user can create a course. They must give a course code, prerequisites, questions, answers and their corresponding number of points. Then that specific course is saved. In the student mode, the student must input a unique username and a password which creates a student account and they can go into the login screen and login to this new account using the username and password.
<img width="391" alt="image" src="https://github.com/CSC207-2023Y-UofT/course-project-held-together-by-duct-tape/assets/133050886/330d4817-dc69-499d-9e43-b6f745ac4747">


 
 
 The student is then able to see a list of all the courses. The student can choose to enroll in a course, however, they must meet the prerequisites to do that, if they don’t, they are not allowed to enroll. Once the student picks a course, they can answer questions and based on a certain criterion, they can get credit for the course. A student has an overall GPA that is updated every time they take a course.


## Checklist For Your Project
- [ ] Verify the correct settings for your project repository
- [ ] Set up Github Projects
- [ ] Create the implementation plan using issues and Github Projects
- [ ] Create deveopment branches for your features
- [ ] Use pull requests to merge finished features into main branch
- [ ] Conduct code reviews

**If your team has trouble with any of these steps, please ask on Piazza. For example, with how GitHub Classroom works, your team *may* not have permissions to do some of the first few steps, in which case we'll post alternative instructions as needed.**

## Workflow Documents

* Github Workflow: Please refer to the workflow that was introduced in the first lab. You should follow this when working on your code. The following document provides additional details too.

* [Project Planning and Development Guide](project_plan_dev.md): This document helps you to understand how to create and maintain a project plan for your class project. **This document helps you to complete the Implementation Plan Milestone.**

## Gradle Project
Import this project into your Intellij editor. It should automatically recognise this as a gradle repository.
The starter code was built using SDK version 11.0.1. Ensure that you are using this version for this project. (You can, of course, change the SDK version as per your requirement if your team has all agreed to use a different version)

You have been provided with two starter files for demonstration: HelloWorld and HelloWorldTest.

You will find HelloWorld in `src/main/java/tutorial` directory. Right click on the HelloWorld file and click on `Run HelloWorld.main()`.
This should run the program and print on your console.

You will find HelloWorldTest in `src/test/java/tutorial` directory. Right click on the HelloWorldTest file and click on `Run HelloWorldTest`.
All tests should pass. Your team can remove this sample of how testing works once you start adding your project code to the repo.

Moving forward, we expect you to maintain this project structure. You *should* use Gradle as the build environment, but it is fine if your team prefers to use something else -- just remove the gradle files and push your preferred project setup. Assuming you stick with Gradle, your source code should go into `src/main/java` (you can keep creating more subdirectories as per your project requirement). Every source class can auto-generate a test file for you. For example, open HelloWorld.java file and click on the `HelloWorld` variable as shown in the image below. You should see an option `Generate` and on clicking this your should see an option `Test`. Clicking on this will generate a JUnit test file for `HelloWorld` class. This was used to generate the `HelloWorldTest`.

![image](https://user-images.githubusercontent.com/5333020/196066655-d3c97bf4-fdbd-46b0-b6ae-aeb8dbcf351d.png)

You can create another simple class and try generating a test for this class.
