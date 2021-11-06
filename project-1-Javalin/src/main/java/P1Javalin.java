import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class P1Javalin {
    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {
            config.addStaticFiles("/", Location.CLASSPATH);
        }).start(9000);

        app.post("/add", context -> {
            double number1 = Double.parseDouble(context.formParam("add_num_1"));
            double number2 = Double.parseDouble(context.formParam("add_num_2"));
            System.out.println("Add form POST: number1=" + number1 + " number2=" + number2);
            System.out.println("Add result="+(number1+number2));
            context.result(String.valueOf(number1 + number2));
        });

        app.post("/subtract", context -> {
            double number1 = Double.parseDouble(context.formParam("subtract_num_1"));
            double number2 = Double.parseDouble(context.formParam("subtract_num_2"));
            System.out.println("subtract form POST: number1=" + number1 + " number2=" + number2);
            System.out.println("subtract result="+(number1-number2));
            context.result(String.valueOf(number1 - number2));
        });

        app.post("/multiply", context -> {
            double number1 = Double.parseDouble(context.formParam("multiply_num_1"));
            double number2 = Double.parseDouble(context.formParam("multiply_num_2"));
            System.out.println("multiply form POST: number1=" + number1 + " number2=" + number2);
            System.out.println("multiply result=" + (number1 * number2));
            context.result(String.valueOf(number1 * number2));
        });

        app.post("/divide", context -> {
                double number1 = Double.parseDouble(context.formParam("divide_num_1"));
                double number2 = Double.parseDouble(context.formParam("divide_num_2"));
                System.out.println("divide form POST: number1=" + number1 + " number2=" + number2);
                System.out.println("divide result="+(number1 / number2));
                context.result(String.valueOf(number1 / number2));
        });
    }
}
