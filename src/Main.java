
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    MusicLibrary musicLibrary = new MusicLibrary();
    List<Artists> artistsList = new ArrayList<>();

    while (true) {
      System.out.println("Menu:");
      System.out.println("1. Add Artist");
      System.out.println("2. Add Album");
      System.out.println("3. Add Track");
      System.out.println("4. List Tracks with Lowest Rating");
      System.out.println("5. Backup Music Tracks to Discs");
      System.out.println("6. Exit");
      System.out.print("Enter your choice: ");
      int choice = sc.nextInt();

      switch (choice) {
        case 1:
          System.out.print("Enter the artist name: ");
          String artistName = sc.next();
          Artists artist = new Artists(artistName);
          artistsList.add(artist);
          System.out.println("Artist added: " + artistName);
          break;

        case 2:
          if (artistsList.isEmpty()) {
            System.out.println("No artists available. Please add an artist first.");
          } else {
            System.out.print("Enter album name: ");
            String albumName = sc.next();
            System.out.print("Enter album type: ");
            String albumType = sc.next();
            System.out.print("Enter the artist for this album: ");
            String artistNameForAlbum = sc.next();

            Artists albumArtist = findArtistByName(artistsList, artistNameForAlbum);

            if (albumArtist == null) {
              System.out.println("Artist not found. Please add the artist first.");
            } else {
              Album album = new Album(albumName, albumType, albumArtist);
              musicLibrary.addAlbum(album);
              System.out.println("Album added: " + albumName);
            }
          }
          break;

        case 3: 
          try{
          if (artistsList.isEmpty()) {
            System.out.println("No artists available. Please add an artist first.");
          } else if (musicLibrary.getAlbums().isEmpty()) {
            System.out.println("No albums available. Please add an album first.");
          } else {
            System.out.print("Enter the number of artists for this track: ");
            int numArtists = sc.nextInt();
            ArrayList<Artists> trackArtists = new ArrayList<>();

            for (int i = 0; i < numArtists; i++) {
              System.out.print("Enter artist " + (i + 1) + " name: ");
              String artistNameForTrack = sc.next();
              Artists matchingArtist = findArtistByName(artistsList, artistNameForTrack);

              if (matchingArtist == null) {
                System.out.println("Artist not found. Please add the artist first.");
                break;
              }
              trackArtists.add(matchingArtist);
            }

            if (!trackArtists.isEmpty()) {
              System.out.print("Enter the music track: ");
              String trackTitle = sc.next();
              MusicTrack track = new MusicTrack(trackTitle, trackArtists);

              System.out.print("Enter date for this track (yyyy/mm/dd): ");
              String date = sc.next();
              System.out.println();
              track.setDate(date);

              System.out.print("Enter Track length (in sec): ");
              int length = sc.nextInt();
              track.setLength(length);

              System.out.print("Enter the rating: ");
              float rating = sc.nextFloat();
              track.setRating(rating);

              System.out.print("Enter the location (album/trackname/typeof file): ");
              String path = sc.next();
              track.setLocation(path);

              System.out.print("Enter the size of the file (in MB): ");
              int size = sc.nextInt();
              track.setSize(size);

              System.out.print("Enter the name of the original album (if any): ");
              String originalAlbumName = sc.next();
              Album originalAlbum = findAlbumByName(musicLibrary.getAlbums(), originalAlbumName);
              if (originalAlbum != null) {
                track.setOriginalAlbum(originalAlbum);
              }

              musicLibrary.addTrack(track);
              System.out.println("Track added: " + trackTitle);
            }
          } 
          } catch(Exception e){
            System.out.println("Invalid input. Please try again.");
          }
          break;

        case 4:
          List<MusicTrack> lowestRatedTracks = musicLibrary.getTracksWithLowestRating();
          if (lowestRatedTracks.isEmpty()) {
            System.out.println("No tracks found with a rating.");
          } else {
            System.out.println("Tracks with the lowest rating:");
            for (MusicTrack track : lowestRatedTracks) {
              System.out.println(track.getTitle() + " - Rating: " + track.getRating());
            }
          }
          break;

        case 5:
          System.out.print("Enter the disc capacity (in MB): ");
          int discCapacity = sc.nextInt();
          List<List<MusicTrack>> backupDiscs = musicLibrary.backupMusicTracks(discCapacity);

          int discNumber = 1;
          for (List<MusicTrack> disc : backupDiscs) {
            System.out.println("Disc " + discNumber + ":");
            for (MusicTrack track : disc) {
              System.out.println("  " + track.getTitle() + " - " + track.getSize() + " MB");
            }
            discNumber++;
          }
          break;

        case 6:
          System.out.println("Exiting the program.");
          System.exit(0);
          break;

        default:
          System.out.println("Invalid choice. Please select a valid option.");
      }
    }
  }

  private static Artists findArtistByName(List<Artists> artists, String name) {
    for (Artists artist : artists) {
      if (artist.getName().equals(name)) {
        return artist;
      }
    }
    return null;
  }

  private static Album findAlbumByName(List<Album> albums, String name) {
    for (Album album : albums) {
      if (album.getName().equals(name)) {
        return album;
      }
    }
    return null;
  }
}
