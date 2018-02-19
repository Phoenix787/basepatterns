package com.example.basepatterns.structural.adapter.adapter_example;

public class Demo {
    public static void main(String[] args) {
        RoundHole hole = new RoundHole(5);
        RoundPeg roundPeg = new RoundPeg(5);

        if (hole.fits(roundPeg)){
            System.out.println("Round peg r5 fits round hole r5");
        }

        SquarePeg smallPeg = new SquarePeg(2);
        SquarePeg largePeg = new SquarePeg(20);

        //hole.fits(smallPeg); - не скомпилируется

        SquarePegAdapter smallAdapter = new SquarePegAdapter(smallPeg);
        SquarePegAdapter largeAdapter = new SquarePegAdapter(largePeg);

        if (hole.fits(smallAdapter)){
            System.out.println("Square peg w2 fits round hole r5");
        }
        if (!hole.fits(largeAdapter)){
            System.out.println("Square peg w20 does not fit round hole r5");
        }
    }
}
