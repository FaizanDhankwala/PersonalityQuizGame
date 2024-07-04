import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class QuizGame extends JFrame {
    private JPanel questionPanel;
    private JLabel questionLabel;
    private ArrayList<JButton> optionButtons;
    private int currentQuestionIndex;
    private ArrayList<String[]> questions;
    private int[] scores;
    private Clip backgroundMusic;

    private final String[][] personalityTypes = {
        {"The Extrovert", "You are extroverted, which means you thrive in social settings and draw energy from being around others. You often feel energized and excited when interacting with people and enjoy being the center of attention at times.\n\nYou're outgoing and confident, finding it easy to strike up conversations with strangers and make new friends. You prefer group activities over solitary pursuits and tend to think out loud, processing ideas by talking them through with others. Your enthusiasm and sociability make you a natural leader in group settings, where you excel at motivating and energizing those around you. Overall, your extroverted nature enriches your social life and contributes to your ability to connect with a wide range of people.\nHowever, this being said, you tend to jump into situations very quickly without considering the consequences or possible dangers of the events at hand. This impulsive nature can make you susceptible to manipulation, as you may overlook important details or warning signs. Consequently, you might find yourself easily tricked or baited into unfavorable circumstances, often regretting your decisions later. It’s important to take a step back and evaluate situations more thoroughly to avoid potential pitfalls and make more informed choices.", "extrovert.png", "extrovert.wav"},
        {"The Observer", "You are an observer, someone who prefers to stay in the background and carefully watches others to discern their true nature. You have a keen eye for details and subtle cues, allowing you to understand people's motivations and behaviors without needing to be the center of attention yourself.\n\nYour ability to observe enables you to gain deep insights into human behavior and dynamics. You notice patterns and nuances that others may overlook, which helps you form accurate judgments about people and situations. This keen perception allows you to navigate social interactions with a heightened awareness of underlying dynamics. This being said, however, you tend to lack friends and social interaction. Perhaps you are not into small talk, finding it tedious or uninteresting. This can make it challenging for you to connect with others on a superficial level, leading to fewer casual friendships. You might prefer deeper, more meaningful conversations and relationships, which can make you appear distant or aloof in social settings. This tendency can sometimes be misinterpreted as disinterest or arrogance, further complicating your social interactions. It's important to find a balance, learning to appreciate the value of casual interactions while staying true to your preference for deeper connections.", "observer.png", "observer.wav"},
        {"The Giver", "You are a giver, embodying humility, wisdom, and a deep consideration for others. You often prioritize the needs and well-being of those around you before your own, finding fulfillment in helping and supporting others. Your humility shines through in your actions, as you don't seek recognition or praise for your kindness and generosity. Instead, you derive satisfaction from seeing others thrive and succeed because of your support.\n\nWisdom is a hallmark of your personality, as you possess a deep understanding of human nature and empathy. You offer thoughtful advice and insights, drawing from your experiences and understanding of others' perspectives. Your decisions are guided by a strong sense of fairness and compassion, always considering the impact on others before taking action. However, this can lead to sometimes prioritizing others before yourself—when you should prioritize yourself. While your selflessness and willingness to help others are admirable traits, they can sometimes come at the expense of your own well-being. This tendency can result in neglecting your own needs and desires, leading to burnout and resentment. It's essential to find a healthy balance, ensuring that you take care of yourself first so that you can better support those around you. Remember, self-care is not selfish; it's necessary for your overall happiness and effectiveness in helping others.", "giver.png", "giver.wav"},
        {"The Taker", "You are a taker, someone who prioritizes your own needs and desires above all else. Your focus is primarily on fulfilling your own goals and ambitions, often without much consideration for how it impacts others around you. You believe in taking opportunities that benefit you, sometimes at the expense of others.\n\nYour approach to relationships and interactions tends to be transactional, where you assess what you can gain or achieve personally. You may seek recognition, status, or material rewards, viewing success through the lens of personal gain rather than collective well-being. Your decisions are often driven by self-interest and the desire to maximize your own outcomes. However, it is important to remember that selfishness isn't always the best trait. While looking out for your own needs and interests is crucial, excessive self-centeredness can strain relationships and alienate those around you. Balancing self-care with empathy and consideration for others can lead to more harmonious and fulfilling interactions. By cultivating a sense of compassion and understanding, you can build stronger connections and create a more supportive and nurturing environment for yourself and those you care about.", "taker.png", "taker.wav"},
        {"The Planner", "You are a planner, someone who thrives on thinking ahead and organizing every aspect of your life and work. You possess a meticulous and strategic mindset, always considering various possibilities and outcomes before making decisions. Planning is not just a task for you; it's a way of life that brings you clarity and control.\n\nYour strength lies in your ability to foresee potential challenges and opportunities, allowing you to create detailed strategies and contingency plans. You excel in setting goals and breaking them down into actionable steps, ensuring steady progress towards your objectives. Your organized approach helps you stay focused and productive, even in complex or uncertain situations. However, this may cause you to be unlikable or not prepared for fast-paced scenarios where planning isn't ideal. Your meticulous nature and preference for detailed planning can sometimes make you appear rigid or inflexible to others. In dynamic situations that require quick thinking and adaptability, you might struggle to keep up, potentially leading to frustration and a sense of being overwhelmed. This can also affect how others perceive you, as they might find your methodical approach unsuitable for spontaneous or high-pressure environments. It's important to work on becoming more adaptable and open to change, allowing yourself to thrive even in unpredictable circumstances.", "planner.png", "planner.wav"},
        {"The Spontaneous", "You are spontaneous, the Joker Card. Someone who thrives on seeking out new experiences and embracing opportunities as they arise. Someone who laughs in the face of danger and takes all the risks they can. You find excitement and joy in exploring the unknown, often seeking variety and novelty in your activities and relationships. Routine and predictability may feel stifling to you, as you prefer to live in the moment and follow your impulses.\n\nYour spontaneity is fueled by curiosity and a thirst for adventure. You enjoy trying new hobbies, visiting new places, and meeting new people. Your openness to new experiences allows you to adapt quickly to changing circumstances and make the most out of unexpected opportunities. You do not worry if it get you in trouble or not. However, you cannot handle the often dull times in life. Boredom is your worst enemy, and you may find it difficult to stay engaged during routine or monotonous tasks. This restlessness can lead to seeking constant excitement and new experiences, which might make it hard for you to appreciate the quieter, more mundane aspects of life. As a result, you could miss out on the value and growth that can come from patience and perseverance through less thrilling moments. Learning to find contentment in simplicity and developing the ability to cope with boredom can help you lead a more balanced and fulfilling life.", "spontaneous.png", "GTA.wav"}
    };

    public QuizGame() {
        setTitle("Personality Quiz By Faizan");
        setSize(1200, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Attempt to play background music
        playMusic("megalovania.wav"); // Default background music

        showWelcomeScreen();
    }

    private void playMusic(String filepath) {
        try {
            if (backgroundMusic != null && backgroundMusic.isRunning()) {
                backgroundMusic.stop(); // Stop current music if playing
            }

            File musicFile = new File(filepath);
            if (musicFile.exists()) {
                AudioInputStream audio = AudioSystem.getAudioInputStream(musicFile);
                backgroundMusic = AudioSystem.getClip();
                backgroundMusic.open(audio);
                backgroundMusic.loop(Clip.LOOP_CONTINUOUSLY);
            } else {
                System.out.println("The specified audio file was not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showWelcomeScreen() {
        JPanel welcomePanel = new JPanel();
        welcomePanel.setLayout(new BorderLayout());
        welcomePanel.setBackground(Color.pink);

        JLabel welcomeLabel = new JLabel("Welcome to the Personality Quiz Game!", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        welcomePanel.add(welcomeLabel, BorderLayout.NORTH);
        welcomeLabel.setForeground(Color.white);

        JLabel instructionsLabel = new JLabel("<html><div style='text-align: center;'>The rules of this game are simple: just read the question and answer based on what option you feel represents you as a person more!</div></html>", SwingConstants.CENTER);
        instructionsLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        welcomePanel.add(instructionsLabel, BorderLayout.CENTER);
        instructionsLabel.setForeground(Color.BLACK);

        JButton startButton = new JButton("Start Quiz");
        startButton.setBackground(Color.lightGray);
        startButton.setForeground(Color.WHITE);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showQuizScreen();
            }
        });
        welcomePanel.add(startButton, BorderLayout.SOUTH);

        add(welcomePanel);
    }

    private void showQuizScreen() {
        getContentPane().removeAll();
        questionPanel = new JPanel();
        questionLabel = new JLabel();
        optionButtons = new ArrayList<>();
    
        questionPanel.setBackground(Color.pink);
        questionLabel.setBackground(Color.white);
        questionPanel.setLayout(new BorderLayout());
        questionPanel.add(questionLabel, BorderLayout.NORTH);
    
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        questionLabel.setForeground(Color.BLACK);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 2)); // Change GridLayout to accommodate 3 rows and 2 columns
    
        for (int i = 0; i < 6; i++) { // Change to loop through 6 options
            JButton button = new JButton("Option " + (i + 1));
            button.setBackground(Color.pink);
            button.addActionListener(new OptionButtonListener(i));
            optionButtons.add(button);
            buttonPanel.add(button);
        }
    
        questionPanel.add(buttonPanel, BorderLayout.CENTER);
        add(questionPanel);
    
        scores = new int[personalityTypes.length];
    
        questions = new ArrayList<>();
    
    
        questions.add(new String[]{"You're at a party, and there's a lot of people at the dance floor. What are you more likely to do?", 
            "Join the dance floor and dance freely", 
            "Have fun talking with others, but refuse to get too wild", 
            "Talk to some people, but keep to yourself most of the time", 
            "Leave the party early",
            "Organize a group game or activity to get everyone involved",
            "Join a dance circle and show off some moves"});
        questions.add(new String[]{"You're sitting with your friends and having a good time, until out of the corner of your eye- you see someone sitting alone. What do you do? ", 
            "Ignore him, he probably doesn't want to be bothered.", 
            "Ask him if he's okay using only gestures, but no words.", 
            "Ask him if he's okay using words.", 
            "Invite him over to your friend group using words.",
            "Offer to include him in a planned group activity",
            "Sit down and start a conversation"});
        questions.add(new String[]{"You receive an unexpected gift from a friend. How do you react?", 
            "Excitedly thank them and show everyone the gift.", 
            "Thank them politely and keep the gift to yourself.", 
            "Feel a bit awkward but thank them anyway.", 
            "Wonder why they gave you a gift and feel suspicious.",
            "Immediately plan how you'll use or display the gift",
            "Enjoy the gift in the moment and think about its meaning later"});
        questions.add(new String[]{"It's a Saturday afternoon and you have no plans. What do you do?", 
            "Call up friends and organize a group activity.", 
            "Spend the day relaxing at home with a good book or movie.", 
            "Go for a walk or a solo adventure.", 
            "Catch up on chores and other responsibilities.",
            "Create a schedule for the day, balancing relaxation and productivity",
            "Do the craziest thing you've been planning for a while"});
        questions.add(new String[]{"You have a group project due soon. How do you contribute?", 
            "Take charge and delegate tasks to everyone.", 
            "Collaborate and contribute your fair share.", 
            "Let others take the lead but help where you can.", 
            "Do the minimum required and let others handle the rest.",
            "Plan out the project timeline and milestones in advance",
            "Ask if you can work alone"});
        questions.add(new String[]{"You’re at a networking event with strangers. How do you handle it?", 
            "Mingle and introduce yourself to as many people as possible.", 
            "Talk to a few people who seem interesting.", 
            "Stay with the people you already know.", 
            "Stay on the sidelines and observe.",
            "Prepare talking points and goals for the event ahead of time",
            "Go with the flow and engage with whoever you meet naturally"});
        questions.add(new String[]{"You have a disagreement with a close friend. How do you handle it?", 
            "Address it directly and try to resolve it immediately.", 
            "Bring it up casually and hope it resolves naturally.", 
            "Avoid the topic and hope it goes away.", 
            "End the friendship to avoid conflict.",
            "Suggest scheduling a time to discuss it in depth",
            "Wait for the right moment to bring it up naturally"});
        questions.add(new String[]{"You’re given a challenging task at work or school. How do you approach it?", 
            "Tackle it head-on and try to solve it as quickly as possible.", 
            "Take your time to understand the task and work through it methodically.", 
            "Ask for help from colleagues or classmates.", 
            "Procrastinate and deal with it at the last minute.",
            "Create a detailed plan or outline before starting",
            "Jump into solving it and adapt your approach as you go"});
        questions.add(new String[]{"You’re on vacation in a new city. What’s your plan?", 
            "Plan a detailed itinerary and visit as many places as possible.", 
            "Visit a few key attractions and spend the rest of the time relaxing.", 
            "Explore the city spontaneously without a fixed plan.", 
            "Stay mostly in your hotel and relax.",
            "Schedule time for exploring and time for relaxation",
            "Wander around without a care in mind"});
        questions.add(new String[]{"Your favorite band is in town for a concert. What do you do?", 
            "Buy tickets immediately and try to get the best seats.", 
            "Consider going if friends are interested too.", 
            "Listen to the concert online instead of attending.", 
            "Ignore it because large crowds aren’t your thing.",
            "Plan to arrive early and explore the venue",
            "Decide last minute based on your mood and schedule"});
        questions.add(new String[]{"A friend is feeling down and reaches out to you. How do you respond?", 
            "Offer to meet up and cheer them up.", 
            "Listen to their problems and offer advice.", 
            "Send a supportive message but keep your distance.", 
            "Avoid getting involved and hope they feel better soon.",
            "Make a plan to spend time together and uplift their spirits",
            "Reach out to show support and care"});
        questions.add(new String[]{"You’re at a family gathering, and a heated debate starts. How do you handle it?", 
            "Jump in and share your opinions passionately.", 
            "Share your thoughts but try to keep the peace.", 
            "Listen quietly and avoid getting involved.", 
            "Find an excuse to leave the room.",
            "Prepare to steer the conversation towards common ground",
            "Start adding fire to the debate to see where it goes"});
        questions.add(new String[]{"You have a free weekend with no commitments. What do you do?", 
            "Plan a fun trip or outing with friends.", 
            "Catch up on hobbies or personal projects.", 
            "Spend the weekend relaxing and doing nothing.", 
            "Use the time to get ahead on work or study.",
            "Organize activities to make the most of your free time",
            "Do the #1 thing on your bucket list"});
        questions.add(new String[]{"You see someone being treated unfairly in public. What do you do?", 
            "Step in and confront the situation.", 
            "Offer support to the person being treated unfairly.", 
            "Alert someone else to handle it.", 
            "Avoid getting involved.",
            "Make a plan to assist discreetly and effectively",
            "Act on your instincts and intervene immediately"});
        questions.add(new String[]{"You’re asked to give a presentation at work or school. How do you prepare?", 
            "Create a detailed presentation and practice thoroughly.", 
            "Prepare enough to cover the basics.", 
            "Wing it and hope for the best.", 
            "Try to find a way to avoid doing it.",
            "Plan out each slide and practice your delivery",
            "Prepare? Who does that?"});
        questions.add(new String[]{"You’re given a surprise day off. How do you spend it?", 
            "Plan a spontaneous adventure.", 
            "Relax at home and enjoy the downtime.", 
            "Catch up on errands and chores.", 
            "Sleep in and take it easy all day.",
            "Decide on activities based on how you feel in the moment",
            "Use the time to plan upcoming personal goals or projects"});
        questions.add(new String[]{"You’re invited to a themed costume party. How do you participate?", 
            "Go all out and create an elaborate costume.", 
            "Wear a simple costume that fits the theme.", 
            "Show up in regular clothes and say you’re ‘dressed as yourself’.", 
            "Skip the party because costumes aren’t your thing.",
            "Plan and execute a unique costume idea in advance",
            "Take someone elses costume"});
        questions.add(new String[]{"You’re at a restaurant, and your order is wrong. What do you do?", 
            "Politely ask the server to correct it.", 
            "Eat it anyway without saying anything.", 
            "Complain loudly to the staff.", 
            "Leave the restaurant without saying anything.",
            "Check the menu again to see if you missed something",
            "Leave the resteraunt without paying"});
        questions.add(new String[]{"You’re asked to help organize a big event. What’s your role?", 
            "Take the lead and coordinate everything.", 
            "Offer to help with specific tasks.", 
            "Help only if someone asks you directly.", 
            "Avoid getting involved as much as possible.",
            "Plan and delegate tasks in advance to ensure smooth execution",
            "Ask if you can become the host"});
        questions.add(new String[]{"You’re traveling and miss your flight. How do you handle it?", 
            "Quickly find the next available flight and rebook.", 
            "Stay calm and explore other travel options.", 
            "Panic and get upset.", 
            "Consider going back home instead.",
            "Have a backup plan in place for unexpected travel disruptions",
            "See if you can catch a new one on the spot"});
        questions.add(new String[]{"You’re offered a new job opportunity that requires moving to a new city. What do you do?", 
            "Accept it immediately and start planning the move.", 
            "Consider it carefully and discuss with close ones.", 
            "Decline it because you don’t want to move.", 
            "Ignore it because change is too overwhelming.",
            "Research the new city and plan the logistics of moving",
            "Ask your employer how the city's like"});
        questions.add(new String[]{"You see a friend posting something controversial on social media. What do you do?", 
            "Engage in a discussion and share your viewpoint.", 
            "Send them a private message to talk about it.", 
            "Ignore it and scroll past.", 
            "Unfollow or block them to avoid seeing such posts.",
            "Plan your response carefully to encourage constructive dialogue",
            "Post your own version of controversy"});
        questions.add(new String[]{"You’re in a class or meeting and don’t understand the topic being discussed. What do you do?", 
            "Ask questions until you understand.", 
            "Look up information later to understand better.", 
            "Pretend to understand and hope no one notices.", 
            "Zone out and wait for the session to end.",
            "Plan to review the material later to grasp the concepts",
            "Seek clarification from others in the class or meeting"});
        questions.add(new String[]{"You’re at a restaurant with friends, and the bill arrives. What do you do?", 
            "Offer to pay for everyone.", 
            "Suggest splitting the bill evenly.", 
            "Pay only for what you ordered.", 
            "Wait for someone else to take care of it.",
            "Plan to handle the bill in a fair and efficient manner",
            "Leave the resteraunt quietly "});
        questions.add(new String[]{"You’re planning a vacation. How do you go about it?", 
            "Create a detailed itinerary and book everything in advance.", 
            "Plan some activities but leave room for spontaneity.", 
            "Go with the flow and decide on the spot.", 
            "Let someone else plan it and just follow along.",
            "Develop a flexible plan that accommodates unexpected opportunities",
            "Ditch the planning and just go"});
        questions.add(new String[]{"You hear a rumor about a friend. What do you do?", 
            "Confront the friend directly to get the truth.", 
            "Ask around to gather more information.", 
            "Ignore it and assume it's not true.", 
            "Spread the rumor further without verifying.",
            "Plan to verify the rumor's validity before taking any action",
            "Make up your own rumors"});
        questions.add(new String[]{"You’re at the gym and see someone struggling with their workout. What do you do?", 
            "Offer to help them with their workout.", 
            "Give them some encouraging words.", 
            "Watch them but don’t intervene.", 
            "Ignore them and focus on your own workout.",
            "Plan to provide assistance in a way that respects their privacy",
            "Act like you support them but really do not care."});
        questions.add(new String[]{"You’re at a job interview, and they ask about your weaknesses. How do you respond?", 
            "Honestly discuss your weaknesses and how you’re working on them.", 
            "Give a cliché answer like ‘I work too hard’.", 
            "Avoid the question and redirect to your strengths.", 
            "Say you don’t have any weaknesses.",
            "Plan your response to highlight areas of improvement and growth",
            "Ask the Interviewer why they ask this question"});
        questions.add(new String[]{"You’re at a friend’s house, and they serve a dish you dislike. What do you do?", 
            "Politely eat it anyway.", 
            "Try a little and leave the rest.", 
            "Explain that you don’t like it.", 
            "Make an excuse to avoid eating it.",
            "Plan your response to minimize any discomfort or offense",
            "Offer to cook something for yourself"});
        questions.add(new String[]{"You’re assigned a new role in a group project. How do you react?", 
            "Take charge and lead the group.", 
            "Collaborate and do your part.", 
            "Go along with whatever the group decides.", 
            "Try to avoid taking on responsibilities.",
            "Plan your approach to contribute effectively to the group's success",
            "Ask the teacher if you can work alone"});
        

        currentQuestionIndex = 0;
        showCurrentQuestion();
    }

    private void showCurrentQuestion() {
        String[] currentQuestion = questions.get(currentQuestionIndex);
        questionLabel.setText("<html><div style='text-align: center;'><h2>Question " + (currentQuestionIndex + 1) + "</h2><p>" + currentQuestion[0] + "</p></div></html>");

        for (int i = 0; i < 6; i++) {
            optionButtons.get(i).setText(currentQuestion[i + 1]);
        }

        getContentPane().revalidate();
        getContentPane().repaint();
    }

    private class OptionButtonListener implements ActionListener {
        private int optionIndex;

        public OptionButtonListener(int optionIndex) {
            this.optionIndex = optionIndex;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            scores[optionIndex]++;
            currentQuestionIndex++;
            if (currentQuestionIndex < questions.size()) {
                showCurrentQuestion();
            } else {
                showResultScreen();
            }
        }
    }

    private void showResultScreen() {
        getContentPane().removeAll();
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new BorderLayout());
        resultPanel.setBackground(Color.pink);

        int maxScoreIndex = 0;
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > scores[maxScoreIndex]) {
                maxScoreIndex = i;
            }
        }

        String[] result = personalityTypes[maxScoreIndex];
        JLabel resultLabel = new JLabel("<html><div style='text-align: center;'><h1>You are: " + result[0] + "</h1></div></html>", SwingConstants.CENTER);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 20));
        resultPanel.add(resultLabel, BorderLayout.NORTH);

        // Create a panel to hold image and description
        JPanel imageDescriptionPanel = new JPanel();
        imageDescriptionPanel.setLayout(new BorderLayout());

        // Load and display image
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(result[2])); // Load image from resources
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imageDescriptionPanel.add(imageLabel, BorderLayout.CENTER);

        // Display description below the image
        JLabel descriptionLabel = new JLabel("<html><div style='text-align: justify; margin:20px;'>" + result[1] + "</div></html>");
        descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        imageDescriptionPanel.add(descriptionLabel, BorderLayout.SOUTH);

        resultPanel.add(imageDescriptionPanel, BorderLayout.CENTER);

        // Stop background music and play personality-specific music
        stopMusic();
        playMusic(result[3]); // Assuming result[3] holds the filename for the music of this personality type

        JButton restartButton = new JButton("Play Again");
        restartButton.setBackground(Color.lightGray);
        restartButton.setForeground(Color.WHITE);
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showQuizScreen();
            }
        });
        resultPanel.add(restartButton, BorderLayout.SOUTH);

        add(resultPanel);
        getContentPane().revalidate();
        getContentPane().repaint();
    }

    private void stopMusic() {
        if (backgroundMusic != null && backgroundMusic.isRunning()) {
            backgroundMusic.stop();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new QuizGame().setVisible(true);
            }
        });
    }
}
