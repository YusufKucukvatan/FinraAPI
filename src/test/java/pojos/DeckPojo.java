package pojos;

public class DeckPojo {

    /*
    This is a generic Pojo Class.
     */
    private int deckName;
    private int deckId;
    private int cardAmount;
    private boolean hasJoker;

    public DeckPojo() {
    }

    public DeckPojo(int deckName, int cardAmount, boolean hasJoker) {
        this.deckName = deckName;
        this.cardAmount = cardAmount;
        this.hasJoker = hasJoker;
    }

    public int getDeckName() {
        return deckName;
    }

    public void setDeckName(int deckName) {
        this.deckName = deckName;
    }

    public int getDeckId() {
        return deckId;
    }

    public int getCardAmount() {
        return cardAmount;
    }

    public void setCardAmount(int cardAmount) {
        this.cardAmount = cardAmount;
    }

    public boolean isHasJoker() {
        return hasJoker;
    }

    public void setHasJoker(boolean hasJoker) {
        this.hasJoker = hasJoker;
    }

    @Override
    public String toString() {
        return "DeckPojo{" +
                "deckName=" + deckName +
                ", deckId=" + deckId +
                ", cardAmount=" + cardAmount +
                ", hasJoker=" + hasJoker +
                '}';
    }
}