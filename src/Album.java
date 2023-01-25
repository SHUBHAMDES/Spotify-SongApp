import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {

   private String name;
    private String artist;
    private List<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
       this.songs=new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public boolean findSong(String title){
        for(Song s: songs){
         if(s.getTitle().equals(title))//equals method use to compare two object
             return true;
        }
          return false;
    }

    public void addSongtoAlbum(String title,double duration){
        Song s=new Song(title,duration);
       // songs.add(s);
        if(findSong(s.getTitle())==true){
            System.out.println("song already present in album");
        }else{
            songs.add(s);
            System.out.println("New Song Has ben Added");
        }
          return;
    }
    //polymorphism
    public void addToPlayListFromAlbum(String title, LinkedList<Song>playList){

        if (findSong(title)==true){
            for(Song song:songs){
                if(song.getTitle().equals(title)){
                    playList.add(song);
                    System.out.println("Song Has Been Added to Your PlayList");
                    break;
                }
            }
        }else{
            System.out.println("Song is Not Present in album");
        }
    }

    public void addToPlayListFromAlbum(int tracNo,LinkedList<Song>playList){
//tarckNO-means (Song Number)
        int index=tracNo-1;
        if(index>=0&&index<songs.size()){
            System.out.println("Song Has Been Added to Your PlayList");
            playList.add(songs.get(index));
        }else{
            System.out.println("Invalid Trac Number");
        }
    }
}
