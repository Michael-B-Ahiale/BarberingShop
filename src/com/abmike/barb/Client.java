package com.abmike.barb;

public class Client {

    private String type;
    private int id;

    public Client(String type, int id) {
        this.type = type;
        this.id = id;
    }

    public String getName(){
        return type+id;
    }

    public boolean isVIP(){
        return type.equals("VIP");
    }

    @Override
    public String toString() {
        return getName();
    }
}
