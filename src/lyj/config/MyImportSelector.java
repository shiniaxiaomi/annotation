package lyj.config;

import lyj.dao.BookDao;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Created by 陆英杰
 * 2018/9/15 15:15
 */

//自定义逻辑返回需要导入的组件
public class MyImportSelector implements ImportSelector {

    //返回值就是导入到容器中的组件的全类名
    //annotationMetadata : 当前标注@Import注解的类的所有注解信息
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        //可以自定义逻辑
//        annotationMetadata.get
        return new String[]{BookDao.class.getName()};
    }
}
