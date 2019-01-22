package com.elsevier.datamigration.mendeley;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MendeleyCategories {
    @JsonProperty("id")
    private String id;
    @JsonProperty("label")
    private String label;
}
