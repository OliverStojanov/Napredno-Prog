package Zad_Juni.Zad2;

import java.util.ArrayList;
import java.util.List;

public class Comment {
    String author;
    String id;
    String content;
    int likes = 0;
    List<Comment> comments;
  //  String replyToId;

    public Comment(String author, String id, String content) {
        this.author = author;
        this.id = id;
        this.content = content;
        comments = new ArrayList<>();
    }

    public void setLikes(int likes) {
        this.likes += likes;
    }

    public int getLikes() {
        int sum = likes;
        for (Comment comment: comments) {
            sum+=comment.likes + comment.getLikes();
        }
        return sum;
    }
    public void likeComment(String id){
        for (Comment comment:comments) {
            if(comment.id.equals(id)){
                comment.setLikes(1);
            }else{
                likeComment(id);
            }
        }
    }
    public static void setComment(String id,Comment comms, Comment comm){
        for (Comment comment:comms.comments) {
            if(comment.id.equals(id)){
                comment.comments.add(comm);
            }else{
                setComment(id,comment,comm);
            }
        }

    }

    public static void createString(StringBuilder sb,Comment com,int lvl){
        for(int i=0; i<lvl; i++){
            sb.append("    ");
        }
        sb.append(String.format("        Comment: %s\n        Written by: %s\n        Likes: %d\n",com.content,com.author,com.likes));
        for(Comment comment: com.comments){
            Comment.createString(sb,comment,lvl+1);
        }
    }

    @Override
    public String toString(){
        return String.format("        Comment: %s\n        Written by: %s\n        Likes: %d\n",content,author,likes);
    }
}
