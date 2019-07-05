package laktest;

public class Registry extends ChainLink {

    @Override
    public String Recognize(String complaint)
    {
       return this.getFirst().Recognize(complaint);
    }
}
