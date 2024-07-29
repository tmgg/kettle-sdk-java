package io.github.tmgg.kettle.sdk.response;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class SlaveServerJobStatus {

  @JacksonXmlProperty(localName = "jobname")
  private String jobName;
  private String id;


  @JacksonXmlProperty(localName = "status_desc")
  private String statusDescription;


  @JacksonXmlProperty(localName = "error_desc")
  private String errorDescription;


  @JacksonXmlProperty(localName = "logging_string")
  private String loggingString;


  @JacksonXmlProperty(localName = "first_log_line_nr")
  private int firstLoggingLineNr;


  @JacksonXmlProperty(localName = "last_log_line_nr")
  private int lastLoggingLineNr;


  @JacksonXmlProperty(localName = "log_date")
  private Date logDate;




}
