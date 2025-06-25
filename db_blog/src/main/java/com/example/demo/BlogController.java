package com.example.demo;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BlogController {
    @GetMapping("/api/blogs")
    public List<Blog> getBlogs() {
        return List.of(
            new Blog(1, "タイトル1", "2025-05-01", "/images/blog1.png", "/tech-blog/article/1","タイトル"),
            new Blog(1, "こなブログ", "2025-05-01", "/images/blog1.png", "/tech-blog/article/1","こなブログタグ"),
            new Blog(1, "ふぉー", "2025-05-01", "/images/blog1.png", "/tech-blog/article/1","ふぉー"),
            new Blog(1, "やったーぁ", "2025-05-01", "/images/blog1.png", "/tech-blog/article/1","やったぁー"),
            new Blog(2, "タイトル2", "2025-05-02", "/images/blog2.png", "/tech-blog/article/2","タイトル")
        );
    }
    @GetMapping("/images/{filename}")
    public ResponseEntity<Resource> getImage(@PathVariable String filename) {
        Path path = Paths.get("images/" + filename); 
        Resource resource = new FileSystemResource(path);

        return ResponseEntity.ok()
            .contentType(MediaType.IMAGE_PNG)
            .body(resource);
    }
}




class Blog {
    public int id;
    public String title;
    public String date;
    public String image;
    public String url;
    public String tag;

    public Blog(int id, String title, String date, String image, String url,String tag) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.image = image;
        this.url = url;
        this.url = tag;
    }
}
