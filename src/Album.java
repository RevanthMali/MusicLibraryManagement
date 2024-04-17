

import java.util.ArrayList;
import java.util.List;

public class Album {
  private String name;
  private String type;
  private Artists artist;
  private List<MusicTrack> tracks;

  public Album(String name, String type, Artists artist) {
    this.name = name;
    this.type = type;
    this.artist = artist;
    this.tracks = new ArrayList<>();
  }

  public void addTrack(MusicTrack track) {

    // check whether the track is existing in the tracks list or not....if not add
    // track to the tracks

    if (!tracks.contains(track)) {
      tracks.add(track);
    }
  }

  public List<MusicTrack> getTracks() {
    return tracks;
  }

  public int overallRunningTime() {
    // initialize the variable to 0
    int TotalTime = 0;
    // Iterate over the Track List using a ForEach and add length of each file
    for (MusicTrack track : tracks) {
      TotalTime += track.getLength();
    }
    return TotalTime;
  }

  public int getOverallFileSize() {
    // initialize the variable to 0
    int totalSize = 0;
    // Iterate over the Track List using a ForEach and add size of each file
    for (MusicTrack track : tracks) {
      totalSize += track.getSize();
    }
    return totalSize;
  }

  // Method to find the average rating of the Track
  public double getAverageRating() {
    // If track if empty simply return the average as 0
    if (tracks.isEmpty()) {
      return 0.0;
    }
    int totalRating = 0;
    for (MusicTrack track : tracks) {
      totalRating += track.getRating();
    }
    return (double) totalRating / tracks.size(); // This returns the average rating for an album
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Artists getArtist() {
    return artist;
  }

  public void setArtist(Artists artist) {
    this.artist = artist;
  }

  public void setTracks(List<MusicTrack> tracks) {
    this.tracks = tracks;
  }

}
