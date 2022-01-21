package com.lms.lms.category;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.lms.lms.book.Book;
import com.lms.lms.book.BookRepository;

@Controller
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepo;
    
    @Autowired
    private BookRepository bookRepo;
    
    @GetMapping("/categories/new")
    public String showCreateNewCategoryForm(Model model){
        List<Book> listBook = bookRepo.findAll();
        model.addAttribute("listBook", listBook);
        
        model.addAttribute("category", new Category());
        
        return "category_form";
    }
    
    @PostMapping("/categories/save")
    public String saveCategory(Category category){
        categoryRepo.save(category);
        
        return "redirect:/categories";
    }
    
    @GetMapping("/categories")
    public String listCategories(Model model){
        List<Category> listCategories = categoryRepo.findAll();
        model.addAttribute("listCategories", listCategories);
        
        return "categories";
    }
}
