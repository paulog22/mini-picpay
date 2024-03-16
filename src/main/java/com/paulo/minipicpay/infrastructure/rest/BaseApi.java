package com.paulo.minipicpay.infrastructure.rest;

import com.google.gson.Gson;
import spark.Response;

public abstract class BaseApi {

    protected final Gson serializer;

    protected BaseApi(Gson serializer) {
        this.serializer = serializer;
    }

    protected void error(Exception exception, Response response, int httpStatus, String message) {
        response.status(httpStatus);
        response.body(serializer.toJson(new ApiErrorResponse(httpStatus, message)));
    }

    protected String jsonWith(Object body, Response res) {
        res.type("application/json");
        return serializer.toJson(body);
    }
}
