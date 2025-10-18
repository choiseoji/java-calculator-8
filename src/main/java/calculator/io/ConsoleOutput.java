package calculator.io;

public class ConsoleOutput implements Output{

    @Override
    public void print(int result) {

        System.out.println("결과 : " + result);
    }
}
