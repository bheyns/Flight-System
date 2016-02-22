/*
 Name of Program:FlightsSystem
Date created:24/08/2015
OS used:Windows 8.1
Author:Bernard Heyns - Dv2013-0499
Description:The is the java class that contains all the methods to check the flight priority, send the update when the user updates the table
            and also removes the flights from the doubly linked lists. 
 */
package flightssystem;

// Create the linkedListClass class and declare the variables
public class linkedListClass {
    private int size;
    private node head;
    private node tail;
    // In the constructor , initialise the variables
    public linkedListClass() {
        size = 0;
        head = null;
        tail = null;
    }
    //This method takes the priority and the flight code as parameters
    public void flightPriority(int prio,String code){
        //Create a new instance of the node Object
        node nodePrio = new node(code,null,null,prio);
       //Increment the size variable
        size++;
        //This checks if the head of the node is null
        if (this.head == null) {
          //if it is null , ass the priority to each end of the node(Head and Tail)
            head = nodePrio;
            tail = nodePrio;
          
            //Set the previous and next node to null in the head of the node
            head.setPreviousNode(null);
            head.setNextNode(null);
            return;
            // Else check if the priority in the head is smaller than the current priority
        }else if (head.getPrio() < nodePrio.getPrio()){
           // Set the next and previous node priority in the nodePrio and in the head
            nodePrio.setNextNode(head);
            head.setPreviousNode(nodePrio);
            // Set the priority in the head of the node
            head = nodePrio;
            return;
            // If the tail priority is bigger or equal to the current node priority:
        }else if (tail.getPrio() >= nodePrio.getPrio()){
            // Set the previous node address as tail
            nodePrio.setPreviousNode(tail);
            // Set the tail of the node as next node priority
            tail.setNextNode(nodePrio);
            tail = nodePrio;
            return;
            
        }
        // This will happen outside of the if statement block , it sets the head to node Variable headNode
        node headNode = head;
        // Call the check flight proirity method and send the node priority and the previousy created node variable
        checkFlightPriority(nodePrio,headNode);
}
    // This method checks the priority of the flight
    public void checkFlightPriority(node nodePrio, node codes){
        //If the next node priority is less than the sent node priority , then:
        if (codes.getNextNode().getPrio() < nodePrio.getPrio()) {
            // Create a temporary object of node and assign the code of the flight
            node tempNode = codes.getNextNode();
            // set the priority of the flight to the next node
            codes.setNextNode(nodePrio);
            // Set the codes of the flights in the next and previous nodes 
            nodePrio.setPreviousNode(codes);
            nodePrio.setNextNode(tempNode);
            tempNode.setPreviousNode(nodePrio);
        }else {
            // Else call the check priority method and send the next nodes priority and flight code
        checkFlightPriority(nodePrio,codes.getNextNode());
        }
    }
    
    // This method gets called to update the text area
    public String updateList(){
        // Create a new node object and assign variable n to it
        node n = new node();
        // Set the newly created node to head
        n = head;
        //Clear the list of flight codes
        String listQ = "";
        // Check if there are flights in the box
        if (size == 1){
            // If there is , return the flight codes
            return n.getCodes();
        }
        // Create a variable of the size of the list
        int listSize = size;
        // While there are items in the list it will do the code:
        while (listSize > 0){
            //Add the flight codes to the list 
           listQ += n.getCodes()+"\n";
           // Get the next node and assign it the temporary variable n
            n = n.getNextNode();
            // decrement the size of the list
            listSize--;
        }
        // Return the created list 
        return listQ;
    }
    // This method removes the node from the doubly linked list
    public void removeFlight(){
        // Check if the head does not equal to the tail
        if (head != tail){
            head = head.getNextNode();
            head.setPreviousNode(null);
            // decrement size 
            size --;
         // Else check if the head does not equal to null   
        }else if(head != null){
            // if it does , then set the head and the tail to null
            head = null;
            tail = null;
            // decrement the list size
            size--;
        }
    }
}
