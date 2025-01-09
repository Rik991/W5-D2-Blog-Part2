package it.epicode.W5_D2_Blog.blogPosts;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blogPosts")
// risponde a chiamate sull'endpoint http://localhost:8080/api/blogPosts
public class BlogPostController {
    @Autowired
    private BlogPostService blogPostService;

    // qui vanno definite le chiamate che si possono fare sull'endpoint


    //chiamata get per la findAll all'endpoint http://localhost:8080/api/blogPosts con paginazione
    //ho quindi commentato la findAll senza paginazione
    @GetMapping
    public ResponseEntity<Page<BlogPost>> getAllBlogPosts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy) {
         return ResponseEntity.ok(blogPostService.findAll(page, size, sortBy));
    }

    //altro tipo di paginazione
//    @GetMapping("/paged")
//    public ResponseEntity<Page<BlogPost>> getAllBlogPosts(Pageable page) {
//        return ResponseEntity.ok(blogPostService.findAll(page));
//    }

    //chiamata get per la findAll all'endpoint http://localhost:8080/api/blogPosts
//    @GetMapping
//    public ResponseEntity<List<BlogPost>> listAllBlogPosts(){
//        return ResponseEntity.ok(blogPostService.findAll());
//    }

    //chiamata get per la findById all'endpoint http://localhost:8080/api/blogPosts/{id}
    @GetMapping("/{id}")
    public ResponseEntity<BlogPost> findById(@PathVariable Long id){
        return ResponseEntity.ok(blogPostService.findById(id));
    }

    //chiamata per creare un nuovo blogPost (POST) all'endpoint http://localhost:8080/api/blogPosts
    @PostMapping
    public ResponseEntity<BlogPost> createBlogPost(@RequestBody BlogPostDTO request){
        return new ResponseEntity<>(blogPostService.createBlogPost(request), HttpStatus.CREATED);
    }

    //chiamata per modificare un blogPost (PUT) all'endpoint http://localhost:8080/api/blogPosts/{id}
    @PutMapping("/{id}")
    public ResponseEntity<BlogPost> updateBlogPost(@PathVariable Long id, @RequestBody BlogPost request){
        return ResponseEntity.ok(blogPostService.updateBlogPost(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlogPost(@PathVariable Long id){
        blogPostService.deleteBlogPost(id);
        return ResponseEntity.noContent().build();//ritorna 204
    }



}







