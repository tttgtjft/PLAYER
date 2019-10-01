import java.util.ArrayList;
import java.util.Arrays;



public class PlayList {

    private static final int SIZE_OF_TRACKS_IN_PLAYLIST = 10;

    private String name;

    private Track[] tracks;



    public PlayList(String name, Track[] tracks) {

        this.name = name;

        this.tracks = tracks;

    }



    public String getName() {

        return name;

    }



    public void setName(String name) {

        this.name = name;

    }



    public Track[] getTracks() {

        return tracks;

    }



    public void setTracks(Track[] tracks) {

        this.tracks = tracks;

    }


    @Override

    public String toString() {

        return "PlayList{" +

                "name='" + name + '\'' +

                ", tracks=" + Arrays.toString(tracks) +

                '}';

    }



}