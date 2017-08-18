

import org.junit.*;
import static org.junit.Assert.*;
public class SquadTest{
  @After
  public void clearTestData(){
    Squad.clear();
  }

  @Test
  public void squad_squadInstantatesCorrectly_true(){
    Squad testSquad = new Squad("Marvels", "Recover all infinity stones");
    assertTrue( testSquad instanceof Squad);
  }
  @Test
public void getName_nameInstatentsCorrectly_marvels(){
  Squad testSquad = new Squad("Marvels", "Recover all infinity stones");
  assertEquals("Marvels", testSquad.getName());
}
@Test
public void getCause_causeInstatentsCorrectly(){
Squad testSquad = new Squad("Marvels", "Recover all infinity stones");
assertEquals("Recover all infinity stones", testSquad.getCause());
}
@Test
public void all_returnsAllInstancesOfSsuad(){
Squad testSquad1 = new Squad("Marvels", "Recover all infinity stones");
Squad testSquad2 = new Squad("Gurdians", "Save the galaxy");
assertTrue(Squad.all().contains(testSquad1));
assertTrue(Squad.all().contains(testSquad2));
}
@Test
public void addHero_addNewHeroToSquad(){
  Squad testSquad = new Squad("Marvels", "Recover all infinity stones");
  Hero myHero = new Hero("Ironman", 35, "Flys", "Mean at times");
  testSquad.addHero(myHero);
  assertTrue(testSquad.getHeros().contains(myHero));
}
@Test
public void getId_getIdOfTheSquadAdded(){
Squad testSquad = new Squad("Marvels", "Recover all infinity stones");
assertEquals(1,testSquad.getId());
}
@Test
  public void Squad_returnsWithSameIdAstestSquad2() {
    Squad testSquad1 = new Squad("Marvels", "Recover all infinity stones");
    Squad testSquad2 = new Squad("Gurdians", "Save the galaxy");
    assertEquals(Squad.find(testSquad2.getId()),testSquad2);
  }

}
