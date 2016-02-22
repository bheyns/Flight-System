/*
 Name of Program:FlightsSystem
Date created:24/08/2015
OS used:Windows 8.1
Author:Bernard Heyns - Dv2013-0499
Description:node.java-The is the class that is responsible for getting and setting the flight priority and the flight codes,
              it is a 'user-defined' class with an empty constructer and getters and setters. 
 */
package flightssystem;

/**
 *
 * @author Bernard Heyns
 */
 //Create an object class type node which holds all the needed info on a node such as priority and codes , as well as their addresses
public class node {
    
    // Declare the variables as private 
    private String codes;
    private node nextNode;
    private node previousNode;
    private int prio;

    public node() {
        // Initialise the variables
        codes = "";
        nextNode = null;
        previousNode = null;
        prio = 0;
        
    }
    //The constructer that recieves the cods, next and previous nodes and the priority
    public node(String codes, node nextNode, node previousNode, int prio) {
        this.codes = codes;
        this.nextNode = nextNode;
        this.previousNode = previousNode;
        this.prio = prio;
    }
// Getters and setters to assign the values and return them for easy usage by other classes.
    public String getCodes() {
        return codes;
    }

    public void setCodes(String codes) {
        this.codes = codes;
    }

    public node getNextNode() {
        return nextNode;
    }

    public void setNextNode(node nextNode) {
        this.nextNode = nextNode;
    }

    public node getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(node previousNode) {
        this.previousNode = previousNode;
    }

    public int getPrio() {
        return prio;
    }

    public void setPrio(int prio) {
        this.prio = prio;
    }
    
    
}
