package org.example;
import org.example.config.Database;
import org.example.models.User;
import org.postgresql.jdbc.FieldMetadata;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.postgresql.Driver;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static spark.Spark.get;
import static spark.Spark.staticFileLocation;

public class App {
    public static void main(String[] args) {

        Sql2o sql2o = Database.getDatabase();

        staticFileLocation("public");

        get("/", (req, res) -> {

            HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();
            Map<String, List<User>> payload = new HashMap<>();

            try (Connection connection = sql2o.open()) {
                List<User> users = connection.createQuery("SELECT * FROM data;")
                        .executeAndFetch(User.class);
                payload.put("users", users);

            } catch (Exception exception) {
                System.out.println("Error");

                System.out.println(exception.getMessage());

            }
            ModelAndView model = new ModelAndView(payload, "home.hbs");
            return engine.render(model);

        });
    }
}
