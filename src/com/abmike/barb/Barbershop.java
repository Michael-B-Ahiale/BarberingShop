package com.abmike.barb;

import java.util.LinkedList;
import java.util.Queue;

public class Barbershop {

    private Client mainChair;
    private Queue<Client> waitingChairs;
    private int maxWaitingChairs;
    private int ordCount;
    private int vipCount;

    public Barbershop(int maxWaitingChairs) {
        this.maxWaitingChairs = maxWaitingChairs;
        this.waitingChairs = new LinkedList<>();
        this.ordCount = 0;
        this.vipCount = 0;
    }

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
                int vipIndex=findLastVIPIndex();
                insertVIP(newClient,vipIndex);
            }else{
                waitingChairs.offer(newClient);
            }
            return true;
        }
        return false;
    }
        private int findLastVIPIndex(){
        int index=0;
        for(Client client:waitingChairs){
            if(!client.isVIP()){
                break;
            }
            index++;
        }
        return index;
        }

        private void insertVIP(Client vipClient, int index){
        //created a temporary linked list
        LinkedList<Client> tempList=new LinkedList<>(waitingChairs);
        tempList.add(index,vipClient);
        waitingChairs=tempList;
        }

        public Client removeClient(){
        Client leavingClient=mainChair;
        mainChair=waitingChairs.poll();
        return leavingClient;
        }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (mainChair != null) {
            sb.append(mainChair);
        }
        for (Client client : waitingChairs) {
            sb.append(", ").append(client);
        }
        sb.append("]");
        return sb.toString();
    }

}
