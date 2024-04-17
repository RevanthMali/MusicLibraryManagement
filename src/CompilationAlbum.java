

import java.util.ArrayList;
import java.util.List;

public class CompilationAlbum extends Album {
  private List<Album> originalAlbums;

  public CompilationAlbum(String name, String type, List<MusicTrack> tracks) {
    super(name, type, null); // Compilation albums do not have a single artist, so pass null
    this.originalAlbums = new ArrayList<>();
    for (MusicTrack track : tracks) {
      Album originalAlbum = track.getOriginalAlbum();
      if (originalAlbum != null && !originalAlbums.contains(originalAlbum)) {
        originalAlbums.add(originalAlbum);
      }
    }
  }

  public List<Album> getOriginalAlbums() {
    return originalAlbums;
  }
}
