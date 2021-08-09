import java.io.*;
import java.util.*;
class Institue{
    static String Iname = "ITNU";

    public String getIname() {
        return Iname;
    }
}
class Employee extends Institue{
    Scanner sc = new Scanner(System.in);
    String name;
    int age;

    public Employee() {
        System.out.print("\n\t\t\tEnter Your name :-");
        this.name = sc.nextLine();
        System.out.print("\t\t\tAge :-");
        this.age = sc.nextInt();

    }

    static void display(){
        System.out.println(Iname);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
class Staff extends Employee{
    static int c;
    String sector;
    int years;

    public Staff() {
        super();
        System.out.println("\t\t\tSelect Sector :-");
        System.out.println("\n\t\t\t[1]  -  Management");
        System.out.println("\n\t\t\t[2]  -  Establishment");
        System.out.println("\n\t\t\t[3]  -  Accounts");
        System.out.println("\n\t\t\t[4]  -  Student-Section");
        System.out.print("\n\t\t\tEnter your choice :-");
        c = sc.nextInt();
        if(c==1){
            this.sector = "Management";
        }
        else if(c==2){
            this.sector = "Establishment";
        }
        else if(c==3){
            this.sector = "Accounts";
        }
        else {
            this.sector = "Student-Section";
        }
        System.out.print("\n\t\t\tEnter years of working :- ");
        this.years = sc.nextInt();
        System.out.println("\n\t\t\t Registration Succesfull");
    }


    public String getSector() {
        return sector;
    }

    public int getYears() {
        return years;
    }
}
class Faculty extends Employee{
    static int c;
    String branch;
    String Course;
    int experience;
    String position;
    String salary;

    public Faculty() {
        super();
        System.out.println("\n\t\t\tSelect Branch :-");
        System.out.println(" \n\t\t\tComputer Science and Engineering    [1]");
        System.out.println(" \t\t\tElectronics and Communication       [2]");
        System.out.println(" \t\t\tMechanical                          [3]");
        System.out.print(" \n\t\t\tEnter Your choice :- ");
        c = sc.nextInt();
        if(c==1){
            this.branch = "Computer Science and Engineering";
            System.out.println("\n\t\t\tSelect course :- ");
            System.out.println("\n\t\t\t [1] - DSA    [2] - OOP   [3] - DBMS");
            System.out.print(" \n\t\t\tEnter Your choice :- ");
            c = sc.nextInt();
            if(c==1){
                this.Course = "DSA";
            }
            else if(c==2){
                this.Course = "OOP";
            }
            else{
                this.Course = "DBMS";
            }
        }
        else if(c==2){
            this.branch = "Electronics and Communication";
            System.out.println("\n\t\t\tSelect course :- ");
            System.out.println("\n\t\t\t[1] - Network Theory    [2] - Digital Logic   [3] - Signal and systems");
            System.out.print(" \t\t\tEnter Your choice :- ");
            c = sc.nextInt();
            if(c==1){
                this.Course = "Network Theory";
            }
            else if(c==2){
                this.Course = "Digital Logic";
            }
            else{
                this.Course = "Signal and systems";
            }
        }
        else{
            this.branch = "Mechanical Engineering";
            System.out.println("\n\t\t\tSelect course :- ");
            System.out.println("\n\t\t\t[1] - Fluid Mechanics    [2] - Static and Dynamics   [3] - Solid Mechanics");

            System.out.print(" \t\t\tEnter Your choice :- ");
            c = sc.nextInt();
            if(c==1){
                this.Course = "Fluid Mechanics";
            }
            else if(c==2){
                this.Course = "Static and Dynamics";
            }
            else{
                this.Course = "Solid Mechanincs";
            }
        }
        System.out.print("\t\t\tEnter your experience :- ");
        this.experience = sc.nextInt();
        if(this.experience <= 5){
            this.position = "Assistant-Professor";
        }
        else if(this.experience >5 && this.experience <=10){
            this.position = "Professor";

        }
        else {
            this.position = "Head-Professor";
        }

    }

    public String getBranch() {
        return branch;
    }

    public String getCourse() {
        return Course;
    }

    public int getExperience() {
        return experience;
    }

    public String getPosition() {
        return position;
    }

    public String getSalary() {
        return salary;
    }
}
class Supp_staff extends Employee{
    static int c;
    String type;
    int daily;
    public Supp_staff() {
        super();
        String s[] = new String[4];
        s[1] = "cleaning";
        s[2] = "plumbing";
        s[3] = "Electric";
        System.out.println("\n\n \t\t       Works available ");
        for(int i=1;i<4;i++){
            System.out.println("\t\t\t"+ i + "    " +s[i] + "    " + ((i+1)*150) );
        }
        System.out.print("\n\t\t\tChoose from above :- ");
        this.daily = sc.nextInt();

        this.type = s[daily];
        this.daily++;
        this.daily *= 150;
    }

    public String getType() {
        return type;
    }

    public int getDaily() {
        return daily;
    }

}

public class CollegeManagmentSystem {
    static  Scanner sc = new Scanner(System.in);
    public static void clearScreen() {

        try {

            if (System.getProperty("os.name").contains("Windows"))

                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

            else

                Runtime.getRuntime().exec("clear");

        } catch (IOException | InterruptedException ex) {}

    }
    public static void insert_staff() throws IOException{
        Staff s = new Staff();
        File file1 = new File("Staff.txt");
        file1.createNewFile();
        BufferedWriter b1 = new BufferedWriter(new FileWriter(file1,true));
        b1.write("Name :- " + s.getName() + "\n");
        b1.write("Age :- " + s.getAge() + "\n");
        b1.write("Sector :- " + s.getSector() +"\n");
        b1.write("Working experience :- " +s.getYears() +"\n\n");
        b1.close();
    }
    public static void display_Staff() throws IOException{
        File file1 = new File("Staff.txt");
        file1.createNewFile();
        if(file1.length()==0){
            System.out.println("\n\n\n \t\t\t No Records Found");
            return;
        }

        String s;
        BufferedReader r = new BufferedReader(new FileReader(file1));

        while ((s = r.readLine() )!= null)
        {
            System.out.println(s);
        }
        r.close();

    }
    public static void insert_faculty() throws IOException{
        Faculty f = new Faculty();
        File file1 = new File("Faculty.txt");
        file1.createNewFile();
        BufferedWriter b1 = new BufferedWriter(new FileWriter(file1,true));
        b1.write("Name :- " + f.getName() + "\n");
        b1.write("Age :- " + f.getAge()   + "\n") ;
        b1.write("Branch :- " + f.getBranch() +"\n");
        b1.write("Course :- " + f.getCourse() +"\n");
        b1.write("Teaching Experince :- " + f.getExperience() +"\n");
        b1.write("Post  :- " + f.getPosition()  + "\n");
        b1.close();




    }
    public static void display_faculty() throws IOException{
        File file1 = new File("Faculty.txt");
        file1.createNewFile();
        if(file1.length()==0){
            System.out.println("\n\n\n \t\t\t No Records Found");
            return;
        }

        String s;
        BufferedReader r = new BufferedReader(new FileReader(file1));
        while ((s = r.readLine() )!= null)
        {
            System.out.println(s);
        }
        r.close();

    }
    public static void insert_suppstaff() throws  IOException{

        Supp_staff ss = new Supp_staff();
        int d,e;
        String method;
        System.out.print("\t\tEnter the number of days your will work :- ");
        d = sc.nextInt();
        System.out.println("\n\t\tYour salary as per " + d + " days will be " + ( d * ss.getDaily()));
        System.out.println("Do you agree (1/0) ");
        e = sc.nextInt();
        if(e==1) {
            System.out.println("\t\tSelect Method of Payment \n \t\t1 - Cheque     2 - cash");
            int i = sc.nextInt();
            if (i == 1) {
                method = "Cheque";
            } else {
                method = "Cash";
            }
            File file1 = new File("C:\\Users\\Priyank Vara\\Desktop\\Supp_staff.txt");
            file1.createNewFile();
            BufferedWriter b1 = new BufferedWriter(new FileWriter(file1, true));
            b1.write("Name :- " + ss.getName() + "\n");
            b1.write("Age :- " + ss.getAge() + "\n");
            b1.write("work  :- " + ss.getType() + "\n");
            b1.write("days worked :- " + d + "\n");
            b1.write("Salary " + (ss.getDaily() * d) + "\n");

            b1.write("Method of Payment :-" + method + "\n\n");
            b1.close();
            System.out.println("\t\t Registration Successful");
        }
        else {
            System.out.println("Registration Unsuccessful");
        }


    }
    static  void display_suppstaff() throws IOException{
        File file1 = new File("C:\\Users\\Priyank Vara\\Desktop\\Supp_staff.txt");

        file1.createNewFile();
        if(file1.length()==0){
            System.out.println("\n\n\n \t\t\t No Records Found");
            return;
        }
        String s;
        BufferedReader r = new BufferedReader(new FileReader(file1));
        while ((s = r.readLine() )!= null)
        {
            System.out.println(s);
        }
        r.close();
    }
    static void menu() throws IOException{
        int t = 0;
        int p=0;
        while (t != 3) {
            clearScreen();
            System.out.println("\n\n\n\n\t\t\t     \tMAIN MENU");
            System.out.println("\n\t\t\t Register \t\t [1]");
            System.out.println("\n\t\t\t Display  \t\t [2]");
            System.out.println("\n\t\t\t Exit     \t\t [3]");
            System.out.print("\n\t\t Enter your Choice :- ");
            t = sc.nextInt();
            switch(t){
                case 1 :
                    clearScreen();
                    System.out.println("\n\n\n\n\t\t\t       Registration");
                    System.out.println("\n\t\t\t Staff         \t\t [1]");
                    System.out.println("\n\t\t\t Faculty       \t\t [2]");
                    System.out.println("\n\t\t\t Support_staff \t\t [3]");
                    System.out.print("\n\t\t Enter your Choice :- ");
                    p = sc.nextInt();
                    switch (p){
                        case 1:
                            clearScreen();
                            System.out.println("\n\n\t\t\t   Staff Registration");
                            insert_staff();
                            char c2= (char) System.in.read();
                            break;
                        case 2:
                            clearScreen();
                            System.out.println("\n\n\t\t\t   Faculty Registration");
                            insert_faculty();
                            char c1= (char) System.in.read();
                            break;
                        case 3:
                            clearScreen();

                            System.out.println("\n\n\t\t\tSupport-Staff Registration");
                            insert_suppstaff();
                            char c= (char) System.in.read();
                            break;
                    }
                    break;
                case 2:
                    clearScreen();
                    System.out.println("\n\n\n\n\t\t\t       Display");
                    System.out.println("\n\t\t\t Staff         \t\t [1]");
                    System.out.println("\n\t\t\t Faculty       \t\t [2]");
                    System.out.println("\n\t\t\t Support_staff \t\t [3]");
                    System.out.print("\n\t\t  Enter your Choice :- ");
                    p = sc.nextInt();
                    switch (p){
                        case 1:
                            clearScreen();
                            System.out.println(" \n\n\t\t\t ITNU");
                            System.out.println("\t\t\t Staff-Members");
                            display_Staff();
                            char ch = (char) System.in.read();
                            break;
                        case 2:
                            clearScreen();

                            System.out.println(" \n\n\t\t\t\t ITNU");

                            System.out.println("\n\t\t\t Faculty-Members");
                            display_faculty();
                            char c= (char) System.in.read();
                            break;
                        case 3:
                            clearScreen();

                            System.out.println(" \n\n\t\t\t\t ITNU");

                            System.out.println(" \n\t\t\t Support-Staff-Members");
                            display_suppstaff();
                            char c2 = (char) System.in.read();
                            break;

                    }
                    break;
                case 3 :
                    clearScreen();
                    System.out.println("\n\n\n\n \t\t\t\t Thank you");
                    System.out.println("\n\t\t\tBy :- 19bce291");
                    break;

            }
        }

    }
    public static void main(String[] args) throws IOException {
        menu();
    }
}
