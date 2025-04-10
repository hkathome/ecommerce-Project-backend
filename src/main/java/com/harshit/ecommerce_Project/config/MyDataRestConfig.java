package com.harshit.ecommerce_Project.config;

import com.harshit.ecommerce_Project.entity.Product;
import com.harshit.ecommerce_Project.entity.ProductCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
    public class MyDataRestConfig implements RepositoryRestConfigurer {
        @Override
        public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors){
            HttpMethod[] theUnsupportedActions= {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};
            config.getExposureConfiguration()
                    .forDomainType(Product.class) //Apply to Repo for : Class Name (for which you want to disable the endpoints)
                    .withItemExposure((metadata,httpMethods) -> httpMethods.disable(theUnsupportedActions))
                    .withCollectionExposure((metadata,httpMethods) ->httpMethods.disable(theUnsupportedActions));

            config.getExposureConfiguration()
                    .forDomainType(ProductCategory.class) //Apply to Repo for : Class Name (for which you want to disable the endpoints)
                    .withItemExposure((metadata,httpMethods) -> httpMethods.disable(theUnsupportedActions))
                    .withCollectionExposure((metadata,httpMethods) ->httpMethods.disable(theUnsupportedActions));
        }
    }

