package com.lms.lms.book;

import com.lms.lms.booknum.BookNum;
import com.lms.lms.category.Category;
import com.lms.lms.customer.Customer;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(length=128, nullable=false, unique=true)
    private String name;
    
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Category category;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Set<Customer> customer = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_number_id")
    private BookNum bookNum;

    public BookNum getBookNum() {
        return bookNum;
    }

    public void setBookNum(BookNum bookNum) {
        this.bookNum = bookNum;
    } 
 
    public Integer getId(){
        return id;
    }
    
    public void setId(Integer id){
        this.id = id;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public Set<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(Set<Customer> customer) {
        this.customer = customer;
    }
    
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
    @Override
    public String toString(){
        return name;
    }
    
}
