public class Course {
    int courseId;
    String title;
    int duration;
    double price;

    public Course(int courseId,String title,int duration,double price){
        this.courseId = courseId;
        this.title = title;
        this.duration = duration;
        this.price = price;
    }

    void welcome(){
        System.out.println("Welcome to online learning platform.");
    }
}

class ProgrammingCourse extends Course {

    String programmingLanguage;
    public ProgrammingCourse(int courseId, String title, int duration, double price,String programmingLanguage) {
        super(courseId, title, duration, price);
        this.programmingLanguage = programmingLanguage;
    }

    void enroll(){
        System.out.println("Enrolled in Programming Course.");
    }
}

class AdvancedProgrammingCourse extends ProgrammingCourse{
    public AdvancedProgrammingCourse(int courseId,String title,int duration,double price,String ProgrammingLanguage){
        super(courseId,title,duration,price,ProgrammingLanguage);
    }

    void enroll(){
        System.out.println("Enrolled in Advanced Programming Course too.");
    }
}

class MathCourse extends Course{

    String topicsCovered;
    public MathCourse(int courseId,String title,int duration,double price,String topicsCovered){
        super(courseId,title,duration,price);
        this.topicsCovered = topicsCovered;
    }

    void enroll(){
        System.out.println("Enrolled in Mathematics Course.");
    }
}



class OnlineLearningPlatform {
    public static void main(String args[]) {
        ProgrammingCourse pc= new ProgrammingCourse(1,"Introduction to Programming",3,4000,"Java");
        MathCourse mc = new MathCourse(2,"Mathematics for Data Scientists",3,4000,"Integration,Differenciation");
        AdvancedProgrammingCourse apc = new AdvancedProgrammingCourse(3,"Advanced Programming",3,4000,"Advanced Java");
        pc.enroll();
        pc.welcome();
        mc.enroll();
        mc.welcome();
        apc.welcome();
        apc.enroll();

    }
}


