import java.util.HashMap;

public class EmojiReactions {
    private HashMap<String, Integer> emojiMap;

    public EmojiReactions() {
        emojiMap = new HashMap<>();
        emojiMap.put("❤️", 0);
        emojiMap.put("👍", 0);
        emojiMap.put("😂", 0);
        emojiMap.put("😢", 0);
    }

    public void addReaction(String emoji) {
        if (emojiMap.containsKey(emoji)) {
            int count = emojiMap.get(emoji);
            emojiMap.put(emoji, count + 1);
        } else {
            System.out.println("Invalid emoji!");
        }
    }

    public void removeReaction(String emoji) {
        if (emojiMap.containsKey(emoji)) {
            int count = emojiMap.get(emoji);
            if (count > 0) {
                emojiMap.put(emoji, count - 1);
            } else {
                System.out.println("This reaction has not been added yet!");
            }
        } else {
            System.out.println("Invalid emoji!");
        }
    }

    public void printReactions() {
        for (String emoji : emojiMap.keySet()) {
            System.out.println(emoji + ": " + emojiMap.get(emoji));
        }
    }

    public static void main(String[] args) {
        EmojiReactions reactions = new EmojiReactions();
        reactions.addReaction("❤️");
        reactions.addReaction("👍");
        reactions.addReaction("😂");
        reactions.addReaction("❤️");
        reactions.addReaction("😂");
        reactions.addReaction("😢");
        reactions.printReactions();
        reactions.removeReaction("❤️");
        reactions.removeReaction("❤️");
        reactions.printReactions();
    }
}
