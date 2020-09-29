package com.revise.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "authority")
@Data
public class Authority {

   @Id
   @Column(name = "name", length = 50)
   @NotNull
   private String name;
}
