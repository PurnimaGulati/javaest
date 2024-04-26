import java.util.HashSet;
import java.util.Iterator;

public class Exp5 {
    interface Card{
        HashSet<String> set = new HashSet<>();
        void returnUniqueElements(String[] cards);
    }
    static class ImplimentsCards implements Card{

        @Override
        public void returnUniqueElements(String[] cards) {
            for (int i = 0 ;i < cards.length;i++){
                set.add(cards[i]);
            }
            Iterator<String> it = set.iterator();
            while(it.hasNext()){
                System.out.println(it.next());
            }
        }
    }

    public static void main(String[] args) {
        String[] card = {"heart","Spades","Club","Club","heart"};
        ImplimentsCards cards = new ImplimentsCards();
        cards.returnUniqueElements(card);
    }
}
