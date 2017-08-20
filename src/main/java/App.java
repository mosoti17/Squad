import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.List;
import java.util.ArrayList;
public class App {

    public static void main(String[] args) {
      staticFileLocation("/public");

      String layout = "templates/layout.vtl";

      get("/", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("squads", Squad.all());
        model.put("template", "templates/index.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());


      post("/", (request, response) -> {
          Map<String, Object> model = new HashMap<String, Object>();
          String name = request.queryParams("name");
          String cause = request.queryParams("cause");
          Squad newSquad = new Squad(name,cause);
          model.put("squads", Squad.all());
          model.put("heros", Hero.all());
          model.put("template", "templates/index.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        post("/hero", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("name");
            int age = Integer.parseInt(request.queryParams("age"));
            String strength = request.queryParams("strength");
            String weakness = request.queryParams("weakness");
            Hero newHero = new Hero(name, age, strength, weakness);
            model.put("squads", Squad.all());
            model.put("heros", Hero.all());
            model.put("template", "templates/hero.vtl");
            return new ModelAndView(model, layout);
          }, new VelocityTemplateEngine());

          get("/hero", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("heros", Hero.all());
            model.put("template", "templates/hero.vtl");
            return new ModelAndView(model, layout);
          }, new VelocityTemplateEngine());

        get("/squad/:id", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        Squad squad = Squad.find(Integer.parseInt(request.params(":id")));
        model.put("squad", squad);
        model.put("heros", Hero.all());
        model.put("template", "templates/squad.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      post("/squad/:squadid/assignhero/:heroid", (request, response) -> {
          Map<String, Object> model = new HashMap<String, Object>();
          Hero myHero = Hero.find(Integer.parseInt(request.params(":heroid")));
          Squad mySquad = Squad.find(Integer.parseInt(request.params(":squadid")));
          mySquad.addHero(myHero);
          model.put("squad", mySquad);
          model.put("heros", Hero.all());
          model.put("template", "templates/squad.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());


    }
}
