package com.leonardo;

import java.util.ArrayList;
import java.util.Collections;

public class Valores implements ValoresITF {

    private ArrayList<Integer> values;

    public Valores() {
        this.values = new ArrayList<Integer>(10);
    }

    @Override
    public boolean ins(int v) {

        if (v > 0 && values.size() < 10) {
            this.values.add(v);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int del(int i) {

        if (i < values.size()) {
            int oldValue = this.values.get(i);
            this.values.remove(i);
            return oldValue;
        } else {
            return -1;
        }
    }

    @Override
    public int size() {
        return this.values.size();
    }

    @Override
    public double mean() {

        if (this.values.size() > 0) {
            int sum = 0;

            for (int value : this.values) {
                sum = sum + value;
            }

            return (double) sum / this.values.size();
        } else {
            return 0;
        }
    }

    @Override
    public int greater() {

        if (this.values.size() > 0) {
            return Collections.max(this.values);
        } else {
            return -1;
        }
    }

    @Override
    public int lower() {

        if (this.values.size() > 0) {
            return Collections.min(this.values);
        } else {
            return -1;
        }
    }
}
