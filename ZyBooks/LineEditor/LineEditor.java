import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 
 * Student name: Key Houck
 * Completion date: 11-12-2023
 *
 * LineList.txt: the template file of LineList.java
 * Student tasks: implement tasks as specified in this file
 *
 * LineList class is a linked-base list that represents the contents of a
 * document
 *
 */

public class LineList {

    private Node head;

    public LineList() { // constructor
        head = null;
    }

    public void empty() {
        head = null;
    }

    public void load(String fileName, boolean append) {
        // append is true, read lines and add to existing list,
        // otherwise, create new list.
        // Each line is stored in a Node.
        // You may need to handle exception within this method
        // or throw runtime exception only.

        if (!append) {
            empty();
        }
        try (Stream<String> stream = Files.lines(Paths.get("src", fileName))) {
            stream.forEach((String line) -> addLine(line));
        } catch (IOException e) {
            throw new RuntimeException("Error reading file", e);
        }
    }

    public void save(String fileName) {
        // Save all lines represented with Nodes to a file.
        // Each line (Node) occupies a line in the saved file.
        // You may need to handle exception within this method
        // or throw runtime exception only.
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileName))) {
            Node current = head;
            while (current != null) {
                writer.write(current.getLine());
                if (current.getNext() != null) {
                    writer.newLine();
                }
                current = current.getNext();
            }
        } catch (IOException e) {
            throw new RuntimeException("Error writing to file", e);
        }
    }

    public void addLine(String line) {
        // append the line to the end of the list
        Node newNode = new Node(line);
        if (head == null) {
            head = newNode;
        } else {
            Node last = head;
            while (last.getNext() != null) {
                last = last.getNext();
            }
            last.setNext(newNode);
        }
    }

    public void addLine(String line, int n) {
        Node newNode = new Node(line);

        if (head == null || n <= 1) {
            newNode.setNext(head);
            head = newNode;
            return;
        }

        Node current = head;
        int count = 1;
        while (current.getNext() != null && count < n - 1) {
            current = current.getNext();
            count++;
        }

        newNode.setNext(current.getNext());
        current.setNext(newNode);
    }

    public int words() {
        int wordCount = 0;
        Node current = head;
        while (current != null) {
            String line = current.getLine();
            // Use regex to split the line into words using the specified delimiters.
            // Include a negative look-ahead (?!) to ensure that a sequence of delimiters
            // doesn't produce an empty match.
            String[] words = line.split("[\\s\\t,;.?!\\-@'\"\\*:]+");
            for (String word : words) {
                // Ensure the word is not empty or just whitespace
                if (!word.trim().isEmpty()) {
                    wordCount++;
                }
            }
            current = current.getNext();
        }
        return wordCount;
    }

    public int lines() {
        // count number of lines, which is the same as the number of
        // nodes in the list.
        int lineCount = 0;
        Node current = head;
        while (current != null) {
            lineCount++;
            current = current.getNext();
        }
        return lineCount;
    }

    public void delete(int n) {
        if (n <= 1) {
            if (head != null) {
                head = head.getNext();
            }
            return;
        }

        Node current = head;
        int count = 1;

        while (current != null && current.getNext() != null && count < n - 1) {
            current = current.getNext();
            count++;
        }

        if (current != null && current.getNext() != null) {
            current.setNext(current.getNext().getNext());
        }
    }

    public String toString() {
        // Return all lines represented by Nodes in the list. All lines
        // are in the same order as their corresponding nodes in the list.
        // All lines are separated with \n. No newline character should be
        // added after the last line.
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.getLine());
            if (current.getNext() != null) {
                sb.append("\n");
            }
            current = current.getNext();
        }
        return sb.toString();
    }

    public void print() {
        // Print each line. Each line is proceeded with its corresponding line
        // numbers. Please refer to sample output.
        int lineNumber = 1;
        Node current = head;
        while (current != null) {
            System.out.println(lineNumber + ". " + current.getLine());
            lineNumber++;
            current = current.getNext();
        }
    }

    public void replace(String s1, String s2) {
        // Replace all occurrences of s1 with s2.
        Node current = head;
        while (current != null) {
            String updatedData = current.getLine().replace(s1, s2);
            current.setLine(updatedData);
            current = current.getNext();
        }
    }

    public void line(int n) {
        // Print nth line in the document. (The nth node in the list)
        // If nth line does not exists, print �Line n does not exist.�
        if (n <= 0) {
            System.out.println("Line " + n + " does not exist.");
            return;
        }

        Node current = head;
        int count = 1;

        // Traverse the list until the nth node
        while (current != null && count < n) {
            current = current.getNext();
            count++;
        }

        // Check if the current node is null, which means we've reached the end of the
        // list without finding the nth node
        if (current == null) {
            System.out.println("Line " + n + " does not exist.");
        } else {
            // Current is now pointing to the nth node
            System.out.println(current.getLine());
        }
    }
}
