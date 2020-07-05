package org.apache.struts.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.lang.Nullable;
import org.springframework.util.MultiValueMap;
import org.springframework.util.ObjectUtils;

import java.util.Properties;

@Getter
@Builder
@AllArgsConstructor
public class HttpRequestModel<T> {
    /**
     * The empty {@code HttpEntity}, with no body or headers.
     */
//    public static final HttpRequestModel<?> EMPTY = new HttpRequestModel<>(HttpMethod.HEAD, "UNKNOWN");


    private HttpMethod method;
    private String remoteHost;
    private final HttpHeaders headers;
    private Properties requestParams;
    @Nullable
    private final T body;


//    /**
//     * Create a new, empty {@code HttpEntity}.
//     */
//    protected HttpRequestModel(HttpMethod method, String remoteHost) {
//        this(method, remoteHost, null, null);
//    }
//
//    /**
//     * Create a new {@code HttpEntity} with the given body and no headers.
//     * @param body the entity body
//     */
//    public HttpRequestModel(HttpMethod method, String remoteHost, T body) {
//        this(method, remoteHost, body, null);
//    }
//
//    /**
//     * Create a new {@code HttpEntity} with the given headers and no body.
//     * @param headers the entity headers
//     */
//    public HttpRequestModel(HttpMethod method, String remoteHost, MultiValueMap<String, String> headers) {
//        this(method, remoteHost, null, headers);
//    }
//
//    /**
//     * Create a new {@code HttpEntity} with the given body and headers.
//     * @param body the entity body
//     * @param headers the entity headers
//     */
//    public HttpRequestModel(HttpMethod method, String remoteHost,
//                            @Nullable T body,
//                            @Nullable MultiValueMap<String, String> headers) {
//        this(method, remoteHost, body, headers, null);
//    }
//
//    public HttpRequestModel(
//            HttpMethod method,
//            String remoteHost,
//            @Nullable T body,
//            @Nullable MultiValueMap<String, String> headers,
//            @Nullable Properties requestParams) {
//        this.method = method;
//        this.remoteHost = remoteHost;
//        this.body = body;
//        HttpHeaders tempHeaders = new HttpHeaders();
//        if (headers != null) {
//            tempHeaders.putAll(headers);
//        }
//        this.headers = HttpHeaders.readOnlyHttpHeaders(tempHeaders);
//        this.requestParams = requestParams;
//    }
//
//    public Properties getRequestParams() {
//        return requestParams;
//    }
//
//    public HttpMethod getMethod() {
//        return method;
//    }
//
//    /**
//     * Returns the headers of this entity.
//     */
//    public HttpHeaders getHeaders() {
//        return this.headers;
//    }
//
//    /**
//     * Returns the body of this entity.
//     */
//    @Nullable
//    public T getBody() {
//        return this.body;
//    }
//
//    /**
//     * Indicates whether this entity has a body.
//     */
//    public boolean hasBody() {
//        return (this.body != null);
//    }


    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || other.getClass() != getClass()) {
            return false;
        }
        HttpRequestModel<?> otherEntity = (HttpRequestModel<?>) other;
        return (ObjectUtils.nullSafeEquals(this.headers, otherEntity.headers) &&
                ObjectUtils.nullSafeEquals(this.body, otherEntity.body));
    }

    @Override
    public int hashCode() {
        return (ObjectUtils.nullSafeHashCode(this.headers) * 29 + ObjectUtils.nullSafeHashCode(this.body));
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("<");
        if (this.body != null) {
            builder.append(this.body);
            builder.append(',');
        }
        builder.append(this.headers);
        builder.append('>');
        return builder.toString();
    }
}
