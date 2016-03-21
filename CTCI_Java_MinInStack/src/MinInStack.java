import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

/**
 * Created by thuskinson on 3/21/2016.
 */
public class MinInStack {

    public static class Stack{
        public class StackNode{
            Double value;
            StackNode next;
        }

        StackNode top = null;
        StackNode minTop = null;

        public void push(Double value){
            StackNode newTop = new StackNode();
            newTop.next = top;
            newTop.value = value;
            top = newTop;

            if(minTop == null || newTop.value <= minTop.value){
                // add to minstack
                StackNode newMinTop = new StackNode();
                newMinTop.next = minTop;
                newMinTop.value = newTop.value;
                minTop = newMinTop;
            }
        }

        public Double pop(){
            Double ret = top.value;
            top = top.next;

            if(ret == minTop.value){
                minTop = minTop.next;
            }

            return ret;
        }

        public Double peek(){
            return top.value;
        }

        public Double min(){
            return minTop.value;
        }

        public Boolean isEmpty(){
            if(top == null){
                return true;
            } else {
                return false;
            }
        }
    }

    public static void main(String [] args){
        String fileName = args[0];
        Stack s = new Stack();
        readFile(fileName, s);
    }

    private static void readFile(String fileName, Stack s){
        String line = null;

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null){
                // split the line to the command and the value
                String command = line.split(" ")[0];
                if(command.equals("push")){
                    Double value = Double.parseDouble(line.split(" ")[1]);
                    System.out.println("push " + value);
                    s.push(value);
                } else if(command.equals("pop")){
                    if(!s.isEmpty()){
                        Double value = s.pop();
                        System.out.println("pop " + value);
                    }
                } else if(command.equals("peek")){
                    if(!s.isEmpty()){
                        Double value = s.peek();
                        System.out.println("peek " + value);
                    }
                } else if(command.equals("isEmpty")){
                    System.out.println("isEmpty " + s.isEmpty());
                } else if(command.equals("min")){
                    System.out.println("min " + s.min());
                } else {
                    throw new IllegalArgumentException();
                }
            }

            bufferedReader.close();
        } catch(FileNotFoundException ex){
            System.out.println("Unable to open file " + fileName);
        } catch(IOException ex){
            System.out.println("Error reading file " + fileName);
        }
    }

}
