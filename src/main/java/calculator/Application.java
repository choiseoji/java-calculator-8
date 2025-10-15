package calculator;

public class Application {
    public static void main(String[] args) {

        InputHandler inputHandler = new InputHandler();
        String command = inputHandler.run();

        Parser parser = new Parser();
        String[] tokens = parser.run(command);
    }
}
