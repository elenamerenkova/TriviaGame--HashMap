
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.*;
import java.util.*;

public class trivia {

    private static HashMap<String, String> qa = new LinkedHashMap<>();
    private static ArrayList<String> keys = new ArrayList<>();
    private static ArrayList<String> values = new ArrayList<>();
    private static ArrayList<Integer> questions = new ArrayList<>(Arrays.asList(100, 200, 300, 400, 500));
    private static int counter = 0;
    private static String[] Songs = {"src/success.wav", "src/fail.wav", "src/applause.wav"};

    public static void setCounter() {
        System.out.println("Points counter: " + counter + " points");
    }

    public static void startGame() throws FileNotFoundException, InterruptedException {
        loadQA("src/qa.csv");
        keys.addAll(qa.keySet());
        values.addAll(qa.values());
        boolean keepGoing = true;
        while(keepGoing) {
            System.out.println("Please select the question's value: " + questions.toString() + " | Press 0 to exit");
            Scanner scanner = new Scanner(System.in);
            int userInput = scanner.nextInt();
            setCounter();
            if(userInput == 100) {
                System.out.println(keys.get(0));
                Scanner scanner1 = new Scanner(System.in);
                String answer = scanner1.nextLine();
                if (answer.equalsIgnoreCase(values.get(0))) {
                    System.out.println("Correct");
                    play(Songs[0]);
                    counter+=userInput;
                    questions.remove(Integer.valueOf(100));
                    setCounter();
                } else {
                    System.out.println("Incorrect");
                    play(Songs[1]);
                }
            }

            if(userInput == 200) {
                System.out.println(keys.get(1));
                Scanner scanner1 = new Scanner(System.in);
                String answer = scanner1.nextLine();
                if (answer.equalsIgnoreCase(values.get(1))) {
                    System.out.println("Correct");
                    play(Songs[0]);
                    counter+=userInput;
                    questions.remove(Integer.valueOf(200));
                    setCounter();
                } else {
                    System.out.println("Incorrect");
                    play(Songs[1]);
                }
            }

            if(userInput == 300) {
                System.out.println(keys.get(2));
                Scanner scanner1 = new Scanner(System.in);
                String answer = scanner1.nextLine();
                if (answer.equalsIgnoreCase(values.get(2))) {
                    System.out.println("Correct");
                    play(Songs[0]);
                    counter+=userInput;
                    questions.remove(Integer.valueOf(300));
                    setCounter();
                } else {
                    System.out.println("Incorrect");
                    play(Songs[1]);
                }
            }

            if(userInput == 400) {
                System.out.println(keys.get(3));
                Scanner scanner1 = new Scanner(System.in);
                String answer = scanner1.nextLine();
                if (answer.equalsIgnoreCase(values.get(3))) {
                    System.out.println("Correct");
                    play(Songs[0]);
                    counter+=userInput;
                    questions.remove(Integer.valueOf(400));
                    setCounter();
                } else {
                    System.out.println("Incorrect");
                    play(Songs[1]);
                }
            }

            if(userInput == 500) {
                System.out.println(keys.get(4));
                Scanner scanner1 = new Scanner(System.in);
                String answer = scanner1.nextLine();
                if (answer.equalsIgnoreCase(values.get(4))) {
                    System.out.println("Correct");
                    play(Songs[0]);
                    counter+=userInput;
                    questions.remove(Integer.valueOf(500));
                    setCounter();
                } else {
                    System.out.println("Incorrect");
                    play(Songs[1]);
                }
            }

            if (counter >= 1500) {
                play(Songs[2]);
                System.out.println("Congratulations! You won the trivia game");
                Thread.sleep(6000);
                keepGoing = false;
            }

            if(userInput == 0){
                System.out.println("Exiting");
                keepGoing = false;
            }

        }
    }

    public static void loadQA(String file) throws FileNotFoundException {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while((line=bufferedReader.readLine()) != null) {
                String[] pair = line.split(",");
                qa.put(pair[0], pair[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void play(String Songs) {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(Songs)));
            clip.start();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}
