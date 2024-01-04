package Zad_Juni.Zad2;

import Zad50.Component;

import java.util.*;

public class Post {
    String postAuthor;
    String postContent;
    Map<String,Comment> comments;
    public Post(String postAuthor, String postContent) {
        this.postAuthor = postAuthor;
        this.postContent = postContent;
        comments = new TreeMap<>();
    }

    public void addComment(String author, String id, String content, String replyToId) {
        Comment comment = new Comment(author, id, content);
        if(replyToId == null) {
            comments.putIfAbsent(id, comment);
            return;
        }
        for (Map.Entry<String, Comment> entry : comments.entrySet()) {
            Comment.setComment(replyToId, entry.getValue(),comment);
        }
//        this.comments.values().stream()
//                .forEach(comm -> Comment.setComment(replyToId,comm,comment));
    }

    public void likeComment(String commentId) {
        if(comments.containsKey(commentId)) {
            comments.get(commentId).setLikes(1);
            return;
        }
        this.comments.values().stream()
                .forEach(comm -> comm.likeComment(commentId));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Post: %s\nWritten by: %s\nComments:\n",postContent,postAuthor));
        Collection<Comment>comm = comments.values();
        List<Comment> comms = new ArrayList<>();
        for (Comment co:comm) {
            comms.add(co);
        }
        comms.sort(Comparator.comparing(Comment::getLikes).reversed());
        comms.stream().forEach(com ->{
            Comment.createString(sb,com,0);
        });
//        for (Map.Entry<String, Comment> entry : comments.entrySet()) {
//            Comment.createString(sb, entry.getValue(), 0);
//        }
        return sb.toString();
    }
}
