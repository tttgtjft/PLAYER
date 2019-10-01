import java.util.Arrays;
public class Track {

    private String name;
    private String text;

    public Track(String name, String text) {
        this.name = name;
        this.text = text;
    }



    public String getName() {

        return name;

    }



    public void setName(String name) {

        this.name = name;

    }



    public String getText() {

        return text;

    }



    public void setText(String text) {

        this.text = text;

    }



    @Override

    public String toString() {

        return "Track{" +

                "name='" + name + '\'' +

                ", text='" + text + '\'' +

                '}';

    }


    public boolean equals (Track track){
            if (this.name.equals(track.name) && this.text.equals(track.text)){
            return true;
        }
        return false;
    }
}
