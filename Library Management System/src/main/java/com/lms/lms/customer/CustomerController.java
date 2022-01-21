package com.lms.lms.customer;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.lms.lms.book.Book;
import com.lms.lms.book.BookRepository;

@Controller
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepo;
    
    @Autowired
    private BookRepository bookRepo;
    
    @GetMapping("/customer/new")
    public String showCreateNewDetailForm(Model model){
        List<Book> listBook = bookRepo.findAll();
        model.addAttribute("listBook", listBook);
        
        model.addAttribute("customer", new Customer());
        
        return "customer_form";
    }
    
    @PostMapping("/customer/save")
    public String saveAttendee(Customer customer){
        customerRepo.save(customer);
        
        return "redirect:/customer";
    }
    
    @GetMapping("/customer")
    public String listAttendeeDetails(Model model){
        List<Customer> listCustomer = customerRepo.findAll();
        model.addAttribute("listCustomer", listCustomer);
        
        return "customer";
    }
}