package lyj.service;

import lyj.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by 陆英杰
 * 2018/9/15 12:40
 */

@Service
public class BookService {

    //明确指定通过id去容器中查找bean
    @Qualifier("bookDao")
    //设置required = false则表示这个成员变量不是必须要装配,如果容器中找不到bean,就可以为null
    @Autowired(required = false)
    private BookDao bookDao;

    @Override
    public String toString() {
        return "BookService{" +
                "bookDao=" + bookDao +
                '}';
    }

    public BookDao getBookDao() {
        return bookDao;
    }

}
