import java.util.ArrayList;
import java.util.List;
public class Squad {
  private String mName;
  private String mCause;
  private int mId;
  private static List<Squad> squads = new ArrayList<Squad>();
  private List<Hero> mHeros;
  public Squad(String name, String cause){
    mName = name;
    mCause = cause;
    squads.add(this);
    mId= squads.size();
    mHeros = new ArrayList<Hero>();

  }
  public String getName(){
    return mName;
  }
  public String getCause(){
    return mCause;
  }
  public int getId(){
    return mId;
  }
  public static List<Squad> all(){
    return squads;
  }
  public List<Hero> getHeros(){
    return mHeros;
  }
  public void addHero(Hero hero) {
    mHeros.add(hero);
}
  public static void clear() {
  squads.clear();
  }
  public static Squad find(int id) {
    return squads.get(id - 1);
  }

}
