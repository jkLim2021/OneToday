package com.jk.onetoday;

public class Memoitem {
    public String title;
    public String contents;

    public Memoitem() {

    }

    public Memoitem(String title, String contents) {
        this.title = title;
        this.contents = contents;

    }

    public String getTitle(){ return title; }
    public String getContents(){
        return contents;
    }
}

