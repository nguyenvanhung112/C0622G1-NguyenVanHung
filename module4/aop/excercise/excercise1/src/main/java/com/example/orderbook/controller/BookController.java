package com.example.orderbook.controller;

import com.example.orderbook.model.Book;
import com.example.orderbook.model.OrderBook;
import com.example.orderbook.service.IBookService;
import com.example.orderbook.service.IOrderService;
import com.example.orderbook.service.impl.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("book")
public class BookController {

    @Autowired
    private IBookService bookService;

    @Autowired
    private IOrderService orderService;

    @GetMapping("")
    public ModelAndView getList() {
        ModelAndView mv = new ModelAndView("/book/listbook");
        List<Book> books = bookService.findAll();
        mv.addObject("books", books);
        return mv;
    }

    @GetMapping("/create")
    public ModelAndView getAdd() {
        ModelAndView mv = new ModelAndView("/book/create");
        mv.addObject("book", new Book());
        return mv;
    }

    @PostMapping("/create")
    public ModelAndView postAdd(@ModelAttribute Book book) {
        ModelAndView modelAndView = new ModelAndView("/book/create");
        bookService.save(book);
        modelAndView.addObject("book", book);
        modelAndView.addObject("message", "Create new successfully!");
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public ModelAndView view(@PathVariable int id) {
        Book book = bookService.findById(id);
        ModelAndView mv = new ModelAndView("/book/view");
        mv.addObject("book", book);
        return mv;
    }

    @GetMapping("/order/{id}")
    public ModelAndView order(@PathVariable int id) throws Exception {
        ModelAndView mv = new ModelAndView("/book/view");
        Book book = bookService.findById(id);
        if (book.getCount() == 0) {
            throw new Exception();
        }
        book.setCount(book.getCount() - 1);
        bookService.save(book);
        OrderBook orderBook = new OrderBook();
        orderBook.setBook(book);
        orderBook.setCode((int) (Math.random() * 99999));
        orderBook.setDate(new Date(System.currentTimeMillis()));
        orderService.save(orderBook);
        mv.addObject("book", book);
        mv.addObject("message", "Order successfully!");
        return mv;
    }

    @GetMapping("/list-order")
    public ModelAndView oderList() {
        ModelAndView mv = new ModelAndView("/order/listorder");
        List<OrderBook> orderBooks = orderService.findAll();
        mv.addObject("orderBooks", orderBooks);
        return mv;
    }

    @GetMapping("/return/{id}")
    public ModelAndView returnBook(@PathVariable int id) {
        ModelAndView mv = new ModelAndView("/order/return");
        Book book = bookService.findById(id);
        mv.addObject("book", book);
        return mv;
    }

    @PostMapping("/return")
    public ModelAndView returnBookPost(@RequestParam int bookId, String code) throws Exception {
        ModelAndView mv = new ModelAndView("/order/listorder");
        Book book = bookService.findById(bookId);
        OrderBook orderBook = orderService.findCode(code);
        if (orderBook != null) {
            book.setCount(book.getCount() + 1);
            orderService.remove(orderBook);
            mv.addObject("message", "Return success!");
            List<OrderBook> orderBooks = orderService.findAll();
            mv.addObject("orderBooks", orderBooks);
            return mv;
        }
        throw new Exception();
    }

    @ExceptionHandler(Exception.class)
    public String handlerError(Exception e) {
        return "/order/error";
    }
}
