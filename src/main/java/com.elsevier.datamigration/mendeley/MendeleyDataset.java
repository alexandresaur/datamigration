package com.elsevier.datamigration.mendeley;

import com.elsevier.datamigration.mendeley.articles.MendeleyArticle;
import com.elsevier.datamigration.mendeley.files.MendeleyFiles;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MendeleyDataset {

    @JsonProperty("id")
    private String id;

    @JsonProperty("doi")
    private MendeleyDoi doi;

    @JsonProperty("data_licence")
    private DataLicence licence;

    @JsonProperty("contributors")
    private List<MendeleyContributors> contributors = new ArrayList<>();

    @JsonProperty("versions")
    private List<MendeleyVersions> versions = new ArrayList<>();

    @JsonProperty("files")
    private List<MendeleyFiles> files = new ArrayList<>();

    @JsonProperty("articles")
    private List<MendeleyArticle> articles = new ArrayList<>();

    @JsonProperty("categories")
    private List<MendeleyCategories> categories = new ArrayList<>();

    @JsonProperty("metrics")
    private MendeleyOverallMetrics overallMetrics = new MendeleyOverallMetrics();

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("version")
    private int version;

    @JsonProperty("publish_date")
    private String publishDate;

    @JsonProperty("available")
    private boolean isAvailable;
}