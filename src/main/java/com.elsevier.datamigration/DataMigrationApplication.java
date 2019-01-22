package com.elsevier.datamigration;


import com.elsevier.datasearch.core.PipelineConfig;
import com.elsevier.datasearch.dao.S3Dao;
import com.elsevier.datasearch.dao.SolrDAO;
import com.elsevier.datasearch.datatypes.ApplicationName;
import com.elsevier.datasearch.datatypes.EnvironmentType;
import com.elsevier.datasearch.service.IRepositoryClassificationService;
import com.elsevier.datasearch.service.impl.RepositoryClassificationService;
import com.elsevier.datasearch.service.impl.S3ConfigManagementService;
import com.elsevier.datasearch.utils.SourceUtils;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.util.UriComponentsBuilder;
import springfox.documentation.spring.web.paths.AbstractPathProvider;
import springfox.documentation.spring.web.paths.Paths;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.IOException;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableSwagger2
@PropertySource({"classpath:swagger.properties"})
public class DataMigrationApplication implements WebMvcConfigurer {

    @Value("#{'${datasearch.webapp}'}")
    public String DATASEARCH_WEBAPP;


    public static void main(String[] args) {
        SpringApplication.run(DataMigrationApplication.class, args);
    }

    @Bean
    public S3Dao s3Dao(@Value("#{'${s3.preview.bucketName}'}") String bucketName) {
        PipelineConfig pipelineConfig = new PipelineConfig();
        pipelineConfig.getConnectionProperties().put("bucketName", bucketName);
        return new S3Dao(pipelineConfig);
    }

    @Bean
    public SolrDAO solrDAO(@Value("#{'${solr.zookeepers}'}") String zookeeperList,
                           @Value("#{'${solr.containerMetadataCollection}'}") String containerCollectionName,
                           @Value("#{'${solr.assetMetadataCollection}'}") String assetCollectionName,
                           @Value("#{'${solr.queryBoostConfigurationCollection}'}") String queryBoostConfigurationCollectionName,
                           @Value("#{'${solr.typeAheadCollectionName}'}") String typeAheadCollectionName) {
        PipelineConfig pipelineConfig = new PipelineConfig();
        pipelineConfig.getConnectionProperties().put("zkQuorum", zookeeperList);
        pipelineConfig.getConnectionProperties().put("containerCollectionName",
            containerCollectionName);
        pipelineConfig.getConnectionProperties().put("assetCollectionName", assetCollectionName);
        pipelineConfig.getConnectionProperties().put("queryBoostConfigurationCollectionName",
            queryBoostConfigurationCollectionName);
        pipelineConfig.getConnectionProperties().put("typeAheadCollectionName",
            typeAheadCollectionName);
        return new SolrDAO(pipelineConfig);
    }

    @Bean
    public EnvironmentType environmentType(@Value("#{'${s3.environmentType}'}") String environmentType) {
        SourceUtils.setEnvironment(EnvironmentType.valueOf(environmentType));
        return EnvironmentType.valueOf(environmentType);
    }

    @Bean
    public ApplicationName assetType(@Value("#{'${s3.applicationName}'}") String applicationName) {
        return ApplicationName.valueOf(applicationName);
    }

    @Bean
    public S3ConfigManagementService s3ConfigManagementService(@Value("#{'${s3.configurations.bucketName}'}") String bucketName) {
        return new S3ConfigManagementService(bucketName);
    }

    @Bean
    public IRepositoryClassificationService repositoryClassificationService() {
        return new RepositoryClassificationService();
    }

    @Bean
    public FreeMarkerConfigurer customDirectives(ApplicationContext context) throws IOException, TemplateException {
        FreeMarkerConfigurer result = new FreeMarkerConfigurer();
        result.setTemplateLoaderPath("classpath:/templates");
        result.afterPropertiesSet();
        context.getBeansOfType(TemplateDirectiveModel.class).forEach(result.getConfiguration()::setSharedVariable);
        return result;
    }

    private class BaseVersionProvider extends AbstractPathProvider {

        public static final String ROOT = "/api/v1";

        public BaseVersionProvider() {
            super();
        }

        @Override
        protected String applicationPath() {
            return ROOT;
        }

        @Override
        protected String getDocumentationPath() {
            return "/";
        }

        @Override
        public String getApplicationBasePath() {
            return ROOT;
        }

        @Override
        public String getOperationPath(String operationPath) {
            UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromPath("/");
            return Paths.removeAdjacentForwardSlashes(
                uriComponentsBuilder.path(operationPath.replaceAll(ROOT, "")).build().toString());
        }
    }

}

