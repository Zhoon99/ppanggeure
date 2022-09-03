package inha.capstone.ppanggeure.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@ToString
@Builder
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long id;

    private Integer scope;

    private String content;

    @Column(length = 1, nullable = false)
    private Character division;

    @Column(nullable = false)
    private Long writerId;

    @ManyToOne(targetEntity = Bread.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "bread_id")
    private Bread bread;
}
