package lyj.controller;

import lyj.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by 陆英杰
 * 2018/9/15 12:39
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;
}
