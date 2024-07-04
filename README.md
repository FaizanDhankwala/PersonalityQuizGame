
## JAVA PERSONALITY QUIZ GAME
By Faizan Dhankwala

![image](https://github.com/FaizanDhankwala/PersonalityQuizGame/assets/55712375/47f42e0c-3ee2-478c-b56b-114b8d867408)


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

2.Open the project in your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse).

3. Compile and run the QuizGame.java file to start the application.

## Usage
Launch the application to start the personality quiz.
Answer each question by selecting one of the provided options.
After completing all questions, the application will reveal your personality type along with its description, image, and background music.
Enjoy exploring different personality types and learning about yourself!

## Screenshots
![image](https://github.com/FaizanDhankwala/PersonalityQuizGame/assets/55712375/80630f44-0925-4ae2-8127-457da486a3c1)

-Caption: Example of the GUI interface displaying a question.

![image](https://github.com/FaizanDhankwala/PersonalityQuizGame/assets/55712375/5995e141-fa32-4507-a2cf-9ac68c80986e)

-Caption: End screen displaying the user's personality type and corresponding details.

## Technical Details
GUI Interface
The graphical user interface is implemented using Java's Swing library. Components such as JFrame, JPanel, JLabel, and JButton are used to create the layout and handle user interactions. The interface is designed to be user-friendly and responsive, adapting to different screen sizes and resolutions.

## Question Handling
Questions and multiple-choice options are managed using data structures like ArrayList of String[], where each element represents a question and its corresponding options. This allows for dynamic loading and presentation of questions during the quiz.

## Personality Types
The application includes six predefined personality types, each characterized by a distinct set of traits and attributes.

-Here are all the typees:
1. ![image](https://github.com/FaizanDhankwala/PersonalityQuizGame/assets/55712375/a9f7ad76-3dbc-47eb-9d4d-de4efdb3f59f)
2. ![image](https://github.com/FaizanDhankwala/PersonalityQuizGame/assets/55712375/8e101c82-30fb-4bec-8bd7-284c8af2e434)
3. ![image](https://github.com/FaizanDhankwala/PersonalityQuizGame/assets/55712375/c88d3856-1095-476d-a868-f27d4fcc5fd2)
4. ![image](https://github.com/FaizanDhankwala/PersonalityQuizGame/assets/55712375/a31877b2-36df-488e-b00f-027b43a86d51)
5. ![image](https://github.com/FaizanDhankwala/PersonalityQuizGame/assets/55712375/3c3a5664-5222-48f6-bd6a-15ecd00aac56)
6. ![image](https://github.com/FaizanDhankwala/PersonalityQuizGame/assets/55712375/1fcb18b6-c445-4d8a-8486-4b13527f38eb)

## Each personality type is associated with:
-A descriptive text explaining the characteristics of that personality type.
-An image (*.jpg format) representing the personality type visually.
-Background music (*.wav format) that plays when the personality type is revealed at the end of the quiz.
-Media Integration
-Images for personality types are stored in the images folder within the project directory. The application dynamically loads and displays the appropriate image based on the user's personality type selection. Similarly, background music files are stored in the music folder and are played using Java's javax.sound.sampled API.

## Contributing
Contributions to this project are welcome! If you encounter any issues, have ideas for improvements, or wish to add new features, please feel free to:

## Create an issue to report bugs or suggest enhancements.
Fork the repository, make your changes, and submit a pull request for review.
Your contributions can help make this project even better for users interested in exploring personality types through interactive quizzes.

## License
This project is licensed under the MIT License. See the LICENSE file for more details.
