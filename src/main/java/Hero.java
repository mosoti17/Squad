import java.util.ArrayList;
import java.util.List;
public class Hero {
  private String mName;
  private int mAge;
  private String mSuperpowers;
  private String mWeakness;
  private static List<Hero> instances = new ArrayList<Hero>();
  private int mId;
  public Hero(String name, int age, String superpowers, String weakness){
    mName = name;
    mAge = age;
    mSuperpowers = superpowers;
    mWeakness = weakness;
    instances.add(this);
    mId = instances.size();
  }
  public String getName(){
    return mName;
  }
  public int getAge(){
    return mAge;
  }
  public String getSuperpowers(){
  return mSuperpowers;
  }
  public String getWeakness(){
    return mWeakness;
  }
  public static List<Hero> all() {
    return instances;
  }
  public int getId(){
  return mId;
}
public static void clear() {
instances.clear();
}
public static Hero find(int id) {
  return instances.get(id - 1);
}

}
