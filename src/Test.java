import java.util.Arrays;



public class Test {



    public static void main(String[] args) {



        Track[] allTracks = new Track[5];

        PlayList[] playLists = new PlayList[2];



        for(int i = 0; i < allTracks.length; i++){

            allTracks[i] = new Track("track # " + i + 1, "text # " + i + 1);

        }



        System.out.println(getReadableTracks(allTracks));



    }



    private static String getReadableTracks(Track[] tracks){

        String s = "";

        for (int i = 0; i < tracks.length; i++){

            s += "Track (name: \"" + tracks[i].getName() + "\", text: \"" + tracks[i].getText() + "\")\n";

        }

        return s;

    }



    private static PlayList getNewPlaylist(String name){

        return new PlayList(name, new Track[10]);



    }





}
