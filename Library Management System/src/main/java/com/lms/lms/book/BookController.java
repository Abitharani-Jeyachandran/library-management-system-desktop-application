package com.lms.lms.book;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {
    @Autowired
    private BookRepository bookRepo;

    @GetMapping("/book/new")
    public String showNewEventForm(Model model){
        model.addAttribute("book", new Book());
        
        return "book_form";
    }
    
    @PostMapping("/book/save")
    public String saveBook(Book book){
        bookRepo.save(book);
        
        return "redirect:/book";
    }
    
    @GetMapping("/book")
    public String listBook(Model model){
        List<Book> listBook = bookRepo.findAll();
        model.addAttribute("listBook", listBook);
        
        return "book";
    }
}
