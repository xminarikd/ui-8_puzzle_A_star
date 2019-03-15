package src;

import java.util.Comparator;

/**
 * Trieda, ktora sluzi na porovnavanie uzlov v prioritnom rade
 */
public class PCom implements Comparator<Uzol> {

    @Override
    public int compare(Uzol o1, Uzol o2) {

        if((o1.getHcost() + o1.getLevel()) > (o2.getHcost() + o2.getLevel()))
            return 1;
        else if((o1.getHcost() + o1.getLevel()) < (o2.getHcost() + o2.getLevel()))
            return -1;
        else return 0;


        //return Integer.compare((o1.getHcost() + o1.getLevel()), (o2.getHcost() + o2.getLevel()));

    }

}
