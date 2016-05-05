package com.homework.chapter1;

/**
 * Created by Nicolas Battiato on 4/5/2016.
 */
public class Message {
    private String message;

    public Message(){
        this.message = new String();
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
