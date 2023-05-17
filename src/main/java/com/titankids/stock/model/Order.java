package com.titankids.stock.model;

        import jakarta.persistence.*;
        import lombok.AllArgsConstructor;
        import lombok.Data;
        import lombok.NoArgsConstructor;
        import org.hibernate.annotations.GenericGenerator;

        import java.time.LocalDateTime;
        import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order", schema = "game_shop" )
public class Order {

    @GenericGenerator(
            name = "order_generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "order_id_seq"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "optimizer", value = "hilo")
            }
    )
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_generator")
    @Column(name = "id")
    private Long id;

    @Column(name="created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne
    private Client client;

    @ManyToOne
    private Game game;

    private String comment;

    @ManyToOne
    @JoinColumn(name = "order_status_id")
    private OrderStatus status;

    @ManyToOne
    @JoinColumn(name = "order_type_id")
    private OrderType type;

    private Double price;

    private int amount = 1;
}