package com.dam.jonathan.juegodelaoca;

import android.graphics.drawable.ColorDrawable;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Oca {
    private Random random = new Random();
    private int j = 2;
    private Set<Integer> posiciones;

    // Constructor to initialize posiciones set
    public Oca() {
        posiciones = new HashSet<>();
        int[] initialPosiciones = {5, 9, 14, 18, 23, 27, 30, 34, 39, 41, 45, 50, 54, 59};
        for (int pos : initialPosiciones) {
            posiciones.add(pos);
        }
    }

    public int tirada() {
        return random.nextInt(6) + 1;
    }

    public int nextPlayer() {
        j = (j == 1) ? 2 : 1;
        return j;
    }

    public boolean casellaEspacial(int n) {
        return posiciones.contains(n);
    }
    public boolean guanyador(Integer p1){
        return p1 >= 60;

    }
    public void intercanviarColors(ConstraintLayout M1, ConstraintLayout M2) {
        int colorM1 = ((ColorDrawable) M1.getBackground()).getColor();
        int colorM2 = ((ColorDrawable) M2.getBackground()).getColor();
        M1.setBackgroundColor(colorM2);
        M2.setBackgroundColor(colorM1);
    }


}





