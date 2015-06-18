/**
 * Date: Jun 17, 2015
 * @author sgall
 */
package com.example.entity;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
  /**
   * @author Steven Gall
   */
  @EntityListeners({AuditingEntityListener.class})
  @MappedSuperclass
  public abstract class AbstractEntity {

    /**
     * The class logger.
     */
    private static final Logger LOG = LogManager.getLogger(AbstractEntity.class);

    /**
     * The entity id.
     */
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    @NotNull
    private long id;

    /**
     * The date the entity was created.
     */
    @CreatedDate
    @Column(name = "created_date", updatable = false)
    private Calendar createdDate;

    /**
     * The last time the entity was modified.
     */
    @LastModifiedDate
    @Column(name = "modified_date")
    private Calendar modifiedDate;

    /**
     * @return the createdDate
     */
    public Calendar getCreatedDate() {
      return createdDate;
    }

    /**
     * @return the id
     */
    public long getId() {
      return id;
    }

    /**
     * @return the modifiedDate
     */
    public Calendar getModifiedDate() {
      return modifiedDate;
    }

    /**
     * @param createdDate the createdDate to set
     */
    public void setCreatedDate(Calendar createdDate) {
      this.createdDate = createdDate;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
      this.id = id;
    }

    /**
     * @param modifiedDate the modifiedDate to set
     */
    public void setModifiedDate(Calendar modifiedDate) {
      this.modifiedDate = modifiedDate;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    public String toString() {
      return ReflectionToStringBuilder.toString(this);
    }
  }
