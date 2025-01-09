package it.epicode.W5_D2_Blog.blogPosts;

import it.epicode.W5_D2_Blog.authors.Author;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "blog_posts")
public class BlogPost {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    @Column(name = "tempo_di_lettura")
    private int tempoDiLettura;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

}