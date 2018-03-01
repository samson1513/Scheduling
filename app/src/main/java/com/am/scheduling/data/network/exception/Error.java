package com.am.scheduling.data.network.exception;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

/**
 * Created by Alex Michenko
 * on 07.02.2018.
 */

@JsonObject(fieldDetectionPolicy = JsonObject.FieldDetectionPolicy.NONPRIVATE_FIELDS_AND_ACCESSORS)
public class Error {

    @JsonField
    public String code;
    @JsonField
    public String message;
}
