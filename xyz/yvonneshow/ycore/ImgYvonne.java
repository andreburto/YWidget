package xyz.yvonneshow.ycore;

public class ImgYvonne {
    public String thumb;
    public String image;
    
    public ImgYvonne(String t, String i) {
        this.thumb = t;
        this.image = i;
    }
    
    public String toString() {
        return "{t:'"+this.thumb+"',i:'"+this.image+"'}";
    }
}