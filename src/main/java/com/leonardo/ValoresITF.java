package com.leonardo;

public interface ValoresITF {
    
    public boolean ins(int v); // Insert a Value of Value v
    public int del(int i);     // Delete a Value on Index i
    public int size();         // Returns the Amount of Stored Values 
    public double mean();      // Returns the Avarage of the Stored Values
    public int greater();      // Returns the Greater Stored Value
    public int lower();        // Returns the Lower Stored Value
}
