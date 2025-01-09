package it.epicode.W5_D2_Blog.blogPosts;


import jakarta.persistence.Column;
import lombok.Data;

@Data
public class BlogPostDTO {


    private String titolo;

    private String contenuto;

    private int tempoDiLettura;

    private Long authorId;


}
