package org.example;

import com.google.auto.service.AutoService;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import java.io.IOException;
import java.util.Set;

@AutoService(Processor.class)
@SupportedAnnotationTypes("org.example.SameAs")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class SameAsProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        System.out.println("@@@@@@@@@@@@@@@@ Process method running @@@@@@@@@@@@@@@@");
        System.out.println(set.size());

        Elements elementUtils = processingEnv.getElementUtils();

        for (Element element : roundEnvironment.getElementsAnnotatedWith(SameAs.class)) {
            if (element instanceof TypeElement) {
                TypeElement typeElement = (TypeElement) element;
                SameAs sameAsAnnotation = typeElement.getAnnotation(SameAs.class);
                TypeElement targetElement = elementUtils.getTypeElement(SameAs.class.getCanonicalName());

                if (targetElement != null) {
                    String className = String.valueOf(typeElement.getSimpleName());
                    System.out.println(className);

                    Class<?> sourceClass = sameAsAnnotation.clazz();
                }



                TypeElement targetClass = (TypeElement) element;
                System.out.println(targetClass.getSimpleName());
//            SameAs annotation = element.getAnnotation(SameAs.class);
//xd
//            // Get the source class from the annotation
//            Class<?> sourceClass = annotation.clazz();
//            System.out.println(sourceClass.getName());
            }

        }


        return false;
    }
}
