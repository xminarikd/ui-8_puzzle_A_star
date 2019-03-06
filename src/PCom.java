package src;

import java.util.Comparator;

public class PCom implements Comparator<Uzol> {

    @Override
    public int compare(Uzol o1, Uzol o2) {
        return Integer.compare(o1.getHcost() + o1.getLevel(), o2.getHcost() + o2.getLevel());
    }

}
