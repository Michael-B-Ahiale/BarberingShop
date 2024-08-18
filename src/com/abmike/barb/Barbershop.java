package com.abmike.barb;

import java.util.LinkedList;
import java.util.Queue;

public class Barbershop {

    private Client mainChair;
    private Queue<Client> waitingChairs;
    private int maxWaitingChairs;
    private int ordCount;
    private int vipCount;

    //Method to add a client based on the type
    public boolean addClient(String type){
        Client newClient;
        if(type.equals("VIP")){
            newClient=new Client("VIP",++vipCount);
        }else{
            newClient=new Client("ORD",++ordCount);
        }

        if(mainChair==null){
            mainChair=newClient;
            return true;
        }else if(waitingChairs.size()<maxWaitingChairs){
            if(newClient.isVIP()){

            }
        }
    }


}
