import java.util.*;

public class Main {

    public static List<Album> albums=new ArrayList<>();
    public static void main(String[] args) {

        Album album1 = new Album("Moosa", "Sidhu Moosawala");
        album1.addSongtoAlbum("295", 4.05);
        album1.addSongtoAlbum("LastRide", 5.5);
        album1.addSongtoAlbum("So High", 3.05);

        Album album2 = new Album("Arjit's Songs", "Arjit Singh");
        album2.addSongtoAlbum("Kesariya", 5);
        album2.addSongtoAlbum("Jeena Jeena", 4.05);
        album2.addSongtoAlbum("Gerua", 6);

        albums.add(album1);
        albums.add(album2);

        //check album1 sidhu moosawala
        System.out.println(album1.findSong("Gerua"));

        LinkedList<Song> myPlayList = new LinkedList<>();
        album1.addToPlayListFromAlbum("295", myPlayList);
        album2.addToPlayListFromAlbum(2, myPlayList);
        album1.addToPlayListFromAlbum("LastRide",myPlayList);
        album2.addToPlayListFromAlbum("Kesariya",myPlayList);


                        //Song sample=new Song ("abc",6);
                       //System.out.println(sample);

        play(myPlayList);
    }
        public static void play(LinkedList<Song>playList){
            ListIterator<Song>itr=playList.listIterator();
            Scanner sc=new Scanner(System.in);

            boolean isForward=false;

            if(playList.size()>0){
                System.out.println("currently playing");
                System.out.println(itr.next());
                isForward=true;
            }else{
                System.out.println("PlayList is empty");
                return;
            }
            System.out.println("Enter  your choice");
            printMenu();
            boolean quit=false;
            while(!quit){
                int choice=sc.nextInt();
                switch (choice){
                    case 1:
                        if(isForward==false){
                            itr.next();
                            isForward=true;
                        }
                        if(itr.hasNext()){
                            System.out.println(itr.next());
                        }else {
                            System.out.println("you have reached the end of the playlist");
                            isForward=false;
                        }
                        break;
                    case 2:
                        if(isForward==true){
                            itr.previous();
                            isForward=false;
                        }
                        if(itr.hasPrevious()){
                            System.out.println(itr.previous());
                        }else{
                            System.out.println("your are start of the palyList");
                            isForward=true;
                        }
                        break;
                    case 3://repeat the current song
                        if(isForward==true){
                            if(itr.hasPrevious()) {
                                System.out.println(itr.previous());
                                isForward=false;
                            }else {
                                //System.out.println("Song does not exist");
                            }
                        }else{
                            if(itr.hasNext()){
                                System.out.println(itr.next());
                                isForward=true;
                            }else{
                               // System.out.println("Song is Not Present");
                            }
                        }
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        printSongs(playList);
                        break;

                    case 7:
                        quit=true;
                        break;
                }
            }

    }

    public static void printSongs(LinkedList<Song>playList){
        for(Song song :playList){
            System.out.println(song);
            return;
        }
    }
    public static void printMenu(){


        System.out.println("1 play next song");
        System.out.println("2 play prevoious song");
        System.out.println("3 repeat the current song");
        System.out.println("4 Show menu again");
        System.out.println("5 Delete the currnt somg");
        System.out.println("6 Print all the songs in playlist");
        System.out.println("7 Exit");

        return;
    }
}