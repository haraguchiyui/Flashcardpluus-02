package com.example.yui06.flushcardplus;

public class card {
    public int imageId;
    public String title;
    public String content;
    public int likeNum=0;

    public String meaning;

    public card(int imageId,String title,String content,String  meaning){
        this.imageId=imageId;
        this.title=title;
        this.content=content;
        this.meaning=meaning;

    }

}
