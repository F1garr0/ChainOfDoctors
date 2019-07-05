package laktest;

import java.util.ArrayList;
import java.util.List;

public abstract class ChainLink {
    ArrayList<ChainLink> next;

    ChainLink()
    {
        next = new ArrayList<>();
    }

    ChainLink getFirst() {return this.next.get(0);}

    List<ChainLink> getAllNext()
    {
        return this.next;
    }

    void addNext(ChainLink nextDoc) {
        this.next.add(nextDoc);
    }

    public abstract String Recognize(String description);
}
