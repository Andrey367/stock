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
@Table(name = "buy_sales_report")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BuySalesReport {

    @Id
    @Column(name = "id")
    Long id;
    Double buy;
    Double sale;
    Integer month;

}
