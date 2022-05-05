package com.intesasanpaolo.bear.tit0.engine.utils;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Collections;
import java.util.List;

@Getter
@Setter
public class RestPageImpl<T> extends PageImpl<T> {

  @JsonCreator
  public RestPageImpl(
      @JsonProperty("content") List<T> content,
      @JsonProperty("pageable") PageableModel pageable,
      @JsonProperty("total") Long total) {
    super(content, PageRequest.of(pageable.getPage(), pageable.getSize()), total);
  }

  public RestPageImpl(List<T> content, Pageable pageable, long total) {
    super(content, pageable, total);
  }

  public RestPageImpl(List<T> content) {
    super(content);
  }

  public RestPageImpl() {
    super(Collections.emptyList());
  }
}
