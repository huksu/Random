/**
 * Created by thuskinson on 3/18/2016.
 * Write code to remove duplicates from an unsorted linked list.
 * Follow up: How would you solve this problem if a temporary buffer was not allowed?
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Hashtable;

public class RemoveDupes {

    public static class Node<N> {
        Node<N> next = null;
        N data;

        public Node(N data){
            this.data = data;
        }

        public Node<N> append(N data){
            return(this.next = new Node<N>(data));
        }
    }

    public static void main(String [] args){
        String fileName = args[0];
        RemoveDupes(fileName);
        RemoveDupes2(fileName);
        RemoveDupes3(fileName);
    }

    private static void RemoveDupes(String fileName){
        Node<Integer> head = new Node(null); // first node is null
        readFile(fileName, head);

        Node<Integer> n = head.next;
        Node<Integer> trailer = head;
        HashSet<Integer> hashSet = new HashSet<>();

        while(n != null) {
            if(!hashSet.contains(n.data)){
                hashSet.add(n.data);
                trailer = n;
            } else {
                // drop the node from the list
                trailer.next = n.next;
            }
            n = n.next;
        }

        System.out.println("Cleaned List: ");
        n = head.next;
        while(n != null) {
            System.out.println(n.data);
            n = n.next;
        }
    }

    private static void RemoveDupes2(String fileName){
        Node<Integer> head = new Node(null); // first node is null
        readFile(fileName, head);

        HashSet<Integer> hashSet = new HashSet<>();
        Node<Integer> n = head.next;
        hashSet.add(n.data);
        while(n.next != null){
            if(!hashSet.contains(n.next.data)){
                hashSet.add(n.next.data);
                n = n.next;
            } else {
                // drop the node from the list
                if(n.next == null){
                    n.next = null;
                } else {
                    n.next = n.next.next;
                }
            }
        }

        System.out.println("Cleaned List: ");
        n = head.next;
        while(n != null) {
            System.out.println(n.data);
            n = n.next;
        }
    }

    private static void RemoveDupes3(String fileName){
        // Let's avoid use of the hash table for O(n^2) complexity

        Node<Integer> head = new Node(null); // first node is null
        readFile(fileName, head);

        Node<Integer> n = head.next;

        while(n != null) {
            Node<Integer> next = n.next;
            Node<Integer> trailer = n;

            while(next != null){
                if(n.data == next.data){
                    // remove next from the linked list
                    trailer.next = next.next;
                } else {
                    // keep on truckin...
                    trailer = next;
                }
                next = next.next;
            }

            n = n.next;
        }

        System.out.println("Cleaned List: ");
        n = head.next;
        while(n != null) {
            System.out.println(n.data);
            n = n.next;
        }
    }

    private static void readFile(String fileName, Node<Integer> n){
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
                n = n.append(Integer.parseInt(line));
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
