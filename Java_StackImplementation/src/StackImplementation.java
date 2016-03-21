import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.EmptyStackException;

/**
 * Created by thuskinson on 3/21/2016.
 */

public class StackImplementation {

    public static class Stack<N>{

        public static class StackNode<N> {
            public StackNode(N value){
                this.value = value;
                this.next = null;
            }

            N value;
            StackNode<N> next;
        }

        StackNode<N> top = null;

        public void push(N value){
            StackNode<N> n = new StackNode(value);
            n.next = top;
            top = n;
        }

        public N peek(){
            if(top == null) throw new EmptyStackException();
            return top.value;
        }

        public N pop(){
            if(top == null) throw new EmptyStackException();
            N ret = top.value;
            top = top.next;
            return ret;
        }

        public Boolean isEmpty(){
            if(top == null)
                return true;
            else
                return false;
        }

    }

    public static void main(String [] args){
        String fileName = args[0];
        Stack<Double> s = new Stack();
        readFile(fileName, s);
    }

    private static void readFile(String fileName, Stack<Double> s){
        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                // split the line to the command and the value
                String command = line.split(" ")[0];
                if(command.equals("push")){
                    Double value = Double.parseDouble(line.split(" ")[1]);
                    System.out.println("push " + value);
                    s.push(value);
                } else if(command.equals("pop")){
                    Double value = s.pop();
                    System.out.println("pop " + value);
                } else if(command.equals("peek")){
                    Double value = s.peek();
                    System.out.println("peek " + value);
                } else if(command.equals("isEmpty")){
                    System.out.println("isEmpty " + s.isEmpty());
                } else {
                    throw new IllegalArgumentException();
                }
            }

            // Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
        }
    }
}
