
## JAVA PERSONALITY QUIZ GAME
By Faizan Dhankwala

![image](https://github.com/FaizanDhankwala/PersonalityQuizGame/assets/55712375/ea52c3e8-8144-43c8-ac4e-7bd4b45efe31)



Welcome to the Java GUI Personality Quiz Game! This project is a Java-based application that allows users to take a personality quiz through a graphical user interface (GUI). The quiz determines the user's personality type based on their responses to a series of questions. Each personality type is associated with a unique description, image, and background music.

PS: This is my first time with JFrame and GUI's so things may be a little visually unappealing!
But without further ado..

## Table of Contents

1. Introduction
2. Features
3. Installation
4. Usage
5. Screenshots
6. Technical Details
   - GUI Interface
   - Question Handling
   - Personality Types
   - Media Integration
7. Contributing
8. License

## Introduction

This project aims to provide an interactive and engaging way for users to explore different personality types through a quiz format. The application utilizes Java's Swing framework for creating the GUI components, allowing for an intuitive user experience.

## Features

- **GUI Interface:** Built using Java Swing for a responsive and visually appealing interface.
- **Dynamic Question Handling:** Presents questions sequentially with multiple-choice options.
- **Six Personality Types:** Each with a unique description, image, and background music.
- **Image and Sound Integration:** Displays corresponding images and plays background music based on the user's personality type.
- **Score Calculation:** Determines the user's personality type based on their answers and scores.
- **User Interaction:** Users interact through clickable buttons for selecting answers and progressing through the quiz.
- **Flexibility:** Easily customizable with additional questions, personality types, and media files.

## Installation

To run the application locally, follow these steps:

1. Clone the repository:

2. Open the project in your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse).

3. Compile and run the QuizGame.java file to start the application.

   (Its better to run in an IDE such as VScode)

## Usage
Launch the application to start the personality quiz.
Answer each question by selecting one of the provided options.
After completing all questions, the application will reveal your personality type along with its description, image, and background music.
Enjoy exploring different personality types and learning about yourself!

## Screenshots
![image](https://github.com/FaizanDhankwala/PersonalityQuizGame/assets/55712375/e35c182a-7491-4661-9ff9-ca62671de324)


-Caption: Example of the GUI interface displaying a question.

![image](https://github.com/FaizanDhankwala/PersonalityQuizGame/assets/55712375/4827ba50-5add-4d98-89bc-d208c0dec2e4)


-Caption: End screen displaying the user's personality type and corresponding details.

## Technical Details
GUI Interface
The graphical user interface is implemented using Java's Swing library. Components such as JFrame, JPanel, JLabel, and JButton are used to create the layout and handle user interactions. The interface is designed to be user-friendly and responsive, adapting to different screen sizes and resolutions.

## Question Handling
Questions and multiple-choice options are managed using data structures like ArrayList of String[], where each element represents a question and its corresponding options. This allows for dynamic loading and presentation of questions during the quiz.

## Personality Types
The application includes six predefined personality types, each characterized by a distinct set of traits and attributes.

-Here are all the typees:
1. ![image](https://github.com/FaizanDhankwala/PersonalityQuizGame/assets/55712375/db8af429-a1af-45d2-b9d7-c0f7324f50af)
2. ![image](https://github.com/FaizanDhankwala/PersonalityQuizGame/assets/55712375/ea52c3e8-8144-43c8-ac4e-7bd4b45efe31)
3. ![image](https://github.com/FaizanDhankwala/PersonalityQuizGame/assets/55712375/7a57b704-524f-40d8-a9c5-566167985da3)
4. ![image](https://github.com/FaizanDhankwala/PersonalityQuizGame/assets/55712375/c29ee6ef-143a-4973-9563-c3ebb4e93cf6)
5. ![image](https://github.com/FaizanDhankwala/PersonalityQuizGame/assets/55712375/4827ba50-5add-4d98-89bc-d208c0dec2e4)
6. ![image](https://github.com/FaizanDhankwala/PersonalityQuizGame/assets/55712375/fc71ef98-e716-4d91-bdf0-a1ea17dcb88e)


## Each personality type is associated with:
-A descriptive text explaining the characteristics of that personality type.
-An image (*.jpg format) representing the personality type visually.
-Background music (*.wav format) that plays when the personality type is revealed at the end of the quiz.
-Media Integration
-Images for personality types are stored within the project directory. The application dynamically loads and displays the appropriate image based on the user's personality type selection. Background music are played using Java's javax.sound.sampled API.

## Contributing
Contributions to this project are welcome! If you encounter any issues, have ideas for improvements, or wish to add new features, please feel free to:

## Create an issue to report bugs or suggest enhancements.
Fork the repository, make your changes, and submit a pull request for review.
Your contributions can help make this project even better for users interested in exploring personality types through interactive quizzes.

## License
This project is licensed under the MIT License. See the LICENSE file for more details.
