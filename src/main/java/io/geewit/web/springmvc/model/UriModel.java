package io.geewit.web.springmvc.model;

import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Objects;

public class UriModel {
    public UriModel(String path, RequestMethod method) {
        this.path = path;
        this.method = method;
    }

    private String path;

    private RequestMethod method;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public RequestMethod getMethod() {
        return method;
    }

    public void setMethod(RequestMethod method) {
        this.method = method;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UriModel uriModel = (UriModel) o;
        return Objects.equals(path, uriModel.path) &&
                method == uriModel.method;
    }

    @Override
    public int hashCode() {
        return Objects.hash(path, method);
    }
}
