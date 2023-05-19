package com.titankids.stock.model.report;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Immutable;

@Data
@Entity
@Immutable
@Table(name = "sales_by_genre")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SalesByGenre {

    @Id
    @Column(name = "id")
    Long id;
    String genre;
    Double sale;

}
