public class Student implements Comparable<Student>{
  private String name = null;
  private int number = 0;
  private boolean canChooseTurn = false;
  
  private Student(){}
  private Student(String name, int number, boolean canChooseTurn){
    this.name = name;
    this.number = number;
    this.canChooseTurn = canChooseTurn;
  }
  public Student(String line){
    String[] attributes = line.split("[;,]");
    this.name = attributes[0];
    this.number = Integer.parseInt(attributes[1]);
    this.canChooseTurn = Boolean.parseBoolean(attributes[2]);
  }

  public int getNumber() {
    return this.number;
  }

  public int compareTo(Student other) {
    if(this.getNumber() > other.getNumber()) return 1;
    if(this.getNumber() == other.getNumber()) return 0;
    return -1;
  }

  public String toString(){
    return "[STUDENT " + this.number + "]" +
      "\n\tName: " + this.name +
      "\n\tCan choose turn: " + this.canChooseTurn;
  }

  public String toLine(){
    return "[" + number + "] " + name;
  }
}
