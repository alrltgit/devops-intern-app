public class HelloApp {
    public static String buildGreeting(String name) {
        return "Hello, " + name + "! This is a simple Java app running in Docker.";
    }

    public static void main(String[] args) {
        String name = System.getenv("NAME");
        if (name == null || name.isEmpty()) {
            name = "Intern";
        }
        System.out.println(buildGreeting(name));
    }
}
