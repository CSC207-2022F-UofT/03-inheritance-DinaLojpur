/*
 * This file defines an abstract class named Bag.
 * In this exercise, you will be writing a larger class according to
 * the TODOs we have left you. You may find the readings in chapter
 * 1. Introduction to Java helpful.
 */

public abstract class Bag {
    /*
     * TODO: Create the following private instance variables
     *       - a String named color
     *       - an int named numberOfContents
     *       - an int named capacity
     *       - an array of Strings named contents
     */
    private String color;
    private int numberOfContents;
    private int capacity;
    private String[] contents;


    /*
     * TODO: Create a constructor that takes two arguments:
     *       - a String representing the Bag's colour
     *       - an int representing the Bag's capacity
     *
     * The other attributes (private instance variables) should
     * be empty (e.g. numberOfContents is 0 and an empty String array for
     * its contents.)
     */
    public Bag(String bag_colour, int bag_capacity){
        this.color = bag_colour;
        this.capacity = bag_capacity;
        this.numberOfContents = 0;
        this.contents = new String[capacity];
    }


    /*
     * TODO: Create a variety of 'getter' functions.
     *       These should be named:
     *           - getColor
     *           - getNumberOfContents
     *           - getCapacity
     */
    public String getColor(){
        return this.color;
    }
    public int getNumberOfContents(){
        return this.numberOfContents;
    }
    public int getCapacity(){
        return this.capacity;
    }


    /*
     * TODO: Create a setter function called setColor which sets the
     *       color of this bag to the given color.
     */
    public void setColor(String given_colour){
        this.color = given_colour;
    }


    /*
     * TODO: Create a method called addItem that takes in a String
     *       representing an item in the Bag.
     *       The item is added into the Bag if the number of items
     *       in the bag is < the capacity of the Bag.
     *       Remember to modify numberOfContents accordingly.
     *
     *       This method should return true if the item was added
     *       and false otherwise.
     */
    public boolean addItem(String item_in_bag){
        if (this.getNumberOfContents() < this.getCapacity()){
            String[] new_numberOfContents = new String[capacity];

            for (int content_index = 0; content_index + 1 <= this.getNumberOfContents(); content_index++)
                new_numberOfContents[content_index] = this.contents[content_index];
            new_numberOfContents[this.getNumberOfContents()] = item_in_bag;
            this.contents = new_numberOfContents;
            this.numberOfContents++;
            return true;
        }
        return false;
    }


    /**
     * TODO: Create a method called popItem that returns a String.
     *       The string should be the last item added to this Bag
     *       and the item should be removed from this Bag.
     *       Remember to modify numberOfContents accordingly.
     *
     * If there are no items in this Bag, return null.
     *
     * @return
     */
    public String popItem(){
        String last_item = "";
        String[]  new_bag_contents = new String[capacity];

        if(this.numberOfContents > 0) {
            for (int item_index = 0; item_index <= numberOfContents - 1; item_index++) {
                new_bag_contents[item_index] = this.contents[item_index];
            }
            last_item = this.contents[this.getNumberOfContents() - 1];
            numberOfContents--;
            return last_item;
        }
        return null;
    }



    /**
     * Increase this bag's capacity by n.
     *
     * @param n the amount to increase this Bag's capacity by
     */
    public void increaseCapacity(int n) {
        // TODO: Implement this method.
        String [] copy_contents = new String[this.capacity + n];
        for (int content_index = 0; content_index <= this.getNumberOfContents() - 1; content_index++) {
            copy_contents[content_index] = this.contents[content_index];
        }
        this.contents = copy_contents;
        this.capacity = this.capacity + n;
    }

    /**
     * Return the details of this Bag.
     * This method requires you to have created the private
     * instance variables mentioned above.
     *
     * @return
     */
    @Override
    public String toString() {
        return this.color + " Bag (" + this.numberOfContents + " / " +
                this.capacity + ")";
    }

    /*
     * Below we have defined an abstract method.
     * This method takes no arguments and does not return anything.
     * It increases the capacity of this Bag.
     *
     * You will need to implement this method in
     * HandBag.java and CrossbodyBag.java.
     *
     * We recommend you look at HandBag.java first.
     */
    public abstract void enhance();
}