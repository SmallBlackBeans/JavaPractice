//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.3.0 生成的
// 请访问 <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2018.11.13 时间 11:35:38 AM CST 
//


package com.hanxiaocu.ws.webservice.jaxb;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.hanxiaocu.ws.webservice.jaxb package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.hanxiaocu.ws.webservice.jaxb
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AuthorRequest }
     * 
     */
    public AuthorRequest createAuthorRequest() {
        return new AuthorRequest();
    }

    /**
     * Create an instance of {@link AuthorResponse }
     * 
     */
    public AuthorResponse createAuthorResponse() {
        return new AuthorResponse();
    }

    /**
     * Create an instance of {@link Author }
     * 
     */
    public Author createAuthor() {
        return new Author();
    }

    /**
     * Create an instance of {@link AuthorListRequest }
     * 
     */
    public AuthorListRequest createAuthorListRequest() {
        return new AuthorListRequest();
    }

    /**
     * Create an instance of {@link AuthorListResponse }
     * 
     */
    public AuthorListResponse createAuthorListResponse() {
        return new AuthorListResponse();
    }

}
