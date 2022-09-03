package inha.capstone.ppanggeure.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ReviewImg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rimg_id")
    private Long id;

    @Column(nullable = false)
    private String uuid;

    @Column(nullable = false)
    private String imgName;

    @Column(nullable = false)
    private String folderPath;

    @ManyToOne(targetEntity = Review.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id")
    private Review review;
}
