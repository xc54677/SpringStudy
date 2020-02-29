package springDemo.config;

import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

public class MyFilter implements TypeFilter {
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        /**
         * 扫描器扫描包路径下(value="springDemo")的所有类，getClassName()可以获取到该包路径下所有的
         * 表有 @Service，@Repository，@Controller 对应类的类名
         */
        String className = classMetadata.getClassName();
        if (className.contains("School")){
            return true;
        }
        return false;
    }
}
