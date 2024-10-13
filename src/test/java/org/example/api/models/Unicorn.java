package org.example.api.models;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Unicorn {
    private String name;
    private String colour;
    @SerializedName("_id")
    private String id;
}
