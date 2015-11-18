package com.denis.models;

/**
 * This class describes the client of clinic
 * Created by Denis on 16.09.2015.
 */
public class Client {

    private int id;
    private String clientName;
    private Pet pet;

    public Client(int id, String clientName,Pet pet){
        this.id = id;
        this.clientName = clientName;
        this.pet = pet;
    }

    public int getId() {
        return this.id;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
}
