import java.util.ArrayList;
import java.util.Scanner;



public class Player {
    private static final int SIZE_OF_TRACK_LIST = 100;
    private static final int SIZE_OF_PLAYLIST_LIST = 10;
    private static final int SIZE_OF_TRACKS_IN_PLAYLIST = 10;
    private static final int ZERO = 0;
    private static final String COMMANDS =
            "\n1 - print all tracks\n" +
                    "2 - add track in tracklist\n" +
                            "3 - create new playlist\n" +
                                    "4 - quit";
    private static final String WELCOME_PAGE = "Welcome!";
    private static final String ERROR_MESSAGE = "Error";
    private static final String NAME_PLAYLIST = "Enter name of PLayList";
    private static final String QUESTION_ADD_TRACKS_IN_PLAYLIST = "Do you want to add some tracks in your new playlist?\n0 - yes\n1 - no";
    private static final String ENTER_NAME_OF_TRACK = "Enter name of track which you want to add";
    private static final String LIMIT_OF_TRACKS_IN_PLAYLIST = "Sorry, you can add only 10 tracks in your playlist, not more";
    private static final String QUESTION_EXIT_FROM_PLAYLIST = "Do you want to exit from adding tracks in your playlist?\n0 - yes\n1 - no";
    private static final String ENTER_TEXT_OF_TRACK = "Enter text of track";
    private static final String MESSAGE_ABOUT_SUCCESSFULLY_ADDING_TRACK = "You`ve added track in tracklist successfully!";
    private static final String QUESTION_ABOUT_EXIT_OR_RETURN_IN_MENU = "Do you want to\n1 - return in menu\n2 - exit from player";
    private static final String MESSAGE_BYE = "Goodbye!";
    private static final String MESSAGE_SAME_TRACK = "Sorry, there is already such a track in tracklist";
    private static final String MESSAGE_SAME_TRACK_PLAYLIST = "Sorry, there is such a track in playlist";
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        ArrayList<Track> list = new ArrayList<>();
        for (int x = 0; x < SIZE_OF_TRACK_LIST; x++){
            list.add(x,null);
        }
        PlayList[] playLists = new PlayList[SIZE_OF_PLAYLIST_LIST];
        System.out.println(WELCOME_PAGE);
        System.out.println(COMMANDS);

        while (sc.hasNext()) {
            int check = sc.nextInt();
            if(check == 1){
                System.out.println(getReadableTracks(list));
            }else if(check == 2) {
                int checking = 0;
                System.out.println(ENTER_NAME_OF_TRACK);
                String nameOfTrack = sc.next();
                if (sc.hasNextLine()){
                    System.out.println(ENTER_TEXT_OF_TRACK);
                }
                String textOfTrack = sc.next();
                if (sc.hasNextLine()){
                    getNewTrack (nameOfTrack, textOfTrack, list);
                }
                for (int x = 0; x < SIZE_OF_TRACK_LIST - 1; x++){
                    for (int y = x + 1; y < SIZE_OF_TRACK_LIST; y++){
                        if (list.get(x) != null && list.get(y) != null){
                            if (list.get(x).equals(list.get(y)) == true){
                                list.remove(y);
                                System.out.println(MESSAGE_SAME_TRACK);
                                checking = y;
                                continue;
                            }
                        }
                    }
                }
                if (list.get(checking) != null){
                    System.out.println(MESSAGE_ABOUT_SUCCESSFULLY_ADDING_TRACK);
                }
                }else if(check == 3){
                int checking = 0;
                System.out.println(NAME_PLAYLIST);
                String nameOfPlayList = sc.next();
                for (int x = 0; x < playLists.length; x++){
                    if (playLists[x] == null){
                        playLists[x] = getNewPlaylist(nameOfPlayList);
                        checking = x;
                        break;
                    }
                }
                if (sc.hasNextLine()){
                    System.out.println(QUESTION_ADD_TRACKS_IN_PLAYLIST);
                }
                sc.match();
                int second_check = sc.nextInt();
                first:if (second_check == 0){
                    while(sc.hasNext()){
                        System.out.println(ENTER_NAME_OF_TRACK);
                        String nameOfTrack = sc.next();
                        if (sc.hasNext()){
                            addTrackInPlayList(nameOfTrack, playLists[checking], list);
                        }
                        if (isInPlayList(playLists[checking])){
                            System.out.println(MESSAGE_SAME_TRACK_PLAYLIST);
                        }
                        if  (playLists[checking].getTracks()[9] != null){
                            System.out.println(LIMIT_OF_TRACKS_IN_PLAYLIST);
                            break;
                        }
                        System.out.println(QUESTION_EXIT_FROM_PLAYLIST);
                        sc.next();
                        check = sc.nextInt();
                        if (check == 0){
                            break;
                        }
                    }
                }
            }else if (check == 4){
                break;
            }
            System.out.println(COMMANDS);
        }
    }


      private static String getReadableTracks(ArrayList<Track> list){
        String s = "";
        for (int i = 0; i < SIZE_OF_TRACK_LIST; i++){
            s += (i + 1) + ") ";
            if(list.get(i) == null){
                s += "Empty track";
            } else {
                s += "Track (name: \"" + list.get(i).getName() + "\", text: \"" + list.get(i).getText() + "\")";
            }
            s += "\n";
        }
        return s;
    }





    private static PlayList getNewPlaylist(String name){
        Track[] tracks = new Track[SIZE_OF_TRACKS_IN_PLAYLIST];
        PlayList playList = new PlayList(name, tracks);
        return playList;
    }

    private static Track getNewTrack (String name, String text, ArrayList<Track> list){
        int check = 0;
        for (int x = 0; x < SIZE_OF_TRACK_LIST; x++){
            if (list.get(x) == null){
                list.add(x, new Track(name, text));
                check = x;
                break;
            }
        }
        return list.get(check);
    }


    public static Track addTrackInPlayList(String name, PlayList playLists, ArrayList<Track> list){
        int check = SIZE_OF_TRACKS_IN_PLAYLIST - 1;
        for (int x = 0; x < SIZE_OF_TRACKS_IN_PLAYLIST; x++){
            if (playLists.getTracks()[x] == null && list.get(x) != null){
                if (name == list.get(x).getName()){
                    playLists.getTracks()[x] = list.get(x);
                    return playLists.getTracks()[x];
                }
                System.out.println("Sorry, there is not such a track in tracklist");
            }
        }
        return playLists.getTracks()[check];
    }

    public static boolean isInPlayList(PlayList playLists){
        for (int x = 0; x < SIZE_OF_TRACKS_IN_PLAYLIST - 1; x++){
                for (int y = x + 1; y < SIZE_OF_TRACKS_IN_PLAYLIST; y++){
                    if (playLists.getTracks()[x] != null && playLists.getTracks()[y] != null){
                        if (playLists.getTracks()[x].equals(playLists.getTracks()[y])){
                            playLists.getTracks()[y] = null;
                            return true;
                        }
                    }

                }
        }
        return false;
    }
}