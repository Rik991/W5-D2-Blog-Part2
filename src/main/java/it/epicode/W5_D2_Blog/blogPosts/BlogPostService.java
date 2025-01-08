package it.epicode.W5_D2_Blog.blogPosts;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogPostService {

    private final BlogPostRepo blogPostRepo;

    //metodo per tutti i blogPost
    public List<BlogPost> findAll() {
        return blogPostRepo.findAll();
    }

    //metodo per un singolo blogPost
    public BlogPost findById(Long id) {
        if(!blogPostRepo.existsById(id)){
            throw new EntityNotFoundException("BlogPost non trovato");
        } else {
            return blogPostRepo.findById(id).get();
        }
    }

    //metodo per creare un blogPost
    public BlogPost createBlogPost(BlogPost blogPost) {
        return blogPostRepo.save(blogPost);
    }

    //metodo per modificare un blogPost
    public BlogPost updateBlogPost(Long id, BlogPost blogPostModificato) {
      BlogPost postModificato = findById(id);
      BeanUtils.copyProperties(blogPostModificato, postModificato);
        return blogPostRepo.save(postModificato);
    }

    //metodo per eliminare un blogPost
    public void deleteBlogPost(Long id) {
        blogPostRepo.deleteById(id);
    }





}
