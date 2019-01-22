package com.elsevier.datamigration.figshare;


import java.util.List;
import java.util.Map;

public class FigshareCollection {

  private String title;
  private String description;
  private List<Long> articles;
  private List<FigshareAuthor> authors;
  private List<Long> categories;
  private List<String> tags;
  private List<String> keywords;
  private List<String> references;
  private Map<String, Object> customFields;
  private String doi;
  private String resourceId;
  private String resourceLink;
  private String resourceDoi;
  private String resourceTitle;
  private Integer resourceVersion;
  private Long groupId;


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<Long> getArticles() {
    return articles;
  }

  public void setArticles(List<Long> articles) {
    this.articles = articles;
  }

  public List<FigshareAuthor> getAuthors() {
    return authors;
  }

  public void setAuthors(List<FigshareAuthor> authors) {
    this.authors = authors;
  }

  public List<Long> getCategories() {
    return categories;
  }

  public void setCategories(List<Long> categories) {
    this.categories = categories;
  }

  public List<String> getTags() {
    return tags;
  }

  public void setTags(List<String> tags) {
    this.tags = tags;
  }

  public List<String> getKeywords() {
    return keywords;
  }

  public void setKeywords(List<String> keywords) {
    this.keywords = keywords;
  }

  public List<String> getReferences() {
    return references;
  }

  public void setReferences(List<String> references) {
    this.references = references;
  }

  public Map<String, Object> getCustomFields() {
    return customFields;
  }

  public void setCustomFields(Map<String, Object> customFields) {
    this.customFields = customFields;
  }

  public String getDoi() {
    return doi;
  }

  public void setDoi(String doi) {
    this.doi = doi;
  }

  public String getResourceId() {
    return resourceId;
  }

  public void setResourceId(String resourceId) {
    this.resourceId = resourceId;
  }

  public String getResourceLink() {
    return resourceLink;
  }

  public void setResourceLink(String resourceLink) {
    this.resourceLink = resourceLink;
  }

  public String getResourceDoi() {
    return resourceDoi;
  }

  public void setResourceDoi(String resourceDoi) {
    this.resourceDoi = resourceDoi;
  }

  public String getResourceTitle() {
    return resourceTitle;
  }

  public void setResourceTitle(String resourceTitle) {
    this.resourceTitle = resourceTitle;
  }

  public Integer getResourceVersion() {
    return resourceVersion;
  }

  public void setResourceVersion(Integer resourceVersion) {
    this.resourceVersion = resourceVersion;
  }

  public Long getGroupId() {
    return groupId;
  }

  public void setGroupId(Long groupId) {
    this.groupId = groupId;
  }

}