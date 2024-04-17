
import java.util.*;
public class Artists {
  private String name;
  private List<Artists> bandmembers;
  // Define the constructor for Artists class that initializes its contents
  public Artists(String name) {
    this.name = name;
    this.bandmembers = new ArrayList<>();
  } 
  // To retrieve name of the artist
  public String getName() {
    return name;
  } 
  // Define a method to store the band members info
  public void addBandMembers(Artists  artist) {
       // check if he already exists in the band, if not add the artist to the band
    if(!bandmembers.contains(artist)) {
      bandmembers.add(artist);
    } 	
  } 
  public List<Artists> getBandMembers() {
    return bandmembers;
  }
  @Override
  public String toString() {
    return "Artists [name=" + name + ", bandmembers=" + bandmembers + "]";
  }

}
