/**
 * @author Sagar Shah
 * Playing cards from: https://github.com/hayeah/playing-cards-assets
 */
import javafx.scene.image.Image;
public class Card {
    private int rank = -1;
    private String type = "-1";
    Image image = null;

    public Card(String type, int num, String image){
        this.rank=num;
        this.type=type;
        this.image = new Image(image);
    }
    public int getRank(){
        return rank;
    }
    public String getRankString(){
        if(rank==1)
            return "Ace";
        if(rank==2)
            return "2";
        if(rank==3)
            return "3";
        if(rank==4)
            return "4";
        if(rank==5)
            return "5";
        if(rank==6)
            return "6";
        if(rank==7)
            return "7";
        if(rank==8)
            return "8";
        if(rank==9)
            return "9";
        if(rank==10)
            return "10";
        if(rank==11)
            return "Jack";
        if(rank==12)
            return "Queen";
        if(rank==13)
            return "King";
        else return "Who knows";
    }
    public String getType(){
        return type;
    }
    public Image getImage(){
        return image;
    }
}
