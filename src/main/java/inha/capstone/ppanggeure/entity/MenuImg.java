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
public class MenuImg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mimg_id")
    private Long id;

    @Column(nullable = false)
    private String uuid;

    @Column(nullable = false)
    private String imgName;

    @Column(nullable = false)
    private String folderPath;

    @ManyToOne(targetEntity = Bread.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "bread_id")
    private Bread bread;
}
