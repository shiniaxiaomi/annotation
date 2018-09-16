package lyj.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * Created by 陆英杰
 * 2018/9/15 13:23
 */

/**
 * DESC: 设置自定义的包扫描的Filter过滤规则
 */
public class MyTypeFilter implements TypeFilter {
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {

        //获取当前类注解的信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();

        //获取当前正在扫描的类的类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        String className = classMetadata.getClassName();//获取类名
        System.out.println("扫描过的类名====>"+className+":"+classMetadata.hashCode());

        //获取当前类资源(类所在的路径)
        Resource resource = metadataReader.getResource();

        //可以在这里设置过滤规则(返回true则表示匹配成功,符合条件)
        if(className.contains("Book")){
            return true;
        }

        return false;
    }
}
