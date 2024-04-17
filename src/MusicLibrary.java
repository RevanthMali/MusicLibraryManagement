

import java.util.*;

public class MusicLibrary {

  private List<Album> albums;
  private List<MusicTrack> tracks;

  public MusicLibrary() {
    this.tracks = new ArrayList<>();
    this.albums = new ArrayList<>();
  }

  // Method to add a music track
  public void addTrack(MusicTrack track) {
    if (!tracks.contains(track)) {
      tracks.add(track);
    }
  }

  // Method to add an Album
  public void addAlbum(Album album) {
    if (!albums.contains(album)) {
      albums.add(album);
      tracks.addAll(album.getTracks());
    }
  }

  // Method to get the tracks with the lowest rating
  public List<MusicTrack> getTracksWithLowestRating() {
    // wrapper class of Integer
    float lowestRating = Integer.MAX_VALUE;
    // Create an ArrayList to store the lowest rated tracks
    List<MusicTrack> lowestRatedTracks = new ArrayList<>();
    // Iterate over tracks List
    for (MusicTrack track : tracks) {
      if (track.getRating() < lowestRating) {
        // If the current track contains lowest rating assign it to variable
        // 'lowestRating'
        lowestRating = track.getRating();
        lowestRatedTracks.clear();
        lowestRatedTracks.add(track); // add the track to the list
      }
      // else if (track.getRating() == lowestRating) {
      // lowestRatedTracks.add(track);
      // }
    }

    return lowestRatedTracks;
  }

  public List<Album> getAlbums() {
    return albums;
  }

  public void setAlbums(List<Album> albums) {
    this.albums = albums;
  }

  public List<MusicTrack> getTracks() {
    return tracks;
  }

  public void setTracks(List<MusicTrack> tracks) {
    this.tracks = tracks;
  }

  public List<List<MusicTrack>> backupMusicTracks(int discCapacity) {
    List<List<MusicTrack>> backupDiscs = new ArrayList<>();
    List<MusicTrack> remainingTracks = new ArrayList<>();

    while (!remainingTracks.isEmpty()) {
      List<MusicTrack> currentDisc = new ArrayList<>();
      int remainingCapacity = discCapacity;

      for (MusicTrack track : new ArrayList<>(remainingTracks)) {
        if (track.getSize() <= remainingCapacity) {
          currentDisc.add(track);
          remainingCapacity -= track.getSize();
          remainingTracks.remove(track);
        }
      }

      backupDiscs.add(currentDisc);
    }

    return backupDiscs;
  }

  @Override
  public String toString() {
    return "MusicLibrary [albums=" + albums + ", tracks=" + tracks + "]";
  }

}
