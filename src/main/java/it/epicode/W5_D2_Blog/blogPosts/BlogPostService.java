package it.epicode.W5_D2_Blog.blogPosts;

import it.epicode.W5_D2_Blog.authors.Author;
import it.epicode.W5_D2_Blog.authors.AuthorService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogPostService {

    private final BlogPostRepo blogPostRepo;
    private final AuthorService authorService;

    //metodo per tutti i blogPost con paginazione e ordinamento
    public Page<BlogPost> findAll(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return blogPostRepo.findAll(pageable);
    }

    //altro tipo di paginazione
//    public Page<BlogPost> findAll(Pageable pageable) {
//
//        return blogPostRepo.findAll(pageable);
//    }

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
    public BlogPost createBlogPost(BlogPostDTO blogPostDTO) {
        BlogPost newBlogPost = new BlogPost();
        Author author = authorService.findById(blogPostDTO.getAuthorId());
        BeanUtils.copyProperties(blogPostDTO, newBlogPost);
        newBlogPost.setAuthor(author);
        return blogPostRepo.save(newBlogPost);
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
