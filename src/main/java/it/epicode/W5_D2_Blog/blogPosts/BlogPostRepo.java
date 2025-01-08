package it.epicode.W5_D2_Blog.blogPosts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogPostRepo extends JpaRepository<BlogPost, Long> {
}
