package com.lms.lms.booknum;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.lms.lms.book.Book;
import com.lms.lms.book.BookRepository;

@Controller
public class BookNumController {
    @Autowired
    private BookNumRepository bookNumRepo;
    
    @Autowired
    private BookRepository eventRepo;
    
    @GetMapping("/bookNum/new")
    public String showCreateNewDetailForm(Model model){
        List<Book> listEvents = eventRepo.findAll();
        model.addAttribute("listEvents", listEvents);
        
        model.addAttribute("bookNum", new BookNum());
        
        return "book_form";
    }
    
    @PostMapping("/bookNum/save")
    public String saveBookNum(BookNum bookNum){
        bookNumRepo.save(bookNum);
        
        return "redirect:/bookNum";
    }
    
    @GetMapping("/bookNum")
    public String listBookNum(Model model){
        List<BookNum> listBookNum = bookNumRepo.findAll();
        model.addAttribute("listBookNum", listBookNum);
        
        return "bookNum";
    }
}
