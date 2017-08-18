import org.junit.*;
import static org.junit.Assert.*;
public class HeroTest {
  @After
public void clearTestData(){
  Hero.clear();
}

  @Test
public void Hero_istatatesCorrectly_true(){
  Hero myHero = new Hero("Ironman", 35, "Flys", "Mean at times");
  assertTrue(myHero instanceof Hero);
}
@Test
  public void Hero_instantiatesWithName_String() {
    Hero myHero = new Hero("Ironman", 35, "Flys", "Mean at times");
    assertEquals("Ironman", myHero.getName());
  }
@Test
  public void Hero_instantiatesWithAge_int() {
    Hero myHero = new Hero("Ironman", 35, "Flys", "Mean at times");
    assertEquals(35, myHero.getAge());
  }
@Test
  public void Hero_instantiatesWithSuperpowers_String() {
    Hero myHero = new Hero("Ironman", 35, "Flys", "Mean at times");
    assertEquals("Flys", myHero.getSuperpowers());
  }
  @Test
    public void Hero_instantiatesWithweekness_String() {
      Hero myHero = new Hero("Ironman", 35, "Flys", "Mean at times");
      assertEquals("Mean at times", myHero.getWeakness());
    }
    @Test
      public void Hero_returnsAllInstances() {
        Hero myHero1 = new Hero("Ironman", 35, "Flys", "Mean at times");
        Hero myHero2 = new Hero("Superman", 200, "Super strength", "kryptonite");
        assertTrue(Hero.all().contains(myHero1));
        assertTrue(Hero.all().contains(myHero2));
      }

      @Test
  public void getId_tasksInstantiateWithAnID_1() {
    Hero myHero = new Hero("Ironman", 35, "Flys", "Mean at times");
    assertEquals(1, myHero.getId());
  }
  @Test
    public void Hero_returnsWithSameIdAsHero2() {
      Hero myHero1 = new Hero("Ironman", 35, "Flys", "Mean at times");
      Hero myHero2 = new Hero("Superman", 200, "Super strength", "kryptonite");
      assertEquals(Hero.find(myHero2.getId()),myHero2);
    }

}
