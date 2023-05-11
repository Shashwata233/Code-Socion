public class Post {
    private String content;
    private LocalDateTime timestamp;
    private Map<String, Boolean> viewedBy;

    public Post(String content) {
        this.content = content;
        this.timestamp = LocalDateTime.now();
        this.viewedBy = new HashMap<>();
    }

    public void viewPost(String userId) {
        viewedBy.put(userId, true);
    }

    public List<String> getViewers() {
        List<String> viewers = new ArrayList<>();
        for (Map.Entry<String, Boolean> entry : viewedBy.entrySet()) {
            if (entry.getValue()) {
                viewers.add(entry.getKey());
            }
        }
        return viewers;
    }
}
