package com.elsevier.datamigration.mendeley;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MendeleyContributors {
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("profile_id")
    private String profileId;
}
