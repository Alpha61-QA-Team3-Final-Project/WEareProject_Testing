## Project Description

The WEareProject is a Social Network web application developed to enable users to connect and interact with others in meaningful ways. The application provides core social networking features, such as:

- **Connecting with People**: Users can build connections with friends, colleagues, and like-minded individuals.
- **Creating and Interacting with Posts**: Users can create posts, comment on them, and express their appreciation by liking posts.
- **Personalized Feed**: A feed displays the latest and most relevant posts from a user's connections, making it easy to stay updated.

The specific theme of this application is open to interpretation and creativity. Whether it is focused on connecting travelers with reviews and experiences, helping students stay in touch, or generating a personalized feed similar to popular social networks, the application aims to provide a versatile platform for connection and interaction.

## Purpose of the Project

The primary goal of this project is to automate the testing of the Social Network application, ensuring that core functionalities are reliable and user-friendly. Using Selenium WebDriver, we aim to verify critical features such as user registration, login, post creation, commenting, liking, and feed 

# WEare Social Network Project Repository

### **Overview**
Welcome to the **WEare** Social Network project repository, created as part of our final project at Telerik Academy. This repository provides comprehensive details and reports on the testing of the WEare Social Network project. The social network is designed to connect individuals who can mutually benefit by exchanging skills and services. Users can create posts, comments, and show appreciation through likes.

### **Testing Strategy**
We have adopted the **Agile Scrum methodology**, organizing our work into sprints. Testing activities are structured to cover **UI testing** with **Selenium WebDriver** and **API testing** with **REST Assured** and **Postman**. Performance testing are also a part of our strategy. For more detailed information on our testing approach and strategies, refer to the **TestPlan** file in the **Documents** folder.

### **Repository Structure**
- **Documents**
  Contains the detailed test plan for the project, bug template and test case template.

- **WEare_Postman_API**  
  Includes **Weare_Postman_API** for API testing and **REPORT** folder.

- **WEare_REST_Assured**  
  Includes **REST_Assured** for API testing and **REPORT** folder.

-  **WEareProject_Selenium**  
   Includes **WEareProject_Selenium** for UI testing, **REPORT** and **ALLURE_REPORT** folders.

- **Jira Report**  
  Includes templates used for creating Jira test cases and reports, including the Jira Test Coverage report and Test Plan report.

- **Performance Testing**  
  This folder contains statistics of performance testing conducted with **JMeter**.

### **Viewing Jacoco and Newman Reports**
- To view Jacoco reports open .html file in the **REPORT** folders in **WEareProject_Selenium** and - **WEare_REST_Assured**.
- To view Newman report open .html file in the **REPORT** folder in **WEare_Postman_API**.

### **Viewing Allure Reports**
To view the generated Allure report, follow these steps:
1. Open your terminal;
2. Navigate to the project directory;
3. Run the following command:
#### allure serve allure-results

This command will start a local server and automatically open the Allure report in your browser, displaying details such as passed/failed tests, test history, and more.

Feel free to explore each section to gain a comprehensive understanding of our project's testing and development process.
