

import java.util.ArrayList;
import java.util.List;

public class MusicTrack {
    private String title;
    private Artists artist;
    private Album originalAlbum; // Reference to the original album
    private String date;
    private int length;
    private float rating;
    private String location;
    private int size;
    private List<Artists> guestArtists;
    private int playCount;

    public MusicTrack(String title, List<Artists> trackArtists) {
        this.title = title;
        this.artist = trackArtists.isEmpty() ? null : trackArtists.get(0);
        this.guestArtists = new ArrayList<>(trackArtists.subList(1, trackArtists.size()));
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public Artists getArtist() {
        return artist;
    }

    public void setArtist(Artists artist) {
        this.artist = artist;
    }

    public Album getOriginalAlbum() {
        return originalAlbum;
    }

    public void setOriginalAlbum(Album album) {
        this.originalAlbum = album;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void addGuestArtists(Artists artist) {
        if (!guestArtists.contains(artist)) {
            guestArtists.add(artist);
        }
    }

    public List<Artists> getAllArtists() {
        List<Artists> allArtists = new ArrayList<>();
        allArtists.add(artist);
        allArtists.addAll(guestArtists);
        allArtists.addAll(artist.getBandMembers());
        return allArtists;
    }

    public void addToPlayCount() {
        playCount++;
    }

    public int getPlayCount() {
        return playCount;
    } 



    @Override
    public String toString() {
        return "MusicTrack [title=" + title + ", date=" + date + ", length=" + length + ", rating=" + rating
                + ", location=" + location + ", size=" + size + ", guestArtists=" + guestArtists + ", playCount=" + playCount
                + ", originalAlbum=" + (originalAlbum != null ? originalAlbum.getName() : "N/A") + "]";
    }
}
