import java.io.IOException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main{
  public static void main(String[] args){
    String studentsFile = args[0];
    String outFile = "turns.txt";
    
    int turnCount;
    if((args.length) >= 3) {
      outFile = args[1];
      turnCount = Integer.parseInt(args[2]);
    } else {
      turnCount = Integer.parseInt(args[1]);
    }

    ArrayList<Student> students = new ArrayList<Student>();
    try {
      FileReader fr = new FileReader(studentsFile);
      BufferedReader br = new BufferedReader(fr);

      String line = br.readLine();
      while(line != null) {
        students.add(new Student(line));
        line = br.readLine();
      }
      br.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    // Dont even ask why i have a sorting algorithm
    // Collections.sort(students);
    
    Collections.shuffle(students);
    
    int i = 0;
    for(Student s : students){
      if((i % turnCount) == 0)
        System.out.println("-----=====-----\nTurn #" + (i / turnCount + 1));
      System.out.println(s);
      i++;
    }
    System.out.println("-----=====-----");

    try {
      PrintWriter pr = new PrintWriter(outFile);

      i = 0;
      for(Student s : students){
        if((i % turnCount) == 0) pr.println("--- TURN #" + (i / turnCount + 1) + " ---");
        pr.println(s.toLine());
        i++;
      }
  
      pr.close();
  
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

