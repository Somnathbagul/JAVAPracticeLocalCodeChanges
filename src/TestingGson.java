//import com.google.gson.Gson;

public class TestingGson {

    static class Student{
        String name;
        String age;
        Student(String name, String age){
            this.age=age;
            this.name=name;
        }

    }
    public static void main(String[] args) {
        System.out.println("test your self!!");

        Student student = new Student("samar","3");
      /*  Gson gson = new Gson();

        String json = gson.toJson(student);
        System.out.println(json);*/

    }
}
