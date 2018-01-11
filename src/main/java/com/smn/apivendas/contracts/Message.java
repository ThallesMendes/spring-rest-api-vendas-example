package com.smn.apivendas.contracts;

public class Message {

    private String message;
    private Object content;

    public Message(String message){
        this.message = message;
    }

    public Message(String message, Object content){
        this.message = message;
        this.content = content;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
